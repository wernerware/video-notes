package org.a.a.a.f;

import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.f.a
abstract class class_160 {
   public boolean hasNext() {
      return false;
   }

   public Object next() {
      throw new NoSuchElementException("Iterator contains no elements");
   }

   public boolean hasPrevious() {
      return false;
   }

   public Object previous() {
      throw new NoSuchElementException("Iterator contains no elements");
   }

   public int nextIndex() {
      return 0;
   }

   public int previousIndex() {
      return -1;
   }

   public void add(Object var1) {
      throw new UnsupportedOperationException("add() not supported for empty Iterator");
   }

   public void set(Object var1) {
      throw new IllegalStateException("Iterator contains no elements");
   }

   public void remove() {
      throw new IllegalStateException("Iterator contains no elements");
   }

   // $FF: renamed from: c () void
   public void method_507() {
   }
}
