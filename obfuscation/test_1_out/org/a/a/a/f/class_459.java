package org.a.a.a.f;

import org.a.a.a.class_29;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.f.R
public final class class_459 implements class_4, class_29 {
   // $FF: renamed from: a org.a.a.a.Z
   private final class_4 field_838;

   // $FF: renamed from: a (org.a.a.a.Z) org.a.a.a.Z
   public static class_4 method_1541(class_4 var0) {
      if (var0 == null) {
         throw new NullPointerException("MapIterator must not be null");
      } else {
         return (class_4)(var0 instanceof class_29 ? var0 : new class_459(var0));
      }
   }

   private class_459(class_4 var1) {
      this.field_838 = var1;
   }

   public boolean hasNext() {
      return this.field_838.hasNext();
   }

   public Object next() {
      return this.field_838.next();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      return this.field_838.method_6();
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      return this.field_838.method_7();
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      throw new UnsupportedOperationException("setValue() is not supported");
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() is not supported");
   }
}
