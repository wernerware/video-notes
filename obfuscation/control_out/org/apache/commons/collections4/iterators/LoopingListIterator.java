package org.apache.commons.collections4.iterators;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class LoopingListIterator implements ResettableListIterator {
   private final List list;
   private ListIterator iterator;

   public LoopingListIterator(List list) {
      if (list == null) {
         throw new NullPointerException("The list must not be null");
      } else {
         this.list = list;
         this._reset();
      }
   }

   public boolean hasNext() {
      return !this.list.isEmpty();
   }

   public Object next() {
      if (this.list.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         if (!this.iterator.hasNext()) {
            this.reset();
         }

         return this.iterator.next();
      }
   }

   public int nextIndex() {
      if (this.list.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         return !this.iterator.hasNext() ? 0 : this.iterator.nextIndex();
      }
   }

   public boolean hasPrevious() {
      return !this.list.isEmpty();
   }

   public Object previous() {
      if (this.list.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else if (this.iterator.hasPrevious()) {
         return this.iterator.previous();
      } else {
         Object result;
         for(result = null; this.iterator.hasNext(); result = this.iterator.next()) {
            ;
         }

         this.iterator.previous();
         return result;
      }
   }

   public int previousIndex() {
      if (this.list.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         return !this.iterator.hasPrevious() ? this.list.size() - 1 : this.iterator.previousIndex();
      }
   }

   public void remove() {
      this.iterator.remove();
   }

   public void add(Object obj) {
      this.iterator.add(obj);
   }

   public void set(Object obj) {
      this.iterator.set(obj);
   }

   public void reset() {
      this._reset();
   }

   private void _reset() {
      this.iterator = this.list.listIterator();
   }

   public int size() {
      return this.list.size();
   }
}
