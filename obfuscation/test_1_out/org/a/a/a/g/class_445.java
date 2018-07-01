package org.a.a.a.g;

import java.io.Serializable;
import java.util.Arrays;

// $FF: renamed from: org.a.a.a.g.f
public class class_445 implements Serializable {
   // $FF: renamed from: a long
   private static final long field_793 = 4465448607415788805L;
   // $FF: renamed from: b java.lang.Object[]
   private final Object[] field_794;
   // $FF: renamed from: c int
   private transient int field_795;

   public class_445(Object var1, Object var2) {
      this((Object[])(new Object[]{var1, var2}), false);
   }

   public class_445(Object var1, Object var2, Object var3) {
      this((Object[])(new Object[]{var1, var2, var3}), false);
   }

   public class_445(Object var1, Object var2, Object var3, Object var4) {
      this((Object[])(new Object[]{var1, var2, var3, var4}), false);
   }

   public class_445(Object var1, Object var2, Object var3, Object var4, Object var5) {
      this((Object[])(new Object[]{var1, var2, var3, var4, var5}), false);
   }

   public class_445(Object[] var1) {
      this(var1, true);
   }

   public class_445(Object[] var1, boolean var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("The array of keys must not be null");
      } else {
         if (var2) {
            this.field_794 = (Object[])var1.clone();
         } else {
            this.field_794 = var1;
         }

         this.method_1519(var1);
      }
   }

   // $FF: renamed from: a () java.lang.Object[]
   public Object[] method_1516() {
      return (Object[])this.field_794.clone();
   }

   // $FF: renamed from: a (int) java.lang.Object
   public Object method_1517(int var1) {
      return this.field_794[var1];
   }

   // $FF: renamed from: b () int
   public int method_1518() {
      return this.field_794.length;
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (var1 instanceof class_445) {
         class_445 var2 = (class_445)var1;
         return Arrays.equals(this.field_794, var2.field_794);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field_795;
   }

   public String toString() {
      return "MultiKey" + Arrays.toString(this.field_794);
   }

   // $FF: renamed from: a (java.lang.Object[]) void
   private void method_1519(Object[] var1) {
      int var2 = 0;
      Object[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object var6 = var3[var5];
         if (var6 != null) {
            var2 ^= var6.hashCode();
         }
      }

      this.field_795 = var2;
   }

   // $FF: renamed from: c () java.lang.Object
   protected Object method_1520() {
      this.method_1519(this.field_794);
      return this;
   }
}
