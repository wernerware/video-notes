package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class NullIsFalsePredicate implements PredicateDecorator, Serializable {
   private static final long serialVersionUID = -2997501534564735525L;
   private final Predicate iPredicate;

   public static Predicate nullIsFalsePredicate(Predicate predicate) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new NullIsFalsePredicate(predicate);
      }
   }

   public NullIsFalsePredicate(Predicate predicate) {
      this.iPredicate = predicate;
   }

   public boolean evaluate(Object object) {
      return object == null ? false : this.iPredicate.evaluate(object);
   }

   public Predicate[] getPredicates() {
      return new Predicate[]{this.iPredicate};
   }
}
