package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

public class ConstantTransformer implements Transformer, Serializable {
   private static final long serialVersionUID = 6374440726369055124L;
   public static final Transformer NULL_INSTANCE = new ConstantTransformer((Object)null);
   private final Object iConstant;

   public static Transformer nullTransformer() {
      return NULL_INSTANCE;
   }

   public static Transformer constantTransformer(Object constantToReturn) {
      return (Transformer)(constantToReturn == null ? nullTransformer() : new ConstantTransformer(constantToReturn));
   }

   public ConstantTransformer(Object constantToReturn) {
      this.iConstant = constantToReturn;
   }

   public Object transform(Object input) {
      return this.iConstant;
   }

   public Object getConstant() {
      return this.iConstant;
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof ConstantTransformer)) {
         return false;
      } else {
         Object otherConstant = ((ConstantTransformer)obj).getConstant();
         return otherConstant == this.getConstant() || otherConstant != null && otherConstant.equals(this.getConstant());
      }
   }

   public int hashCode() {
      int result = "ConstantTransformer".hashCode() << 2;
      if (this.getConstant() != null) {
         result |= this.getConstant().hashCode();
      }

      return result;
   }
}
