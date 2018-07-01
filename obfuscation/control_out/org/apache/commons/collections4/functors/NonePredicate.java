package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

public final class NonePredicate extends AbstractQuantifierPredicate {
   private static final long serialVersionUID = 2007613066565892961L;

   public static Predicate nonePredicate(Predicate... predicates) {
      FunctorUtils.validate(predicates);
      return (Predicate)(predicates.length == 0 ? TruePredicate.truePredicate() : new NonePredicate(FunctorUtils.copy(predicates)));
   }

   public static Predicate nonePredicate(Collection predicates) {
      Predicate[] preds = FunctorUtils.validate(predicates);
      return (Predicate)(preds.length == 0 ? TruePredicate.truePredicate() : new NonePredicate(preds));
   }

   public NonePredicate(Predicate... predicates) {
      super(predicates);
   }

   public boolean evaluate(Object object) {
      Predicate[] arr$ = this.iPredicates;
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Predicate iPredicate = arr$[i$];
         if (iPredicate.evaluate(object)) {
            return false;
         }
      }

      return true;
   }
}
