package org.a.a.a.h;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;

// $FF: renamed from: org.a.a.a.h.g
public abstract class class_50 extends class_49 {
   // $FF: renamed from: a long
   private static final long field_31 = 2684959196747496299L;

   protected class_50(List var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_106(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.c());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_107(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
   }
}
