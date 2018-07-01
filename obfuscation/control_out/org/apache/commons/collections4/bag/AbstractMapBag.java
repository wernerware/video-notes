package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;

public abstract class AbstractMapBag implements Bag {
   private transient Map map;
   private int size;
   private transient int modCount;
   private transient Set uniqueSet;

   protected AbstractMapBag() {
   }

   protected AbstractMapBag(Map map) {
      this.map = map;
   }

   protected Map getMap() {
      return this.map;
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.map.isEmpty();
   }

   public int getCount(Object object) {
      AbstractMapBag.MutableInteger count = (AbstractMapBag.MutableInteger)this.map.get(object);
      return count != null ? count.value : 0;
   }

   public boolean contains(Object object) {
      return this.map.containsKey(object);
   }

   public boolean containsAll(Collection coll) {
      return coll instanceof Bag ? this.containsAll((Bag)coll) : this.containsAll((Bag)(new HashBag(coll)));
   }

   boolean containsAll(Bag other) {
      Iterator it = other.uniqueSet().iterator();

      Object current;
      do {
         if (!it.hasNext()) {
            return true;
         }

         current = it.next();
      } while(this.getCount(current) >= other.getCount(current));

      return false;
   }

   public Iterator iterator() {
      return new AbstractMapBag.BagIterator(this);
   }

   public boolean add(Object object) {
      return this.add(object, 1);
   }

   public boolean add(Object object, int nCopies) {
      ++this.modCount;
      if (nCopies > 0) {
         AbstractMapBag.MutableInteger mut = (AbstractMapBag.MutableInteger)this.map.get(object);
         this.size += nCopies;
         if (mut == null) {
            this.map.put(object, new AbstractMapBag.MutableInteger(nCopies));
            return true;
         } else {
            mut.value += nCopies;
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean addAll(Collection coll) {
      boolean changed = false;

      boolean added;
      for(Iterator i = coll.iterator(); i.hasNext(); changed = changed || added) {
         added = this.add(i.next());
      }

      return changed;
   }

   public void clear() {
      ++this.modCount;
      this.map.clear();
      this.size = 0;
   }

   public boolean remove(Object object) {
      AbstractMapBag.MutableInteger mut = (AbstractMapBag.MutableInteger)this.map.get(object);
      if (mut == null) {
         return false;
      } else {
         ++this.modCount;
         this.map.remove(object);
         this.size -= mut.value;
         return true;
      }
   }

   public boolean remove(Object object, int nCopies) {
      AbstractMapBag.MutableInteger mut = (AbstractMapBag.MutableInteger)this.map.get(object);
      if (mut == null) {
         return false;
      } else if (nCopies <= 0) {
         return false;
      } else {
         ++this.modCount;
         if (nCopies < mut.value) {
            mut.value -= nCopies;
            this.size -= nCopies;
         } else {
            this.map.remove(object);
            this.size -= mut.value;
         }

         return true;
      }
   }

   public boolean removeAll(Collection coll) {
      boolean result = false;
      boolean changed;
      if (coll != null) {
         for(Iterator i = coll.iterator(); i.hasNext(); result = result || changed) {
            changed = this.remove(i.next(), 1);
         }
      }

      return result;
   }

   public boolean retainAll(Collection coll) {
      return coll instanceof Bag ? this.retainAll((Bag)coll) : this.retainAll((Bag)(new HashBag(coll)));
   }

   boolean retainAll(Bag other) {
      boolean result = false;
      Bag excess = new HashBag();
      Iterator i = this.uniqueSet().iterator();

      while(true) {
         while(i.hasNext()) {
            Object current = i.next();
            int myCount = this.getCount(current);
            int otherCount = other.getCount(current);
            if (1 <= otherCount && otherCount <= myCount) {
               excess.add(current, myCount - otherCount);
            } else {
               excess.add(current, myCount);
            }
         }

         if (!excess.isEmpty()) {
            result = this.removeAll(excess);
         }

         return result;
      }
   }

   public Object[] toArray() {
      Object[] result = new Object[this.size()];
      int i = 0;
      Iterator it = this.map.keySet().iterator();

      while(it.hasNext()) {
         Object current = it.next();

         for(int index = this.getCount(current); index > 0; --index) {
            result[i++] = current;
         }
      }

      return result;
   }

   public Object[] toArray(Object[] array) {
      int size = this.size();
      if (array.length < size) {
         Object[] unchecked = (Object[])((Object[])Array.newInstance(array.getClass().getComponentType(), size));
         array = unchecked;
      }

      int i = 0;
      Iterator it = this.map.keySet().iterator();

      while(it.hasNext()) {
         Object current = it.next();

         for(int index = this.getCount(current); index > 0; --index) {
            array[i++] = current;
         }
      }

      while(i < array.length) {
         array[i++] = null;
      }

      return array;
   }

   public Set uniqueSet() {
      if (this.uniqueSet == null) {
         this.uniqueSet = UnmodifiableSet.unmodifiableSet(this.map.keySet());
      }

      return this.uniqueSet;
   }

   protected void doWriteObject(ObjectOutputStream out) throws IOException {
      out.writeInt(this.map.size());
      Iterator i$ = this.map.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         out.writeObject(entry.getKey());
         out.writeInt(((AbstractMapBag.MutableInteger)entry.getValue()).value);
      }

   }

   protected void doReadObject(Map map, ObjectInputStream in) throws IOException, ClassNotFoundException {
      this.map = map;
      int entrySize = in.readInt();

      for(int i = 0; i < entrySize; ++i) {
         Object obj = in.readObject();
         int count = in.readInt();
         map.put(obj, new AbstractMapBag.MutableInteger(count));
         this.size += count;
      }

   }

   public boolean equals(Object object) {
      if (object == this) {
         return true;
      } else if (!(object instanceof Bag)) {
         return false;
      } else {
         Bag other = (Bag)object;
         if (other.size() != this.size()) {
            return false;
         } else {
            Iterator i$ = this.map.keySet().iterator();

            Object element;
            do {
               if (!i$.hasNext()) {
                  return true;
               }

               element = i$.next();
            } while(other.getCount(element) == this.getCount(element));

            return false;
         }
      }
   }

   public int hashCode() {
      int total = 0;

      Object element;
      AbstractMapBag.MutableInteger count;
      for(Iterator i$ = this.map.entrySet().iterator(); i$.hasNext(); total += (element == null ? 0 : element.hashCode()) ^ count.value) {
         Entry entry = (Entry)i$.next();
         element = entry.getKey();
         count = (AbstractMapBag.MutableInteger)entry.getValue();
      }

      return total;
   }

   public String toString() {
      if (this.size() == 0) {
         return "[]";
      } else {
         StringBuilder buf = new StringBuilder();
         buf.append('[');
         Iterator it = this.uniqueSet().iterator();

         while(it.hasNext()) {
            Object current = it.next();
            int count = this.getCount(current);
            buf.append(count);
            buf.append(':');
            buf.append(current);
            if (it.hasNext()) {
               buf.append(',');
            }
         }

         buf.append(']');
         return buf.toString();
      }
   }

   protected static class MutableInteger {
      protected int value;

      MutableInteger(int value) {
         this.value = value;
      }

      public boolean equals(Object obj) {
         if (!(obj instanceof AbstractMapBag.MutableInteger)) {
            return false;
         } else {
            return ((AbstractMapBag.MutableInteger)obj).value == this.value;
         }
      }

      public int hashCode() {
         return this.value;
      }
   }

   static class BagIterator implements Iterator {
      private final AbstractMapBag parent;
      private final Iterator entryIterator;
      private Entry current;
      private int itemCount;
      private final int mods;
      private boolean canRemove;

      public BagIterator(AbstractMapBag parent) {
         this.parent = parent;
         this.entryIterator = parent.map.entrySet().iterator();
         this.current = null;
         this.mods = parent.modCount;
         this.canRemove = false;
      }

      public boolean hasNext() {
         return this.itemCount > 0 || this.entryIterator.hasNext();
      }

      public Object next() {
         if (this.parent.modCount != this.mods) {
            throw new ConcurrentModificationException();
         } else {
            if (this.itemCount == 0) {
               this.current = (Entry)this.entryIterator.next();
               this.itemCount = ((AbstractMapBag.MutableInteger)this.current.getValue()).value;
            }

            this.canRemove = true;
            --this.itemCount;
            return this.current.getKey();
         }
      }

      public void remove() {
         if (this.parent.modCount != this.mods) {
            throw new ConcurrentModificationException();
         } else if (!this.canRemove) {
            throw new IllegalStateException();
         } else {
            AbstractMapBag.MutableInteger mut = (AbstractMapBag.MutableInteger)this.current.getValue();
            if (mut.value > 1) {
               --mut.value;
            } else {
               this.entryIterator.remove();
            }

            this.parent.size--;
            this.canRemove = false;
         }
      }
   }
}
