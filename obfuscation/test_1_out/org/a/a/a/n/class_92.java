package org.a.a.a.n;

import java.util.Set;
import org.a.a.a.class_21;
import org.a.a.a.c.class_90;

// $FF: renamed from: org.a.a.a.n.o
public class class_92 extends class_90 implements Set {
   // $FF: renamed from: b long
   private static final long field_84 = 306127383500410386L;

   // $FF: renamed from: a (java.util.Set, org.a.a.a.aI) org.a.a.a.n.o
   public static class_92 method_199(Set var0, class_21 var1) {
      return new class_92(var0, var1);
   }

   // $FF: renamed from: b (java.util.Set, org.a.a.a.aI) java.util.Set
   public static Set method_200(Set var0, class_21 var1) {
      class_92 var2 = new class_92(var0, var1);
      if (var0.size() > 0) {
         Object[] var3 = (Object[])var0.toArray();
         var0.clear();
         Object[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            var2.f().add(var1.method_25(var7));
         }
      }

      return var2;
   }

   protected class_92(Set var1, class_21 var2) {
      super(var1, var2);
   }

   public boolean equals(Object var1) {
      return var1 == this || this.f().equals(var1);
   }

   public int hashCode() {
      return this.f().hashCode();
   }
}
