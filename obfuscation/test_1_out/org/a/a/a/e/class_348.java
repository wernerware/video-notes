package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.e.aa
public final class class_348 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_581 = -5596090919668315834L;
   // $FF: renamed from: b org.a.a.a.aI
   private final class_21 field_582;
   // $FF: renamed from: c org.a.a.a.an
   private final class_1 field_583;

   // $FF: renamed from: a (org.a.a.a.aI, org.a.a.a.an) org.a.a.a.an
   public static class_1 method_883(class_21 var0, class_1 var1) {
      if (var0 == null) {
         throw new NullPointerException("The transformer to call must not be null");
      } else if (var1 == null) {
         throw new NullPointerException("The predicate to call must not be null");
      } else {
         return new class_348(var0, var1);
      }
   }

   public class_348(class_21 var1, class_1 var2) {
      this.field_582 = var1;
      this.field_583 = var2;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      Object var2 = this.field_582.method_25(var1);
      return this.field_583.method_3(var2);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public class_1[] method_4() {
      return new class_1[]{this.field_583};
   }

   // $FF: renamed from: b () org.a.a.a.aI
   public class_21 method_884() {
      return this.field_582;
   }
}
