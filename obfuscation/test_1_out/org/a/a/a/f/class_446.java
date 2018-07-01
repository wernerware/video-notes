package org.a.a.a.f;

import java.util.NoSuchElementException;
import org.a.a.a.class_6;

// $FF: renamed from: org.a.a.a.f.L
public class class_446 implements class_6 {
   // $FF: renamed from: a boolean
   private boolean field_796 = true;
   // $FF: renamed from: b boolean
   private boolean field_797 = false;
   // $FF: renamed from: c boolean
   private boolean field_798 = false;
   // $FF: renamed from: d java.lang.Object
   private Object field_799;

   public class_446(Object var1) {
      this.field_799 = var1;
   }

   public boolean hasNext() {
      return this.field_796 && !this.field_798;
   }

   public boolean hasPrevious() {
      return !this.field_796 && !this.field_798;
   }

   public int nextIndex() {
      return this.field_796 ? 0 : 1;
   }

   public int previousIndex() {
      return this.field_796 ? -1 : 0;
   }

   public Object next() {
      if (this.field_796 && !this.field_798) {
         this.field_796 = false;
         this.field_797 = true;
         return this.field_799;
      } else {
         throw new NoSuchElementException();
      }
   }

   public Object previous() {
      if (!this.field_796 && !this.field_798) {
         this.field_796 = true;
         return this.field_799;
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      if (this.field_797 && !this.field_798) {
         this.field_799 = null;
         this.field_798 = true;
      } else {
         throw new IllegalStateException();
      }
   }

   public void add(Object var1) {
      throw new UnsupportedOperationException("add() is not supported by this iterator");
   }

   public void set(Object var1) {
      if (this.field_797 && !this.field_798) {
         this.field_799 = var1;
      } else {
         throw new IllegalStateException();
      }
   }

   // $FF: renamed from: c () void
   public void method_1521() {
      this.field_796 = true;
      this.field_797 = false;
   }
}
