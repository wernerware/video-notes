package org.a.a.a.k;

import java.util.Iterator;
import org.a.a.a.class_27;

// $FF: renamed from: org.a.a.a.k.k
class class_381 implements Iterator {
   // $FF: renamed from: a org.a.a.a.k.g
   private final class_370 field_668;
   // $FF: renamed from: b java.util.Iterator
   private final Iterator field_669;
   // $FF: renamed from: c org.a.a.a.ag
   private class_27 field_670;
   // $FF: renamed from: d int
   private int field_671;
   // $FF: renamed from: e boolean
   private boolean field_672;

   public class_381(class_370 var1) {
      this.field_668 = var1;
      this.field_669 = var1.method_63().iterator();
      this.field_670 = null;
      this.field_672 = false;
   }

   public boolean hasNext() {
      return this.field_671 > 0 || this.field_669.hasNext();
   }

   public Object next() {
      if (this.field_671 == 0) {
         this.field_670 = (class_27)this.field_669.next();
         this.field_671 = this.field_670.method_57();
      }

      this.field_672 = true;
      --this.field_671;
      return this.field_670.method_56();
   }

   public void remove() {
      if (!this.field_672) {
         throw new IllegalStateException();
      } else {
         int var1 = this.field_670.method_57();
         if (var1 > 1) {
            this.field_668.remove(this.field_670.method_56());
         } else {
            this.field_669.remove();
         }

         this.field_672 = false;
      }
   }
}
