package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;

public class DualTreeBidiMap extends AbstractDualBidiMap implements SortedBidiMap, Serializable {
   private static final long serialVersionUID = 721969328361809L;
   private final Comparator comparator;
   private final Comparator valueComparator;

   public DualTreeBidiMap() {
      super(new TreeMap(), new TreeMap());
      this.comparator = null;
      this.valueComparator = null;
   }

   public DualTreeBidiMap(Map map) {
      super(new TreeMap(), new TreeMap());
      this.putAll(map);
      this.comparator = null;
      this.valueComparator = null;
   }

   public DualTreeBidiMap(Comparator keyComparator, Comparator valueComparator) {
      super(new TreeMap(keyComparator), new TreeMap(valueComparator));
      this.comparator = keyComparator;
      this.valueComparator = valueComparator;
   }

   protected DualTreeBidiMap(Map normalMap, Map reverseMap, BidiMap inverseBidiMap) {
      super(normalMap, reverseMap, inverseBidiMap);
      this.comparator = ((SortedMap)normalMap).comparator();
      this.valueComparator = ((SortedMap)reverseMap).comparator();
   }

   protected DualTreeBidiMap createBidiMap(Map normalMap, Map reverseMap, BidiMap inverseMap) {
      return new DualTreeBidiMap(normalMap, reverseMap, inverseMap);
   }

   public Comparator comparator() {
      return ((SortedMap)this.normalMap).comparator();
   }

   public Comparator valueComparator() {
      return ((SortedMap)this.reverseMap).comparator();
   }

   public Object firstKey() {
      return ((SortedMap)this.normalMap).firstKey();
   }

   public Object lastKey() {
      return ((SortedMap)this.normalMap).lastKey();
   }

   public Object nextKey(Object key) {
      if (this.isEmpty()) {
         return null;
      } else if (this.normalMap instanceof OrderedMap) {
         return ((OrderedMap)this.normalMap).nextKey(key);
      } else {
         SortedMap sm = (SortedMap)this.normalMap;
         Iterator it = sm.tailMap(key).keySet().iterator();
         it.next();
         return it.hasNext() ? it.next() : null;
      }
   }

   public Object previousKey(Object key) {
      if (this.isEmpty()) {
         return null;
      } else if (this.normalMap instanceof OrderedMap) {
         return ((OrderedMap)this.normalMap).previousKey(key);
      } else {
         SortedMap sm = (SortedMap)this.normalMap;
         SortedMap hm = sm.headMap(key);
         return hm.isEmpty() ? null : hm.lastKey();
      }
   }

   public OrderedMapIterator mapIterator() {
      return new DualTreeBidiMap.BidiOrderedMapIterator(this);
   }

   public SortedBidiMap inverseSortedBidiMap() {
      return this.inverseBidiMap();
   }

   public OrderedBidiMap inverseOrderedBidiMap() {
      return this.inverseBidiMap();
   }

   public SortedMap headMap(Object toKey) {
      SortedMap sub = ((SortedMap)this.normalMap).headMap(toKey);
      return new DualTreeBidiMap.ViewMap(this, sub);
   }

   public SortedMap tailMap(Object fromKey) {
      SortedMap sub = ((SortedMap)this.normalMap).tailMap(fromKey);
      return new DualTreeBidiMap.ViewMap(this, sub);
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      SortedMap sub = ((SortedMap)this.normalMap).subMap(fromKey, toKey);
      return new DualTreeBidiMap.ViewMap(this, sub);
   }

   public SortedBidiMap inverseBidiMap() {
      return (SortedBidiMap)super.inverseBidiMap();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.normalMap);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.normalMap = new TreeMap(this.comparator);
      this.reverseMap = new TreeMap(this.valueComparator);
      Map map = (Map)in.readObject();
      this.putAll(map);
   }

   protected static class BidiOrderedMapIterator implements OrderedMapIterator, ResettableIterator {
      private final AbstractDualBidiMap parent;
      private ListIterator iterator;
      private Entry last = null;

      protected BidiOrderedMapIterator(AbstractDualBidiMap parent) {
         this.parent = parent;
         this.iterator = (new ArrayList(parent.entrySet())).listIterator();
      }

      public boolean hasNext() {
         return this.iterator.hasNext();
      }

      public Object next() {
         this.last = (Entry)this.iterator.next();
         return this.last.getKey();
      }

      public boolean hasPrevious() {
         return this.iterator.hasPrevious();
      }

      public Object previous() {
         this.last = (Entry)this.iterator.previous();
         return this.last.getKey();
      }

      public void remove() {
         this.iterator.remove();
         this.parent.remove(this.last.getKey());
         this.last = null;
      }

      public Object getKey() {
         if (this.last == null) {
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
         } else {
            return this.last.getKey();
         }
      }

      public Object getValue() {
         if (this.last == null) {
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
         } else {
            return this.last.getValue();
         }
      }

      public Object setValue(Object value) {
         if (this.last == null) {
            throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
         } else if (this.parent.reverseMap.containsKey(value) && this.parent.reverseMap.get(value) != this.last.getKey()) {
            throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
         } else {
            Object oldValue = this.parent.put(this.last.getKey(), value);
            this.last.setValue(value);
            return oldValue;
         }
      }

      public void reset() {
         this.iterator = (new ArrayList(this.parent.entrySet())).listIterator();
         this.last = null;
      }

      public String toString() {
         return this.last != null ? "MapIterator[" + this.getKey() + "=" + this.getValue() + "]" : "MapIterator[]";
      }
   }

   protected static class ViewMap extends AbstractSortedMapDecorator {
      protected ViewMap(DualTreeBidiMap bidi, SortedMap sm) {
         super(new DualTreeBidiMap(sm, bidi.reverseMap, bidi.inverseBidiMap));
      }

      public boolean containsValue(Object value) {
         return this.decorated().normalMap.containsValue(value);
      }

      public void clear() {
         Iterator it = this.keySet().iterator();

         while(it.hasNext()) {
            it.next();
            it.remove();
         }

      }

      public SortedMap headMap(Object toKey) {
         return new DualTreeBidiMap.ViewMap(this.decorated(), super.headMap(toKey));
      }

      public SortedMap tailMap(Object fromKey) {
         return new DualTreeBidiMap.ViewMap(this.decorated(), super.tailMap(fromKey));
      }

      public SortedMap subMap(Object fromKey, Object toKey) {
         return new DualTreeBidiMap.ViewMap(this.decorated(), super.subMap(fromKey, toKey));
      }

      protected DualTreeBidiMap decorated() {
         return (DualTreeBidiMap)super.decorated();
      }

      public Object previousKey(Object key) {
         return this.decorated().previousKey(key);
      }

      public Object nextKey(Object key) {
         return this.decorated().nextKey(key);
      }
   }
}
