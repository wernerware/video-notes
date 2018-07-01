package org.a.a.a.j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_24;

// $FF: renamed from: org.a.a.a.j.x
public class class_469 extends class_468 implements Serializable {
   // $FF: renamed from: a long
   private static final long field_853 = 20151118L;
   // $FF: renamed from: b int
   private static final int field_854 = 16;
   // $FF: renamed from: c int
   private static final int field_855 = 3;
   // $FF: renamed from: d int
   private final int field_856;

   public class_469() {
      this(16, 3);
   }

   public class_469(int var1) {
      this(16, var1);
   }

   public class_469(int var1, int var2) {
      super(new HashMap(var1));
      this.field_856 = var2;
   }

   public class_469(class_24 var1) {
      this(var1.method_33(), 3);
      super.a(var1);
   }

   public class_469(Map var1) {
      this(var1.size(), 3);
      super.a(var1);
   }

   // $FF: renamed from: m () java.util.HashSet
   protected HashSet method_1561() {
      return new HashSet(this.field_856);
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_1562(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_1563(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.b(new HashMap());
      this.a(var1);
   }

   // $FF: renamed from: k () java.util.Set
   // $FF: synthetic method
   protected Set method_1559() {
      return this.method_1561();
   }

   // $FF: renamed from: l () java.util.Collection
   // $FF: synthetic method
   protected Collection method_1554() {
      return this.method_1561();
   }
}
