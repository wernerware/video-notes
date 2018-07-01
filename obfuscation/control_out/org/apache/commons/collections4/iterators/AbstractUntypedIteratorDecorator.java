package org.apache.commons.collections4.iterators;

import java.util.Iterator;

public abstract class AbstractUntypedIteratorDecorator implements Iterator {
   private final Iterator iterator;

   protected AbstractUntypedIteratorDecorator(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.iterator = iterator;
      }
   }

   protected Iterator getIterator() {
      return this.iterator;
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public void remove() {
      this.iterator.remove();
   }
}
