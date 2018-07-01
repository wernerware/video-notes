package org.a.a.a.i;

import java.util.Iterator;
import org.a.a.a.f.class_212;
import org.a.a.a.f.class_463;

// $FF: renamed from: org.a.a.a.i.av
class class_216 extends class_212 {
   // $FF: renamed from: a java.util.Iterator
   // $FF: synthetic field
   final Iterator field_301;
   // $FF: renamed from: b org.a.a.a.i.au
   // $FF: synthetic field
   final class_130 field_302;

   class_216(class_130 var1, Iterator var2) {
      this.field_302 = var1;
      this.field_301 = var2;
   }

   // $FF: renamed from: a (int) java.util.Iterator
   protected Iterator method_555(int var1) {
      if (!this.field_301.hasNext()) {
         return null;
      } else {
         Object var2 = this.field_301.next();
         class_261 var3 = new class_261(this, var2);
         return new class_463(new class_298(this.field_302, var2), var3);
      }
   }
}
