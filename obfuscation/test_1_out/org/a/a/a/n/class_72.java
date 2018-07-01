package org.a.a.a.n;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Set;

// $FF: renamed from: org.a.a.a.n.b
public abstract class class_72 extends class_70 {
   // $FF: renamed from: a long
   private static final long field_58 = 1229469966212206107L;

   protected class_72(Set var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_138(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.c());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_139(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
   }
}
