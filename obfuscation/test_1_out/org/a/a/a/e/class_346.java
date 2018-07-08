package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.class_21;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.e.ac
public final class class_346 implements Serializable, APPARENTLY_REALLY_IMPORTANT {
   // $FF: renamed from: a long
   private static final long field_577 = -2407966402920578741L;
   // $FF: renamed from: b org.a.a.a.aI
   private final class_21 field_578;

   // $FF: renamed from: a (org.a.a.a.aI) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_879(class_21 var0) {
      if (var0 == null) {
         throw new NullPointerException("The transformer to call must not be null");
      } else {
         return new class_346(var0);
      }
   }

   public class_346(class_21 var1) {
      this.field_578 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      Boolean var2 = (Boolean)this.field_578.method_25(var1);
      if (var2 == null) {
         throw new class_427("Transformer must return an instanceof Boolean, it was a null object");
      } else {
         return var2;
      }
   }

   // $FF: renamed from: a () org.a.a.a.aI
   public class_21 method_880() {
      return this.field_578;
   }
}
