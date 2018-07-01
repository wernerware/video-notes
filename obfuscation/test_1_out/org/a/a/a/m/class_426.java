package org.a.a.a.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: org.a.a.a.m.d
public class class_426 {
   // $FF: renamed from: a java.util.List
   private final List field_732 = new ArrayList();
   // $FF: renamed from: b int
   private int field_733 = 0;
   // $FF: renamed from: c int
   private int field_734 = 0;

   // $FF: renamed from: a (org.a.a.a.m.f) void
   public void method_1414(class_424 var1) {
      this.field_732.add(var1);
      ++this.field_733;
   }

   // $FF: renamed from: a (org.a.a.a.m.e) void
   public void method_1415(class_425 var1) {
      this.field_732.add(var1);
      ++this.field_734;
   }

   // $FF: renamed from: a (org.a.a.a.m.b) void
   public void method_1416(class_423 var1) {
      this.field_732.add(var1);
      ++this.field_734;
   }

   // $FF: renamed from: a (org.a.a.a.m.a) void
   public void method_1417(class_36 var1) {
      Iterator var2 = this.field_732.iterator();

      while(var2.hasNext()) {
         class_422 var3 = (class_422)var2.next();
         var3.method_1413(var1);
      }

   }

   // $FF: renamed from: a () int
   public int method_1418() {
      return this.field_733;
   }

   // $FF: renamed from: b () int
   public int method_1419() {
      return this.field_734;
   }
}
