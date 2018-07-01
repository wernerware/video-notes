package org.a.a.a.f;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.f.s
public class class_223 implements Iterator {
   // $FF: renamed from: a java.util.Iterator
   private Iterator field_321;
   // $FF: renamed from: b org.a.a.a.an
   private class_1 field_322;
   // $FF: renamed from: c java.lang.Object
   private Object field_323;
   // $FF: renamed from: d boolean
   private boolean field_324 = false;

   public class_223() {
   }

   public class_223(Iterator var1) {
      this.field_321 = var1;
   }

   public class_223(Iterator var1, class_1 var2) {
      this.field_321 = var1;
      this.field_322 = var2;
   }

   public boolean hasNext() {
      return this.field_324 || this.method_580();
   }

   public Object next() {
      if (!this.field_324 && !this.method_580()) {
         throw new NoSuchElementException();
      } else {
         this.field_324 = false;
         return this.field_323;
      }
   }

   public void remove() {
      if (this.field_324) {
         throw new IllegalStateException("remove() cannot be called");
      } else {
         this.field_321.remove();
      }
   }

   // $FF: renamed from: a () java.util.Iterator
   public Iterator method_576() {
      return this.field_321;
   }

   // $FF: renamed from: a (java.util.Iterator) void
   public void method_577(Iterator var1) {
      this.field_321 = var1;
      this.field_323 = null;
      this.field_324 = false;
   }

   // $FF: renamed from: b () org.a.a.a.an
   public class_1 method_578() {
      return this.field_322;
   }

   // $FF: renamed from: a (org.a.a.a.an) void
   public void method_579(class_1 var1) {
      this.field_322 = var1;
      this.field_323 = null;
      this.field_324 = false;
   }

   // $FF: renamed from: c () boolean
   private boolean method_580() {
      while(true) {
         if (this.field_321.hasNext()) {
            Object var1 = this.field_321.next();
            if (!this.field_322.method_3(var1)) {
               continue;
            }

            this.field_323 = var1;
            this.field_324 = true;
            return true;
         }

         return false;
      }
   }
}
