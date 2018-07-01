package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.am
class class_242 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.ak
   private final class_131 field_350;

   class_242(class_131 var1) {
      this.field_350 = var1;
   }

   public int size() {
      return this.field_350.size();
   }

   public boolean contains(Object var1) {
      return this.field_350.containsKey(var1);
   }

   public void clear() {
      this.field_350.clear();
   }

   public Iterator iterator() {
      return new class_178(this, this.field_350.entrySet().iterator());
   }
}
