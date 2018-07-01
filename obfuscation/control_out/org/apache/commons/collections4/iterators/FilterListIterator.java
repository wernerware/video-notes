package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Predicate;

public class FilterListIterator implements ListIterator {
   private ListIterator iterator;
   private Predicate predicate;
   private Object nextObject;
   private boolean nextObjectSet = false;
   private Object previousObject;
   private boolean previousObjectSet = false;
   private int nextIndex = 0;

   public FilterListIterator() {
   }

   public FilterListIterator(ListIterator iterator) {
      this.iterator = iterator;
   }

   public FilterListIterator(ListIterator iterator, Predicate predicate) {
      this.iterator = iterator;
      this.predicate = predicate;
   }

   public FilterListIterator(Predicate predicate) {
      this.predicate = predicate;
   }

   public void add(Object o) {
      throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
   }

   public boolean hasNext() {
      return this.nextObjectSet || this.setNextObject();
   }

   public boolean hasPrevious() {
      return this.previousObjectSet || this.setPreviousObject();
   }

   public Object next() {
      if (!this.nextObjectSet && !this.setNextObject()) {
         throw new NoSuchElementException();
      } else {
         ++this.nextIndex;
         Object temp = this.nextObject;
         this.clearNextObject();
         return temp;
      }
   }

   public int nextIndex() {
      return this.nextIndex;
   }

   public Object previous() {
      if (!this.previousObjectSet && !this.setPreviousObject()) {
         throw new NoSuchElementException();
      } else {
         --this.nextIndex;
         Object temp = this.previousObject;
         this.clearPreviousObject();
         return temp;
      }
   }

   public int previousIndex() {
      return this.nextIndex - 1;
   }

   public void remove() {
      throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
   }

   public void set(Object o) {
      throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
   }

   public ListIterator getListIterator() {
      return this.iterator;
   }

   public void setListIterator(ListIterator iterator) {
      this.iterator = iterator;
   }

   public Predicate getPredicate() {
      return this.predicate;
   }

   public void setPredicate(Predicate predicate) {
      this.predicate = predicate;
   }

   private void clearNextObject() {
      this.nextObject = null;
      this.nextObjectSet = false;
   }

   private boolean setNextObject() {
      if (this.previousObjectSet) {
         this.clearPreviousObject();
         if (!this.setNextObject()) {
            return false;
         }

         this.clearNextObject();
      }

      if (this.iterator == null) {
         return false;
      } else {
         Object object;
         do {
            if (!this.iterator.hasNext()) {
               return false;
            }

            object = this.iterator.next();
         } while(!this.predicate.evaluate(object));

         this.nextObject = object;
         this.nextObjectSet = true;
         return true;
      }
   }

   private void clearPreviousObject() {
      this.previousObject = null;
      this.previousObjectSet = false;
   }

   private boolean setPreviousObject() {
      if (this.nextObjectSet) {
         this.clearNextObject();
         if (!this.setPreviousObject()) {
            return false;
         }

         this.clearPreviousObject();
      }

      if (this.iterator == null) {
         return false;
      } else {
         Object object;
         do {
            if (!this.iterator.hasPrevious()) {
               return false;
            }

            object = this.iterator.previous();
         } while(!this.predicate.evaluate(object));

         this.previousObject = object;
         this.previousObjectSet = true;
         return true;
      }
   }
}
