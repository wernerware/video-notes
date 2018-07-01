package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

// $FF: renamed from: org.a.a.a.i.ai
public class class_154 extends class_153 implements Serializable, Cloneable {
   // $FF: renamed from: u long
   private static final long field_189 = 9077234323521161066L;

   public class_154() {
      super(16, 0.75F, 12);
   }

   public class_154(int var1) {
      super(var1);
   }

   public class_154(int var1, float var2) {
      super(var1, var2);
   }

   public class_154(Map var1) {
      super(var1);
   }

   // $FF: renamed from: a () org.a.a.a.i.ai
   public class_154 method_473() {
      return (class_154)super.j();
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_474(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_475(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(var1);
   }

   // $FF: renamed from: d (int) java.lang.Object
   public Object method_476(int var1) {
      return this.c(var1).getKey();
   }

   // $FF: renamed from: e (int) java.lang.Object
   public Object method_477(int var1) {
      return this.c(var1).getValue();
   }

   // $FF: renamed from: g (java.lang.Object) int
   public int method_478(Object var1) {
      var1 = this.a(var1);
      int var2 = 0;

      for(class_497 var3 = this.t.field_908; var3 != this.t; ++var2) {
         if (this.a(var1, var3.c)) {
            return var2;
         }

         var3 = var3.field_908;
      }

      return -1;
   }

   // $FF: renamed from: f (int) java.lang.Object
   public Object method_479(int var1) {
      return this.remove(this.method_476(var1));
   }

   // $FF: renamed from: b () java.util.List
   public List method_480() {
      return new class_240(this);
   }

   // $FF: renamed from: j () org.a.a.a.i.a
   // $FF: synthetic method
   public class_151 method_464() {
      return this.method_473();
   }

   // $FF: synthetic method
   public Object clone() {
      return this.method_473();
   }
}
