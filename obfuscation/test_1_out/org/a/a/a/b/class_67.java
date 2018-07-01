package org.a.a.a.b;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.b.d
public class class_67 extends class_66 implements Set {
   // $FF: renamed from: b long
   private static final long field_51 = 4040410962603292348L;

   protected class_67(class_353 var1) {
      super(var1.field_588.entrySet(), var1);
   }

   public Iterator iterator() {
      return this.a.method_976(super.iterator());
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Object var3;
         Object var4;
         label20: {
            Entry var2 = (Entry)var1;
            var3 = var2.getKey();
            if (this.a.containsKey(var3)) {
               var4 = this.a.field_588.get(var3);
               if (var4 == null) {
                  if (var2.getValue() == null) {
                     break label20;
                  }
               } else if (var4.equals(var2.getValue())) {
                  break label20;
               }
            }

            return false;
         }

         this.a.field_588.remove(var3);
         this.a.field_589.remove(var4);
         return true;
      }
   }
}
