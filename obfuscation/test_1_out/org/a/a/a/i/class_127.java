package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.a.a.a.class_29;
import org.a.a.a.c.class_98;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.i.bd
public final class class_127 extends class_123 implements Serializable, class_29 {
   // $FF: renamed from: b long
   private static final long field_128 = 5805344239827376360L;

   // $FF: renamed from: a (java.util.SortedMap) java.util.SortedMap
   public static SortedMap method_285(SortedMap var0) {
      return (SortedMap)(var0 instanceof class_29 ? var0 : new class_127(var0));
   }

   private class_127(SortedMap var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_286(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_287(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Object put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map var1) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public Set entrySet() {
      return class_79.method_159(super.entrySet());
   }

   public Set keySet() {
      return class_74.method_150(super.keySet());
   }

   public Collection values() {
      return class_98.method_216(super.values());
   }

   public Object firstKey() {
      return this.b().firstKey();
   }

   public Object lastKey() {
      return this.b().lastKey();
   }

   public Comparator comparator() {
      return this.b().comparator();
   }

   public SortedMap subMap(Object var1, Object var2) {
      return new class_127(this.b().subMap(var1, var2));
   }

   public SortedMap headMap(Object var1) {
      return new class_127(this.b().headMap(var1));
   }

   public SortedMap tailMap(Object var1) {
      return new class_127(this.b().tailMap(var1));
   }
}
