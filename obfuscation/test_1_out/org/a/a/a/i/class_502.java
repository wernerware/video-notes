package org.a.a.a.i;

import java.util.NoSuchElementException;
import org.a.a.a.class_20;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.i.Z
class class_502 implements class_4, class_20 {
   // $FF: renamed from: a org.a.a.a.i.U
   private final class_504 field_914;
   // $FF: renamed from: b int
   private int field_915 = 0;
   // $FF: renamed from: c boolean
   private boolean field_916 = false;

   class_502(class_504 var1) {
      this.field_914 = var1;
   }

   public boolean hasNext() {
      return this.field_915 < class_504.method_1595(this.field_914);
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException("No next() entry in the iteration");
      } else {
         this.field_916 = true;
         ++this.field_915;
         return this.method_6();
      }
   }

   public void remove() {
      if (!this.field_916) {
         throw new IllegalStateException("remove() can only be called once after next()");
      } else {
         this.field_914.remove(this.method_6());
         --this.field_915;
         this.field_916 = false;
      }
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (!this.field_916) {
         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
      } else {
         switch(this.field_915) {
         case 1:
            return class_504.method_1598(this.field_914);
         case 2:
            return class_504.method_1597(this.field_914);
         case 3:
            return class_504.method_1596(this.field_914);
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_915);
         }
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (!this.field_916) {
         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
      } else {
         switch(this.field_915) {
         case 1:
            return class_504.method_1601(this.field_914);
         case 2:
            return class_504.method_1600(this.field_914);
         case 3:
            return class_504.method_1599(this.field_914);
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_915);
         }
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (!this.field_916) {
         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
      } else {
         Object var2 = this.method_7();
         switch(this.field_915) {
         case 1:
            class_504.method_1604(this.field_914, var1);
            break;
         case 2:
            class_504.method_1603(this.field_914, var1);
            break;
         case 3:
            class_504.method_1602(this.field_914, var1);
            break;
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_915);
         }

         return var2;
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_915 = 0;
      this.field_916 = false;
   }

   public String toString() {
      return this.field_916 ? "Iterator[" + this.method_6() + "=" + this.method_7() + "]" : "Iterator[]";
   }
}
