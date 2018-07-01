package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class LoopingIterator implements ResettableIterator {
   private final Collection collection;
   private Iterator iterator;

   public LoopingIterator(Collection coll) {
      if (coll == null) {
         throw new NullPointerException("The collection must not be null");
      } else {
         this.collection = coll;
         this.reset();
      }
   }

   public boolean hasNext() {
      return this.collection.size() > 0;
   }

   public Object next() {
      if (this.collection.size() == 0) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         if (!this.iterator.hasNext()) {
            this.reset();
         }

         return this.iterator.next();
      }
   }

   public void remove() {
      this.iterator.remove();
   }

   public void reset() {
      this.iterator = this.collection.iterator();
   }

   public int size() {
      return this.collection.size();
   }
}
