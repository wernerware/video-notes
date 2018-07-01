package org.a.a.a.i;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.a.a.a.class_15;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.f.class_161;
import org.a.a.a.f.class_164;

// $FF: renamed from: org.a.a.a.i.p
public abstract class class_153 extends class_151 implements class_15 {
   // $FF: renamed from: t org.a.a.a.i.s
   transient class_497 field_188;

   protected class_153() {
   }

   protected class_153(int var1, float var2, int var3) {
      super(var1, var2, var3);
   }

   protected class_153(int var1) {
      super(var1);
   }

   protected class_153(int var1, float var2) {
      super(var1, var2);
   }

   protected class_153(Map var1) {
      super(var1);
   }

   // $FF: renamed from: d () void
   protected void method_435() {
      this.field_188 = this.method_470((class_496)null, -1, (Object)null, (Object)null);
      this.field_188.field_907 = this.field_188.field_908 = this.field_188;
   }

   public boolean containsValue(Object var1) {
      class_497 var2;
      if (var1 == null) {
         for(var2 = this.field_188.field_908; var2 != this.field_188; var2 = var2.field_908) {
            if (var2.getValue() == null) {
               return true;
            }
         }
      } else {
         for(var2 = this.field_188.field_908; var2 != this.field_188; var2 = var2.field_908) {
            if (this.b(var1, var2.getValue())) {
               return true;
            }
         }
      }

      return false;
   }

   public void clear() {
      super.clear();
      this.field_188.field_907 = this.field_188.field_908 = this.field_188;
   }

   public Object firstKey() {
      if (this.m == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.field_188.field_908.getKey();
      }
   }

   public Object lastKey() {
      if (this.m == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.field_188.field_907.getKey();
      }
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      class_497 var2 = this.method_468(var1);
      return var2 != null && var2.field_908 != this.field_188 ? var2.field_908.getKey() : null;
   }

   // $FF: renamed from: f (java.lang.Object) org.a.a.a.i.s
   protected class_497 method_468(Object var1) {
      return (class_497)super.method_442(var1);
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      class_497 var2 = this.method_468(var1);
      return var2 != null && var2.field_907 != this.field_188 ? var2.field_907.getKey() : null;
   }

   // $FF: renamed from: c (int) org.a.a.a.i.s
   protected class_497 method_469(int var1) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException("Index " + var1 + " is less than zero");
      } else if (var1 >= this.m) {
         throw new IndexOutOfBoundsException("Index " + var1 + " is invalid for size " + this.m);
      } else {
         class_497 var2;
         int var3;
         if (var1 < this.m / 2) {
            var2 = this.field_188.field_908;

            for(var3 = 0; var3 < var1; ++var3) {
               var2 = var2.field_908;
            }
         } else {
            var2 = this.field_188;

            for(var3 = this.m; var3 > var1; --var3) {
               var2 = var2.field_907;
            }
         }

         return var2;
      }
   }

   // $FF: renamed from: a (org.a.a.a.i.d, int) void
   protected void method_447(class_496 var1, int var2) {
      class_497 var3 = (class_497)var1;
      var3.field_908 = this.field_188;
      var3.field_907 = this.field_188.field_907;
      this.field_188.field_907.field_908 = var3;
      this.field_188.field_907 = var3;
      this.n[var2] = var3;
   }

   // $FF: renamed from: b (org.a.a.a.i.d, int, java.lang.Object, java.lang.Object) org.a.a.a.i.s
   protected class_497 method_470(class_496 var1, int var2, Object var3, Object var4) {
      return new class_497(var1, var2, this.a(var3), var4);
   }

   // $FF: renamed from: b (org.a.a.a.i.d, int, org.a.a.a.i.d) void
   protected void method_449(class_496 var1, int var2, class_496 var3) {
      class_497 var4 = (class_497)var1;
      var4.field_907.field_908 = var4.field_908;
      var4.field_908.field_907 = var4.field_907;
      var4.field_908 = null;
      var4.field_907 = null;
      super.method_449(var1, var2, var3);
   }

   // $FF: renamed from: a (org.a.a.a.i.s) org.a.a.a.i.s
   protected class_497 method_471(class_497 var1) {
      return var1.field_907;
   }

   // $FF: renamed from: b (org.a.a.a.i.s) org.a.a.a.i.s
   protected class_497 method_472(class_497 var1) {
      return var1.field_908;
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return (class_7)(this.m == 0 ? class_164.method_513() : new class_517(this));
   }

   // $FF: renamed from: g () java.util.Iterator
   protected Iterator method_459() {
      return (Iterator)(this.size() == 0 ? class_161.method_508() : new class_515(this));
   }

   // $FF: renamed from: h () java.util.Iterator
   protected Iterator method_460() {
      return (Iterator)(this.size() == 0 ? class_161.method_508() : new class_514(this));
   }

   // $FF: renamed from: i () java.util.Iterator
   protected Iterator method_461() {
      return (Iterator)(this.size() == 0 ? class_161.method_508() : new class_516(this));
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }

   // $FF: renamed from: a (org.a.a.a.i.d, int, java.lang.Object, java.lang.Object) org.a.a.a.i.d
   // $FF: synthetic method
   protected class_496 method_446(class_496 var1, int var2, Object var3, Object var4) {
      return this.method_470(var1, var2, var3, var4);
   }

   // $FF: renamed from: e (java.lang.Object) org.a.a.a.i.d
   // $FF: synthetic method
   protected class_496 method_442(Object var1) {
      return this.method_468(var1);
   }
}
