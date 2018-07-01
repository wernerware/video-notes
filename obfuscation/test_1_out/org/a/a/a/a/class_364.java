package org.a.a.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

// $FF: renamed from: org.a.a.a.a.h
public class class_364 extends class_363 implements Serializable {
   // $FF: renamed from: a long
   private static final long field_627 = -6561115435802554013L;

   public class_364() {
      super(new HashMap());
   }

   public class_364(Collection var1) {
      this();
      this.addAll(var1);
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_1071(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      super.method_1066(var1);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_1072(ObjectInputStream var1) {
      var1.defaultReadObject();
      super.method_1067(new HashMap(), var1);
   }
}
