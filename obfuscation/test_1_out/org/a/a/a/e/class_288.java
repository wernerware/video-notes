package org.a.a.a.e;

import org.a.a.a.class_34;

// $FF: renamed from: org.a.a.a.e.w
public class class_288 implements class_34 {
   // $FF: renamed from: a int
   private final int field_445;
   // $FF: renamed from: b org.a.a.a.g
   private final class_34 field_446;

   // $FF: renamed from: a (int, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_670(int var0, class_34 var1) {
      if (var0 > 0 && var1 != null) {
         return (class_34)(var0 == 1 ? var1 : new class_288(var0, var1));
      } else {
         return class_243.method_597();
      }
   }

   public class_288(int var1, class_34 var2) {
      this.field_445 = var1;
      this.field_446 = var2;
   }

   // $FF: renamed from: a (java.lang.Object) void
   public void method_70(Object var1) {
      for(int var2 = 0; var2 < this.field_445; ++var2) {
         this.field_446.method_70(var1);
      }

   }

   // $FF: renamed from: a () org.a.a.a.g
   public class_34 method_671() {
      return this.field_446;
   }

   // $FF: renamed from: b () int
   public int method_672() {
      return this.field_445;
   }
}
