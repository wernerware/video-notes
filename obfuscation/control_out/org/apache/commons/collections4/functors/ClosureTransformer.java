package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

public class ClosureTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 478466901448617286L;
   private final Closure iClosure;

   public static Transformer closureTransformer(Closure closure) {
      if (closure == null) {
         throw new NullPointerException("Closure must not be null");
      } else {
         return new ClosureTransformer(closure);
      }
   }

   public ClosureTransformer(Closure closure) {
      this.iClosure = closure;
   }

   public Object transform(Object input) {
      this.iClosure.execute(input);
      return input;
   }

   public Closure getClosure() {
      return this.iClosure;
   }
}
