package org.a.a.a;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.a.a.a.i.class_118;
import org.a.a.a.i.class_124;
import org.a.a.a.i.class_127;
import org.a.a.a.i.class_128;
import org.a.a.a.i.class_130;
import org.a.a.a.i.class_131;
import org.a.a.a.i.class_132;
import org.a.a.a.i.class_133;
import org.a.a.a.i.class_135;
import org.a.a.a.i.class_136;
import org.a.a.a.i.class_137;
import org.a.a.a.i.class_138;

// $FF: renamed from: org.a.a.a.aa
public class class_351 {
   // $FF: renamed from: a java.util.SortedMap
   public static final SortedMap field_586 = class_127.method_285(new TreeMap());
   // $FF: renamed from: b java.lang.String
   private static final String field_587 = "    ";

   // $FF: renamed from: a (java.util.Map, java.lang.Object) java.lang.Object
   public static Object method_900(Map var0, Object var1) {
      return var0 != null ? var0.get(var1) : null;
   }

   // $FF: renamed from: b (java.util.Map, java.lang.Object) java.lang.String
   public static String method_901(Map var0, Object var1) {
      if (var0 != null) {
         Object var2 = var0.get(var1);
         if (var2 != null) {
            return var2.toString();
         }
      }

      return null;
   }

   // $FF: renamed from: c (java.util.Map, java.lang.Object) java.lang.Boolean
   public static Boolean method_902(Map var0, Object var1) {
      if (var0 != null) {
         Object var2 = var0.get(var1);
         if (var2 != null) {
            if (var2 instanceof Boolean) {
               return (Boolean)var2;
            }

            if (var2 instanceof String) {
               return Boolean.valueOf((String)var2);
            }

            if (var2 instanceof Number) {
               Number var3 = (Number)var2;
               return var3.intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
            }
         }
      }

      return null;
   }

   // $FF: renamed from: d (java.util.Map, java.lang.Object) java.lang.Number
   public static Number method_903(Map var0, Object var1) {
      if (var0 != null) {
         Object var2 = var0.get(var1);
         if (var2 != null) {
            if (var2 instanceof Number) {
               return (Number)var2;
            }

            if (var2 instanceof String) {
               try {
                  String var3 = (String)var2;
                  return NumberFormat.getInstance().parse(var3);
               } catch (ParseException var4) {
                  ;
               }
            }
         }
      }

      return null;
   }

   // $FF: renamed from: e (java.util.Map, java.lang.Object) java.lang.Byte
   public static Byte method_904(Map var0, Object var1) {
      Number var2 = method_903(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         return var2 instanceof Byte ? (Byte)var2 : var2.byteValue();
      }
   }

   // $FF: renamed from: f (java.util.Map, java.lang.Object) java.lang.Short
   public static Short method_905(Map var0, Object var1) {
      Number var2 = method_903(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         return var2 instanceof Short ? (Short)var2 : var2.shortValue();
      }
   }

   // $FF: renamed from: g (java.util.Map, java.lang.Object) java.lang.Integer
   public static Integer method_906(Map var0, Object var1) {
      Number var2 = method_903(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         return var2 instanceof Integer ? (Integer)var2 : var2.intValue();
      }
   }

   // $FF: renamed from: h (java.util.Map, java.lang.Object) java.lang.Long
   public static Long method_907(Map var0, Object var1) {
      Number var2 = method_903(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         return var2 instanceof Long ? (Long)var2 : var2.longValue();
      }
   }

   // $FF: renamed from: i (java.util.Map, java.lang.Object) java.lang.Float
   public static Float method_908(Map var0, Object var1) {
      Number var2 = method_903(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         return var2 instanceof Float ? (Float)var2 : var2.floatValue();
      }
   }

   // $FF: renamed from: j (java.util.Map, java.lang.Object) java.lang.Double
   public static Double method_909(Map var0, Object var1) {
      Number var2 = method_903(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         return var2 instanceof Double ? (Double)var2 : var2.doubleValue();
      }
   }

   // $FF: renamed from: k (java.util.Map, java.lang.Object) java.util.Map
   public static Map method_910(Map var0, Object var1) {
      if (var0 != null) {
         Object var2 = var0.get(var1);
         if (var2 != null && var2 instanceof Map) {
            return (Map)var2;
         }
      }

      return null;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Object) java.lang.Object
   public static Object method_911(Map var0, Object var1, Object var2) {
      if (var0 != null) {
         Object var3 = var0.get(var1);
         if (var3 != null) {
            return var3;
         }
      }

      return var2;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.String) java.lang.String
   public static String method_912(Map var0, Object var1, String var2) {
      String var3 = method_901(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Boolean) java.lang.Boolean
   public static Boolean method_913(Map var0, Object var1, Boolean var2) {
      Boolean var3 = method_902(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Number) java.lang.Number
   public static Number method_914(Map var0, Object var1, Number var2) {
      Number var3 = method_903(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Byte) java.lang.Byte
   public static Byte method_915(Map var0, Object var1, Byte var2) {
      Byte var3 = method_904(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Short) java.lang.Short
   public static Short method_916(Map var0, Object var1, Short var2) {
      Short var3 = method_905(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Integer) java.lang.Integer
   public static Integer method_917(Map var0, Object var1, Integer var2) {
      Integer var3 = method_906(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Long) java.lang.Long
   public static Long method_918(Map var0, Object var1, Long var2) {
      Long var3 = method_907(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Float) java.lang.Float
   public static Float method_919(Map var0, Object var1, Float var2) {
      Float var3 = method_908(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.lang.Double) java.lang.Double
   public static Double method_920(Map var0, Object var1, Double var2) {
      Double var3 = method_909(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, java.util.Map) java.util.Map
   public static Map method_921(Map var0, Object var1, Map var2) {
      Map var3 = method_910(var0, var1);
      if (var3 == null) {
         var3 = var2;
      }

      return var3;
   }

   // $FF: renamed from: l (java.util.Map, java.lang.Object) boolean
   public static boolean method_922(Map var0, Object var1) {
      return Boolean.TRUE.equals(method_902(var0, var1));
   }

   // $FF: renamed from: m (java.util.Map, java.lang.Object) byte
   public static byte method_923(Map var0, Object var1) {
      Byte var2 = method_904(var0, var1);
      return var2 == null ? 0 : var2;
   }

   // $FF: renamed from: n (java.util.Map, java.lang.Object) short
   public static short method_924(Map var0, Object var1) {
      Short var2 = method_905(var0, var1);
      return var2 == null ? 0 : var2;
   }

   // $FF: renamed from: o (java.util.Map, java.lang.Object) int
   public static int method_925(Map var0, Object var1) {
      Integer var2 = method_906(var0, var1);
      return var2 == null ? 0 : var2;
   }

   // $FF: renamed from: p (java.util.Map, java.lang.Object) long
   public static long method_926(Map var0, Object var1) {
      Long var2 = method_907(var0, var1);
      return var2 == null ? 0L : var2;
   }

   // $FF: renamed from: q (java.util.Map, java.lang.Object) float
   public static float method_927(Map var0, Object var1) {
      Float var2 = method_908(var0, var1);
      return var2 == null ? 0.0F : var2;
   }

   // $FF: renamed from: r (java.util.Map, java.lang.Object) double
   public static double method_928(Map var0, Object var1) {
      Double var2 = method_909(var0, var1);
      return var2 == null ? 0.0D : var2;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, boolean) boolean
   public static boolean method_929(Map var0, Object var1, boolean var2) {
      Boolean var3 = method_902(var0, var1);
      return var3 == null ? var2 : var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, byte) byte
   public static byte method_930(Map var0, Object var1, byte var2) {
      Byte var3 = method_904(var0, var1);
      return var3 == null ? var2 : var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, short) short
   public static short method_931(Map var0, Object var1, short var2) {
      Short var3 = method_905(var0, var1);
      return var3 == null ? var2 : var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, int) int
   public static int method_932(Map var0, Object var1, int var2) {
      Integer var3 = method_906(var0, var1);
      return var3 == null ? var2 : var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, long) long
   public static long method_933(Map var0, Object var1, long var2) {
      Long var4 = method_907(var0, var1);
      return var4 == null ? var2 : var4;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, float) float
   public static float method_934(Map var0, Object var1, float var2) {
      Float var3 = method_908(var0, var1);
      return var3 == null ? var2 : var3;
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object, double) double
   public static double method_935(Map var0, Object var1, double var2) {
      Double var4 = method_909(var0, var1);
      return var4 == null ? var2 : var4;
   }

   // $FF: renamed from: a (java.util.Map) java.util.Properties
   public static Properties method_936(Map var0) {
      Properties var1 = new Properties();
      if (var0 != null) {
         Iterator var2 = var0.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            Object var5 = var3.getKey();
            Object var6 = var3.getValue();
            var1.put(var5, var6);
         }
      }

      return var1;
   }

   // $FF: renamed from: a (java.util.ResourceBundle) java.util.Map
   public static Map method_937(ResourceBundle var0) {
      Enumeration var1 = var0.getKeys();
      HashMap var2 = new HashMap();

      while(var1.hasMoreElements()) {
         String var3 = (String)var1.nextElement();
         Object var4 = var0.getObject(var3);
         var2.put(var3, var4);
      }

      return var2;
   }

   // $FF: renamed from: a (java.io.PrintStream, java.lang.Object, java.util.Map) void
   public static void method_938(PrintStream var0, Object var1, Map var2) {
      method_940(var0, var1, var2, new ArrayDeque(), false);
   }

   // $FF: renamed from: b (java.io.PrintStream, java.lang.Object, java.util.Map) void
   public static void method_939(PrintStream var0, Object var1, Map var2) {
      method_940(var0, var1, var2, new ArrayDeque(), true);
   }

   // $FF: renamed from: a (java.io.PrintStream, java.lang.Object, java.util.Map, java.util.Deque, boolean) void
   private static void method_940(PrintStream var0, Object var1, Map var2, Deque var3, boolean var4) {
      method_941(var0, var3.size());
      if (var2 == null) {
         if (var1 != null) {
            var0.print(var1);
            var0.print(" = ");
         }

         var0.println("null");
      } else {
         if (var1 != null) {
            var0.print(var1);
            var0.println(" = ");
         }

         method_941(var0, var3.size());
         var0.println("{");
         var3.addLast(var2);
         Iterator var5 = var2.entrySet().iterator();

         while(true) {
            while(var5.hasNext()) {
               Entry var6 = (Entry)var5.next();
               Object var7 = var6.getKey();
               Object var8 = var6.getValue();
               if (var8 instanceof Map && !var3.contains(var8)) {
                  method_940(var0, var7 == null ? "null" : var7, (Map)var8, var3, var4);
               } else {
                  method_941(var0, var3.size());
                  var0.print(var7);
                  var0.print(" = ");
                  int var9 = class_402.method_1257(var3, class_326.method_795(var8));
                  if (var9 == -1) {
                     var0.print(var8);
                  } else if (var3.size() - 1 == var9) {
                     var0.print("(this Map)");
                  } else {
                     var0.print("(ancestor[" + (var3.size() - 1 - var9 - 1) + "] Map)");
                  }

                  if (var4 && var8 != null) {
                     var0.print(' ');
                     var0.println(var8.getClass().getName());
                  } else {
                     var0.println();
                  }
               }
            }

            var3.removeLast();
            method_941(var0, var3.size());
            var0.println(var4 ? "} " + var2.getClass().getName() : "}");
            return;
         }
      }
   }

   // $FF: renamed from: a (java.io.PrintStream, int) void
   private static void method_941(PrintStream var0, int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         var0.print("    ");
      }

   }

   // $FF: renamed from: b (java.util.Map) java.util.Map
   public static Map method_942(Map var0) {
      HashMap var1 = new HashMap(var0.size());
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(var3.getValue(), var3.getKey());
      }

      return var1;
   }

   // $FF: renamed from: b (java.util.Map, java.lang.Object, java.lang.Object) void
   public static void method_943(Map var0, Object var1, Object var2) {
      var0.put(var1, var2 == null ? "" : var2);
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object[]) java.util.Map
   public static Map method_944(Map var0, Object[] var1) {
      if (var0 == null) {
         throw new NullPointerException("The map must not be null");
      } else if (var1 != null && var1.length != 0) {
         Object var2 = var1[0];
         int var5;
         Object var6;
         int var8;
         Object[] var9;
         if (var2 instanceof Entry) {
            var9 = var1;
            var8 = var1.length;

            for(var5 = 0; var5 < var8; ++var5) {
               var6 = var9[var5];
               Entry var10 = (Entry)var6;
               var0.put(var10.getKey(), var10.getValue());
            }
         } else if (var2 instanceof class_30) {
            var9 = var1;
            var8 = var1.length;

            for(var5 = 0; var5 < var8; ++var5) {
               var6 = var9[var5];
               class_30 var7 = (class_30)var6;
               var0.put(var7.getKey(), var7.getValue());
            }
         } else {
            int var3;
            if (var2 instanceof Object[]) {
               for(var3 = 0; var3 < var1.length; ++var3) {
                  Object[] var4 = (Object[])((Object[])var1[var3]);
                  if (var4 == null || var4.length < 2) {
                     throw new IllegalArgumentException("Invalid array element: " + var3);
                  }

                  var0.put(var4[0], var4[1]);
               }
            } else {
               var3 = 0;

               while(var3 < var1.length - 1) {
                  var0.put(var1[var3++], var1[var3++]);
               }
            }
         }

         return var0;
      } else {
         return var0;
      }
   }

   // $FF: renamed from: c (java.util.Map) java.util.Map
   public static Map method_945(Map var0) {
      return var0 == null ? Collections.emptyMap() : var0;
   }

   // $FF: renamed from: d (java.util.Map) boolean
   public static boolean method_946(Map var0) {
      return var0 == null || var0.isEmpty();
   }

   // $FF: renamed from: e (java.util.Map) boolean
   public static boolean method_947(Map var0) {
      return !method_946(var0);
   }

   // $FF: renamed from: f (java.util.Map) java.util.Map
   public static Map method_948(Map var0) {
      return Collections.synchronizedMap(var0);
   }

   // $FF: renamed from: g (java.util.Map) java.util.Map
   public static Map method_949(Map var0) {
      return class_128.method_288(var0);
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.an, org.a.a.a.an) org.a.a.a.y
   public static class_11 method_950(Map var0, class_1 var1, class_1 var2) {
      return class_137.method_372(var0, var1, var2);
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.y
   public static class_11 method_951(Map var0, class_21 var1, class_21 var2) {
      return class_135.method_362(var0, var1, var2);
   }

   // $FF: renamed from: h (java.util.Map) org.a.a.a.y
   public static class_11 method_952(Map var0) {
      return class_118.method_264(var0);
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.s) org.a.a.a.y
   public static class_11 method_953(Map var0, class_32 var1) {
      return class_132.method_353(var0, var1);
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.aI) org.a.a.a.y
   public static class_11 method_954(Map var0, class_21 var1) {
      return class_132.method_354(var0, var1);
   }

   // $FF: renamed from: i (java.util.Map) org.a.a.a.al
   public static class_15 method_955(Map var0) {
      return class_131.method_339(var0);
   }

   // $FF: renamed from: j (java.util.Map) org.a.a.a.i.au
   public static class_130 method_956(Map var0) {
      return class_130.method_326(var0);
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Class) org.a.a.a.i.au
   public static class_130 method_957(Map var0, Class var1) {
      return class_130.method_327(var0, var1);
   }

   // $FF: renamed from: b (java.util.Map, org.a.a.a.s) org.a.a.a.i.au
   public static class_130 method_958(Map var0, class_32 var1) {
      return class_130.method_328(var0, var1);
   }

   // $FF: renamed from: a (java.util.SortedMap) java.util.SortedMap
   public static SortedMap method_959(SortedMap var0) {
      return Collections.synchronizedSortedMap(var0);
   }

   // $FF: renamed from: b (java.util.SortedMap) java.util.SortedMap
   public static SortedMap method_960(SortedMap var0) {
      return class_127.method_285(var0);
   }

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.an, org.a.a.a.an) java.util.SortedMap
   public static SortedMap method_961(SortedMap var0, class_1 var1, class_1 var2) {
      return class_138.method_376(var0, var1, var2);
   }

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.aI, org.a.a.a.aI) java.util.SortedMap
   public static SortedMap method_962(SortedMap var0, class_21 var1, class_21 var2) {
      return class_136.method_369(var0, var1, var2);
   }

   // $FF: renamed from: c (java.util.SortedMap) java.util.SortedMap
   public static SortedMap method_963(SortedMap var0) {
      return class_124.method_280(var0);
   }

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.s) java.util.SortedMap
   public static SortedMap method_964(SortedMap var0, class_32 var1) {
      return class_133.method_357(var0, var1);
   }

   // $FF: renamed from: a (java.util.SortedMap, org.a.a.a.aI) java.util.SortedMap
   public static SortedMap method_965(SortedMap var0, class_21 var1) {
      return class_133.method_358(var0, var1);
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Iterable, org.a.a.a.aI) void
   public static void method_966(Map var0, Iterable var1, class_21 var2) {
      method_967(var0, var1, var2, class_341.method_851());
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Iterable, org.a.a.a.aI, org.a.a.a.aI) void
   public static void method_967(Map var0, Iterable var1, class_21 var2, class_21 var3) {
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         var0.put(var2.method_25(var5), var3.method_25(var5));
      }

   }

   // $FF: renamed from: a (org.a.a.a.ad, java.lang.Iterable, org.a.a.a.aI) void
   public static void method_968(class_14 var0, Iterable var1, class_21 var2) {
      method_969(var0, var1, var2, class_341.method_851());
   }

   // $FF: renamed from: a (org.a.a.a.ad, java.lang.Iterable, org.a.a.a.aI, org.a.a.a.aI) void
   public static void method_969(class_14 var0, Iterable var1, class_21 var2, class_21 var3) {
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         var0.put(var2.method_25(var5), var3.method_25(var5));
      }

   }

   // $FF: renamed from: k (java.util.Map) org.a.a.a.y
   public static class_11 method_970(Map var0) {
      if (var0 == null) {
         throw new NullPointerException("Map must not be null");
      } else {
         return (class_11)(var0 instanceof class_11 ? (class_11)var0 : new class_119(var0));
      }
   }

   // $FF: renamed from: d (java.util.SortedMap) org.a.a.a.z
   public static class_16 method_971(SortedMap var0) {
      if (var0 == null) {
         throw new NullPointerException("Map must not be null");
      } else {
         return (class_16)(var0 instanceof class_16 ? (class_16)var0 : new class_126(var0));
      }
   }
}
