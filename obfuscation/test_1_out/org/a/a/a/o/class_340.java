package org.a.a.a.o;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_21;
import org.a.a.a.class_8;
import org.a.a.a.i.class_154;

// $FF: renamed from: org.a.a.a.o.b
public class class_340 extends class_339 implements Serializable, class_8 {
   // $FF: renamed from: b long
   private static final long field_566 = 5966875321133456994L;
   // $FF: renamed from: c org.a.a.a.aI
   private final class_21 field_567;
   // $FF: renamed from: d org.a.a.a.aI
   private final class_21 field_568;

   // $FF: renamed from: a (java.util.Map, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.o.b
   public static class_340 method_842(Map var0, class_21 var1, class_21 var2) {
      return new class_340(var0, var1, var2);
   }

   protected class_340(Map var1, class_21 var2, class_21 var3) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("KeyTransformer must not be null.");
      } else {
         this.field_567 = var2;
         if (var3 == null) {
            throw new NullPointerException("ValueTransformer must not be null.");
         } else {
            this.field_568 = var3;
         }
      }
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_843(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_844(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_845(Object var1) {
      return this.field_567.method_25(var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   protected Object method_846(Object var1) {
      return this.field_568.method_25(var1);
   }

   // $FF: renamed from: a (java.util.Map) java.util.Map
   protected Map method_847(Map var1) {
      if (var1.isEmpty()) {
         return var1;
      } else {
         class_154 var2 = new class_154(var1.size());
         Iterator var3 = var1.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            var2.put(this.method_845(var4.getKey()), this.method_846(var4.getValue()));
         }

         return var2;
      }
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   protected Object method_848(Object var1) {
      return this.field_568.method_25(var1);
   }

   public Object put(Object var1, Object var2) {
      return this.a().put(this.method_845(var1), this.method_846(var2));
   }

   public void putAll(Map var1) {
      this.a().putAll(this.method_847(var1));
   }

   public void clear() {
      this.a().clear();
   }
}
