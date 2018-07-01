package org.a.a.a.o;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_10;
import org.a.a.a.class_4;
import org.a.a.a.i.class_505;

// $FF: renamed from: org.a.a.a.o.a
public class class_339 implements class_10 {
   // $FF: renamed from: a java.util.Map
   transient Map field_565;

   public class_339(Map var1) {
      if (var1 == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         this.field_565 = var1;
      }
   }

   protected class_339() {
   }

   // $FF: renamed from: a () java.util.Map
   protected Map method_841() {
      return this.field_565;
   }

   public boolean containsKey(Object var1) {
      return this.method_841().containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      return this.method_841().containsValue(var1);
   }

   public Set entrySet() {
      return this.method_841().entrySet();
   }

   public Object get(Object var1) {
      return this.method_841().get(var1);
   }

   public Object remove(Object var1) {
      return this.method_841().remove(var1);
   }

   public boolean isEmpty() {
      return this.method_841().isEmpty();
   }

   public Set keySet() {
      return this.method_841().keySet();
   }

   public int size() {
      return this.method_841().size();
   }

   public Collection values() {
      return this.method_841().values();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      return new class_505(this.entrySet());
   }

   public boolean equals(Object var1) {
      return var1 == this ? true : this.method_841().equals(var1);
   }

   public int hashCode() {
      return this.method_841().hashCode();
   }

   public String toString() {
      return this.method_841().toString();
   }
}
