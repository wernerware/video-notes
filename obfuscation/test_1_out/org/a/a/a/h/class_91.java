package org.a.a.a.h;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_21;
import org.a.a.a.c.class_90;

// $FF: renamed from: org.a.a.a.h.u
public class class_91 extends class_90 implements List {
   // $FF: renamed from: b long
   private static final long field_83 = 1077193035000013141L;

   // $FF: renamed from: a (java.util.List, org.a.a.a.aI) org.a.a.a.h.u
   public static class_91 method_194(List var0, class_21 var1) {
      return new class_91(var0, var1);
   }

   // $FF: renamed from: b (java.util.List, org.a.a.a.aI) org.a.a.a.h.u
   public static class_91 method_195(List var0, class_21 var1) {
      class_91 var2 = new class_91(var0, var1);
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

   protected class_91(List var1, class_21 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a () java.util.List
   protected List method_196() {
      return (List)this.f();
   }

   public boolean equals(Object var1) {
      return var1 == this || this.f().equals(var1);
   }

   public int hashCode() {
      return this.f().hashCode();
   }

   public Object get(int var1) {
      return this.method_196().get(var1);
   }

   public int indexOf(Object var1) {
      return this.method_196().indexOf(var1);
   }

   public int lastIndexOf(Object var1) {
      return this.method_196().lastIndexOf(var1);
   }

   public Object remove(int var1) {
      return this.method_196().remove(var1);
   }

   public void add(int var1, Object var2) {
      var2 = this.b(var2);
      this.method_196().add(var1, var2);
   }

   public boolean addAll(int var1, Collection var2) {
      var2 = this.b(var2);
      return this.method_196().addAll(var1, var2);
   }

   public ListIterator listIterator() {
      return this.listIterator(0);
   }

   public ListIterator listIterator(int var1) {
      return new class_199(this, this.method_196().listIterator(var1));
   }

   public Object set(int var1, Object var2) {
      var2 = this.b(var2);
      return this.method_196().set(var1, var2);
   }

   public List subList(int var1, int var2) {
      List var3 = this.method_196().subList(var1, var2);
      return new class_91(var3, this.a);
   }

   // $FF: renamed from: a (org.a.a.a.h.u, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   static Object method_197(class_91 var0, Object var1) {
      return var0.b(var1);
   }

   // $FF: renamed from: b (org.a.a.a.h.u, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   static Object method_198(class_91 var0, Object var1) {
      return var0.b(var1);
   }
}
