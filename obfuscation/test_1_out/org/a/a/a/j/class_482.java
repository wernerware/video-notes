package org.a.a.a.j;

import java.util.AbstractCollection;
import java.util.Iterator;
import org.a.a.a.f.class_220;

// $FF: renamed from: org.a.a.a.j.q
class class_482 extends AbstractCollection {
   // $FF: renamed from: a org.a.a.a.j.d
   // $FF: synthetic field
   final class_467 field_882;

   private class_482(class_467 var1) {
      this.field_882 = var1;
   }

   public Iterator iterator() {
      class_220 var1 = new class_220();
      Iterator var2 = this.field_882.method_48().iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.method_568(new class_480(this.field_882, var3));
      }

      return var1;
   }

   public int size() {
      return this.field_882.method_33();
   }

   public void clear() {
      this.field_882.method_45();
   }

   // $FF: synthetic method
   class_482(class_467 var1, class_472 var2) {
      this(var1);
   }
}
