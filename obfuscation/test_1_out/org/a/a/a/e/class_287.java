package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;
import org.a.a.a.class_34;

// $FF: renamed from: org.a.a.a.e.z
public class class_287 implements Serializable, class_34 {
   // $FF: renamed from: a long
   private static final long field_441 = 3518477308466486130L;
   // $FF: renamed from: b org.a.a.a.an
   private final class_1 field_442;
   // $FF: renamed from: c org.a.a.a.g
   private final class_34 field_443;
   // $FF: renamed from: d org.a.a.a.g
   private final class_34 field_444;

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_665(class_1 var0, class_34 var1) {
      return method_666(var0, var1, class_243.method_597());
   }

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.g, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_666(class_1 var0, class_34 var1, class_34 var2) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (var1 != null && var2 != null) {
         return new class_287(var0, var1, var2);
      } else {
         throw new NullPointerException("Closures must not be null");
      }
   }

   public class_287(class_1 var1, class_34 var2) {
      this(var1, var2, class_243.method_597());
   }

   public class_287(class_1 var1, class_34 var2, class_34 var3) {
      this.field_442 = var1;
      this.field_443 = var2;
      this.field_444 = var3;
   }

   // $FF: renamed from: a (java.lang.Object) void
   public void method_70(Object var1) {
      if (this.field_442.method_3(var1)) {
         this.field_443.method_70(var1);
      } else {
         this.field_444.method_70(var1);
      }

   }

   // $FF: renamed from: a () org.a.a.a.an
   public class_1 method_667() {
      return this.field_442;
   }

   // $FF: renamed from: b () org.a.a.a.g
   public class_34 method_668() {
      return this.field_443;
   }

   // $FF: renamed from: c () org.a.a.a.g
   public class_34 method_669() {
      return this.field_444;
   }
}
