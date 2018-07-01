package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import org.a.a.a.class_32;
import org.a.a.a.class_427;

// $FF: renamed from: org.a.a.a.i.ay
class class_262 implements Serializable, class_32 {
   // $FF: renamed from: a long
   private static final long field_387 = 2986114157496788874L;
   // $FF: renamed from: b java.lang.Class
   private final Class field_388;

   public class_262(Class var1) {
      this.field_388 = var1;
   }

   // $FF: renamed from: b () java.util.Collection
   public Collection method_621() {
      try {
         return (Collection)this.field_388.newInstance();
      } catch (Exception var2) {
         throw new class_427("Cannot instantiate class: " + this.field_388, var2);
      }
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_622(ObjectInputStream var1) {
      var1.defaultReadObject();
      if (this.field_388 != null && !Collection.class.isAssignableFrom(this.field_388)) {
         throw new UnsupportedOperationException();
      }
   }

   // $FF: renamed from: a () java.lang.Object
   // $FF: synthetic method
   public Object method_67() {
      return this.method_621();
   }
}
