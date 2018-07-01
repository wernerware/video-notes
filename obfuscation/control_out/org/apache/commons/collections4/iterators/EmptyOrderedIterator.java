package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EmptyOrderedIterator extends AbstractEmptyIterator implements OrderedIterator, ResettableIterator {
   public static final OrderedIterator INSTANCE = new EmptyOrderedIterator();

   public static OrderedIterator emptyOrderedIterator() {
      return INSTANCE;
   }
}
