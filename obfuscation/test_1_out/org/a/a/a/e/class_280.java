package org.a.a.a.e;

import java.io.Serializable;
import java.util.Comparator;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.e.j
public class class_280 implements Serializable, class_1 {
   // $FF: renamed from: a long
   private static final long field_427 = -1863209236504077399L;
   // $FF: renamed from: b java.lang.Object
   private final Object field_428;
   // $FF: renamed from: c java.util.Comparator
   private final Comparator field_429;
   // $FF: renamed from: d org.a.a.a.e.l
   private final class_278 field_430;

   // $FF: renamed from: a (java.lang.Object, java.util.Comparator) org.a.a.a.an
   public static class_1 method_652(Object var0, Comparator var1) {
      return method_653(var0, var1, class_278.field_419);
   }

   // $FF: renamed from: a (java.lang.Object, java.util.Comparator, org.a.a.a.e.l) org.a.a.a.an
   public static class_1 method_653(Object var0, Comparator var1, class_278 var2) {
      if (var1 == null) {
         throw new NullPointerException("Comparator must not be null.");
      } else if (var2 == null) {
         throw new NullPointerException("Criterion must not be null.");
      } else {
         return new class_280(var0, var1, var2);
      }
   }

   public class_280(Object var1, Comparator var2, class_278 var3) {
      this.field_428 = var1;
      this.field_429 = var2;
      this.field_430 = var3;
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_3(Object var1) {
      boolean var2 = false;
      int var3 = this.field_429.compare(this.field_428, var1);
      switch(class_277.field_418[this.field_430.ordinal()]) {
      case 1:
         var2 = var3 == 0;
         break;
      case 2:
         var2 = var3 > 0;
         break;
      case 3:
         var2 = var3 < 0;
         break;
      case 4:
         var2 = var3 >= 0;
         break;
      case 5:
         var2 = var3 <= 0;
         break;
      default:
         throw new IllegalStateException("The current criterion '" + this.field_430 + "' is invalid.");
      }

      return var2;
   }
}
