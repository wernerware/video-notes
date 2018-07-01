package org.a.a.a.i;

import java.util.AbstractList;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.ar
class class_259 extends AbstractList {
   // $FF: renamed from: a org.a.a.a.i.ak
   private final class_131 field_382;

   class_259(class_131 var1) {
      this.field_382 = var1;
   }

   public int size() {
      return this.field_382.size();
   }

   public boolean contains(Object var1) {
      return this.field_382.containsValue(var1);
   }

   public void clear() {
      this.field_382.clear();
   }

   public Iterator iterator() {
      return new class_177(this, this.field_382.entrySet().iterator());
   }

   public Object get(int var1) {
      return this.field_382.method_346(var1);
   }

   public Object set(int var1, Object var2) {
      return this.field_382.method_348(var1, var2);
   }

   public Object remove(int var1) {
      return this.field_382.method_350(var1);
   }
}
