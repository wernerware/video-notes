package org.a.a.a.b;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.b.C
class class_111 extends class_108 {
   // $FF: renamed from: a org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_111;

   public class_111(class_362 var1, class_361 var2) {
      super(var1, var2);
      this.field_111 = var1;
   }

   public Iterator iterator() {
      return new class_147(this.field_111, this.b);
   }

   public boolean contains(Object var1) {
      class_362.method_1044(var1, class_361.field_612);
      return class_362.method_1047(this.field_111, var1) != null;
   }

   public boolean remove(Object var1) {
      return class_362.method_1048(this.field_111, var1) != null;
   }
}
