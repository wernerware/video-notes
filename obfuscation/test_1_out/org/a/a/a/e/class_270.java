package org.a.a.a.e;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.a.a.a.class_32;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.e.V
class class_270 implements class_32 {
   // $FF: renamed from: a java.lang.Object
   private final Object field_403;
   // $FF: renamed from: b java.lang.reflect.Method
   private transient Method field_404;

   private class_270(Object var1, Method var2) {
      this.field_403 = var1;
      this.field_404 = var2;
   }

   // $FF: renamed from: b () void
   private void method_637() {
      try {
         this.field_404 = this.field_403.getClass().getMethod("clone", (Class[])null);
      } catch (NoSuchMethodException var2) {
         throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
      }
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_67() {
      if (this.field_404 == null) {
         this.method_637();
      }

      try {
         return this.field_404.invoke(this.field_403, (Object[])null);
      } catch (IllegalAccessException var2) {
         throw new class_427("PrototypeCloneFactory: Clone method must be public", var2);
      } catch (InvocationTargetException var3) {
         throw new class_427("PrototypeCloneFactory: Clone method threw an exception", var3);
      }
   }

   // $FF: synthetic method
   class_270(Object var1, Method var2, class_269 var3) {
      this(var1, var2);
   }
}
