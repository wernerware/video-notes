package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Transformer;

public abstract class AbstractMultiSet extends AbstractCollection implements MultiSet {
   private transient Set uniqueSet;
   private transient Set entrySet;

   public int size() {
      int totalSize = 0;

      MultiSet.Entry entry;
      for(Iterator i$ = this.entrySet().iterator(); i$.hasNext(); totalSize += entry.getCount()) {
         entry = (MultiSet.Entry)i$.next();
      }

      return totalSize;
   }

   public int getCount(Object object) {
      Iterator i$ = this.entrySet().iterator();

      MultiSet.Entry entry;
      Object element;
      do {
         if (!i$.hasNext()) {
            return 0;
         }

         entry = (MultiSet.Entry)i$.next();
         element = entry.getElement();
      } while(element != object && (element == null || !element.equals(object)));

      return entry.getCount();
   }

   public int setCount(Object object, int count) {
      if (count < 0) {
         throw new IllegalArgumentException("Count must not be negative.");
      } else {
         int oldCount = this.getCount(object);
         if (oldCount < count) {
            this.add(object, count - oldCount);
         } else {
            this.remove(object, oldCount - count);
         }

         return oldCount;
      }
   }

   public boolean contains(Object object) {
      return this.getCount(object) > 0;
   }

   public Iterator iterator() {
      return new AbstractMultiSet.MultiSetIterator(this);
   }

   public boolean add(Object object) {
      this.add(object, 1);
      return true;
   }

   public int add(Object object, int occurrences) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      Iterator it = this.entrySet().iterator();

      while(it.hasNext()) {
         it.next();
         it.remove();
      }

   }

   public boolean remove(Object object) {
      return this.remove(object, 1) != 0;
   }

   public int remove(Object object, int occurrences) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection coll) {
      boolean result = false;

      boolean changed;
      for(Iterator i = coll.iterator(); i.hasNext(); result = result || changed) {
         Object obj = i.next();
         changed = this.remove(obj, this.getCount(obj)) != 0;
      }

      return result;
   }

   public Set uniqueSet() {
      if (this.uniqueSet == null) {
         this.uniqueSet = this.createUniqueSet();
      }

      return this.uniqueSet;
   }

   protected Set createUniqueSet() {
      return new AbstractMultiSet.UniqueSet(this);
   }

   protected Iterator createUniqueSetIterator() {
      Transformer transformer = new Transformer() {
         public Object transform(MultiSet.Entry entry) {
            return entry.getElement();
         }
      };
      return IteratorUtils.transformedIterator(this.entrySet().iterator(), transformer);
   }

   public Set entrySet() {
      if (this.entrySet == null) {
         this.entrySet = this.createEntrySet();
      }

      return this.entrySet;
   }

   protected Set createEntrySet() {
      return new AbstractMultiSet.EntrySet(this);
   }

   protected abstract int uniqueElements();

   protected abstract Iterator createEntrySetIterator();

   protected void doWriteObject(ObjectOutputStream out) throws IOException {
      out.writeInt(this.entrySet().size());
      Iterator i$ = this.entrySet().iterator();

      while(i$.hasNext()) {
         MultiSet.Entry entry = (MultiSet.Entry)i$.next();
         out.writeObject(entry.getElement());
         out.writeInt(entry.getCount());
      }

   }

   protected void doReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      int entrySize = in.readInt();

      for(int i = 0; i < entrySize; ++i) {
         Object obj = in.readObject();
         int count = in.readInt();
         this.setCount(obj, count);
      }

   }

   public boolean equals(Object object) {
      if (object == this) {
         return true;
      } else if (!(object instanceof MultiSet)) {
         return false;
      } else {
         MultiSet other = (MultiSet)object;
         if (other.size() != this.size()) {
            return false;
         } else {
            Iterator i$ = this.entrySet().iterator();

            MultiSet.Entry entry;
            do {
               if (!i$.hasNext()) {
                  return true;
               }

               entry = (MultiSet.Entry)i$.next();
            } while(other.getCount(entry.getElement()) == this.getCount(entry.getElement()));

            return false;
         }
      }
   }

   public int hashCode() {
      return this.entrySet().hashCode();
   }

   public String toString() {
      return this.entrySet().toString();
   }

   protected abstract static class AbstractEntry implements MultiSet.Entry {
      public boolean equals(Object object) {
         if (!(object instanceof MultiSet.Entry)) {
            return false;
         } else {
            MultiSet.Entry other = (MultiSet.Entry)object;
            Object element = this.getElement();
            Object otherElement = other.getElement();
            return this.getCount() == other.getCount() && (element == otherElement || element != null && element.equals(otherElement));
         }
      }

      public int hashCode() {
         Object element = this.getElement();
         return (element == null ? 0 : element.hashCode()) ^ this.getCount();
      }

      public String toString() {
         return String.format("%s:%d", this.getElement(), this.getCount());
      }
   }

   protected static class EntrySet extends AbstractSet {
      private final AbstractMultiSet parent;

      protected EntrySet(AbstractMultiSet parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.uniqueElements();
      }

      public Iterator iterator() {
         return this.parent.createEntrySetIterator();
      }

      public boolean contains(Object obj) {
         if (!(obj instanceof MultiSet.Entry)) {
            return false;
         } else {
            MultiSet.Entry entry = (MultiSet.Entry)obj;
            Object element = entry.getElement();
            return this.parent.getCount(element) == entry.getCount();
         }
      }

      public boolean remove(Object obj) {
         if (!(obj instanceof MultiSet.Entry)) {
            return false;
         } else {
            MultiSet.Entry entry = (MultiSet.Entry)obj;
            Object element = entry.getElement();
            if (this.parent.contains(element)) {
               int count = this.parent.getCount(element);
               if (entry.getCount() == count) {
                  this.parent.remove(element, count);
                  return true;
               }
            }

            return false;
         }
      }
   }

   protected static class UniqueSet extends AbstractSet {
      protected final AbstractMultiSet parent;

      protected UniqueSet(AbstractMultiSet parent) {
         this.parent = parent;
      }

      public Iterator iterator() {
         return this.parent.createUniqueSetIterator();
      }

      public boolean contains(Object key) {
         return this.parent.contains(key);
      }

      public boolean containsAll(Collection coll) {
         return this.parent.containsAll(coll);
      }

      public boolean remove(Object key) {
         return this.parent.remove(key, this.parent.getCount(key)) != 0;
      }

      public int size() {
         return this.parent.uniqueElements();
      }

      public void clear() {
         this.parent.clear();
      }
   }

   private static class MultiSetIterator implements Iterator {
      private final AbstractMultiSet parent;
      private final Iterator entryIterator;
      private MultiSet.Entry current;
      private int itemCount;
      private boolean canRemove;

      public MultiSetIterator(AbstractMultiSet parent) {
         this.parent = parent;
         this.entryIterator = parent.entrySet().iterator();
         this.current = null;
         this.canRemove = false;
      }

      public boolean hasNext() {
         return this.itemCount > 0 || this.entryIterator.hasNext();
      }

      public Object next() {
         if (this.itemCount == 0) {
            this.current = (MultiSet.Entry)this.entryIterator.next();
            this.itemCount = this.current.getCount();
         }

         this.canRemove = true;
         --this.itemCount;
         return this.current.getElement();
      }

      public void remove() {
         if (!this.canRemove) {
            throw new IllegalStateException();
         } else {
            int count = this.current.getCount();
            if (count > 1) {
               this.parent.remove(this.current.getElement());
            } else {
               this.entryIterator.remove();
            }

            this.canRemove = false;
         }
      }
   }
}
