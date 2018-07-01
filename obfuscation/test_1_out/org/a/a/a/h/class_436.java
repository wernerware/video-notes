package org.a.a.a.h;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

// $FF: renamed from: org.a.a.a.h.o
public class class_436 extends class_435 implements Serializable {
   // $FF: renamed from: d long
   private static final long field_761 = 6897789178562232073L;
   // $FF: renamed from: e int
   private static final int field_762 = 20;
   // $FF: renamed from: f org.a.a.a.h.e
   private transient class_438 field_763;
   // $FF: renamed from: g int
   private transient int field_764;
   // $FF: renamed from: h int
   private int field_765;

   public class_436() {
      this(20);
   }

   public class_436(Collection var1) {
      super(var1);
      this.field_765 = 20;
   }

   public class_436(int var1) {
      this.field_765 = var1;
      this.a();
   }

   // $FF: renamed from: h () int
   protected int method_1454() {
      return this.field_765;
   }

   // $FF: renamed from: a (int) void
   protected void method_1455(int var1) {
      this.field_765 = var1;
      this.method_1456();
   }

   // $FF: renamed from: i () void
   protected void method_1456() {
      while(this.field_764 > this.field_765) {
         this.method_1457();
      }

   }

   // $FF: renamed from: j () org.a.a.a.h.e
   protected class_438 method_1457() {
      if (this.field_764 == 0) {
         return null;
      } else {
         class_438 var1 = this.field_763;
         this.field_763 = var1.field_769;
         var1.field_769 = null;
         --this.field_764;
         return var1;
      }
   }

   // $FF: renamed from: k () boolean
   protected boolean method_1458() {
      return this.field_764 >= this.field_765;
   }

   // $FF: renamed from: b (org.a.a.a.h.e) void
   protected void method_1459(class_438 var1) {
      if (!this.method_1458()) {
         class_438 var2 = this.field_763;
         var1.field_768 = null;
         var1.field_769 = var2;
         var1.method_1472((Object)null);
         this.field_763 = var1;
         ++this.field_764;
      }
   }

   // $FF: renamed from: c (java.lang.Object) org.a.a.a.h.e
   protected class_438 method_1443(Object var1) {
      class_438 var2 = this.method_1457();
      if (var2 == null) {
         return super.method_1443(var1);
      } else {
         var2.method_1472(var1);
         return var2;
      }
   }

   // $FF: renamed from: a (org.a.a.a.h.e) void
   protected void method_1447(class_438 var1) {
      super.method_1447(var1);
      this.method_1459(var1);
   }

   // $FF: renamed from: g () void
   protected void method_1448() {
      int var1 = Math.min(this.b, this.field_765 - this.field_764);
      class_438 var2 = this.a.field_769;

      for(int var3 = 0; var3 < var1; ++var3) {
         class_438 var4 = var2;
         var2 = var2.field_769;
         this.method_1459(var4);
      }

      super.method_1448();
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_1460(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_1461(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(var1);
   }
}
