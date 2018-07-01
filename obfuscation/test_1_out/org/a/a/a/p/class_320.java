package org.a.a.a.p;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.p.l
class class_320 extends class_318 {
   // $FF: renamed from: c java.lang.Object
   private final Object field_528;
   // $FF: renamed from: d int
   private final int field_529;
   // $FF: renamed from: e int
   private final int field_530;
   // $FF: renamed from: f java.lang.Object
   private Object field_531;
   // $FF: renamed from: g java.lang.Object
   private Object field_532;
   // $FF: renamed from: h int
   private transient int field_533;
   // $FF: renamed from: i int
   private int field_534;
   // $FF: renamed from: a org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_535;

   private class_320(class_303 var1, Object var2, int var3, int var4) {
      super(var1, (class_330)null);
      this.field_535 = var1;
      this.field_531 = null;
      this.field_532 = null;
      this.field_533 = 0;
      this.field_534 = -1;
      this.field_528 = var2;
      this.field_529 = var3;
      this.field_530 = var4;
   }

   // $FF: renamed from: f () int
   private int method_761() {
      if (this.field_534 == -1 || this.field_535.field_488 != this.field_533) {
         Iterator var1 = super.entrySet().iterator();
         this.field_534 = 0;
         Entry var2 = null;
         if (var1.hasNext()) {
            var2 = (Entry)var1.next();
            this.field_534 = 1;
         }

         this.field_531 = var2 == null ? null : var2.getKey();
         if (this.field_531 != null) {
            class_301 var3 = this.field_535.method_737((class_301)var2);
            this.field_531 = var3 == null ? null : var3.getKey();
         }

         for(this.field_532 = this.field_531; var1.hasNext(); var2 = (Entry)var1.next()) {
            ++this.field_534;
         }

         this.field_532 = var2 == null ? null : var2.getKey();
         if (this.field_532 != null) {
            class_301 var4 = this.field_535.method_725((class_301)var2);
            this.field_532 = var4 == null ? null : var4.getKey();
         }

         this.field_533 = this.field_535.field_488;
      }

      return this.field_534;
   }

   public Object firstKey() {
      this.method_761();
      class_301 var1 = null;
      if (this.field_531 == null) {
         var1 = this.field_535.method_727();
      } else {
         var1 = this.field_535.method_730(this.field_531);
      }

      Object var2 = var1 != null ? var1.getKey() : null;
      if (var1 != null && this.field_535.a().method_833(this.field_528, this.field_529, this.field_530, var2)) {
         return var2;
      } else {
         throw new NoSuchElementException();
      }
   }

   public Object lastKey() {
      this.method_761();
      class_301 var1 = null;
      if (this.field_532 == null) {
         var1 = this.field_535.method_735();
      } else {
         var1 = this.field_535.method_732(this.field_532);
      }

      Object var2 = var1 != null ? var1.getKey() : null;
      if (var1 != null && this.field_535.a().method_833(this.field_528, this.field_529, this.field_530, var2)) {
         return var2;
      } else {
         throw new NoSuchElementException();
      }
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   protected boolean method_756(Object var1) {
      return this.field_535.a().method_833(this.field_528, this.field_529, this.field_530, var1);
   }

   // $FF: renamed from: b (java.lang.Object) boolean
   protected boolean method_757(Object var1) {
      return this.method_756(var1);
   }

   // $FF: renamed from: a (java.lang.Object, boolean) boolean
   protected boolean method_758(Object var1, boolean var2) {
      return this.field_535.a().method_833(this.field_528, this.field_529, this.field_530, var1);
   }

   // $FF: renamed from: b (java.lang.Object, boolean) boolean
   protected boolean method_759(Object var1, boolean var2) {
      return this.field_535.a().method_833(this.field_528, this.field_529, this.field_530, var1);
   }

   // $FF: renamed from: a () java.util.Set
   protected Set method_751() {
      return new class_324(this.field_535, this);
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_752() {
      return this.field_531;
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_754() {
      return this.field_532;
   }

   // $FF: renamed from: d () boolean
   public boolean method_753() {
      return false;
   }

   // $FF: renamed from: e () boolean
   public boolean method_755() {
      return false;
   }

   // $FF: renamed from: a (java.lang.Object, boolean, java.lang.Object, boolean) java.util.SortedMap
   protected SortedMap method_760(Object var1, boolean var2, Object var3, boolean var4) {
      return new class_319(this.field_535, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   class_320(class_303 var1, Object var2, int var3, int var4, class_330 var5) {
      this(var1, var2, var3, var4);
   }

   // $FF: renamed from: a (org.a.a.a.p.l) int
   // $FF: synthetic method
   static int method_762(class_320 var0) {
      return var0.method_761();
   }

   // $FF: renamed from: b (org.a.a.a.p.l) java.lang.Object
   // $FF: synthetic method
   static Object method_763(class_320 var0) {
      return var0.field_528;
   }

   // $FF: renamed from: c (org.a.a.a.p.l) int
   // $FF: synthetic method
   static int method_764(class_320 var0) {
      return var0.field_529;
   }

   // $FF: renamed from: d (org.a.a.a.p.l) int
   // $FF: synthetic method
   static int method_765(class_320 var0) {
      return var0.field_530;
   }
}
