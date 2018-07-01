package org.a.a.a.f;

import java.util.ListIterator;

// $FF: renamed from: org.a.a.a.f.d
public class class_195 implements ListIterator {
   // $FF: renamed from: a java.util.ListIterator
   private final ListIterator field_265;

   public class_195(ListIterator var1) {
      if (var1 == null) {
         throw new NullPointerException("ListIterator must not be null");
      } else {
         this.field_265 = var1;
      }
   }

   // $FF: renamed from: a () java.util.ListIterator
   protected ListIterator method_551() {
      return this.field_265;
   }

   public boolean hasNext() {
      return this.field_265.hasNext();
   }

   public Object next() {
      return this.field_265.next();
   }

   public int nextIndex() {
      return this.field_265.nextIndex();
   }

   public boolean hasPrevious() {
      return this.field_265.hasPrevious();
   }

   public Object previous() {
      return this.field_265.previous();
   }

   public int previousIndex() {
      return this.field_265.previousIndex();
   }

   public void remove() {
      this.field_265.remove();
   }

   public void set(Object var1) {
      this.field_265.set(var1);
   }

   public void add(Object var1) {
      this.field_265.add(var1);
   }
}
