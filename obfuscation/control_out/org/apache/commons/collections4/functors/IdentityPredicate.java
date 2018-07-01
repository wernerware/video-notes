package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

public final class IdentityPredicate implements Predicate, Serializable {
   private static final long serialVersionUID = -89901658494523293L;
   private final Object iValue;

   public static Predicate identityPredicate(Object object) {
      return (Predicate)(object == null ? NullPredicate.nullPredicate() : new IdentityPredicate(object));
   }

   public IdentityPredicate(Object object) {
      this.iValue = object;
   }

   public boolean evaluate(Object object) {
      return this.iValue == object;
   }

   public Object getValue() {
      return this.iValue;
   }
}
