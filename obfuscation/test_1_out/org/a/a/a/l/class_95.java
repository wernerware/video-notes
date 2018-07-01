package org.a.a.a.l;

import java.util.Queue;
import org.a.a.a.class_21;
import org.a.a.a.c.class_90;

// $FF: renamed from: org.a.a.a.l.e
public class class_95 extends class_90 implements Queue {
   // $FF: renamed from: b long
   private static final long field_87 = -7901091318986132033L;

   // $FF: renamed from: a (java.util.Queue, org.a.a.a.aI) org.a.a.a.l.e
   public static class_95 method_207(Queue var0, class_21 var1) {
      return new class_95(var0, var1);
   }

   // $FF: renamed from: b (java.util.Queue, org.a.a.a.aI) org.a.a.a.l.e
   public static class_95 method_208(Queue var0, class_21 var1) {
      class_95 var2 = new class_95(var0, var1);
      if (var0.size() > 0) {
         Object[] var3 = (Object[])var0.toArray();
         var0.clear();
         Object[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            var2.f().add(var1.method_25(var7));
         }
      }

      return var2;
   }

   protected class_95(Queue var1, class_21 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a () java.util.Queue
   protected Queue method_209() {
      return (Queue)this.f();
   }

   public boolean offer(Object var1) {
      return this.method_209().offer(this.b(var1));
   }

   public Object poll() {
      return this.method_209().poll();
   }

   public Object peek() {
      return this.method_209().peek();
   }

   public Object element() {
      return this.method_209().element();
   }

   public Object remove() {
      return this.method_209().remove();
   }
}
