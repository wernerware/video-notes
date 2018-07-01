package org.a.a.a.a;

import java.util.Comparator;
import org.a.a.a.class_22;
import org.a.a.a.class_23;

// $FF: renamed from: org.a.a.a.a.m
public class class_105 extends class_104 implements class_23 {
   // $FF: renamed from: a long
   private static final long field_100 = 722374056718497858L;

   // $FF: renamed from: a (org.a.a.a.aC) org.a.a.a.a.m
   public static class_105 method_226(class_23 var0) {
      return new class_105(var0);
   }

   protected class_105(class_23 var1) {
      super(var1);
   }

   protected class_105(class_22 var1, Object var2) {
      super(var1, var2);
   }

   // $FF: renamed from: f () org.a.a.a.aC
   protected class_23 method_227() {
      return (class_23)this.g();
   }

   // $FF: renamed from: c () java.lang.Object
   public synchronized Object method_31() {
      Object var1 = this.b;
      synchronized(this.b) {
         return this.method_227().method_31();
      }
   }

   // $FF: renamed from: d () java.lang.Object
   public synchronized Object method_32() {
      Object var1 = this.b;
      synchronized(this.b) {
         return this.method_227().method_32();
      }
   }

   // $FF: renamed from: b () java.util.Comparator
   public synchronized Comparator method_30() {
      Object var1 = this.b;
      synchronized(this.b) {
         return this.method_227().method_30();
      }
   }
}
