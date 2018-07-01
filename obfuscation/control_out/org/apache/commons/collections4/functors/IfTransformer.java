package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

public class IfTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 8069309411242014252L;
   private final Predicate iPredicate;
   private final Transformer iTrueTransformer;
   private final Transformer iFalseTransformer;

   public static Transformer ifTransformer(Predicate predicate, Transformer trueTransformer, Transformer falseTransformer) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (trueTransformer != null && falseTransformer != null) {
         return new IfTransformer(predicate, trueTransformer, falseTransformer);
      } else {
         throw new NullPointerException("Transformers must not be null");
      }
   }

   public static Transformer ifTransformer(Predicate predicate, Transformer trueTransformer) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (trueTransformer == null) {
         throw new NullPointerException("Transformer must not be null");
      } else {
         return new IfTransformer(predicate, trueTransformer, NOPTransformer.nopTransformer());
      }
   }

   public IfTransformer(Predicate predicate, Transformer trueTransformer, Transformer falseTransformer) {
      this.iPredicate = predicate;
      this.iTrueTransformer = trueTransformer;
      this.iFalseTransformer = falseTransformer;
   }

   public Object transform(Object input) {
      return this.iPredicate.evaluate(input) ? this.iTrueTransformer.transform(input) : this.iFalseTransformer.transform(input);
   }

   public Predicate getPredicate() {
      return this.iPredicate;
   }

   public Transformer getTrueTransformer() {
      return this.iTrueTransformer;
   }

   public Transformer getFalseTransformer() {
      return this.iFalseTransformer;
   }
}
