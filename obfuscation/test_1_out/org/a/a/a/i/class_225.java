package org.a.a.a.i;

import java.util.AbstractCollection;
import java.util.Iterator;
import org.a.a.a.f.class_166;

// $FF: renamed from: org.a.a.a.i.ac
class class_225 extends AbstractCollection {
   // $FF: renamed from: a org.a.a.a.i.U
   private final class_504 field_325;

   class_225(class_504 var1) {
      this.field_325 = var1;
   }

   public int size() {
      return this.field_325.size();
   }

   public void clear() {
      this.field_325.clear();
   }

   public boolean contains(Object var1) {
      return this.field_325.containsValue(var1);
   }

   public Iterator iterator() {
      if (class_504.method_1605(this.field_325) != null) {
         return class_504.method_1605(this.field_325).values().iterator();
      } else {
         return (Iterator)(this.field_325.size() == 0 ? class_166.method_517() : new class_228(this.field_325));
      }
   }
}
