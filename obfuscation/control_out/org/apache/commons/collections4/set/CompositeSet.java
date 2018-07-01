package org.apache.commons.collections4.set;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeSet implements Set, Serializable {
   private static final long serialVersionUID = 5185069727540378940L;
   private CompositeSet.SetMutator mutator;
   private final List all = new ArrayList();

   public CompositeSet() {
   }

   public CompositeSet(Set set) {
      this.addComposited(set);
   }

   public CompositeSet(Set... sets) {
      this.addComposited(sets);
   }

   public int size() {
      int size = 0;

      Set item;
      for(Iterator i$ = this.all.iterator(); i$.hasNext(); size += item.size()) {
         item = (Set)i$.next();
      }

      return size;
   }

   public boolean isEmpty() {
      Iterator i$ = this.all.iterator();

      Set item;
      do {
         if (!i$.hasNext()) {
            return true;
         }

         item = (Set)i$.next();
      } while(item.isEmpty());

      return false;
   }

   public boolean contains(Object obj) {
      Iterator i$ = this.all.iterator();

      Set item;
      do {
         if (!i$.hasNext()) {
            return false;
         }

         item = (Set)i$.next();
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
            Set item = (Set)i$.next();
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
         throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
      } else {
         return this.mutator.add(this, this.all, obj);
      }
   }

   public boolean remove(Object obj) {
      Iterator i$ = this.getSets().iterator();

      Set set;
      do {
         if (!i$.hasNext()) {
            return false;
         }

         set = (Set)i$.next();
      } while(!set.contains(obj));

      return set.remove(obj);
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
         throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
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

   public void setMutator(CompositeSet.SetMutator mutator) {
      this.mutator = mutator;
   }

   public synchronized void addComposited(Set set) {
      Iterator i$ = this.getSets().iterator();

      while(i$.hasNext()) {
         Set existingSet = (Set)i$.next();
         Collection intersects = CollectionUtils.intersection(existingSet, set);
         if (intersects.size() > 0) {
            if (this.mutator == null) {
               throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");
            }

            this.getMutator().resolveCollision(this, existingSet, set, intersects);
            if (CollectionUtils.intersection(existingSet, set).size() > 0) {
               throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
            }
         }
      }

      this.all.add(set);
   }

   public void addComposited(Set set1, Set set2) {
      this.addComposited(set1);
      this.addComposited(set2);
   }

   public void addComposited(Set... sets) {
      Set[] arr$ = sets;
      int len$ = sets.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Set set = arr$[i$];
         this.addComposited(set);
      }

   }

   public void removeComposited(Set set) {
      this.all.remove(set);
   }

   public Set toSet() {
      return new HashSet(this);
   }

   public List getSets() {
      return UnmodifiableList.unmodifiableList(this.all);
   }

   protected CompositeSet.SetMutator getMutator() {
      return this.mutator;
   }

   public boolean equals(Object obj) {
      if (!(obj instanceof Set)) {
         return false;
      } else {
         Set set = (Set)obj;
         return set.size() == this.size() && set.containsAll(this);
      }
   }

   public int hashCode() {
      int code = 0;

      Object e;
      for(Iterator i$ = this.iterator(); i$.hasNext(); code += e == null ? 0 : e.hashCode()) {
         e = i$.next();
      }

      return code;
   }

   public interface SetMutator extends Serializable {
      boolean add(CompositeSet var1, List var2, Object var3);

      boolean addAll(CompositeSet var1, List var2, Collection var3);

      void resolveCollision(CompositeSet var1, Set var2, Set var3, Collection var4);
   }
}
