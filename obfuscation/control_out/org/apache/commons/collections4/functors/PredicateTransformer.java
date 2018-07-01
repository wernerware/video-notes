package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public class PredicateTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 5278818408044349346L;
   private final Predicate iPredicate;

   public static Transformer predicateTransformer(Predicate predicate) {
      if (predicate == null) {
         throw new IllegalArgumentException("Predicate must not be null");
      } else {
         return new PredicateTransformer(predicate);
      }
   }

   public PredicateTransformer(Predicate predicate) {
      this.iPredicate = predicate;
   }

   public Boolean transform(Object input) {
      return this.iPredicate.evaluate(input);
   }

   public Predicate getPredicate() {
      return this.iPredicate;
   }
}
