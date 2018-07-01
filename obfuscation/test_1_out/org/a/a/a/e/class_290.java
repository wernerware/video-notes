package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_21;
import org.a.a.a.class_32;

// $FF: renamed from: org.a.a.a.e.u
public class class_290 implements Serializable, class_21 {
   // $FF: renamed from: a long
   private static final long field_447 = -6817674502475353160L;
   // $FF: renamed from: b org.a.a.a.s
   private final class_32 field_448;

   // $FF: renamed from: a (org.a.a.a.s) org.a.a.a.aI
   public static class_21 method_683(class_32 var0) {
      if (var0 == null) {
         throw new NullPointerException("Factory must not be null");
      } else {
         return new class_290(var0);
      }
   }

   public class_290(class_32 var1) {
      this.field_448 = var1;
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      return this.field_448.method_67();
   }

   // $FF: renamed from: a () org.a.a.a.s
   public class_32 method_684() {
      return this.field_448;
   }
}
