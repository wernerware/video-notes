package org.a.a.a.i;

import java.util.Map;
import java.util.Set;

// $FF: renamed from: org.a.a.a.i.k
abstract class class_134 extends class_116 {
   protected class_134() {
   }

   protected class_134(Map var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected abstract Object method_360(Object var1);

   // $FF: renamed from: a () boolean
   protected boolean method_361() {
      return true;
   }

   public Set entrySet() {
      return (Set)(this.method_361() ? new class_71(this, this.a.entrySet(), this) : this.a.entrySet());
   }
}
