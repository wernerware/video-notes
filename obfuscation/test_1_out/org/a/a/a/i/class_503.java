package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.f.class_166;

// $FF: renamed from: org.a.a.a.i.W
class class_503 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.U
   private final class_504 field_917;

   class_503(class_504 var1) {
      this.field_917 = var1;
   }

   public int size() {
      return this.field_917.size();
   }

   public void clear() {
      this.field_917.clear();
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         boolean var4 = this.field_917.containsKey(var3);
         this.field_917.remove(var3);
         return var4;
      }
   }

   public Iterator iterator() {
      if (class_504.method_1605(this.field_917) != null) {
         return class_504.method_1605(this.field_917).entrySet().iterator();
      } else {
         return (Iterator)(this.field_917.size() == 0 ? class_166.method_517() : new class_227(this.field_917));
      }
   }
}
