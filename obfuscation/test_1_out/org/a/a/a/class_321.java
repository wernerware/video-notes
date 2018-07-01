package org.a.a.a;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.a.a.a.n.class_73;
import org.a.a.a.n.class_74;
import org.a.a.a.n.class_76;
import org.a.a.a.n.class_78;
import org.a.a.a.n.class_83;
import org.a.a.a.n.class_84;
import org.a.a.a.n.class_85;
import org.a.a.a.n.class_92;
import org.a.a.a.n.class_93;
import org.a.a.a.n.class_94;

// $FF: renamed from: org.a.a.a.at
public class class_321 {
   // $FF: renamed from: a java.util.SortedSet
   public static final SortedSet field_536 = class_76.method_152(new TreeSet());

   // $FF: renamed from: a () java.util.Set
   public static Set method_766() {
      return Collections.emptySet();
   }

   // $FF: renamed from: b () java.util.SortedSet
   public static SortedSet method_767() {
      return field_536;
   }

   // $FF: renamed from: a (java.util.Set) java.util.Set
   public static Set method_768(Set var0) {
      return var0 == null ? Collections.emptySet() : var0;
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Collection) boolean
   public static boolean method_769(Collection var0, Collection var1) {
      if (var0 == var1) {
         return true;
      } else {
         return var0 != null && var1 != null && var0.size() == var1.size() ? var0.containsAll(var1) : false;
      }
   }

   // $FF: renamed from: a (java.util.Collection) int
   public static int method_770(Collection var0) {
      if (var0 == null) {
         return 0;
      } else {
         int var1 = 0;
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            if (var3 != null) {
               var1 += var3.hashCode();
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: c () java.util.Set
   public static Set method_771() {
      return Collections.newSetFromMap(new IdentityHashMap());
   }

   // $FF: renamed from: b (java.util.Set) java.util.Set
   public static Set method_772(Set var0) {
      return Collections.synchronizedSet(var0);
   }

   // $FF: renamed from: c (java.util.Set) java.util.Set
   public static Set method_773(Set var0) {
      return class_74.method_150(var0);
   }

   // $FF: renamed from: a (java.util.Set, org.a.a.a.an) java.util.Set
   public static Set method_774(Set var0, class_1 var1) {
      return class_83.method_176(var0, var1);
   }

   // $FF: renamed from: a (java.util.Set, org.a.a.a.aI) java.util.Set
   public static Set method_775(Set var0, class_21 var1) {
      return class_92.method_199(var0, var1);
   }

   // $FF: renamed from: d (java.util.Set) java.util.Set
   public static Set method_776(Set var0) {
      return class_73.method_141(var0);
   }

   // $FF: renamed from: a (java.util.SortedSet) java.util.SortedSet
   public static SortedSet method_777(SortedSet var0) {
      return Collections.synchronizedSortedSet(var0);
   }

   // $FF: renamed from: b (java.util.SortedSet) java.util.SortedSet
   public static SortedSet method_778(SortedSet var0) {
      return class_76.method_152(var0);
   }

   // $FF: renamed from: a (java.util.SortedSet, org.a.a.a.an) java.util.SortedSet
   public static SortedSet method_779(SortedSet var0, class_1 var1) {
      return class_84.method_178(var0, var1);
   }

   // $FF: renamed from: a (java.util.SortedSet, org.a.a.a.aI) java.util.SortedSet
   public static SortedSet method_780(SortedSet var0, class_21 var1) {
      return class_93.method_201(var0, var1);
   }

   // $FF: renamed from: a (java.util.NavigableSet) java.util.SortedSet
   public static SortedSet method_781(NavigableSet var0) {
      return class_78.method_156(var0);
   }

   // $FF: renamed from: a (java.util.NavigableSet, org.a.a.a.an) java.util.SortedSet
   public static SortedSet method_782(NavigableSet var0, class_1 var1) {
      return class_85.method_180(var0, var1);
   }

   // $FF: renamed from: a (java.util.NavigableSet, org.a.a.a.aI) java.util.SortedSet
   public static SortedSet method_783(NavigableSet var0, class_21 var1) {
      return class_94.method_204(var0, var1);
   }

   // $FF: renamed from: a (java.util.Set, java.util.Set) org.a.a.a.aA
   public static class_305 method_784(Set var0, Set var1) {
      if (var0 != null && var1 != null) {
         class_305 var2 = method_785(var1, var0);
         return new class_308(var0, var1, var2);
      } else {
         throw new NullPointerException("Sets must not be null.");
      }
   }

   // $FF: renamed from: b (java.util.Set, java.util.Set) org.a.a.a.aA
   public static class_305 method_785(Set var0, Set var1) {
      if (var0 != null && var1 != null) {
         class_310 var2 = new class_310(var1);
         return new class_309(var0, var1, var2);
      } else {
         throw new NullPointerException("Sets must not be null.");
      }
   }

   // $FF: renamed from: c (java.util.Set, java.util.Set) org.a.a.a.aA
   public static class_305 method_786(Set var0, Set var1) {
      if (var0 != null && var1 != null) {
         class_325 var2 = new class_325(var1);
         return new class_306(var0, var1, var2);
      } else {
         throw new NullPointerException("Sets must not be null.");
      }
   }

   // $FF: renamed from: d (java.util.Set, java.util.Set) org.a.a.a.aA
   public static class_305 method_787(Set var0, Set var1) {
      if (var0 != null && var1 != null) {
         class_305 var2 = method_785(var0, var1);
         class_305 var3 = method_785(var1, var0);
         return new class_307(var0, var1, var2, var3);
      } else {
         throw new NullPointerException("Sets must not be null.");
      }
   }
}
