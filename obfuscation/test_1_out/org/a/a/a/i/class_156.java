package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

// $FF: renamed from: org.a.a.a.i.ae
public class class_156 extends class_151 implements Serializable, Cloneable {
   // $FF: renamed from: t long
   private static final long field_194 = -1788199231038721040L;

   public class_156() {
      super(16, 0.75F, 12);
   }

   public class_156(int var1) {
      super(var1);
   }

   public class_156(int var1, float var2) {
      super(var1, var2);
   }

   public class_156(Map var1) {
      super(var1);
   }

   // $FF: renamed from: a () org.a.a.a.i.ae
   public class_156 method_489() {
      return (class_156)super.method_464();
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_490(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_491(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(var1);
   }

   // $FF: renamed from: j () org.a.a.a.i.a
   // $FF: synthetic method
   public class_151 method_464() {
      return this.method_489();
   }

   // $FF: synthetic method
   public Object clone() {
      return this.method_489();
   }
}
