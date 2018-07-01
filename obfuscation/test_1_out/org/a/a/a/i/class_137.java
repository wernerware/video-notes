package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_1;

// $FF: renamed from: org.a.a.a.i.aE
public class class_137 extends class_134 implements Serializable {
   // $FF: renamed from: d long
   private static final long field_143 = 7412622456128415156L;
   // $FF: renamed from: b org.a.a.a.an
   protected final class_1 field_144;
   // $FF: renamed from: c org.a.a.a.an
   protected final class_1 field_145;

   // $FF: renamed from: a (java.util.Map, org.a.a.a.an, org.a.a.a.an) org.a.a.a.i.aE
   public static class_137 method_372(Map var0, class_1 var1, class_1 var2) {
      return new class_137(var0, var1, var2);
   }

   protected class_137(Map var1, class_1 var2, class_1 var3) {
      super(var1);
      this.field_144 = var2;
      this.field_145 = var3;
      Iterator var4 = var1.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         this.method_375(var5.getKey(), var5.getValue());
      }

   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_373(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_374(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) void
   protected void method_375(Object var1, Object var2) {
      if (this.field_144 != null && !this.field_144.method_3(var1)) {
         throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
      } else if (this.field_145 != null && !this.field_145.method_3(var2)) {
         throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_360(Object var1) {
      if (!this.field_145.method_3(var1)) {
         throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
      } else {
         return var1;
      }
   }

   // $FF: renamed from: a () boolean
   protected boolean method_361() {
      return this.field_145 != null;
   }

   public Object put(Object var1, Object var2) {
      this.method_375(var1, var2);
      return this.a.put(var1, var2);
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.method_375(var3.getKey(), var3.getValue());
      }

      super.putAll(var1);
   }
}
