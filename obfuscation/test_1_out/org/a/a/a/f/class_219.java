package org.a.a.a.f;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.f.t
public class class_219 implements ListIterator {
   // $FF: renamed from: a java.util.ListIterator
   private ListIterator field_306;
   // $FF: renamed from: b org.a.a.a.an
   private APPARENTLY_REALLY_IMPORTANT field_307;
   // $FF: renamed from: c java.lang.Object
   private Object field_308;
   // $FF: renamed from: d boolean
   private boolean field_309 = false;
   // $FF: renamed from: e java.lang.Object
   private Object field_310;
   // $FF: renamed from: f boolean
   private boolean field_311 = false;
   // $FF: renamed from: g int
   private int field_312 = 0;

   public class_219() {
   }

   public class_219(ListIterator var1) {
      this.field_306 = var1;
   }

   public class_219(ListIterator var1, APPARENTLY_REALLY_IMPORTANT var2) {
      this.field_306 = var1;
      this.field_307 = var2;
   }

   public class_219(APPARENTLY_REALLY_IMPORTANT var1) {
      this.field_307 = var1;
   }

   public void add(Object var1) {
      throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
   }

   public boolean hasNext() {
      return this.field_309 || this.method_565();
   }

   public boolean hasPrevious() {
      return this.field_311 || this.method_567();
   }

   public Object next() {
      if (!this.field_309 && !this.method_565()) {
         throw new NoSuchElementException();
      } else {
         ++this.field_312;
         Object var1 = this.field_308;
         this.method_564();
         return var1;
      }
   }

   public int nextIndex() {
      return this.field_312;
   }

   public Object previous() {
      if (!this.field_311 && !this.method_567()) {
         throw new NoSuchElementException();
      } else {
         --this.field_312;
         Object var1 = this.field_310;
         this.method_566();
         return var1;
      }
   }

   public int previousIndex() {
      return this.field_312 - 1;
   }

   public void remove() {
      throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
   }

   public void set(Object var1) {
      throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
   }

   // $FF: renamed from: a () java.util.ListIterator
   public ListIterator method_560() {
      return this.field_306;
   }

   // $FF: renamed from: a (java.util.ListIterator) void
   public void method_561(ListIterator var1) {
      this.field_306 = var1;
   }

   // $FF: renamed from: b () org.a.a.a.an
   public APPARENTLY_REALLY_IMPORTANT method_562() {
      return this.field_307;
   }

   // $FF: renamed from: a (org.a.a.a.an) void
   public void method_563(APPARENTLY_REALLY_IMPORTANT var1) {
      this.field_307 = var1;
   }

   // $FF: renamed from: c () void
   private void method_564() {
      this.field_308 = null;
      this.field_309 = false;
   }

   // $FF: renamed from: d () boolean
   private boolean method_565() {
      if (this.field_311) {
         this.method_566();
         if (!this.method_565()) {
            return false;
         }

         this.method_564();
      }

      if (this.field_306 == null) {
         return false;
      } else {
         Object var1;
         do {
            if (!this.field_306.hasNext()) {
               return false;
            }

            var1 = this.field_306.next();
         } while(!this.field_307.method_3(var1));

         this.field_308 = var1;
         this.field_309 = true;
         return true;
      }
   }

   // $FF: renamed from: e () void
   private void method_566() {
      this.field_310 = null;
      this.field_311 = false;
   }

   // $FF: renamed from: f () boolean
   private boolean method_567() {
      if (this.field_309) {
         this.method_564();
         if (!this.method_567()) {
            return false;
         }

         this.method_566();
      }

      if (this.field_306 == null) {
         return false;
      } else {
         Object var1;
         do {
            if (!this.field_306.hasPrevious()) {
               return false;
            }

            var1 = this.field_306.previous();
         } while(!this.field_307.method_3(var1));

         this.field_310 = var1;
         this.field_311 = true;
         return true;
      }
   }
}
