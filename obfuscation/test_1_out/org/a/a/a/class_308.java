package org.a.a.a;

import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: org.a.a.a.au
final class class_308 extends class_305 {
   // $FF: renamed from: a java.util.Set
   // $FF: synthetic field
   final Set field_497;
   // $FF: renamed from: b java.util.Set
   // $FF: synthetic field
   final Set field_498;
   // $FF: renamed from: c org.a.a.a.aA
   // $FF: synthetic field
   final class_305 field_499;

   class_308(Set var1, Set var2, class_305 var3) {
      this.field_497 = var1;
      this.field_498 = var2;
      this.field_499 = var3;
   }

   public boolean contains(Object var1) {
      return this.field_497.contains(var1) || this.field_498.contains(var1);
   }

   // $FF: renamed from: a () java.util.Iterator
   public Iterator method_742() {
      return class_401.method_1192(this.field_497.iterator(), this.field_499.iterator());
   }

   public boolean isEmpty() {
      return this.field_497.isEmpty() && this.field_498.isEmpty();
   }

   public int size() {
      return this.field_497.size() + this.field_499.size();
   }
}
