package org.a.a.a.e;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.a.a.a.class_32;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.e.C
public class class_249 implements class_32 {
   // $FF: renamed from: a java.lang.Class
   private final Class field_367;
   // $FF: renamed from: b java.lang.Class[]
   private final Class[] field_368;
   // $FF: renamed from: c java.lang.Object[]
   private final Object[] field_369;
   // $FF: renamed from: d java.lang.reflect.Constructor
   private transient Constructor field_370 = null;

   // $FF: renamed from: a (java.lang.Class, java.lang.Class[], java.lang.Object[]) org.a.a.a.s
   public static class_32 method_606(Class var0, Class[] var1, Object[] var2) {
      if (var0 == null) {
         throw new NullPointerException("Class to instantiate must not be null");
      } else if (var1 == null && var2 != null || var1 != null && var2 == null || var1 != null && var2 != null && var1.length != var2.length) {
         throw new IllegalArgumentException("Parameter types must match the arguments");
      } else {
         return var1 != null && var1.length != 0 ? new class_249(var0, var1, var2) : new class_249(var0);
      }
   }

   public class_249(Class var1) {
      this.field_367 = var1;
      this.field_368 = null;
      this.field_369 = null;
      this.method_607();
   }

   public class_249(Class var1, Class[] var2, Object[] var3) {
      this.field_367 = var1;
      this.field_368 = (Class[])var2.clone();
      this.field_369 = (Object[])var3.clone();
      this.method_607();
   }

   // $FF: renamed from: b () void
   private void method_607() {
      try {
         this.field_370 = this.field_367.getConstructor(this.field_368);
      } catch (NoSuchMethodException var2) {
         throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
      }
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_67() {
      if (this.field_370 == null) {
         this.method_607();
      }

      try {
         return this.field_370.newInstance(this.field_369);
      } catch (InstantiationException var2) {
         throw new class_427("InstantiateFactory: InstantiationException", var2);
      } catch (IllegalAccessException var3) {
         throw new class_427("InstantiateFactory: Constructor must be public", var3);
      } catch (InvocationTargetException var4) {
         throw new class_427("InstantiateFactory: Constructor threw an exception", var4);
      }
   }
}
