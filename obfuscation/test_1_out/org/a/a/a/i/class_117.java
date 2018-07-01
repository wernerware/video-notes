package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.a.a.a.class_21;
import org.a.a.a.class_32;
import org.a.a.a.e.class_276;
import org.a.a.a.e.class_290;

// $FF: renamed from: org.a.a.a.i.Q
public class class_117 extends class_116 implements Serializable {
   // $FF: renamed from: b long
   private static final long field_120 = 19698628745827L;
   // $FF: renamed from: c org.a.a.a.aI
   private final class_21 field_121;

   // $FF: renamed from: a (java.util.Map, java.lang.Object) org.a.a.a.i.Q
   public static class_117 method_259(Map var0, Object var1) {
      return new class_117(var0, class_276.method_648(var1));
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.s) org.a.a.a.i.Q
   public static class_117 method_260(Map var0, class_32 var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Factory must not be null");
      } else {
         return new class_117(var0, class_290.method_683(var1));
      }
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.aI) java.util.Map
   public static Map method_261(Map var0, class_21 var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Transformer must not be null");
      } else {
         return new class_117(var0, var1);
      }
   }

   public class_117(Object var1) {
      this(class_276.method_648(var1));
   }

   public class_117(class_21 var1) {
      this(new HashMap(), var1);
   }

   protected class_117(Map var1, class_21 var2) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("Transformer must not be null.");
      } else {
         this.field_121 = var2;
      }
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_262(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_263(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   public Object get(Object var1) {
      return !this.a.containsKey(var1) ? this.field_121.method_25(var1) : this.a.get(var1);
   }
}
