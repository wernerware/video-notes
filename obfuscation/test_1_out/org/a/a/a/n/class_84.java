package org.a.a.a.n;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.n.m
public class class_84 extends class_83 implements SortedSet {
   // $FF: renamed from: b long
   private static final long field_75 = -9110948148132275052L;

   // $FF: renamed from: a (java.util.SortedSet, org.a.a.a.an) org.a.a.a.n.m
   public static class_84 method_178(SortedSet var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return new class_84(var0, var1);
   }

   protected class_84(SortedSet var1, APPARENTLY_REALLY_IMPORTANT var2) {
      super(var1, var2);
   }

   // $FF: renamed from: b () java.util.SortedSet
   protected SortedSet method_179() {
      return (SortedSet)super.method_177();
   }

   public Comparator comparator() {
      return this.method_179().comparator();
   }

   public Object first() {
      return this.method_179().first();
   }

   public Object last() {
      return this.method_179().last();
   }

   public SortedSet subSet(Object var1, Object var2) {
      SortedSet var3 = this.method_179().subSet(var1, var2);
      return new class_84(var3, this.a);
   }

   public SortedSet headSet(Object var1) {
      SortedSet var2 = this.method_179().headSet(var1);
      return new class_84(var2, this.a);
   }

   public SortedSet tailSet(Object var1) {
      SortedSet var2 = this.method_179().tailSet(var1);
      return new class_84(var2, this.a);
   }

   // $FF: renamed from: c () java.util.Set
   // $FF: synthetic method
   protected Set method_177() {
      return this.method_179();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_179();
   }
}
