package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.class_33;

// $FF: renamed from: org.a.a.a.e.p
public final class class_297 implements Serializable, APPARENTLY_REALLY_IMPORTANT {
   // $FF: renamed from: a long
   private static final long field_462 = 5633766978029907089L;
   // $FF: renamed from: b java.lang.Object
   private final Object field_463;
   // $FF: renamed from: c org.a.a.a.r
   private final class_33 field_464;

   // $FF: renamed from: b (java.lang.Object) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_697(Object var0) {
      return (APPARENTLY_REALLY_IMPORTANT)(var0 == null ? class_274.method_643() : new class_297(var0));
   }

   // $FF: renamed from: a (java.lang.Object, org.a.a.a.r) org.a.a.a.an
   public static APPARENTLY_REALLY_IMPORTANT method_698(Object var0, class_33 var1) {
      return (APPARENTLY_REALLY_IMPORTANT)(var0 == null ? class_274.method_643() : new class_297(var0, var1));
   }

   public class_297(Object var1) {
      this(var1, (class_33)null);
   }

   public class_297(Object var1, class_33 var2) {
      this.field_463 = var1;
      this.field_464 = var2;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      return this.field_464 != null ? this.field_464.method_68(this.field_463, var1) : this.field_463.equals(var1);
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_699() {
      return this.field_463;
   }
}
