package org.a.a.a;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.C
final class class_386 extends class_384 {
   // $FF: renamed from: a java.lang.Iterable
   // $FF: synthetic field
   final Iterable field_676;
   // $FF: renamed from: b org.a.a.a.aI
   // $FF: synthetic field
   final class_21 field_677;

   class_386(Iterable var1, class_21 var2) {
      this.field_676 = var1;
      this.field_677 = var2;
   }

   public Iterator iterator() {
      return class_401.method_1199(this.field_676.iterator(), this.field_677);
   }
}
