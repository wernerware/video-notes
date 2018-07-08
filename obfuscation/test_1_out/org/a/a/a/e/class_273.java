package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.Q
public final class class_273 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_407 = -8791518325735182855L;
   // $FF: renamed from: b org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_408;
   // $FF: renamed from: c org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_409;

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.an) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_642(APPARENTLY_REALLY_IMPORTANT var0, APPARENTLY_REALLY_IMPORTANT var1) {
      if (var0 != null && var1 != null) {
         return new class_273(var0, var1);
      } else {
         throw new NullPointerException("Predicate must not be null");
      }
   }

   public class_273(APPARENTLY_REALLY_IMPORTANT var1, APPARENTLY_REALLY_IMPORTANT var2) {
      this.field_408 = var1;
      this.field_409 = var2;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return this.field_408.method_3(var1) || this.field_409.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public APPARENTLY_REALLY_IMPORTANT[] method_4() {
      return new APPARENTLY_REALLY_IMPORTANT[]{this.field_408, this.field_409};
   }
}
