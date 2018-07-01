package org.a.a.a.f;

import java.util.ListIterator;
import org.a.a.a.class_29;

// $FF: renamed from: org.a.a.a.f.Q
public final class class_462 implements ListIterator, class_29 {
   // $FF: renamed from: a java.util.ListIterator
   private final ListIterator field_841;

   // $FF: renamed from: a (java.util.ListIterator) java.util.ListIterator
   public static ListIterator method_1544(ListIterator var0) {
      if (var0 == null) {
         throw new NullPointerException("ListIterator must not be null");
      } else {
         return (ListIterator)(var0 instanceof class_29 ? var0 : new class_462(var0));
      }
   }

   private class_462(ListIterator var1) {
      this.field_841 = var1;
   }

   public boolean hasNext() {
      return this.field_841.hasNext();
   }

   public Object next() {
      return this.field_841.next();
   }

   public int nextIndex() {
      return this.field_841.nextIndex();
   }

   public boolean hasPrevious() {
      return this.field_841.hasPrevious();
   }

   public Object previous() {
      return this.field_841.previous();
   }

   public int previousIndex() {
      return this.field_841.previousIndex();
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() is not supported");
   }

   public void set(Object var1) {
      throw new UnsupportedOperationException("set() is not supported");
   }

   public void add(Object var1) {
      throw new UnsupportedOperationException("add() is not supported");
   }
}
