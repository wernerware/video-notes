package org.a.a.a.p;

import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.p.j
final class class_316 extends class_311 {
   // $FF: renamed from: f java.lang.Object
   private final Object field_513;
   // $FF: renamed from: g int
   private final int field_514;
   // $FF: renamed from: h int
   private final int field_515;
   // $FF: renamed from: i boolean
   private boolean field_516;
   // $FF: renamed from: j org.a.a.a.p.r
   private class_301 field_517;
   // $FF: renamed from: a org.a.a.a.p.i
   // $FF: synthetic field
   final class_324 field_518;

   class_316(class_324 var1, class_301 var2, Object var3, int var4, int var5) {
      super(var1.field_545);
      this.field_518 = var1;
      this.field_517 = var2;
      this.c = var1.field_545.method_728(var2);
      this.field_513 = var3;
      this.field_514 = var4;
      this.field_515 = var5;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_749() {
      class_301 var1 = this.c();
      if (this.field_516) {
         this.c = null;
      }

      return var1;
   }

   // $FF: renamed from: a (org.a.a.a.p.r) org.a.a.a.p.r
   protected class_301 method_746(class_301 var1) {
      return this.field_518.field_545.method_738(var1, this.field_517);
   }

   public void remove() {
      boolean var1 = false;
      int var2 = this.field_517.field_475;
      if (this.d == this.field_517) {
         var1 = true;
      }

      super.remove();
      if (var2 != this.field_517.field_475 || var1) {
         this.field_517 = this.field_518.field_545.method_734(this.field_513, this.field_514, this.field_515);
      }

      if (this.field_515 >= this.field_517.field_475) {
         this.field_516 = true;
      }

   }

   // $FF: synthetic method
   public Object next() {
      return this.method_749();
   }
}
