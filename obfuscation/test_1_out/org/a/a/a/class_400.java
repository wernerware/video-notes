package org.a.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.a.a.a.a.class_364;
import org.a.a.a.e.class_296;
import org.a.a.a.h.class_51;
import org.a.a.a.h.class_53;
import org.a.a.a.h.class_55;
import org.a.a.a.h.class_82;
import org.a.a.a.h.class_91;
import org.a.a.a.m.class_426;
import org.a.a.a.m.class_428;

// $FF: renamed from: org.a.a.a.T
public class class_400 {
   // $FF: renamed from: a (java.util.List) java.util.List
   public static List method_1145(List var0) {
      return var0 == null ? Collections.emptyList() : var0;
   }

   // $FF: renamed from: a (java.util.List, java.util.List) java.util.List
   public static List method_1146(List var0, List var1) {
      return var0 == null ? var1 : var0;
   }

   // $FF: renamed from: b (java.util.List, java.util.List) java.util.List
   public static List method_1147(List var0, List var1) {
      ArrayList var2 = new ArrayList();
      List var3 = var0;
      List var4 = var1;
      if (var0.size() > var1.size()) {
         var3 = var1;
         var4 = var0;
      }

      HashSet var5 = new HashSet(var3);
      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         if (var5.contains(var7)) {
            var2.add(var7);
            var5.remove(var7);
         }
      }

      return var2;
   }

   // $FF: renamed from: c (java.util.List, java.util.List) java.util.List
   public static List method_1148(List var0, List var1) {
      ArrayList var2 = new ArrayList();
      class_364 var3 = new class_364(var1);
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if (!var3.b(var5, 1)) {
            var2.add(var5);
         }
      }

      return var2;
   }

   // $FF: renamed from: d (java.util.List, java.util.List) java.util.List
   public static List method_1149(List var0, List var1) {
      return method_1148(method_1150(var0, var1), method_1147(var0, var1));
   }

   // $FF: renamed from: e (java.util.List, java.util.List) java.util.List
   public static List method_1150(List var0, List var1) {
      ArrayList var2 = new ArrayList(var0);
      var2.addAll(var1);
      return var2;
   }

   // $FF: renamed from: a (java.util.Collection, org.a.a.a.an) java.util.List
   public static List method_1151(Collection var0, class_1 var1) {
      return (List)class_415.method_1353(var0, var1, new ArrayList(var0.size()));
   }

   // $FF: renamed from: b (java.util.Collection, org.a.a.a.an) java.util.List
   public static List method_1152(Collection var0, class_1 var1) {
      return (List)class_415.method_1356(var0, var1, new ArrayList(var0.size()));
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Collection) boolean
   public static boolean method_1153(Collection var0, Collection var1) {
      if (var0 == var1) {
         return true;
      } else if (var0 != null && var1 != null && var0.size() == var1.size()) {
         Iterator var2 = var0.iterator();
         Iterator var3 = var1.iterator();
         Object var4 = null;
         Object var5 = null;

         while(true) {
            if (var2.hasNext() && var3.hasNext()) {
               var4 = var2.next();
               var5 = var3.next();
               if (var4 == null) {
                  if (var5 == null) {
                     continue;
                  }
               } else if (var4.equals(var5)) {
                  continue;
               }

               return false;
            }

            return !var2.hasNext() && !var3.hasNext();
         }
      } else {
         return false;
      }
   }

   // $FF: renamed from: a (java.util.Collection) int
   public static int method_1154(Collection var0) {
      if (var0 == null) {
         return 0;
      } else {
         int var1 = 1;

         Object var3;
         for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = 31 * var1 + (var3 == null ? 0 : var3.hashCode())) {
            var3 = var2.next();
         }

         return var1;
      }
   }

   // $FF: renamed from: b (java.util.Collection, java.util.Collection) java.util.List
   public static List method_1155(Collection var0, Collection var1) {
      ArrayList var2 = new ArrayList(Math.min(var0.size(), var1.size()));
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if (var1.contains(var4)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   // $FF: renamed from: c (java.util.Collection, java.util.Collection) java.util.List
   public static List method_1156(Collection var0, Collection var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if (!var1.contains(var4)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   // $FF: renamed from: b (java.util.List) java.util.List
   public static List method_1157(List var0) {
      return Collections.synchronizedList(var0);
   }

   // $FF: renamed from: c (java.util.List) java.util.List
   public static List method_1158(List var0) {
      return class_51.method_108(var0);
   }

   // $FF: renamed from: a (java.util.List, org.a.a.a.an) java.util.List
   public static List method_1159(List var0, class_1 var1) {
      return class_82.method_172(var0, var1);
   }

   // $FF: renamed from: a (java.util.List, org.a.a.a.aI) java.util.List
   public static List method_1160(List var0, class_21 var1) {
      return class_91.method_194(var0, var1);
   }

   // $FF: renamed from: a (java.util.List, org.a.a.a.s) java.util.List
   public static List method_1161(List var0, class_32 var1) {
      return class_53.method_110(var0, var1);
   }

   // $FF: renamed from: d (java.util.List) java.util.List
   public static List method_1162(List var0) {
      return class_55.method_114(var0);
   }

   // $FF: renamed from: b (java.util.List, org.a.a.a.an) int
   public static int method_1163(List var0, class_1 var1) {
      if (var0 != null && var1 != null) {
         for(int var2 = 0; var2 < var0.size(); ++var2) {
            Object var3 = var0.get(var2);
            if (var1.method_3(var3)) {
               return var2;
            }
         }
      }

      return -1;
   }

   // $FF: renamed from: f (java.util.List, java.util.List) java.util.List
   public static List method_1164(List var0, List var1) {
      return method_1165(var0, var1, class_296.method_695());
   }

   // $FF: renamed from: a (java.util.List, java.util.List, org.a.a.a.r) java.util.List
   public static List method_1165(List var0, List var1, class_33 var2) {
      if (var0 != null && var1 != null) {
         if (var2 == null) {
            throw new NullPointerException("Equator must not be null");
         } else {
            class_428 var3 = new class_428(var0, var1, var2);
            class_426 var4 = var3.method_1420();
            class_419 var5 = new class_419();
            var4.method_1417(var5);
            return var5.method_1410();
         }
      } else {
         throw new NullPointerException("List must not be null");
      }
   }

   // $FF: renamed from: a (java.lang.CharSequence, java.lang.CharSequence) java.lang.String
   public static String method_1166(CharSequence var0, CharSequence var1) {
      if (var0 != null && var1 != null) {
         List var2 = method_1164(new class_420(var0), new class_420(var1));
         StringBuilder var3 = new StringBuilder();
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            Character var5 = (Character)var4.next();
            var3.append(var5);
         }

         return var3.toString();
      } else {
         throw new NullPointerException("CharSequence must not be null");
      }
   }

   // $FF: renamed from: a (java.util.List, int) java.util.List
   public static List method_1167(List var0, int var1) {
      if (var0 == null) {
         throw new NullPointerException("List must not be null");
      } else if (var1 <= 0) {
         throw new IllegalArgumentException("Size must be greater than 0");
      } else {
         return new class_418(var0, var1, (class_421)null);
      }
   }
}
