package org.a.a.a;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import org.a.a.a.f.class_222;

// $FF: renamed from: org.a.a.a.q
public class class_410 {
   // $FF: renamed from: a (java.util.Enumeration, int) java.lang.Object
   public static Object method_1304(Enumeration var0, int var1) {
      int var2 = var1;
      class_415.method_1367(var1);

      while(var0.hasMoreElements()) {
         --var2;
         if (var2 == -1) {
            return var0.nextElement();
         }

         var0.nextElement();
      }

      throw new IndexOutOfBoundsException("Entry does not exist: " + var2);
   }

   // $FF: renamed from: a (java.util.Enumeration) java.util.List
   public static List method_1305(Enumeration var0) {
      return class_401.method_1220(new class_222(var0));
   }

   // $FF: renamed from: a (java.util.StringTokenizer) java.util.List
   public static List method_1306(StringTokenizer var0) {
      ArrayList var1 = new ArrayList(var0.countTokens());

      while(var0.hasMoreTokens()) {
         var1.add(var0.nextToken());
      }

      return var1;
   }
}
