package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class Flat3Map implements IterableMap, Serializable, Cloneable {
   private static final long serialVersionUID = -6701087419741928296L;
   private transient int size;
   private transient int hash1;
   private transient int hash2;
   private transient int hash3;
   private transient Object key1;
   private transient Object key2;
   private transient Object key3;
   private transient Object value1;
   private transient Object value2;
   private transient Object value3;
   private transient AbstractHashedMap delegateMap;

   public Flat3Map() {
   }

   public Flat3Map(Map map) {
      this.putAll(map);
   }

   public Object get(Object key) {
      if (this.delegateMap != null) {
         return this.delegateMap.get(key);
      } else {
         if (key == null) {
            switch(this.size) {
            case 3:
               if (this.key3 == null) {
                  return this.value3;
               }
            case 2:
               if (this.key2 == null) {
                  return this.value2;
               }
            case 1:
               if (this.key1 == null) {
                  return this.value1;
               }
            }
         } else if (this.size > 0) {
            int hashCode = key.hashCode();
            switch(this.size) {
            case 3:
               if (this.hash3 == hashCode && key.equals(this.key3)) {
                  return this.value3;
               }
            case 2:
               if (this.hash2 == hashCode && key.equals(this.key2)) {
                  return this.value2;
               }
            case 1:
               if (this.hash1 == hashCode && key.equals(this.key1)) {
                  return this.value1;
               }
            }
         }

         return null;
      }
   }

   public int size() {
      return this.delegateMap != null ? this.delegateMap.size() : this.size;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public boolean containsKey(Object key) {
      if (this.delegateMap != null) {
         return this.delegateMap.containsKey(key);
      } else {
         if (key == null) {
            switch(this.size) {
            case 3:
               if (this.key3 == null) {
                  return true;
               }
            case 2:
               if (this.key2 == null) {
                  return true;
               }
            case 1:
               if (this.key1 == null) {
                  return true;
               }
            }
         } else if (this.size > 0) {
            int hashCode = key.hashCode();
            switch(this.size) {
            case 3:
               if (this.hash3 == hashCode && key.equals(this.key3)) {
                  return true;
               }
            case 2:
               if (this.hash2 == hashCode && key.equals(this.key2)) {
                  return true;
               }
            case 1:
               if (this.hash1 == hashCode && key.equals(this.key1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean containsValue(Object value) {
      if (this.delegateMap != null) {
         return this.delegateMap.containsValue(value);
      } else {
         if (value == null) {
            switch(this.size) {
            case 3:
               if (this.value3 == null) {
                  return true;
               }
            case 2:
               if (this.value2 == null) {
                  return true;
               }
            case 1:
               if (this.value1 == null) {
                  return true;
               }
            }
         } else {
            switch(this.size) {
            case 3:
               if (value.equals(this.value3)) {
                  return true;
               }
            case 2:
               if (value.equals(this.value2)) {
                  return true;
               }
            case 1:
               if (value.equals(this.value1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public Object put(Object key, Object value) {
      if (this.delegateMap != null) {
         return this.delegateMap.put(key, value);
      } else {
         if (key == null) {
            Object old;
            switch(this.size) {
            case 3:
               if (this.key3 == null) {
                  old = this.value3;
                  this.value3 = value;
                  return old;
               }
            case 2:
               if (this.key2 == null) {
                  old = this.value2;
                  this.value2 = value;
                  return old;
               }
            case 1:
               if (this.key1 == null) {
                  old = this.value1;
                  this.value1 = value;
                  return old;
               }
            }
         } else if (this.size > 0) {
            int hashCode = key.hashCode();
            Object old;
            switch(this.size) {
            case 3:
               if (this.hash3 == hashCode && key.equals(this.key3)) {
                  old = this.value3;
                  this.value3 = value;
                  return old;
               }
            case 2:
               if (this.hash2 == hashCode && key.equals(this.key2)) {
                  old = this.value2;
                  this.value2 = value;
                  return old;
               }
            case 1:
               if (this.hash1 == hashCode && key.equals(this.key1)) {
                  old = this.value1;
                  this.value1 = value;
                  return old;
               }
            }
         }

         switch(this.size) {
         case 0:
            this.hash1 = key == null ? 0 : key.hashCode();
            this.key1 = key;
            this.value1 = value;
            break;
         case 1:
            this.hash2 = key == null ? 0 : key.hashCode();
            this.key2 = key;
            this.value2 = value;
            break;
         case 2:
            this.hash3 = key == null ? 0 : key.hashCode();
            this.key3 = key;
            this.value3 = value;
            break;
         default:
            this.convertToMap();
            this.delegateMap.put(key, value);
            return null;
         }

         ++this.size;
         return null;
      }
   }

   public void putAll(Map map) {
      int size = map.size();
      if (size != 0) {
         if (this.delegateMap != null) {
            this.delegateMap.putAll(map);
         } else {
            if (size < 4) {
               Iterator i$ = map.entrySet().iterator();

               while(i$.hasNext()) {
                  Entry entry = (Entry)i$.next();
                  this.put(entry.getKey(), entry.getValue());
               }
            } else {
               this.convertToMap();
               this.delegateMap.putAll(map);
            }

         }
      }
   }

   private void convertToMap() {
      this.delegateMap = this.createDelegateMap();
      switch(this.size) {
      case 3:
         this.delegateMap.put(this.key3, this.value3);
      case 2:
         this.delegateMap.put(this.key2, this.value2);
      case 1:
         this.delegateMap.put(this.key1, this.value1);
      case 0:
         this.size = 0;
         this.hash1 = this.hash2 = this.hash3 = 0;
         this.key1 = this.key2 = this.key3 = null;
         this.value1 = this.value2 = this.value3 = null;
         return;
      default:
         throw new IllegalStateException("Invalid map index: " + this.size);
      }
   }

   protected AbstractHashedMap createDelegateMap() {
      return new HashedMap();
   }

   public Object remove(Object key) {
      if (this.delegateMap != null) {
         return this.delegateMap.remove(key);
      } else if (this.size == 0) {
         return null;
      } else {
         if (key == null) {
            Object old;
            switch(this.size) {
            case 1:
               if (this.key1 == null) {
                  old = this.value1;
                  this.hash1 = 0;
                  this.key1 = null;
                  this.value1 = null;
                  this.size = 0;
                  return old;
               }
               break;
            case 2:
               if (this.key2 == null) {
                  old = this.value2;
                  this.hash2 = 0;
                  this.key2 = null;
                  this.value2 = null;
                  this.size = 1;
                  return old;
               }

               if (this.key1 == null) {
                  old = this.value1;
                  this.hash1 = this.hash2;
                  this.key1 = this.key2;
                  this.value1 = this.value2;
                  this.hash2 = 0;
                  this.key2 = null;
                  this.value2 = null;
                  this.size = 1;
                  return old;
               }

               return null;
            case 3:
               if (this.key3 == null) {
                  old = this.value3;
                  this.hash3 = 0;
                  this.key3 = null;
                  this.value3 = null;
                  this.size = 2;
                  return old;
               }

               if (this.key2 == null) {
                  old = this.value2;
                  this.hash2 = this.hash3;
                  this.key2 = this.key3;
                  this.value2 = this.value3;
                  this.hash3 = 0;
                  this.key3 = null;
                  this.value3 = null;
                  this.size = 2;
                  return old;
               }

               if (this.key1 == null) {
                  old = this.value1;
                  this.hash1 = this.hash3;
                  this.key1 = this.key3;
                  this.value1 = this.value3;
                  this.hash3 = 0;
                  this.key3 = null;
                  this.value3 = null;
                  this.size = 2;
                  return old;
               }

               return null;
            }
         } else if (this.size > 0) {
            int hashCode = key.hashCode();
            Object old;
            switch(this.size) {
            case 1:
               if (this.hash1 == hashCode && key.equals(this.key1)) {
                  old = this.value1;
                  this.hash1 = 0;
                  this.key1 = null;
                  this.value1 = null;
                  this.size = 0;
                  return old;
               }
               break;
            case 2:
               if (this.hash2 == hashCode && key.equals(this.key2)) {
                  old = this.value2;
                  this.hash2 = 0;
                  this.key2 = null;
                  this.value2 = null;
                  this.size = 1;
                  return old;
               }

               if (this.hash1 == hashCode && key.equals(this.key1)) {
                  old = this.value1;
                  this.hash1 = this.hash2;
                  this.key1 = this.key2;
                  this.value1 = this.value2;
                  this.hash2 = 0;
                  this.key2 = null;
                  this.value2 = null;
                  this.size = 1;
                  return old;
               }

               return null;
            case 3:
               if (this.hash3 == hashCode && key.equals(this.key3)) {
                  old = this.value3;
                  this.hash3 = 0;
                  this.key3 = null;
                  this.value3 = null;
                  this.size = 2;
                  return old;
               }

               if (this.hash2 == hashCode && key.equals(this.key2)) {
                  old = this.value2;
                  this.hash2 = this.hash3;
                  this.key2 = this.key3;
                  this.value2 = this.value3;
                  this.hash3 = 0;
                  this.key3 = null;
                  this.value3 = null;
                  this.size = 2;
                  return old;
               }

               if (this.hash1 == hashCode && key.equals(this.key1)) {
                  old = this.value1;
                  this.hash1 = this.hash3;
                  this.key1 = this.key3;
                  this.value1 = this.value3;
                  this.hash3 = 0;
                  this.key3 = null;
                  this.value3 = null;
                  this.size = 2;
                  return old;
               }

               return null;
            }
         }

         return null;
      }
   }

   public void clear() {
      if (this.delegateMap != null) {
         this.delegateMap.clear();
         this.delegateMap = null;
      } else {
         this.size = 0;
         this.hash1 = this.hash2 = this.hash3 = 0;
         this.key1 = this.key2 = this.key3 = null;
         this.value1 = this.value2 = this.value3 = null;
      }

   }

   public MapIterator mapIterator() {
      if (this.delegateMap != null) {
         return this.delegateMap.mapIterator();
      } else {
         return (MapIterator)(this.size == 0 ? EmptyMapIterator.emptyMapIterator() : new Flat3Map.FlatMapIterator(this));
      }
   }

   public Set entrySet() {
      return (Set)(this.delegateMap != null ? this.delegateMap.entrySet() : new Flat3Map.EntrySet(this));
   }

   public Set keySet() {
      return (Set)(this.delegateMap != null ? this.delegateMap.keySet() : new Flat3Map.KeySet(this));
   }

   public Collection values() {
      return (Collection)(this.delegateMap != null ? this.delegateMap.values() : new Flat3Map.Values(this));
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeInt(this.size());
      MapIterator it = this.mapIterator();

      while(it.hasNext()) {
         out.writeObject(it.next());
         out.writeObject(it.getValue());
      }

   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      int count = in.readInt();
      if (count > 3) {
         this.delegateMap = this.createDelegateMap();
      }

      for(int i = count; i > 0; --i) {
         this.put(in.readObject(), in.readObject());
      }

   }

   public Flat3Map clone() {
      try {
         Flat3Map cloned = (Flat3Map)super.clone();
         if (cloned.delegateMap != null) {
            cloned.delegateMap = cloned.delegateMap.clone();
         }

         return cloned;
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (this.delegateMap != null) {
         return this.delegateMap.equals(obj);
      } else if (!(obj instanceof Map)) {
         return false;
      } else {
         Map other = (Map)obj;
         if (this.size != other.size()) {
            return false;
         } else if (this.size > 0) {
            Object otherValue = null;
            switch(this.size) {
            case 3:
               if (!other.containsKey(this.key3)) {
                  return false;
               }

               otherValue = other.get(this.key3);
               if (this.value3 == null) {
                  if (otherValue != null) {
                     return false;
                  }
               } else if (!this.value3.equals(otherValue)) {
                  return false;
               }
            case 2:
               if (!other.containsKey(this.key2)) {
                  return false;
               }

               otherValue = other.get(this.key2);
               if (this.value2 == null) {
                  if (otherValue != null) {
                     break;
                  }
               } else if (!this.value2.equals(otherValue)) {
                  break;
               }
            case 1:
               if (!other.containsKey(this.key1)) {
                  return false;
               }

               otherValue = other.get(this.key1);
               if (this.value1 == null) {
                  if (otherValue == null) {
                     return true;
                  }
               } else if (this.value1.equals(otherValue)) {
                  return true;
               }

               return false;
            default:
               return true;
            }

            return false;
         } else {
            return true;
         }
      }
   }

   public int hashCode() {
      if (this.delegateMap != null) {
         return this.delegateMap.hashCode();
      } else {
         int total = 0;
         switch(this.size) {
         case 3:
            total += this.hash3 ^ (this.value3 == null ? 0 : this.value3.hashCode());
         case 2:
            total += this.hash2 ^ (this.value2 == null ? 0 : this.value2.hashCode());
         case 1:
            total += this.hash1 ^ (this.value1 == null ? 0 : this.value1.hashCode());
         case 0:
            return total;
         default:
            throw new IllegalStateException("Invalid map index: " + this.size);
         }
      }
   }

   public String toString() {
      if (this.delegateMap != null) {
         return this.delegateMap.toString();
      } else if (this.size == 0) {
         return "{}";
      } else {
         StringBuilder buf = new StringBuilder(128);
         buf.append('{');
         switch(this.size) {
         case 3:
            buf.append(this.key3 == this ? "(this Map)" : this.key3);
            buf.append('=');
            buf.append(this.value3 == this ? "(this Map)" : this.value3);
            buf.append(',');
         case 2:
            buf.append(this.key2 == this ? "(this Map)" : this.key2);
            buf.append('=');
            buf.append(this.value2 == this ? "(this Map)" : this.value2);
            buf.append(',');
         case 1:
            buf.append(this.key1 == this ? "(this Map)" : this.key1);
            buf.append('=');
            buf.append(this.value1 == this ? "(this Map)" : this.value1);
            buf.append('}');
            return buf.toString();
         default:
            throw new IllegalStateException("Invalid map index: " + this.size);
         }
      }
   }

   static class ValuesIterator extends Flat3Map.EntryIterator implements Iterator {
      ValuesIterator(Flat3Map parent) {
         super(parent);
      }

      public Object next() {
         return this.nextEntry().getValue();
      }
   }

   static class Values extends AbstractCollection {
      private final Flat3Map parent;

      Values(Flat3Map parent) {
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
         if (this.parent.delegateMap != null) {
            return this.parent.delegateMap.values().iterator();
         } else {
            return (Iterator)(this.parent.size() == 0 ? EmptyIterator.emptyIterator() : new Flat3Map.ValuesIterator(this.parent));
         }
      }
   }

   static class KeySetIterator extends Flat3Map.EntryIterator implements Iterator {
      KeySetIterator(Flat3Map parent) {
         super(parent);
      }

      public Object next() {
         return this.nextEntry().getKey();
      }
   }

   static class KeySet extends AbstractSet {
      private final Flat3Map parent;

      KeySet(Flat3Map parent) {
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
         if (this.parent.delegateMap != null) {
            return this.parent.delegateMap.keySet().iterator();
         } else {
            return (Iterator)(this.parent.size() == 0 ? EmptyIterator.emptyIterator() : new Flat3Map.KeySetIterator(this.parent));
         }
      }
   }

   static class EntrySetIterator extends Flat3Map.EntryIterator implements Iterator {
      EntrySetIterator(Flat3Map parent) {
         super(parent);
      }

      public Entry next() {
         return this.nextEntry();
      }
   }

   abstract static class EntryIterator {
      private final Flat3Map parent;
      private int nextIndex = 0;
      private Flat3Map.FlatMapEntry currentEntry = null;

      public EntryIterator(Flat3Map parent) {
         this.parent = parent;
      }

      public boolean hasNext() {
         return this.nextIndex < this.parent.size;
      }

      public Entry nextEntry() {
         if (!this.hasNext()) {
            throw new NoSuchElementException("No next() entry in the iteration");
         } else {
            this.currentEntry = new Flat3Map.FlatMapEntry(this.parent, ++this.nextIndex);
            return this.currentEntry;
         }
      }

      public void remove() {
         if (this.currentEntry == null) {
            throw new IllegalStateException("remove() can only be called once after next()");
         } else {
            this.currentEntry.setRemoved(true);
            this.parent.remove(this.currentEntry.getKey());
            --this.nextIndex;
            this.currentEntry = null;
         }
      }
   }

   static class FlatMapEntry implements Entry {
      private final Flat3Map parent;
      private final int index;
      private volatile boolean removed;

      public FlatMapEntry(Flat3Map parent, int index) {
         this.parent = parent;
         this.index = index;
         this.removed = false;
      }

      void setRemoved(boolean flag) {
         this.removed = flag;
      }

      public Object getKey() {
         if (this.removed) {
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
         } else {
            switch(this.index) {
            case 1:
               return this.parent.key1;
            case 2:
               return this.parent.key2;
            case 3:
               return this.parent.key3;
            default:
               throw new IllegalStateException("Invalid map index: " + this.index);
            }
         }
      }

      public Object getValue() {
         if (this.removed) {
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
         } else {
            switch(this.index) {
            case 1:
               return this.parent.value1;
            case 2:
               return this.parent.value2;
            case 3:
               return this.parent.value3;
            default:
               throw new IllegalStateException("Invalid map index: " + this.index);
            }
         }
      }

      public Object setValue(Object value) {
         if (this.removed) {
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
         } else {
            Object old = this.getValue();
            switch(this.index) {
            case 1:
               this.parent.value1 = value;
               break;
            case 2:
               this.parent.value2 = value;
               break;
            case 3:
               this.parent.value3 = value;
               break;
            default:
               throw new IllegalStateException("Invalid map index: " + this.index);
            }

            return old;
         }
      }

      public boolean equals(Object obj) {
         if (this.removed) {
            return false;
         } else if (!(obj instanceof Entry)) {
            return false;
         } else {
            boolean var10000;
            label43: {
               label29: {
                  Entry other = (Entry)obj;
                  Object key = this.getKey();
                  Object value = this.getValue();
                  if (key == null) {
                     if (other.getKey() != null) {
                        break label29;
                     }
                  } else if (!key.equals(other.getKey())) {
                     break label29;
                  }

                  if (value == null) {
                     if (other.getValue() == null) {
                        break label43;
                     }
                  } else if (value.equals(other.getValue())) {
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
         if (this.removed) {
            return 0;
         } else {
            Object key = this.getKey();
            Object value = this.getValue();
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
         }
      }

      public String toString() {
         return !this.removed ? this.getKey() + "=" + this.getValue() : "";
      }
   }

   static class EntrySet extends AbstractSet {
      private final Flat3Map parent;

      EntrySet(Flat3Map parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.size();
      }

      public void clear() {
         this.parent.clear();
      }

      public boolean remove(Object obj) {
         if (!(obj instanceof Entry)) {
            return false;
         } else {
            Entry entry = (Entry)obj;
            Object key = entry.getKey();
            boolean result = this.parent.containsKey(key);
            this.parent.remove(key);
            return result;
         }
      }

      public Iterator iterator() {
         if (this.parent.delegateMap != null) {
            return this.parent.delegateMap.entrySet().iterator();
         } else {
            return (Iterator)(this.parent.size() == 0 ? EmptyIterator.emptyIterator() : new Flat3Map.EntrySetIterator(this.parent));
         }
      }
   }

   static class FlatMapIterator implements MapIterator, ResettableIterator {
      private final Flat3Map parent;
      private int nextIndex = 0;
      private boolean canRemove = false;

      FlatMapIterator(Flat3Map parent) {
         this.parent = parent;
      }

      public boolean hasNext() {
         return this.nextIndex < this.parent.size;
      }

      public Object next() {
         if (!this.hasNext()) {
            throw new NoSuchElementException("No next() entry in the iteration");
         } else {
            this.canRemove = true;
            ++this.nextIndex;
            return this.getKey();
         }
      }

      public void remove() {
         if (!this.canRemove) {
            throw new IllegalStateException("remove() can only be called once after next()");
         } else {
            this.parent.remove(this.getKey());
            --this.nextIndex;
            this.canRemove = false;
         }
      }

      public Object getKey() {
         if (!this.canRemove) {
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
         } else {
            switch(this.nextIndex) {
            case 1:
               return this.parent.key1;
            case 2:
               return this.parent.key2;
            case 3:
               return this.parent.key3;
            default:
               throw new IllegalStateException("Invalid map index: " + this.nextIndex);
            }
         }
      }

      public Object getValue() {
         if (!this.canRemove) {
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
         } else {
            switch(this.nextIndex) {
            case 1:
               return this.parent.value1;
            case 2:
               return this.parent.value2;
            case 3:
               return this.parent.value3;
            default:
               throw new IllegalStateException("Invalid map index: " + this.nextIndex);
            }
         }
      }

      public Object setValue(Object value) {
         if (!this.canRemove) {
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
         } else {
            Object old = this.getValue();
            switch(this.nextIndex) {
            case 1:
               this.parent.value1 = value;
               break;
            case 2:
               this.parent.value2 = value;
               break;
            case 3:
               this.parent.value3 = value;
               break;
            default:
               throw new IllegalStateException("Invalid map index: " + this.nextIndex);
            }

            return old;
         }
      }

      public void reset() {
         this.nextIndex = 0;
         this.canRemove = false;
      }

      public String toString() {
         return this.canRemove ? "Iterator[" + this.getKey() + "=" + this.getValue() + "]" : "Iterator[]";
      }
   }
}
