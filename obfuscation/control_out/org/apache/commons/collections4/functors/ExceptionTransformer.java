package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

public final class ExceptionTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 7179106032121985545L;
   public static final Transformer INSTANCE = new ExceptionTransformer();

   public static Transformer exceptionTransformer() {
      return INSTANCE;
   }

   public Object transform(Object input) {
      throw new FunctorException("ExceptionTransformer invoked");
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
