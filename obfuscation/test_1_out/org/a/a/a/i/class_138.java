package org.a.a.a.i;

import java.util.Comparator;
import java.util.SortedMap;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;

// $FF: renamed from: org.a.a.a.i.aF
public class class_138 extends class_137 implements SortedMap {
   // $FF: renamed from: d long
   private static final long field_146 = 3359846175935304332L;

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.an, org.a.a.a.an) org.a.a.a.i.aF
   public static class_138 method_376(SortedMap var0, APPARENTLY_REALLY_IMPORTANT var1, APPARENTLY_REALLY_IMPORTANT var2) {
      return new class_138(var0, var1, var2);
   }

   protected class_138(SortedMap var1, APPARENTLY_REALLY_IMPORTANT var2, APPARENTLY_REALLY_IMPORTANT var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: b () java.util.SortedMap
   protected SortedMap method_377() {
      return (SortedMap)this.a;
   }

   public Object firstKey() {
      return this.method_377().firstKey();
   }

   public Object lastKey() {
      return this.method_377().lastKey();
   }

   public Comparator comparator() {
      return this.method_377().comparator();
   }

   public SortedMap subMap(Object var1, Object var2) {
      SortedMap var3 = this.method_377().subMap(var1, var2);
      return new class_138(var3, this.b, this.c);
   }

   public SortedMap headMap(Object var1) {
      SortedMap var2 = this.method_377().headMap(var1);
      return new class_138(var2, this.b, this.c);
   }

   public SortedMap tailMap(Object var1) {
      SortedMap var2 = this.method_377().tailMap(var1);
      return new class_138(var2, this.b, this.c);
   }
}
