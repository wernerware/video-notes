package org.apache.commons.collections4;

import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.multiset.SynchronizedMultiSet;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;

public class MultiSetUtils {
   public static final MultiSet EMPTY_MULTISET = UnmodifiableMultiSet.unmodifiableMultiSet(new HashMultiSet());

   public static MultiSet synchronizedMultiSet(MultiSet multiset) {
      return SynchronizedMultiSet.synchronizedMultiSet(multiset);
   }

   public static MultiSet unmodifiableMultiSet(MultiSet multiset) {
      return UnmodifiableMultiSet.unmodifiableMultiSet(multiset);
   }

   public static MultiSet predicatedMultiSet(MultiSet multiset, Predicate predicate) {
      return PredicatedMultiSet.predicatedMultiSet(multiset, predicate);
   }

   public static MultiSet emptyMultiSet() {
      return EMPTY_MULTISET;
   }
}
