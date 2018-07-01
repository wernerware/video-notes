package org.a.a.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.a.a.a.class_12;

// $FF: renamed from: org.a.a.a.b.n
public class class_355 extends class_353 implements Serializable {
   // $FF: renamed from: g long
   private static final long field_595 = 721969328361808L;

   public class_355() {
      super(new HashMap(), new HashMap());
   }

   public class_355(Map var1) {
      super(new HashMap(), new HashMap());
      this.putAll(var1);
   }

   protected class_355(Map var1, Map var2, class_12 var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: a (java.util.Map, java.util.Map, org.a.a.a.d) org.a.a.a.d
   protected class_12 method_973(Map var1, Map var2, class_12 var3) {
      return new class_355(var1, var2, var3);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_979(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_980(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = new HashMap();
      this.b = new HashMap();
      Map var2 = (Map)var1.readObject();
      this.putAll(var2);
   }
}
