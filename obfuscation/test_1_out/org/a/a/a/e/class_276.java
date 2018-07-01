package org.a.a.a.e;

import java.io.Serializable;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.e.n
public class class_276 implements Serializable, class_21 {
   // $FF: renamed from: b long
   private static final long field_415 = 6374440726369055124L;
   // $FF: renamed from: a org.a.a.a.aI
   public static final class_21 field_416 = new class_276((Object)null);
   // $FF: renamed from: c java.lang.Object
   private final Object field_417;

   // $FF: renamed from: a () org.a.a.a.aI
   public static class_21 method_647() {
      return field_416;
   }

   // $FF: renamed from: a (java.lang.Object) org.a.a.a.aI
   public static class_21 method_648(Object var0) {
      return (class_21)(var0 == null ? method_647() : new class_276(var0));
   }

   public class_276(Object var1) {
      this.field_417 = var1;
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      return this.field_417;
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_649() {
      return this.field_417;
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof class_276)) {
         return false;
      } else {
         Object var2 = ((class_276)var1).method_649();
         return var2 == this.method_649() || var2 != null && var2.equals(this.method_649());
      }
   }

   public int hashCode() {
      int var1 = "ConstantTransformer".hashCode() << 2;
      if (this.method_649() != null) {
         var1 |= this.method_649().hashCode();
      }

      return var1;
   }
}
