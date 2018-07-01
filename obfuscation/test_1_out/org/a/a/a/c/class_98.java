package org.a.a.a.c;

import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;

// $FF: renamed from: org.a.a.a.c.j
public final class class_98 extends class_48 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_90 = -239892006883819945L;

   // $FF: renamed from: b (java.util.Collection) java.util.Collection
   public static Collection method_216(Collection var0) {
      return (Collection)(var0 instanceof class_29 ? var0 : new class_98(var0));
   }

   private class_98(Collection var1) {
      super(var1);
   }

   public Iterator iterator() {
      return class_461.method_1543(this.f().iterator());
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
}
