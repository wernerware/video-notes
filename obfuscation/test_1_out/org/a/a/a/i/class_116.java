package org.a.a.a.i;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: org.a.a.a.i.w
public abstract class class_116 extends class_113 {
   // $FF: renamed from: a java.util.Map
   transient Map field_119;

   protected class_116() {
   }

   protected class_116(Map var1) {
      if (var1 == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         this.field_119 = var1;
      }
   }

   // $FF: renamed from: i () java.util.Map
   protected Map method_258() {
      return this.field_119;
   }

   public void clear() {
      this.method_258().clear();
   }

   public boolean containsKey(Object var1) {
      return this.method_258().containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      return this.method_258().containsValue(var1);
   }

   public Set entrySet() {
      return this.method_258().entrySet();
   }

   public Object get(Object var1) {
      return this.method_258().get(var1);
   }

   public boolean isEmpty() {
      return this.method_258().isEmpty();
   }

   public Set keySet() {
      return this.method_258().keySet();
   }

   public Object put(Object var1, Object var2) {
      return this.method_258().put(var1, var2);
   }

   public void putAll(Map var1) {
      this.method_258().putAll(var1);
   }

   public Object remove(Object var1) {
      return this.method_258().remove(var1);
   }

   public int size() {
      return this.method_258().size();
   }

   public Collection values() {
      return this.method_258().values();
   }

   public boolean equals(Object var1) {
      return var1 == this ? true : this.method_258().equals(var1);
   }

   public int hashCode() {
      return this.method_258().hashCode();
   }

   public String toString() {
      return this.method_258().toString();
   }
}
