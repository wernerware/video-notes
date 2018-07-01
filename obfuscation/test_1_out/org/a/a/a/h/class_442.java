package org.a.a.a.h;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.h.y
class class_442 {
   // $FF: renamed from: a org.a.a.a.h.y
   private class_442 field_781;
   // $FF: renamed from: b boolean
   private boolean field_782;
   // $FF: renamed from: c org.a.a.a.h.y
   private class_442 field_783;
   // $FF: renamed from: d boolean
   private boolean field_784;
   // $FF: renamed from: e int
   private int field_785;
   // $FF: renamed from: f int
   private int field_786;
   // $FF: renamed from: g java.lang.Object
   private Object field_787;

   private class_442(int var1, Object var2, class_442 var3, class_442 var4) {
      this.field_786 = var1;
      this.field_787 = var2;
      this.field_784 = true;
      this.field_782 = true;
      this.field_783 = var3;
      this.field_781 = var4;
   }

   private class_442(Collection var1) {
      this(var1.iterator(), 0, var1.size() - 1, 0, (class_442)null, (class_442)null);
   }

   private class_442(Iterator var1, int var2, int var3, int var4, class_442 var5, class_442 var6) {
      int var7 = var2 + (var3 - var2) / 2;
      if (var2 < var7) {
         this.field_781 = new class_442(var1, var2, var7 - 1, var7, var5, this);
      } else {
         this.field_782 = true;
         this.field_781 = var5;
      }

      this.field_787 = var1.next();
      this.field_786 = var7 - var4;
      if (var7 < var3) {
         this.field_783 = new class_442(var1, var7 + 1, var3, var7, this, var6);
      } else {
         this.field_784 = true;
         this.field_783 = var6;
      }

      this.method_1501();
   }

   // $FF: renamed from: a () java.lang.Object
   Object method_1480() {
      return this.field_787;
   }

   // $FF: renamed from: a (java.lang.Object) void
   void method_1481(Object var1) {
      this.field_787 = var1;
   }

   // $FF: renamed from: a (int) org.a.a.a.h.y
   class_442 method_1482(int var1) {
      int var2 = var1 - this.field_786;
      if (var2 == 0) {
         return this;
      } else {
         class_442 var3 = var2 < 0 ? this.method_1490() : this.method_1491();
         return var3 == null ? null : var3.method_1482(var2);
      }
   }

   // $FF: renamed from: a (java.lang.Object, int) int
   int method_1483(Object var1, int var2) {
      if (this.method_1490() != null) {
         int var3 = this.field_781.method_1483(var1, var2 + this.field_781.field_786);
         if (var3 != -1) {
            return var3;
         }
      }

      if (this.field_787 == null) {
         if (this.field_787 != var1) {
            return this.method_1491() != null ? this.field_783.method_1483(var1, var2 + this.field_783.field_786) : -1;
         }
      } else if (!this.field_787.equals(var1)) {
         return this.method_1491() != null ? this.field_783.method_1483(var1, var2 + this.field_783.field_786) : -1;
      }

      return var2;
   }

   // $FF: renamed from: a (java.lang.Object[], int) void
   void method_1484(Object[] var1, int var2) {
      var1[var2] = this.field_787;
      if (this.method_1490() != null) {
         this.field_781.method_1484(var1, var2 + this.field_781.field_786);
      }

      if (this.method_1491() != null) {
         this.field_783.method_1484(var1, var2 + this.field_783.field_786);
      }

   }

   // $FF: renamed from: b () org.a.a.a.h.y
   class_442 method_1485() {
      return !this.field_784 && this.field_783 != null ? this.field_783.method_1493() : this.field_783;
   }

   // $FF: renamed from: c () org.a.a.a.h.y
   class_442 method_1486() {
      return !this.field_782 && this.field_781 != null ? this.field_781.method_1492() : this.field_781;
   }

   // $FF: renamed from: a (int, java.lang.Object) org.a.a.a.h.y
   class_442 method_1487(int var1, Object var2) {
      int var3 = var1 - this.field_786;
      return var3 <= 0 ? this.method_1488(var3, var2) : this.method_1489(var3, var2);
   }

   // $FF: renamed from: b (int, java.lang.Object) org.a.a.a.h.y
   private class_442 method_1488(int var1, Object var2) {
      if (this.method_1490() == null) {
         this.method_1506(new class_442(-1, var2, this, this.field_781), (class_442)null);
      } else {
         this.method_1506(this.field_781.method_1487(var1, var2), (class_442)null);
      }

      if (this.field_786 >= 0) {
         ++this.field_786;
      }

      class_442 var3 = this.method_1498();
      this.method_1501();
      return var3;
   }

   // $FF: renamed from: c (int, java.lang.Object) org.a.a.a.h.y
   private class_442 method_1489(int var1, Object var2) {
      if (this.method_1491() == null) {
         this.method_1507(new class_442(1, var2, this.field_783, this), (class_442)null);
      } else {
         this.method_1507(this.field_783.method_1487(var1, var2), (class_442)null);
      }

      if (this.field_786 < 0) {
         --this.field_786;
      }

      class_442 var3 = this.method_1498();
      this.method_1501();
      return var3;
   }

   // $FF: renamed from: d () org.a.a.a.h.y
   private class_442 method_1490() {
      return this.field_782 ? null : this.field_781;
   }

   // $FF: renamed from: e () org.a.a.a.h.y
   private class_442 method_1491() {
      return this.field_784 ? null : this.field_783;
   }

   // $FF: renamed from: f () org.a.a.a.h.y
   private class_442 method_1492() {
      return this.method_1491() == null ? this : this.field_783.method_1492();
   }

   // $FF: renamed from: g () org.a.a.a.h.y
   private class_442 method_1493() {
      return this.method_1490() == null ? this : this.field_781.method_1493();
   }

   // $FF: renamed from: b (int) org.a.a.a.h.y
   class_442 method_1494(int var1) {
      int var2 = var1 - this.field_786;
      if (var2 == 0) {
         return this.method_1497();
      } else {
         if (var2 > 0) {
            this.method_1507(this.field_783.method_1494(var2), this.field_783.field_783);
            if (this.field_786 < 0) {
               ++this.field_786;
            }
         } else {
            this.method_1506(this.field_781.method_1494(var2), this.field_781.field_781);
            if (this.field_786 > 0) {
               --this.field_786;
            }
         }

         this.method_1501();
         return this.method_1498();
      }
   }

   // $FF: renamed from: h () org.a.a.a.h.y
   private class_442 method_1495() {
      if (this.method_1491() == null) {
         return this.method_1497();
      } else {
         this.method_1507(this.field_783.method_1495(), this.field_783.field_783);
         if (this.field_786 < 0) {
            ++this.field_786;
         }

         this.method_1501();
         return this.method_1498();
      }
   }

   // $FF: renamed from: i () org.a.a.a.h.y
   private class_442 method_1496() {
      if (this.method_1490() == null) {
         return this.method_1497();
      } else {
         this.method_1506(this.field_781.method_1496(), this.field_781.field_781);
         if (this.field_786 > 0) {
            --this.field_786;
         }

         this.method_1501();
         return this.method_1498();
      }
   }

   // $FF: renamed from: j () org.a.a.a.h.y
   private class_442 method_1497() {
      if (this.method_1491() == null && this.method_1490() == null) {
         return null;
      } else if (this.method_1491() == null) {
         if (this.field_786 > 0) {
            this.field_781.field_786 += this.field_786 + (this.field_786 > 0 ? 0 : 1);
         }

         this.field_781.method_1492().method_1507((class_442)null, this.field_783);
         return this.field_781;
      } else if (this.method_1490() == null) {
         this.field_783.field_786 += this.field_786 - (this.field_786 < 0 ? 0 : 1);
         this.field_783.method_1493().method_1506((class_442)null, this.field_781);
         return this.field_783;
      } else {
         class_442 var1;
         if (this.method_1503() > 0) {
            var1 = this.field_783.method_1493();
            this.field_787 = var1.field_787;
            if (this.field_782) {
               this.field_781 = var1.field_781;
            }

            this.field_783 = this.field_783.method_1496();
            if (this.field_786 < 0) {
               ++this.field_786;
            }
         } else {
            var1 = this.field_781.method_1492();
            this.field_787 = var1.field_787;
            if (this.field_784) {
               this.field_783 = var1.field_783;
            }

            class_442 var2 = this.field_781.field_781;
            this.field_781 = this.field_781.method_1495();
            if (this.field_781 == null) {
               this.field_781 = var2;
               this.field_782 = true;
            }

            if (this.field_786 > 0) {
               --this.field_786;
            }
         }

         this.method_1501();
         return this;
      }
   }

   // $FF: renamed from: k () org.a.a.a.h.y
   private class_442 method_1498() {
      switch(this.method_1503()) {
      case -2:
         if (this.field_781.method_1503() > 0) {
            this.method_1506(this.field_781.method_1504(), (class_442)null);
         }

         return this.method_1505();
      case -1:
      case 0:
      case 1:
         return this;
      case 2:
         if (this.field_783.method_1503() < 0) {
            this.method_1507(this.field_783.method_1505(), (class_442)null);
         }

         return this.method_1504();
      default:
         throw new RuntimeException("tree inconsistent!");
      }
   }

   // $FF: renamed from: c (org.a.a.a.h.y) int
   private int method_1499(class_442 var1) {
      return var1 == null ? 0 : var1.field_786;
   }

   // $FF: renamed from: a (org.a.a.a.h.y, int) int
   private int method_1500(class_442 var1, int var2) {
      if (var1 == null) {
         return 0;
      } else {
         int var3 = this.method_1499(var1);
         var1.field_786 = var2;
         return var3;
      }
   }

   // $FF: renamed from: l () void
   private void method_1501() {
      this.field_785 = Math.max(this.method_1490() == null ? -1 : this.method_1490().field_785, this.method_1491() == null ? -1 : this.method_1491().field_785) + 1;
   }

   // $FF: renamed from: d (org.a.a.a.h.y) int
   private int method_1502(class_442 var1) {
      return var1 == null ? -1 : var1.field_785;
   }

   // $FF: renamed from: m () int
   private int method_1503() {
      return this.method_1502(this.method_1491()) - this.method_1502(this.method_1490());
   }

   // $FF: renamed from: n () org.a.a.a.h.y
   private class_442 method_1504() {
      class_442 var1 = this.field_783;
      class_442 var2 = this.method_1491().method_1490();
      int var3 = this.field_786 + this.method_1499(var1);
      int var4 = -var1.field_786;
      int var5 = this.method_1499(var1) + this.method_1499(var2);
      this.method_1507(var2, var1);
      var1.method_1506(this, (class_442)null);
      this.method_1500(var1, var3);
      this.method_1500(this, var4);
      this.method_1500(var2, var5);
      return var1;
   }

   // $FF: renamed from: o () org.a.a.a.h.y
   private class_442 method_1505() {
      class_442 var1 = this.field_781;
      class_442 var2 = this.method_1490().method_1491();
      int var3 = this.field_786 + this.method_1499(var1);
      int var4 = -var1.field_786;
      int var5 = this.method_1499(var1) + this.method_1499(var2);
      this.method_1506(var2, var1);
      var1.method_1507(this, (class_442)null);
      this.method_1500(var1, var3);
      this.method_1500(this, var4);
      this.method_1500(var2, var5);
      return var1;
   }

   // $FF: renamed from: a (org.a.a.a.h.y, org.a.a.a.h.y) void
   private void method_1506(class_442 var1, class_442 var2) {
      this.field_782 = var1 == null;
      this.field_781 = this.field_782 ? var2 : var1;
      this.method_1501();
   }

   // $FF: renamed from: b (org.a.a.a.h.y, org.a.a.a.h.y) void
   private void method_1507(class_442 var1, class_442 var2) {
      this.field_784 = var1 == null;
      this.field_783 = this.field_784 ? var2 : var1;
      this.method_1501();
   }

   // $FF: renamed from: b (org.a.a.a.h.y, int) org.a.a.a.h.y
   private class_442 method_1508(class_442 var1, int var2) {
      class_442 var3 = this.method_1492();
      class_442 var4 = var1.method_1493();
      int var8;
      if (var1.field_785 > this.field_785) {
         class_442 var11 = this.method_1495();
         ArrayDeque var12 = new ArrayDeque();
         class_442 var13 = var1;
         var8 = var1.field_786 + var2;
         int var14 = 0;

         while(var13 != null && var13.field_785 > this.method_1502(var11)) {
            var14 = var8;
            var12.push(var13);
            var13 = var13.field_781;
            if (var13 != null) {
               var8 += var13.field_786;
            }
         }

         var3.method_1506(var11, (class_442)null);
         var3.method_1507(var13, var4);
         if (var11 != null) {
            var11.method_1492().method_1507((class_442)null, var3);
            var11.field_786 -= var2 - 1;
         }

         if (var13 != null) {
            var13.method_1493().method_1506((class_442)null, var3);
            var13.field_786 = var8 - var2 + 1;
         }

         var3.field_786 = var2 - 1 - var14;
         var1.field_786 += var2;

         class_442 var10;
         for(var13 = var3; !var12.isEmpty(); var13 = var10.method_1498()) {
            var10 = (class_442)var12.pop();
            var10.method_1506(var13, (class_442)null);
         }

         return var13;
      } else {
         var1 = var1.method_1496();
         ArrayDeque var5 = new ArrayDeque();
         class_442 var6 = this;
         int var7 = this.field_786;
         var8 = 0;

         while(var6 != null && var6.field_785 > this.method_1502(var1)) {
            var8 = var7;
            var5.push(var6);
            var6 = var6.field_783;
            if (var6 != null) {
               var7 += var6.field_786;
            }
         }

         var4.method_1507(var1, (class_442)null);
         var4.method_1506(var6, var3);
         if (var1 != null) {
            var1.method_1493().method_1506((class_442)null, var4);
            ++var1.field_786;
         }

         if (var6 != null) {
            var6.method_1492().method_1507((class_442)null, var4);
            var6.field_786 = var7 - var2;
         }

         var4.field_786 = var2 - var8;

         class_442 var9;
         for(var6 = var4; !var5.isEmpty(); var6 = var9.method_1498()) {
            var9 = (class_442)var5.pop();
            var9.method_1507(var6, (class_442)null);
         }

         return var6;
      }
   }

   public String toString() {
      return "AVLNode(" + this.field_786 + ',' + (this.field_781 != null) + ',' + this.field_787 + ',' + (this.method_1491() != null) + ", faedelung " + this.field_784 + " )";
   }

   // $FF: synthetic method
   class_442(Collection var1, class_441 var2) {
      this(var1);
   }

   // $FF: renamed from: a (org.a.a.a.h.y) int
   // $FF: synthetic method
   static int method_1509(class_442 var0) {
      return var0.field_786;
   }

   // $FF: synthetic method
   class_442(int var1, Object var2, class_442 var3, class_442 var4, class_441 var5) {
      this(var1, var2, var3, var4);
   }

   // $FF: renamed from: a (org.a.a.a.h.y, org.a.a.a.h.y, int) org.a.a.a.h.y
   // $FF: synthetic method
   static class_442 method_1510(class_442 var0, class_442 var1, int var2) {
      return var0.method_1508(var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.h.y) java.lang.Object
   // $FF: synthetic method
   static Object method_1511(class_442 var0) {
      return var0.field_787;
   }
}
