package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.c
public final class class_285 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_436 = 4189014213763186912L;
   // $FF: renamed from: b org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_437;
   // $FF: renamed from: c org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_438;

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.an) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_662(APPARENTLY_REALLY_IMPORTANT var0, APPARENTLY_REALLY_IMPORTANT var1) {
      if (var0 != null && var1 != null) {
         return new class_285(var0, var1);
      } else {
         throw new NullPointerException("Predicate must not be null");
      }
   }

   public class_285(APPARENTLY_REALLY_IMPORTANT var1, APPARENTLY_REALLY_IMPORTANT var2) {
      this.field_437 = var1;
      this.field_438 = var2;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return this.field_437.method_3(var1) && this.field_438.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public APPARENTLY_REALLY_IMPORTANT[] method_4() {
      return new APPARENTLY_REALLY_IMPORTANT[]{this.field_437, this.field_438};
   }
}
