package org.a.a.a.f;

import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.f.G
public class class_452 implements Iterator {
   // $FF: renamed from: a java.util.Iterator
   private final Iterator field_820;
   // $FF: renamed from: b boolean
   private boolean field_821 = false;
   // $FF: renamed from: c boolean
   private boolean field_822 = false;
   // $FF: renamed from: d java.lang.Object
   private Object field_823;

   // $FF: renamed from: a (java.util.Iterator) org.a.a.a.f.G
   public static class_452 method_1529(Iterator var0) {
      if (var0 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (var0 instanceof class_452) {
         class_452 var1 = (class_452)var0;
         return var1;
      } else {
         return new class_452(var0);
      }
   }

   public class_452(Iterator var1) {
      this.field_820 = var1;
   }

   // $FF: renamed from: c () void
   private void method_1530() {
      if (!this.field_821 && !this.field_822) {
         if (this.field_820.hasNext()) {
            this.field_823 = this.field_820.next();
            this.field_822 = true;
         } else {
            this.field_821 = true;
            this.field_823 = null;
            this.field_822 = false;
         }

      }
   }

   public boolean hasNext() {
      if (this.field_821) {
         return false;
      } else {
         return this.field_822 ? true : this.field_820.hasNext();
      }
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_1531() {
      this.method_1530();
      return this.field_821 ? null : this.field_823;
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_1532() {
      this.method_1530();
      if (this.field_821) {
         throw new NoSuchElementException();
      } else {
         return this.field_823;
      }
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.field_822 ? this.field_823 : this.field_820.next();
         this.field_823 = null;
         this.field_822 = false;
         return var1;
      }
   }

   public void remove() {
      if (this.field_822) {
         throw new IllegalStateException("peek() or element() called before remove()");
      } else {
         this.field_820.remove();
      }
   }
}
