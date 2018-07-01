package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.apache.commons.collections4.comparators.ComparableComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.collections4.comparators.ReverseComparator;
import org.apache.commons.collections4.comparators.TransformingComparator;

public class ComparatorUtils {
   public static final Comparator NATURAL_COMPARATOR = ComparableComparator.comparableComparator();

   public static Comparator naturalComparator() {
      return NATURAL_COMPARATOR;
   }

   public static Comparator chainedComparator(Comparator... comparators) {
      ComparatorChain chain = new ComparatorChain();
      Comparator[] arr$ = comparators;
      int len$ = comparators.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Comparator comparator = arr$[i$];
         if (comparator == null) {
            throw new NullPointerException("Comparator cannot be null");
         }

         chain.addComparator(comparator);
      }

      return chain;
   }

   public static Comparator chainedComparator(Collection comparators) {
      return chainedComparator((Comparator[])((Comparator[])comparators.toArray(new Comparator[comparators.size()])));
   }

   public static Comparator reversedComparator(Comparator comparator) {
      return new ReverseComparator(comparator);
   }

   public static Comparator booleanComparator(boolean trueFirst) {
      return BooleanComparator.booleanComparator(trueFirst);
   }

   public static Comparator nullLowComparator(Comparator comparator) {
      if (comparator == null) {
         comparator = NATURAL_COMPARATOR;
      }

      return new NullComparator(comparator, false);
   }

   public static Comparator nullHighComparator(Comparator comparator) {
      if (comparator == null) {
         comparator = NATURAL_COMPARATOR;
      }

      return new NullComparator(comparator, true);
   }

   public static Comparator transformedComparator(Comparator comparator, Transformer transformer) {
      if (comparator == null) {
         comparator = NATURAL_COMPARATOR;
      }

      return new TransformingComparator(transformer, comparator);
   }

   public static Object min(Object o1, Object o2, Comparator comparator) {
      if (comparator == null) {
         comparator = NATURAL_COMPARATOR;
      }

      int c = comparator.compare(o1, o2);
      return c < 0 ? o1 : o2;
   }

   public static Object max(Object o1, Object o2, Comparator comparator) {
      if (comparator == null) {
         comparator = NATURAL_COMPARATOR;
      }

      int c = comparator.compare(o1, o2);
      return c > 0 ? o1 : o2;
   }
}
