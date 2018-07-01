package org.a.a.a;

// $FF: renamed from: org.a.a.a.n
class class_408 {
   // $FF: renamed from: a org.a.a.a.r
   private final class_33 field_718;
   // $FF: renamed from: b java.lang.Object
   private final Object field_719;

   public class_408(class_33 var1, Object var2) {
      this.field_718 = var1;
      this.field_719 = var2;
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_1297() {
      return this.field_719;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof class_408)) {
         return false;
      } else {
         class_408 var2 = (class_408)var1;
         return this.field_718.method_68(this.field_719, var2.method_1297());
      }
   }

   public int hashCode() {
      return this.field_718.method_69(this.field_719);
   }
}
