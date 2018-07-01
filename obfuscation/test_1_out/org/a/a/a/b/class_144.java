package org.a.a.a.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.a.a.a.class_12;
import org.a.a.a.class_18;
import org.a.a.a.class_19;
import org.a.a.a.class_29;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.f.class_460;
import org.a.a.a.i.class_127;
import org.a.a.a.i.class_79;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.b.J
public final class class_144 extends class_143 implements class_29 {
   // $FF: renamed from: b org.a.a.a.b.J
   private class_144 field_149;

   // $FF: renamed from: a (org.a.a.a.aD) org.a.a.a.aD
   public static class_19 method_384(class_19 var0) {
      return (class_19)(var0 instanceof class_29 ? var0 : new class_144(var0));
   }

   private class_144(class_19 var1) {
      super(var1);
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
      Set var1 = super.entrySet();
      return class_79.method_159(var1);
   }

   public Set keySet() {
      Set var1 = super.keySet();
      return class_74.method_150(var1);
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_13() {
      Set var1 = super.b();
      return class_74.method_150(var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_11(Object var1) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      class_7 var1 = this.k().e();
      return class_460.method_1542(var1);
   }

   // $FF: renamed from: f () org.a.a.a.aD
   public class_19 method_22() {
      if (this.field_149 == null) {
         this.field_149 = new class_144(this.k().method_22());
         this.field_149.field_149 = this;
      }

      return this.field_149;
   }

   public SortedMap subMap(Object var1, Object var2) {
      SortedMap var3 = this.k().subMap(var1, var2);
      return class_127.method_285(var3);
   }

   public SortedMap headMap(Object var1) {
      SortedMap var2 = this.k().headMap(var1);
      return class_127.method_285(var2);
   }

   public SortedMap tailMap(Object var1) {
      SortedMap var2 = this.k().tailMap(var1);
      return class_127.method_285(var2);
   }

   // $FF: renamed from: d () org.a.a.a.aj
   // $FF: synthetic method
   public class_18 method_21() {
      return this.method_22();
   }

   // $FF: renamed from: a () org.a.a.a.d
   // $FF: synthetic method
   public class_12 method_12() {
      return this.method_22();
   }

   // $FF: synthetic method
   public Collection values() {
      return this.method_13();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }
}
