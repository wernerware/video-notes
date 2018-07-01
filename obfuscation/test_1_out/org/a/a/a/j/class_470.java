package org.a.a.a.j;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.a.a.a.class_25;
import org.a.a.a.class_400;

// $FF: renamed from: org.a.a.a.j.a
public abstract class class_470 extends class_467 implements class_25 {
   protected class_470() {
   }

   protected class_470(Map var1) {
      super(var1);
   }

   // $FF: renamed from: j () java.util.Map
   protected Map method_1552() {
      return super.method_1552();
   }

   // $FF: renamed from: k () java.util.List
   protected abstract List method_1564();

   // $FF: renamed from: a (java.lang.Object) java.util.List
   public List method_52(Object var1) {
      return this.method_1565(var1);
   }

   // $FF: renamed from: g (java.lang.Object) java.util.List
   List method_1565(Object var1) {
      return new class_476(this, var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.util.List
   public List method_53(Object var1) {
      return class_400.method_1145((List)this.method_1552().remove(var1));
   }

   // $FF: renamed from: f (java.lang.Object) java.util.Collection
   // $FF: synthetic method
   public Collection method_43(Object var1) {
      return this.method_53(var1);
   }

   // $FF: renamed from: h (java.lang.Object) java.util.Collection
   // $FF: synthetic method
   Collection method_1555(Object var1) {
      return this.method_1565(var1);
   }

   // $FF: renamed from: e (java.lang.Object) java.util.Collection
   // $FF: synthetic method
   public Collection method_38(Object var1) {
      return this.method_52(var1);
   }

   // $FF: renamed from: l () java.util.Collection
   // $FF: synthetic method
   protected Collection method_1554() {
      return this.method_1564();
   }
}
