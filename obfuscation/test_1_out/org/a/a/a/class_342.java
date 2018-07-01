package org.a.a.a;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: org.a.a.a.aH
class class_342 implements Map, class_8 {
   // $FF: renamed from: a org.a.a.a.ap
   private final class_8 field_569;

   private class_342(class_8 var1) {
      this.field_569 = var1;
   }

   public void clear() {
      this.field_569.clear();
   }

   public boolean containsKey(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean containsValue(Object var1) {
      throw new UnsupportedOperationException();
   }

   public Set entrySet() {
      throw new UnsupportedOperationException();
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else {
         return var1 instanceof class_342 && ((class_342)var1).field_569.equals(this.field_569);
      }
   }

   public Object get(Object var1) {
      throw new UnsupportedOperationException();
   }

   public int hashCode() {
      return "WrappedPut".hashCode() << 4 | this.field_569.hashCode();
   }

   public boolean isEmpty() {
      throw new UnsupportedOperationException();
   }

   public Set keySet() {
      throw new UnsupportedOperationException();
   }

   public Object put(Object var1, Object var2) {
      return this.field_569.put(var1, var2);
   }

   public void putAll(Map var1) {
      this.field_569.putAll(var1);
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public int size() {
      throw new UnsupportedOperationException();
   }

   public Collection values() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   class_342(class_8 var1, class_337 var2) {
      this(var1);
   }
}
