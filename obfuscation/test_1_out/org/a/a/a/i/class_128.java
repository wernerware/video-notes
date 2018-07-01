package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_11;
import org.a.a.a.class_29;
import org.a.a.a.class_4;
import org.a.a.a.c.class_98;
import org.a.a.a.f.class_230;
import org.a.a.a.f.class_459;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.i.bb
public final class class_128 extends class_116 implements Serializable, class_29 {
   // $FF: renamed from: b long
   private static final long field_129 = 2737023427269031941L;

   // $FF: renamed from: a (java.util.Map) java.util.Map
   public static Map method_288(Map var0) {
      return (Map)(var0 instanceof class_29 ? var0 : new class_128(var0));
   }

   private class_128(Map var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_289(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_290(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Object put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map var1) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      if (this.a instanceof class_11) {
         class_4 var2 = ((class_11)this.a).c();
         return class_459.method_1541(var2);
      } else {
         class_230 var1 = new class_230(this.a);
         return class_459.method_1541(var1);
      }
   }

   public Set entrySet() {
      Set var1 = super.entrySet();
      return class_79.method_159(var1);
   }

   public Set keySet() {
      Set var1 = super.keySet();
      return class_74.method_150(var1);
   }

   public Collection values() {
      Collection var1 = super.values();
      return class_98.method_216(var1);
   }
}
