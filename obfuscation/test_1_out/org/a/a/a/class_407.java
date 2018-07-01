package org.a.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: org.a.a.a.o
class class_407 extends class_406 implements Iterable {
   // $FF: renamed from: c java.util.Set
   private final Set field_716 = new HashSet();
   // $FF: renamed from: d java.util.List
   private final List field_717;

   public class_407(Iterable var1, Iterable var2) {
      super(var1, var2);
      class_415.method_1362(this.field_716, var1);
      class_415.method_1362(this.field_716, var2);
      this.field_717 = new ArrayList(this.field_716.size());
   }

   public Iterator iterator() {
      return this.field_716.iterator();
   }

   // $FF: renamed from: a (java.lang.Object, int) void
   public void method_1295(Object var1, int var2) {
      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_717.add(var1);
      }

   }

   // $FF: renamed from: a () java.util.Collection
   public Collection method_1296() {
      return this.field_717;
   }
}
