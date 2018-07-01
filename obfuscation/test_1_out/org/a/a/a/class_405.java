package org.a.a.a;

import java.util.Collection;
import java.util.Comparator;
import org.a.a.a.d.class_39;
import org.a.a.a.d.class_40;
import org.a.a.a.d.class_42;
import org.a.a.a.d.class_45;
import org.a.a.a.d.class_46;
import org.a.a.a.d.class_47;

// $FF: renamed from: org.a.a.a.p
public class class_405 {
   // $FF: renamed from: a java.util.Comparator
   public static final Comparator field_713 = class_45.method_86();

   // $FF: renamed from: a () java.util.Comparator
   public static Comparator method_1280() {
      return field_713;
   }

   // $FF: renamed from: a (java.util.Comparator[]) java.util.Comparator
   public static Comparator method_1281(Comparator... var0) {
      class_46 var1 = new class_46();
      Comparator[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Comparator var5 = var2[var4];
         if (var5 == null) {
            throw new NullPointerException("Comparator cannot be null");
         }

         var1.method_88(var5);
      }

      return var1;
   }

   // $FF: renamed from: a (java.util.Collection) java.util.Comparator
   public static Comparator method_1282(Collection var0) {
      return method_1281((Comparator[])((Comparator[])var0.toArray(new Comparator[var0.size()])));
   }

   // $FF: renamed from: a (java.util.Comparator) java.util.Comparator
   public static Comparator method_1283(Comparator var0) {
      return new class_39(var0);
   }

   // $FF: renamed from: a (boolean) java.util.Comparator
   public static Comparator method_1284(boolean var0) {
      return class_47.method_100(var0);
   }

   // $FF: renamed from: b (java.util.Comparator) java.util.Comparator
   public static Comparator method_1285(Comparator var0) {
      if (var0 == null) {
         var0 = field_713;
      }

      return new class_42(var0, false);
   }

   // $FF: renamed from: c (java.util.Comparator) java.util.Comparator
   public static Comparator method_1286(Comparator var0) {
      if (var0 == null) {
         var0 = field_713;
      }

      return new class_42(var0, true);
   }

   // $FF: renamed from: a (java.util.Comparator, org.a.a.a.aI) java.util.Comparator
   public static Comparator method_1287(Comparator var0, class_21 var1) {
      if (var0 == null) {
         var0 = field_713;
      }

      return new class_40(var1, var0);
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object, java.util.Comparator) java.lang.Object
   public static Object method_1288(Object var0, Object var1, Comparator var2) {
      if (var2 == null) {
         var2 = field_713;
      }

      int var3 = var2.compare(var0, var1);
      return var3 < 0 ? var0 : var1;
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object, java.util.Comparator) java.lang.Object
   public static Object method_1289(Object var0, Object var1, Comparator var2) {
      if (var2 == null) {
         var2 = field_713;
      }

      int var3 = var2.compare(var0, var1);
      return var3 > 0 ? var0 : var1;
   }
}
