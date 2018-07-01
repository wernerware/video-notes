package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.e.A
public class class_258 implements Serializable, class_21 {
   // $FF: renamed from: a long
   private static final long field_378 = 8069309411242014252L;
   // $FF: renamed from: b org.a.a.a.an
   private final class_1 field_379;
   // $FF: renamed from: c org.a.a.a.aI
   private final class_21 field_380;
   // $FF: renamed from: d org.a.a.a.aI
   private final class_21 field_381;

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.aI
   public static class_21 method_613(class_1 var0, class_21 var1, class_21 var2) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (var1 != null && var2 != null) {
         return new class_258(var0, var1, var2);
      } else {
         throw new NullPointerException("Transformers must not be null");
      }
   }

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.aI) org.a.a.a.aI
   public static class_21 method_614(class_1 var0, class_21 var1) {
      if (var0 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else if (var1 == null) {
         throw new NullPointerException("Transformer must not be null");
      } else {
         return new class_258(var0, var1, class_245.method_600());
      }
   }

   public class_258(class_1 var1, class_21 var2, class_21 var3) {
      this.field_379 = var1;
      this.field_380 = var2;
      this.field_381 = var3;
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      return this.field_379.method_3(var1) ? this.field_380.method_25(var1) : this.field_381.method_25(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an
   public class_1 method_615() {
      return this.field_379;
   }

   // $FF: renamed from: b () org.a.a.a.aI
   public class_21 method_616() {
      return this.field_380;
   }

   // $FF: renamed from: c () org.a.a.a.aI
   public class_21 method_617() {
      return this.field_381;
   }
}
