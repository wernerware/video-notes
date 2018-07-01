package org.a.a.a.i;

import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.i.F
class class_487 extends class_485 implements class_4 {
   protected class_487(class_157 var1) {
      super(var1);
   }

   public Object next() {
      return this.c().getKey();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      class_498 var1 = this.d();
      if (var1 == null) {
         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
      } else {
         return var1.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      class_498 var1 = this.d();
      if (var1 == null) {
         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
      } else {
         return var1.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      class_498 var2 = this.d();
      if (var2 == null) {
         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
      } else {
         return var2.setValue(var1);
      }
   }
}
