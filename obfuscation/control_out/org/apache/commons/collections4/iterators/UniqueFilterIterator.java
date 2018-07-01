package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.functors.UniquePredicate;

public class UniqueFilterIterator extends FilterIterator {
   public UniqueFilterIterator(Iterator iterator) {
      super(iterator, UniquePredicate.uniquePredicate());
   }
}
