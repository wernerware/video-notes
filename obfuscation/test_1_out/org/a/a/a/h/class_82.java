package org.a.a.a.h;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_1;
import org.a.a.a.c.class_81;

// $FF: renamed from: org.a.a.a.h.p
public class class_82 extends class_81 implements List {
   // $FF: renamed from: b long
   private static final long field_73 = -5722039223898659102L;

   // $FF: renamed from: a (java.util.List, org.a.a.a.an) org.a.a.a.h.p
   public static class_82 method_172(List var0, class_1 var1) {
      return new class_82(var0, var1);
   }

   protected class_82(List var1, class_1 var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a () java.util.List
   protected List method_173() {
      return (List)super.f();
   }

   public boolean equals(Object var1) {
      return var1 == this || this.method_173().equals(var1);
   }

   public int hashCode() {
      return this.method_173().hashCode();
   }

   public Object get(int var1) {
      return this.method_173().get(var1);
   }

   public int indexOf(Object var1) {
      return this.method_173().indexOf(var1);
   }

   public int lastIndexOf(Object var1) {
      return this.method_173().lastIndexOf(var1);
   }

   public Object remove(int var1) {
      return this.method_173().remove(var1);
   }

   public void add(int var1, Object var2) {
      this.b(var2);
      this.method_173().add(var1, var2);
   }

   public boolean addAll(int var1, Collection var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         this.b(var4);
      }

      return this.method_173().addAll(var1, var2);
   }

   public ListIterator listIterator() {
      return this.listIterator(0);
   }

   public ListIterator listIterator(int var1) {
      return new class_197(this, this.method_173().listIterator(var1));
   }

   public Object set(int var1, Object var2) {
      this.b(var2);
      return this.method_173().set(var1, var2);
   }

   public List subList(int var1, int var2) {
      List var3 = this.method_173().subList(var1, var2);
      return new class_82(var3, this.a);
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_173();
   }

   // $FF: renamed from: a (org.a.a.a.h.p, java.lang.Object) void
   // $FF: synthetic method
   static void method_174(class_82 var0, Object var1) {
      var0.b(var1);
   }

   // $FF: renamed from: b (org.a.a.a.h.p, java.lang.Object) void
   // $FF: synthetic method
   static void method_175(class_82 var0, Object var1) {
      var0.b(var1);
   }
}
