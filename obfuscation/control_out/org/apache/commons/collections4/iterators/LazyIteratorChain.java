package org.apache.commons.collections4.iterators;

import java.util.Iterator;

public abstract class LazyIteratorChain implements Iterator {
   private int callCounter = 0;
   private boolean chainExhausted = false;
   private Iterator currentIterator = null;
   private Iterator lastUsedIterator = null;

   protected abstract Iterator nextIterator(int var1);

   private void updateCurrentIterator() {
      if (this.callCounter == 0) {
         this.currentIterator = this.nextIterator(++this.callCounter);
         if (this.currentIterator == null) {
            this.currentIterator = EmptyIterator.emptyIterator();
            this.chainExhausted = true;
         }

         this.lastUsedIterator = this.currentIterator;
      }

      while(!this.currentIterator.hasNext() && !this.chainExhausted) {
         Iterator nextIterator = this.nextIterator(++this.callCounter);
         if (nextIterator != null) {
            this.currentIterator = nextIterator;
         } else {
            this.chainExhausted = true;
         }
      }

   }

   public boolean hasNext() {
      this.updateCurrentIterator();
      this.lastUsedIterator = this.currentIterator;
      return this.currentIterator.hasNext();
   }

   public Object next() {
      this.updateCurrentIterator();
      this.lastUsedIterator = this.currentIterator;
      return this.currentIterator.next();
   }

   public void remove() {
      if (this.currentIterator == null) {
         this.updateCurrentIterator();
      }

      this.lastUsedIterator.remove();
   }
}
