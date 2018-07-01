package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.e.B
public final class class_260 implements Serializable, class_1 {
   // $FF: renamed from: a long
   private static final long field_383 = -6682656911025165584L;
   // $FF: renamed from: b java.lang.Class
   private final Class field_384;

   // $FF: renamed from: a (java.lang.Class) org.a.a.a.an
   public static class_1 method_618(Class var0) {
      if (var0 == null) {
         throw new NullPointerException("The type to check instanceof must not be null");
      } else {
         return new class_260(var0);
      }
   }

   public class_260(Class var1) {
      this.field_384 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return this.field_384.isInstance(var1);
   }

   // $FF: renamed from: a () java.lang.Class
   public Class method_619() {
      return this.field_384;
   }
}
