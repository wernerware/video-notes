package org.a.a.a.b;

import java.util.Map.Entry;
import org.a.a.a.class_5;
import org.a.a.a.g.class_255;

// $FF: renamed from: org.a.a.a.b.y
class class_146 extends class_145 implements class_5 {
   // $FF: renamed from: a org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_156;

   class_146(class_362 var1) {
      super(var1, class_361.field_612);
      this.field_156 = var1;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_387() {
      return this.method_389(this.g());
   }

   // $FF: renamed from: b () java.util.Map.Entry
   public Entry method_388() {
      return this.method_389(this.h());
   }

   // $FF: renamed from: a (org.a.a.a.b.B) java.util.Map.Entry
   private Entry method_389(class_150 var1) {
      return new class_255(var1.method_418(), var1.method_417());
   }

   // $FF: synthetic method
   public Object previous() {
      return this.method_388();
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_387();
   }
}
