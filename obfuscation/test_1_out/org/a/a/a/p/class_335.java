package org.a.a.a.p;

import java.util.AbstractCollection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.p.u
class class_335 extends AbstractCollection {
   // $FF: renamed from: a org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_563;

   private class_335(class_303 var1) {
      this.field_563 = var1;
   }

   public Iterator iterator() {
      return new class_313(this, (class_330)null);
   }

   public int size() {
      return this.field_563.size();
   }

   public boolean contains(Object var1) {
      return this.field_563.containsValue(var1);
   }

   public void clear() {
      this.field_563.clear();
   }

   public boolean remove(Object var1) {
      Iterator var2 = this.iterator();

      Object var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = var2.next();
      } while(!class_302.method_711(var3, var1));

      var2.remove();
      return true;
   }

   // $FF: synthetic method
   class_335(class_303 var1, class_330 var2) {
      this(var1);
   }
}
