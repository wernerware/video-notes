package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedMap extends AbstractMapDecorator implements OrderedMap, Serializable {
   private static final long serialVersionUID = 2728177751851003750L;
   private final List insertOrder;

   public static ListOrderedMap listOrderedMap(Map map) {
      return new ListOrderedMap(map);
   }

   public ListOrderedMap() {
      this(new HashMap());
   }

   protected ListOrderedMap(Map map) {
      super(map);
      this.insertOrder = new ArrayList();
      this.insertOrder.addAll(this.decorated().keySet());
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.map);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }

   public OrderedMapIterator mapIterator() {
      return new ListOrderedMap.ListOrderedMapIterator(this);
   }

   public Object firstKey() {
      if (this.size() == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.insertOrder.get(0);
      }
   }

   public Object lastKey() {
      if (this.size() == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.insertOrder.get(this.size() - 1);
      }
   }

   public Object nextKey(Object key) {
      int index = this.insertOrder.indexOf(key);
      return index >= 0 && index < this.size() - 1 ? this.insertOrder.get(index + 1) : null;
   }

   public Object previousKey(Object key) {
      int index = this.insertOrder.indexOf(key);
      return index > 0 ? this.insertOrder.get(index - 1) : null;
   }

   public Object put(Object key, Object value) {
      if (this.decorated().containsKey(key)) {
         return this.decorated().put(key, value);
      } else {
         Object result = this.decorated().put(key, value);
         this.insertOrder.add(key);
         return result;
      }
   }

   public void putAll(Map map) {
      Iterator i$ = map.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         this.put(entry.getKey(), entry.getValue());
      }

   }

   public void putAll(int index, Map map) {
      if (index >= 0 && index <= this.insertOrder.size()) {
         Iterator i$ = map.entrySet().iterator();

         while(i$.hasNext()) {
            Entry entry = (Entry)i$.next();
            Object key = entry.getKey();
            boolean contains = this.containsKey(key);
            this.put(index, entry.getKey(), entry.getValue());
            if (!contains) {
               ++index;
            } else {
               index = this.indexOf(entry.getKey()) + 1;
            }
         }

      } else {
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.insertOrder.size());
      }
   }

   public Object remove(Object key) {
      Object result = null;
      if (this.decorated().containsKey(key)) {
         result = this.decorated().remove(key);
         this.insertOrder.remove(key);
      }

      return result;
   }

   public void clear() {
      this.decorated().clear();
      this.insertOrder.clear();
   }

   public Set keySet() {
      return new ListOrderedMap.KeySetView(this);
   }

   public List keyList() {
      return UnmodifiableList.unmodifiableList(this.insertOrder);
   }

   public Collection values() {
      return new ListOrderedMap.ValuesView(this);
   }

   public List valueList() {
      return new ListOrderedMap.ValuesView(this);
   }

   public Set entrySet() {
      return new ListOrderedMap.EntrySetView(this, this.insertOrder);
   }

   public String toString() {
      if (this.isEmpty()) {
         return "{}";
      } else {
         StringBuilder buf = new StringBuilder();
         buf.append('{');
         boolean first = true;
         Iterator i$ = this.entrySet().iterator();

         while(i$.hasNext()) {
            Entry entry = (Entry)i$.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (first) {
               first = false;
            } else {
               buf.append(", ");
            }

            buf.append(key == this ? "(this Map)" : key);
            buf.append('=');
            buf.append(value == this ? "(this Map)" : value);
         }

         buf.append('}');
         return buf.toString();
      }
   }

   public Object get(int index) {
      return this.insertOrder.get(index);
   }

   public Object getValue(int index) {
      return this.get(this.insertOrder.get(index));
   }

   public int indexOf(Object key) {
      return this.insertOrder.indexOf(key);
   }

   public Object setValue(int index, Object value) {
      Object key = this.insertOrder.get(index);
      return this.put(key, value);
   }

   public Object put(int index, Object key, Object value) {
      if (index >= 0 && index <= this.insertOrder.size()) {
         Map m = this.decorated();
         if (m.containsKey(key)) {
            Object result = m.remove(key);
            int pos = this.insertOrder.indexOf(key);
            this.insertOrder.remove(pos);
            if (pos < index) {
               --index;
            }

            this.insertOrder.add(index, key);
            m.put(key, value);
            return result;
         } else {
            this.insertOrder.add(index, key);
            m.put(key, value);
            return null;
         }
      } else {
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.insertOrder.size());
      }
   }

   public Object remove(int index) {
      return this.remove(this.get(index));
   }

   public List asList() {
      return this.keyList();
   }

   static class ListOrderedMapIterator implements OrderedMapIterator, ResettableIterator {
      private final ListOrderedMap parent;
      private ListIterator iterator;
      private Object last = null;
      private boolean readable = false;

      ListOrderedMapIterator(ListOrderedMap parent) {
         this.parent = parent;
         this.iterator = parent.insertOrder.listIterator();
      }

      public boolean hasNext() {
         return this.iterator.hasNext();
      }

      public Object next() {
         this.last = this.iterator.next();
         this.readable = true;
         return this.last;
      }

      public boolean hasPrevious() {
         return this.iterator.hasPrevious();
      }

      public Object previous() {
         this.last = this.iterator.previous();
         this.readable = true;
         return this.last;
      }

      public void remove() {
         if (!this.readable) {
            throw new IllegalStateException("remove() can only be called once after next()");
         } else {
            this.iterator.remove();
            this.parent.map.remove(this.last);
            this.readable = false;
         }
      }

      public Object getKey() {
         if (!this.readable) {
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
         } else {
            return this.last;
         }
      }

      public Object getValue() {
         if (!this.readable) {
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
         } else {
            return this.parent.get(this.last);
         }
      }

      public Object setValue(Object value) {
         if (!this.readable) {
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
         } else {
            return this.parent.map.put(this.last, value);
         }
      }

      public void reset() {
         this.iterator = this.parent.insertOrder.listIterator();
         this.last = null;
         this.readable = false;
      }

      public String toString() {
         return this.readable ? "Iterator[" + this.getKey() + "=" + this.getValue() + "]" : "Iterator[]";
      }
   }

   static class ListOrderedMapEntry extends AbstractMapEntry {
      private final ListOrderedMap parent;

      ListOrderedMapEntry(ListOrderedMap parent, Object key) {
         super(key, (Object)null);
         this.parent = parent;
      }

      public Object getValue() {
         return this.parent.get(this.getKey());
      }

      public Object setValue(Object value) {
         return this.parent.decorated().put(this.getKey(), value);
      }
   }

   static class ListOrderedIterator extends AbstractUntypedIteratorDecorator {
      private final ListOrderedMap parent;
      private Object last = null;

      ListOrderedIterator(ListOrderedMap parent, List insertOrder) {
         super(insertOrder.iterator());
         this.parent = parent;
      }

      public Entry next() {
         this.last = this.getIterator().next();
         return new ListOrderedMap.ListOrderedMapEntry(this.parent, this.last);
      }

      public void remove() {
         super.remove();
         this.parent.decorated().remove(this.last);
      }
   }

   static class EntrySetView extends AbstractSet {
      private final ListOrderedMap parent;
      private final List insertOrder;
      private Set entrySet;

      public EntrySetView(ListOrderedMap parent, List insertOrder) {
         this.parent = parent;
         this.insertOrder = insertOrder;
      }

      private Set getEntrySet() {
         if (this.entrySet == null) {
            this.entrySet = this.parent.decorated().entrySet();
         }

         return this.entrySet;
      }

      public int size() {
         return this.parent.size();
      }

      public boolean isEmpty() {
         return this.parent.isEmpty();
      }

      public boolean contains(Object obj) {
         return this.getEntrySet().contains(obj);
      }

      public boolean containsAll(Collection coll) {
         return this.getEntrySet().containsAll(coll);
      }

      public boolean remove(Object obj) {
         if (!(obj instanceof Entry)) {
            return false;
         } else if (this.getEntrySet().contains(obj)) {
            Object key = ((Entry)obj).getKey();
            this.parent.remove(key);
            return true;
         } else {
            return false;
         }
      }

      public void clear() {
         this.parent.clear();
      }

      public boolean equals(Object obj) {
         return obj == this ? true : this.getEntrySet().equals(obj);
      }

      public int hashCode() {
         return this.getEntrySet().hashCode();
      }

      public String toString() {
         return this.getEntrySet().toString();
      }

      public Iterator iterator() {
         return new ListOrderedMap.ListOrderedIterator(this.parent, this.insertOrder);
      }
   }

   static class KeySetView extends AbstractSet {
      private final ListOrderedMap parent;

      KeySetView(ListOrderedMap parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.size();
      }

      public boolean contains(Object value) {
         return this.parent.containsKey(value);
      }

      public void clear() {
         this.parent.clear();
      }

      public Iterator iterator() {
         return new AbstractUntypedIteratorDecorator(this.parent.entrySet().iterator()) {
            public Object next() {
               return ((Entry)this.getIterator().next()).getKey();
            }
         };
      }
   }

   static class ValuesView extends AbstractList {
      private final ListOrderedMap parent;

      ValuesView(ListOrderedMap parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.size();
      }

      public boolean contains(Object value) {
         return this.parent.containsValue(value);
      }

      public void clear() {
         this.parent.clear();
      }

      public Iterator iterator() {
         return new AbstractUntypedIteratorDecorator(this.parent.entrySet().iterator()) {
            public Object next() {
               return ((Entry)this.getIterator().next()).getValue();
            }
         };
      }

      public Object get(int index) {
         return this.parent.getValue(index);
      }

      public Object set(int index, Object value) {
         return this.parent.setValue(index, value);
      }

      public Object remove(int index) {
         return this.parent.remove(index);
      }
   }
}
