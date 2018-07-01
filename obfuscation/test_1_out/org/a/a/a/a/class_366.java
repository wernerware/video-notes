package org.a.a.a.a;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.a.c
class class_366 implements Iterator {
   // $FF: renamed from: a org.a.a.a.a.b
   private final class_363 field_629;
   // $FF: renamed from: b java.util.Iterator
   private final Iterator field_630;
   // $FF: renamed from: c java.util.Map.Entry
   private Entry field_631;
   // $FF: renamed from: d int
   private int field_632;
   // $FF: renamed from: e int
   private final int field_633;
   // $FF: renamed from: f boolean
   private boolean field_634;

   public class_366(class_363 var1) {
      this.field_629 = var1;
      this.field_630 = class_363.method_1068(var1).entrySet().iterator();
      this.field_631 = null;
      this.field_633 = class_363.method_1069(var1);
      this.field_634 = false;
   }

   public boolean hasNext() {
      return this.field_632 > 0 || this.field_630.hasNext();
   }

   public Object next() {
      if (class_363.method_1069(this.field_629) != this.field_633) {
         throw new ConcurrentModificationException();
      } else {
         if (this.field_632 == 0) {
            this.field_631 = (Entry)this.field_630.next();
            this.field_632 = ((class_367)this.field_631.getValue()).field_635;
         }

         this.field_634 = true;
         --this.field_632;
         return this.field_631.getKey();
      }
   }

   public void remove() {
      if (class_363.method_1069(this.field_629) != this.field_633) {
         throw new ConcurrentModificationException();
      } else if (!this.field_634) {
         throw new IllegalStateException();
      } else {
         class_367 var1 = (class_367)this.field_631.getValue();
         if (var1.field_635 > 1) {
            --var1.field_635;
         } else {
            this.field_630.remove();
         }

         class_363.method_1070(this.field_629);
         this.field_634 = false;
      }
   }
}
