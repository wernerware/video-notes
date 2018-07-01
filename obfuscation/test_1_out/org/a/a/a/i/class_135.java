package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.i.aW
public class class_135 extends class_134 implements Serializable {
   // $FF: renamed from: d long
   private static final long field_139 = 7023152376788900464L;
   // $FF: renamed from: b org.a.a.a.aI
   protected final class_21 field_140;
   // $FF: renamed from: c org.a.a.a.aI
   protected final class_21 field_141;

   // $FF: renamed from: a (java.util.Map, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.i.aW
   public static class_135 method_362(Map var0, class_21 var1, class_21 var2) {
      return new class_135(var0, var1, var2);
   }

   // $FF: renamed from: b (java.util.Map, org.a.a.a.aI, org.a.a.a.aI) org.a.a.a.i.aW
   public static class_135 method_363(Map var0, class_21 var1, class_21 var2) {
      class_135 var3 = new class_135(var0, var1, var2);
      if (var0.size() > 0) {
         Map var4 = var3.method_368(var0);
         var3.clear();
         var3.i().putAll(var4);
      }

      return var3;
   }

   protected class_135(Map var1, class_21 var2, class_21 var3) {
      super(var1);
      this.field_140 = var2;
      this.field_141 = var3;
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_364(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_365(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   protected Object method_366(Object var1) {
      return this.field_140 == null ? var1 : this.field_140.method_25(var1);
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   protected Object method_367(Object var1) {
      return this.field_141 == null ? var1 : this.field_141.method_25(var1);
   }

   // $FF: renamed from: a (java.util.Map) java.util.Map
   protected Map method_368(Map var1) {
      if (var1.isEmpty()) {
         return var1;
      } else {
         class_154 var2 = new class_154(var1.size());
         Iterator var3 = var1.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            var2.put(this.method_366(var4.getKey()), this.method_367(var4.getValue()));
         }

         return var2;
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_360(Object var1) {
      return this.field_141.method_25(var1);
   }

   // $FF: renamed from: a () boolean
   protected boolean method_361() {
      return this.field_141 != null;
   }

   public Object put(Object var1, Object var2) {
      var1 = this.method_366(var1);
      var2 = this.method_367(var2);
      return this.i().put(var1, var2);
   }

   public void putAll(Map var1) {
      var1 = this.method_368(var1);
      this.i().putAll(var1);
   }
}
