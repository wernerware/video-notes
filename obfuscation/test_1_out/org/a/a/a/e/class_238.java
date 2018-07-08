package org.a.a.a.e;

import java.util.Collection;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.P
public final class class_238 extends class_235 {
   // $FF: renamed from: b long
   private static final long field_345 = -8125389089924745785L;

   // $FF: renamed from: a (org.a.a.a.an[]) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_591(APPARENTLY_REALLY_IMPORTANT... var0) {
      class_289.method_675(var0);
      if (var0.length == 0) {
         return class_291.method_685();
      } else {
         return (APPARENTLY_REALLY_IMPORTANT)(var0.length == 1 ? var0[0] : new class_238(class_289.method_673(var0)));
      }
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_592(Collection var0) {
      APPARENTLY_REALLY_IMPORTANT[] var1 = class_289.method_676(var0);
      return new class_238(var1);
   }

   public class_238(APPARENTLY_REALLY_IMPORTANT... var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      boolean var2 = false;
      APPARENTLY_REALLY_IMPORTANT[] var3 = this.a;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         APPARENTLY_REALLY_IMPORTANT var6 = var3[var5];
         if (var6.method_3(var1)) {
            if (var2) {
               return false;
            }

            var2 = true;
         }
      }

      return var2;
   }
}
