package org.a.a.a.p.a;

import org.a.a.a.p.class_333;

// $FF: renamed from: org.a.a.a.p.a.a
public class class_334 extends class_333 {
   // $FF: renamed from: f long
   private static final long field_559 = -7032449491269434877L;
   // $FF: renamed from: d org.a.a.a.p.a.a
   public static final class_334 field_560 = new class_334();
   // $FF: renamed from: e int
   public static final int field_561 = 16;
   // $FF: renamed from: g int
   private static final int field_562 = 32768;

   // $FF: renamed from: e (int) int
   private static int method_834(int var0) {
      return '耀' >>> var0;
   }

   // $FF: renamed from: a () int
   public int method_829() {
      return 16;
   }

   // $FF: renamed from: a (java.lang.String) int
   public int method_835(String var1) {
      return var1 != null ? var1.length() * 16 : 0;
   }

   // $FF: renamed from: a (java.lang.String, int, int, java.lang.String, int, int) int
   public int method_836(String var1, int var2, int var3, String var4, int var5, int var6) {
      boolean var7 = true;
      if (var2 % 16 == 0 && var5 % 16 == 0 && var3 % 16 == 0 && var6 % 16 == 0) {
         int var8 = var2 / 16;
         int var9 = var5 / 16;
         int var10 = var8 + var3 / 16;
         int var11 = var9 + var6 / 16;
         int var12 = Math.max(var10, var11);
         boolean var13 = false;
         boolean var14 = false;

         for(int var15 = 0; var15 < var12; ++var15) {
            int var16 = var8 + var15;
            int var17 = var9 + var15;
            char var19;
            if (var16 >= var10) {
               var19 = 0;
            } else {
               var19 = var1.charAt(var16);
            }

            char var20;
            if (var4 != null && var17 < var11) {
               var20 = var4.charAt(var17);
            } else {
               var20 = 0;
            }

            if (var19 != var20) {
               int var18 = var19 ^ var20;
               return var15 * 16 + Integer.numberOfLeadingZeros(var18) - 16;
            }

            if (var19 != 0) {
               var7 = false;
            }
         }

         if (var7) {
            return -1;
         } else {
            return -2;
         }
      } else {
         throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
      }
   }

   // $FF: renamed from: a (java.lang.String, int, int) boolean
   public boolean method_837(String var1, int var2, int var3) {
      if (var1 != null && var2 < var3) {
         int var4 = var2 / 16;
         int var5 = var2 % 16;
         return (var1.charAt(var4) & method_834(var5)) != 0;
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (java.lang.String, int, int, java.lang.String) boolean
   public boolean method_838(String var1, int var2, int var3, String var4) {
      if (var2 % 16 == 0 && var3 % 16 == 0) {
         String var5 = var1.substring(var2 / 16, var3 / 16);
         return var4.startsWith(var5);
      } else {
         throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
      }
   }
}
