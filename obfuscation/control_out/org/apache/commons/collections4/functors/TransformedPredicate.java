package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public final class TransformedPredicate implements PredicateDecorator, Serializable {
   private static final long serialVersionUID = -5596090919668315834L;
   private final Transformer iTransformer;
   private final Predicate iPredicate;

   public static Predicate transformedPredicate(Transformer transformer, Predicate predicate) {
      if (transformer == null) {
         throw new NullPointerException("The transformer to call must not be null");
      } else if (predicate == null) {
         throw new NullPointerException("The predicate to call must not be null");
      } else {
         return new TransformedPredicate(transformer, predicate);
      }
   }

   public TransformedPredicate(Transformer transformer, Predicate predicate) {
      this.iTransformer = transformer;
      this.iPredicate = predicate;
   }

   public boolean evaluate(Object object) {
      Object result = this.iTransformer.transform(object);
      return this.iPredicate.evaluate(result);
   }

   public Predicate[] getPredicates() {
      return new Predicate[]{this.iPredicate};
   }

   public Transformer getTransformer() {
      return this.iTransformer;
   }
}
