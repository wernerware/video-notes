package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.e.M
public final class class_231 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_333 = -2997501534564735525L;
   // $FF: renamed from: b org.a.a.a.an
   private final class_1 field_334;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   public static class_1 method_583(class_1 var0) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new class_231(var0);
      }
   }

   public class_231(class_1 var1) {
      this.field_334 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return var1 == null ? false : this.field_334.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public class_1[] method_4() {
      return new class_1[]{this.field_334};
   }
}
