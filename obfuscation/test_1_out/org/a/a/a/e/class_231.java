package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.M
public final class class_231 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_333 = -2997501534564735525L;
   // $FF: renamed from: b org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_334;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_583(APPARENTLY_REALLY_IMPORTANT var0) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new class_231(var0);
      }
   }

   public class_231(APPARENTLY_REALLY_IMPORTANT var1) {
      this.field_334 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return var1 == null ? false : this.field_334.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public APPARENTLY_REALLY_IMPORTANT[] method_4() {
      return new APPARENTLY_REALLY_IMPORTANT[]{this.field_334};
   }
}
