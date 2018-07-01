package org.a.a.a.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_12;
import org.a.a.a.class_29;
import org.a.a.a.class_4;
import org.a.a.a.f.class_459;
import org.a.a.a.i.class_79;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.b.H
public final class class_140 extends class_139 implements class_29 {
   // $FF: renamed from: b org.a.a.a.b.H
   private class_140 field_147;

   // $FF: renamed from: a (org.a.a.a.d) org.a.a.a.d
   public static class_12 method_379(class_12 var0) {
      return (class_12)(var0 instanceof class_29 ? var0 : new class_140(var0));
   }

   private class_140(class_12 var1) {
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
      Set var1 = super.method_13();
      return class_74.method_150(var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_11(Object var1) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      class_4 var1 = this.h().c();
      return class_459.method_1541(var1);
   }

   // $FF: renamed from: a () org.a.a.a.d
   public synchronized class_12 method_12() {
      if (this.field_147 == null) {
         this.field_147 = new class_140(this.h().method_12());
         this.field_147.field_147 = this;
      }

      return this.field_147;
   }

   // $FF: synthetic method
   public Collection values() {
      return this.method_13();
   }
}
