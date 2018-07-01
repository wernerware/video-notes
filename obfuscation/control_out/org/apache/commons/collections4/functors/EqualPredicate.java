package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

public final class EqualPredicate implements Predicate, Serializable {
   private static final long serialVersionUID = 5633766978029907089L;
   private final Object iValue;
   private final Equator equator;

   public static Predicate equalPredicate(Object object) {
      return (Predicate)(object == null ? NullPredicate.nullPredicate() : new EqualPredicate(object));
   }

   public static Predicate equalPredicate(Object object, Equator equator) {
      return (Predicate)(object == null ? NullPredicate.nullPredicate() : new EqualPredicate(object, equator));
   }

   public EqualPredicate(Object object) {
      this(object, (Equator)null);
   }

   public EqualPredicate(Object object, Equator equator) {
      this.iValue = object;
      this.equator = equator;
   }

   public boolean evaluate(Object object) {
      return this.equator != null ? this.equator.equate(this.iValue, object) : this.iValue.equals(object);
   }

   public Object getValue() {
      return this.iValue;
   }
}
