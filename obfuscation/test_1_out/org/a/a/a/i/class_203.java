package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.aR
class class_203 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.aL
   // $FF: synthetic field
   final class_115 field_274;

   private class_203(class_115 var1) {
      this.field_274 = var1;
   }

   public int size() {
      return this.field_274.size();
   }

   public void clear() {
      this.field_274.clear();
   }

   public Iterator iterator() {
      return new class_193(this.field_274, (class_174)null);
   }

   public boolean contains(Object var1) {
      return this.field_274.containsKey(var1);
   }

   public boolean remove(Object param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   class_203(class_115 var1, class_174 var2) {
      this(var1);
   }
}
