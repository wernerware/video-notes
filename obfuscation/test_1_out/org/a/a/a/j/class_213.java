package org.a.a.a.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.f.class_212;
import org.a.a.a.f.class_463;

// $FF: renamed from: org.a.a.a.j.j
class class_213 extends class_212 {
   // $FF: renamed from: a java.util.Collection
   final Collection field_296;
   // $FF: renamed from: b java.util.Iterator
   final Iterator field_297;
   // $FF: renamed from: c org.a.a.a.j.i
   // $FF: synthetic field
   final class_464 field_298;

   class_213(class_464 var1) {
      this.field_298 = var1;
      this.field_296 = new ArrayList(this.field_298.field_844.method_1552().keySet());
      this.field_297 = this.field_296.iterator();
   }

   // $FF: renamed from: a (int) java.util.Iterator
   protected Iterator method_555(int var1) {
      if (!this.field_297.hasNext()) {
         return null;
      } else {
         Object var2 = this.field_297.next();
         class_484 var3 = new class_484(this, var2);
         return new class_463(new class_480(this.field_298.field_844, var2), var3);
      }
   }
}
