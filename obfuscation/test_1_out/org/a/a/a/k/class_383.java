package org.a.a.a.k;

import java.util.AbstractSet;
import java.util.Iterator;
import org.a.a.a.class_27;

// $FF: renamed from: org.a.a.a.k.j
public class class_383 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.k.g
   private final class_370 field_674;

   protected class_383(class_370 var1) {
      this.field_674 = var1;
   }

   public int size() {
      return this.field_674.method_1094();
   }

   public Iterator iterator() {
      return this.field_674.method_1095();
   }

   public boolean contains(Object var1) {
      if (!(var1 instanceof class_27)) {
         return false;
      } else {
         class_27 var2 = (class_27)var1;
         Object var3 = var2.method_56();
         return this.field_674.method_58(var3) == var2.method_57();
      }
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof class_27)) {
         return false;
      } else {
         class_27 var2 = (class_27)var1;
         Object var3 = var2.method_56();
         if (this.field_674.contains(var3)) {
            int var4 = this.field_674.method_58(var3);
            if (var2.method_57() == var4) {
               this.field_674.method_61(var3, var4);
               return true;
            }
         }

         return false;
      }
   }
}
