package org.a.a.a.f;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.a.a.a.class_6;

// $FF: renamed from: org.a.a.a.f.i
public class class_172 extends class_171 implements class_6 {
   // $FF: renamed from: e int
   private int field_226 = -1;

   public class_172(Object var1) {
      super(var1);
   }

   public class_172(Object var1, int var2) {
      super(var1, var2);
   }

   public class_172(Object var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   public boolean hasPrevious() {
      return this.d > this.b;
   }

   public Object previous() {
      if (!this.hasPrevious()) {
         throw new NoSuchElementException();
      } else {
         this.field_226 = --this.d;
         return Array.get(this.a, this.d);
      }
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.field_226 = this.d;
         return Array.get(this.a, this.d++);
      }
   }

   public int nextIndex() {
      return this.d - this.b;
   }

   public int previousIndex() {
      return this.d - this.b - 1;
   }

   public void add(Object var1) {
      throw new UnsupportedOperationException("add() method is not supported");
   }

   public void set(Object var1) {
      if (this.field_226 == -1) {
         throw new IllegalStateException("must call next() or previous() before a call to set()");
      } else {
         Array.set(this.a, this.field_226, var1);
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      super.method_24();
      this.field_226 = -1;
   }
}
