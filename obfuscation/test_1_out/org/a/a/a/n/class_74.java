package org.a.a.a.n;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;

// $FF: renamed from: org.a.a.a.n.r
public final class class_74 extends class_72 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_61 = 6499119872185240161L;

   // $FF: renamed from: a (java.util.Set) java.util.Set
   public static Set method_150(Set var0) {
      return (Set)(var0 instanceof class_29 ? var0 : new class_74(var0));
   }

   private class_74(Set var1) {
      super(var1);
   }

   public Iterator iterator() {
      return class_461.method_1543(this.c().iterator());
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
