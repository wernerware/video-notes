package org.a.a.a.p;

import java.io.Serializable;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.p.b
abstract class class_300 implements Serializable, Entry {
   // $FF: renamed from: c long
   private static final long field_471 = -944364551314110330L;
   // $FF: renamed from: a java.lang.Object
   protected Object field_472;
   // $FF: renamed from: b java.lang.Object
   protected Object field_473;

   public class_300(Object var1) {
      this.field_472 = var1;
   }

   public class_300(Object var1, Object var2) {
      this.field_472 = var1;
      this.field_473 = var2;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_700(Object var1, Object var2) {
      this.field_472 = var1;
      return this.setValue(var2);
   }

   public Object getKey() {
      return this.field_472;
   }

   public Object getValue() {
      return this.field_473;
   }

   public Object setValue(Object var1) {
      Object var2 = this.field_473;
      this.field_473 = var1;
      return var2;
   }

   public int hashCode() {
      return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         return class_302.method_711(this.field_472, var2.getKey()) && class_302.method_711(this.field_473, var2.getValue());
      }
   }

   public String toString() {
      return this.field_472 + "=" + this.field_473;
   }
}
