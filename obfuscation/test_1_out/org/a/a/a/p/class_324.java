package org.a.a.a.p;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: org.a.a.a.p.i
final class class_324 extends class_323 {
   // $FF: renamed from: c org.a.a.a.p.l
   private final class_320 field_542;
   // $FF: renamed from: d org.a.a.a.p.r
   private class_301 field_543;
   // $FF: renamed from: e int
   private int field_544;
   // $FF: renamed from: a org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_545;

   public class_324(class_303 var1, class_320 var2) {
      super(var1, var2);
      this.field_545 = var1;
      this.field_544 = 0;
      this.field_542 = var2;
   }

   public int size() {
      return class_320.method_762(this.field_542);
   }

   public Iterator iterator() {
      if (this.field_545.field_488 != this.field_544) {
         this.field_543 = this.field_545.method_734(class_320.method_763(this.field_542), class_320.method_764(this.field_542), class_320.method_765(this.field_542));
         this.field_544 = this.field_545.field_488;
      }

      if (this.field_543 == null) {
         Set var1 = Collections.emptySet();
         return var1.iterator();
      } else {
         return (Iterator)(class_320.method_765(this.field_542) > this.field_543.field_475 ? new class_327(this, this.field_543) : new class_316(this, this.field_543, class_320.method_763(this.field_542), class_320.method_764(this.field_542), class_320.method_765(this.field_542)));
      }
   }
}
