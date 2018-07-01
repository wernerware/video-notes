package org.apache.commons.collections4.bidimap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;

public abstract class AbstractDualBidiMap implements BidiMap {
   transient Map normalMap;
   transient Map reverseMap;
   transient BidiMap inverseBidiMap = null;
   transient Set keySet = null;
   transient Set values = null;
   transient Set entrySet = null;

   protected AbstractDualBidiMap() {
   }

   protected AbstractDualBidiMap(Map normalMap, Map reverseMap) {
      this.normalMap = normalMap;
      this.reverseMap = reverseMap;
   }

   protected AbstractDualBidiMap(Map normalMap, Map reverseMap, BidiMap inverseBidiMap) {
      this.normalMap = normalMap;
      this.reverseMap = reverseMap;
      this.inverseBidiMap = inverseBidiMap;
   }

   protected abstract BidiMap createBidiMap(Map var1, Map var2, BidiMap var3);

   public Object get(Object key) {
      return this.normalMap.get(key);
   }

   public int size() {
      return this.normalMap.size();
   }

   public boolean isEmpty() {
      return this.normalMap.isEmpty();
   }

   public boolean containsKey(Object key) {
      return this.normalMap.containsKey(key);
   }

   public boolean equals(Object obj) {
      return this.normalMap.equals(obj);
   }

   public int hashCode() {
      return this.normalMap.hashCode();
   }

   public String toString() {
      return this.normalMap.toString();
   }

   public Object put(Object key, Object value) {
      if (this.normalMap.containsKey(key)) {
         this.reverseMap.remove(this.normalMap.get(key));
      }

      if (this.reverseMap.containsKey(value)) {
         this.normalMap.remove(this.reverseMap.get(value));
      }

      Object obj = this.normalMap.put(key, value);
      this.reverseMap.put(value, key);
      return obj;
   }

   public void putAll(Map map) {
      Iterator i$ = map.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         this.put(entry.getKey(), entry.getValue());
      }

   }

   public Object remove(Object key) {
      Object value = null;
      if (this.normalMap.containsKey(key)) {
         value = this.normalMap.remove(key);
         this.reverseMap.remove(value);
      }

      return value;
   }

   public void clear() {
      this.normalMap.clear();
      this.reverseMap.clear();
   }

   public boolean containsValue(Object value) {
      return this.reverseMap.containsKey(value);
   }

   public MapIterator mapIterator() {
      return new AbstractDualBidiMap.BidiMapIterator(this);
   }

   public Object getKey(Object value) {
      return this.reverseMap.get(value);
   }

   public Object removeValue(Object value) {
      Object key = null;
      if (this.reverseMap.containsKey(value)) {
         key = this.reverseMap.remove(value);
         this.normalMap.remove(key);
      }

      return key;
   }

   public BidiMap inverseBidiMap() {
      if (this.inverseBidiMap == null) {
         this.inverseBidiMap = this.createBidiMap(this.reverseMap, this.normalMap, this);
      }

      return this.inverseBidiMap;
   }

   public Set keySet() {
      if (this.keySet == null) {
         this.keySet = new AbstractDualBidiMap.KeySet(this);
      }

      return this.keySet;
   }

   protected Iterator createKeySetIterator(Iterator iterator) {
      return new AbstractDualBidiMap.KeySetIterator(iterator, this);
   }

   public Set values() {
      if (this.values == null) {
         this.values = new AbstractDualBidiMap.Values(this);
      }

      return this.values;
   }

   protected Iterator createValuesIterator(Iterator iterator) {
      return new AbstractDualBidiMap.ValuesIterator(iterator, this);
   }

   public Set entrySet() {
      if (this.entrySet == null) {
         this.entrySet = new AbstractDualBidiMap.EntrySet(this);
      }

      return this.entrySet;
   }

   protected Iterator createEntrySetIterator(Iterator iterator) {
      return new AbstractDualBidiMap.EntrySetIterator(iterator, this);
   }

   protected static class BidiMapIterator implements MapIterator, ResettableIterator {
      protected final AbstractDualBidiMap parent;
      protected Iterator iterator;
      protected Entry last = null;
      protected boolean canRemove = false;

      protected BidiMapIterator(AbstractDualBidiMap parent) {
         this.parent = parent;
         this.iterator = parent.normalMap.entrySet().iterator();
      }

      public boolean hasNext() {
         return this.iterator.hasNext();
      }

      public Object next() {
         this.last = (Entry)this.iterator.next();
         this.canRemove = true;
         return this.last.getKey();
      }

      public void remove() {
         if (!this.canRemove) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
         } else {
            Object value = this.last.getValue();
            this.iterator.remove();
            this.parent.reverseMap.remove(value);
            this.last = null;
            this.canRemove = false;
         }
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
            return this.parent.put(this.last.getKey(), value);
         }
      }

      public void reset() {
         this.iterator = this.parent.normalMap.entrySet().iterator();
         this.last = null;
         this.canRemove = false;
      }

      public String toString() {
         return this.last != null ? "MapIterator[" + this.getKey() + "=" + this.getValue() + "]" : "MapIterator[]";
      }
   }

   protected static class MapEntry extends AbstractMapEntryDecorator {
      protected final AbstractDualBidiMap parent;

      protected MapEntry(Entry entry, AbstractDualBidiMap parent) {
         super(entry);
         this.parent = parent;
      }

      public Object setValue(Object value) {
         Object key = this.getKey();
         if (this.parent.reverseMap.containsKey(value) && this.parent.reverseMap.get(value) != key) {
            throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
         } else {
            this.parent.put(key, value);
            return super.setValue(value);
         }
      }
   }

   protected static class EntrySetIterator extends AbstractIteratorDecorator {
      protected final AbstractDualBidiMap parent;
      protected Entry last = null;
      protected boolean canRemove = false;

      protected EntrySetIterator(Iterator iterator, AbstractDualBidiMap parent) {
         super(iterator);
         this.parent = parent;
      }

      public Entry next() {
         this.last = new AbstractDualBidiMap.MapEntry((Entry)super.next(), this.parent);
         this.canRemove = true;
         return this.last;
      }

      public void remove() {
         if (!this.canRemove) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
         } else {
            Object value = this.last.getValue();
            super.remove();
            this.parent.reverseMap.remove(value);
            this.last = null;
            this.canRemove = false;
         }
      }
   }

   protected static class EntrySet extends AbstractDualBidiMap.View implements Set {
      private static final long serialVersionUID = 4040410962603292348L;

      protected EntrySet(AbstractDualBidiMap parent) {
         super(parent.normalMap.entrySet(), parent);
      }

      public Iterator iterator() {
         return this.parent.createEntrySetIterator(super.iterator());
      }

      public boolean remove(Object obj) {
         if (!(obj instanceof Entry)) {
            return false;
         } else {
            Object key;
            Object value;
            label20: {
               Entry entry = (Entry)obj;
               key = entry.getKey();
               if (this.parent.containsKey(key)) {
                  value = this.parent.normalMap.get(key);
                  if (value == null) {
                     if (entry.getValue() == null) {
                        break label20;
                     }
                  } else if (value.equals(entry.getValue())) {
                     break label20;
                  }
               }

               return false;
            }

            this.parent.normalMap.remove(key);
            this.parent.reverseMap.remove(value);
            return true;
         }
      }
   }

   protected static class ValuesIterator extends AbstractIteratorDecorator {
      protected final AbstractDualBidiMap parent;
      protected Object lastValue = null;
      protected boolean canRemove = false;

      protected ValuesIterator(Iterator iterator, AbstractDualBidiMap parent) {
         super(iterator);
         this.parent = parent;
      }

      public Object next() {
         this.lastValue = super.next();
         this.canRemove = true;
         return this.lastValue;
      }

      public void remove() {
         if (!this.canRemove) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
         } else {
            super.remove();
            this.parent.reverseMap.remove(this.lastValue);
            this.lastValue = null;
            this.canRemove = false;
         }
      }
   }

   protected static class Values extends AbstractDualBidiMap.View implements Set {
      private static final long serialVersionUID = 4023777119829639864L;

      protected Values(AbstractDualBidiMap parent) {
         super(parent.normalMap.values(), parent);
      }

      public Iterator iterator() {
         return this.parent.createValuesIterator(super.iterator());
      }

      public boolean contains(Object value) {
         return this.parent.reverseMap.containsKey(value);
      }

      public boolean remove(Object value) {
         if (this.parent.reverseMap.containsKey(value)) {
            Object key = this.parent.reverseMap.remove(value);
            this.parent.normalMap.remove(key);
            return true;
         } else {
            return false;
         }
      }
   }

   protected static class KeySetIterator extends AbstractIteratorDecorator {
      protected final AbstractDualBidiMap parent;
      protected Object lastKey = null;
      protected boolean canRemove = false;

      protected KeySetIterator(Iterator iterator, AbstractDualBidiMap parent) {
         super(iterator);
         this.parent = parent;
      }

      public Object next() {
         this.lastKey = super.next();
         this.canRemove = true;
         return this.lastKey;
      }

      public void remove() {
         if (!this.canRemove) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
         } else {
            Object value = this.parent.normalMap.get(this.lastKey);
            super.remove();
            this.parent.reverseMap.remove(value);
            this.lastKey = null;
            this.canRemove = false;
         }
      }
   }

   protected static class KeySet extends AbstractDualBidiMap.View implements Set {
      private static final long serialVersionUID = -7107935777385040694L;

      protected KeySet(AbstractDualBidiMap parent) {
         super(parent.normalMap.keySet(), parent);
      }

      public Iterator iterator() {
         return this.parent.createKeySetIterator(super.iterator());
      }

      public boolean contains(Object key) {
         return this.parent.normalMap.containsKey(key);
      }

      public boolean remove(Object key) {
         if (this.parent.normalMap.containsKey(key)) {
            Object value = this.parent.normalMap.remove(key);
            this.parent.reverseMap.remove(value);
            return true;
         } else {
            return false;
         }
      }
   }

   protected abstract static class View extends AbstractCollectionDecorator {
      private static final long serialVersionUID = 4621510560119690639L;
      protected final AbstractDualBidiMap parent;

      protected View(Collection coll, AbstractDualBidiMap parent) {
         super(coll);
         this.parent = parent;
      }

      public boolean equals(Object object) {
         return object == this || this.decorated().equals(object);
      }

      public int hashCode() {
         return this.decorated().hashCode();
      }

      public boolean removeAll(Collection coll) {
         if (!this.parent.isEmpty() && !coll.isEmpty()) {
            boolean modified = false;

            for(Iterator it = coll.iterator(); it.hasNext(); modified |= this.remove(it.next())) {
               ;
            }

            return modified;
         } else {
            return false;
         }
      }

      public boolean retainAll(Collection coll) {
         if (this.parent.isEmpty()) {
            return false;
         } else if (coll.isEmpty()) {
            this.parent.clear();
            return true;
         } else {
            boolean modified = false;
            Iterator it = this.iterator();

            while(it.hasNext()) {
               if (!coll.contains(it.next())) {
                  it.remove();
                  modified = true;
               }
            }

            return modified;
         }
      }

      public void clear() {
         this.parent.clear();
      }
   }
}
