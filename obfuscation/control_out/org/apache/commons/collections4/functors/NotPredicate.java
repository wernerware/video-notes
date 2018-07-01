package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class NotPredicate implements PredicateDecorator, Serializable {
   private static final long serialVersionUID = -2654603322338049674L;
   private final Predicate iPredicate;

   public static Predicate notPredicate(Predicate predicate) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new NotPredicate(predicate);
      }
   }

   public NotPredicate(Predicate predicate) {
      this.iPredicate = predicate;
   }

   public boolean evaluate(Object object) {
      return !this.iPredicate.evaluate(object);
   }

   public Predicate[] getPredicates() {
      return new Predicate[]{this.iPredicate};
   }
}
