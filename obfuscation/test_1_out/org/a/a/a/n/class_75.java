package org.a.a.a.n;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

// $FF: renamed from: org.a.a.a.n.d
public abstract class class_75 extends class_70 implements SortedSet {
   // $FF: renamed from: a long
   private static final long field_62 = -3462240946294214398L;

   protected class_75() {
   }

   protected class_75(Set var1) {
      super(var1);
   }

   // $FF: renamed from: b () java.util.SortedSet
   protected SortedSet method_151() {
      return (SortedSet)super.method_137();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return this.method_151().subSet(var1, var2);
   }

   public SortedSet headSet(Object var1) {
      return this.method_151().headSet(var1);
   }

   public SortedSet tailSet(Object var1) {
      return this.method_151().tailSet(var1);
   }

   public Object first() {
      return this.method_151().first();
   }

   public Object last() {
      return this.method_151().last();
   }

   public Comparator comparator() {
      return this.method_151().comparator();
   }

   // $FF: renamed from: c () java.util.Set
   // $FF: synthetic method
   protected Set method_137() {
      return this.method_151();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_151();
   }
}
