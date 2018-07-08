package org.a.a.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.e.class_243;
import org.a.a.a.e.class_246;
import org.a.a.a.e.class_264;
import org.a.a.a.e.class_284;
import org.a.a.a.e.class_287;
import org.a.a.a.e.class_288;
import org.a.a.a.e.class_294;
import org.a.a.a.e.class_297;
import org.a.a.a.e.class_343;
import org.a.a.a.e.class_347;

// $FF: renamed from: org.a.a.a.h
public class class_411 {
   // $FF: renamed from: a () org.a.a.a.g
   public static class_34 method_1307() {
      return class_294.method_691();
   }

   // $FF: renamed from: b () org.a.a.a.g
   public static class_34 method_1308() {
      return class_243.method_597();
   }

   // $FF: renamed from: a (org.a.a.a.aI) org.a.a.a.g
   public static class_34 method_1309(class_21 var0) {
      return class_347.method_881(var0);
   }

   // $FF: renamed from: a (int, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_1310(int var0, class_34 var1) {
      return class_288.method_670(var0, var1);
   }

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_1311(APPARENTLY_REALLY_IMPORTANT var0, class_34 var1) {
      return class_343.method_872(var0, var1, false);
   }

   // $FF: renamed from: a (org.a.a.a.g, org.a.a.a.an) org.a.a.a.g
   public static class_34 method_1312(class_34 var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return class_343.method_872(var1, var0, true);
   }

   // $FF: renamed from: a (java.lang.String) org.a.a.a.g
   public static class_34 method_1313(String var0) {
      return method_1309(class_246.method_602(var0));
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Class[], java.lang.Object[]) org.a.a.a.g
   public static class_34 method_1314(String var0, Class[] var1, Object[] var2) {
      return method_1309(class_246.method_603(var0, var1, var2));
   }

   // $FF: renamed from: a (org.a.a.a.g[]) org.a.a.a.g
   public static class_34 method_1315(class_34... var0) {
      return class_284.method_659(var0);
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.g
   public static class_34 method_1316(Collection var0) {
      return class_284.method_660(var0);
   }

   // $FF: renamed from: b (org.a.a.a.an, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_1317(APPARENTLY_REALLY_IMPORTANT var0, class_34 var1) {
      return class_287.method_665(var0, var1);
   }

   // $FF: renamed from: a (org.a.a.a.an, org.a.a.a.g, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_1318(APPARENTLY_REALLY_IMPORTANT var0, class_34 var1, class_34 var2) {
      return class_287.method_666(var0, var1, var2);
   }

   // $FF: renamed from: a (org.a.a.a.an[], org.a.a.a.g[]) org.a.a.a.g
   public static class_34 method_1319(APPARENTLY_REALLY_IMPORTANT[] var0, class_34[] var1) {
      return class_264.method_623(var0, var1, (class_34)null);
   }

   // $FF: renamed from: a (org.a.a.a.an[], org.a.a.a.g[], org.a.a.a.g) org.a.a.a.g
   public static class_34 method_1320(APPARENTLY_REALLY_IMPORTANT[] var0, class_34[] var1, class_34 var2) {
      return class_264.method_623(var0, var1, var2);
   }

   // $FF: renamed from: a (java.util.Map) org.a.a.a.g
   public static class_34 method_1321(Map var0) {
      return class_264.method_624(var0);
   }

   // $FF: renamed from: b (java.util.Map) org.a.a.a.g
   public static class_34 method_1322(Map var0) {
      if (var0 == null) {
         throw new NullPointerException("The object and closure map must not be null");
      } else {
         class_34 var1 = (class_34)var0.remove((Object)null);
         int var2 = var0.size();
         class_34[] var3 = new class_34[var2];
         APPARENTLY_REALLY_IMPORTANT[] var4 = new APPARENTLY_REALLY_IMPORTANT[var2];
         int var5 = 0;

         for(Iterator var6 = var0.entrySet().iterator(); var6.hasNext(); ++var5) {
            Entry var7 = (Entry)var6.next();
            var4[var5] = class_297.method_697(var7.getKey());
            var3[var5] = (class_34)var7.getValue();
         }

         return method_1320(var4, var3, var1);
      }
   }
}
