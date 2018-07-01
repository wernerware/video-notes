package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public abstract class AbstractQuantifierPredicate implements PredicateDecorator, Serializable {
   private static final long serialVersionUID = -3094696765038308799L;
   protected final Predicate[] iPredicates;

   public AbstractQuantifierPredicate(Predicate... predicates) {
      this.iPredicates = predicates;
   }

   public Predicate[] getPredicates() {
      return FunctorUtils.copy(this.iPredicates);
   }
}
