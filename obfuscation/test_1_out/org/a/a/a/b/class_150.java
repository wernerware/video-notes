package org.a.a.a.b;

import java.util.Map.Entry;
import org.a.a.a.class_30;

// $FF: renamed from: org.a.a.a.b.B
class class_150 implements Entry, class_30 {
   // $FF: renamed from: a java.lang.Comparable
   private final Comparable field_160;
   // $FF: renamed from: b java.lang.Comparable
   private final Comparable field_161;
   // $FF: renamed from: c org.a.a.a.b.B[]
   private final class_150[] field_162;
   // $FF: renamed from: d org.a.a.a.b.B[]
   private final class_150[] field_163;
   // $FF: renamed from: e org.a.a.a.b.B[]
   private final class_150[] field_164;
   // $FF: renamed from: f boolean[]
   private final boolean[] field_165;
   // $FF: renamed from: g int
   private int field_166;
   // $FF: renamed from: h boolean
   private boolean field_167;

   class_150(Comparable var1, Comparable var2) {
      this.field_160 = var1;
      this.field_161 = var2;
      this.field_162 = new class_150[2];
      this.field_163 = new class_150[2];
      this.field_164 = new class_150[2];
      this.field_165 = new boolean[]{true, true};
      this.field_167 = false;
   }

   // $FF: renamed from: a (org.a.a.a.b.u) java.lang.Object
   private Object method_402(class_361 var1) {
      switch(class_360.field_610[var1.ordinal()]) {
      case 1:
         return this.method_417();
      case 2:
         return this.method_418();
      default:
         throw new IllegalArgumentException();
      }
   }

   // $FF: renamed from: k (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_403(class_150 var1, class_361 var2) {
      this.field_162[var2.ordinal()] = var1;
   }

   // $FF: renamed from: b (org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_404(class_361 var1) {
      return this.field_162[var1.ordinal()];
   }

   // $FF: renamed from: l (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_405(class_150 var1, class_361 var2) {
      this.field_163[var2.ordinal()] = var1;
   }

   // $FF: renamed from: c (org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_406(class_361 var1) {
      return this.field_163[var1.ordinal()];
   }

   // $FF: renamed from: m (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_407(class_150 var1, class_361 var2) {
      this.field_164[var2.ordinal()] = var1;
   }

   // $FF: renamed from: d (org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_408(class_361 var1) {
      return this.field_164[var1.ordinal()];
   }

   // $FF: renamed from: n (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_409(class_150 var1, class_361 var2) {
      boolean[] var10000 = this.field_165;
      int var10001 = var2.ordinal();
      var10000[var10001] ^= var1.field_165[var2.ordinal()];
      var10000 = var1.field_165;
      var10001 = var2.ordinal();
      var10000[var10001] ^= this.field_165[var2.ordinal()];
      var10000 = this.field_165;
      var10001 = var2.ordinal();
      var10000[var10001] ^= var1.field_165[var2.ordinal()];
   }

   // $FF: renamed from: e (org.a.a.a.b.u) boolean
   private boolean method_410(class_361 var1) {
      return this.field_165[var1.ordinal()];
   }

   // $FF: renamed from: f (org.a.a.a.b.u) boolean
   private boolean method_411(class_361 var1) {
      return !this.field_165[var1.ordinal()];
   }

   // $FF: renamed from: g (org.a.a.a.b.u) void
   private void method_412(class_361 var1) {
      this.field_165[var1.ordinal()] = true;
   }

   // $FF: renamed from: h (org.a.a.a.b.u) void
   private void method_413(class_361 var1) {
      this.field_165[var1.ordinal()] = false;
   }

   // $FF: renamed from: o (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_414(class_150 var1, class_361 var2) {
      this.field_165[var2.ordinal()] = var1.field_165[var2.ordinal()];
   }

   // $FF: renamed from: i (org.a.a.a.b.u) boolean
   private boolean method_415(class_361 var1) {
      return this.field_164[var1.ordinal()] != null && this.field_164[var1.ordinal()].field_162[var1.ordinal()] == this;
   }

   // $FF: renamed from: j (org.a.a.a.b.u) boolean
   private boolean method_416(class_361 var1) {
      return this.field_164[var1.ordinal()] != null && this.field_164[var1.ordinal()].field_163[var1.ordinal()] == this;
   }

   // $FF: renamed from: a () java.lang.Comparable
   public Comparable method_417() {
      return this.field_160;
   }

   // $FF: renamed from: b () java.lang.Comparable
   public Comparable method_418() {
      return this.field_161;
   }

   // $FF: renamed from: a (java.lang.Comparable) java.lang.Comparable
   public Comparable method_419(Comparable var1) {
      throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         return this.method_417().equals(var2.getKey()) && this.method_418().equals(var2.getValue());
      }
   }

   public int hashCode() {
      if (!this.field_167) {
         this.field_166 = this.method_417().hashCode() ^ this.method_418().hashCode();
         this.field_167 = true;
      }

      return this.field_166;
   }

   // $FF: synthetic method
   public Object setValue(Object var1) {
      return this.method_419((Comparable)var1);
   }

   // $FF: synthetic method
   public Object getValue() {
      return this.method_418();
   }

   // $FF: synthetic method
   public Object getKey() {
      return this.method_417();
   }

   // $FF: renamed from: a (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_420(class_150 var0, class_361 var1) {
      return var0.method_404(var1);
   }

   // $FF: renamed from: a (org.a.a.a.b.B, org.a.a.a.b.B, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_421(class_150 var0, class_150 var1, class_361 var2) {
      var0.method_403(var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.b.B, org.a.a.a.b.B, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_422(class_150 var0, class_150 var1, class_361 var2) {
      var0.method_407(var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_423(class_150 var0, class_361 var1) {
      return var0.method_406(var1);
   }

   // $FF: renamed from: c (org.a.a.a.b.B, org.a.a.a.b.B, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_424(class_150 var0, class_150 var1, class_361 var2) {
      var0.method_405(var1, var2);
   }

   // $FF: renamed from: c (org.a.a.a.b.B, org.a.a.a.b.u) java.lang.Object
   // $FF: synthetic method
   static Object method_425(class_150 var0, class_361 var1) {
      return var0.method_402(var1);
   }

   // $FF: renamed from: d (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_426(class_150 var0, class_361 var1) {
      return var0.method_408(var1);
   }

   // $FF: renamed from: e (org.a.a.a.b.B, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_427(class_150 var0, class_361 var1) {
      var0.method_412(var1);
   }

   // $FF: renamed from: d (org.a.a.a.b.B, org.a.a.a.b.B, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_428(class_150 var0, class_150 var1, class_361 var2) {
      var0.method_414(var1, var2);
   }

   // $FF: renamed from: f (org.a.a.a.b.B, org.a.a.a.b.u) boolean
   // $FF: synthetic method
   static boolean method_429(class_150 var0, class_361 var1) {
      return var0.method_411(var1);
   }

   // $FF: renamed from: g (org.a.a.a.b.B, org.a.a.a.b.u) boolean
   // $FF: synthetic method
   static boolean method_430(class_150 var0, class_361 var1) {
      return var0.method_410(var1);
   }

   // $FF: renamed from: h (org.a.a.a.b.B, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_431(class_150 var0, class_361 var1) {
      var0.method_413(var1);
   }

   // $FF: renamed from: i (org.a.a.a.b.B, org.a.a.a.b.u) boolean
   // $FF: synthetic method
   static boolean method_432(class_150 var0, class_361 var1) {
      return var0.method_415(var1);
   }

   // $FF: renamed from: j (org.a.a.a.b.B, org.a.a.a.b.u) boolean
   // $FF: synthetic method
   static boolean method_433(class_150 var0, class_361 var1) {
      return var0.method_416(var1);
   }

   // $FF: renamed from: e (org.a.a.a.b.B, org.a.a.a.b.B, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_434(class_150 var0, class_150 var1, class_361 var2) {
      var0.method_409(var1, var2);
   }
}
