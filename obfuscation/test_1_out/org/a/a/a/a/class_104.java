package org.a.a.a.a;

import java.util.Set;
import org.a.a.a.class_22;
import org.a.a.a.c.class_100;

// $FF: renamed from: org.a.a.a.a.k
public class class_104 extends class_100 implements class_22 {
   // $FF: renamed from: a long
   private static final long field_99 = 8084674570753837109L;

   // $FF: renamed from: a (org.a.a.a.b) org.a.a.a.a.k
   public static class_104 method_224(class_22 var0) {
      return new class_104(var0);
   }

   protected class_104(class_22 var1) {
      super(var1);
   }

   protected class_104(class_22 var1, Object var2) {
      super(var1, var2);
   }

   // $FF: renamed from: e () org.a.a.a.b
   protected class_22 method_225() {
      return (class_22)this.g();
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else {
         Object var2 = this.b;
         synchronized(this.b) {
            return this.method_225().equals(var1);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.b;
      synchronized(this.b) {
         return this.method_225().hashCode();
      }
   }

   // $FF: renamed from: a (java.lang.Object, int) boolean
   public boolean method_27(Object var1, int var2) {
      Object var3 = this.b;
      synchronized(this.b) {
         return this.method_225().method_27(var1, var2);
      }
   }

   // $FF: renamed from: b (java.lang.Object, int) boolean
   public boolean method_28(Object var1, int var2) {
      Object var3 = this.b;
      synchronized(this.b) {
         return this.method_225().method_28(var1, var2);
      }
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_29() {
      Object var1 = this.b;
      synchronized(this.b) {
         Set var2 = this.method_225().method_29();
         return new class_103(this, var2, this.b);
      }
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_26(Object var1) {
      Object var2 = this.b;
      synchronized(this.b) {
         return this.method_225().method_26(var1);
      }
   }
}
