package org.a.a.a.n;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;

// $FF: renamed from: org.a.a.a.n.q
public final class class_78 extends class_77 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_65 = 20150528L;

   // $FF: renamed from: a (java.util.NavigableSet) java.util.NavigableSet
   public static NavigableSet method_156(NavigableSet var0) {
      return (NavigableSet)(var0 instanceof class_29 ? var0 : new class_78(var0));
   }

   private class_78(NavigableSet var1) {
      super(var1);
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

   public SortedSet subSet(Object var1, Object var2) {
      SortedSet var3 = this.a().subSet(var1, var2);
      return class_76.method_152(var3);
   }

   public SortedSet headSet(Object var1) {
      SortedSet var2 = this.a().headSet(var1);
      return class_76.method_152(var2);
   }

   public SortedSet tailSet(Object var1) {
      SortedSet var2 = this.a().tailSet(var1);
      return class_76.method_152(var2);
   }

   public NavigableSet descendingSet() {
      return method_156(this.a().descendingSet());
   }

   public Iterator descendingIterator() {
      return class_461.method_1543(this.a().descendingIterator());
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      NavigableSet var5 = this.a().subSet(var1, var2, var3, var4);
      return method_156(var5);
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      NavigableSet var3 = this.a().headSet(var1, var2);
      return method_156(var3);
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      NavigableSet var3 = this.a().tailSet(var1, var2);
      return method_156(var3);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_157(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_158(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
   }
}
