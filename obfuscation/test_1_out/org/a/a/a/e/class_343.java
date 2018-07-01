package org.a.a.a.e;

import org.a.a.a.class_1;
import org.a.a.a.class_34;

// $FF: renamed from: org.a.a.a.e.af
public class class_343 implements class_34 {
   // $FF: renamed from: a org.a.a.a.an
   private final class_1 field_570;
   // $FF: renamed from: b org.a.a.a.g
   private final class_34 field_571;
   // $FF: renamed from: c boolean
   private final boolean field_572;

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.g, boolean) org.a.a.a.g
   public static class_34 method_872(class_1 var0, class_34 var1, boolean var2) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (var1 == null) {
         throw new NullPointerException("Closure must not be null");
      } else {
         return new class_343(var0, var1, var2);
      }
   }

   public class_343(class_1 var1, class_34 var2, boolean var3) {
      this.field_570 = var1;
      this.field_571 = var2;
      this.field_572 = var3;
   }

   // $FF: renamed from: a (java.lang.Object) void
   public void method_70(Object var1) {
      if (this.field_572) {
         this.field_571.method_70(var1);
      }

      while(this.field_570.method_3(var1)) {
         this.field_571.method_70(var1);
      }

   }

   // $FF: renamed from: a () org.a.a.a.an
   public class_1 method_873() {
      return this.field_570;
   }

   // $FF: renamed from: b () org.a.a.a.g
   public class_34 method_874() {
      return this.field_571;
   }

   // $FF: renamed from: c () boolean
   public boolean method_875() {
      return this.field_572;
   }
}
