package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Transformer;

public class CloneTransformer implements Transformer {
   public static final Transformer INSTANCE = new CloneTransformer();

   public static Transformer cloneTransformer() {
      return INSTANCE;
   }

   public Object transform(Object input) {
      return input == null ? null : PrototypeFactory.prototypeFactory(input).create();
   }
}
