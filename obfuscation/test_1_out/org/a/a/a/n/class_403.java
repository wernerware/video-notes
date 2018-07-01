package org.a.a.a.n;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: org.a.a.a.n.j
public final class class_403 implements Serializable, Set {
   // $FF: renamed from: a long
   private static final long field_710 = 6723912213766056587L;
   // $FF: renamed from: b java.util.Map
   private final Map field_711;
   // $FF: renamed from: c java.lang.Object
   private final Object field_712;

   // $FF: renamed from: a (java.util.Map) org.a.a.a.n.j
   public static class_403 method_1278(Map var0) {
      return method_1279(var0, (Object)null);
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Object) org.a.a.a.n.j
   public static class_403 method_1279(Map var0, Object var1) {
      return new class_403(var0, var1);
   }

   private class_403(Map var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException("The map must not be null");
      } else {
         this.field_711 = var1;
         this.field_712 = var2;
      }
   }

   public int size() {
      return this.field_711.size();
   }

   public boolean isEmpty() {
      return this.field_711.isEmpty();
   }

   public Iterator iterator() {
      return this.field_711.keySet().iterator();
   }

   public boolean contains(Object var1) {
      return this.field_711.containsKey(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.field_711.keySet().containsAll(var1);
   }

   public boolean add(Object var1) {
      int var2 = this.field_711.size();
      this.field_711.put(var1, this.field_712);
      return this.field_711.size() != var2;
   }

   public boolean addAll(Collection var1) {
      int var2 = this.field_711.size();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         this.field_711.put(var4, this.field_712);
      }

      return this.field_711.size() != var2;
   }

   public boolean remove(Object var1) {
      int var2 = this.field_711.size();
      this.field_711.remove(var1);
      return this.field_711.size() != var2;
   }

   public boolean removeAll(Collection var1) {
      return this.field_711.keySet().removeAll(var1);
   }

   public boolean retainAll(Collection var1) {
      return this.field_711.keySet().retainAll(var1);
   }

   public void clear() {
      this.field_711.clear();
   }

   public Object[] toArray() {
      return this.field_711.keySet().toArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.field_711.keySet().toArray(var1);
   }

   public boolean equals(Object var1) {
      return this.field_711.keySet().equals(var1);
   }

   public int hashCode() {
      return this.field_711.keySet().hashCode();
   }
}
