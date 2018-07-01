package org.a.a.a.n;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.n.n
public class class_94 extends class_93 implements NavigableSet {
   // $FF: renamed from: b long
   private static final long field_86 = 20150528L;

   // $FF: renamed from: a (java.util.NavigableSet, org.a.a.a.aI) org.a.a.a.n.n
   public static class_94 method_204(NavigableSet var0, class_21 var1) {
      return new class_94(var0, var1);
   }

   // $FF: renamed from: b (java.util.NavigableSet, org.a.a.a.aI) org.a.a.a.n.n
   public static class_94 method_205(NavigableSet var0, class_21 var1) {
      class_94 var2 = new class_94(var0, var1);
      if (var0.size() > 0) {
         Object[] var3 = (Object[])var0.toArray();
         var0.clear();
         Object[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            var2.method_206().add(var1.method_25(var7));
         }
      }

      return var2;
   }

   protected class_94(NavigableSet var1, class_21 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a () java.util.NavigableSet
   protected NavigableSet method_206() {
      return (NavigableSet)super.f();
   }

   public Object lower(Object var1) {
      return this.method_206().lower(var1);
   }

   public Object floor(Object var1) {
      return this.method_206().floor(var1);
   }

   public Object ceiling(Object var1) {
      return this.method_206().ceiling(var1);
   }

   public Object higher(Object var1) {
      return this.method_206().higher(var1);
   }

   public Object pollFirst() {
      return this.method_206().pollFirst();
   }

   public Object pollLast() {
      return this.method_206().pollLast();
   }

   public NavigableSet descendingSet() {
      return method_204(this.method_206().descendingSet(), this.a);
   }

   public Iterator descendingIterator() {
      return this.method_206().descendingIterator();
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      NavigableSet var5 = this.method_206().subSet(var1, var2, var3, var4);
      return method_204(var5, this.a);
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      NavigableSet var3 = this.method_206().headSet(var1, var2);
      return method_204(var3, this.a);
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      NavigableSet var3 = this.method_206().tailSet(var1, var2);
      return method_204(var3, this.a);
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_206();
   }
}
