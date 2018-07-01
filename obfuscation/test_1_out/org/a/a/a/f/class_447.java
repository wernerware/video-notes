package org.a.a.a.f;

import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_6;

// $FF: renamed from: org.a.a.a.f.J
public class class_447 implements class_6 {
   // $FF: renamed from: a java.util.List
   private final List field_800;
   // $FF: renamed from: b java.util.ListIterator
   private ListIterator field_801;
   // $FF: renamed from: c boolean
   private boolean field_802 = true;

   public class_447(List var1) {
      if (var1 == null) {
         throw new NullPointerException("List must not be null.");
      } else {
         this.field_800 = var1;
         this.field_801 = var1.listIterator(var1.size());
      }
   }

   public boolean hasNext() {
      return this.field_801.hasPrevious();
   }

   public Object next() {
      Object var1 = this.field_801.previous();
      this.field_802 = true;
      return var1;
   }

   public int nextIndex() {
      return this.field_801.previousIndex();
   }

   public boolean hasPrevious() {
      return this.field_801.hasNext();
   }

   public Object previous() {
      Object var1 = this.field_801.next();
      this.field_802 = true;
      return var1;
   }

   public int previousIndex() {
      return this.field_801.nextIndex();
   }

   public void remove() {
      if (!this.field_802) {
         throw new IllegalStateException("Cannot remove from list until next() or previous() called");
      } else {
         this.field_801.remove();
      }
   }

   public void set(Object var1) {
      if (!this.field_802) {
         throw new IllegalStateException("Cannot set to list until next() or previous() called");
      } else {
         this.field_801.set(var1);
      }
   }

   public void add(Object var1) {
      if (!this.field_802) {
         throw new IllegalStateException("Cannot add to list until next() or previous() called");
      } else {
         this.field_802 = false;
         this.field_801.add(var1);
         this.field_801.previous();
      }
   }

   // $FF: renamed from: c () void
   public void method_1522() {
      this.field_801 = this.field_800.listIterator(this.field_800.size());
   }
}
