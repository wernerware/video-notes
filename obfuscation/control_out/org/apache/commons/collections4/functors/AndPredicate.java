package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class AndPredicate implements PredicateDecorator, Serializable {
   private static final long serialVersionUID = 4189014213763186912L;
   private final Predicate iPredicate1;
   private final Predicate iPredicate2;

   public static Predicate andPredicate(Predicate predicate1, Predicate predicate2) {
      if (predicate1 != null && predicate2 != null) {
         return new AndPredicate(predicate1, predicate2);
      } else {
         throw new NullPointerException("Predicate must not be null");
      }
   }

   public AndPredicate(Predicate predicate1, Predicate predicate2) {
      this.iPredicate1 = predicate1;
      this.iPredicate2 = predicate2;
   }

   public boolean evaluate(Object object) {
      return this.iPredicate1.evaluate(object) && this.iPredicate2.evaluate(object);
   }

   public Predicate[] getPredicates() {
      return new Predicate[]{this.iPredicate1, this.iPredicate2};
   }
}
