package org.a.a.a.n;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;

// $FF: renamed from: org.a.a.a.n.s
public final class class_76 extends class_75 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_63 = -725356885467962424L;

   // $FF: renamed from: a (java.util.SortedSet) java.util.SortedSet
   public static SortedSet method_152(SortedSet var0) {
      return (SortedSet)(var0 instanceof class_29 ? var0 : new class_76(var0));
   }

   private class_76(SortedSet var1) {
      super(var1);
   }

   public Iterator iterator() {
      return class_461.method_1543(this.b().iterator());
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

   public SortedSet subSet(Object var1, Object var2) {
      SortedSet var3 = this.b().subSet(var1, var2);
      return method_152(var3);
   }

   public SortedSet headSet(Object var1) {
      SortedSet var2 = this.b().headSet(var1);
      return method_152(var2);
   }

   public SortedSet tailSet(Object var1) {
      SortedSet var2 = this.b().tailSet(var1);
      return method_152(var2);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_153(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.b());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_154(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
   }
}
