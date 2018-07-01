package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

public final class AnyPredicate extends AbstractQuantifierPredicate {
   private static final long serialVersionUID = 7429999530934647542L;

   public static Predicate anyPredicate(Predicate... predicates) {
      FunctorUtils.validate(predicates);
      if (predicates.length == 0) {
         return FalsePredicate.falsePredicate();
      } else {
         return (Predicate)(predicates.length == 1 ? predicates[0] : new AnyPredicate(FunctorUtils.copy(predicates)));
      }
   }

   public static Predicate anyPredicate(Collection predicates) {
      Predicate[] preds = FunctorUtils.validate(predicates);
      if (preds.length == 0) {
         return FalsePredicate.falsePredicate();
      } else {
         return (Predicate)(preds.length == 1 ? preds[0] : new AnyPredicate(preds));
      }
   }

   public AnyPredicate(Predicate... predicates) {
      super(predicates);
   }

   public boolean evaluate(Object object) {
      Predicate[] arr$ = this.iPredicates;
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Predicate iPredicate = arr$[i$];
         if (iPredicate.evaluate(object)) {
            return true;
         }
      }

      return false;
   }
}
