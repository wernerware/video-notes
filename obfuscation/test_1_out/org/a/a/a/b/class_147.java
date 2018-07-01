package org.a.a.a.b;

import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.b.z
class class_147 extends class_145 implements class_7 {
   // $FF: renamed from: a org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_157;

   public class_147(class_362 var1, class_361 var2) {
      super(var1, var2);
      this.field_157 = var1;
   }

   // $FF: renamed from: c () java.lang.Comparable
   public Comparable method_390() {
      if (this.b == null) {
         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
      } else {
         return this.b.method_418();
      }
   }

   // $FF: renamed from: d () java.lang.Comparable
   public Comparable method_391() {
      if (this.b == null) {
         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
      } else {
         return this.b.method_417();
      }
   }

   // $FF: renamed from: a (java.lang.Comparable) java.lang.Comparable
   public Comparable method_392(Comparable var1) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: e () java.lang.Comparable
   public Comparable method_393() {
      return this.g().method_418();
   }

   // $FF: renamed from: f () java.lang.Comparable
   public Comparable method_394() {
      return this.h().method_418();
   }

   // $FF: synthetic method
   public Object previous() {
      return this.method_394();
   }

   // $FF: renamed from: b () java.lang.Object
   // $FF: synthetic method
   public Object method_7() {
      return this.method_391();
   }

   // $FF: renamed from: a () java.lang.Object
   // $FF: synthetic method
   public Object method_6() {
      return this.method_390();
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_393();
   }
}
