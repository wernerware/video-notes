package org.a.a.a.h;

import java.util.List;
import org.a.a.a.class_32;

// $FF: renamed from: org.a.a.a.h.n
public class class_53 extends class_50 {
   // $FF: renamed from: a long
   private static final long field_34 = -1708388017160694542L;
   // $FF: renamed from: b org.a.a.a.s
   private final class_32 field_35;

   // $FF: renamed from: a (java.util.List, org.a.a.a.s) org.a.a.a.h.n
   public static class_53 method_110(List var0, class_32 var1) {
      return new class_53(var0, var1);
   }

   protected class_53(List var1, class_32 var2) {
      super(var1);
      if (var2 == null) {
         throw new IllegalArgumentException("Factory must not be null");
      } else {
         this.field_35 = var2;
      }
   }

   public Object get(int var1) {
      int var2 = this.c().size();
      Object var4;
      if (var1 < var2) {
         var4 = this.c().get(var1);
         if (var4 == null) {
            var4 = this.field_35.method_67();
            this.c().set(var1, var4);
            return var4;
         } else {
            return var4;
         }
      } else {
         for(int var3 = var2; var3 < var1; ++var3) {
            this.c().add((Object)null);
         }

         var4 = this.field_35.method_67();
         this.c().add(var4);
         return var4;
      }
   }

   public List subList(int var1, int var2) {
      List var3 = this.c().subList(var1, var2);
      return new class_53(var3, this.field_35);
   }
}
