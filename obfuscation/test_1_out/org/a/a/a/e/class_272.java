package org.a.a.a.e;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.a.a.a.class_32;

// $FF: renamed from: org.a.a.a.e.T
public class class_272 {
   // $FF: renamed from: a (java.lang.Object) org.a.a.a.s
   public static class_32 method_641(Object var0) {
      if (var0 == null) {
         return class_275.method_645((Object)null);
      } else {
         try {
            Method var1 = var0.getClass().getMethod("clone", (Class[])null);
            return new class_270(var0, var1, (class_269)null);
         } catch (NoSuchMethodException var4) {
            try {
               var0.getClass().getConstructor(var0.getClass());
               return new class_249(var0.getClass(), new Class[]{var0.getClass()}, new Object[]{var0});
            } catch (NoSuchMethodException var3) {
               if (var0 instanceof Serializable) {
                  return new class_267((Serializable)var0, (class_269)null);
               } else {
                  throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
               }
            }
         }
      }
   }
}
