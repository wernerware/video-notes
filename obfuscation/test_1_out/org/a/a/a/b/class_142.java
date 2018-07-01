package org.a.a.a.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_12;
import org.a.a.a.class_18;
import org.a.a.a.class_29;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.f.class_460;
import org.a.a.a.i.class_79;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.b.I
public final class class_142 extends class_141 implements class_29 {
   // $FF: renamed from: b org.a.a.a.b.I
   private class_142 field_148;

   // $FF: renamed from: a (org.a.a.a.aj) org.a.a.a.aj
   public static class_18 method_381(class_18 var0) {
      return (class_18)(var0 instanceof class_29 ? var0 : new class_142(var0));
   }

   private class_142(class_18 var1) {
      super(var1);
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Object put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map var1) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public Set entrySet() {
      Set var1 = super.entrySet();
      return class_79.method_159(var1);
   }

   public Set keySet() {
      Set var1 = super.keySet();
      return class_74.method_150(var1);
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_13() {
      Set var1 = super.b();
      return class_74.method_150(var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_11(Object var1) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: d () org.a.a.a.aj
   public class_18 method_21() {
      return this.method_382();
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      class_7 var1 = this.j().e();
      return class_460.method_1542(var1);
   }

   // $FF: renamed from: f () org.a.a.a.aj
   public class_18 method_382() {
      if (this.field_148 == null) {
         this.field_148 = new class_142(this.j().method_21());
         this.field_148.field_148 = this;
      }

      return this.field_148;
   }

   // $FF: renamed from: a () org.a.a.a.d
   // $FF: synthetic method
   public class_12 method_12() {
      return this.method_21();
   }

   // $FF: synthetic method
   public Collection values() {
      return this.method_13();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }
}
