package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.e.K
public final class class_233 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_337 = -2654603322338049674L;
   // $FF: renamed from: b org.a.a.a.an
   private final class_1 field_338;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   public static class_1 method_585(class_1 var0) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new class_233(var0);
      }
   }

   public class_233(class_1 var1) {
      this.field_338 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return !this.field_338.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public class_1[] method_4() {
      return new class_1[]{this.field_338};
   }
}
