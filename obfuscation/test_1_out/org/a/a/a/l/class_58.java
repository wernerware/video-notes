package org.a.a.a.l;

import java.util.Collection;
import java.util.Queue;
import org.a.a.a.c.class_48;

// $FF: renamed from: org.a.a.a.l.a
public abstract class class_58 extends class_48 implements Queue {
   // $FF: renamed from: a long
   private static final long field_41 = -2629815475789577029L;

   protected class_58() {
   }

   protected class_58(Queue var1) {
      super(var1);
   }

   // $FF: renamed from: a () java.util.Queue
   protected Queue method_119() {
      return (Queue)super.method_103();
   }

   public boolean offer(Object var1) {
      return this.method_119().offer(var1);
   }

   public Object poll() {
      return this.method_119().poll();
   }

   public Object peek() {
      return this.method_119().peek();
   }

   public Object element() {
      return this.method_119().element();
   }

   public Object remove() {
      return this.method_119().remove();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_119();
   }
}
