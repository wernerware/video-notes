package org.a.a.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_12;
import org.a.a.a.class_18;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.f.class_164;

// $FF: renamed from: org.a.a.a.b.s
public class class_362 implements Serializable, class_18 {
   // $FF: renamed from: a long
   private static final long field_615 = 721969328361807L;
   // $FF: renamed from: b org.a.a.a.b.B[]
   private transient class_150[] field_616;
   // $FF: renamed from: c int
   private transient int field_617;
   // $FF: renamed from: d int
   private transient int field_618;
   // $FF: renamed from: e java.util.Set
   private transient Set field_619;
   // $FF: renamed from: f java.util.Set
   private transient Set field_620;
   // $FF: renamed from: g java.util.Set
   private transient Set field_621;
   // $FF: renamed from: h org.a.a.a.b.w
   private transient class_359 field_622;

   public class_362() {
      this.field_617 = 0;
      this.field_618 = 0;
      this.field_622 = null;
      this.field_616 = new class_150[2];
   }

   public class_362(Map var1) {
      this();
      this.putAll(var1);
   }

   public int size() {
      return this.field_617;
   }

   public boolean isEmpty() {
      return this.field_617 == 0;
   }

   public boolean containsKey(Object var1) {
      method_1031(var1);
      return this.method_1008(var1) != null;
   }

   public boolean containsValue(Object var1) {
      method_1032(var1);
      return this.method_1009(var1) != null;
   }

   // $FF: renamed from: e (java.lang.Object) java.lang.Comparable
   public Comparable method_995(Object var1) {
      method_1031(var1);
      class_150 var2 = this.method_1008(var1);
      return var2 == null ? null : var2.method_418();
   }

   // $FF: renamed from: a (java.lang.Comparable, java.lang.Comparable) java.lang.Comparable
   public Comparable method_996(Comparable var1, Comparable var2) {
      Comparable var3 = this.method_995(var1);
      this.method_1004(var1, var2);
      return var3;
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.method_996((Comparable)var3.getKey(), (Comparable)var3.getValue());
      }

   }

   // $FF: renamed from: f (java.lang.Object) java.lang.Comparable
   public Comparable method_997(Object var1) {
      return this.method_1005(var1);
   }

   public void clear() {
      this.method_1034();
      this.field_617 = 0;
      this.field_616[class_361.field_611.ordinal()] = null;
      this.field_616[class_361.field_612.ordinal()] = null;
   }

   // $FF: renamed from: g (java.lang.Object) java.lang.Comparable
   public Comparable method_998(Object var1) {
      method_1032(var1);
      class_150 var2 = this.method_1009(var1);
      return var2 == null ? null : var2.method_417();
   }

   // $FF: renamed from: h (java.lang.Object) java.lang.Comparable
   public Comparable method_999(Object var1) {
      return this.method_1006(var1);
   }

   // $FF: renamed from: f () java.lang.Comparable
   public Comparable method_1000() {
      if (this.field_617 == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.method_1013(this.field_616[class_361.field_611.ordinal()], class_361.field_611).method_417();
      }
   }

   // $FF: renamed from: g () java.lang.Comparable
   public Comparable method_1001() {
      if (this.field_617 == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.method_1014(this.field_616[class_361.field_611.ordinal()], class_361.field_611).method_417();
      }
   }

   // $FF: renamed from: a (java.lang.Comparable) java.lang.Comparable
   public Comparable method_1002(Comparable var1) {
      method_1031(var1);
      class_150 var2 = this.method_1010(this.method_1008(var1), class_361.field_611);
      return var2 == null ? null : var2.method_417();
   }

   // $FF: renamed from: b (java.lang.Comparable) java.lang.Comparable
   public Comparable method_1003(Comparable var1) {
      method_1031(var1);
      class_150 var2 = this.method_1011(this.method_1008(var1), class_361.field_611);
      return var2 == null ? null : var2.method_417();
   }

   public Set keySet() {
      if (this.field_619 == null) {
         this.field_619 = new class_112(this, class_361.field_611);
      }

      return this.field_619;
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_13() {
      if (this.field_620 == null) {
         this.field_620 = new class_111(this, class_361.field_611);
      }

      return this.field_620;
   }

   public Set entrySet() {
      if (this.field_621 == null) {
         this.field_621 = new class_109(this);
      }

      return this.field_621;
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return (class_7)(this.isEmpty() ? class_164.method_513() : new class_148(this, class_361.field_611));
   }

   // $FF: renamed from: d () org.a.a.a.aj
   public class_18 method_21() {
      if (this.field_622 == null) {
         this.field_622 = new class_359(this);
      }

      return this.field_622;
   }

   public boolean equals(Object var1) {
      return this.method_1038(var1, class_361.field_611);
   }

   public int hashCode() {
      return this.method_1039(class_361.field_611);
   }

   public String toString() {
      return this.method_1040(class_361.field_611);
   }

   // $FF: renamed from: b (java.lang.Comparable, java.lang.Comparable) void
   private void method_1004(Comparable var1, Comparable var2) {
      method_1033(var1, var2);
      this.method_1005(var1);
      this.method_1006(var2);
      class_150 var3 = this.field_616[class_361.field_611.ordinal()];
      if (var3 == null) {
         class_150 var6 = new class_150(var1, var2);
         this.field_616[class_361.field_611.ordinal()] = var6;
         this.field_616[class_361.field_612.ordinal()] = var6;
         this.method_1035();
      } else {
         while(true) {
            int var4 = method_1012(var1, var3.method_417());
            if (var4 == 0) {
               throw new IllegalArgumentException("Cannot store a duplicate key (\"" + var1 + "\") in this Map");
            }

            class_150 var5;
            if (var4 < 0) {
               if (class_150.method_420(var3, class_361.field_611) == null) {
                  var5 = new class_150(var1, var2);
                  this.method_1037(var5);
                  class_150.method_421(var3, var5, class_361.field_611);
                  class_150.method_422(var5, var3, class_361.field_611);
                  this.method_1026(var5, class_361.field_611);
                  this.method_1035();
                  break;
               }

               var3 = class_150.method_420(var3, class_361.field_611);
            } else {
               if (class_150.method_423(var3, class_361.field_611) == null) {
                  var5 = new class_150(var1, var2);
                  this.method_1037(var5);
                  class_150.method_424(var3, var5, class_361.field_611);
                  class_150.method_422(var5, var3, class_361.field_611);
                  this.method_1026(var5, class_361.field_611);
                  this.method_1035();
                  break;
               }

               var3 = class_150.method_423(var3, class_361.field_611);
            }
         }
      }

   }

   // $FF: renamed from: j (java.lang.Object) java.lang.Comparable
   private Comparable method_1005(Object var1) {
      class_150 var2 = this.method_1008(var1);
      if (var2 == null) {
         return null;
      } else {
         this.method_1027(var2);
         return var2.method_418();
      }
   }

   // $FF: renamed from: k (java.lang.Object) java.lang.Comparable
   private Comparable method_1006(Object var1) {
      class_150 var2 = this.method_1009(var1);
      if (var2 == null) {
         return null;
      } else {
         this.method_1027(var2);
         return var2.method_417();
      }
   }

   // $FF: renamed from: b (java.lang.Object, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1007(Object var1, class_361 var2) {
      class_150 var3 = null;

      int var5;
      for(class_150 var4 = this.field_616[var2.ordinal()]; var4 != null; var4 = var5 < 0 ? class_150.method_420(var4, var2) : class_150.method_423(var4, var2)) {
         var5 = method_1012((Comparable)var1, (Comparable)class_150.method_425(var4, var2));
         if (var5 == 0) {
            var3 = var4;
            break;
         }
      }

      return var3;
   }

   // $FF: renamed from: l (java.lang.Object) org.a.a.a.b.B
   private class_150 method_1008(Object var1) {
      return this.method_1007(var1, class_361.field_611);
   }

   // $FF: renamed from: m (java.lang.Object) org.a.a.a.b.B
   private class_150 method_1009(Object var1) {
      return this.method_1007(var1, class_361.field_612);
   }

   // $FF: renamed from: a (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1010(class_150 var1, class_361 var2) {
      class_150 var3;
      if (var1 == null) {
         var3 = null;
      } else if (class_150.method_423(var1, var2) != null) {
         var3 = this.method_1013(class_150.method_423(var1, var2), var2);
      } else {
         class_150 var4 = class_150.method_426(var1, var2);

         for(class_150 var5 = var1; var4 != null && var5 == class_150.method_423(var4, var2); var4 = class_150.method_426(var4, var2)) {
            var5 = var4;
         }

         var3 = var4;
      }

      return var3;
   }

   // $FF: renamed from: b (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1011(class_150 var1, class_361 var2) {
      class_150 var3;
      if (var1 == null) {
         var3 = null;
      } else if (class_150.method_420(var1, var2) != null) {
         var3 = this.method_1014(class_150.method_420(var1, var2), var2);
      } else {
         class_150 var4 = class_150.method_426(var1, var2);

         for(class_150 var5 = var1; var4 != null && var5 == class_150.method_420(var4, var2); var4 = class_150.method_426(var4, var2)) {
            var5 = var4;
         }

         var3 = var4;
      }

      return var3;
   }

   // $FF: renamed from: c (java.lang.Comparable, java.lang.Comparable) int
   private static int method_1012(Comparable var0, Comparable var1) {
      return var0.compareTo(var1);
   }

   // $FF: renamed from: c (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1013(class_150 var1, class_361 var2) {
      class_150 var3 = var1;
      if (var1 != null) {
         while(class_150.method_420(var3, var2) != null) {
            var3 = class_150.method_420(var3, var2);
         }
      }

      return var3;
   }

   // $FF: renamed from: d (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1014(class_150 var1, class_361 var2) {
      class_150 var3 = var1;
      if (var1 != null) {
         while(class_150.method_423(var3, var2) != null) {
            var3 = class_150.method_423(var3, var2);
         }
      }

      return var3;
   }

   // $FF: renamed from: a (org.a.a.a.b.B, org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_1015(class_150 var1, class_150 var2, class_361 var3) {
      if (var2 != null) {
         if (var1 == null) {
            class_150.method_427(var2, var3);
         } else {
            class_150.method_428(var2, var1, var3);
         }
      }

   }

   // $FF: renamed from: e (org.a.a.a.b.B, org.a.a.a.b.u) boolean
   private static boolean method_1016(class_150 var0, class_361 var1) {
      return var0 != null && class_150.method_429(var0, var1);
   }

   // $FF: renamed from: f (org.a.a.a.b.B, org.a.a.a.b.u) boolean
   private static boolean method_1017(class_150 var0, class_361 var1) {
      return var0 == null || class_150.method_430(var0, var1);
   }

   // $FF: renamed from: g (org.a.a.a.b.B, org.a.a.a.b.u) void
   private static void method_1018(class_150 var0, class_361 var1) {
      if (var0 != null) {
         class_150.method_431(var0, var1);
      }

   }

   // $FF: renamed from: h (org.a.a.a.b.B, org.a.a.a.b.u) void
   private static void method_1019(class_150 var0, class_361 var1) {
      if (var0 != null) {
         class_150.method_427(var0, var1);
      }

   }

   // $FF: renamed from: i (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1020(class_150 var1, class_361 var2) {
      return this.method_1021(this.method_1021(var1, var2), var2);
   }

   // $FF: renamed from: j (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1021(class_150 var1, class_361 var2) {
      return var1 == null ? null : class_150.method_426(var1, var2);
   }

   // $FF: renamed from: k (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1022(class_150 var1, class_361 var2) {
      return var1 == null ? null : class_150.method_423(var1, var2);
   }

   // $FF: renamed from: l (org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   private class_150 method_1023(class_150 var1, class_361 var2) {
      return var1 == null ? null : class_150.method_420(var1, var2);
   }

   // $FF: renamed from: m (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_1024(class_150 var1, class_361 var2) {
      class_150 var3 = class_150.method_423(var1, var2);
      class_150.method_424(var1, class_150.method_420(var3, var2), var2);
      if (class_150.method_420(var3, var2) != null) {
         class_150.method_422(class_150.method_420(var3, var2), var1, var2);
      }

      class_150.method_422(var3, class_150.method_426(var1, var2), var2);
      if (class_150.method_426(var1, var2) == null) {
         this.field_616[var2.ordinal()] = var3;
      } else if (class_150.method_420(class_150.method_426(var1, var2), var2) == var1) {
         class_150.method_421(class_150.method_426(var1, var2), var3, var2);
      } else {
         class_150.method_424(class_150.method_426(var1, var2), var3, var2);
      }

      class_150.method_421(var3, var1, var2);
      class_150.method_422(var1, var3, var2);
   }

   // $FF: renamed from: n (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_1025(class_150 var1, class_361 var2) {
      class_150 var3 = class_150.method_420(var1, var2);
      class_150.method_421(var1, class_150.method_423(var3, var2), var2);
      if (class_150.method_423(var3, var2) != null) {
         class_150.method_422(class_150.method_423(var3, var2), var1, var2);
      }

      class_150.method_422(var3, class_150.method_426(var1, var2), var2);
      if (class_150.method_426(var1, var2) == null) {
         this.field_616[var2.ordinal()] = var3;
      } else if (class_150.method_423(class_150.method_426(var1, var2), var2) == var1) {
         class_150.method_424(class_150.method_426(var1, var2), var3, var2);
      } else {
         class_150.method_421(class_150.method_426(var1, var2), var3, var2);
      }

      class_150.method_424(var3, var1, var2);
      class_150.method_422(var1, var3, var2);
   }

   // $FF: renamed from: o (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_1026(class_150 var1, class_361 var2) {
      class_150 var3 = var1;
      method_1018(var1, var2);

      while(var3 != null && var3 != this.field_616[var2.ordinal()] && method_1016(class_150.method_426(var3, var2), var2)) {
         class_150 var4;
         if (class_150.method_432(var3, var2)) {
            var4 = this.method_1022(this.method_1020(var3, var2), var2);
            if (method_1016(var4, var2)) {
               method_1019(this.method_1021(var3, var2), var2);
               method_1019(var4, var2);
               method_1018(this.method_1020(var3, var2), var2);
               var3 = this.method_1020(var3, var2);
            } else {
               if (class_150.method_433(var3, var2)) {
                  var3 = this.method_1021(var3, var2);
                  this.method_1024(var3, var2);
               }

               method_1019(this.method_1021(var3, var2), var2);
               method_1018(this.method_1020(var3, var2), var2);
               if (this.method_1020(var3, var2) != null) {
                  this.method_1025(this.method_1020(var3, var2), var2);
               }
            }
         } else {
            var4 = this.method_1023(this.method_1020(var3, var2), var2);
            if (method_1016(var4, var2)) {
               method_1019(this.method_1021(var3, var2), var2);
               method_1019(var4, var2);
               method_1018(this.method_1020(var3, var2), var2);
               var3 = this.method_1020(var3, var2);
            } else {
               if (class_150.method_432(var3, var2)) {
                  var3 = this.method_1021(var3, var2);
                  this.method_1025(var3, var2);
               }

               method_1019(this.method_1021(var3, var2), var2);
               method_1018(this.method_1020(var3, var2), var2);
               if (this.method_1020(var3, var2) != null) {
                  this.method_1024(this.method_1020(var3, var2), var2);
               }
            }
         }
      }

      method_1019(this.field_616[var2.ordinal()], var2);
   }

   // $FF: renamed from: a (org.a.a.a.b.B) void
   private void method_1027(class_150 var1) {
      class_361[] var2 = class_361.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_361 var5 = var2[var4];
         if (class_150.method_420(var1, var5) != null && class_150.method_423(var1, var5) != null) {
            this.method_1029(this.method_1010(var1, var5), var1, var5);
         }

         class_150 var6 = class_150.method_420(var1, var5) != null ? class_150.method_420(var1, var5) : class_150.method_423(var1, var5);
         if (var6 != null) {
            class_150.method_422(var6, class_150.method_426(var1, var5), var5);
            if (class_150.method_426(var1, var5) == null) {
               this.field_616[var5.ordinal()] = var6;
            } else if (var1 == class_150.method_420(class_150.method_426(var1, var5), var5)) {
               class_150.method_421(class_150.method_426(var1, var5), var6, var5);
            } else {
               class_150.method_424(class_150.method_426(var1, var5), var6, var5);
            }

            class_150.method_421(var1, (class_150)null, var5);
            class_150.method_424(var1, (class_150)null, var5);
            class_150.method_422(var1, (class_150)null, var5);
            if (method_1017(var1, var5)) {
               this.method_1028(var6, var5);
            }
         } else if (class_150.method_426(var1, var5) == null) {
            this.field_616[var5.ordinal()] = null;
         } else {
            if (method_1017(var1, var5)) {
               this.method_1028(var1, var5);
            }

            if (class_150.method_426(var1, var5) != null) {
               if (var1 == class_150.method_420(class_150.method_426(var1, var5), var5)) {
                  class_150.method_421(class_150.method_426(var1, var5), (class_150)null, var5);
               } else {
                  class_150.method_424(class_150.method_426(var1, var5), (class_150)null, var5);
               }

               class_150.method_422(var1, (class_150)null, var5);
            }
         }
      }

      this.method_1036();
   }

   // $FF: renamed from: p (org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_1028(class_150 var1, class_361 var2) {
      class_150 var3 = var1;

      while(var3 != this.field_616[var2.ordinal()] && method_1017(var3, var2)) {
         class_150 var4;
         if (class_150.method_432(var3, var2)) {
            var4 = this.method_1022(this.method_1021(var3, var2), var2);
            if (method_1016(var4, var2)) {
               method_1019(var4, var2);
               method_1018(this.method_1021(var3, var2), var2);
               this.method_1024(this.method_1021(var3, var2), var2);
               var4 = this.method_1022(this.method_1021(var3, var2), var2);
            }

            if (method_1017(this.method_1023(var4, var2), var2) && method_1017(this.method_1022(var4, var2), var2)) {
               method_1018(var4, var2);
               var3 = this.method_1021(var3, var2);
            } else {
               if (method_1017(this.method_1022(var4, var2), var2)) {
                  method_1019(this.method_1023(var4, var2), var2);
                  method_1018(var4, var2);
                  this.method_1025(var4, var2);
                  var4 = this.method_1022(this.method_1021(var3, var2), var2);
               }

               this.method_1015(this.method_1021(var3, var2), var4, var2);
               method_1019(this.method_1021(var3, var2), var2);
               method_1019(this.method_1022(var4, var2), var2);
               this.method_1024(this.method_1021(var3, var2), var2);
               var3 = this.field_616[var2.ordinal()];
            }
         } else {
            var4 = this.method_1023(this.method_1021(var3, var2), var2);
            if (method_1016(var4, var2)) {
               method_1019(var4, var2);
               method_1018(this.method_1021(var3, var2), var2);
               this.method_1025(this.method_1021(var3, var2), var2);
               var4 = this.method_1023(this.method_1021(var3, var2), var2);
            }

            if (method_1017(this.method_1022(var4, var2), var2) && method_1017(this.method_1023(var4, var2), var2)) {
               method_1018(var4, var2);
               var3 = this.method_1021(var3, var2);
            } else {
               if (method_1017(this.method_1023(var4, var2), var2)) {
                  method_1019(this.method_1022(var4, var2), var2);
                  method_1018(var4, var2);
                  this.method_1024(var4, var2);
                  var4 = this.method_1023(this.method_1021(var3, var2), var2);
               }

               this.method_1015(this.method_1021(var3, var2), var4, var2);
               method_1019(this.method_1021(var3, var2), var2);
               method_1019(this.method_1023(var4, var2), var2);
               this.method_1025(this.method_1021(var3, var2), var2);
               var3 = this.field_616[var2.ordinal()];
            }
         }
      }

      method_1019(var3, var2);
   }

   // $FF: renamed from: b (org.a.a.a.b.B, org.a.a.a.b.B, org.a.a.a.b.u) void
   private void method_1029(class_150 var1, class_150 var2, class_361 var3) {
      class_150 var4 = class_150.method_426(var1, var3);
      class_150 var5 = class_150.method_420(var1, var3);
      class_150 var6 = class_150.method_423(var1, var3);
      class_150 var7 = class_150.method_426(var2, var3);
      class_150 var8 = class_150.method_420(var2, var3);
      class_150 var9 = class_150.method_423(var2, var3);
      boolean var10 = class_150.method_426(var1, var3) != null && var1 == class_150.method_420(class_150.method_426(var1, var3), var3);
      boolean var11 = class_150.method_426(var2, var3) != null && var2 == class_150.method_420(class_150.method_426(var2, var3), var3);
      if (var1 == var7) {
         class_150.method_422(var1, var2, var3);
         if (var11) {
            class_150.method_421(var2, var1, var3);
            class_150.method_424(var2, var6, var3);
         } else {
            class_150.method_424(var2, var1, var3);
            class_150.method_421(var2, var5, var3);
         }
      } else {
         class_150.method_422(var1, var7, var3);
         if (var7 != null) {
            if (var11) {
               class_150.method_421(var7, var1, var3);
            } else {
               class_150.method_424(var7, var1, var3);
            }
         }

         class_150.method_421(var2, var5, var3);
         class_150.method_424(var2, var6, var3);
      }

      if (var2 == var4) {
         class_150.method_422(var2, var1, var3);
         if (var10) {
            class_150.method_421(var1, var2, var3);
            class_150.method_424(var1, var9, var3);
         } else {
            class_150.method_424(var1, var2, var3);
            class_150.method_421(var1, var8, var3);
         }
      } else {
         class_150.method_422(var2, var4, var3);
         if (var4 != null) {
            if (var10) {
               class_150.method_421(var4, var2, var3);
            } else {
               class_150.method_424(var4, var2, var3);
            }
         }

         class_150.method_421(var1, var8, var3);
         class_150.method_424(var1, var9, var3);
      }

      if (class_150.method_420(var1, var3) != null) {
         class_150.method_422(class_150.method_420(var1, var3), var1, var3);
      }

      if (class_150.method_423(var1, var3) != null) {
         class_150.method_422(class_150.method_423(var1, var3), var1, var3);
      }

      if (class_150.method_420(var2, var3) != null) {
         class_150.method_422(class_150.method_420(var2, var3), var2, var3);
      }

      if (class_150.method_423(var2, var3) != null) {
         class_150.method_422(class_150.method_423(var2, var3), var2, var3);
      }

      class_150.method_434(var1, var2, var3);
      if (this.field_616[var3.ordinal()] == var1) {
         this.field_616[var3.ordinal()] = var2;
      } else if (this.field_616[var3.ordinal()] == var2) {
         this.field_616[var3.ordinal()] = var1;
      }

   }

   // $FF: renamed from: c (java.lang.Object, org.a.a.a.b.u) void
   private static void method_1030(Object var0, class_361 var1) {
      if (var0 == null) {
         throw new NullPointerException(var1 + " cannot be null");
      } else if (!(var0 instanceof Comparable)) {
         throw new ClassCastException(var1 + " must be Comparable");
      }
   }

   // $FF: renamed from: n (java.lang.Object) void
   private static void method_1031(Object var0) {
      method_1030(var0, class_361.field_611);
   }

   // $FF: renamed from: o (java.lang.Object) void
   private static void method_1032(Object var0) {
      method_1030(var0, class_361.field_612);
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) void
   private static void method_1033(Object var0, Object var1) {
      method_1031(var0);
      method_1032(var1);
   }

   // $FF: renamed from: h () void
   private void method_1034() {
      ++this.field_618;
   }

   // $FF: renamed from: i () void
   private void method_1035() {
      this.method_1034();
      ++this.field_617;
   }

   // $FF: renamed from: j () void
   private void method_1036() {
      this.method_1034();
      --this.field_617;
   }

   // $FF: renamed from: b (org.a.a.a.b.B) void
   private void method_1037(class_150 var1) {
      class_150 var2 = this.field_616[class_361.field_612.ordinal()];

      while(true) {
         int var3 = method_1012(var1.method_418(), var2.method_418());
         if (var3 == 0) {
            throw new IllegalArgumentException("Cannot store a duplicate value (\"" + class_150.method_425(var1, class_361.field_612) + "\") in this Map");
         }

         if (var3 < 0) {
            if (class_150.method_420(var2, class_361.field_612) == null) {
               class_150.method_421(var2, var1, class_361.field_612);
               class_150.method_422(var1, var2, class_361.field_612);
               this.method_1026(var1, class_361.field_612);
               break;
            }

            var2 = class_150.method_420(var2, class_361.field_612);
         } else {
            if (class_150.method_423(var2, class_361.field_612) == null) {
               class_150.method_424(var2, var1, class_361.field_612);
               class_150.method_422(var1, var2, class_361.field_612);
               this.method_1026(var1, class_361.field_612);
               break;
            }

            var2 = class_150.method_423(var2, class_361.field_612);
         }
      }

   }

   // $FF: renamed from: d (java.lang.Object, org.a.a.a.b.u) boolean
   private boolean method_1038(Object param1, class_361 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (org.a.a.a.b.u) int
   private int method_1039(class_361 var1) {
      int var2 = 0;
      Object var4;
      Object var5;
      if (this.field_617 > 0) {
         for(class_4 var3 = this.method_1041(var1); var3.hasNext(); var2 += var4.hashCode() ^ var5.hashCode()) {
            var4 = var3.next();
            var5 = var3.method_7();
         }
      }

      return var2;
   }

   // $FF: renamed from: b (org.a.a.a.b.u) java.lang.String
   private String method_1040(class_361 var1) {
      if (this.field_617 == 0) {
         return "{}";
      } else {
         StringBuilder var2 = new StringBuilder(this.field_617 * 32);
         var2.append('{');
         class_4 var3 = this.method_1041(var1);
         boolean var4 = var3.hasNext();

         while(var4) {
            Object var5 = var3.next();
            Object var6 = var3.method_7();
            var2.append(var5 == this ? "(this Map)" : var5).append('=').append(var6 == this ? "(this Map)" : var6);
            var4 = var3.hasNext();
            if (var4) {
               var2.append(", ");
            }
         }

         var2.append('}');
         return var2.toString();
      }
   }

   // $FF: renamed from: c (org.a.a.a.b.u) org.a.a.a.Z
   private class_4 method_1041(class_361 var1) {
      switch(class_360.field_610[var1.ordinal()]) {
      case 1:
         return new class_148(this, class_361.field_611);
      case 2:
         return new class_147(this, class_361.field_612);
      default:
         throw new IllegalArgumentException();
      }
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_1042(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.field_616 = new class_150[2];
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Comparable var4 = (Comparable)var1.readObject();
         Comparable var5 = (Comparable)var1.readObject();
         this.method_996(var4, var5);
      }

   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_1043(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.size());
      Iterator var2 = this.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeObject(var3.getValue());
      }

   }

   // $FF: renamed from: a () org.a.a.a.d
   // $FF: synthetic method
   public class_12 method_12() {
      return this.method_21();
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_11(Object var1) {
      return this.method_999(var1);
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_10(Object var1) {
      return this.method_998(var1);
   }

   // $FF: synthetic method
   public Object put(Object var1, Object var2) {
      return this.method_996((Comparable)var1, (Comparable)var2);
   }

   // $FF: synthetic method
   public Collection values() {
      return this.method_13();
   }

   // $FF: synthetic method
   public Object remove(Object var1) {
      return this.method_997(var1);
   }

   // $FF: synthetic method
   public Object get(Object var1) {
      return this.method_995(var1);
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_19(Object var1) {
      return this.method_1003((Comparable)var1);
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_18(Object var1) {
      return this.method_1002((Comparable)var1);
   }

   // $FF: synthetic method
   public Object lastKey() {
      return this.method_1001();
   }

   // $FF: synthetic method
   public Object firstKey() {
      return this.method_1000();
   }

   // $FF: renamed from: a (java.lang.Object, org.a.a.a.b.u) void
   // $FF: synthetic method
   static void method_1044(Object var0, class_361 var1) {
      method_1030(var0, var1);
   }

   // $FF: renamed from: a (org.a.a.a.b.s, java.lang.Object) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_1045(class_362 var0, Object var1) {
      return var0.method_1008(var1);
   }

   // $FF: renamed from: b (org.a.a.a.b.s, java.lang.Object) java.lang.Comparable
   // $FF: synthetic method
   static Comparable method_1046(class_362 var0, Object var1) {
      return var0.method_1005(var1);
   }

   // $FF: renamed from: c (org.a.a.a.b.s, java.lang.Object) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_1047(class_362 var0, Object var1) {
      return var0.method_1009(var1);
   }

   // $FF: renamed from: d (org.a.a.a.b.s, java.lang.Object) java.lang.Comparable
   // $FF: synthetic method
   static Comparable method_1048(class_362 var0, Object var1) {
      return var0.method_1006(var1);
   }

   // $FF: renamed from: a (org.a.a.a.b.s, org.a.a.a.b.B) void
   // $FF: synthetic method
   static void method_1049(class_362 var0, class_150 var1) {
      var0.method_1027(var1);
   }

   // $FF: renamed from: a (org.a.a.a.b.s) int
   // $FF: synthetic method
   static int method_1050(class_362 var0) {
      return var0.field_618;
   }

   // $FF: renamed from: b (org.a.a.a.b.s) org.a.a.a.b.B[]
   // $FF: synthetic method
   static class_150[] method_1051(class_362 var0) {
      return var0.field_616;
   }

   // $FF: renamed from: a (org.a.a.a.b.s, org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_1052(class_362 var0, class_150 var1, class_361 var2) {
      return var0.method_1013(var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.b.s, org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_1053(class_362 var0, class_150 var1, class_361 var2) {
      return var0.method_1010(var1, var2);
   }

   // $FF: renamed from: c (org.a.a.a.b.s, org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_1054(class_362 var0, class_150 var1, class_361 var2) {
      return var0.method_1011(var1, var2);
   }

   // $FF: renamed from: d (org.a.a.a.b.s, org.a.a.a.b.B, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_1055(class_362 var0, class_150 var1, class_361 var2) {
      return var0.method_1014(var1, var2);
   }

   // $FF: renamed from: c (org.a.a.a.b.s) int
   // $FF: synthetic method
   static int method_1056(class_362 var0) {
      return var0.field_617;
   }

   // $FF: renamed from: i (java.lang.Object) void
   // $FF: synthetic method
   static void method_1057(Object var0) {
      method_1031(var0);
   }

   // $FF: renamed from: a (org.a.a.a.b.s, java.lang.Object, org.a.a.a.b.u) org.a.a.a.b.B
   // $FF: synthetic method
   static class_150 method_1058(class_362 var0, Object var1, class_361 var2) {
      return var0.method_1007(var1, var2);
   }

   // $FF: renamed from: a (org.a.a.a.b.s, java.lang.Comparable, java.lang.Comparable) void
   // $FF: synthetic method
   static void method_1059(class_362 var0, Comparable var1, Comparable var2) {
      var0.method_1004(var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.b.s, java.lang.Object, org.a.a.a.b.u) boolean
   // $FF: synthetic method
   static boolean method_1060(class_362 var0, Object var1, class_361 var2) {
      return var0.method_1038(var1, var2);
   }

   // $FF: renamed from: a (org.a.a.a.b.s, org.a.a.a.b.u) int
   // $FF: synthetic method
   static int method_1061(class_362 var0, class_361 var1) {
      return var0.method_1039(var1);
   }

   // $FF: renamed from: b (org.a.a.a.b.s, org.a.a.a.b.u) java.lang.String
   // $FF: synthetic method
   static String method_1062(class_362 var0, class_361 var1) {
      return var0.method_1040(var1);
   }
}
