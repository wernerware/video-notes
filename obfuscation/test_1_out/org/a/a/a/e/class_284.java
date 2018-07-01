package org.a.a.a.e;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.class_34;

// $FF: renamed from: org.a.a.a.e.f
public class class_284 implements Serializable, class_34 {
   // $FF: renamed from: a long
   private static final long field_434 = -3520677225766901240L;
   // $FF: renamed from: b org.a.a.a.g[]
   private final class_34[] field_435;

   // $FF: renamed from: a (org.a.a.a.g[]) org.a.a.a.g
   public static class_34 method_659(class_34... var0) {
      class_289.method_678(var0);
      return (class_34)(var0.length == 0 ? class_243.method_597() : new class_284(var0));
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.g
   public static class_34 method_660(Collection var0) {
      if (var0 == null) {
         throw new NullPointerException("Closure collection must not be null");
      } else if (var0.size() == 0) {
         return class_243.method_597();
      } else {
         class_34[] var1 = new class_34[var0.size()];
         int var2 = 0;

         class_34 var4;
         for(Iterator var3 = var0.iterator(); var3.hasNext(); var1[var2++] = var4) {
            var4 = (class_34)var3.next();
         }

         class_289.method_678(var1);
         return new class_284(false, var1);
      }
   }

   private class_284(boolean var1, class_34... var2) {
      this.field_435 = var1 ? class_289.method_677(var2) : var2;
   }

   public class_284(class_34... var1) {
      this(true, var1);
   }

   // $FF: renamed from: a (java.lang.Object) void
   public void method_70(Object var1) {
      class_34[] var2 = this.field_435;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_34 var5 = var2[var4];
         var5.method_70(var1);
      }

   }

   // $FF: renamed from: a () org.a.a.a.g[]
   public class_34[] method_661() {
      return class_289.method_677(this.field_435);
   }
}
