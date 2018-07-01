package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

public class FactoryTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = -6817674502475353160L;
   private final Factory iFactory;

   public static Transformer factoryTransformer(Factory factory) {
      if (factory == null) {
         throw new NullPointerException("Factory must not be null");
      } else {
         return new FactoryTransformer(factory);
      }
   }

   public FactoryTransformer(Factory factory) {
      this.iFactory = factory;
   }

   public Object transform(Object input) {
      return this.iFactory.create();
   }

   public Factory getFactory() {
      return this.iFactory;
   }
}
