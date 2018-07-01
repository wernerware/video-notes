package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

public class TransformerClosure implements Closure, Serializable {
   private static final long serialVersionUID = -5194992589193388969L;
   private final Transformer iTransformer;

   public static Closure transformerClosure(Transformer transformer) {
      return (Closure)(transformer == null ? NOPClosure.nopClosure() : new TransformerClosure(transformer));
   }

   public TransformerClosure(Transformer transformer) {
      this.iTransformer = transformer;
   }

   public void execute(Object input) {
      this.iTransformer.transform(input);
   }

   public Transformer getTransformer() {
      return this.iTransformer;
   }
}
