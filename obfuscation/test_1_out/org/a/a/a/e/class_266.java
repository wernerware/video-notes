package org.a.a.a.e;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.e.Z
public class class_266 implements Serializable, class_21 {
   // $FF: renamed from: a long
   private static final long field_396 = -6404460890903469332L;
   // $FF: renamed from: b org.a.a.a.an[]
   private final APPARENTLY_REALLY_IMPORTANT[] field_397;
   // $FF: renamed from: c org.a.a.a.aI[]
   private final class_21[] field_398;
   // $FF: renamed from: d org.a.a.a.aI
   private final class_21 field_399;

   // $FF: renamed from: a (org.a.a.a.an[], org.a.a.a.aI[], org.a.a.a.aI) org.a.a.a.aI
   public static class_21 method_628(APPARENTLY_REALLY_IMPORTANT[] var0, class_21[] var1, class_21 var2) {
      class_289.method_675(var0);
      class_289.method_681(var1);
      if (var0.length != var1.length) {
         throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
      } else if (var0.length == 0) {
         return var2 == null ? class_276.method_647() : var2;
      } else {
         return new class_266(var0, var1, var2);
      }
   }

   // $FF: renamed from: a (java.util.Map) org.a.a.a.aI
   public static class_21 method_629(Map var0) {
      if (var0 == null) {
         throw new NullPointerException("The predicate and transformer map must not be null");
      } else if (var0.size() == 0) {
         return class_276.method_647();
      } else {
         class_21 var1 = (class_21)var0.remove((Object)null);
         int var2 = var0.size();
         if (var2 == 0) {
            return var1 == null ? class_276.method_647() : var1;
         } else {
            class_21[] var3 = new class_21[var2];
            APPARENTLY_REALLY_IMPORTANT[] var4 = new APPARENTLY_REALLY_IMPORTANT[var2];
            int var5 = 0;

            for(Iterator var6 = var0.entrySet().iterator(); var6.hasNext(); ++var5) {
               Entry var7 = (Entry)var6.next();
               var4[var5] = (APPARENTLY_REALLY_IMPORTANT)var7.getKey();
               var3[var5] = (class_21)var7.getValue();
            }

            return new class_266(false, var4, var3, var1);
         }
      }
   }

   private class_266(boolean var1, APPARENTLY_REALLY_IMPORTANT[] var2, class_21[] var3, class_21 var4) {
      this.field_397 = var1 ? class_289.method_673(var2) : var2;
      this.field_398 = var1 ? class_289.method_680(var3) : var3;
      this.field_399 = var4 == null ? class_276.method_647() : var4;
   }

   public class_266(APPARENTLY_REALLY_IMPORTANT[] var1, class_21[] var2, class_21 var3) {
      this(true, var1, var2, var3);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      for(int var2 = 0; var2 < this.field_397.length; ++var2) {
         if (this.field_397[var2].method_3(var1)) {
            return this.field_398[var2].method_25(var1);
         }
      }

      return this.field_399.method_25(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public APPARENTLY_REALLY_IMPORTANT[] method_630() {
      return class_289.method_673(this.field_397);
   }

   // $FF: renamed from: b () org.a.a.a.aI[]
   public class_21[] method_631() {
      return class_289.method_680(this.field_398);
   }

   // $FF: renamed from: c () org.a.a.a.aI
   public class_21 method_632() {
      return this.field_399;
   }
}
