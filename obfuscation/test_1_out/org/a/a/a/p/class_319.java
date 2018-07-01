package org.a.a.a.p;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

// $FF: renamed from: org.a.a.a.p.m
class class_319 extends class_318 {
   // $FF: renamed from: c java.lang.Object
   private final Object field_523;
   // $FF: renamed from: d java.lang.Object
   private final Object field_524;
   // $FF: renamed from: e boolean
   private final boolean field_525;
   // $FF: renamed from: f boolean
   private final boolean field_526;
   // $FF: renamed from: a org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_527;

   protected class_319(class_303 var1, Object var2, Object var3) {
      this(var1, var2, true, var3, false);
   }

   protected class_319(class_303 var1, Object var2, boolean var3, Object var4, boolean var5) {
      super(var1, (class_330)null);
      this.field_527 = var1;
      if (var2 == null && var4 == null) {
         throw new IllegalArgumentException("must have a from or to!");
      } else if (var2 != null && var4 != null && var1.a().compare(var2, var4) > 0) {
         throw new IllegalArgumentException("fromKey > toKey");
      } else {
         this.field_523 = var2;
         this.field_525 = var3;
         this.field_524 = var4;
         this.field_526 = var5;
      }
   }

   public Object firstKey() {
      class_301 var1 = null;
      if (this.field_523 == null) {
         var1 = this.field_527.method_727();
      } else if (this.field_525) {
         var1 = this.field_527.method_731(this.field_523);
      } else {
         var1 = this.field_527.method_730(this.field_523);
      }

      Object var2 = var1 != null ? var1.getKey() : null;
      if (var1 != null && (this.field_524 == null || this.b(var2, false))) {
         return var2;
      } else {
         throw new NoSuchElementException();
      }
   }

   public Object lastKey() {
      class_301 var1;
      if (this.field_524 == null) {
         var1 = this.field_527.method_735();
      } else if (this.field_526) {
         var1 = this.field_527.method_733(this.field_524);
      } else {
         var1 = this.field_527.method_732(this.field_524);
      }

      Object var2 = var1 != null ? var1.getKey() : null;
      if (var1 != null && (this.field_523 == null || this.a(var2, false))) {
         return var2;
      } else {
         throw new NoSuchElementException();
      }
   }

   // $FF: renamed from: a () java.util.Set
   protected Set method_751() {
      return new class_323(this.field_527, this);
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_752() {
      return this.field_523;
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_754() {
      return this.field_524;
   }

   // $FF: renamed from: d () boolean
   public boolean method_753() {
      return this.field_525;
   }

   // $FF: renamed from: e () boolean
   public boolean method_755() {
      return this.field_526;
   }

   // $FF: renamed from: a (java.lang.Object, boolean, java.lang.Object, boolean) java.util.SortedMap
   protected SortedMap method_760(Object var1, boolean var2, Object var3, boolean var4) {
      return new class_319(this.field_527, var1, var2, var3, var4);
   }
}
