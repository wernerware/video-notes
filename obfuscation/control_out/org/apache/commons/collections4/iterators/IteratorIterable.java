package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.ResettableIterator;

public class IteratorIterable implements Iterable {
   private final Iterator iterator;
   private final Iterator typeSafeIterator;

   private static Iterator createTypesafeIterator(final Iterator iterator) {
      return new Iterator() {
         public boolean hasNext() {
            return iterator.hasNext();
         }

         public Object next() {
            return iterator.next();
         }

         public void remove() {
            iterator.remove();
         }
      };
   }

   public IteratorIterable(Iterator iterator) {
      this(iterator, false);
   }

   public IteratorIterable(Iterator iterator, boolean multipleUse) {
      if (multipleUse && !(iterator instanceof ResettableIterator)) {
         this.iterator = new ListIteratorWrapper(iterator);
      } else {
         this.iterator = iterator;
      }

      this.typeSafeIterator = createTypesafeIterator(this.iterator);
   }

   public Iterator iterator() {
      if (this.iterator instanceof ResettableIterator) {
         ((ResettableIterator)this.iterator).reset();
      }

      return this.typeSafeIterator;
   }
}
