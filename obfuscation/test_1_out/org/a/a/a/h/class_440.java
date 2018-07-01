package org.a.a.a.h;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_5;

// $FF: renamed from: org.a.a.a.h.z
class class_440 implements ListIterator, class_5 {
   // $FF: renamed from: a org.a.a.a.h.w
   private final class_443 field_775;
   // $FF: renamed from: b org.a.a.a.h.y
   private class_442 field_776;
   // $FF: renamed from: c int
   private int field_777;
   // $FF: renamed from: d org.a.a.a.h.y
   private class_442 field_778;
   // $FF: renamed from: e int
   private int field_779;
   // $FF: renamed from: f int
   private int field_780;

   protected class_440(class_443 var1, int var2) {
      this.field_775 = var1;
      this.field_780 = class_443.method_1513(var1);
      this.field_776 = class_443.method_1514(var1) == null ? null : class_443.method_1514(var1).method_1482(var2);
      this.field_777 = var2;
      this.field_779 = -1;
   }

   // $FF: renamed from: a () void
   protected void method_1479() {
      if (class_443.method_1515(this.field_775) != this.field_780) {
         throw new ConcurrentModificationException();
      }
   }

   public boolean hasNext() {
      return this.field_777 < this.field_775.size();
   }

   public Object next() {
      this.method_1479();
      if (!this.hasNext()) {
         throw new NoSuchElementException("No element at index " + this.field_777 + ".");
      } else {
         if (this.field_776 == null) {
            this.field_776 = class_443.method_1514(this.field_775).method_1482(this.field_777);
         }

         Object var1 = this.field_776.method_1480();
         this.field_778 = this.field_776;
         this.field_779 = this.field_777++;
         this.field_776 = this.field_776.method_1485();
         return var1;
      }
   }

   public boolean hasPrevious() {
      return this.field_777 > 0;
   }

   public Object previous() {
      this.method_1479();
      if (!this.hasPrevious()) {
         throw new NoSuchElementException("Already at start of list.");
      } else {
         if (this.field_776 == null) {
            this.field_776 = class_443.method_1514(this.field_775).method_1482(this.field_777 - 1);
         } else {
            this.field_776 = this.field_776.method_1486();
         }

         Object var1 = this.field_776.method_1480();
         this.field_778 = this.field_776;
         this.field_779 = --this.field_777;
         return var1;
      }
   }

   public int nextIndex() {
      return this.field_777;
   }

   public int previousIndex() {
      return this.nextIndex() - 1;
   }

   public void remove() {
      this.method_1479();
      if (this.field_779 == -1) {
         throw new IllegalStateException();
      } else {
         this.field_775.remove(this.field_779);
         if (this.field_777 != this.field_779) {
            --this.field_777;
         }

         this.field_776 = null;
         this.field_778 = null;
         this.field_779 = -1;
         ++this.field_780;
      }
   }

   public void set(Object var1) {
      this.method_1479();
      if (this.field_778 == null) {
         throw new IllegalStateException();
      } else {
         this.field_778.method_1481(var1);
      }
   }

   public void add(Object var1) {
      this.method_1479();
      this.field_775.add(this.field_777, var1);
      this.field_778 = null;
      this.field_779 = -1;
      ++this.field_777;
      ++this.field_780;
   }
}
