package org.a.a.a;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.E
final class class_392 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_688;
   // $FF: renamed from: b java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_689;

   class_392(Iterable var1, Iterable var2) {
      this.field_688 = var1;
      this.field_689 = var2;
   }

   public Iterator iterator() {
      return class_401.method_1209(this.field_688.iterator(), this.field_689.iterator());
   }
}
