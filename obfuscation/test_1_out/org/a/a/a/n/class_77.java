package org.a.a.a.n;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

// $FF: renamed from: org.a.a.a.n.a
public abstract class class_77 extends class_75 implements NavigableSet {
   // $FF: renamed from: a long
   private static final long field_64 = 20150528L;

   protected class_77() {
   }

   protected class_77(NavigableSet var1) {
      super(var1);
   }

   // $FF: renamed from: a () java.util.NavigableSet
   protected NavigableSet method_155() {
      return (NavigableSet)super.method_151();
   }

   public Object lower(Object var1) {
      return this.method_155().lower(var1);
   }

   public Object floor(Object var1) {
      return this.method_155().floor(var1);
   }

   public Object ceiling(Object var1) {
      return this.method_155().ceiling(var1);
   }

   public Object higher(Object var1) {
      return this.method_155().higher(var1);
   }

   public Object pollFirst() {
      return this.method_155().pollFirst();
   }

   public Object pollLast() {
      return this.method_155().pollLast();
   }

   public NavigableSet descendingSet() {
      return this.method_155().descendingSet();
   }

   public Iterator descendingIterator() {
      return this.method_155().descendingIterator();
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return this.method_155().subSet(var1, var2, var3, var4);
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return this.method_155().headSet(var1, var2);
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return this.method_155().tailSet(var1, var2);
   }

   // $FF: renamed from: b () java.util.SortedSet
   // $FF: synthetic method
   protected SortedSet method_151() {
      return this.method_155();
   }

   // $FF: renamed from: c () java.util.Set
   // $FF: synthetic method
   protected Set method_137() {
      return this.method_155();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_155();
   }
}
