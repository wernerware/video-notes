package org.a.a.a.f;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.f.y
public abstract class class_212 implements Iterator {
   // $FF: renamed from: a int
   private int field_292 = 0;
   // $FF: renamed from: b boolean
   private boolean field_293 = false;
   // $FF: renamed from: c java.util.Iterator
   private Iterator field_294 = null;
   // $FF: renamed from: d java.util.Iterator
   private Iterator field_295 = null;

   // $FF: renamed from: a (int) java.util.Iterator
   protected abstract Iterator method_555(int var1);

   // $FF: renamed from: a () void
   private void method_556() {
      if (this.field_292 == 0) {
         this.field_294 = this.method_555(++this.field_292);
         if (this.field_294 == null) {
            this.field_294 = class_166.method_517();
            this.field_293 = true;
         }

         this.field_295 = this.field_294;
      }

      while(!this.field_294.hasNext() && !this.field_293) {
         Iterator var1 = this.method_555(++this.field_292);
         if (var1 != null) {
            this.field_294 = var1;
         } else {
            this.field_293 = true;
         }
      }

   }

   public boolean hasNext() {
      this.method_556();
      this.field_295 = this.field_294;
      return this.field_294.hasNext();
   }

   public Object next() {
      this.method_556();
      this.field_295 = this.field_294;
      return this.field_294.next();
   }

   public void remove() {
      if (this.field_294 == null) {
         this.method_556();
      }

      this.field_295.remove();
   }
}
