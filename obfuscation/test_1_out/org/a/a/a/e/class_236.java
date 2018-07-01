package org.a.a.a.e;

import java.util.Collection;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.e.b
public final class class_236 extends class_235 {
   // $FF: renamed from: b long
   private static final long field_343 = -3094696765038308799L;

   // $FF: renamed from: a (org.a.a.a.an[]) org.a.a.a.an
   public static class_1 method_587(class_1... var0) {
      class_289.method_675(var0);
      if (var0.length == 0) {
         return class_345.method_877();
      } else {
         return (class_1)(var0.length == 1 ? class_289.method_674(var0[0]) : new class_236(class_289.method_673(var0)));
      }
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.an
   public static class_1 method_588(Collection var0) {
      class_1[] var1 = class_289.method_676(var0);
      if (var1.length == 0) {
         return class_345.method_877();
      } else {
         return (class_1)(var1.length == 1 ? class_289.method_674(var1[0]) : new class_236(var1));
      }
   }

   public class_236(class_1... var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      class_1[] var2 = this.a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_1 var5 = var2[var4];
         if (!var5.method_3(var1)) {
            return false;
         }
      }

      return true;
   }
}
