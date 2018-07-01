package org.a.a.a.k;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

// $FF: renamed from: org.a.a.a.k.n
public class class_373 extends class_372 implements Serializable {
   // $FF: renamed from: a long
   private static final long field_652 = 20150610L;

   public class_373() {
      super(new HashMap());
   }

   public class_373(Collection var1) {
      this();
      this.addAll(var1);
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_1103(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      super.method_1096(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_1104(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(new HashMap());
      super.method_1097(var1);
   }
}
