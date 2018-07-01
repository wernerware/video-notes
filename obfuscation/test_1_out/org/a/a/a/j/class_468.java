package org.a.a.a.j;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_26;
import org.a.a.a.class_321;

// $FF: renamed from: org.a.a.a.j.u
public abstract class class_468 extends class_467 implements class_26 {
   protected class_468() {
   }

   protected class_468(Map var1) {
      super(var1);
   }

   // $FF: renamed from: j () java.util.Map
   protected Map method_1552() {
      return super.method_1552();
   }

   // $FF: renamed from: k () java.util.Set
   protected abstract Set method_1559();

   // $FF: renamed from: a (java.lang.Object) java.util.Set
   public Set method_54(Object var1) {
      return this.method_1560(var1);
   }

   // $FF: renamed from: g (java.lang.Object) java.util.Set
   Set method_1560(Object var1) {
      return new class_475(this, var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.util.Set
   public Set method_55(Object var1) {
      return class_321.method_768((Set)this.method_1552().remove(var1));
   }

   // $FF: renamed from: f (java.lang.Object) java.util.Collection
   // $FF: synthetic method
   public Collection method_43(Object var1) {
      return this.method_55(var1);
   }

   // $FF: renamed from: h (java.lang.Object) java.util.Collection
   // $FF: synthetic method
   Collection method_1555(Object var1) {
      return this.method_1560(var1);
   }

   // $FF: renamed from: e (java.lang.Object) java.util.Collection
   // $FF: synthetic method
   public Collection method_38(Object var1) {
      return this.method_54(var1);
   }

   // $FF: renamed from: l () java.util.Collection
   // $FF: synthetic method
   protected Collection method_1554() {
      return this.method_1559();
   }
}
