package org.a.a.a.i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.g.class_254;

// $FF: renamed from: org.a.a.a.i.B
class class_500 extends class_499 {
   protected class_500(class_151 var1) {
      super(var1);
   }

   public Object[] toArray() {
      return this.toArray(new Object[this.size()]);
   }

   public Object[] toArray(Object[] var1) {
      ArrayList var2 = new ArrayList(this.size());
      Iterator var3 = this.iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var2.add(new class_254(var4));
      }

      return var2.toArray(var1);
   }
}
