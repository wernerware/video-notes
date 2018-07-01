package org.a.a.a.j;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.j.g
class class_466 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.j.f
   // $FF: synthetic field
   final class_465 field_847;

   class_466(class_465 var1) {
      this.field_847 = var1;
   }

   public Iterator iterator() {
      return new class_182(this.field_847, this.field_847.field_845.entrySet().iterator());
   }

   public int size() {
      return this.field_847.size();
   }

   public void clear() {
      this.field_847.clear();
   }

   public boolean contains(Object var1) {
      return this.field_847.field_845.entrySet().contains(var1);
   }

   public boolean remove(Object var1) {
      if (!this.contains(var1)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         this.field_847.field_846.method_43(var2.getKey());
         return true;
      }
   }
}
