package org.a.a.a.p;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.p.t
class class_312 extends class_311 implements class_7 {
   // $FF: renamed from: a org.a.a.a.p.r
   protected class_301 field_508;
   // $FF: renamed from: f org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_509;

   private class_312(class_303 var1) {
      super(var1);
      this.field_509 = var1;
   }

   public Object next() {
      return this.method_745().getKey();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (this.d == null) {
         throw new IllegalStateException();
      } else {
         return this.d.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (this.d == null) {
         throw new IllegalStateException();
      } else {
         return this.d.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (this.d == null) {
         throw new IllegalStateException();
      } else {
         return this.d.setValue(var1);
      }
   }

   public boolean hasPrevious() {
      return this.field_508 != null;
   }

   public Object previous() {
      return this.method_747().getKey();
   }

   // $FF: renamed from: c () org.a.a.a.p.r
   protected class_301 method_745() {
      class_301 var1 = super.method_745();
      this.field_508 = var1;
      return var1;
   }

   // $FF: renamed from: d () org.a.a.a.p.r
   protected class_301 method_747() {
      if (this.b != this.field_509.field_488) {
         throw new ConcurrentModificationException();
      } else {
         class_301 var1 = this.field_508;
         if (var1 == null) {
            throw new NoSuchElementException();
         } else {
            this.field_508 = this.field_509.method_737(var1);
            this.c = this.d;
            this.d = var1;
            return this.d;
         }
      }
   }

   // $FF: synthetic method
   class_312(class_303 var1, class_330 var2) {
      this(var1);
   }
}
