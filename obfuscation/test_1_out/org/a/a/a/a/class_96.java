package org.a.a.a.a;

import java.util.Set;
import org.a.a.a.class_21;
import org.a.a.a.class_22;
import org.a.a.a.c.class_90;
import org.a.a.a.n.class_92;

// $FF: renamed from: org.a.a.a.a.n
public class class_96 extends class_90 implements class_22 {
   // $FF: renamed from: b long
   private static final long field_88 = 5421170911299074185L;

   // $FF: renamed from: a (org.a.a.a.b, org.a.a.a.aI) org.a.a.a.b
   public static class_22 method_210(class_22 var0, class_21 var1) {
      return new class_96(var0, var1);
   }

   // $FF: renamed from: b (org.a.a.a.b, org.a.a.a.aI) org.a.a.a.b
   public static class_22 method_211(class_22 var0, class_21 var1) {
      class_96 var2 = new class_96(var0, var1);
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

   protected class_96(class_22 var1, class_21 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: e () org.a.a.a.b
   protected class_22 method_212() {
      return (class_22)this.f();
   }

   public boolean equals(Object var1) {
      return var1 == this || this.f().equals(var1);
   }

   public int hashCode() {
      return this.f().hashCode();
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_26(Object var1) {
      return this.method_212().method_26(var1);
   }

   // $FF: renamed from: b (java.lang.Object, int) boolean
   public boolean method_28(Object var1, int var2) {
      return this.method_212().method_28(var1, var2);
   }

   // $FF: renamed from: a (java.lang.Object, int) boolean
   public boolean method_27(Object var1, int var2) {
      return this.method_212().method_27(this.b(var1), var2);
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_29() {
      Set var1 = this.method_212().method_29();
      return class_92.method_199(var1, this.a);
   }
}
