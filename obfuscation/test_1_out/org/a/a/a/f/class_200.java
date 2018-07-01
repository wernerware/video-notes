package org.a.a.a.f;

import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.f.e
public class class_200 implements class_4 {
   // $FF: renamed from: a org.a.a.a.Z
   private final class_4 field_271;

   public class_200(class_4 var1) {
      if (var1 == null) {
         throw new NullPointerException("MapIterator must not be null");
      } else {
         this.field_271 = var1;
      }
   }

   // $FF: renamed from: c () org.a.a.a.Z
   protected class_4 method_552() {
      return this.field_271;
   }

   public boolean hasNext() {
      return this.field_271.hasNext();
   }

   public Object next() {
      return this.field_271.next();
   }

   public void remove() {
      this.field_271.remove();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      return this.field_271.method_6();
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      return this.field_271.method_7();
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      return this.field_271.method_8(var1);
   }
}
