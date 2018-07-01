package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

public class SingletonMap implements OrderedMap, BoundedMap, KeyValue, Serializable, Cloneable {
   private static final long serialVersionUID = -8931271118676803261L;
   private final Object key;
   private Object value;

   public SingletonMap() {
      this.key = null;
   }

   public SingletonMap(Object key, Object value) {
      this.key = key;
      this.value = value;
   }

   public SingletonMap(KeyValue keyValue) {
      this.key = keyValue.getKey();
      this.value = keyValue.getValue();
   }

   public SingletonMap(Entry mapEntry) {
      this.key = mapEntry.getKey();
      this.value = mapEntry.getValue();
   }

   public SingletonMap(Map map) {
      if (map.size() != 1) {
         throw new IllegalArgumentException("The map size must be 1");
      } else {
         Entry entry = (Entry)map.entrySet().iterator().next();
         this.key = entry.getKey();
         this.value = entry.getValue();
      }
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public Object setValue(Object value) {
      Object old = this.value;
      this.value = value;
      return old;
   }

   public boolean isFull() {
      return true;
   }

   public int maxSize() {
      return 1;
   }

   public Object get(Object key) {
      return this.isEqualKey(key) ? this.value : null;
   }

   public int size() {
      return 1;
   }

   public boolean isEmpty() {
      return false;
   }

   public boolean containsKey(Object key) {
      return this.isEqualKey(key);
   }

   public boolean containsValue(Object value) {
      return this.isEqualValue(value);
   }

   public Object put(Object key, Object value) {
      if (this.isEqualKey(key)) {
         return this.setValue(value);
      } else {
         throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
      }
   }

   public void putAll(Map map) {
      switch(map.size()) {
      case 0:
         return;
      case 1:
         Entry entry = (Entry)map.entrySet().iterator().next();
         this.put(entry.getKey(), entry.getValue());
         return;
      default:
         throw new IllegalArgumentException("The map size must be 0 or 1");
      }
   }

   public Object remove(Object key) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Set entrySet() {
      Entry entry = new TiedMapEntry(this, this.getKey());
      return Collections.singleton(entry);
   }

   public Set keySet() {
      return Collections.singleton(this.key);
   }

   public Collection values() {
      return new SingletonMap.SingletonValues(this);
   }

   public OrderedMapIterator mapIterator() {
      return new SingletonMap.SingletonMapIterator(this);
   }

   public Object firstKey() {
      return this.getKey();
   }

   public Object lastKey() {
      return this.getKey();
   }

   public Object nextKey(Object key) {
      return null;
   }

   public Object previousKey(Object key) {
      return null;
   }

   protected boolean isEqualKey(Object key) {
      return key == null ? this.getKey() == null : key.equals(this.getKey());
   }

   protected boolean isEqualValue(Object value) {
      return value == null ? this.getValue() == null : value.equals(this.getValue());
   }

   public SingletonMap clone() {
      try {
         return (SingletonMap)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Map)) {
         return false;
      } else {
         Map other = (Map)obj;
         if (other.size() != 1) {
            return false;
         } else {
            Entry entry = (Entry)other.entrySet().iterator().next();
            return this.isEqualKey(entry.getKey()) && this.isEqualValue(entry.getValue());
         }
      }
   }

   public int hashCode() {
      return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
   }

   public String toString() {
      return (new StringBuilder(128)).append('{').append(this.getKey() == this ? "(this Map)" : this.getKey()).append('=').append(this.getValue() == this ? "(this Map)" : this.getValue()).append('}').toString();
   }

   static class SingletonValues extends AbstractSet implements Serializable {
      private static final long serialVersionUID = -3689524741863047872L;
      private final SingletonMap parent;

      SingletonValues(SingletonMap parent) {
         this.parent = parent;
      }

      public int size() {
         return 1;
      }

      public boolean isEmpty() {
         return false;
      }

      public boolean contains(Object object) {
         return this.parent.containsValue(object);
      }

      public void clear() {
         throw new UnsupportedOperationException();
      }

      public Iterator iterator() {
         return new SingletonIterator(this.parent.getValue(), false);
      }
   }

   static class SingletonMapIterator implements OrderedMapIterator, ResettableIterator {
      private final SingletonMap parent;
      private boolean hasNext = true;
      private boolean canGetSet = false;

      SingletonMapIterator(SingletonMap parent) {
         this.parent = parent;
      }

      public boolean hasNext() {
         return this.hasNext;
      }

      public Object next() {
         if (!this.hasNext) {
            throw new NoSuchElementException("No next() entry in the iteration");
         } else {
            this.hasNext = false;
            this.canGetSet = true;
            return this.parent.getKey();
         }
      }

      public boolean hasPrevious() {
         return !this.hasNext;
      }

      public Object previous() {
         if (this.hasNext) {
            throw new NoSuchElementException("No previous() entry in the iteration");
         } else {
            this.hasNext = true;
            return this.parent.getKey();
         }
      }

      public void remove() {
         throw new UnsupportedOperationException();
      }

      public Object getKey() {
         if (!this.canGetSet) {
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
         } else {
            return this.parent.getKey();
         }
      }

      public Object getValue() {
         if (!this.canGetSet) {
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
         } else {
            return this.parent.getValue();
         }
      }

      public Object setValue(Object value) {
         if (!this.canGetSet) {
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
         } else {
            return this.parent.setValue(value);
         }
      }

      public void reset() {
         this.hasNext = true;
      }

      public String toString() {
         return this.hasNext ? "Iterator[]" : "Iterator[" + this.getKey() + "=" + this.getValue() + "]";
      }
   }
}
