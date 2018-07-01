package org.a.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.a.a.a.a.class_364;
import org.a.a.a.j.class_469;
import org.a.a.a.j.class_471;
import org.a.a.a.j.class_478;
import org.a.a.a.j.class_479;

// $FF: renamed from: org.a.a.a.ae
public class class_349 {
   // $FF: renamed from: a org.a.a.a.ai
   public static final class_24 field_584 = class_478.method_1573(new class_471(0, 0));

   // $FF: renamed from: a () org.a.a.a.ai
   public static class_24 method_885() {
      return field_584;
   }

   // $FF: renamed from: a (org.a.a.a.ai) org.a.a.a.ai
   public static class_24 method_886(class_24 var0) {
      return var0 == null ? field_584 : var0;
   }

   // $FF: renamed from: b (org.a.a.a.ai) boolean
   public static boolean method_887(class_24 var0) {
      return var0 == null || var0.method_34();
   }

   // $FF: renamed from: a (org.a.a.a.ai, java.lang.Object) java.util.Collection
   public static Collection method_888(class_24 var0, Object var1) {
      return var0 != null ? var0.method_38(var1) : null;
   }

   // $FF: renamed from: b (org.a.a.a.ai, java.lang.Object) java.util.List
   public static List method_889(class_24 var0, Object var1) {
      if (var0 != null) {
         Collection var2 = var0.method_38(var1);
         return (List)(var2 instanceof List ? (List)var2 : new ArrayList(var2));
      } else {
         return null;
      }
   }

   // $FF: renamed from: c (org.a.a.a.ai, java.lang.Object) java.util.Set
   public static Set method_890(class_24 var0, Object var1) {
      if (var0 != null) {
         Collection var2 = var0.method_38(var1);
         return (Set)(var2 instanceof Set ? (Set)var2 : new HashSet(var2));
      } else {
         return null;
      }
   }

   // $FF: renamed from: d (org.a.a.a.ai, java.lang.Object) org.a.a.a.b
   public static class_22 method_891(class_24 var0, Object var1) {
      if (var0 != null) {
         Collection var2 = var0.method_38(var1);
         return (class_22)(var2 instanceof class_22 ? (class_22)var2 : new class_364(var2));
      } else {
         return null;
      }
   }

   // $FF: renamed from: b () org.a.a.a.Y
   public static class_25 method_892() {
      return new class_471();
   }

   // $FF: renamed from: c () org.a.a.a.aB
   public static class_26 method_893() {
      return new class_469();
   }

   // $FF: renamed from: c (org.a.a.a.ai) org.a.a.a.ai
   public static class_24 method_894(class_24 var0) {
      return class_478.method_1573(var0);
   }

   // $FF: renamed from: a (org.a.a.a.ai, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.ai
   public static class_24 method_895(class_24 var0, class_21 var1, class_21 var2) {
      return class_479.method_1574(var0, var1, var2);
   }
}
