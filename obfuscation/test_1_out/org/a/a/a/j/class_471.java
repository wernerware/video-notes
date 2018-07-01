package org.a.a.a.j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.a.a.a.class_24;

// $FF: renamed from: org.a.a.a.j.w
public class class_471 extends class_470 implements Serializable {
   // $FF: renamed from: a long
   private static final long field_857 = 20151118L;
   // $FF: renamed from: b int
   private static final int field_858 = 16;
   // $FF: renamed from: c int
   private static final int field_859 = 3;
   // $FF: renamed from: d int
   private final int field_860;

   public class_471() {
      this(16, 3);
   }

   public class_471(int var1) {
      this(16, var1);
   }

   public class_471(int var1, int var2) {
      super(new HashMap(var1));
      this.field_860 = var2;
   }

   public class_471(class_24 var1) {
      this(var1.method_33(), 3);
      super.a(var1);
   }

   public class_471(Map var1) {
      this(var1.size(), 3);
      super.a(var1);
   }

   // $FF: renamed from: m () java.util.ArrayList
   protected ArrayList method_1566() {
      return new ArrayList(this.field_860);
   }

   // $FF: renamed from: n () void
   public void method_1567() {
      Iterator var1 = this.j().values().iterator();

      while(var1.hasNext()) {
         Collection var2 = (Collection)var1.next();
         ArrayList var3 = (ArrayList)var2;
         var3.trimToSize();
      }

   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_1568(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.a(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_1569(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.b(new HashMap());
      this.a(var1);
   }

   // $FF: renamed from: k () java.util.List
   // $FF: synthetic method
   protected List method_1564() {
      return this.method_1566();
   }

   // $FF: renamed from: l () java.util.Collection
   // $FF: synthetic method
   protected Collection method_1554() {
      return this.method_1566();
   }
}
