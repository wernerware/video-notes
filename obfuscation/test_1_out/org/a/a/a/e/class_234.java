package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.e.L
public final class class_234 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_339 = 3243449850504576071L;
   // $FF: renamed from: b org.a.a.a.an
   private final APPARENTLY_REALLY_IMPORTANT field_340;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_586(APPARENTLY_REALLY_IMPORTANT var0) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new class_234(var0);
      }
   }

   public class_234(APPARENTLY_REALLY_IMPORTANT var1) {
      this.field_340 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      if (var1 == null) {
         throw new class_427("Input Object must not be null");
      } else {
         return this.field_340.method_3(var1);
      }
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public APPARENTLY_REALLY_IMPORTANT[] method_4() {
      return new APPARENTLY_REALLY_IMPORTANT[]{this.field_340};
   }
}
