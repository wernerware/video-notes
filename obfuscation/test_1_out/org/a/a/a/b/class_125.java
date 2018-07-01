package org.a.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import org.a.a.a.i.class_123;

// $FF: renamed from: org.a.a.a.b.r
public class class_125 extends class_123 {
   protected class_125(class_356 var1, SortedMap var2) {
      super(new class_356(var2, var1.b, var1.c));
   }

   public boolean containsValue(Object var1) {
      return this.method_284().a.containsValue(var1);
   }

   public void clear() {
      Iterator var1 = this.keySet().iterator();

      while(var1.hasNext()) {
         var1.next();
         var1.remove();
      }

   }

   public SortedMap headMap(Object var1) {
      return new class_125(this.method_284(), super.headMap(var1));
   }

   public SortedMap tailMap(Object var1) {
      return new class_125(this.method_284(), super.tailMap(var1));
   }

   public SortedMap subMap(Object var1, Object var2) {
      return new class_125(this.method_284(), super.subMap(var1, var2));
   }

   // $FF: renamed from: a () org.a.a.a.b.p
   protected class_356 method_284() {
      return (class_356)super.method_279();
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      return this.method_284().method_19(var1);
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      return this.method_284().method_18(var1);
   }

   // $FF: renamed from: b () java.util.SortedMap
   // $FF: synthetic method
   protected SortedMap method_279() {
      return this.method_284();
   }

   // $FF: renamed from: i () java.util.Map
   // $FF: synthetic method
   protected Map method_258() {
      return this.method_284();
   }
}
