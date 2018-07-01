package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.e.Q
public final class class_273 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_407 = -8791518325735182855L;
   // $FF: renamed from: b org.a.a.a.an
   private final class_1 field_408;
   // $FF: renamed from: c org.a.a.a.an
   private final class_1 field_409;

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.an) org.a.a.a.an
   public static class_1 method_642(class_1 var0, class_1 var1) {
      if (var0 != null && var1 != null) {
         return new class_273(var0, var1);
      } else {
         throw new NullPointerException("Predicate must not be null");
      }
   }

   public class_273(class_1 var1, class_1 var2) {
      this.field_408 = var1;
      this.field_409 = var2;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return this.field_408.method_3(var1) || this.field_409.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public class_1[] method_4() {
      return new class_1[]{this.field_408, this.field_409};
   }
}
