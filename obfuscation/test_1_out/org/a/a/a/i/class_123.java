package org.a.a.a.i;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import org.a.a.a.class_16;
import org.a.a.a.class_4;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.i.L
public abstract class class_123 extends class_116 implements class_16 {
   protected class_123() {
   }

   public class_123(SortedMap var1) {
      super(var1);
   }

   // $FF: renamed from: b () java.util.SortedMap
   protected SortedMap method_279() {
      return (SortedMap)super.method_258();
   }

   public Comparator comparator() {
      return this.method_279().comparator();
   }

   public Object firstKey() {
      return this.method_279().firstKey();
   }

   public Object lastKey() {
      return this.method_279().lastKey();
   }

   public SortedMap subMap(Object var1, Object var2) {
      return this.method_279().subMap(var1, var2);
   }

   public SortedMap headMap(Object var1) {
      return this.method_279().headMap(var1);
   }

   public SortedMap tailMap(Object var1) {
      return this.method_279().tailMap(var1);
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      SortedMap var2 = this.headMap(var1);
      return var2.isEmpty() ? null : var2.lastKey();
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      Iterator var2 = this.tailMap(var1).keySet().iterator();
      var2.next();
      return var2.hasNext() ? var2.next() : null;
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return new class_506(this.entrySet());
   }

   // $FF: renamed from: i () java.util.Map
   // $FF: synthetic method
   protected Map method_258() {
      return this.method_279();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }
}
