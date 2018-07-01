package org.a.a.a.i;

import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.i.f
public class class_510 extends class_508 implements class_4 {
   protected class_510(class_151 var1) {
      super(var1);
   }

   public Object next() {
      return super.method_1607().getKey();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      class_496 var1 = this.d();
      if (var1 == null) {
         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
      } else {
         return var1.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      class_496 var1 = this.d();
      if (var1 == null) {
         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
      } else {
         return var1.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      class_496 var2 = this.d();
      if (var2 == null) {
         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
      } else {
         return var2.setValue(var1);
      }
   }
}
