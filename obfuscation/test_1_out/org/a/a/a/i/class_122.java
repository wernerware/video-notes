package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_15;
import org.a.a.a.class_29;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.c.class_98;
import org.a.a.a.f.class_460;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.i.bc
public final class class_122 extends class_121 implements Serializable, class_29 {
   // $FF: renamed from: b long
   private static final long field_126 = 8136428161720526266L;

   // $FF: renamed from: a (org.a.a.a.al) org.a.a.a.al
   public static class_15 method_276(class_15 var0) {
      return (class_15)(var0 instanceof class_29 ? var0 : new class_122(var0));
   }

   private class_122(class_15 var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_277(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_278(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      class_7 var1 = this.a().method_17();
      return class_460.method_1542(var1);
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

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }
}
