package org.a.a.a.p;

// $FF: renamed from: org.a.a.a.p.r
public class class_301 extends class_300 {
   // $FF: renamed from: h long
   private static final long field_474 = 4596023148184140013L;
   // $FF: renamed from: c int
   protected int field_475;
   // $FF: renamed from: d org.a.a.a.p.r
   protected class_301 field_476;
   // $FF: renamed from: e org.a.a.a.p.r
   protected class_301 field_477;
   // $FF: renamed from: f org.a.a.a.p.r
   protected class_301 field_478;
   // $FF: renamed from: g org.a.a.a.p.r
   protected class_301 field_479;

   public class_301(Object var1, Object var2, int var3) {
      super(var1, var2);
      this.field_475 = var3;
      this.field_476 = null;
      this.field_477 = this;
      this.field_478 = null;
      this.field_479 = this;
   }

   // $FF: renamed from: a () boolean
   public boolean method_701() {
      return this.a == null;
   }

   // $FF: renamed from: b () boolean
   public boolean method_702() {
      return this.field_477 != this && this.field_478 != this;
   }

   // $FF: renamed from: c () boolean
   public boolean method_703() {
      return !this.method_702();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      if (this.field_475 == -1) {
         var1.append("RootEntry(");
      } else {
         var1.append("Entry(");
      }

      var1.append("key=").append(this.getKey()).append(" [").append(this.field_475).append("], ");
      var1.append("value=").append(this.getValue()).append(", ");
      if (this.field_476 != null) {
         if (this.field_476.field_475 == -1) {
            var1.append("parent=").append("ROOT");
         } else {
            var1.append("parent=").append(this.field_476.getKey()).append(" [").append(this.field_476.field_475).append("]");
         }
      } else {
         var1.append("parent=").append("null");
      }

      var1.append(", ");
      if (this.field_477 != null) {
         if (this.field_477.field_475 == -1) {
            var1.append("left=").append("ROOT");
         } else {
            var1.append("left=").append(this.field_477.getKey()).append(" [").append(this.field_477.field_475).append("]");
         }
      } else {
         var1.append("left=").append("null");
      }

      var1.append(", ");
      if (this.field_478 != null) {
         if (this.field_478.field_475 == -1) {
            var1.append("right=").append("ROOT");
         } else {
            var1.append("right=").append(this.field_478.getKey()).append(" [").append(this.field_478.field_475).append("]");
         }
      } else {
         var1.append("right=").append("null");
      }

      var1.append(", ");
      if (this.field_479 != null) {
         if (this.field_479.field_475 == -1) {
            var1.append("predecessor=").append("ROOT");
         } else {
            var1.append("predecessor=").append(this.field_479.getKey()).append(" [").append(this.field_479.field_475).append("]");
         }
      }

      var1.append(")");
      return var1.toString();
   }
}
