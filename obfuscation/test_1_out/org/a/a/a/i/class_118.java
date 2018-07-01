package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_13;
import org.a.a.a.c.class_98;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.i.S
public class class_118 extends class_116 implements Serializable, class_13 {
   // $FF: renamed from: b long
   private static final long field_122 = 7450927208116179316L;

   // $FF: renamed from: a (java.util.Map) org.a.a.a.i.S
   public static class_118 method_264(Map var0) {
      return new class_118(var0);
   }

   protected class_118(Map var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_265(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_266(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   public Object put(Object var1, Object var2) {
      if (!this.a.containsKey(var1)) {
         throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
      } else {
         return this.a.put(var1, var2);
      }
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.keySet().iterator();

      Object var3;
      do {
         if (!var2.hasNext()) {
            this.a.putAll(var1);
            return;
         }

         var3 = var2.next();
      } while(this.containsKey(var3));

      throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
   }

   public void clear() {
      throw new UnsupportedOperationException("Map is fixed size");
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException("Map is fixed size");
   }

   public Set entrySet() {
      Set var1 = this.a.entrySet();
      return class_74.method_150(var1);
   }

   public Set keySet() {
      Set var1 = this.a.keySet();
      return class_74.method_150(var1);
   }

   public Collection values() {
      Collection var1 = this.a.values();
      return class_98.method_216(var1);
   }

   // $FF: renamed from: a () boolean
   public boolean method_14() {
      return true;
   }

   // $FF: renamed from: a_ () int
   public int method_15() {
      return this.size();
   }
}
