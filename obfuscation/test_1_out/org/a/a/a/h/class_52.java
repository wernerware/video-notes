package org.a.a.a.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: org.a.a.a.h.m
public class class_52 extends class_50 {
   // $FF: renamed from: a long
   private static final long field_33 = -3620001881672L;

   // $FF: renamed from: a (java.util.List) org.a.a.a.h.m
   public static class_52 method_109(List var0) {
      return new class_52(var0);
   }

   public class_52() {
      super(new ArrayList());
   }

   public class_52(int var1) {
      super(new ArrayList(var1));
   }

   protected class_52(List var1) {
      super(var1);
   }

   public void add(int var1, Object var2) {
      int var3 = this.c().size();
      if (var1 > var3) {
         this.c().addAll(Collections.nCopies(var1 - var3, (Object)null));
      }

      this.c().add(var1, var2);
   }

   public boolean addAll(int var1, Collection var2) {
      int var3 = this.c().size();
      boolean var4 = false;
      if (var1 > var3) {
         this.c().addAll(Collections.nCopies(var1 - var3, (Object)null));
         var4 = true;
      }

      return this.c().addAll(var1, var2) | var4;
   }

   public Object set(int var1, Object var2) {
      int var3 = this.c().size();
      if (var1 >= var3) {
         this.c().addAll(Collections.nCopies(var1 - var3 + 1, (Object)null));
      }

      return this.c().set(var1, var2);
   }
}
