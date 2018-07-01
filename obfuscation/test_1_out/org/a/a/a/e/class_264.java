package org.a.a.a.e;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_1;
import org.a.a.a.class_34;

// $FF: renamed from: org.a.a.a.e.Y
public class class_264 implements Serializable, class_34 {
   // $FF: renamed from: a long
   private static final long field_391 = 3518477308466486130L;
   // $FF: renamed from: b org.a.a.a.an[]
   private final class_1[] field_392;
   // $FF: renamed from: c org.a.a.a.g[]
   private final class_34[] field_393;
   // $FF: renamed from: d org.a.a.a.g
   private final class_34 field_394;

   // $FF: renamed from: a (org.a.a.a.an[], org.a.a.a.g[], org.a.a.a.g) org.a.a.a.g
   public static class_34 method_623(class_1[] var0, class_34[] var1, class_34 var2) {
      class_289.method_675(var0);
      class_289.method_678(var1);
      if (var0.length != var1.length) {
         throw new IllegalArgumentException("The predicate and closure arrays must be the same size");
      } else if (var0.length == 0) {
         return var2 == null ? class_243.method_597() : var2;
      } else {
         return new class_264(var0, var1, var2);
      }
   }

   // $FF: renamed from: a (java.util.Map) org.a.a.a.g
   public static class_34 method_624(Map var0) {
      if (var0 == null) {
         throw new NullPointerException("The predicate and closure map must not be null");
      } else {
         class_34 var1 = (class_34)var0.remove((Object)null);
         int var2 = var0.size();
         if (var2 == 0) {
            return var1 == null ? class_243.method_597() : var1;
         } else {
            class_34[] var3 = new class_34[var2];
            class_1[] var4 = new class_1[var2];
            int var5 = 0;

            for(Iterator var6 = var0.entrySet().iterator(); var6.hasNext(); ++var5) {
               Entry var7 = (Entry)var6.next();
               var4[var5] = (class_1)var7.getKey();
               var3[var5] = (class_34)var7.getValue();
            }

            return new class_264(false, var4, var3, var1);
         }
      }
   }

   private class_264(boolean var1, class_1[] var2, class_34[] var3, class_34 var4) {
      this.field_392 = var1 ? class_289.method_673(var2) : var2;
      this.field_393 = var1 ? class_289.method_677(var3) : var3;
      this.field_394 = var4 == null ? class_243.method_597() : var4;
   }

   public class_264(class_1[] var1, class_34[] var2, class_34 var3) {
      this(true, var1, var2, var3);
   }

   // $FF: renamed from: a (java.lang.Object) void
   public void method_70(Object var1) {
      for(int var2 = 0; var2 < this.field_392.length; ++var2) {
         if (this.field_392[var2].method_3(var1)) {
            this.field_393[var2].method_70(var1);
            return;
         }
      }

      this.field_394.method_70(var1);
   }

   // $FF: renamed from: a () org.a.a.a.an[]
   public class_1[] method_625() {
      return class_289.method_673(this.field_392);
   }

   // $FF: renamed from: b () org.a.a.a.g[]
   public class_34[] method_626() {
      return class_289.method_677(this.field_393);
   }

   // $FF: renamed from: c () org.a.a.a.g
   public class_34 method_627() {
      return this.field_394;
   }
}
