package org.a.a.a.i;

import java.util.AbstractCollection;
import java.util.Iterator;
import org.a.a.a.f.class_220;

// $FF: renamed from: org.a.a.a.i.az
class class_265 extends AbstractCollection {
   // $FF: renamed from: a org.a.a.a.i.au
   // $FF: synthetic field
   final class_130 field_395;

   private class_265(class_130 var1) {
      this.field_395 = var1;
   }

   public Iterator iterator() {
      class_220 var1 = new class_220();
      Iterator var2 = this.field_395.keySet().iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.method_568(new class_298(this.field_395, var3));
      }

      return var1;
   }

   public int size() {
      return this.field_395.method_337();
   }

   public void clear() {
      this.field_395.clear();
   }

   // $FF: synthetic method
   class_265(class_130 var1, class_216 var2) {
      this(var1);
   }
}
