package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.N
public final class class_232 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_335 = -7625133768987126273L;
   // $FF: renamed from: b org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_336;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_584(APPARENTLY_REALLY_IMPORTANT var0) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new class_232(var0);
      }
   }

   public class_232(APPARENTLY_REALLY_IMPORTANT var1) {
      this.field_336 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return var1 == null ? true : this.field_336.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public APPARENTLY_REALLY_IMPORTANT[] method_4() {
      return new APPARENTLY_REALLY_IMPORTANT[]{this.field_336};
   }
}
