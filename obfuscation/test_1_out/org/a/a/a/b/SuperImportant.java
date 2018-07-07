package org.a.a.a.b;

import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.b.G
class class_148 extends class_145 implements class_7 {
   // $FF: renamed from: a org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_158;

   class_148(class_362 var1, class_361 var2) {
      super(var1, var2);
      this.field_158 = var1;
   }

   // $FF: renamed from: c () java.lang.Comparable
   public Comparable method_395() {
      if (this.b == null) {
         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
      } else {
         return this.b.method_417();
      }
   }

   // $FF: renamed from: d () java.lang.Comparable
   public Comparable method_396() {
      if (this.b == null) {
         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
      } else {
         return this.b.method_418();
      }
   }

   // $FF: renamed from: a (java.lang.Comparable) java.lang.Comparable
   public Comparable method_397(Comparable var1) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: e () java.lang.Comparable
   public Comparable method_398() {
      return this.g().method_417();
   }

   // $FF: renamed from: f () java.lang.Comparable
   public Comparable method_399() {
      return this.h().method_417();
   }

   // $FF: synthetic method
   public Object previous() {
      return this.method_399();
   }

   // $FF: renamed from: b () java.lang.Object
   // $FF: synthetic method
   public Object method_7() {
      return this.method_396();
   }

   // $FF: renamed from: a () java.lang.Object
   // $FF: synthetic method
   public Object method_6() {
      return this.method_395();
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_398();
   }
}
