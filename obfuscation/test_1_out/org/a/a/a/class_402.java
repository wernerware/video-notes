package org.a.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.a.a.a.e.class_297;

// $FF: renamed from: org.a.a.a.A
public class class_402 {
   // $FF: renamed from: a org.a.a.a.u
   static final class_384 field_709 = new class_385();

   // $FF: renamed from: a () java.lang.Iterable
   public static Iterable method_1236() {
      return field_709;
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1237(Iterable var0, Iterable var1) {
      return method_1240(var0, var1);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable, java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1238(Iterable var0, Iterable var1, Iterable var2) {
      return method_1240(var0, var1, var2);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable, java.lang.Iterable, java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1239(Iterable var0, Iterable var1, Iterable var2, Iterable var3) {
      return method_1240(var0, var1, var2, var3);
   }

   // $FF: renamed from: a (java.lang.Iterable[]) java.lang.Iterable
   public static Iterable method_1240(Iterable... var0) {
      method_1275(var0);
      return new class_394(var0);
   }

   // $FF: renamed from: b (java.lang.Iterable, java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1241(Iterable var0, Iterable var1) {
      method_1275(var0, var1);
      return new class_388(var0, var1);
   }

   // $FF: renamed from: a (java.util.Comparator, java.lang.Iterable, java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1242(Comparator var0, Iterable var1, Iterable var2) {
      method_1275(var1, var2);
      return new class_389(var0, var1, var2);
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.an) java.lang.Iterable
   public static Iterable method_1243(Iterable var0, APPARENTLY_REALLY_IMPORTANT var1) {
      method_1274(var0);
      if (var1 == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         return new class_390(var0, var1);
      }
   }

   // $FF: renamed from: a (java.lang.Iterable, long) java.lang.Iterable
   public static Iterable method_1244(Iterable var0, long var1) {
      method_1274(var0);
      if (var1 < 0L) {
         throw new IllegalArgumentException("MaxSize parameter must not be negative.");
      } else {
         return new class_391(var0, var1);
      }
   }

   // $FF: renamed from: a (java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1245(Iterable var0) {
      method_1274(var0);
      return new class_396(var0);
   }

   // $FF: renamed from: b (java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1246(Iterable var0) {
      method_1274(var0);
      return new class_397(var0);
   }

   // $FF: renamed from: b (java.lang.Iterable, long) java.lang.Iterable
   public static Iterable method_1247(Iterable var0, long var1) {
      method_1274(var0);
      if (var1 < 0L) {
         throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
      } else {
         return new class_398(var0, var1);
      }
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.aI) java.lang.Iterable
   public static Iterable method_1248(Iterable var0, class_21 var1) {
      method_1274(var0);
      if (var1 == null) {
         throw new NullPointerException("Transformer must not be null.");
      } else {
         return new class_386(var0, var1);
      }
   }

   // $FF: renamed from: c (java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1249(Iterable var0) {
      method_1274(var0);
      return new class_387(var0);
   }

   // $FF: renamed from: d (java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1250(Iterable var0) {
      method_1274(var0);
      return (Iterable)(var0 instanceof class_395 ? var0 : new class_395(var0));
   }

   // $FF: renamed from: c (java.lang.Iterable, java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1251(Iterable var0, Iterable var1) {
      method_1274(var0);
      method_1274(var1);
      return new class_392(var0, var1);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable[]) java.lang.Iterable
   public static Iterable method_1252(Iterable var0, Iterable... var1) {
      method_1274(var0);
      method_1275(var1);
      return new class_393(var1, var0);
   }

   // $FF: renamed from: e (java.lang.Iterable) java.lang.Iterable
   public static Iterable method_1253(Iterable var0) {
      return var0 == null ? method_1236() : var0;
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.g) void
   public static void method_1254(Iterable var0, class_34 var1) {
      class_401.method_1223(method_1276(var0), var1);
   }

   // $FF: renamed from: b (java.lang.Iterable, org.a.a.a.g) java.lang.Object
   public static Object method_1255(Iterable var0, class_34 var1) {
      return class_401.method_1224(method_1276(var0), var1);
   }

   // $FF: renamed from: b (java.lang.Iterable, org.a.a.a.an) java.lang.Object
   public static Object method_1256(Iterable var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return class_401.method_1225(method_1276(var0), var1);
   }

   // $FF: renamed from: c (java.lang.Iterable, org.a.a.a.an) int
   public static int method_1257(Iterable var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return class_401.method_1226(method_1276(var0), var1);
   }

   // $FF: renamed from: d (java.lang.Iterable, org.a.a.a.an) boolean
   public static boolean method_1258(Iterable var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return class_401.method_1228(method_1276(var0), var1);
   }

   // $FF: renamed from: e (java.lang.Iterable, org.a.a.a.an) boolean
   public static boolean method_1259(Iterable var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return class_401.method_1227(method_1276(var0), var1);
   }

   // $FF: renamed from: f (java.lang.Iterable, org.a.a.a.an) long
   public static long method_1260(Iterable var0, APPARENTLY_REALLY_IMPORTANT var1) {
      if (var1 == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         return (long)method_1266(method_1243(method_1253(var0), var1));
      }
   }

   // $FF: renamed from: f (java.lang.Iterable) boolean
   public static boolean method_1261(Iterable var0) {
      return var0 instanceof Collection ? ((Collection)var0).isEmpty() : class_401.method_1229(method_1276(var0));
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Object) boolean
   public static boolean method_1262(Iterable var0, Object var1) {
      return var0 instanceof Collection ? ((Collection)var0).contains(var1) : class_401.method_1230(method_1276(var0), var1);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Object, org.a.a.a.r) boolean
   public static boolean method_1263(Iterable var0, Object var1, class_33 var2) {
      if (var2 == null) {
         throw new NullPointerException("Equator must not be null.");
      } else {
         return method_1259(var0, class_297.method_698(var1, var2));
      }
   }

   // $FF: renamed from: b (java.lang.Iterable, java.lang.Object) int
   public static int method_1264(Iterable var0, Object var1) {
      if (var0 instanceof Set) {
         return ((Set)var0).contains(var1) ? 1 : 0;
      } else {
         return var0 instanceof class_22 ? ((class_22)var0).method_26(var1) : method_1266(method_1243(method_1253(var0), class_297.method_697(var1)));
      }
   }

   // $FF: renamed from: a (java.lang.Iterable, int) java.lang.Object
   public static Object method_1265(Iterable var0, int var1) {
      class_415.method_1367(var1);
      return var0 instanceof List ? ((List)var0).get(var1) : class_401.method_1231(method_1276(var0), var1);
   }

   // $FF: renamed from: g (java.lang.Iterable) int
   public static int method_1266(Iterable var0) {
      return var0 instanceof Collection ? ((Collection)var0).size() : class_401.method_1232(method_1276(var0));
   }

   // $FF: renamed from: g (java.lang.Iterable, org.a.a.a.an) java.util.List
   public static List method_1267(Iterable var0, APPARENTLY_REALLY_IMPORTANT var1) {
      if (var1 == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         class_32 var2 = class_409.method_1302(ArrayList.class);
         APPARENTLY_REALLY_IMPORTANT[] var3 = new APPARENTLY_REALLY_IMPORTANT[]{var1};
         return method_1269(var0, var2, var3);
      }
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.an[]) java.util.List
   public static List method_1268(Iterable var0, APPARENTLY_REALLY_IMPORTANT... var1) {
      class_32 var2 = class_409.method_1302(ArrayList.class);
      return method_1269(var0, var2, var1);
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.s, org.a.a.a.an[]) java.util.List
   public static List method_1269(Iterable var0, class_32 var1, APPARENTLY_REALLY_IMPORTANT... var2) {
      if (var0 == null) {
         Iterable var12 = method_1236();
         return method_1269(var12, var1, var2);
      } else if (var2 == null) {
         throw new NullPointerException("Predicates must not be null.");
      } else {
         APPARENTLY_REALLY_IMPORTANT[] var3 = var2;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            APPARENTLY_REALLY_IMPORTANT var6 = var3[var5];
            if (var6 == null) {
               throw new NullPointerException("Predicate must not be null.");
            }
         }

         if (var2.length < 1) {
            Collection var11 = (Collection)var1.method_67();
            class_415.method_1362(var11, var0);
            return Collections.singletonList(var11);
         } else {
            int var10 = var2.length;
            var4 = var10 + 1;
            ArrayList var13 = new ArrayList(var4);

            for(int var14 = 0; var14 < var4; ++var14) {
               var13.add(var1.method_67());
            }

            Iterator var15 = var0.iterator();

            while(var15.hasNext()) {
               Object var7 = var15.next();
               boolean var8 = false;

               for(int var9 = 0; var9 < var10; ++var9) {
                  if (var2[var9].method_3(var7)) {
                     ((Collection)var13.get(var9)).add(var7);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  ((Collection)var13.get(var10)).add(var7);
               }
            }

            return var13;
         }
      }
   }

   // $FF: renamed from: h (java.lang.Iterable) java.util.List
   public static List method_1270(Iterable var0) {
      return class_401.method_1220(method_1276(var0));
   }

   // $FF: renamed from: i (java.lang.Iterable) java.lang.String
   public static String method_1271(Iterable var0) {
      return class_401.method_1233(method_1276(var0));
   }

   // $FF: renamed from: b (java.lang.Iterable, org.a.a.a.aI) java.lang.String
   public static String method_1272(Iterable var0, class_21 var1) {
      if (var1 == null) {
         throw new NullPointerException("Transformer must not be null.");
      } else {
         return class_401.method_1234(method_1276(var0), var1);
      }
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.aI, java.lang.String, java.lang.String, java.lang.String) java.lang.String
   public static String method_1273(Iterable var0, class_21 var1, String var2, String var3, String var4) {
      return class_401.method_1235(method_1276(var0), var1, var2, var3, var4);
   }

   // $FF: renamed from: j (java.lang.Iterable) void
   static void method_1274(Iterable var0) {
      if (var0 == null) {
         throw new NullPointerException("Iterable must not be null.");
      }
   }

   // $FF: renamed from: b (java.lang.Iterable[]) void
   static void method_1275(Iterable... var0) {
      if (var0 == null) {
         throw new NullPointerException("Iterables must not be null.");
      } else {
         Iterable[] var1 = var0;
         int var2 = var0.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            Iterable var4 = var1[var3];
            method_1274(var4);
         }

      }
   }

   // $FF: renamed from: l (java.lang.Iterable) java.util.Iterator
   private static Iterator method_1276(Iterable var0) {
      return (Iterator)(var0 != null ? var0.iterator() : class_401.method_1168());
   }

   // $FF: renamed from: k (java.lang.Iterable) java.util.Iterator
   // $FF: synthetic method
   static Iterator method_1277(Iterable var0) {
      return method_1276(var0);
   }
}
