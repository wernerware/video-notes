package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

public final class StringValueTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 7511110693171758606L;
   private static final Transformer INSTANCE = new StringValueTransformer();

   public static Transformer stringValueTransformer() {
      return INSTANCE;
   }

   public String transform(Object input) {
      return String.valueOf(input);
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
