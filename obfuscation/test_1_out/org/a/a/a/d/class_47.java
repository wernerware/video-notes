package org.a.a.a.d;

import java.io.Serializable;
import java.util.Comparator;

// $FF: renamed from: org.a.a.a.d.a
public final class class_47 implements Serializable, Comparator {
   // $FF: renamed from: a long
   private static final long field_24 = 1830042991606340609L;
   // $FF: renamed from: b org.a.a.a.d.a
   private static final class_47 field_25 = new class_47(true);
   // $FF: renamed from: c org.a.a.a.d.a
   private static final class_47 field_26 = new class_47(false);
   // $FF: renamed from: d boolean
   private boolean field_27;

   // $FF: renamed from: a () org.a.a.a.d.a
   public static class_47 method_98() {
      return field_25;
   }

   // $FF: renamed from: b () org.a.a.a.d.a
   public static class_47 method_99() {
      return field_26;
   }

   // $FF: renamed from: a (boolean) org.a.a.a.d.a
   public static class_47 method_100(boolean var0) {
      return var0 ? field_25 : field_26;
   }

   public class_47() {
      this(false);
   }

   public class_47(boolean var1) {
      this.field_27 = false;
      this.field_27 = var1;
   }

   // $FF: renamed from: a (java.lang.Boolean, java.lang.Boolean) int
   public int method_101(Boolean var1, Boolean var2) {
      boolean var3 = var1;
      boolean var4 = var2;
      return var3 ^ var4 ? (var3 ^ this.field_27 ? 1 : -1) : 0;
   }

   public int hashCode() {
      int var1 = "BooleanComparator".hashCode();
      return this.field_27 ? -1 * var1 : var1;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof class_47 && this.field_27 == ((class_47)var1).field_27;
   }

   // $FF: renamed from: c () boolean
   public boolean method_102() {
      return this.field_27;
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.method_101((Boolean)var1, (Boolean)var2);
   }
}
