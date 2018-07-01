package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;

public class MultiKeyMap extends AbstractMapDecorator implements Serializable, Cloneable {
   private static final long serialVersionUID = -1788199231038721040L;

   public static MultiKeyMap multiKeyMap(AbstractHashedMap map) {
      if (map == null) {
         throw new NullPointerException("Map must not be null");
      } else if (map.size() > 0) {
         throw new IllegalArgumentException("Map must be empty");
      } else {
         return new MultiKeyMap(map);
      }
   }

   public MultiKeyMap() {
      this(new HashedMap());
   }

   protected MultiKeyMap(AbstractHashedMap map) {
      super(map);
      this.map = map;
   }

   public Object get(Object key1, Object key2) {
      int hashCode = this.hash(key1, key2);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2)) {
            return entry.getValue();
         }
      }

      return null;
   }

   public boolean containsKey(Object key1, Object key2) {
      int hashCode = this.hash(key1, key2);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2)) {
            return true;
         }
      }

      return false;
   }

   public Object put(Object key1, Object key2, Object value) {
      int hashCode = this.hash(key1, key2);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[index]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2)) {
            Object oldValue = entry.getValue();
            this.decorated().updateEntry(entry, value);
            return oldValue;
         }
      }

      this.decorated().addMapping(index, hashCode, new MultiKey(key1, key2), value);
      return null;
   }

   public Object removeMultiKey(Object key1, Object key2) {
      int hashCode = this.hash(key1, key2);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);
      AbstractHashedMap.HashEntry entry = this.decorated().data[index];

      for(AbstractHashedMap.HashEntry previous = null; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2)) {
            Object oldValue = entry.getValue();
            this.decorated().removeMapping(entry, index, previous);
            return oldValue;
         }

         previous = entry;
      }

      return null;
   }

   protected int hash(Object key1, Object key2) {
      int h = 0;
      if (key1 != null) {
         h ^= key1.hashCode();
      }

      if (key2 != null) {
         h ^= key2.hashCode();
      }

      h += ~(h << 9);
      h ^= h >>> 14;
      h += h << 4;
      h ^= h >>> 10;
      return h;
   }

   protected boolean isEqualKey(AbstractHashedMap.HashEntry entry, Object key1, Object key2) {
      MultiKey multi = (MultiKey)entry.getKey();
      return multi.size() == 2 && (key1 == multi.getKey(0) || key1 != null && key1.equals(multi.getKey(0))) && (key2 == multi.getKey(1) || key2 != null && key2.equals(multi.getKey(1)));
   }

   public Object get(Object key1, Object key2, Object key3) {
      int hashCode = this.hash(key1, key2, key3);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3)) {
            return entry.getValue();
         }
      }

      return null;
   }

   public boolean containsKey(Object key1, Object key2, Object key3) {
      int hashCode = this.hash(key1, key2, key3);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3)) {
            return true;
         }
      }

      return false;
   }

   public Object put(Object key1, Object key2, Object key3, Object value) {
      int hashCode = this.hash(key1, key2, key3);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[index]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3)) {
            Object oldValue = entry.getValue();
            this.decorated().updateEntry(entry, value);
            return oldValue;
         }
      }

      this.decorated().addMapping(index, hashCode, new MultiKey(key1, key2, key3), value);
      return null;
   }

   public Object removeMultiKey(Object key1, Object key2, Object key3) {
      int hashCode = this.hash(key1, key2, key3);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);
      AbstractHashedMap.HashEntry entry = this.decorated().data[index];

      for(AbstractHashedMap.HashEntry previous = null; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3)) {
            Object oldValue = entry.getValue();
            this.decorated().removeMapping(entry, index, previous);
            return oldValue;
         }

         previous = entry;
      }

      return null;
   }

   protected int hash(Object key1, Object key2, Object key3) {
      int h = 0;
      if (key1 != null) {
         h ^= key1.hashCode();
      }

      if (key2 != null) {
         h ^= key2.hashCode();
      }

      if (key3 != null) {
         h ^= key3.hashCode();
      }

      h += ~(h << 9);
      h ^= h >>> 14;
      h += h << 4;
      h ^= h >>> 10;
      return h;
   }

   protected boolean isEqualKey(AbstractHashedMap.HashEntry entry, Object key1, Object key2, Object key3) {
      MultiKey multi = (MultiKey)entry.getKey();
      return multi.size() == 3 && (key1 == multi.getKey(0) || key1 != null && key1.equals(multi.getKey(0))) && (key2 == multi.getKey(1) || key2 != null && key2.equals(multi.getKey(1))) && (key3 == multi.getKey(2) || key3 != null && key3.equals(multi.getKey(2)));
   }

   public Object get(Object key1, Object key2, Object key3, Object key4) {
      int hashCode = this.hash(key1, key2, key3, key4);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4)) {
            return entry.getValue();
         }
      }

      return null;
   }

   public boolean containsKey(Object key1, Object key2, Object key3, Object key4) {
      int hashCode = this.hash(key1, key2, key3, key4);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4)) {
            return true;
         }
      }

      return false;
   }

   public Object put(Object key1, Object key2, Object key3, Object key4, Object value) {
      int hashCode = this.hash(key1, key2, key3, key4);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[index]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4)) {
            Object oldValue = entry.getValue();
            this.decorated().updateEntry(entry, value);
            return oldValue;
         }
      }

      this.decorated().addMapping(index, hashCode, new MultiKey(key1, key2, key3, key4), value);
      return null;
   }

   public Object removeMultiKey(Object key1, Object key2, Object key3, Object key4) {
      int hashCode = this.hash(key1, key2, key3, key4);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);
      AbstractHashedMap.HashEntry entry = this.decorated().data[index];

      for(AbstractHashedMap.HashEntry previous = null; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4)) {
            Object oldValue = entry.getValue();
            this.decorated().removeMapping(entry, index, previous);
            return oldValue;
         }

         previous = entry;
      }

      return null;
   }

   protected int hash(Object key1, Object key2, Object key3, Object key4) {
      int h = 0;
      if (key1 != null) {
         h ^= key1.hashCode();
      }

      if (key2 != null) {
         h ^= key2.hashCode();
      }

      if (key3 != null) {
         h ^= key3.hashCode();
      }

      if (key4 != null) {
         h ^= key4.hashCode();
      }

      h += ~(h << 9);
      h ^= h >>> 14;
      h += h << 4;
      h ^= h >>> 10;
      return h;
   }

   protected boolean isEqualKey(AbstractHashedMap.HashEntry entry, Object key1, Object key2, Object key3, Object key4) {
      MultiKey multi = (MultiKey)entry.getKey();
      return multi.size() == 4 && (key1 == multi.getKey(0) || key1 != null && key1.equals(multi.getKey(0))) && (key2 == multi.getKey(1) || key2 != null && key2.equals(multi.getKey(1))) && (key3 == multi.getKey(2) || key3 != null && key3.equals(multi.getKey(2))) && (key4 == multi.getKey(3) || key4 != null && key4.equals(multi.getKey(3)));
   }

   public Object get(Object key1, Object key2, Object key3, Object key4, Object key5) {
      int hashCode = this.hash(key1, key2, key3, key4, key5);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4, key5)) {
            return entry.getValue();
         }
      }

      return null;
   }

   public boolean containsKey(Object key1, Object key2, Object key3, Object key4, Object key5) {
      int hashCode = this.hash(key1, key2, key3, key4, key5);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[this.decorated().hashIndex(hashCode, this.decorated().data.length)]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4, key5)) {
            return true;
         }
      }

      return false;
   }

   public Object put(Object key1, Object key2, Object key3, Object key4, Object key5, Object value) {
      int hashCode = this.hash(key1, key2, key3, key4, key5);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);

      for(AbstractHashedMap.HashEntry entry = this.decorated().data[index]; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4, key5)) {
            Object oldValue = entry.getValue();
            this.decorated().updateEntry(entry, value);
            return oldValue;
         }
      }

      this.decorated().addMapping(index, hashCode, new MultiKey(key1, key2, key3, key4, key5), value);
      return null;
   }

   public Object removeMultiKey(Object key1, Object key2, Object key3, Object key4, Object key5) {
      int hashCode = this.hash(key1, key2, key3, key4, key5);
      int index = this.decorated().hashIndex(hashCode, this.decorated().data.length);
      AbstractHashedMap.HashEntry entry = this.decorated().data[index];

      for(AbstractHashedMap.HashEntry previous = null; entry != null; entry = entry.next) {
         if (entry.hashCode == hashCode && this.isEqualKey(entry, key1, key2, key3, key4, key5)) {
            Object oldValue = entry.getValue();
            this.decorated().removeMapping(entry, index, previous);
            return oldValue;
         }

         previous = entry;
      }

      return null;
   }

   protected int hash(Object key1, Object key2, Object key3, Object key4, Object key5) {
      int h = 0;
      if (key1 != null) {
         h ^= key1.hashCode();
      }

      if (key2 != null) {
         h ^= key2.hashCode();
      }

      if (key3 != null) {
         h ^= key3.hashCode();
      }

      if (key4 != null) {
         h ^= key4.hashCode();
      }

      if (key5 != null) {
         h ^= key5.hashCode();
      }

      h += ~(h << 9);
      h ^= h >>> 14;
      h += h << 4;
      h ^= h >>> 10;
      return h;
   }

   protected boolean isEqualKey(AbstractHashedMap.HashEntry entry, Object key1, Object key2, Object key3, Object key4, Object key5) {
      MultiKey multi = (MultiKey)entry.getKey();
      return multi.size() == 5 && (key1 == multi.getKey(0) || key1 != null && key1.equals(multi.getKey(0))) && (key2 == multi.getKey(1) || key2 != null && key2.equals(multi.getKey(1))) && (key3 == multi.getKey(2) || key3 != null && key3.equals(multi.getKey(2))) && (key4 == multi.getKey(3) || key4 != null && key4.equals(multi.getKey(3))) && (key5 == multi.getKey(4) || key5 != null && key5.equals(multi.getKey(4)));
   }

   public boolean removeAll(Object key1) {
      boolean modified = false;
      MapIterator it = this.mapIterator();

      while(true) {
         while(true) {
            MultiKey multi;
            do {
               if (!it.hasNext()) {
                  return modified;
               }

               multi = (MultiKey)it.next();
            } while(multi.size() < 1);

            if (key1 == null) {
               if (multi.getKey(0) == null) {
                  break;
               }
            } else if (key1.equals(multi.getKey(0))) {
               break;
            }
         }

         it.remove();
         modified = true;
      }
   }

   public boolean removeAll(Object key1, Object key2) {
      boolean modified = false;
      MapIterator it = this.mapIterator();

      while(true) {
         while(true) {
            MultiKey multi;
            while(true) {
               do {
                  if (!it.hasNext()) {
                     return modified;
                  }

                  multi = (MultiKey)it.next();
               } while(multi.size() < 2);

               if (key1 == null) {
                  if (multi.getKey(0) == null) {
                     break;
                  }
               } else if (key1.equals(multi.getKey(0))) {
                  break;
               }
            }

            if (key2 == null) {
               if (multi.getKey(1) == null) {
                  break;
               }
            } else if (key2.equals(multi.getKey(1))) {
               break;
            }
         }

         it.remove();
         modified = true;
      }
   }

   public boolean removeAll(Object key1, Object key2, Object key3) {
      boolean modified = false;
      MapIterator it = this.mapIterator();

      while(true) {
         while(true) {
            MultiKey multi;
            while(true) {
               while(true) {
                  do {
                     if (!it.hasNext()) {
                        return modified;
                     }

                     multi = (MultiKey)it.next();
                  } while(multi.size() < 3);

                  if (key1 == null) {
                     if (multi.getKey(0) == null) {
                        break;
                     }
                  } else if (key1.equals(multi.getKey(0))) {
                     break;
                  }
               }

               if (key2 == null) {
                  if (multi.getKey(1) == null) {
                     break;
                  }
               } else if (key2.equals(multi.getKey(1))) {
                  break;
               }
            }

            if (key3 == null) {
               if (multi.getKey(2) == null) {
                  break;
               }
            } else if (key3.equals(multi.getKey(2))) {
               break;
            }
         }

         it.remove();
         modified = true;
      }
   }

   public boolean removeAll(Object key1, Object key2, Object key3, Object key4) {
      boolean modified = false;
      MapIterator it = this.mapIterator();

      while(true) {
         while(true) {
            MultiKey multi;
            while(true) {
               while(true) {
                  while(true) {
                     do {
                        if (!it.hasNext()) {
                           return modified;
                        }

                        multi = (MultiKey)it.next();
                     } while(multi.size() < 4);

                     if (key1 == null) {
                        if (multi.getKey(0) == null) {
                           break;
                        }
                     } else if (key1.equals(multi.getKey(0))) {
                        break;
                     }
                  }

                  if (key2 == null) {
                     if (multi.getKey(1) == null) {
                        break;
                     }
                  } else if (key2.equals(multi.getKey(1))) {
                     break;
                  }
               }

               if (key3 == null) {
                  if (multi.getKey(2) == null) {
                     break;
                  }
               } else if (key3.equals(multi.getKey(2))) {
                  break;
               }
            }

            if (key4 == null) {
               if (multi.getKey(3) == null) {
                  break;
               }
            } else if (key4.equals(multi.getKey(3))) {
               break;
            }
         }

         it.remove();
         modified = true;
      }
   }

   protected void checkKey(MultiKey key) {
      if (key == null) {
         throw new NullPointerException("Key must not be null");
      }
   }

   public MultiKeyMap clone() {
      try {
         return (MultiKeyMap)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   public Object put(MultiKey key, Object value) {
      this.checkKey(key);
      return super.put(key, value);
   }

   public void putAll(Map mapToCopy) {
      Iterator i$ = mapToCopy.keySet().iterator();

      while(i$.hasNext()) {
         MultiKey key = (MultiKey)i$.next();
         this.checkKey(key);
      }

      super.putAll(mapToCopy);
   }

   public MapIterator mapIterator() {
      return this.decorated().mapIterator();
   }

   protected AbstractHashedMap decorated() {
      return (AbstractHashedMap)super.decorated();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.map);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }
}
