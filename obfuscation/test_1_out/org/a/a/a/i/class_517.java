package org.a.a.a.i;

import org.a.a.a.class_20;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.i.u
public class class_517 extends class_513 implements class_7, class_20 {
   protected class_517(class_153 var1) {
      super(var1);
   }

   public Object next() {
      return super.method_1610().getKey();
   }

   public Object previous() {
      return super.method_1611().getKey();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      class_497 var1 = this.f();
      if (var1 == null) {
         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
      } else {
         return var1.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      class_497 var1 = this.f();
      if (var1 == null) {
         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
      } else {
         return var1.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      class_497 var2 = this.f();
      if (var2 == null) {
         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
      } else {
         return var2.setValue(var1);
      }
   }
}
