package org.a.a.a.f;

import java.util.NoSuchElementException;
import org.a.a.a.class_20;

// $FF: renamed from: org.a.a.a.f.K
public class class_448 implements class_20 {
   // $FF: renamed from: a boolean
   private final boolean field_803;
   // $FF: renamed from: b boolean
   private boolean field_804;
   // $FF: renamed from: c boolean
   private boolean field_805;
   // $FF: renamed from: d java.lang.Object
   private Object field_806;

   public class_448(Object var1) {
      this(var1, true);
   }

   public class_448(Object var1, boolean var2) {
      this.field_804 = true;
      this.field_805 = false;
      this.field_806 = var1;
      this.field_803 = var2;
   }

   public boolean hasNext() {
      return this.field_804 && !this.field_805;
   }

   public Object next() {
      if (this.field_804 && !this.field_805) {
         this.field_804 = false;
         return this.field_806;
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      if (this.field_803) {
         if (!this.field_805 && !this.field_804) {
            this.field_806 = null;
            this.field_805 = true;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new UnsupportedOperationException();
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_804 = true;
   }
}
