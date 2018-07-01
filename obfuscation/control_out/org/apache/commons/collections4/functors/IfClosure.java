package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;

public class IfClosure implements Closure, Serializable {
   private static final long serialVersionUID = 3518477308466486130L;
   private final Predicate iPredicate;
   private final Closure iTrueClosure;
   private final Closure iFalseClosure;

   public static Closure ifClosure(Predicate predicate, Closure trueClosure) {
      return ifClosure(predicate, trueClosure, NOPClosure.nopClosure());
   }

   public static Closure ifClosure(Predicate predicate, Closure trueClosure, Closure falseClosure) {
      if (predicate == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (trueClosure != null && falseClosure != null) {
         return new IfClosure(predicate, trueClosure, falseClosure);
      } else {
         throw new NullPointerException("Closures must not be null");
      }
   }

   public IfClosure(Predicate predicate, Closure trueClosure) {
      this(predicate, trueClosure, NOPClosure.nopClosure());
   }

   public IfClosure(Predicate predicate, Closure trueClosure, Closure falseClosure) {
      this.iPredicate = predicate;
      this.iTrueClosure = trueClosure;
      this.iFalseClosure = falseClosure;
   }

   public void execute(Object input) {
      if (this.iPredicate.evaluate(input)) {
         this.iTrueClosure.execute(input);
      } else {
         this.iFalseClosure.execute(input);
      }

   }

   public Predicate getPredicate() {
      return this.iPredicate;
   }

   public Closure getTrueClosure() {
      return this.iTrueClosure;
   }

   public Closure getFalseClosure() {
      return this.iFalseClosure;
   }
}
