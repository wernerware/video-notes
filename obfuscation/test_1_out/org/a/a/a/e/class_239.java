package org.a.a.a.e;

import java.util.Collection;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.e.I
public final class class_239 extends class_235 {
   // $FF: renamed from: b long
   private static final long field_346 = 2007613066565892961L;

   // $FF: renamed from: a (org.a.a.a.an[]) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_593(APPARENTLY_REALLY_IMPORTANT... var0) {
      class_289.method_675(var0);
      return (APPARENTLY_REALLY_IMPORTANT)(var0.length == 0 ? class_345.method_877() : new class_239(class_289.method_673(var0)));
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_594(Collection var0) {
      APPARENTLY_REALLY_IMPORTANT[] var1 = class_289.method_676(var0);
      return (APPARENTLY_REALLY_IMPORTANT)(var1.length == 0 ? class_345.method_877() : new class_239(var1));
   }

   public class_239(APPARENTLY_REALLY_IMPORTANT... var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      APPARENTLY_REALLY_IMPORTANT[] var2 = this.a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         APPARENTLY_REALLY_IMPORTANT var5 = var2[var4];
         if (var5.method_3(var1)) {
            return false;
         }
      }

      return true;
   }
}
