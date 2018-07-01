package org.a.a.a.n;

import java.util.Comparator;
import java.util.SortedSet;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.n.p
public class class_93 extends class_92 implements SortedSet {
   // $FF: renamed from: b long
   private static final long field_85 = -1675486811351124386L;

   // $FF: renamed from: a (java.util.SortedSet, org.a.a.a.aI) org.a.a.a.n.p
   public static class_93 method_201(SortedSet var0, class_21 var1) {
      return new class_93(var0, var1);
   }

   // $FF: renamed from: b (java.util.SortedSet, org.a.a.a.aI) org.a.a.a.n.p
   public static class_93 method_202(SortedSet var0, class_21 var1) {
      class_93 var2 = new class_93(var0, var1);
      if (var0.size() > 0) {
         Object[] var3 = (Object[])var0.toArray();
         var0.clear();
         Object[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            var2.f().add(var1.method_25(var7));
         }
      }

      return var2;
   }

   protected class_93(SortedSet var1, class_21 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: b () java.util.SortedSet
   protected SortedSet method_203() {
      return (SortedSet)this.f();
   }

   public Object first() {
      return this.method_203().first();
   }

   public Object last() {
      return this.method_203().last();
   }

   public Comparator comparator() {
      return this.method_203().comparator();
   }

   public SortedSet subSet(Object var1, Object var2) {
      SortedSet var3 = this.method_203().subSet(var1, var2);
      return new class_93(var3, this.a);
   }

   public SortedSet headSet(Object var1) {
      SortedSet var2 = this.method_203().headSet(var1);
      return new class_93(var2, this.a);
   }

   public SortedSet tailSet(Object var1) {
      SortedSet var2 = this.method_203().tailSet(var1);
      return new class_93(var2, this.a);
   }
}
