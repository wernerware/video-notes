package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_21;
import org.a.a.a.class_34;

// $FF: renamed from: org.a.a.a.e.i
public class class_279 implements Serializable, class_21 {
   // $FF: renamed from: a long
   private static final long field_425 = 478466901448617286L;
   // $FF: renamed from: b org.a.a.a.g
   private final class_34 field_426;

   // $FF: renamed from: a (org.a.a.a.g) org.a.a.a.aI
   public static class_21 method_650(class_34 var0) {
      if (var0 == null) {
         throw new NullPointerException("Closure must not be null");
      } else {
         return new class_279(var0);
      }
   }

   public class_279(class_34 var1) {
      this.field_426 = var1;
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      this.field_426.method_70(var1);
      return var1;
   }

   // $FF: renamed from: a () org.a.a.a.g
   public class_34 method_651() {
      return this.field_426;
   }
}
