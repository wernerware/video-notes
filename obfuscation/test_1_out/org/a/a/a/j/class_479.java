package org.a.a.a.j;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_21;
import org.a.a.a.class_24;
import org.a.a.a.class_384;
import org.a.a.a.class_415;

// $FF: renamed from: org.a.a.a.j.y
public class class_479 extends class_477 {
   // $FF: renamed from: a long
   private static final long field_872 = 20150612L;
   // $FF: renamed from: b org.a.a.a.aI
   private final class_21 field_873;
   // $FF: renamed from: c org.a.a.a.aI
   private final class_21 field_874;

   // $FF: renamed from: a (org.a.a.a.ai, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.j.y
   public static class_479 method_1574(class_24 var0, class_21 var1, class_21 var2) {
      return new class_479(var0, var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.ai, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.j.y
   public static class_479 method_1575(class_24 var0, class_21 var1, class_21 var2) {
      class_479 var3 = new class_479(var0, var1, var2);
      if (!var0.method_34()) {
         class_471 var4 = new class_471(var0);
         var3.c();
         var3.method_42(var4);
      }

      return var3;
   }

   protected class_479(class_24 var1, class_21 var2, class_21 var3) {
      super(var1);
      this.field_873 = var2;
      this.field_874 = var3;
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_1576(Object var1) {
      return this.field_873 == null ? var1 : this.field_873.method_25(var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   protected Object method_1577(Object var1) {
      return this.field_874 == null ? var1 : this.field_874.method_25(var1);
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   public boolean method_39(Object var1, Object var2) {
      return this.j().method_39(this.method_1576(var1), this.method_1577(var2));
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Iterable) boolean
   public boolean method_40(Object var1, Iterable var2) {
      if (var2 == null) {
         throw new NullPointerException("Values must not be null.");
      } else {
         class_384 var3 = class_384.method_1110(var2).method_1121(this.field_874);
         Iterator var4 = var3.iterator();
         return var4.hasNext() && class_415.method_1363(this.j().method_38(this.method_1576(var1)), var4);
      }
   }

   // $FF: renamed from: a (java.util.Map) boolean
   public boolean method_41(Map var1) {
      if (var1 == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         boolean var2 = false;

         Entry var4;
         for(Iterator var3 = var1.entrySet().iterator(); var3.hasNext(); var2 |= this.method_39(var4.getKey(), var4.getValue())) {
            var4 = (Entry)var3.next();
         }

         return var2;
      }
   }

   // $FF: renamed from: a (org.a.a.a.ai) boolean
   public boolean method_42(class_24 var1) {
      if (var1 == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         boolean var2 = false;

         Entry var4;
         for(Iterator var3 = var1.method_46().iterator(); var3.hasNext(); var2 |= this.method_39(var4.getKey(), var4.getValue())) {
            var4 = (Entry)var3.next();
         }

         return var2;
      }
   }
}
