package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;

// $FF: renamed from: org.a.a.a.i.aG
public class class_159 extends class_157 implements Serializable {
   // $FF: renamed from: t long
   private static final long field_200 = -1266190134568365852L;

   public class_159() {
      super(class_491.field_896, class_491.field_897, 16, 0.75F, false);
   }

   public class_159(class_491 var1, class_491 var2) {
      super(var1, var2, 16, 0.75F, false);
   }

   public class_159(class_491 var1, class_491 var2, boolean var3) {
      super(var1, var2, 16, 0.75F, var3);
   }

   public class_159(class_491 var1, class_491 var2, int var3, float var4) {
      super(var1, var2, var3, var4, false);
   }

   public class_159(class_491 var1, class_491 var2, int var3, float var4, boolean var5) {
      super(var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: b (java.lang.Object) int
   protected int method_438(Object var1) {
      return System.identityHashCode(var1);
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) int
   protected int method_496(Object var1, Object var2) {
      return System.identityHashCode(var1) ^ System.identityHashCode(var2);
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   protected boolean method_439(Object var1, Object var2) {
      var2 = this.a(class_491.field_896) ? var2 : ((Reference)var2).get();
      return var1 == var2;
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   protected boolean method_440(Object var1, Object var2) {
      return var1 == var2;
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_505(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_506(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(var1);
   }
}
