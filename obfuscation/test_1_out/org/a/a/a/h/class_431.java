package org.a.a.a.h;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_5;

// $FF: renamed from: org.a.a.a.h.b
public class class_431 implements ListIterator, class_5 {
   // $FF: renamed from: a org.a.a.a.h.a
   protected final class_435 field_748;
   // $FF: renamed from: b org.a.a.a.h.e
   protected class_438 field_749;
   // $FF: renamed from: c int
   protected int field_750;
   // $FF: renamed from: d org.a.a.a.h.e
   protected class_438 field_751;
   // $FF: renamed from: e int
   protected int field_752;

   protected class_431(class_435 var1, int var2) {
      this.field_748 = var1;
      this.field_752 = var1.field_760;
      this.field_749 = var1.method_1449(var2, true);
      this.field_750 = var2;
   }

   // $FF: renamed from: a () void
   protected void method_1427() {
      if (this.field_748.field_760 != this.field_752) {
         throw new ConcurrentModificationException();
      }
   }

   // $FF: renamed from: b () org.a.a.a.h.e
   protected class_438 method_1428() {
      if (this.field_751 == null) {
         throw new IllegalStateException();
      } else {
         return this.field_751;
      }
   }

   public boolean hasNext() {
      return this.field_749 != this.field_748.field_758;
   }

   public Object next() {
      this.method_1427();
      if (!this.hasNext()) {
         throw new NoSuchElementException("No element at index " + this.field_750 + ".");
      } else {
         Object var1 = this.field_749.method_1471();
         this.field_751 = this.field_749;
         this.field_749 = this.field_749.field_769;
         ++this.field_750;
         return var1;
      }
   }

   public boolean hasPrevious() {
      return this.field_749.field_768 != this.field_748.field_758;
   }

   public Object previous() {
      this.method_1427();
      if (!this.hasPrevious()) {
         throw new NoSuchElementException("Already at start of list.");
      } else {
         this.field_749 = this.field_749.field_768;
         Object var1 = this.field_749.method_1471();
         this.field_751 = this.field_749;
         --this.field_750;
         return var1;
      }
   }

   public int nextIndex() {
      return this.field_750;
   }

   public int previousIndex() {
      return this.nextIndex() - 1;
   }

   public void remove() {
      this.method_1427();
      if (this.field_751 == this.field_749) {
         this.field_749 = this.field_749.field_769;
         this.field_748.method_1447(this.method_1428());
      } else {
         this.field_748.method_1447(this.method_1428());
         --this.field_750;
      }

      this.field_751 = null;
      ++this.field_752;
   }

   public void set(Object var1) {
      this.method_1427();
      this.method_1428().method_1472(var1);
   }

   public void add(Object var1) {
      this.method_1427();
      this.field_748.method_1444(this.field_749, var1);
      this.field_751 = null;
      ++this.field_750;
      ++this.field_752;
   }
}
