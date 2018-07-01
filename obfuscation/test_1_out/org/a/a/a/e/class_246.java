package org.a.a.a.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.a.a.a.class_21;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.e.E
public class class_246 implements class_21 {
   // $FF: renamed from: a java.lang.String
   private final String field_358;
   // $FF: renamed from: b java.lang.Class[]
   private final Class[] field_359;
   // $FF: renamed from: c java.lang.Object[]
   private final Object[] field_360;

   // $FF: renamed from: a (java.lang.String) org.a.a.a.aI
   public static class_21 method_602(String var0) {
      if (var0 == null) {
         throw new NullPointerException("The method to invoke must not be null");
      } else {
         return new class_246(var0);
      }
   }

   // $FF: renamed from: a (java.lang.String, java.lang.Class[], java.lang.Object[]) org.a.a.a.aI
   public static class_21 method_603(String var0, Class[] var1, Object[] var2) {
      if (var0 == null) {
         throw new NullPointerException("The method to invoke must not be null");
      } else if (var1 == null && var2 != null || var1 != null && var2 == null || var1 != null && var2 != null && var1.length != var2.length) {
         throw new IllegalArgumentException("The parameter types must match the arguments");
      } else {
         return var1 != null && var1.length != 0 ? new class_246(var0, var1, var2) : new class_246(var0);
      }
   }

   private class_246(String var1) {
      this.field_358 = var1;
      this.field_359 = null;
      this.field_360 = null;
   }

   public class_246(String var1, Class[] var2, Object[] var3) {
      this.field_358 = var1;
      this.field_359 = var2 != null ? (Class[])var2.clone() : null;
      this.field_360 = var3 != null ? (Object[])var3.clone() : null;
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      if (var1 == null) {
         return null;
      } else {
         try {
            Class var2 = var1.getClass();
            Method var3 = var2.getMethod(this.field_358, this.field_359);
            return var3.invoke(var1, this.field_360);
         } catch (NoSuchMethodException var4) {
            throw new class_427("InvokerTransformer: The method '" + this.field_358 + "' on '" + var1.getClass() + "' does not exist");
         } catch (IllegalAccessException var5) {
            throw new class_427("InvokerTransformer: The method '" + this.field_358 + "' on '" + var1.getClass() + "' cannot be accessed");
         } catch (InvocationTargetException var6) {
            throw new class_427("InvokerTransformer: The method '" + this.field_358 + "' on '" + var1.getClass() + "' threw an exception", var6);
         }
      }
   }
}
