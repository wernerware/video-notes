package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

public final class ExceptionClosure implements Closure, Serializable {
   private static final long serialVersionUID = 7179106032121985545L;
   public static final Closure INSTANCE = new ExceptionClosure();

   public static Closure exceptionClosure() {
      return INSTANCE;
   }

   public void execute(Object input) {
      throw new FunctorException("ExceptionClosure invoked");
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
