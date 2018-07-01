package org.a.a.a;

import java.util.Comparator;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.J
final class class_389 extends class_384 {
   // $FF: renamed from: a java.util.Comparator
   // $FF: synthetic field
   final Comparator field_681;
   // $FF: renamed from: b java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_682;
   // $FF: renamed from: c java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_683;

   class_389(Comparator var1, Iterable var2, Iterable var3) {
      this.field_681 = var1;
      this.field_682 = var2;
      this.field_683 = var3;
   }

   public Iterator iterator() {
      return class_401.method_1195(this.field_681, this.field_682.iterator(), this.field_683.iterator());
   }
}
