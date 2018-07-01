package org.a.a.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.e.class_245;
import org.a.a.a.e.class_246;
import org.a.a.a.e.class_247;
import org.a.a.a.e.class_257;
import org.a.a.a.e.class_258;
import org.a.a.a.e.class_266;
import org.a.a.a.e.class_268;
import org.a.a.a.e.class_271;
import org.a.a.a.e.class_276;
import org.a.a.a.e.class_279;
import org.a.a.a.e.class_281;
import org.a.a.a.e.class_282;
import org.a.a.a.e.class_290;
import org.a.a.a.e.class_293;
import org.a.a.a.e.class_297;

// $FF: renamed from: org.a.a.a.aJ
public class class_341 {
   // $FF: renamed from: a () org.a.a.a.aI
   public static class_21 method_849() {
      return class_293.method_689();
   }

   // $FF: renamed from: b () org.a.a.a.aI
   public static class_21 method_850() {
      return class_276.method_647();
   }

   // $FF: renamed from: c () org.a.a.a.aI
   public static class_21 method_851() {
      return class_245.method_600();
   }

   // $FF: renamed from: d () org.a.a.a.aI
   public static class_21 method_852() {
      return class_282.method_657();
   }

   // $FF: renamed from: a (java.lang.Object) org.a.a.a.aI
   public static class_21 method_853(Object var0) {
      return class_276.method_648(var0);
   }

   // $FF: renamed from: a (org.a.a.a.g) org.a.a.a.aI
   public static class_21 method_854(class_34 var0) {
      return class_279.method_650(var0);
   }

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.aI
   public static class_21 method_855(class_1 var0) {
      return class_271.method_638(var0);
   }

   // $FF: renamed from: a (org.a.a.a.s) org.a.a.a.aI
   public static class_21 method_856(class_32 var0) {
      return class_290.method_683(var0);
   }

   // $FF: renamed from: a (org.a.a.a.aI[]) org.a.a.a.aI
   public static class_21 method_857(class_21... var0) {
      return class_281.method_654(var0);
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.aI
   public static class_21 method_858(Collection var0) {
      return class_281.method_655(var0);
   }

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.aI) org.a.a.a.aI
   public static class_21 method_859(class_1 var0, class_21 var1) {
      return class_258.method_614(var0, var1);
   }

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.aI
   public static class_21 method_860(class_1 var0, class_21 var1, class_21 var2) {
      return class_258.method_613(var0, var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.an, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.aI
   public static class_21 method_861(class_1 var0, class_21 var1, class_21 var2) {
      return class_266.method_628(new class_1[]{var0}, new class_21[]{var1}, var2);
   }

   // $FF: renamed from: a (org.a.a.a.an[], org.a.a.a.aI[]) org.a.a.a.aI
   public static class_21 method_862(class_1[] var0, class_21[] var1) {
      return class_266.method_628(var0, var1, (class_21)null);
   }

   // $FF: renamed from: a (org.a.a.a.an[], org.a.a.a.aI[], org.a.a.a.aI) org.a.a.a.aI
   public static class_21 method_863(class_1[] var0, class_21[] var1, class_21 var2) {
      return class_266.method_628(var0, var1, var2);
   }

   // $FF: renamed from: a (java.util.Map) org.a.a.a.aI
   public static class_21 method_864(Map var0) {
      return class_266.method_629(var0);
   }

   // $FF: renamed from: b (java.util.Map) org.a.a.a.aI
   public static class_21 method_865(Map var0) {
      if (var0 == null) {
         throw new NullPointerException("The object and transformer map must not be null");
      } else {
         class_21 var1 = (class_21)var0.remove((Object)null);
         int var2 = var0.size();
         class_21[] var3 = new class_21[var2];
         class_1[] var4 = new class_1[var2];
         int var5 = 0;

         Entry var7;
         for(Iterator var6 = var0.entrySet().iterator(); var6.hasNext(); var3[var5++] = (class_21)var7.getValue()) {
            var7 = (Entry)var6.next();
            var4[var5] = class_297.method_697(var7.getKey());
         }

         return method_863(var4, var3, var1);
      }
   }

   // $FF: renamed from: e () org.a.a.a.aI
   public static class_21 method_866() {
      return class_257.method_610();
   }

   // $FF: renamed from: a (java.lang.Class[], java.lang.Object[]) org.a.a.a.aI
   public static class_21 method_867(Class[] var0, Object[] var1) {
      return class_257.method_611(var0, var1);
   }

   // $FF: renamed from: c (java.util.Map) org.a.a.a.aI
   public static class_21 method_868(Map var0) {
      return class_247.method_604(var0);
   }

   // $FF: renamed from: a (java.lang.String) org.a.a.a.aI
   public static class_21 method_869(String var0) {
      return class_246.method_603(var0, (Class[])null, (Object[])null);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Class[], java.lang.Object[]) org.a.a.a.aI
   public static class_21 method_870(String var0, Class[] var1, Object[] var2) {
      return class_246.method_603(var0, var1, var2);
   }

   // $FF: renamed from: f () org.a.a.a.aI
   public static class_21 method_871() {
      return class_268.method_634();
   }
}
