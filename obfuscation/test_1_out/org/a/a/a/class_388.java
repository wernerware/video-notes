package org.a.a.a;

import java.util.Comparator;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.I
final class class_388 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_679;
   // $FF: renamed from: b java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_680;

   class_388(Iterable var1, Iterable var2) {
      this.field_679 = var1;
      this.field_680 = var2;
   }

   public Iterator iterator() {
      return class_401.method_1195((Comparator)null, this.field_679.iterator(), this.field_680.iterator());
   }
}
