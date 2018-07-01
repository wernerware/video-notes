package org.a.a.a;

import java.util.Map;

// $FF: renamed from: org.a.a.a.aE
public class class_338 {
   // $FF: renamed from: a (org.a.a.a.w) org.a.a.a.y
   public static class_11 method_839(class_9 var0) {
      if (var0 == null) {
         throw new NullPointerException("Get must not be null");
      } else if (var0 instanceof Map) {
         return var0 instanceof class_11 ? (class_11)var0 : class_351.method_970((Map)var0);
      } else {
         return new class_336(var0, (class_337)null);
      }
   }

   // $FF: renamed from: a (org.a.a.a.ap) java.util.Map
   public static Map method_840(class_8 var0) {
      if (var0 == null) {
         throw new NullPointerException("Put must not be null");
      } else {
         return (Map)(var0 instanceof Map ? (Map)var0 : new class_342(var0, (class_337)null));
      }
   }
}
