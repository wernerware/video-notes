package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;

public class ConstantFactory implements Factory, Serializable {
   private static final long serialVersionUID = -3520677225766901240L;
   public static final Factory NULL_INSTANCE = new ConstantFactory((Object)null);
   private final Object iConstant;

   public static Factory constantFactory(Object constantToReturn) {
      return (Factory)(constantToReturn == null ? NULL_INSTANCE : new ConstantFactory(constantToReturn));
   }

   public ConstantFactory(Object constantToReturn) {
      this.iConstant = constantToReturn;
   }

   public Object create() {
      return this.iConstant;
   }

   public Object getConstant() {
      return this.iConstant;
   }
}
