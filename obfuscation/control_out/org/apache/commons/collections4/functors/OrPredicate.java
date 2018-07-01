package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class OrPredicate implements PredicateDecorator, Serializable {
   private static final long serialVersionUID = -8791518325735182855L;
   private final Predicate iPredicate1;
   private final Predicate iPredicate2;

   public static Predicate orPredicate(Predicate predicate1, Predicate predicate2) {
      if (predicate1 != null && predicate2 != null) {
         return new OrPredicate(predicate1, predicate2);
      } else {
         throw new NullPointerException("Predicate must not be null");
      }
   }

   public OrPredicate(Predicate predicate1, Predicate predicate2) {
      this.iPredicate1 = predicate1;
      this.iPredicate2 = predicate2;
   }

   public boolean evaluate(Object object) {
      return this.iPredicate1.evaluate(object) || this.iPredicate2.evaluate(object);
   }

   public Predicate[] getPredicates() {
      return new Predicate[]{this.iPredicate1, this.iPredicate2};
   }
}
