package org.a.a.a.p;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.p.e
class class_331 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_552;

   private class_331(class_303 var1) {
      this.field_552 = var1;
   }

   public Iterator iterator() {
      return new class_314(this, (class_330)null);
   }

   public boolean contains(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         class_301 var2 = this.field_552.method_716(((Entry)var1).getKey());
         return var2 != null && var2.equals(var1);
      }
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else if (!this.contains(var1)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         this.field_552.remove(var2.getKey());
         return true;
      }
   }

   public int size() {
      return this.field_552.size();
   }

   public void clear() {
      this.field_552.clear();
   }

   // $FF: synthetic method
   class_331(class_303 var1, class_330 var2) {
      this(var1);
   }
}
