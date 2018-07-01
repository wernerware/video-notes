package org.a.a.a.k;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.a.a.a.class_28;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.k.r
public final class class_57 extends class_56 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_40 = 20150611L;

   // $FF: renamed from: a (org.a.a.a.af) org.a.a.a.af
   public static class_28 method_116(class_28 var0) {
      return (class_28)(var0 instanceof class_29 ? var0 : new class_57(var0));
   }

   private class_57(class_28 var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_117(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.c());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_118(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
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

   // $FF: renamed from: a (java.lang.Object, int) int
   public int method_59(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: b (java.lang.Object, int) int
   public int method_60(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: c (java.lang.Object, int) int
   public int method_61(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_62() {
      Set var1 = this.c().method_62();
      return class_74.method_150(var1);
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_63() {
      Set var1 = this.c().method_63();
      return class_74.method_150(var1);
   }
}
