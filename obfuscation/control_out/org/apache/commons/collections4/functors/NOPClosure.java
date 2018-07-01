package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;

public final class NOPClosure implements Closure, Serializable {
   private static final long serialVersionUID = 3518477308466486130L;
   public static final Closure INSTANCE = new NOPClosure();

   public static Closure nopClosure() {
      return INSTANCE;
   }

   public void execute(Object input) {
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
