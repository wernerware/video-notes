package org.a.a.a.f;

import org.a.a.a.class_29;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.f.S
public final class class_460 implements class_29, class_7 {
   // $FF: renamed from: a org.a.a.a.am
   private final class_7 field_839;

   // $FF: renamed from: a (org.a.a.a.am) org.a.a.a.am
   public static class_7 method_1542(class_7 var0) {
      if (var0 == null) {
         throw new NullPointerException("OrderedMapIterator must not be null");
      } else {
         return (class_7)(var0 instanceof class_29 ? var0 : new class_460(var0));
      }
   }

   private class_460(class_7 var1) {
      this.field_839 = var1;
   }

   public boolean hasNext() {
      return this.field_839.hasNext();
   }

   public Object next() {
      return this.field_839.next();
   }

   public boolean hasPrevious() {
      return this.field_839.hasPrevious();
   }

   public Object previous() {
      return this.field_839.previous();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      return this.field_839.a();
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      return this.field_839.b();
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      throw new UnsupportedOperationException("setValue() is not supported");
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() is not supported");
   }
}
