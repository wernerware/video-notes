package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

public final class UniquePredicate implements Predicate, Serializable {
   private static final long serialVersionUID = -3319417438027438040L;
   private final Set iSet = new HashSet();

   public static Predicate uniquePredicate() {
      return new UniquePredicate();
   }

   public boolean evaluate(Object object) {
      return this.iSet.add(object);
   }
}
