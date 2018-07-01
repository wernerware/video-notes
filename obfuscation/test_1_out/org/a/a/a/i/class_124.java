package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.a.a.a.class_13;
import org.a.a.a.class_415;
import org.a.a.a.c.class_98;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.i.T
public class class_124 extends class_123 implements Serializable, class_13 {
   // $FF: renamed from: b long
   private static final long field_127 = 3126019624511683653L;

   // $FF: renamed from: a (java.util.SortedMap) org.a.a.a.i.T
   public static class_124 method_280(SortedMap var0) {
      return new class_124(var0);
   }

   protected class_124(SortedMap var1) {
      super(var1);
   }

   // $FF: renamed from: d () java.util.SortedMap
   protected SortedMap method_281() {
      return (SortedMap)this.a;
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_282(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_283(ObjectInputStream var1) {
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
      if (class_415.method_1336(var1.keySet(), this.keySet())) {
         throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
      } else {
         this.a.putAll(var1);
      }
   }

   public void clear() {
      throw new UnsupportedOperationException("Map is fixed size");
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException("Map is fixed size");
   }

   public Set entrySet() {
      return class_74.method_150(this.a.entrySet());
   }

   public Set keySet() {
      return class_74.method_150(this.a.keySet());
   }

   public Collection values() {
      return class_98.method_216(this.a.values());
   }

   public SortedMap subMap(Object var1, Object var2) {
      return new class_124(this.method_281().subMap(var1, var2));
   }

   public SortedMap headMap(Object var1) {
      return new class_124(this.method_281().headMap(var1));
   }

   public SortedMap tailMap(Object var1) {
      return new class_124(this.method_281().tailMap(var1));
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
