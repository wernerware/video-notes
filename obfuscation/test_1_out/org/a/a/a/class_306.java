package org.a.a.a;

import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: org.a.a.a.ay
final class class_306 extends class_305 {
   // $FF: renamed from: a java.util.Set
   // $FF: synthetic field
   final Set field_490;
   // $FF: renamed from: b java.util.Set
   // $FF: synthetic field
   final Set field_491;
   // $FF: renamed from: c org.a.a.a.an
   // $FF: synthetic field
   final APPARENTLY_REALLY_IMPORTANT field_492;

   class_306(Set var1, Set var2, APPARENTLY_REALLY_IMPORTANT var3) {
      this.field_490 = var1;
      this.field_491 = var2;
      this.field_492 = var3;
   }

   public boolean contains(Object var1) {
      return this.field_490.contains(var1) && this.field_491.contains(var1);
   }

   // $FF: renamed from: a () java.util.Iterator
   public Iterator method_742() {
      return class_401.method_1200(this.field_490.iterator(), this.field_492);
   }
}
