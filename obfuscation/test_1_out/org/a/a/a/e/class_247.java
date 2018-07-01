package org.a.a.a.e;

import java.io.Serializable;
import java.util.Map;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.e.F
public final class class_247 implements Serializable, class_21 {
   // $FF: renamed from: a long
   private static final long field_361 = 862391807045468939L;
   // $FF: renamed from: b java.util.Map
   private final Map field_362;

   // $FF: renamed from: a (java.util.Map) org.a.a.a.aI
   public static class_21 method_604(Map var0) {
      return (class_21)(var0 == null ? class_276.method_647() : new class_247(var0));
   }

   private class_247(Map var1) {
      this.field_362 = var1;
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      return this.field_362.get(var1);
   }

   // $FF: renamed from: a () java.util.Map
   public Map method_605() {
      return this.field_362;
   }
}
