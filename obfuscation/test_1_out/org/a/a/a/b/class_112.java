package org.a.a.a.b;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.b.A
class class_112 extends class_108 {
   // $FF: renamed from: a org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_112;

   public class_112(class_362 var1, class_361 var2) {
      super(var1, var2);
      this.field_112 = var1;
   }

   public Iterator iterator() {
      return new class_148(this.field_112, this.b);
   }

   public boolean contains(Object var1) {
      class_362.method_1044(var1, class_361.field_611);
      return class_362.method_1045(this.field_112, var1) != null;
   }

   public boolean remove(Object var1) {
      return class_362.method_1046(this.field_112, var1) != null;
   }
}
