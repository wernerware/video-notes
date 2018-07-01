package org.a.a.a.i;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.i.aX
public class class_136 extends class_135 implements SortedMap {
   // $FF: renamed from: d long
   private static final long field_142 = -8751771676410385778L;

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.i.aX
   public static class_136 method_369(SortedMap var0, class_21 var1, class_21 var2) {
      return new class_136(var0, var1, var2);
   }

   // $FF: renamed from: b (java.util.SortedMap, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.i.aX
   public static class_136 method_370(SortedMap var0, class_21 var1, class_21 var2) {
      class_136 var3 = new class_136(var0, var1, var2);
      if (var0.size() > 0) {
         Map var4 = var3.a(var0);
         var3.clear();
         var3.i().putAll(var4);
      }

      return var3;
   }

   protected class_136(SortedMap var1, class_21 var2, class_21 var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: b () java.util.SortedMap
   protected SortedMap method_371() {
      return (SortedMap)this.a;
   }

   public Object firstKey() {
      return this.method_371().firstKey();
   }

   public Object lastKey() {
      return this.method_371().lastKey();
   }

   public Comparator comparator() {
      return this.method_371().comparator();
   }

   public SortedMap subMap(Object var1, Object var2) {
      SortedMap var3 = this.method_371().subMap(var1, var2);
      return new class_136(var3, this.b, this.c);
   }

   public SortedMap headMap(Object var1) {
      SortedMap var2 = this.method_371().headMap(var1);
      return new class_136(var2, this.b, this.c);
   }

   public SortedMap tailMap(Object var1) {
      SortedMap var2 = this.method_371().tailMap(var1);
      return new class_136(var2, this.b, this.c);
   }
}
