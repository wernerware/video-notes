package org.a.a.a.c;

import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.e.class_241;

// $FF: renamed from: org.a.a.a.c.e
public class class_81 extends class_48 {
   // $FF: renamed from: b long
   private static final long field_71 = -5259182142076705162L;
   // $FF: renamed from: a org.a.a.a.an
   protected final APPARENTLY_REALLY_IMPORTANT field_72;

   // $FF: renamed from: a (org.a.a.a.an) org.a.a.a.c.f
   public static class_106 method_168(APPARENTLY_REALLY_IMPORTANT var0) {
      return new class_106(var0);
   }

   // $FF: renamed from: h () org.a.a.a.c.f
   public static class_106 method_169() {
      return new class_106(class_241.method_595());
   }

   // $FF: renamed from: a (java.util.Collection, org.a.a.a.an) org.a.a.a.c.e
   public static class_81 method_170(Collection var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return new class_81(var0, var1);
   }

   protected class_81(Collection var1, APPARENTLY_REALLY_IMPORTANT var2) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("Predicate must not be null.");
      } else {
         this.field_72 = var2;
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            this.method_171(var4);
         }

      }
   }

   // $FF: renamed from: b (java.lang.Object) void
   protected void method_171(Object var1) {
      if (!this.field_72.method_3(var1)) {
         throw new IllegalArgumentException("Cannot add Object '" + var1 + "' - Predicate '" + this.field_72 + "' rejected it");
      }
   }

   public boolean add(Object var1) {
      this.method_171(var1);
      return this.f().add(var1);
   }

   public boolean addAll(Collection var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         this.method_171(var3);
      }

      return this.f().addAll(var1);
   }
}
