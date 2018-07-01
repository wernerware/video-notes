package org.a.a.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.a.a.a.class_12;
import org.a.a.a.class_15;
import org.a.a.a.class_18;
import org.a.a.a.class_19;
import org.a.a.a.class_4;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.b.p
public class class_356 extends class_353 implements Serializable, class_19 {
   // $FF: renamed from: g long
   private static final long field_596 = 721969328361809L;
   // $FF: renamed from: h java.util.Comparator
   private final Comparator field_597;
   // $FF: renamed from: i java.util.Comparator
   private final Comparator field_598;

   public class_356() {
      super(new TreeMap(), new TreeMap());
      this.field_597 = null;
      this.field_598 = null;
   }

   public class_356(Map var1) {
      super(new TreeMap(), new TreeMap());
      this.putAll(var1);
      this.field_597 = null;
      this.field_598 = null;
   }

   public class_356(Comparator var1, Comparator var2) {
      super(new TreeMap(var1), new TreeMap(var2));
      this.field_597 = var1;
      this.field_598 = var2;
   }

   protected class_356(Map var1, Map var2, class_12 var3) {
      super(var1, var2, var3);
      this.field_597 = ((SortedMap)var1).comparator();
      this.field_598 = ((SortedMap)var2).comparator();
   }

   // $FF: renamed from: b (java.util.Map, java.util.Map, org.a.a.a.d) org.a.a.a.b.p
   protected class_356 method_981(Map var1, Map var2, class_12 var3) {
      return new class_356(var1, var2, var3);
   }

   public Comparator comparator() {
      return ((SortedMap)this.a).comparator();
   }

   // $FF: renamed from: g () java.util.Comparator
   public Comparator method_23() {
      return ((SortedMap)this.b).comparator();
   }

   public Object firstKey() {
      return ((SortedMap)this.a).firstKey();
   }

   public Object lastKey() {
      return ((SortedMap)this.a).lastKey();
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      if (this.isEmpty()) {
         return null;
      } else if (this.a instanceof class_15) {
         return ((class_15)this.a).method_18(var1);
      } else {
         SortedMap var2 = (SortedMap)this.a;
         Iterator var3 = var2.tailMap(var1).keySet().iterator();
         var3.next();
         return var3.hasNext() ? var3.next() : null;
      }
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      if (this.isEmpty()) {
         return null;
      } else if (this.a instanceof class_15) {
         return ((class_15)this.a).method_19(var1);
      } else {
         SortedMap var2 = (SortedMap)this.a;
         SortedMap var3 = var2.headMap(var1);
         return var3.isEmpty() ? null : var3.lastKey();
      }
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return new class_357(this);
   }

   // $FF: renamed from: h () org.a.a.a.aD
   public class_19 method_982() {
      return this.method_22();
   }

   // $FF: renamed from: i () org.a.a.a.aj
   public class_18 method_983() {
      return this.method_22();
   }

   public SortedMap headMap(Object var1) {
      SortedMap var2 = ((SortedMap)this.a).headMap(var1);
      return new class_125(this, var2);
   }

   public SortedMap tailMap(Object var1) {
      SortedMap var2 = ((SortedMap)this.a).tailMap(var1);
      return new class_125(this, var2);
   }

   public SortedMap subMap(Object var1, Object var2) {
      SortedMap var3 = ((SortedMap)this.a).subMap(var1, var2);
      return new class_125(this, var3);
   }

   // $FF: renamed from: f () org.a.a.a.aD
   public class_19 method_22() {
      return (class_19)super.method_12();
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_984(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_985(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = new TreeMap(this.field_597);
      this.b = new TreeMap(this.field_598);
      Map var2 = (Map)var1.readObject();
      this.putAll(var2);
   }

   // $FF: renamed from: a () org.a.a.a.d
   // $FF: synthetic method
   public class_12 method_12() {
      return this.method_22();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }

   // $FF: renamed from: a (java.util.Map, java.util.Map, org.a.a.a.d) org.a.a.a.d
   // $FF: synthetic method
   protected class_12 method_973(Map var1, Map var2, class_12 var3) {
      return this.method_981(var1, var2, var3);
   }

   // $FF: renamed from: d () org.a.a.a.aj
   // $FF: synthetic method
   public class_18 method_21() {
      return this.method_22();
   }
}
