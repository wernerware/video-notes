package org.a.a.a.i;

import java.util.ArrayList;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.D
class class_495 extends class_494 {
   protected class_495(class_151 var1) {
      super(var1);
   }

   public Object[] toArray() {
      return this.toArray(new Object[this.size()]);
   }

   public Object[] toArray(Object[] var1) {
      ArrayList var2 = new ArrayList(this.size());
      Iterator var3 = this.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.add(var4);
      }

      return var2.toArray(var1);
   }
}
