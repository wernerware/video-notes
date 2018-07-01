package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.e.S
public class class_271 implements Serializable, class_21 {
   // $FF: renamed from: a long
   private static final long field_405 = 5278818408044349346L;
   // $FF: renamed from: b org.a.a.a.an
   private final class_1 field_406;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.aI
   public static class_21 method_638(class_1 var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("Predicate must not be null");
      } else {
         return new class_271(var0);
      }
   }

   public class_271(class_1 var1) {
      this.field_406 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Boolean
   public Boolean method_639(Object var1) {
      return this.field_406.method_3(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an
   public class_1 method_640() {
      return this.field_406;
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_25(Object var1) {
      return this.method_639(var1);
   }
}
