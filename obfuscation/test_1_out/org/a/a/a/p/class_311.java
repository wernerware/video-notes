package org.a.a.a.p;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.p.s
abstract class class_311 implements Iterator {
   // $FF: renamed from: b int
   protected int field_504;
   // $FF: renamed from: c org.a.a.a.p.r
   protected class_301 field_505;
   // $FF: renamed from: d org.a.a.a.p.r
   protected class_301 field_506;
   // $FF: renamed from: e org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_507;

   protected class_311(class_303 var1) {
      this.field_507 = var1;
      this.field_504 = this.field_507.field_488;
      this.field_505 = var1.method_725((class_301)null);
   }

   protected class_311(class_303 var1, class_301 var2) {
      this.field_507 = var1;
      this.field_504 = this.field_507.field_488;
      this.field_505 = var2;
   }

   // $FF: renamed from: c () org.a.a.a.p.r
   protected class_301 method_745() {
      if (this.field_504 != this.field_507.field_488) {
         throw new ConcurrentModificationException();
      } else {
         class_301 var1 = this.field_505;
         if (var1 == null) {
            throw new NoSuchElementException();
         } else {
            this.field_505 = this.method_746(var1);
            this.field_506 = var1;
            return var1;
         }
      }
   }

   // $FF: renamed from: a (org.a.a.a.p.r) org.a.a.a.p.r
   protected class_301 method_746(class_301 var1) {
      return this.field_507.method_725(var1);
   }

   public boolean hasNext() {
      return this.field_505 != null;
   }

   public void remove() {
      if (this.field_506 == null) {
         throw new IllegalStateException();
      } else if (this.field_504 != this.field_507.field_488) {
         throw new ConcurrentModificationException();
      } else {
         class_301 var1 = this.field_506;
         this.field_506 = null;
         this.field_507.method_722(var1);
         this.field_504 = this.field_507.field_488;
      }
   }
}
