package org.a.a.a.f;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.f.I
public class class_450 implements Iterator {
   // $FF: renamed from: a java.util.Iterator
   private final Iterator field_811;
   // $FF: renamed from: b java.util.Deque
   private Deque field_812 = new ArrayDeque();

   // $FF: renamed from: a (java.util.Iterator) org.a.a.a.f.I
   public static class_450 method_1524(Iterator var0) {
      if (var0 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (var0 instanceof class_450) {
         class_450 var1 = (class_450)var0;
         return var1;
      } else {
         return new class_450(var0);
      }
   }

   public class_450(Iterator var1) {
      this.field_811 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) void
   public void method_1525(Object var1) {
      this.field_812.push(var1);
   }

   public boolean hasNext() {
      return !this.field_812.isEmpty() ? true : this.field_811.hasNext();
   }

   public Object next() {
      return !this.field_812.isEmpty() ? this.field_812.pop() : this.field_811.next();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
