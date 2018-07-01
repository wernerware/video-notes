package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.b
public class class_499 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.a
   private final class_151 field_910;

   protected class_499(class_151 var1) {
      this.field_910 = var1;
   }

   public int size() {
      return this.field_910.size();
   }

   public void clear() {
      this.field_910.clear();
   }

   public boolean contains(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         class_496 var3 = this.field_910.method_442(var2.getKey());
         return var3 != null && var3.equals(var2);
      }
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else if (!this.contains(var1)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         this.field_910.remove(var2.getKey());
         return true;
      }
   }

   public Iterator iterator() {
      return this.field_910.method_459();
   }
}
