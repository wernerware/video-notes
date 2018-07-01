package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator {
   private final Iterator iterator;
   private boolean exhausted = false;
   private boolean slotFilled = false;
   private Object slot;

   public static PeekingIterator peekingIterator(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (iterator instanceof PeekingIterator) {
         PeekingIterator it = (PeekingIterator)iterator;
         return it;
      } else {
         return new PeekingIterator(iterator);
      }
   }

   public PeekingIterator(Iterator iterator) {
      this.iterator = iterator;
   }

   private void fill() {
      if (!this.exhausted && !this.slotFilled) {
         if (this.iterator.hasNext()) {
            this.slot = this.iterator.next();
            this.slotFilled = true;
         } else {
            this.exhausted = true;
            this.slot = null;
            this.slotFilled = false;
         }

      }
   }

   public boolean hasNext() {
      if (this.exhausted) {
         return false;
      } else {
         return this.slotFilled ? true : this.iterator.hasNext();
      }
   }

   public Object peek() {
      this.fill();
      return this.exhausted ? null : this.slot;
   }

   public Object element() {
      this.fill();
      if (this.exhausted) {
         throw new NoSuchElementException();
      } else {
         return this.slot;
      }
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Object x = this.slotFilled ? this.slot : this.iterator.next();
         this.slot = null;
         this.slotFilled = false;
         return x;
      }
   }

   public void remove() {
      if (this.slotFilled) {
         throw new IllegalStateException("peek() or element() called before remove()");
      } else {
         this.iterator.remove();
      }
   }
}
