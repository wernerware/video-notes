package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PushbackIterator implements Iterator {
   private final Iterator iterator;
   private Deque items = new ArrayDeque();

   public static PushbackIterator pushbackIterator(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (iterator instanceof PushbackIterator) {
         PushbackIterator it = (PushbackIterator)iterator;
         return it;
      } else {
         return new PushbackIterator(iterator);
      }
   }

   public PushbackIterator(Iterator iterator) {
      this.iterator = iterator;
   }

   public void pushback(Object item) {
      this.items.push(item);
   }

   public boolean hasNext() {
      return !this.items.isEmpty() ? true : this.iterator.hasNext();
   }

   public Object next() {
      return !this.items.isEmpty() ? this.items.pop() : this.iterator.next();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
