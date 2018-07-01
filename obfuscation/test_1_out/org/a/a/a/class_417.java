package org.a.a.a;

import java.util.ArrayList;
import java.util.EmptyStackException;

// $FF: renamed from: org.a.a.a.a
public class class_417 extends ArrayList {
   // $FF: renamed from: a long
   private static final long field_726 = 2130079159931574599L;

   public class_417() {
   }

   public class_417(int var1) {
      super(var1);
   }

   // $FF: renamed from: a () boolean
   public boolean method_1403() {
      return this.isEmpty();
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_1404() {
      int var1 = this.size();
      if (var1 <= 0) {
         throw new EmptyStackException();
      } else {
         return this.get(var1 - 1);
      }
   }

   // $FF: renamed from: a (int) java.lang.Object
   public Object method_1405(int var1) {
      int var2 = this.size() - var1 - 1;
      if (var2 < 0) {
         throw new EmptyStackException();
      } else {
         return this.get(var2);
      }
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_1406() {
      int var1 = this.size();
      if (var1 <= 0) {
         throw new EmptyStackException();
      } else {
         return this.remove(var1 - 1);
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_1407(Object var1) {
      this.add(var1);
      return var1;
   }

   // $FF: renamed from: b (java.lang.Object) int
   public int method_1408(Object var1) {
      int var2 = this.size() - 1;

      for(int var3 = 1; var2 >= 0; ++var3) {
         Object var4 = this.get(var2);
         if (var1 == null && var4 == null || var1 != null && var1.equals(var4)) {
            return var3;
         }

         --var2;
      }

      return -1;
   }
}
