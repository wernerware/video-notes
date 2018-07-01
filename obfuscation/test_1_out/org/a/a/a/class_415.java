package org.a.a.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.a.class_364;
import org.a.a.a.c.class_100;
import org.a.a.a.c.class_81;
import org.a.a.a.c.class_90;
import org.a.a.a.c.class_98;
import org.a.a.a.c.class_99;
import org.a.a.a.e.class_345;
import org.a.a.a.f.class_169;
import org.a.a.a.f.class_449;

// $FF: renamed from: org.a.a.a.i
public class class_415 {
   // $FF: renamed from: a java.util.Collection
   public static final Collection field_723 = class_98.method_216(new ArrayList());

   // $FF: renamed from: a () java.util.Collection
   public static Collection method_1326() {
      return field_723;
   }

   // $FF: renamed from: a (java.util.Collection) java.util.Collection
   public static Collection method_1327(Collection var0) {
      return var0 == null ? field_723 : var0;
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable) java.util.Collection
   public static Collection method_1328(Iterable var0, Iterable var1) {
      class_407 var2 = new class_407(var0, var1);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.method_1295(var4, var2.a(var4));
      }

      return var2.method_1296();
   }

   // $FF: renamed from: b (java.lang.Iterable, java.lang.Iterable) java.util.Collection
   public static Collection method_1329(Iterable var0, Iterable var1) {
      class_407 var2 = new class_407(var0, var1);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.method_1295(var4, var2.b(var4));
      }

      return var2.method_1296();
   }

   // $FF: renamed from: c (java.lang.Iterable, java.lang.Iterable) java.util.Collection
   public static Collection method_1330(Iterable var0, Iterable var1) {
      class_407 var2 = new class_407(var0, var1);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.method_1295(var4, var2.a(var4) - var2.b(var4));
      }

      return var2.method_1296();
   }

   // $FF: renamed from: d (java.lang.Iterable, java.lang.Iterable) java.util.Collection
   public static Collection method_1331(Iterable var0, Iterable var1) {
      class_1 var2 = class_345.method_877();
      return method_1332(var0, var1, var2);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable, org.a.a.a.an) java.util.Collection
   public static Collection method_1332(Iterable var0, Iterable var1, class_1 var2) {
      ArrayList var3 = new ArrayList();
      class_364 var4 = new class_364();
      Iterator var5 = var1.iterator();

      Object var6;
      while(var5.hasNext()) {
         var6 = var5.next();
         if (var2.method_3(var6)) {
            var4.add(var6);
         }
      }

      var5 = var0.iterator();

      while(var5.hasNext()) {
         var6 = var5.next();
         if (!var4.b(var6, 1)) {
            var3.add(var6);
         }
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Collection) boolean
   public static boolean method_1333(Collection var0, Collection var1) {
      if (var1.isEmpty()) {
         return true;
      } else {
         Iterator var2 = var0.iterator();
         HashSet var3 = new HashSet();
         Iterator var4 = var1.iterator();

         boolean var6;
         label43:
         do {
            Object var5;
            do {
               if (!var4.hasNext()) {
                  return true;
               }

               var5 = var4.next();
            } while(var3.contains(var5));

            var6 = false;

            while(true) {
               if (!var2.hasNext()) {
                  continue label43;
               }

               Object var7 = var2.next();
               var3.add(var7);
               if (var5 == null) {
                  if (var7 == null) {
                     break;
                  }
               } else if (var5.equals(var7)) {
                  break;
               }
            }

            var6 = true;
         } while(var6);

         return false;
      }
   }

   // $FF: renamed from: b (java.util.Collection, java.util.Collection) boolean
   public static boolean method_1334(Collection var0, Collection var1) {
      Iterator var2;
      Object var3;
      if (var0.size() < var1.size()) {
         var2 = var0.iterator();

         while(var2.hasNext()) {
            var3 = var2.next();
            if (var1.contains(var3)) {
               return true;
            }
         }
      } else {
         var2 = var1.iterator();

         while(var2.hasNext()) {
            var3 = var2.next();
            if (var0.contains(var3)) {
               return true;
            }
         }
      }

      return false;
   }

   // $FF: renamed from: a (java.lang.Iterable) java.util.Map
   public static Map method_1335(Iterable var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         Integer var4 = (Integer)var1.get(var3);
         if (var4 == null) {
            var1.put(var3, 1);
         } else {
            var1.put(var3, var4 + 1);
         }
      }

      return var1;
   }

   // $FF: renamed from: c (java.util.Collection, java.util.Collection) boolean
   public static boolean method_1336(Collection var0, Collection var1) {
      class_406 var2 = new class_406(var0, var1);
      Iterator var3 = var0.iterator();

      Object var4;
      do {
         if (!var3.hasNext()) {
            return true;
         }

         var4 = var3.next();
      } while(var2.method_1292(var4) <= var2.method_1293(var4));

      return false;
   }

   // $FF: renamed from: d (java.util.Collection, java.util.Collection) boolean
   public static boolean method_1337(Collection var0, Collection var1) {
      return var0.size() < var1.size() && method_1336(var0, var1);
   }

   // $FF: renamed from: e (java.util.Collection, java.util.Collection) boolean
   public static boolean method_1338(Collection var0, Collection var1) {
      if (var0.size() != var1.size()) {
         return false;
      } else {
         class_406 var2 = new class_406(var0, var1);
         if (var2.field_714.size() != var2.field_715.size()) {
            return false;
         } else {
            Iterator var3 = var2.field_714.keySet().iterator();

            Object var4;
            do {
               if (!var3.hasNext()) {
                  return true;
               }

               var4 = var3.next();
            } while(var2.method_1292(var4) == var2.method_1293(var4));

            return false;
         }
      }
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Collection, org.a.a.a.r) boolean
   public static boolean method_1339(Collection var0, Collection var1, class_33 var2) {
      if (var2 == null) {
         throw new NullPointerException("Equator must not be null.");
      } else if (var0.size() != var1.size()) {
         return false;
      } else {
         class_414 var3 = new class_414(var2);
         return method_1338(method_1357(var0, var3), method_1357(var1, var3));
      }
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Iterable) int
   public static int method_1340(Object var0, Iterable var1) {
      if (var1 == null) {
         throw new NullPointerException("coll must not be null.");
      } else {
         return class_402.method_1264(var1, var0);
      }
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.an) java.lang.Object
   public static Object method_1341(Iterable var0, class_1 var1) {
      return var1 != null ? class_402.method_1256(var0, var1) : null;
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_1342(Iterable var0, class_34 var1) {
      if (var1 != null) {
         class_402.method_1254(var0, var1);
      }

      return var1;
   }

   // $FF: renamed from: a (java.util.Iterator, org.a.a.a.g) org.a.a.a.g
   public static class_34 method_1343(Iterator var0, class_34 var1) {
      if (var1 != null) {
         class_401.method_1223(var0, var1);
      }

      return var1;
   }

   // $FF: renamed from: b (java.lang.Iterable, org.a.a.a.g) java.lang.Object
   public static Object method_1344(Iterable var0, class_34 var1) {
      return var1 != null ? class_402.method_1255(var0, var1) : null;
   }

   // $FF: renamed from: b (java.util.Iterator, org.a.a.a.g) java.lang.Object
   public static Object method_1345(Iterator var0, class_34 var1) {
      return var1 != null ? class_401.method_1224(var0, var1) : null;
   }

   // $FF: renamed from: b (java.lang.Iterable, org.a.a.a.an) boolean
   public static boolean method_1346(Iterable var0, class_1 var1) {
      boolean var2 = false;
      if (var0 != null && var1 != null) {
         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            if (!var1.method_3(var3.next())) {
               var3.remove();
               var2 = true;
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: c (java.lang.Iterable, org.a.a.a.an) boolean
   public static boolean method_1347(Iterable var0, class_1 var1) {
      return method_1346(var0, var1 == null ? null : class_326.method_813(var1));
   }

   // $FF: renamed from: a (java.util.Collection, org.a.a.a.aI) void
   public static void method_1348(Collection var0, class_21 var1) {
      if (var0 != null && var1 != null) {
         if (var0 instanceof List) {
            List var2 = (List)var0;
            ListIterator var3 = var2.listIterator();

            while(var3.hasNext()) {
               var3.set(var1.method_25(var3.next()));
            }
         } else {
            Collection var4 = method_1357(var0, var1);
            var0.clear();
            var0.addAll(var4);
         }
      }

   }

   // $FF: renamed from: d (java.lang.Iterable, org.a.a.a.an) int
   public static int method_1349(Iterable var0, class_1 var1) {
      return var1 == null ? 0 : (int)class_402.method_1260(var0, var1);
   }

   // $FF: renamed from: e (java.lang.Iterable, org.a.a.a.an) boolean
   public static boolean method_1350(Iterable var0, class_1 var1) {
      return var1 == null ? false : class_402.method_1259(var0, var1);
   }

   // $FF: renamed from: f (java.lang.Iterable, org.a.a.a.an) boolean
   public static boolean method_1351(Iterable var0, class_1 var1) {
      return var1 == null ? false : class_402.method_1258(var0, var1);
   }

   // $FF: renamed from: g (java.lang.Iterable, org.a.a.a.an) java.util.Collection
   public static Collection method_1352(Iterable var0, class_1 var1) {
      ArrayList var2 = var0 instanceof Collection ? new ArrayList(((Collection)var0).size()) : new ArrayList();
      return method_1353(var0, var1, var2);
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.an, java.util.Collection) java.util.Collection
   public static Collection method_1353(Iterable var0, class_1 var1, Collection var2) {
      if (var0 != null && var1 != null) {
         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            if (var1.method_3(var4)) {
               var2.add(var4);
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.an, java.util.Collection, java.util.Collection) java.util.Collection
   public static Collection method_1354(Iterable var0, class_1 var1, Collection var2, Collection var3) {
      if (var0 != null && var1 != null) {
         Iterator var4 = var0.iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            if (var1.method_3(var5)) {
               var2.add(var5);
            } else {
               var3.add(var5);
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: h (java.lang.Iterable, org.a.a.a.an) java.util.Collection
   public static Collection method_1355(Iterable var0, class_1 var1) {
      ArrayList var2 = var0 instanceof Collection ? new ArrayList(((Collection)var0).size()) : new ArrayList();
      return method_1356(var0, var1, var2);
   }

   // $FF: renamed from: b (java.lang.Iterable, org.a.a.a.an, java.util.Collection) java.util.Collection
   public static Collection method_1356(Iterable var0, class_1 var1, Collection var2) {
      if (var0 != null && var1 != null) {
         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            if (!var1.method_3(var4)) {
               var2.add(var4);
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.aI) java.util.Collection
   public static Collection method_1357(Iterable var0, class_21 var1) {
      ArrayList var2 = var0 instanceof Collection ? new ArrayList(((Collection)var0).size()) : new ArrayList();
      return method_1359(var0, var1, var2);
   }

   // $FF: renamed from: a (java.util.Iterator, org.a.a.a.aI) java.util.Collection
   public static Collection method_1358(Iterator var0, class_21 var1) {
      return method_1360(var0, var1, new ArrayList());
   }

   // $FF: renamed from: a (java.lang.Iterable, org.a.a.a.aI, java.util.Collection) java.util.Collection
   public static Collection method_1359(Iterable var0, class_21 var1, Collection var2) {
      return var0 != null ? method_1360(var0.iterator(), var1, var2) : var2;
   }

   // $FF: renamed from: a (java.util.Iterator, org.a.a.a.aI, java.util.Collection) java.util.Collection
   public static Collection method_1360(Iterator var0, class_21 var1, Collection var2) {
      if (var0 != null && var1 != null) {
         while(var0.hasNext()) {
            Object var3 = var0.next();
            Object var4 = var1.method_25(var3);
            var2.add(var4);
         }
      }

      return var2;
   }

   // $FF: renamed from: a (java.util.Collection, java.lang.Object) boolean
   public static boolean method_1361(Collection var0, Object var1) {
      if (var0 == null) {
         throw new NullPointerException("The collection must not be null");
      } else {
         return var1 != null && var0.add(var1);
      }
   }

   // $FF: renamed from: a (java.util.Collection, java.lang.Iterable) boolean
   public static boolean method_1362(Collection var0, Iterable var1) {
      return var1 instanceof Collection ? var0.addAll((Collection)var1) : method_1363(var0, var1.iterator());
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Iterator) boolean
   public static boolean method_1363(Collection var0, Iterator var1) {
      boolean var2;
      for(var2 = false; var1.hasNext(); var2 |= var0.add(var1.next())) {
         ;
      }

      return var2;
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Enumeration) boolean
   public static boolean method_1364(Collection var0, Enumeration var1) {
      boolean var2;
      for(var2 = false; var1.hasMoreElements(); var2 |= var0.add(var1.nextElement())) {
         ;
      }

      return var2;
   }

   // $FF: renamed from: a (java.util.Collection, java.lang.Object[]) boolean
   public static boolean method_1365(Collection var0, Object[] var1) {
      boolean var2 = false;
      Object[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object var6 = var3[var5];
         var2 |= var0.add(var6);
      }

      return var2;
   }

   // $FF: renamed from: a (java.util.Iterator, int) java.lang.Object
   public static Object method_1366(Iterator var0, int var1) {
      return class_401.method_1231(var0, var1);
   }

   // $FF: renamed from: a (int) void
   static void method_1367(int var0) {
      if (var0 < 0) {
         throw new IndexOutOfBoundsException("Index cannot be negative: " + var0);
      }
   }

   // $FF: renamed from: a (java.lang.Iterable, int) java.lang.Object
   public static Object method_1368(Iterable var0, int var1) {
      return class_402.method_1265(var0, var1);
   }

   // $FF: renamed from: a (java.lang.Object, int) java.lang.Object
   public static Object method_1369(Object var0, int var1) {
      int var2 = var1;
      if (var1 < 0) {
         throw new IndexOutOfBoundsException("Index cannot be negative: " + var1);
      } else if (var0 instanceof Map) {
         Map var8 = (Map)var0;
         Iterator var4 = var8.entrySet().iterator();
         return class_401.method_1231(var4, var1);
      } else if (var0 instanceof Object[]) {
         return ((Object[])((Object[])var0))[var1];
      } else {
         Iterator var6;
         if (var0 instanceof Iterator) {
            var6 = (Iterator)var0;
            return class_401.method_1231(var6, var1);
         } else if (var0 instanceof Iterable) {
            Iterable var7 = (Iterable)var0;
            return class_402.method_1265(var7, var1);
         } else if (var0 instanceof Collection) {
            var6 = ((Collection)var0).iterator();
            return class_401.method_1231(var6, var1);
         } else if (var0 instanceof Enumeration) {
            Enumeration var3 = (Enumeration)var0;
            return class_410.method_1304(var3, var1);
         } else if (var0 == null) {
            throw new IllegalArgumentException("Unsupported object type: null");
         } else {
            try {
               return Array.get(var0, var2);
            } catch (IllegalArgumentException var5) {
               throw new IllegalArgumentException("Unsupported object type: " + var0.getClass().getName());
            }
         }
      }
   }

   // $FF: renamed from: a (java.util.Map, int) java.util.Map.Entry
   public static Entry method_1370(Map var0, int var1) {
      method_1367(var1);
      return (Entry)method_1368(var0.entrySet(), var1);
   }

   // $FF: renamed from: a (java.lang.Object) int
   public static int method_1371(Object var0) {
      if (var0 == null) {
         return 0;
      } else {
         int var1 = 0;
         if (var0 instanceof Map) {
            var1 = ((Map)var0).size();
         } else if (var0 instanceof Collection) {
            var1 = ((Collection)var0).size();
         } else if (var0 instanceof Iterable) {
            var1 = class_402.method_1266((Iterable)var0);
         } else if (var0 instanceof Object[]) {
            var1 = ((Object[])((Object[])var0)).length;
         } else if (var0 instanceof Iterator) {
            var1 = class_401.method_1232((Iterator)var0);
         } else if (var0 instanceof Enumeration) {
            Enumeration var2 = (Enumeration)var0;

            while(var2.hasMoreElements()) {
               ++var1;
               var2.nextElement();
            }
         } else {
            try {
               var1 = Array.getLength(var0);
            } catch (IllegalArgumentException var3) {
               throw new IllegalArgumentException("Unsupported object type: " + var0.getClass().getName());
            }
         }

         return var1;
      }
   }

   // $FF: renamed from: b (java.lang.Object) boolean
   public static boolean method_1372(Object var0) {
      if (var0 == null) {
         return true;
      } else if (var0 instanceof Collection) {
         return ((Collection)var0).isEmpty();
      } else if (var0 instanceof Iterable) {
         return class_402.method_1261((Iterable)var0);
      } else if (var0 instanceof Map) {
         return ((Map)var0).isEmpty();
      } else if (var0 instanceof Object[]) {
         return ((Object[])((Object[])var0)).length == 0;
      } else if (var0 instanceof Iterator) {
         return !((Iterator)var0).hasNext();
      } else if (var0 instanceof Enumeration) {
         return !((Enumeration)var0).hasMoreElements();
      } else {
         try {
            return Array.getLength(var0) == 0;
         } catch (IllegalArgumentException var2) {
            throw new IllegalArgumentException("Unsupported object type: " + var0.getClass().getName());
         }
      }
   }

   // $FF: renamed from: b (java.util.Collection) boolean
   public static boolean method_1373(Collection var0) {
      return var0 == null || var0.isEmpty();
   }

   // $FF: renamed from: c (java.util.Collection) boolean
   public static boolean method_1374(Collection var0) {
      return !method_1373(var0);
   }

   // $FF: renamed from: a (java.lang.Object[]) void
   public static void method_1375(Object[] var0) {
      int var1 = 0;

      for(int var2 = var0.length - 1; var2 > var1; ++var1) {
         Object var3 = var0[var2];
         var0[var2] = var0[var1];
         var0[var1] = var3;
         --var2;
      }

   }

   // $FF: renamed from: d (java.util.Collection) boolean
   public static boolean method_1376(Collection var0) {
      if (var0 == null) {
         throw new NullPointerException("The collection must not be null");
      } else if (var0 instanceof class_35) {
         return ((class_35)var0).method_71();
      } else {
         try {
            class_35 var1 = class_99.method_218(var0);
            return var1.method_71();
         } catch (IllegalArgumentException var2) {
            return false;
         }
      }
   }

   // $FF: renamed from: e (java.util.Collection) int
   public static int method_1377(Collection var0) {
      if (var0 == null) {
         throw new NullPointerException("The collection must not be null");
      } else if (var0 instanceof class_35) {
         return ((class_35)var0).method_72();
      } else {
         try {
            class_35 var1 = class_99.method_218(var0);
            return var1.method_72();
         } catch (IllegalArgumentException var2) {
            return -1;
         }
      }
   }

   // $FF: renamed from: e (java.lang.Iterable, java.lang.Iterable) java.util.List
   public static List method_1378(Iterable var0, Iterable var1) {
      return method_1381(var0, var1, class_405.method_1280(), true);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable, boolean) java.util.List
   public static List method_1379(Iterable var0, Iterable var1, boolean var2) {
      return method_1381(var0, var1, class_405.method_1280(), var2);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable, java.util.Comparator) java.util.List
   public static List method_1380(Iterable var0, Iterable var1, Comparator var2) {
      return method_1381(var0, var1, var2, true);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable, java.util.Comparator, boolean) java.util.List
   public static List method_1381(Iterable var0, Iterable var1, Comparator var2, boolean var3) {
      if (var0 != null && var1 != null) {
         if (var2 == null) {
            throw new NullPointerException("The comparator must not be null");
         } else {
            int var4 = var0 instanceof Collection && var1 instanceof Collection ? Math.max(1, ((Collection)var0).size() + ((Collection)var1).size()) : 10;
            class_169 var5 = new class_169(var2, var0.iterator(), var1.iterator());
            if (var3) {
               return class_401.method_1221(var5, var4);
            } else {
               ArrayList var6 = new ArrayList(var4);

               Object var8;
               for(Object var7 = null; var5.hasNext(); var7 = var8) {
                  var8 = var5.next();
                  if (var7 == null || !var7.equals(var8)) {
                     var6.add(var8);
                  }
               }

               var6.trimToSize();
               return var6;
            }
         }
      } else {
         throw new NullPointerException("The collections must not be null");
      }
   }

   // $FF: renamed from: f (java.util.Collection) java.util.Collection
   public static Collection method_1382(Collection var0) {
      class_449 var1 = new class_449(var0);
      LinkedList var2 = new LinkedList();

      while(var1.hasNext()) {
         var2.add(var1.method_1523());
      }

      return var2;
   }

   // $FF: renamed from: f (java.util.Collection, java.util.Collection) java.util.Collection
   public static Collection method_1383(Collection var0, Collection var1) {
      return class_400.method_1155(var0, var1);
   }

   // $FF: renamed from: a (java.lang.Iterable, java.lang.Iterable, org.a.a.a.r) java.util.Collection
   public static Collection method_1384(Iterable var0, Iterable var1, class_33 var2) {
      class_413 var3 = new class_413(var2);
      Set var4 = (Set)method_1359(var1, var3, new HashSet());
      ArrayList var5 = new ArrayList();
      Iterator var6 = var0.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         if (var4.contains(new class_408(var2, var7))) {
            var5.add(var7);
         }
      }

      return var5;
   }

   // $FF: renamed from: g (java.util.Collection, java.util.Collection) java.util.Collection
   public static Collection method_1385(Collection var0, Collection var1) {
      return class_400.method_1156(var0, var1);
   }

   // $FF: renamed from: b (java.lang.Iterable, java.lang.Iterable, org.a.a.a.r) java.util.Collection
   public static Collection method_1386(Iterable var0, Iterable var1, class_33 var2) {
      class_412 var3 = new class_412(var2);
      Set var4 = (Set)method_1359(var1, var3, new HashSet());
      ArrayList var5 = new ArrayList();
      Iterator var6 = var0.iterator();

      while(var6.hasNext()) {
         Object var7 = var6.next();
         if (!var4.contains(new class_408(var2, var7))) {
            var5.add(var7);
         }
      }

      return var5;
   }

   // $FF: renamed from: g (java.util.Collection) java.util.Collection
   public static Collection method_1387(Collection var0) {
      return class_100.method_220(var0);
   }

   // $FF: renamed from: h (java.util.Collection) java.util.Collection
   public static Collection method_1388(Collection var0) {
      return class_98.method_216(var0);
   }

   // $FF: renamed from: a (java.util.Collection, org.a.a.a.an) java.util.Collection
   public static Collection method_1389(Collection var0, class_1 var1) {
      return class_81.method_170(var0, var1);
   }

   // $FF: renamed from: b (java.util.Collection, org.a.a.a.aI) java.util.Collection
   public static Collection method_1390(Collection var0, class_21 var1) {
      return class_90.method_190(var0, var1);
   }

   // $FF: renamed from: i (java.util.Collection) java.lang.Object
   public static Object method_1391(Collection var0) {
      if (var0 == null) {
         throw new NullPointerException("Collection must not be null.");
      } else if (var0.size() != 1) {
         throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
      } else {
         return var0.iterator().next();
      }
   }
}
