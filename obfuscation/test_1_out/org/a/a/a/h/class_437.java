package org.a.a.a.h;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// $FF: renamed from: org.a.a.a.h.h
public class class_437 extends class_435 implements Serializable {
   // $FF: renamed from: d long
   private static final long field_766 = 8836393098519411393L;
   // $FF: renamed from: e java.util.List
   private transient List field_767;

   public class_437() {
      this.method_1433();
   }

   public class_437(Collection var1) {
      super(var1);
   }

   // $FF: renamed from: a () void
   protected void method_1433() {
      super.method_1433();
      this.field_767 = new ArrayList();
   }

   public Iterator iterator() {
      return super.listIterator(0);
   }

   public ListIterator listIterator() {
      return this.method_1463(0);
   }

   public ListIterator listIterator(int var1) {
      return this.method_1463(var1);
   }

   // $FF: renamed from: h () org.a.a.a.h.i
   public class_433 method_1462() {
      return this.method_1463(0);
   }

   // $FF: renamed from: a (int) org.a.a.a.h.i
   public class_433 method_1463(int var1) {
      class_433 var2 = new class_433(this, var1);
      this.method_1464(var2);
      return var2;
   }

   // $FF: renamed from: a (org.a.a.a.h.e, java.lang.Object) void
   protected void method_1441(class_438 var1, Object var2) {
      super.method_1441(var1, var2);
      this.method_1466(var1);
   }

   // $FF: renamed from: a (org.a.a.a.h.e, org.a.a.a.h.e) void
   protected void method_1446(class_438 var1, class_438 var2) {
      super.method_1446(var1, var2);
      this.method_1468(var1);
   }

   // $FF: renamed from: a (org.a.a.a.h.e) void
   protected void method_1447(class_438 var1) {
      super.method_1447(var1);
      this.method_1467(var1);
   }

   // $FF: renamed from: g () void
   protected void method_1448() {
      if (this.size() > 0) {
         Iterator var1 = this.iterator();

         while(var1.hasNext()) {
            var1.next();
            var1.remove();
         }
      }

   }

   // $FF: renamed from: a (org.a.a.a.h.i) void
   protected void method_1464(class_433 var1) {
      Iterator var2 = this.field_767.iterator();

      while(var2.hasNext()) {
         WeakReference var3 = (WeakReference)var2.next();
         if (var3.get() == null) {
            var2.remove();
         }
      }

      this.field_767.add(new WeakReference(var1));
   }

   // $FF: renamed from: b (org.a.a.a.h.i) void
   protected void method_1465(class_433 var1) {
      Iterator var2 = this.field_767.iterator();

      while(var2.hasNext()) {
         WeakReference var3 = (WeakReference)var2.next();
         class_433 var4 = (class_433)var3.get();
         if (var4 == null) {
            var2.remove();
         } else if (var4 == var1) {
            var3.clear();
            var2.remove();
            break;
         }
      }

   }

   // $FF: renamed from: b (org.a.a.a.h.e) void
   protected void method_1466(class_438 var1) {
      Iterator var2 = this.field_767.iterator();

      while(var2.hasNext()) {
         WeakReference var3 = (WeakReference)var2.next();
         class_433 var4 = (class_433)var3.get();
         if (var4 == null) {
            var2.remove();
         } else {
            var4.method_1429(var1);
         }
      }

   }

   // $FF: renamed from: c (org.a.a.a.h.e) void
   protected void method_1467(class_438 var1) {
      Iterator var2 = this.field_767.iterator();

      while(var2.hasNext()) {
         WeakReference var3 = (WeakReference)var2.next();
         class_433 var4 = (class_433)var3.get();
         if (var4 == null) {
            var2.remove();
         } else {
            var4.method_1430(var1);
         }
      }

   }

   // $FF: renamed from: d (org.a.a.a.h.e) void
   protected void method_1468(class_438 var1) {
      Iterator var2 = this.field_767.iterator();

      while(var2.hasNext()) {
         WeakReference var3 = (WeakReference)var2.next();
         class_433 var4 = (class_433)var3.get();
         if (var4 == null) {
            var2.remove();
         } else {
            var4.method_1431(var1);
         }
      }

   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_1469(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_1470(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(var1);
   }

   // $FF: renamed from: a (org.a.a.a.h.c, int) java.util.ListIterator
   protected ListIterator method_1451(class_439 var1, int var2) {
      class_434 var3 = new class_434(var1, var2);
      this.method_1464(var3);
      return var3;
   }
}
