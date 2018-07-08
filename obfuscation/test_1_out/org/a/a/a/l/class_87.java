package org.a.a.a.l;

import java.util.Collection;
import java.util.Queue;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.c.class_81;

// $FF: renamed from: org.a.a.a.l.d
public class class_87 extends class_81 implements Queue {
   // $FF: renamed from: b long
   private static final long field_78 = 2307609000539943581L;

   // $FF: renamed from: a (java.util.Queue, org.a.a.a.an) org.a.a.a.l.d
   public static class_87 method_184(Queue var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return new class_87(var0, var1);
   }

   protected class_87(Queue var1, APPARENTLY_REALLY_IMPORTANT var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a () java.util.Queue
   protected Queue method_185() {
      return (Queue)super.f();
   }

   public boolean offer(Object var1) {
      this.b(var1);
      return this.method_185().offer(var1);
   }

   public Object poll() {
      return this.method_185().poll();
   }

   public Object peek() {
      return this.method_185().peek();
   }

   public Object element() {
      return this.method_185().element();
   }

   public Object remove() {
      return this.method_185().remove();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_185();
   }
}
