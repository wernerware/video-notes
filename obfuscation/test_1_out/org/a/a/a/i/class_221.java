package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Iterator;
import org.a.a.a.f.class_166;

// $FF: renamed from: org.a.a.a.i.aa
class class_221 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.U
   private final class_504 field_317;

   class_221(class_504 var1) {
      this.field_317 = var1;
   }

   public int size() {
      return this.field_317.size();
   }

   public void clear() {
      this.field_317.clear();
   }

   public boolean contains(Object var1) {
      return this.field_317.containsKey(var1);
   }

   public boolean remove(Object var1) {
      boolean var2 = this.field_317.containsKey(var1);
      this.field_317.remove(var1);
      return var2;
   }

   public Iterator iterator() {
      if (class_504.method_1605(this.field_317) != null) {
         return class_504.method_1605(this.field_317).keySet().iterator();
      } else {
         return (Iterator)(this.field_317.size() == 0 ? class_166.method_517() : new class_229(this.field_317));
      }
   }
}
