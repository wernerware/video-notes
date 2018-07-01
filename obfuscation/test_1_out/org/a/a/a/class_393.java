package org.a.a.a;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.F
final class class_393 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable[]
   // $FF: synthetic field
   final Iterable[] field_690;
   // $FF: renamed from: b java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_691;

   class_393(Iterable[] var1, Iterable var2) {
      this.field_690 = var1;
      this.field_691 = var2;
   }

   public Iterator iterator() {
      Iterator[] var1 = new Iterator[this.field_690.length + 1];
      var1[0] = this.field_691.iterator();

      for(int var2 = 0; var2 < this.field_690.length; ++var2) {
         var1[var2 + 1] = this.field_690[var2].iterator();
      }

      return class_401.method_1211(var1);
   }
}
