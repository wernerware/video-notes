package org.a.a.a.e;

import java.io.Serializable;
import java.util.Collection;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.e.g
public class class_281 implements Serializable, class_21 {
   // $FF: renamed from: a long
   private static final long field_431 = 3514945074733160196L;
   // $FF: renamed from: b org.a.a.a.aI[]
   private final class_21[] field_432;

   // $FF: renamed from: a (org.a.a.a.aI[]) org.a.a.a.aI
   public static class_21 method_654(class_21... var0) {
      class_289.method_681(var0);
      return (class_21)(var0.length == 0 ? class_245.method_600() : new class_281(var0));
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.aI
   public static class_21 method_655(Collection var0) {
      if (var0 == null) {
         throw new NullPointerException("Transformer collection must not be null");
      } else if (var0.size() == 0) {
         return class_245.method_600();
      } else {
         class_21[] var1 = (class_21[])var0.toArray(new class_21[var0.size()]);
         class_289.method_681(var1);
         return new class_281(false, var1);
      }
   }

   private class_281(boolean var1, class_21[] var2) {
      this.field_432 = var1 ? class_289.method_680(var2) : var2;
   }

   public class_281(class_21... var1) {
      this(true, var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_25(Object var1) {
      class_21[] var2 = this.field_432;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_21 var5 = var2[var4];
         var1 = var5.method_25(var1);
      }

      return var1;
   }

   // $FF: renamed from: a () org.a.a.a.aI[]
   public class_21[] method_656() {
      return class_289.method_680(this.field_432);
   }
}
