package org.a.a.a;

import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: org.a.a.a.az
final class class_307 extends class_305 {
   // $FF: renamed from: a java.util.Set
   // $FF: synthetic field
   final Set field_493;
   // $FF: renamed from: b java.util.Set
   // $FF: synthetic field
   final Set field_494;
   // $FF: renamed from: c org.a.a.a.aA
   // $FF: synthetic field
   final class_305 field_495;
   // $FF: renamed from: d org.a.a.a.aA
   // $FF: synthetic field
   final class_305 field_496;

   class_307(Set var1, Set var2, class_305 var3, class_305 var4) {
      this.field_493 = var1;
      this.field_494 = var2;
      this.field_495 = var3;
      this.field_496 = var4;
   }

   public boolean contains(Object var1) {
      return this.field_493.contains(var1) ^ this.field_494.contains(var1);
   }

   // $FF: renamed from: a () java.util.Iterator
   public Iterator method_742() {
      return class_401.method_1192(this.field_495.iterator(), this.field_496.iterator());
   }

   public boolean isEmpty() {
      return this.field_495.isEmpty() && this.field_496.isEmpty();
   }

   public int size() {
      return this.field_495.size() + this.field_496.size();
   }
}
