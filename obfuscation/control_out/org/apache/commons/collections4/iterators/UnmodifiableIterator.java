package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.Unmodifiable;

public final class UnmodifiableIterator implements Iterator, Unmodifiable {
   private final Iterator iterator;

   public static Iterator unmodifiableIterator(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         return (Iterator)(iterator instanceof Unmodifiable ? iterator : new UnmodifiableIterator(iterator));
      }
   }

   private UnmodifiableIterator(Iterator iterator) {
      this.iterator = iterator;
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public Object next() {
      return this.iterator.next();
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() is not supported");
   }
}
