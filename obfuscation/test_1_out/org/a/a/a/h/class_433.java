package org.a.a.a.h;

import java.util.ConcurrentModificationException;

// $FF: renamed from: org.a.a.a.h.i
public class class_433 extends class_431 {
   // $FF: renamed from: f boolean
   boolean field_754 = true;
   // $FF: renamed from: g boolean
   boolean field_755 = true;
   // $FF: renamed from: h boolean
   boolean field_756 = false;

   protected class_433(class_437 var1, int var2) {
      super(var1, var2);
      this.field_754 = true;
   }

   public void remove() {
      if (this.d != null || !this.field_756) {
         this.method_1427();
         this.a.method_1447(this.b());
      }

      this.field_756 = false;
   }

   public void add(Object var1) {
      super.add(var1);
      this.b = this.b.field_769;
   }

   public int nextIndex() {
      if (!this.field_755) {
         if (this.b == this.a.field_758) {
            this.c = this.a.size();
         } else {
            int var1 = 0;

            for(class_438 var2 = this.a.field_758.field_769; var2 != this.b; var2 = var2.field_769) {
               ++var1;
            }

            this.c = var1;
         }

         this.field_755 = true;
      }

      return this.c;
   }

   // $FF: renamed from: a (org.a.a.a.h.e) void
   protected void method_1429(class_438 var1) {
   }

   // $FF: renamed from: b (org.a.a.a.h.e) void
   protected void method_1430(class_438 var1) {
      if (var1 == this.b && var1 == this.d) {
         this.b = var1.field_769;
         this.d = null;
         this.field_756 = true;
      } else if (var1 == this.b) {
         this.b = var1.field_769;
         this.field_756 = false;
      } else if (var1 == this.d) {
         this.d = null;
         this.field_756 = true;
         --this.c;
      } else {
         this.field_755 = false;
         this.field_756 = false;
      }

   }

   // $FF: renamed from: c (org.a.a.a.h.e) void
   protected void method_1431(class_438 var1) {
      if (var1.field_768 == this.d) {
         this.b = var1;
      } else if (this.b.field_768 == var1) {
         this.b = var1;
      } else {
         this.field_755 = false;
      }

   }

   // $FF: renamed from: a () void
   protected void method_1427() {
      if (!this.field_754) {
         throw new ConcurrentModificationException("Cursor closed");
      }
   }

   // $FF: renamed from: c () void
   public void method_1432() {
      if (this.field_754) {
         ((class_437)this.a).method_1465(this);
         this.field_754 = false;
      }

   }
}
