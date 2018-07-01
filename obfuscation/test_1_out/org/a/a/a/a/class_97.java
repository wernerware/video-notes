package org.a.a.a.a;

import java.util.Comparator;
import org.a.a.a.class_21;
import org.a.a.a.class_23;

// $FF: renamed from: org.a.a.a.a.o
public class class_97 extends class_96 implements class_23 {
   // $FF: renamed from: b long
   private static final long field_89 = -251737742649401930L;

   // $FF: renamed from: a (org.a.a.a.aC, org.a.a.a.aI) org.a.a.a.a.o
   public static class_97 method_213(class_23 var0, class_21 var1) {
      return new class_97(var0, var1);
   }

   // $FF: renamed from: b (org.a.a.a.aC, org.a.a.a.aI) org.a.a.a.a.o
   public static class_97 method_214(class_23 var0, class_21 var1) {
      class_97 var2 = new class_97(var0, var1);
      if (var0.size() > 0) {
         Object[] var3 = (Object[])var0.toArray();
         var0.clear();
         Object[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            var2.f().add(var1.method_25(var7));
         }
      }

      return var2;
   }

   protected class_97(class_23 var1, class_21 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: g () org.a.a.a.aC
   protected class_23 method_215() {
      return (class_23)this.f();
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_31() {
      return this.method_215().method_31();
   }

   // $FF: renamed from: d () java.lang.Object
   public Object method_32() {
      return this.method_215().method_32();
   }

   // $FF: renamed from: b () java.util.Comparator
   public Comparator method_30() {
      return this.method_215().method_30();
   }
}
