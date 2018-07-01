package org.a.a.a.n;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.n.k
public class class_85 extends class_84 implements NavigableSet {
   // $FF: renamed from: b long
   private static final long field_76 = 20150528L;

   // $FF: renamed from: a (java.util.NavigableSet, org.a.a.a.an) org.a.a.a.n.k
   public static class_85 method_180(NavigableSet var0, class_1 var1) {
      return new class_85(var0, var1);
   }

   protected class_85(NavigableSet var1, class_1 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a () java.util.NavigableSet
   protected NavigableSet method_181() {
      return (NavigableSet)super.method_179();
   }

   public Object lower(Object var1) {
      return this.method_181().lower(var1);
   }

   public Object floor(Object var1) {
      return this.method_181().floor(var1);
   }

   public Object ceiling(Object var1) {
      return this.method_181().ceiling(var1);
   }

   public Object higher(Object var1) {
      return this.method_181().higher(var1);
   }

   public Object pollFirst() {
      return this.method_181().pollFirst();
   }

   public Object pollLast() {
      return this.method_181().pollLast();
   }

   public NavigableSet descendingSet() {
      return method_180(this.method_181().descendingSet(), this.a);
   }

   public Iterator descendingIterator() {
      return this.method_181().descendingIterator();
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      NavigableSet var5 = this.method_181().subSet(var1, var2, var3, var4);
      return method_180(var5, this.a);
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      NavigableSet var3 = this.method_181().headSet(var1, var2);
      return method_180(var3, this.a);
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      NavigableSet var3 = this.method_181().tailSet(var1, var2);
      return method_180(var3, this.a);
   }

   // $FF: renamed from: b () java.util.SortedSet
   // $FF: synthetic method
   protected SortedSet method_179() {
      return this.method_181();
   }

   // $FF: renamed from: c () java.util.Set
   // $FF: synthetic method
   protected Set method_177() {
      return this.method_181();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_181();
   }
}
