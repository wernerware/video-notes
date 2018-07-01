package org.a.a.a;

import java.util.Iterator;
import java.util.List;
import org.a.a.a.f.class_447;

// $FF: renamed from: org.a.a.a.O
final class class_397 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_695;

   class_397(Iterable var1) {
      this.field_695 = var1;
   }

   public Iterator iterator() {
      List var1 = this.field_695 instanceof List ? (List)this.field_695 : class_401.method_1220(this.field_695.iterator());
      return new class_447(var1);
   }
}
