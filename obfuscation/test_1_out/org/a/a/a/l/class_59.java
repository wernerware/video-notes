package org.a.a.a.l;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;

// $FF: renamed from: org.a.a.a.l.f
public final class class_59 extends class_58 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_42 = 1832948656215393357L;

   // $FF: renamed from: a (java.util.Queue) java.util.Queue
   public static Queue method_120(Queue var0) {
      return (Queue)(var0 instanceof class_29 ? var0 : new class_59(var0));
   }

   private class_59(Queue var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_121(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_122(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
   }

   public Iterator iterator() {
      return class_461.method_1543(this.a().iterator());
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean offer(Object var1) {
      throw new UnsupportedOperationException();
   }

   public Object poll() {
      throw new UnsupportedOperationException();
   }

   public Object remove() {
      throw new UnsupportedOperationException();
   }
}
