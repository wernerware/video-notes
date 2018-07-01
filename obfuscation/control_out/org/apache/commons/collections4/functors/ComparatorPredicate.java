package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.Predicate;

public class ComparatorPredicate implements Predicate, Serializable {
   private static final long serialVersionUID = -1863209236504077399L;
   private final Object object;
   private final Comparator comparator;
   private final ComparatorPredicate.Criterion criterion;

   public static Predicate comparatorPredicate(Object object, Comparator comparator) {
      return comparatorPredicate(object, comparator, ComparatorPredicate.Criterion.EQUAL);
   }

   public static Predicate comparatorPredicate(Object object, Comparator comparator, ComparatorPredicate.Criterion criterion) {
      if (comparator == null) {
         throw new NullPointerException("Comparator must not be null.");
      } else if (criterion == null) {
         throw new NullPointerException("Criterion must not be null.");
      } else {
         return new ComparatorPredicate(object, comparator, criterion);
      }
   }

   public ComparatorPredicate(Object object, Comparator comparator, ComparatorPredicate.Criterion criterion) {
      this.object = object;
      this.comparator = comparator;
      this.criterion = criterion;
   }

   public boolean evaluate(Object target) {
      boolean result = false;
      int comparison = this.comparator.compare(this.object, target);
      switch(this.criterion) {
      case EQUAL:
         result = comparison == 0;
         break;
      case GREATER:
         result = comparison > 0;
         break;
      case LESS:
         result = comparison < 0;
         break;
      case GREATER_OR_EQUAL:
         result = comparison >= 0;
         break;
      case LESS_OR_EQUAL:
         result = comparison <= 0;
         break;
      default:
         throw new IllegalStateException("The current criterion '" + this.criterion + "' is invalid.");
      }

      return result;
   }

   public static enum Criterion {
      EQUAL,
      GREATER,
      LESS,
      GREATER_OR_EQUAL,
      LESS_OR_EQUAL;
   }
}
