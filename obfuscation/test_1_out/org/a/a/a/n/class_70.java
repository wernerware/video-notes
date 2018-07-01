package org.a.a.a.n;

import java.util.Collection;
import java.util.Set;
import org.a.a.a.c.class_48;

// $FF: renamed from: org.a.a.a.n.c
public abstract class class_70 extends class_48 implements Set {
   // $FF: renamed from: a long
   private static final long field_54 = -4678668309576958546L;

   protected class_70() {
   }

   protected class_70(Set var1) {
      super(var1);
   }

   // $FF: renamed from: c () java.util.Set
   protected Set method_137() {
      return (Set)super.method_103();
   }

   public boolean equals(Object var1) {
      return var1 == this || this.method_137().equals(var1);
   }

   public int hashCode() {
      return this.method_137().hashCode();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_137();
   }
}
