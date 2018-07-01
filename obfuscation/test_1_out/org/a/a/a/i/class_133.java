package org.a.a.a.i;

import java.util.Comparator;
import java.util.SortedMap;
import org.a.a.a.class_21;
import org.a.a.a.class_32;

// $FF: renamed from: org.a.a.a.i.ah
public class class_133 extends class_132 implements SortedMap {
   // $FF: renamed from: c long
   private static final long field_138 = 2715322183617658933L;

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.s) org.a.a.a.i.ah
   public static class_133 method_357(SortedMap var0, class_32 var1) {
      return new class_133(var0, var1);
   }

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.aI) org.a.a.a.i.ah
   public static class_133 method_358(SortedMap var0, class_21 var1) {
      return new class_133(var0, var1);
   }

   protected class_133(SortedMap var1, class_32 var2) {
      super(var1, (class_32)var2);
   }

   protected class_133(SortedMap var1, class_21 var2) {
      super(var1, (class_21)var2);
   }

   // $FF: renamed from: a () java.util.SortedMap
   protected SortedMap method_359() {
      return (SortedMap)this.a;
   }

   public Object firstKey() {
      return this.method_359().firstKey();
   }

   public Object lastKey() {
      return this.method_359().lastKey();
   }

   public Comparator comparator() {
      return this.method_359().comparator();
   }

   public SortedMap subMap(Object var1, Object var2) {
      SortedMap var3 = this.method_359().subMap(var1, var2);
      return new class_133(var3, this.b);
   }

   public SortedMap headMap(Object var1) {
      SortedMap var2 = this.method_359().headMap(var1);
      return new class_133(var2, this.b);
   }

   public SortedMap tailMap(Object var1) {
      SortedMap var2 = this.method_359().tailMap(var1);
      return new class_133(var2, this.b);
   }
}
