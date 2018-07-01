package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

// $FF: renamed from: org.a.a.a.i.N
public class class_152 extends class_151 implements Serializable, Cloneable {
   // $FF: renamed from: t long
   private static final long field_187 = -7074655917369299456L;

   public class_152() {
      super(16, 0.75F, 12);
   }

   public class_152(int var1) {
      super(var1);
   }

   public class_152(int var1, float var2) {
      super(var1, var2);
   }

   public class_152(Map var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_437(Object var1) {
      if (var1 == null) {
         return class_151.field_178;
      } else {
         char[] var2 = var1.toString().toCharArray();

         for(int var3 = var2.length - 1; var3 >= 0; --var3) {
            var2[var3] = Character.toLowerCase(Character.toUpperCase(var2[var3]));
         }

         return new String(var2);
      }
   }

   // $FF: renamed from: a () org.a.a.a.i.N
   public class_152 method_465() {
      return (class_152)super.method_464();
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_466(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_467(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(var1);
   }

   // $FF: renamed from: j () org.a.a.a.i.a
   // $FF: synthetic method
   public class_151 method_464() {
      return this.method_465();
   }

   // $FF: synthetic method
   public Object clone() {
      return this.method_465();
   }
}
