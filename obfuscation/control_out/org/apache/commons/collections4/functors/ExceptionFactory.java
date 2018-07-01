package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

public final class ExceptionFactory implements Factory, Serializable {
   private static final long serialVersionUID = 7179106032121985545L;
   public static final Factory INSTANCE = new ExceptionFactory();

   public static Factory exceptionFactory() {
      return INSTANCE;
   }

   public Object create() {
      throw new FunctorException("ExceptionFactory invoked");
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
