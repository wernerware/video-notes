package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.e.N
public final class class_232 implements Serializable, class_2 {
   // $FF: renamed from: a long
   private static final long field_335 = -7625133768987126273L;
   // $FF: renamed from: b org.a.a.a.an
   private final class_1 field_336;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.an
   public static class_1 method_584(class_1 var0) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         return new class_232(var0);
      }
   }

   public class_232(class_1 var1) {
      this.field_336 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return var1 == null ? true : this.field_336.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public class_1[] method_4() {
      return new class_1[]{this.field_336};
   }
}
