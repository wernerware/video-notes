package org.a.a.a.p;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.a.a.a.class_17;
import org.a.a.a.class_29;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.f.class_460;

// $FF: renamed from: org.a.a.a.p.y
public class class_332 implements Serializable, class_17, class_29 {
   // $FF: renamed from: a long
   private static final long field_553 = -7156426030315945159L;
   // $FF: renamed from: b org.a.a.a.aK
   private final class_17 field_554;

   // $FF: renamed from: a (org.a.a.a.aK) org.a.a.a.aK
   public static class_17 method_824(class_17 var0) {
      return (class_17)(var0 instanceof class_29 ? var0 : new class_332(var0));
   }

   public class_332(class_17 var1) {
      if (var1 == null) {
         throw new NullPointerException("Trie must not be null");
      } else {
         this.field_554 = var1;
      }
   }

   public Set entrySet() {
      return Collections.unmodifiableSet(this.field_554.entrySet());
   }

   public Set keySet() {
      return Collections.unmodifiableSet(this.field_554.keySet());
   }

   public Collection values() {
      return Collections.unmodifiableCollection(this.field_554.values());
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean containsKey(Object var1) {
      return this.field_554.containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      return this.field_554.containsValue(var1);
   }

   public Object get(Object var1) {
      return this.field_554.get(var1);
   }

   public boolean isEmpty() {
      return this.field_554.isEmpty();
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

   public int size() {
      return this.field_554.size();
   }

   public Object firstKey() {
      return this.field_554.firstKey();
   }

   public SortedMap headMap(Object var1) {
      return Collections.unmodifiableSortedMap(this.field_554.headMap(var1));
   }

   public Object lastKey() {
      return this.field_554.lastKey();
   }

   public SortedMap subMap(Object var1, Object var2) {
      return Collections.unmodifiableSortedMap(this.field_554.subMap(var1, var2));
   }

   public SortedMap tailMap(Object var1) {
      return Collections.unmodifiableSortedMap(this.field_554.tailMap(var1));
   }

   // $FF: renamed from: a (java.lang.Object) java.util.SortedMap
   public SortedMap method_20(Object var1) {
      return Collections.unmodifiableSortedMap(this.field_554.method_20(var1));
   }

   public Comparator comparator() {
      return this.field_554.comparator();
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      class_7 var1 = this.field_554.e();
      return class_460.method_1542(var1);
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      return this.field_554.c(var1);
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      return this.field_554.d(var1);
   }

   public int hashCode() {
      return this.field_554.hashCode();
   }

   public boolean equals(Object var1) {
      return this.field_554.equals(var1);
   }

   public String toString() {
      return this.field_554.toString();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }
}
