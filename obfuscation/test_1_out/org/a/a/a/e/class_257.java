package org.a.a.a.e;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.a.a.a.class_21;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.e.D
public class class_257 implements class_21 {
   // $FF: renamed from: a org.a.a.a.aI
   private static final class_21 field_375 = new class_257();
   // $FF: renamed from: b java.lang.Class[]
   private final Class[] field_376;
   // $FF: renamed from: c java.lang.Object[]
   private final Object[] field_377;

   // $FF: renamed from: a () org.a.a.a.aI
   public static class_21 method_610() {
      return field_375;
   }

   // $FF: renamed from: a (java.lang.Class[], java.lang.Object[]) org.a.a.a.aI
   public static class_21 method_611(Class[] var0, Object[] var1) {
      if (var0 == null && var1 != null || var0 != null && var1 == null || var0 != null && var1 != null && var0.length != var1.length) {
         throw new IllegalArgumentException("Parameter types must match the arguments");
      } else {
         return var0 != null && var0.length != 0 ? new class_257(var0, var1) : new class_257();
      }
   }

   private class_257() {
      this.field_376 = null;
      this.field_377 = null;
   }

   public class_257(Class[] var1, Object[] var2) {
      this.field_376 = var1 != null ? (Class[])var1.clone() : null;
      this.field_377 = var2 != null ? (Object[])var2.clone() : null;
   }

   // $FF: renamed from: a (java.lang.Class) java.lang.Object
   public Object method_612(Class var1) {
      try {
         if (var1 == null) {
            throw new class_427("InstantiateTransformer: Input object was not an instanceof Class, it was a null object");
         } else {
            Constructor var2 = var1.getConstructor(this.field_376);
            return var2.newInstance(this.field_377);
         }
      } catch (NoSuchMethodException var3) {
         throw new class_427("InstantiateTransformer: The constructor must exist and be public ");
      } catch (InstantiationException var4) {
         throw new class_427("InstantiateTransformer: InstantiationException", var4);
      } catch (IllegalAccessException var5) {
         throw new class_427("InstantiateTransformer: Constructor must be public", var5);
      } catch (InvocationTargetException var6) {
         throw new class_427("InstantiateTransformer: Constructor threw an exception", var6);
      }
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_25(Object var1) {
      return this.method_612((Class)var1);
   }
}
