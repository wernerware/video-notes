package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

public class NOPTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 2133891748318574490L;
   public static final Transformer INSTANCE = new NOPTransformer();

   public static Transformer nopTransformer() {
      return INSTANCE;
   }

   public Object transform(Object input) {
      return input;
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
