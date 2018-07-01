package org.a.a.a.i;

import java.util.concurrent.TimeUnit;

// $FF: renamed from: org.a.a.a.i.aC
public class class_299 implements class_3 {
   // $FF: renamed from: a long
   private static final long field_469 = 1L;
   // $FF: renamed from: b long
   private final long field_470;

   public class_299() {
      this(-1L);
   }

   public class_299(long var1) {
      this.field_470 = var1;
   }

   public class_299(long var1, TimeUnit var3) {
      this(class_120.method_274(var1, var3));
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) long
   public long method_5(Object var1, Object var2) {
      if (this.field_470 >= 0L) {
         long var3 = System.currentTimeMillis();
         return var3 > Long.MAX_VALUE - this.field_470 ? -1L : var3 + this.field_470;
      } else {
         return -1L;
      }
   }
}
