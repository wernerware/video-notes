package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.a.a.a.class_21;
import org.a.a.a.class_32;
import org.a.a.a.e.class_290;

// $FF: renamed from: org.a.a.a.i.ag
public class class_132 extends class_116 implements Serializable {
   // $FF: renamed from: c long
   private static final long field_136 = 7990956402564206740L;
   // $FF: renamed from: b org.a.a.a.aI
   protected final class_21 field_137;

   // $FF: renamed from: a (java.util.Map, org.a.a.a.s) org.a.a.a.i.ag
   public static class_132 method_353(Map var0, class_32 var1) {
      return new class_132(var0, var1);
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.aI) org.a.a.a.i.ag
   public static class_132 method_354(Map var0, class_21 var1) {
      return new class_132(var0, var1);
   }

   protected class_132(Map var1, class_32 var2) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("Factory must not be null");
      } else {
         this.field_137 = class_290.method_683(var2);
      }
   }

   protected class_132(Map var1, class_21 var2) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("Factory must not be null");
      } else {
         this.field_137 = var2;
      }
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_355(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_356(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   public Object get(Object var1) {
      if (!this.a.containsKey(var1)) {
         Object var3 = this.field_137.method_25(var1);
         this.a.put(var1, var3);
         return var3;
      } else {
         return this.a.get(var1);
      }
   }
}
