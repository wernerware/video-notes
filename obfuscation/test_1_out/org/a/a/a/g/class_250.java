package org.a.a.a.g;

import org.a.a.a.class_30;

// $FF: renamed from: org.a.a.a.g.a
public abstract class class_250 implements class_30 {
   // $FF: renamed from: a java.lang.Object
   private Object field_371;
   // $FF: renamed from: b java.lang.Object
   private Object field_372;

   protected class_250(Object var1, Object var2) {
      this.field_371 = var1;
      this.field_372 = var2;
   }

   public Object getKey() {
      return this.field_371;
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_608(Object var1) {
      Object var2 = this.field_371;
      this.field_371 = var1;
      return var2;
   }

   public Object getValue() {
      return this.field_372;
   }

   protected Object setValue(Object var1) {
      Object var2 = this.field_372;
      this.field_372 = var1;
      return var2;
   }

   public String toString() {
      return "" + this.getKey() + '=' + this.getValue();
   }
}
