package org.a.a.a.m;

import java.util.List;
import org.a.a.a.class_33;
import org.a.a.a.e.class_296;

// $FF: renamed from: org.a.a.a.m.i
public class class_428 {
   // $FF: renamed from: a java.util.List
   private final List field_736;
   // $FF: renamed from: b java.util.List
   private final List field_737;
   // $FF: renamed from: c org.a.a.a.r
   private final class_33 field_738;
   // $FF: renamed from: d int[]
   private final int[] field_739;
   // $FF: renamed from: e int[]
   private final int[] field_740;

   public class_428(List var1, List var2) {
      this(var1, var2, class_296.method_695());
   }

   public class_428(List var1, List var2, class_33 var3) {
      this.field_736 = var1;
      this.field_737 = var2;
      this.field_738 = var3;
      int var4 = var1.size() + var2.size() + 2;
      this.field_739 = new int[var4];
      this.field_740 = new int[var4];
   }

   // $FF: renamed from: a () org.a.a.a.m.d
   public class_426 method_1420() {
      class_426 var1 = new class_426();
      this.method_1423(0, this.field_736.size(), 0, this.field_737.size(), var1);
      return var1;
   }

   // $FF: renamed from: a (int, int, int, int) org.a.a.a.m.j
   private class_429 method_1421(int var1, int var2, int var3, int var4) {
      int var5;
      for(var5 = var1; var5 - var2 < var4 && var5 < var3 && this.field_738.method_68(this.field_736.get(var5), this.field_737.get(var5 - var2)); ++var5) {
         ;
      }

      return new class_429(var1, var5, var2);
   }

   // $FF: renamed from: b (int, int, int, int) org.a.a.a.m.j
   private class_429 method_1422(int var1, int var2, int var3, int var4) {
      int var5 = var2 - var1;
      int var6 = var4 - var3;
      if (var5 != 0 && var6 != 0) {
         int var7 = var5 - var6;
         int var8 = var6 + var5;
         int var9 = (var8 % 2 == 0 ? var8 : var8 + 1) / 2;
         this.field_739[1 + var9] = var1;
         this.field_740[1 + var9] = var2 + 1;

         for(int var10 = 0; var10 <= var9; ++var10) {
            int var11;
            int var12;
            int var13;
            int var14;
            for(var11 = -var10; var11 <= var10; var11 += 2) {
               var12 = var11 + var9;
               if (var11 != -var10 && (var11 == var10 || this.field_739[var12 - 1] >= this.field_739[var12 + 1])) {
                  this.field_739[var12] = this.field_739[var12 - 1] + 1;
               } else {
                  this.field_739[var12] = this.field_739[var12 + 1];
               }

               var13 = this.field_739[var12];

               for(var14 = var13 - var1 + var3 - var11; var13 < var2 && var14 < var4 && this.field_738.method_68(this.field_736.get(var13), this.field_737.get(var14)); ++var14) {
                  ++var13;
                  this.field_739[var12] = var13;
               }

               if (var7 % 2 != 0 && var7 - var10 <= var11 && var11 <= var7 + var10 && this.field_740[var12 - var7] <= this.field_739[var12]) {
                  return this.method_1421(this.field_740[var12 - var7], var11 + var1 - var3, var2, var4);
               }
            }

            for(var11 = var7 - var10; var11 <= var7 + var10; var11 += 2) {
               var12 = var11 + var9 - var7;
               if (var11 != var7 - var10 && (var11 == var7 + var10 || this.field_740[var12 + 1] > this.field_740[var12 - 1])) {
                  this.field_740[var12] = this.field_740[var12 - 1];
               } else {
                  this.field_740[var12] = this.field_740[var12 + 1] - 1;
               }

               var13 = this.field_740[var12] - 1;

               for(var14 = var13 - var1 + var3 - var11; var13 >= var1 && var14 >= var3 && this.field_738.method_68(this.field_736.get(var13), this.field_737.get(var14)); --var14) {
                  this.field_740[var12] = var13--;
               }

               if (var7 % 2 == 0 && -var10 <= var11 && var11 <= var10 && this.field_740[var12] <= this.field_739[var12 + var7]) {
                  return this.method_1421(this.field_740[var12], var11 + var1 - var3, var2, var4);
               }
            }
         }

         throw new RuntimeException("Internal Error");
      } else {
         return null;
      }
   }

   // $FF: renamed from: a (int, int, int, int, org.a.a.a.m.d) void
   private void method_1423(int var1, int var2, int var3, int var4, class_426 var5) {
      class_429 var6 = this.method_1422(var1, var2, var3, var4);
      int var7;
      if (var6 != null && (var6.method_1424() != var2 || var6.method_1426() != var2 - var4) && (var6.method_1425() != var1 || var6.method_1426() != var1 - var3)) {
         this.method_1423(var1, var6.method_1424(), var3, var6.method_1424() - var6.method_1426(), var5);

         for(var7 = var6.method_1424(); var7 < var6.method_1425(); ++var7) {
            var5.method_1414(new class_424(this.field_736.get(var7)));
         }

         this.method_1423(var6.method_1425(), var2, var6.method_1425() - var6.method_1426(), var4, var5);
      } else {
         var7 = var1;
         int var8 = var3;

         while(true) {
            while(var7 < var2 || var8 < var4) {
               if (var7 < var2 && var8 < var4 && this.field_738.method_68(this.field_736.get(var7), this.field_737.get(var8))) {
                  var5.method_1414(new class_424(this.field_736.get(var7)));
                  ++var7;
                  ++var8;
               } else if (var2 - var1 > var4 - var3) {
                  var5.method_1416(new class_423(this.field_736.get(var7)));
                  ++var7;
               } else {
                  var5.method_1415(new class_425(this.field_737.get(var8)));
                  ++var8;
               }
            }

            return;
         }
      }
   }
}
