package org.a.a.a;

import java.util.Map;

// $FF: renamed from: org.a.a.a.m
class class_406 {
   // $FF: renamed from: a java.util.Map
   final Map field_714;
   // $FF: renamed from: b java.util.Map
   final Map field_715;

   public class_406(Iterable var1, Iterable var2) {
      this.field_714 = class_415.method_1335(var1);
      this.field_715 = class_415.method_1335(var2);
   }

   // $FF: renamed from: a (java.lang.Object) int
   public final int method_1290(Object var1) {
      return Math.max(this.method_1292(var1), this.method_1293(var1));
   }

   // $FF: renamed from: b (java.lang.Object) int
   public final int method_1291(Object var1) {
      return Math.min(this.method_1292(var1), this.method_1293(var1));
   }

   // $FF: renamed from: c (java.lang.Object) int
   public int method_1292(Object var1) {
      return this.method_1294(var1, this.field_714);
   }

   // $FF: renamed from: d (java.lang.Object) int
   public int method_1293(Object var1) {
      return this.method_1294(var1, this.field_715);
   }

   // $FF: renamed from: a (java.lang.Object, java.util.Map) int
   private final int method_1294(Object var1, Map var2) {
      Integer var3 = (Integer)var2.get(var1);
      return var3 != null ? var3 : 0;
   }
}
