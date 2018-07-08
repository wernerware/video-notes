package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.K
public final class class_233 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_337 = -2654603322338049674L;
   // $FF: renamed from: b org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_338;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_585(APPARENTLY_REALLY_IMPORTANT var0) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new class_233(var0);
      }
   }

   public class_233(APPARENTLY_REALLY_IMPORTANT var1) {
      this.field_338 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return !this.field_338.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public APPARENTLY_REALLY_IMPORTANT[] method_4() {
      return new APPARENTLY_REALLY_IMPORTANT[]{this.field_338};
   }
}
