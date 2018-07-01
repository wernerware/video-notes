package org.a.a.a;

import java.util.Iterator;
import org.a.a.a.f.class_224;

// $FF: renamed from: org.a.a.a.D
final class class_387 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_678;

   class_387(Iterable var1) {
      this.field_678 = var1;
   }

   public Iterator iterator() {
      return new class_224(this.field_678.iterator());
   }
}
