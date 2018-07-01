package org.apache.commons.collections4.iterators;

public abstract class AbstractEmptyMapIterator extends AbstractEmptyIterator {
   public Object getKey() {
      throw new IllegalStateException("Iterator contains no elements");
   }

   public Object getValue() {
      throw new IllegalStateException("Iterator contains no elements");
   }

   public Object setValue(Object value) {
      throw new IllegalStateException("Iterator contains no elements");
   }
}
