package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class AbstractHashedMap extends AbstractMap implements IterableMap {
   protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";
   protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";
   protected static final String REMOVE_INVALID = "remove() can only be called once after next()";
   protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";
   protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";
   protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";
   protected static final int DEFAULT_CAPACITY = 16;
   protected static final int DEFAULT_THRESHOLD = 12;
   protected static final float DEFAULT_LOAD_FACTOR = 0.75F;
   protected static final int MAXIMUM_CAPACITY = 1073741824;
   protected static final Object NULL = new Object();
   transient float loadFactor;
   transient int size;
   transient AbstractHashedMap.HashEntry[] data;
   transient int threshold;
   transient int modCount;
   transient AbstractHashedMap.EntrySet entrySet;
   transient AbstractHashedMap.KeySet keySet;
   transient AbstractHashedMap.Values values;

   protected AbstractHashedMap() {
   }

   protected AbstractHashedMap(int initialCapacity, float loadFactor, int threshold) {
      this.loadFactor = loadFactor;
      this.data = new AbstractHashedMap.HashEntry[initialCapacity];
      this.threshold = threshold;
      this.init();
   }

   protected AbstractHashedMap(int initialCapacity) {
      this(initialCapacity, 0.75F);
   }

   protected AbstractHashedMap(int initialCapacity, float loadFactor) {
      if (initialCapacity < 0) {
         throw new IllegalArgumentException("Initial capacity must be a non negative number");
      } else if (loadFactor > 0.0F && !Float.isNaN(loadFactor)) {
         this.loadFactor = loadFactor;
         initialCapacity = this.calculateNewCapacity(initialCapacity);
         this.threshold = this.calculateThreshold(initialCapacity, loadFactor);
         this.data = new AbstractHashedMap.HashEntry[initialCapacity];
         this.init();
      } else {
         throw new IllegalArgumentException("Load factor must be greater than 0");
      }
   }

   protected AbstractHashedMap(Map map) {
      this(Math.max(2 * map.size(), 16), 0.75F);
      this._putAll(map);
   }

   protected void init() {
   }

   public Object get(Object key) {
      key = this.convertKey(key);
      int hashCode = this.hash(key);

      for(AbstractHashedMap.HashEntry entry = this.data[this.hashIndex(hashCode, this.data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(key, entry.key)) {
            return entry.getValue();
         }
      }

      return null;
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public boolean containsKey(Object key) {
      key = this.convertKey(key);
      int hashCode = this.hash(key);

      for(AbstractHashedMap.HashEntry entry = this.data[this.hashIndex(hashCode, this.data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(key, entry.key)) {
            return true;
         }
      }

      return false;
   }

   public boolean containsValue(Object value) {
      AbstractHashedMap.HashEntry[] arr$;
      int len$;
      int i$;
      AbstractHashedMap.HashEntry element;
      AbstractHashedMap.HashEntry entry;
      if (value == null) {
         arr$ = this.data;
         len$ = arr$.length;

         for(i$ = 0; i$ < len$; ++i$) {
            element = arr$[i$];

            for(entry = element; entry != null; entry = entry.next) {
               if (entry.getValue() == null) {
                  return true;
               }
            }
         }
      } else {
         arr$ = this.data;
         len$ = arr$.length;

         for(i$ = 0; i$ < len$; ++i$) {
            element = arr$[i$];

            for(entry = element; entry != null; entry = entry.next) {
               if (this.isEqualValue(value, entry.getValue())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public Object put(Object key, Object value) {
      Object convertedKey = this.convertKey(key);
      int hashCode = this.hash(convertedKey);
      int index = this.hashIndex(hashCode, this.data.length);

      for(AbstractHashedMap.HashEntry entry = this.data[index]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(convertedKey, entry.key)) {
            Object oldValue = entry.getValue();
            this.updateEntry(entry, value);
            return oldValue;
         }
      }

      this.addMapping(index, hashCode, key, value);
      return null;
   }

   public void putAll(Map map) {
      this._putAll(map);
   }

   private void _putAll(Map map) {
      int mapSize = map.size();
      if (mapSize != 0) {
         int newSize = (int)((float)(this.size + mapSize) / this.loadFactor + 1.0F);
         this.ensureCapacity(this.calculateNewCapacity(newSize));
         Iterator i$ = map.entrySet().iterator();

         while(i$.hasNext()) {
            Entry entry = (Entry)i$.next();
            this.put(entry.getKey(), entry.getValue());
         }

      }
   }

   public Object remove(Object key) {
      key = this.convertKey(key);
      int hashCode = this.hash(key);
      int index = this.hashIndex(hashCode, this.data.length);
      AbstractHashedMap.HashEntry entry = this.data[index];

      for(AbstractHashedMap.HashEntry previous = null; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(key, entry.key)) {
            Object oldValue = entry.getValue();
            this.removeMapping(entry, index, previous);
            return oldValue;
         }

         previous = entry;
      }

      return null;
   }

   public void clear() {
      ++this.modCount;
      AbstractHashedMap.HashEntry[] data = this.data;

      for(int i = data.length - 1; i >= 0; --i) {
         data[i] = null;
      }

      this.size = 0;
   }

   protected Object convertKey(Object key) {
      return key == null ? NULL : key;
   }

   protected int hash(Object key) {
      int h = key.hashCode();
      h += ~(h << 9);
      h ^= h >>> 14;
      h += h << 4;
      h ^= h >>> 10;
      return h;
   }

   protected boolean isEqualKey(Object key1, Object key2) {
      return key1 == key2 || key1.equals(key2);
   }

   protected boolean isEqualValue(Object value1, Object value2) {
      return value1 == value2 || value1.equals(value2);
   }

   protected int hashIndex(int hashCode, int dataSize) {
      return hashCode & dataSize - 1;
   }

   protected AbstractHashedMap.HashEntry getEntry(Object key) {
      key = this.convertKey(key);
      int hashCode = this.hash(key);

      for(AbstractHashedMap.HashEntry entry = this.data[this.hashIndex(hashCode, this.data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(key, entry.key)) {
            return entry;
         }
      }

      return null;
   }

   protected void updateEntry(AbstractHashedMap.HashEntry entry, Object newValue) {
      entry.setValue(newValue);
   }

   protected void reuseEntry(AbstractHashedMap.HashEntry entry, int hashIndex, int hashCode, Object key, Object value) {
      entry.next = this.data[hashIndex];
      entry.hashCode = hashCode;
      entry.key = key;
      entry.value = value;
   }

   protected void addMapping(int hashIndex, int hashCode, Object key, Object value) {
      ++this.modCount;
      AbstractHashedMap.HashEntry entry = this.createEntry(this.data[hashIndex], hashCode, key, value);
      this.addEntry(entry, hashIndex);
      ++this.size;
      this.checkCapacity();
   }

   protected AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry next, int hashCode, Object key, Object value) {
      return new AbstractHashedMap.HashEntry(next, hashCode, this.convertKey(key), value);
   }

   protected void addEntry(AbstractHashedMap.HashEntry entry, int hashIndex) {
      this.data[hashIndex] = entry;
   }

   protected void removeMapping(AbstractHashedMap.HashEntry entry, int hashIndex, AbstractHashedMap.HashEntry previous) {
      ++this.modCount;
      this.removeEntry(entry, hashIndex, previous);
      --this.size;
      this.destroyEntry(entry);
   }

   protected void removeEntry(AbstractHashedMap.HashEntry entry, int hashIndex, AbstractHashedMap.HashEntry previous) {
      if (previous == null) {
         this.data[hashIndex] = entry.next;
      } else {
         previous.next = entry.next;
      }

   }

   protected void destroyEntry(AbstractHashedMap.HashEntry entry) {
      entry.next = null;
      entry.key = null;
      entry.value = null;
   }

   protected void checkCapacity() {
      if (this.size >= this.threshold) {
         int newCapacity = this.data.length * 2;
         if (newCapacity <= 1073741824) {
            this.ensureCapacity(newCapacity);
         }
      }

   }

   protected void ensureCapacity(int newCapacity) {
      int oldCapacity = this.data.length;
      if (newCapacity > oldCapacity) {
         if (this.size == 0) {
            this.threshold = this.calculateThreshold(newCapacity, this.loadFactor);
            this.data = new AbstractHashedMap.HashEntry[newCapacity];
         } else {
            AbstractHashedMap.HashEntry[] oldEntries = this.data;
            AbstractHashedMap.HashEntry[] newEntries = new AbstractHashedMap.HashEntry[newCapacity];
            ++this.modCount;

            for(int i = oldCapacity - 1; i >= 0; --i) {
               AbstractHashedMap.HashEntry entry = oldEntries[i];
               if (entry != null) {
                  oldEntries[i] = null;

                  AbstractHashedMap.HashEntry next;
                  do {
                     next = entry.next;
                     int index = this.hashIndex(entry.hashCode, newCapacity);
                     entry.next = newEntries[index];
                     newEntries[index] = entry;
                     entry = next;
                  } while(next != null);
               }
            }

            this.threshold = this.calculateThreshold(newCapacity, this.loadFactor);
            this.data = newEntries;
         }

      }
   }

   protected int calculateNewCapacity(int proposedCapacity) {
      int newCapacity = 1;
      if (proposedCapacity > 1073741824) {
         newCapacity = 1073741824;
      } else {
         while(true) {
            if (newCapacity >= proposedCapacity) {
               if (newCapacity > 1073741824) {
                  newCapacity = 1073741824;
               }
               break;
            }

            newCapacity <<= 1;
         }
      }

      return newCapacity;
   }

   protected int calculateThreshold(int newCapacity, float factor) {
      return (int)((float)newCapacity * factor);
   }

   protected AbstractHashedMap.HashEntry entryNext(AbstractHashedMap.HashEntry entry) {
      return entry.next;
   }

   protected int entryHashCode(AbstractHashedMap.HashEntry entry) {
      return entry.hashCode;
   }

   protected Object entryKey(AbstractHashedMap.HashEntry entry) {
      return entry.getKey();
   }

   protected Object entryValue(AbstractHashedMap.HashEntry entry) {
      return entry.getValue();
   }

   public MapIterator mapIterator() {
      return (MapIterator)(this.size == 0 ? EmptyMapIterator.emptyMapIterator() : new AbstractHashedMap.HashMapIterator(this));
   }

   public Set entrySet() {
      if (this.entrySet == null) {
         this.entrySet = new AbstractHashedMap.EntrySet(this);
      }

      return this.entrySet;
   }

   protected Iterator createEntrySetIterator() {
      return (Iterator)(this.size() == 0 ? EmptyIterator.emptyIterator() : new AbstractHashedMap.EntrySetIterator(this));
   }

   public Set keySet() {
      if (this.keySet == null) {
         this.keySet = new AbstractHashedMap.KeySet(this);
      }

      return this.keySet;
   }

   protected Iterator createKeySetIterator() {
      return (Iterator)(this.size() == 0 ? EmptyIterator.emptyIterator() : new AbstractHashedMap.KeySetIterator(this));
   }

   public Collection values() {
      if (this.values == null) {
         this.values = new AbstractHashedMap.Values(this);
      }

      return this.values;
   }

   protected Iterator createValuesIterator() {
      return (Iterator)(this.size() == 0 ? EmptyIterator.emptyIterator() : new AbstractHashedMap.ValuesIterator(this));
   }

   protected void doWriteObject(ObjectOutputStream out) throws IOException {
      out.writeFloat(this.loadFactor);
      out.writeInt(this.data.length);
      out.writeInt(this.size);
      MapIterator it = this.mapIterator();

      while(it.hasNext()) {
         out.writeObject(it.next());
         out.writeObject(it.getValue());
      }

   }

   protected void doReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      this.loadFactor = in.readFloat();
      int capacity = in.readInt();
      int size = in.readInt();
      this.init();
      this.threshold = this.calculateThreshold(capacity, this.loadFactor);
      this.data = new AbstractHashedMap.HashEntry[capacity];

      for(int i = 0; i < size; ++i) {
         Object key = in.readObject();
         Object value = in.readObject();
         this.put(key, value);
      }

   }

   protected AbstractHashedMap clone() {
      try {
         AbstractHashedMap cloned = (AbstractHashedMap)super.clone();
         cloned.data = new AbstractHashedMap.HashEntry[this.data.length];
         cloned.entrySet = null;
         cloned.keySet = null;
         cloned.values = null;
         cloned.modCount = 0;
         cloned.size = 0;
         cloned.init();
         cloned.putAll(this);
         return cloned;
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   public boolean equals(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      int total = 0;

      for(Iterator it = this.createEntrySetIterator(); it.hasNext(); total += ((Entry)it.next()).hashCode()) {
         ;
      }

      return total;
   }

   public String toString() {
      if (this.size() == 0) {
         return "{}";
      } else {
         StringBuilder buf = new StringBuilder(32 * this.size());
         buf.append('{');
         MapIterator it = this.mapIterator();
         boolean hasNext = it.hasNext();

         while(hasNext) {
            Object key = it.next();
            Object value = it.getValue();
            buf.append(key == this ? "(this Map)" : key).append('=').append(value == this ? "(this Map)" : value);
            hasNext = it.hasNext();
            if (hasNext) {
               buf.append(',').append(' ');
            }
         }

         buf.append('}');
         return buf.toString();
      }
   }

   protected abstract static class HashIterator {
      private final AbstractHashedMap parent;
      private int hashIndex;
      private AbstractHashedMap.HashEntry last;
      private AbstractHashedMap.HashEntry next;
      private int expectedModCount;

      protected HashIterator(AbstractHashedMap parent) {
         this.parent = parent;
         AbstractHashedMap.HashEntry[] data = parent.data;
         int i = data.length;

         AbstractHashedMap.HashEntry next;
         for(next = null; i > 0 && next == null; next = data[i]) {
            --i;
         }

         this.next = next;
         this.hashIndex = i;
         this.expectedModCount = parent.modCount;
      }

      public boolean hasNext() {
         return this.next != null;
      }

      protected AbstractHashedMap.HashEntry nextEntry() {
         if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         } else {
            AbstractHashedMap.HashEntry newCurrent = this.next;
            if (newCurrent == null) {
               throw new NoSuchElementException("No next() entry in the iteration");
            } else {
               AbstractHashedMap.HashEntry[] data = this.parent.data;
               int i = this.hashIndex;

               AbstractHashedMap.HashEntry n;
               for(n = newCurrent.next; n == null && i > 0; n = data[i]) {
                  --i;
               }

               this.next = n;
               this.hashIndex = i;
               this.last = newCurrent;
               return newCurrent;
            }
         }
      }

      protected AbstractHashedMap.HashEntry currentEntry() {
         return this.last;
      }

      public void remove() {
         if (this.last == null) {
            throw new IllegalStateException("remove() can only be called once after next()");
         } else if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         } else {
            this.parent.remove(this.last.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
         }
      }

      public String toString() {
         return this.last != null ? "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]" : "Iterator[]";
      }
   }

   protected static class HashEntry implements Entry, KeyValue {
      protected AbstractHashedMap.HashEntry next;
      protected int hashCode;
      protected Object key;
      protected Object value;

      protected HashEntry(AbstractHashedMap.HashEntry next, int hashCode, Object key, Object value) {
         this.next = next;
         this.hashCode = hashCode;
         this.key = key;
         this.value = value;
      }

      public Object getKey() {
         return this.key == AbstractHashedMap.NULL ? null : this.key;
      }

      public Object getValue() {
         return this.value;
      }

      public Object setValue(Object value) {
         Object old = this.value;
         this.value = value;
         return old;
      }

      public boolean equals(Object obj) {
         if (obj == this) {
            return true;
         } else if (!(obj instanceof Entry)) {
            return false;
         } else {
            boolean var10000;
            label43: {
               label29: {
                  Entry other = (Entry)obj;
                  if (this.getKey() == null) {
                     if (other.getKey() != null) {
                        break label29;
                     }
                  } else if (!this.getKey().equals(other.getKey())) {
                     break label29;
                  }

                  if (this.getValue() == null) {
                     if (other.getValue() == null) {
                        break label43;
                     }
                  } else if (this.getValue().equals(other.getValue())) {
                     break label43;
                  }
               }

               var10000 = false;
               return var10000;
            }

            var10000 = true;
            return var10000;
         }
      }

      public int hashCode() {
         return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
      }

      public String toString() {
         return "" + this.getKey() + '=' + this.getValue();
      }
   }

   protected static class ValuesIterator extends AbstractHashedMap.HashIterator implements Iterator {
      protected ValuesIterator(AbstractHashedMap parent) {
         super(parent);
      }

      public Object next() {
         return super.nextEntry().getValue();
      }
   }

   protected static class Values extends AbstractCollection {
      private final AbstractHashedMap parent;

      protected Values(AbstractHashedMap parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.size();
      }

      public void clear() {
         this.parent.clear();
      }

      public boolean contains(Object value) {
         return this.parent.containsValue(value);
      }

      public Iterator iterator() {
         return this.parent.createValuesIterator();
      }
   }

   protected static class KeySetIterator extends AbstractHashedMap.HashIterator implements Iterator {
      protected KeySetIterator(AbstractHashedMap parent) {
         super(parent);
      }

      public Object next() {
         return super.nextEntry().getKey();
      }
   }

   protected static class KeySet extends AbstractSet {
      private final AbstractHashedMap parent;

      protected KeySet(AbstractHashedMap parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.size();
      }

      public void clear() {
         this.parent.clear();
      }

      public boolean contains(Object key) {
         return this.parent.containsKey(key);
      }

      public boolean remove(Object key) {
         boolean result = this.parent.containsKey(key);
         this.parent.remove(key);
         return result;
      }

      public Iterator iterator() {
         return this.parent.createKeySetIterator();
      }
   }

   protected static class EntrySetIterator extends AbstractHashedMap.HashIterator implements Iterator {
      protected EntrySetIterator(AbstractHashedMap parent) {
         super(parent);
      }

      public Entry next() {
         return super.nextEntry();
      }
   }

   protected static class EntrySet extends AbstractSet {
      private final AbstractHashedMap parent;

      protected EntrySet(AbstractHashedMap parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.size();
      }

      public void clear() {
         this.parent.clear();
      }

      public boolean contains(Object entry) {
         if (!(entry instanceof Entry)) {
            return false;
         } else {
            Entry e = (Entry)entry;
            Entry match = this.parent.getEntry(e.getKey());
            return match != null && match.equals(e);
         }
      }

      public boolean remove(Object obj) {
         if (!(obj instanceof Entry)) {
            return false;
         } else if (!this.contains(obj)) {
            return false;
         } else {
            Entry entry = (Entry)obj;
            this.parent.remove(entry.getKey());
            return true;
         }
      }

      public Iterator iterator() {
         return this.parent.createEntrySetIterator();
      }
   }

   protected static class HashMapIterator extends AbstractHashedMap.HashIterator implements MapIterator {
      protected HashMapIterator(AbstractHashedMap parent) {
         super(parent);
      }

      public Object next() {
         return super.nextEntry().getKey();
      }

      public Object getKey() {
         AbstractHashedMap.HashEntry current = this.currentEntry();
         if (current == null) {
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
         } else {
            return current.getKey();
         }
      }

      public Object getValue() {
         AbstractHashedMap.HashEntry current = this.currentEntry();
         if (current == null) {
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
         } else {
            return current.getValue();
         }
      }

      public Object setValue(Object value) {
         AbstractHashedMap.HashEntry current = this.currentEntry();
         if (current == null) {
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
         } else {
            return current.setValue(value);
         }
      }
   }
}
