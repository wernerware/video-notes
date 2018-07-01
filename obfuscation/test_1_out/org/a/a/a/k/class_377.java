package org.a.a.a.k;

import org.a.a.a.class_27;

// $FF: renamed from: org.a.a.a.k.i
public abstract class class_377 implements class_27 {
   public boolean equals(Object var1) {
      if (!(var1 instanceof class_27)) {
         return false;
      } else {
         class_27 var2 = (class_27)var1;
         Object var3 = this.a();
         Object var4 = var2.method_56();
         return this.b() == var2.method_57() && (var3 == var4 || var3 != null && var3.equals(var4));
      }
   }

   public int hashCode() {
      Object var1 = this.a();
      return (var1 == null ? 0 : var1.hashCode()) ^ this.b();
   }

   public String toString() {
      return String.format("%s:%d", this.a(), this.b());
   }
}
