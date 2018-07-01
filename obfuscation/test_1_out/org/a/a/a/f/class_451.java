package org.a.a.a.f;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.f.F
public class class_451 implements Iterator {
   // $FF: renamed from: a java.util.Deque
   private final Deque field_813 = new ArrayDeque(8);
   // $FF: renamed from: b java.lang.Object
   private Object field_814;
   // $FF: renamed from: c org.a.a.a.aI
   private final class_21 field_815;
   // $FF: renamed from: d boolean
   private boolean field_816 = false;
   // $FF: renamed from: e java.util.Iterator
   private Iterator field_817;
   // $FF: renamed from: f java.lang.Object
   private Object field_818;
   // $FF: renamed from: g java.util.Iterator
   private Iterator field_819;

   public class_451(Object var1, class_21 var2) {
      if (var1 instanceof Iterator) {
         this.field_817 = (Iterator)var1;
      } else {
         this.field_814 = var1;
      }

      this.field_815 = var2;
   }

   public class_451(Iterator var1) {
      this.field_817 = var1;
      this.field_815 = null;
   }

   // $FF: renamed from: a () void
   protected void method_1526() {
      if (!this.field_816) {
         if (this.field_817 == null) {
            if (this.field_814 != null) {
               if (this.field_815 == null) {
                  this.method_1527(this.field_814);
               } else {
                  this.method_1527(this.field_815.method_25(this.field_814));
               }

               this.field_814 = null;
            }
         } else {
            this.method_1528(this.field_817);
         }

      }
   }

   // $FF: renamed from: a (java.lang.Object) void
   protected void method_1527(Object var1) {
      if (var1 instanceof Iterator) {
         this.method_1528((Iterator)var1);
      } else {
         this.field_818 = var1;
         this.field_816 = true;
      }

   }

   // $FF: renamed from: a (java.util.Iterator) void
   protected void method_1528(Iterator var1) {
      if (var1 != this.field_817) {
         if (this.field_817 != null) {
            this.field_813.push(this.field_817);
         }

         this.field_817 = var1;
      }

      Object var2;
      for(; this.field_817.hasNext() && !this.field_816; this.method_1527(var2)) {
         var2 = this.field_817.next();
         if (this.field_815 != null) {
            var2 = this.field_815.method_25(var2);
         }
      }

      if (!this.field_816 && !this.field_813.isEmpty()) {
         this.field_817 = (Iterator)this.field_813.pop();
         this.method_1528(this.field_817);
      }

   }

   public boolean hasNext() {
      this.method_1526();
      return this.field_816;
   }

   public Object next() {
      this.method_1526();
      if (!this.field_816) {
         throw new NoSuchElementException("No more elements in the iteration");
      } else {
         this.field_819 = this.field_817;
         Object var1 = this.field_818;
         this.field_818 = null;
         this.field_816 = false;
         return var1;
      }
   }

   public void remove() {
      if (this.field_819 == null) {
         throw new IllegalStateException("Iterator remove() cannot be called at this time");
      } else {
         this.field_819.remove();
         this.field_819 = null;
      }
   }
}
