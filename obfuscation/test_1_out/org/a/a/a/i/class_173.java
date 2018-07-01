package org.a.a.a.i;

import java.util.NoSuchElementException;
import org.a.a.a.class_20;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.i.aJ
class class_173 implements class_7, class_20 {
   // $FF: renamed from: a org.a.a.a.i.aI
   private final class_167 field_227;
   // $FF: renamed from: b boolean
   private boolean field_228 = true;
   // $FF: renamed from: c boolean
   private boolean field_229 = false;

   class_173(class_167 var1) {
      this.field_227 = var1;
   }

   public boolean hasNext() {
      return this.field_228;
   }

   public Object next() {
      if (!this.field_228) {
         throw new NoSuchElementException("No next() entry in the iteration");
      } else {
         this.field_228 = false;
         this.field_229 = true;
         return this.field_227.getKey();
      }
   }

   public boolean hasPrevious() {
      return !this.field_228;
   }

   public Object previous() {
      if (this.field_228) {
         throw new NoSuchElementException("No previous() entry in the iteration");
      } else {
         this.field_228 = true;
         return this.field_227.getKey();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (!this.field_229) {
         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
      } else {
         return this.field_227.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (!this.field_229) {
         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
      } else {
         return this.field_227.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (!this.field_229) {
         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
      } else {
         return this.field_227.method_518(var1);
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_228 = true;
   }

   public String toString() {
      return this.field_228 ? "Iterator[]" : "Iterator[" + this.method_6() + "=" + this.method_7() + "]";
   }
}
