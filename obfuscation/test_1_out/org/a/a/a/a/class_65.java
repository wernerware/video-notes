package org.a.a.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.a.a.a.class_22;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.a.q
public final class class_65 extends class_60 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_48 = -1873799975157099624L;

   // $FF: renamed from: a (org.a.a.a.b) org.a.a.a.b
   public static class_22 method_134(class_22 var0) {
      return (class_22)(var0 instanceof class_29 ? var0 : new class_65(var0));
   }

   private class_65(class_22 var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_135(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.e());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_136(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
   }

   public Iterator iterator() {
      return class_461.method_1543(this.e().iterator());
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

   // $FF: renamed from: a (java.lang.Object, int) boolean
   public boolean method_27(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: b (java.lang.Object, int) boolean
   public boolean method_28(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_29() {
      Set var1 = this.e().method_29();
      return class_74.method_150(var1);
   }
}
