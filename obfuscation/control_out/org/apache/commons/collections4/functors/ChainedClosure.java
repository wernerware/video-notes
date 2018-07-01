package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.Closure;

public class ChainedClosure implements Closure, Serializable {
   private static final long serialVersionUID = -3520677225766901240L;
   private final Closure[] iClosures;

   public static Closure chainedClosure(Closure... closures) {
      FunctorUtils.validate(closures);
      return (Closure)(closures.length == 0 ? NOPClosure.nopClosure() : new ChainedClosure(closures));
   }

   public static Closure chainedClosure(Collection closures) {
      if (closures == null) {
         throw new NullPointerException("Closure collection must not be null");
      } else if (closures.size() == 0) {
         return NOPClosure.nopClosure();
      } else {
         Closure[] cmds = new Closure[closures.size()];
         int i = 0;

         Closure closure;
         for(Iterator i$ = closures.iterator(); i$.hasNext(); cmds[i++] = closure) {
            closure = (Closure)i$.next();
         }

         FunctorUtils.validate(cmds);
         return new ChainedClosure(false, cmds);
      }
   }

   private ChainedClosure(boolean clone, Closure... closures) {
      this.iClosures = clone ? FunctorUtils.copy(closures) : closures;
   }

   public ChainedClosure(Closure... closures) {
      this(true, closures);
   }

   public void execute(Object input) {
      Closure[] arr$ = this.iClosures;
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Closure iClosure = arr$[i$];
         iClosure.execute(input);
      }

   }

   public Closure[] getClosures() {
      return FunctorUtils.copy(this.iClosures);
   }
}
