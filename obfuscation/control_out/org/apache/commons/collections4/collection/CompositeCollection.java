package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeCollection implements Collection, Serializable {
   private static final long serialVersionUID = 8417515734108306801L;
   private CompositeCollection.CollectionMutator mutator;
   private final List all = new ArrayList();

   public CompositeCollection() {
   }

   public CompositeCollection(Collection compositeCollection) {
      this.addComposited(compositeCollection);
   }

   public CompositeCollection(Collection compositeCollection1, Collection compositeCollection2) {
      this.addComposited(compositeCollection1, compositeCollection2);
   }

   public CompositeCollection(Collection... compositeCollections) {
      this.addComposited(compositeCollections);
   }

   public int size() {
      int size = 0;

      Collection item;
      for(Iterator i$ = this.all.iterator(); i$.hasNext(); size += item.size()) {
         item = (Collection)i$.next();
      }

      return size;
   }

   public boolean isEmpty() {
      Iterator i$ = this.all.iterator();

      Collection item;
      do {
         if (!i$.hasNext()) {
            return true;
         }

         item = (Collection)i$.next();
      } while(item.isEmpty());

      return false;
   }

   public boolean contains(Object obj) {
      Iterator i$ = this.all.iterator();

      Collection item;
      do {
         if (!i$.hasNext()) {
            return false;
         }

         item = (Collection)i$.next();
      } while(!item.contains(obj));

      return true;
   }

   public Iterator iterator() {
      if (this.all.isEmpty()) {
         return EmptyIterator.emptyIterator();
      } else {
         IteratorChain chain = new IteratorChain();
         Iterator i$ = this.all.iterator();

         while(i$.hasNext()) {
            Collection item = (Collection)i$.next();
            chain.addIterator(item.iterator());
         }

         return chain;
      }
   }

   public Object[] toArray() {
      Object[] result = new Object[this.size()];
      int i = 0;

      for(Iterator it = this.iterator(); it.hasNext(); ++i) {
         result[i] = it.next();
      }

      return result;
   }

   public Object[] toArray(Object[] array) {
      int size = this.size();
      Object[] result = null;
      if (array.length >= size) {
         result = array;
      } else {
         result = (Object[])((Object[])Array.newInstance(array.getClass().getComponentType(), size));
      }

      int offset = 0;
      Iterator i$ = this.all.iterator();

      while(i$.hasNext()) {
         Collection item = (Collection)i$.next();

         Object e;
         for(Iterator i$ = item.iterator(); i$.hasNext(); result[offset++] = e) {
            e = i$.next();
         }
      }

      if (result.length > size) {
         result[size] = null;
      }

      return (Object[])result;
   }

   public boolean add(Object obj) {
      if (this.mutator == null) {
         throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
      } else {
         return this.mutator.add(this, this.all, obj);
      }
   }

   public boolean remove(Object obj) {
      if (this.mutator == null) {
         throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
      } else {
         return this.mutator.remove(this, this.all, obj);
      }
   }

   public boolean containsAll(Collection coll) {
      Iterator i$ = coll.iterator();

      Object item;
      do {
         if (!i$.hasNext()) {
            return true;
         }

         item = i$.next();
      } while(this.contains(item));

      return false;
   }

   public boolean addAll(Collection coll) {
      if (this.mutator == null) {
         throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
      } else {
         return this.mutator.addAll(this, this.all, coll);
      }
   }

   public boolean removeAll(Collection coll) {
      if (coll.size() == 0) {
         return false;
      } else {
         boolean changed = false;

         Collection item;
         for(Iterator i$ = this.all.iterator(); i$.hasNext(); changed |= item.removeAll(coll)) {
            item = (Collection)i$.next();
         }

         return changed;
      }
   }

   public boolean retainAll(Collection coll) {
      boolean changed = false;

      Collection item;
      for(Iterator i$ = this.all.iterator(); i$.hasNext(); changed |= item.retainAll(coll)) {
         item = (Collection)i$.next();
      }

      return changed;
   }

   public void clear() {
      Iterator i$ = this.all.iterator();

      while(i$.hasNext()) {
         Collection coll = (Collection)i$.next();
         coll.clear();
      }

   }

   public void setMutator(CompositeCollection.CollectionMutator mutator) {
      this.mutator = mutator;
   }

   public void addComposited(Collection compositeCollection) {
      this.all.add(compositeCollection);
   }

   public void addComposited(Collection compositeCollection1, Collection compositeCollection2) {
      this.all.add(compositeCollection1);
      this.all.add(compositeCollection2);
   }

   public void addComposited(Collection... compositeCollections) {
      this.all.addAll(Arrays.asList(compositeCollections));
   }

   public void removeComposited(Collection coll) {
      this.all.remove(coll);
   }

   public Collection toCollection() {
      return new ArrayList(this);
   }

   public List getCollections() {
      return UnmodifiableList.unmodifiableList(this.all);
   }

   protected CompositeCollection.CollectionMutator getMutator() {
      return this.mutator;
   }

   public interface CollectionMutator extends Serializable {
      boolean add(CompositeCollection var1, List var2, Object var3);

      boolean addAll(CompositeCollection var1, List var2, Collection var3);

      boolean remove(CompositeCollection var1, List var2, Object var3);
   }
}
