package org.a.a.a.p;

import java.io.Serializable;
import java.util.Comparator;

// $FF: renamed from: org.a.a.a.p.w
public abstract class class_333 implements Serializable, Comparator {
   // $FF: renamed from: d long
   private static final long field_555 = -20497563720380683L;
   // $FF: renamed from: a int
   public static final int field_556 = -1;
   // $FF: renamed from: b int
   public static final int field_557 = -2;
   // $FF: renamed from: c int
   public static final int field_558 = -3;

   // $FF: renamed from: a (int) boolean
   static boolean method_825(int var0) {
      return var0 == -3;
   }

   // $FF: renamed from: b (int) boolean
   static boolean method_826(int var0) {
      return var0 == -2;
   }

   // $FF: renamed from: c (int) boolean
   static boolean method_827(int var0) {
      return var0 == -1;
   }

   // $FF: renamed from: d (int) boolean
   static boolean method_828(int var0) {
      return var0 >= 0;
   }

   // $FF: renamed from: a () int
   public abstract int method_829();

   // $FF: renamed from: a (java.lang.Object) int
   public abstract int method_830(Object var1);

   // $FF: renamed from: a (java.lang.Object, int, int) boolean
   public abstract boolean method_831(Object var1, int var2, int var3);

   // $FF: renamed from: a (java.lang.Object, int, int, java.lang.Object, int, int) int
   public abstract int method_832(Object var1, int var2, int var3, Object var4, int var5, int var6);

   // $FF: renamed from: a (java.lang.Object, int, int, java.lang.Object) boolean
   public abstract boolean method_833(Object var1, int var2, int var3, Object var4);

   public int compare(Object var1, Object var2) {
      if (var1 == null) {
         return var2 == null ? 0 : -1;
      } else {
         return var2 == null ? 1 : ((Comparable)var1).compareTo(var2);
      }
   }
}
