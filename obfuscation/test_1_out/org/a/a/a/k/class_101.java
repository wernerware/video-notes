package org.a.a.a.k;

import java.util.Collection;
import java.util.Set;
import org.a.a.a.class_28;
import org.a.a.a.c.class_100;

// $FF: renamed from: org.a.a.a.k.p
public class class_101 extends class_100 implements class_28 {
   // $FF: renamed from: a long
   private static final long field_95 = 20150629L;

   // $FF: renamed from: a (org.a.a.a.af) org.a.a.a.k.p
   public static class_101 method_222(class_28 var0) {
      return new class_101(var0);
   }

   protected class_101(class_28 var1) {
      super(var1);
   }

   protected class_101(class_28 var1, Object var2) {
      super(var1, var2);
   }

   // $FF: renamed from: c () org.a.a.a.af
   protected class_28 method_223() {
      return (class_28)super.method_221();
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else {
         Object var2 = this.b;
         synchronized(this.b) {
            return this.method_223().equals(var1);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.b;
      synchronized(this.b) {
         return this.method_223().hashCode();
      }
   }

   // $FF: renamed from: b (java.lang.Object, int) int
   public int method_60(Object var1, int var2) {
      Object var3 = this.b;
      synchronized(this.b) {
         return this.method_223().method_60(var1, var2);
      }
   }

   // $FF: renamed from: c (java.lang.Object, int) int
   public int method_61(Object var1, int var2) {
      Object var3 = this.b;
      synchronized(this.b) {
         return this.method_223().method_61(var1, var2);
      }
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_58(Object var1) {
      Object var2 = this.b;
      synchronized(this.b) {
         return this.method_223().method_58(var1);
      }
   }

   // $FF: renamed from: a (java.lang.Object, int) int
   public int method_59(Object var1, int var2) {
      Object var3 = this.b;
      synchronized(this.b) {
         return this.method_223().method_59(var1, var2);
      }
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_62() {
      Object var1 = this.b;
      synchronized(this.b) {
         Set var2 = this.method_223().method_62();
         return new class_102(var2, this.b);
      }
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_63() {
      Object var1 = this.b;
      synchronized(this.b) {
         Set var2 = this.method_223().method_63();
         return new class_102(var2, this.b);
      }
   }

   // $FF: renamed from: g () java.util.Collection
   // $FF: synthetic method
   protected Collection method_221() {
      return this.method_223();
   }
}
