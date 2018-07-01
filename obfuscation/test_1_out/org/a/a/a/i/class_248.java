package org.a.a.a.i;

import java.util.ListIterator;
import org.a.a.a.class_20;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.i.aq
class class_248 implements class_7, class_20 {
   // $FF: renamed from: a org.a.a.a.i.ak
   private final class_131 field_363;
   // $FF: renamed from: b java.util.ListIterator
   private ListIterator field_364;
   // $FF: renamed from: c java.lang.Object
   private Object field_365 = null;
   // $FF: renamed from: d boolean
   private boolean field_366 = false;

   class_248(class_131 var1) {
      this.field_363 = var1;
      this.field_364 = class_131.method_352(var1).listIterator();
   }

   public boolean hasNext() {
      return this.field_364.hasNext();
   }

   public Object next() {
      this.field_365 = this.field_364.next();
      this.field_366 = true;
      return this.field_365;
   }

   public boolean hasPrevious() {
      return this.field_364.hasPrevious();
   }

   public Object previous() {
      this.field_365 = this.field_364.previous();
      this.field_366 = true;
      return this.field_365;
   }

   public void remove() {
      if (!this.field_366) {
         throw new IllegalStateException("remove() can only be called once after next()");
      } else {
         this.field_364.remove();
         this.field_363.a.remove(this.field_365);
         this.field_366 = false;
      }
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (!this.field_366) {
         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
      } else {
         return this.field_365;
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (!this.field_366) {
         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
      } else {
         return this.field_363.get(this.field_365);
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (!this.field_366) {
         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
      } else {
         return this.field_363.a.put(this.field_365, var1);
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_364 = class_131.method_352(this.field_363).listIterator();
      this.field_365 = null;
      this.field_366 = false;
   }

   public String toString() {
      return this.field_366 ? "Iterator[" + this.method_6() + "=" + this.method_7() + "]" : "Iterator[]";
   }
}
