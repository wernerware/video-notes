package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EmptyMapIterator extends AbstractEmptyMapIterator implements MapIterator, ResettableIterator {
   public static final MapIterator INSTANCE = new EmptyMapIterator();

   public static MapIterator emptyMapIterator() {
      return INSTANCE;
   }
}
