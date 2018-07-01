package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

public class WhileClosure implements Closure {
   private final Predicate iPredicate;
   private final Closure iClosure;
   private final boolean iDoLoop;

   public static Closure whileClosure(Predicate predicate, Closure closure, boolean doLoop) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (closure == null) {
         throw new NullPointerException("Closure must not be null");
      } else {
         return new WhileClosure(predicate, closure, doLoop);
      }
   }

   public WhileClosure(Predicate predicate, Closure closure, boolean doLoop) {
      this.iPredicate = predicate;
      this.iClosure = closure;
      this.iDoLoop = doLoop;
   }

   public void execute(Object input) {
      if (this.iDoLoop) {
         this.iClosure.execute(input);
      }

      while(this.iPredicate.evaluate(input)) {
         this.iClosure.execute(input);
      }

   }

   public Predicate getPredicate() {
      return this.iPredicate;
   }

   public Closure getClosure() {
      return this.iClosure;
   }

   public boolean isDoLoop() {
      return this.iDoLoop;
   }
}
