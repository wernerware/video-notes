package org.a.a.a.j;

import java.util.AbstractCollection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.j.i
class class_464 extends AbstractCollection {
   // $FF: renamed from: a org.a.a.a.j.d
   // $FF: synthetic field
   final class_467 field_844;

   private class_464(class_467 var1) {
      this.field_844 = var1;
   }

   public Iterator iterator() {
      return new class_213(this);
   }

   public int size() {
      return this.field_844.method_33();
   }

   // $FF: synthetic method
   class_464(class_467 var1, class_472 var2) {
      this(var1);
   }
}
