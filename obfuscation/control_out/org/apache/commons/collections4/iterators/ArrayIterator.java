package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class ArrayIterator implements ResettableIterator {
   final Object array;
   final int startIndex;
   final int endIndex;
   int index;

   public ArrayIterator(Object array) {
      this(array, 0);
   }

   public ArrayIterator(Object array, int startIndex) {
      this(array, startIndex, Array.getLength(array));
   }

   public ArrayIterator(Object array, int startIndex, int endIndex) {
      this.index = 0;
      this.array = array;
      this.startIndex = startIndex;
      this.endIndex = endIndex;
      this.index = startIndex;
      int len = Array.getLength(array);
      this.checkBound(startIndex, len, "start");
      this.checkBound(endIndex, len, "end");
      if (endIndex < startIndex) {
         throw new IllegalArgumentException("End index must not be less than start index.");
      }
   }

   protected void checkBound(int bound, int len, String type) {
      if (bound > len) {
         throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + type + "s beyond the end of the array. ");
      } else if (bound < 0) {
         throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + type + "s before the start of the array. ");
      }
   }

   public boolean hasNext() {
      return this.index < this.endIndex;
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return Array.get(this.array, this.index++);
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() method is not supported");
   }

   public Object getArray() {
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
