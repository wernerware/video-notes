package org.a.a.a.k;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.k.c
class class_376 implements Iterator {
   // $FF: renamed from: a org.a.a.a.k.a
   private final class_372 field_655;
   // $FF: renamed from: b java.util.Iterator
   private final Iterator field_656;
   // $FF: renamed from: c java.util.Map.Entry
   private Entry field_657;
   // $FF: renamed from: d int
   private int field_658;
   // $FF: renamed from: e int
   private final int field_659;
   // $FF: renamed from: f boolean
   private boolean field_660;

   public class_376(class_372 var1) {
      this.field_655 = var1;
      this.field_656 = class_372.method_1100(var1).entrySet().iterator();
      this.field_657 = null;
      this.field_659 = class_372.method_1101(var1);
      this.field_660 = false;
   }

   public boolean hasNext() {
      return this.field_658 > 0 || this.field_656.hasNext();
   }

   public Object next() {
      if (class_372.method_1101(this.field_655) != this.field_659) {
         throw new ConcurrentModificationException();
      } else {
         if (this.field_658 == 0) {
            this.field_657 = (Entry)this.field_656.next();
            this.field_658 = ((class_375)this.field_657.getValue()).field_654;
         }

         this.field_660 = true;
         --this.field_658;
         return this.field_657.getKey();
      }
   }

   public void remove() {
      if (class_372.method_1101(this.field_655) != this.field_659) {
         throw new ConcurrentModificationException();
      } else if (!this.field_660) {
         throw new IllegalStateException();
      } else {
         class_375 var1 = (class_375)this.field_657.getValue();
         if (var1.field_654 > 1) {
            --var1.field_654;
         } else {
            this.field_656.remove();
         }

         class_372.method_1102(this.field_655);
         this.field_660 = false;
      }
   }
}
