package org.a.a.a.j;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_400;

// $FF: renamed from: org.a.a.a.j.c
class class_476 extends class_474 implements List {
   // $FF: renamed from: a org.a.a.a.j.a
   // $FF: synthetic field
   final class_470 field_868;

   public class_476(class_470 var1, Object var2) {
      super(var1, var2);
      this.field_868 = var1;
   }

   // $FF: renamed from: a () java.util.List
   protected List method_1571() {
      return (List)this.field_868.method_1552().get(this.b);
   }

   public void add(int var1, Object var2) {
      List var3 = this.method_1571();
      if (var3 == null) {
         var3 = this.field_868.method_1564();
         this.field_868.method_1552().put(this.b, var3);
      }

      var3.add(var1, var2);
   }

   public boolean addAll(int var1, Collection var2) {
      List var3 = this.method_1571();
      if (var3 == null) {
         var3 = this.field_868.method_1564();
         boolean var4 = var3.addAll(var1, var2);
         if (var4) {
            this.field_868.method_1552().put(this.b, var3);
         }

         return var4;
      } else {
         return var3.addAll(var1, var2);
      }
   }

   public Object get(int var1) {
      List var2 = class_400.method_1145(this.method_1571());
      return var2.get(var1);
   }

   public int indexOf(Object var1) {
      List var2 = class_400.method_1145(this.method_1571());
      return var2.indexOf(var1);
   }

   public int lastIndexOf(Object var1) {
      List var2 = class_400.method_1145(this.method_1571());
      return var2.lastIndexOf(var1);
   }

   public ListIterator listIterator() {
      return new class_473(this.field_868, this.b);
   }

   public ListIterator listIterator(int var1) {
      return new class_473(this.field_868, this.b, var1);
   }

   public Object remove(int var1) {
      List var2 = class_400.method_1145(this.method_1571());
      Object var3 = var2.remove(var1);
      if (var2.isEmpty()) {
         this.field_868.method_53(this.b);
      }

      return var3;
   }

   public Object set(int var1, Object var2) {
      List var3 = class_400.method_1145(this.method_1571());
      return var3.set(var1, var2);
   }

   public List subList(int var1, int var2) {
      List var3 = class_400.method_1145(this.method_1571());
      return var3.subList(var1, var2);
   }

   public boolean equals(Object var1) {
      List var2 = this.method_1571();
      if (var2 == null) {
         return Collections.emptyList().equals(var1);
      } else if (!(var1 instanceof List)) {
         return false;
      } else {
         List var3 = (List)var1;
         return class_400.method_1153(var2, var3);
      }
   }

   public int hashCode() {
      List var1 = this.method_1571();
      return class_400.method_1154(var1);
   }

   // $FF: renamed from: b () java.util.Collection
   // $FF: synthetic method
   protected Collection method_1570() {
      return this.method_1571();
   }
}
