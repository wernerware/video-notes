package org.a.a.a.j;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: org.a.a.a.j.f
class class_465 extends AbstractMap {
   // $FF: renamed from: a java.util.Map
   final transient Map field_845;
   // $FF: renamed from: b org.a.a.a.j.d
   // $FF: synthetic field
   final class_467 field_846;

   class_465(class_467 var1, Map var2) {
      this.field_846 = var1;
      this.field_845 = var2;
   }

   public Set entrySet() {
      return new class_466(this);
   }

   public boolean containsKey(Object var1) {
      return this.field_845.containsKey(var1);
   }

   // $FF: renamed from: a (java.lang.Object) java.util.Collection
   public Collection method_1550(Object var1) {
      Collection var2 = (Collection)this.field_845.get(var1);
      return var2 == null ? null : this.field_846.method_1555(var1);
   }

   public Set keySet() {
      return this.field_846.method_48();
   }

   public int size() {
      return this.field_845.size();
   }

   // $FF: renamed from: b (java.lang.Object) java.util.Collection
   public Collection method_1551(Object var1) {
      Collection var2 = (Collection)this.field_845.remove(var1);
      if (var2 == null) {
         return null;
      } else {
         Collection var3 = this.field_846.method_1554();
         var3.addAll(var2);
         var2.clear();
         return var3;
      }
   }

   public boolean equals(Object var1) {
      return this == var1 || this.field_845.equals(var1);
   }

   public int hashCode() {
      return this.field_845.hashCode();
   }

   public String toString() {
      return this.field_845.toString();
   }

   public void clear() {
      this.field_846.method_45();
   }

   // $FF: synthetic method
   public Object remove(Object var1) {
      return this.method_1551(var1);
   }

   // $FF: synthetic method
   public Object get(Object var1) {
      return this.method_1550(var1);
   }
}
