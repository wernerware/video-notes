package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// $FF: renamed from: org.a.a.a.i.aH
public class class_158 extends class_157 implements Serializable {
   // $FF: renamed from: t long
   private static final long field_199 = 1555089888138299607L;

   public class_158() {
      super(class_491.field_896, class_491.field_897, 16, 0.75F, false);
   }

   public class_158(class_491 var1, class_491 var2) {
      super(var1, var2, 16, 0.75F, false);
   }

   public class_158(class_491 var1, class_491 var2, boolean var3) {
      super(var1, var2, 16, 0.75F, var3);
   }

   public class_158(class_491 var1, class_491 var2, int var3, float var4) {
      super(var1, var2, var3, var4, false);
   }

   public class_158(class_491 var1, class_491 var2, int var3, float var4, boolean var5) {
      super(var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_503(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_504(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a(var1);
   }
}
