package org.a.a.a.n;

import java.util.Collection;
import java.util.Set;
import org.a.a.a.APPARENTLY_REALLY_IMPORTANT;
import org.a.a.a.c.class_81;

// $FF: renamed from: org.a.a.a.n.l
public class class_83 extends class_81 implements Set {
   // $FF: renamed from: b long
   private static final long field_74 = -684521469108685117L;

   // $FF: renamed from: a (java.util.Set, org.a.a.a.an) org.a.a.a.n.l
   public static class_83 method_176(Set var0, APPARENTLY_REALLY_IMPORTANT var1) {
      return new class_83(var0, var1);
   }

   protected class_83(Set var1, APPARENTLY_REALLY_IMPORTANT var2) {
      super(var1, var2);
   }

   // $FF: renamed from: c () java.util.Set
   protected Set method_177() {
      return (Set)super.f();
   }

   public boolean equals(Object var1) {
      return var1 == this || this.method_177().equals(var1);
   }

   public int hashCode() {
      return this.method_177().hashCode();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_177();
   }
}
