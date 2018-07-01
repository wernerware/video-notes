package org.a.a.a.m;

import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: org.a.a.a.m.g
public class class_430 implements class_36 {
   // $FF: renamed from: a java.util.List
   private final List field_744 = new ArrayList();
   // $FF: renamed from: b java.util.List
   private final List field_745 = new ArrayList();
   // $FF: renamed from: c int
   private int field_746 = 0;
   // $FF: renamed from: d org.a.a.a.m.h
   private final class_37 field_747;

   public class_430(class_37 var1) {
      this.field_747 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) void
   public void method_73(Object var1) {
      this.field_744.add(var1);
   }

   // $FF: renamed from: c (java.lang.Object) void
   public void method_74(Object var1) {
      if (this.field_745.isEmpty() && this.field_744.isEmpty()) {
         ++this.field_746;
      } else {
         this.field_747.method_76(this.field_746, this.field_745, this.field_744);
         this.field_745.clear();
         this.field_744.clear();
         this.field_746 = 1;
      }

   }

   // $FF: renamed from: b (java.lang.Object) void
   public void method_75(Object var1) {
      this.field_745.add(var1);
   }
}
