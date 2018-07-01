package org.a.a.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.b.x
class class_110 extends class_108 {
   // $FF: renamed from: a org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_110;

   class_110(class_362 var1) {
      super(var1, class_361.field_612);
      this.field_110 = var1;
   }

   public boolean contains(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getValue();
         class_150 var4 = class_362.method_1047(this.field_110, var2.getKey());
         return var4 != null && var4.method_417().equals(var3);
      }
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getValue();
         class_150 var4 = class_362.method_1047(this.field_110, var2.getKey());
         if (var4 != null && var4.method_417().equals(var3)) {
            class_362.method_1049(this.field_110, var4);
            return true;
         } else {
            return false;
         }
      }
   }

   public Iterator iterator() {
      return new class_146(this.field_110);
   }
}
