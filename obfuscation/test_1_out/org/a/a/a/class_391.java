package org.a.a.a;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.L
final class class_391 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_686;
   // $FF: renamed from: b long
   // $FF: synthetic field
   final long field_687;

   class_391(Iterable var1, long var2) {
      this.field_686 = var1;
      this.field_687 = var2;
   }

   public Iterator iterator() {
      return class_401.method_1187(this.field_686.iterator(), this.field_687);
   }
}
