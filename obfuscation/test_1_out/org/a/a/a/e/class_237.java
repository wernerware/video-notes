package org.a.a.a.e;

import java.util.Collection;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.d
public final class class_237 extends class_235 {
   // $FF: renamed from: b long
   private static final long field_344 = 7429999530934647542L;

   // $FF: renamed from: a (org.a.a.a.an[]) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_589(APPARENTLY_REALLY_IMPORTANT... var0) {
      class_289.method_675(var0);
      if (var0.length == 0) {
         return class_291.method_685();
      } else {
         return (APPARENTLY_REALLY_IMPORTANT)(var0.length == 1 ? var0[0] : new class_237(class_289.method_673(var0)));
      }
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_590(Collection var0) {
      APPARENTLY_REALLY_IMPORTANT[] var1 = class_289.method_676(var0);
      if (var1.length == 0) {
         return class_291.method_685();
      } else {
         return (APPARENTLY_REALLY_IMPORTANT)(var1.length == 1 ? var1[0] : new class_237(var1));
      }
   }

   public class_237(APPARENTLY_REALLY_IMPORTANT... var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      APPARENTLY_REALLY_IMPORTANT[] var2 = this.a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         APPARENTLY_REALLY_IMPORTANT var5 = var2[var4];
         if (var5.method_3(var1)) {
            return true;
         }
      }

      return false;
   }
}
