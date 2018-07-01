package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class ObjectArrayListIterator extends ObjectArrayIterator implements ResettableListIterator {
   private int lastItemIndex = -1;

   public ObjectArrayListIterator(Object... array) {
      super(array);
   }

   public ObjectArrayListIterator(Object[] array, int start) {
      super(array, start);
   }

   public ObjectArrayListIterator(Object[] array, int start, int end) {
      super(array, start, end);
   }

   public boolean hasPrevious() {
      return this.index > this.getStartIndex();
   }

   public Object previous() {
      if (!this.hasPrevious()) {
         throw new NoSuchElementException();
      } else {
         this.lastItemIndex = --this.index;
         return this.array[this.index];
      }
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.lastItemIndex = this.index;
         return this.array[this.index++];
      }
   }

   public int nextIndex() {
      return this.index - this.getStartIndex();
   }

   public int previousIndex() {
      return this.index - this.getStartIndex() - 1;
   }

   public void add(Object obj) {
      throw new UnsupportedOperationException("add() method is not supported");
   }

   public void set(Object obj) {
      if (this.lastItemIndex == -1) {
         throw new IllegalStateException("must call next() or previous() before a call to set()");
      } else {
         this.array[this.lastItemIndex] = obj;
      }
   }

   public void reset() {
      super.reset();
      this.lastItemIndex = -1;
   }
}
