package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EmptyOrderedMapIterator extends AbstractEmptyMapIterator implements OrderedMapIterator, ResettableIterator {
   public static final OrderedMapIterator INSTANCE = new EmptyOrderedMapIterator();

   public static OrderedMapIterator emptyOrderedMapIterator() {
      return INSTANCE;
   }
}
