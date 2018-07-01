package org.a.a.a.i;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.i.t
public abstract class class_513 {
   // $FF: renamed from: a org.a.a.a.i.p
   protected final class_153 field_939;
   // $FF: renamed from: b org.a.a.a.i.s
   protected class_497 field_940;
   // $FF: renamed from: c org.a.a.a.i.s
   protected class_497 field_941;
   // $FF: renamed from: d int
   protected int field_942;

   protected class_513(class_153 var1) {
      this.field_939 = var1;
      this.field_941 = var1.field_188.field_908;
      this.field_942 = var1.p;
   }

   public boolean hasNext() {
      return this.field_941 != this.field_939.field_188;
   }

   public boolean hasPrevious() {
      return this.field_941.field_907 != this.field_939.field_188;
   }

   // $FF: renamed from: d () org.a.a.a.i.s
   protected class_497 method_1610() {
      if (this.field_939.p != this.field_942) {
         throw new ConcurrentModificationException();
      } else if (this.field_941 == this.field_939.field_188) {
         throw new NoSuchElementException("No next() entry in the iteration");
      } else {
         this.field_940 = this.field_941;
         this.field_941 = this.field_941.field_908;
         return this.field_940;
      }
   }

   // $FF: renamed from: e () org.a.a.a.i.s
   protected class_497 method_1611() {
      if (this.field_939.p != this.field_942) {
         throw new ConcurrentModificationException();
      } else {
         class_497 var1 = this.field_941.field_907;
         if (var1 == this.field_939.field_188) {
            throw new NoSuchElementException("No previous() entry in the iteration");
         } else {
            this.field_941 = var1;
            this.field_940 = var1;
            return this.field_940;
         }
      }
   }

   // $FF: renamed from: f () org.a.a.a.i.s
   protected class_497 method_1612() {
      return this.field_940;
   }

   public void remove() {
      if (this.field_940 == null) {
         throw new IllegalStateException("remove() can only be called once after next()");
      } else if (this.field_939.p != this.field_942) {
         throw new ConcurrentModificationException();
      } else {
         this.field_939.remove(this.field_940.getKey());
         this.field_940 = null;
         this.field_942 = this.field_939.p;
      }
   }

   // $FF: renamed from: c () void
   public void method_1613() {
      this.field_940 = null;
      this.field_941 = this.field_939.field_188.field_908;
   }

   public String toString() {
      return this.field_940 != null ? "Iterator[" + this.field_940.getKey() + "=" + this.field_940.getValue() + "]" : "Iterator[]";
   }
}
