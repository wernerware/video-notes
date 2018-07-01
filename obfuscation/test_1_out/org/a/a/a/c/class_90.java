package org.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.c.h
public class class_90 extends class_48 {
   // $FF: renamed from: b long
   private static final long field_81 = 8692300188161871514L;
   // $FF: renamed from: a org.a.a.a.aI
   protected final class_21 field_82;

   // $FF: renamed from: a (java.util.Collection, org.a.a.a.aI) org.a.a.a.c.h
   public static class_90 method_190(Collection var0, class_21 var1) {
      return new class_90(var0, var1);
   }

   // $FF: renamed from: b (java.util.Collection, org.a.a.a.aI) org.a.a.a.c.h
   public static class_90 method_191(Collection var0, class_21 var1) {
      class_90 var2 = new class_90(var0, var1);
      if (var0.size() > 0) {
         Object[] var3 = (Object[])var0.toArray();
         var0.clear();
         Object[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Object var7 = var4[var6];
            var2.f().add(var1.method_25(var7));
         }
      }

      return var2;
   }

   protected class_90(Collection var1, class_21 var2) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("Transformer must not be null");
      } else {
         this.field_82 = var2;
      }
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   protected Object method_192(Object var1) {
      return this.field_82.method_25(var1);
   }

   // $FF: renamed from: b (java.util.Collection) java.util.Collection
   protected Collection method_193(Collection var1) {
      ArrayList var2 = new ArrayList(var1.size());
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var2.add(this.method_192(var4));
      }

      return var2;
   }

   public boolean add(Object var1) {
      return this.f().add(this.method_192(var1));
   }

   public boolean addAll(Collection var1) {
      return this.f().addAll(this.method_193(var1));
   }
}
