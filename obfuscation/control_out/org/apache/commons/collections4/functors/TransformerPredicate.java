package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public final class TransformerPredicate implements Predicate, Serializable {
   private static final long serialVersionUID = -2407966402920578741L;
   private final Transformer iTransformer;

   public static Predicate transformerPredicate(Transformer transformer) {
      if (transformer == null) {
         throw new NullPointerException("The transformer to call must not be null");
      } else {
         return new TransformerPredicate(transformer);
      }
   }

   public TransformerPredicate(Transformer transformer) {
      this.iTransformer = transformer;
   }

   public boolean evaluate(Object object) {
      Boolean result = (Boolean)this.iTransformer.transform(object);
      if (result == null) {
         throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
      } else {
         return result;
      }
   }

   public Transformer getTransformer() {
      return this.iTransformer;
   }
}
