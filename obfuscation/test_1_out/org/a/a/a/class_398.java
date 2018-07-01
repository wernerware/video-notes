package org.a.a.a;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.P
final class class_398 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_696;
   // $FF: renamed from: b long
   // $FF: synthetic field
   final long field_697;

   class_398(Iterable var1, long var2) {
      this.field_696 = var1;
      this.field_697 = var2;
   }

   public Iterator iterator() {
      return class_401.method_1208(this.field_696.iterator(), this.field_697);
   }
}
