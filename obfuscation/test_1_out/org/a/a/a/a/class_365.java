package org.a.a.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.a.a.a.class_23;

// $FF: renamed from: org.a.a.a.a.p
public class class_365 extends class_363 implements Serializable, class_23 {
   // $FF: renamed from: a long
   private static final long field_628 = -7740146511091606676L;

   public class_365() {
      super(new TreeMap());
   }

   public class_365(Comparator var1) {
      super(new TreeMap(var1));
   }

   public class_365(Collection var1) {
      this();
      this.addAll(var1);
   }

   public boolean add(Object var1) {
      if (this.method_30() == null && !(var1 instanceof Comparable)) {
         if (var1 == null) {
            throw new NullPointerException();
         } else {
            throw new IllegalArgumentException("Objects of type " + var1.getClass() + " cannot be added to " + "a naturally ordered TreeBag as it does not implement Comparable");
         }
      } else {
         return super.add(var1);
      }
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_31() {
      return this.method_1073().firstKey();
   }

   // $FF: renamed from: d () java.lang.Object
   public Object method_32() {
      return this.method_1073().lastKey();
   }

   // $FF: renamed from: b () java.util.Comparator
   public Comparator method_30() {
      return this.method_1073().comparator();
   }

   // $FF: renamed from: f () java.util.SortedMap
   protected SortedMap method_1073() {
      return (SortedMap)super.method_1063();
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_1074(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.method_30());
      super.method_1066(var1);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_1075(ObjectInputStream var1) {
      var1.defaultReadObject();
      Comparator var2 = (Comparator)var1.readObject();
      super.method_1067(new TreeMap(var2), var1);
   }

   // $FF: renamed from: e () java.util.Map
   // $FF: synthetic method
   protected Map method_1063() {
      return this.method_1073();
   }
}
