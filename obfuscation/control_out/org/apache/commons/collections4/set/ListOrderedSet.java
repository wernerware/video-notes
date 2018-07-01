package org.apache.commons.collections4.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedSet extends AbstractSerializableSetDecorator {
   private static final long serialVersionUID = -228664372470420141L;
   private final List setOrder;

   public static ListOrderedSet listOrderedSet(Set set, List list) {
      if (set == null) {
         throw new NullPointerException("Set must not be null");
      } else if (list == null) {
         throw new NullPointerException("List must not be null");
      } else if (set.size() <= 0 && list.size() <= 0) {
         return new ListOrderedSet(set, list);
      } else {
         throw new IllegalArgumentException("Set and List must be empty");
      }
   }

   public static ListOrderedSet listOrderedSet(Set set) {
      return new ListOrderedSet(set);
   }

   public static ListOrderedSet listOrderedSet(List list) {
      if (list == null) {
         throw new NullPointerException("List must not be null");
      } else {
         CollectionUtils.filter(list, UniquePredicate.uniquePredicate());
         Set set = new HashSet(list);
         return new ListOrderedSet(set, list);
      }
   }

   public ListOrderedSet() {
      super(new HashSet());
      this.setOrder = new ArrayList();
   }

   protected ListOrderedSet(Set set) {
      super(set);
      this.setOrder = new ArrayList(set);
   }

   protected ListOrderedSet(Set set, List list) {
      super(set);
      if (list == null) {
         throw new NullPointerException("List must not be null");
      } else {
         this.setOrder = list;
      }
   }

   public List asList() {
      return UnmodifiableList.unmodifiableList(this.setOrder);
   }

   public void clear() {
      this.decorated().clear();
      this.setOrder.clear();
   }

   public OrderedIterator iterator() {
      return new ListOrderedSet.OrderedSetIterator(this.setOrder.listIterator(), this.decorated());
   }

   public boolean add(Object object) {
      if (this.decorated().add(object)) {
         this.setOrder.add(object);
         return true;
      } else {
         return false;
      }
   }

   public boolean addAll(Collection coll) {
      boolean result = false;

      Object e;
      for(Iterator i$ = coll.iterator(); i$.hasNext(); result |= this.add(e)) {
         e = i$.next();
      }

      return result;
   }

   public boolean remove(Object object) {
      boolean result = this.decorated().remove(object);
      if (result) {
         this.setOrder.remove(object);
      }

      return result;
   }

   public boolean removeAll(Collection coll) {
      boolean result = false;

      Object name;
      for(Iterator i$ = coll.iterator(); i$.hasNext(); result |= this.remove(name)) {
         name = i$.next();
      }

      return result;
   }

   public boolean retainAll(Collection coll) {
      boolean result = this.decorated().retainAll(coll);
      if (!result) {
         return false;
      } else {
         if (this.decorated().size() == 0) {
            this.setOrder.clear();
         } else {
            Iterator it = this.setOrder.iterator();

            while(it.hasNext()) {
               if (!this.decorated().contains(it.next())) {
                  it.remove();
               }
            }
         }

         return result;
      }
   }

   public Object[] toArray() {
      return this.setOrder.toArray();
   }

   public Object[] toArray(Object[] a) {
      return this.setOrder.toArray(a);
   }

   public Object get(int index) {
      return this.setOrder.get(index);
   }

   public int indexOf(Object object) {
      return this.setOrder.indexOf(object);
   }

   public void add(int index, Object object) {
      if (!this.contains(object)) {
         this.decorated().add(object);
         this.setOrder.add(index, object);
      }

   }

   public boolean addAll(int index, Collection coll) {
      boolean changed = false;
      List toAdd = new ArrayList();
      Iterator i$ = coll.iterator();

      while(i$.hasNext()) {
         Object e = i$.next();
         if (!this.contains(e)) {
            this.decorated().add(e);
            toAdd.add(e);
            changed = true;
         }
      }

      if (changed) {
         this.setOrder.addAll(index, toAdd);
      }

      return changed;
   }

   public Object remove(int index) {
      Object obj = this.setOrder.remove(index);
      this.remove(obj);
      return obj;
   }

   public String toString() {
      return this.setOrder.toString();
   }

   static class OrderedSetIterator extends AbstractIteratorDecorator implements OrderedIterator {
      private final Collection set;
      private Object last;

      private OrderedSetIterator(ListIterator iterator, Collection set) {
         super(iterator);
         this.set = set;
      }

      public Object next() {
         this.last = this.getIterator().next();
         return this.last;
      }

      public void remove() {
         this.set.remove(this.last);
         this.getIterator().remove();
         this.last = null;
      }

      public boolean hasPrevious() {
         return ((ListIterator)this.getIterator()).hasPrevious();
      }

      public Object previous() {
         this.last = ((ListIterator)this.getIterator()).previous();
         return this.last;
      }

      // $FF: synthetic method
      OrderedSetIterator(ListIterator x0, Collection x1, Object x2) {
         this(x0, x1);
      }
   }
}
