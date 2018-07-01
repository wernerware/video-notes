package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ObjectArrayIterator implements ResettableIterator {
   final Object[] array;
   final int startIndex;
   final int endIndex;
   int index;

   public ObjectArrayIterator(Object... array) {
      this(array, 0, array.length);
   }

   public ObjectArrayIterator(Object[] array, int start) {
      this(array, start, array.length);
   }

   public ObjectArrayIterator(Object[] array, int start, int end) {
      this.index = 0;
      if (start < 0) {
         throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
      } else if (end > array.length) {
         throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
      } else if (start > array.length) {
         throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
      } else if (end < start) {
         throw new IllegalArgumentException("End index must not be less than start index");
      } else {
         this.array = array;
         this.startIndex = start;
         this.endIndex = end;
         this.index = start;
      }
   }

   public boolean hasNext() {
      return this.index < this.endIndex;
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.array[this.index++];
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
   }

   public Object[] getArray() {
      return this.array;
   }

   public int getStartIndex() {
      return this.startIndex;
   }

   public int getEndIndex() {
      return this.endIndex;
   }

   public void reset() {
      this.index = this.startIndex;
   }
}
