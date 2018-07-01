package org.a.a.a.b;

import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: org.a.a.a.b.f
public class class_68 extends class_66 implements Set {
   // $FF: renamed from: b long
   private static final long field_52 = -7107935777385040694L;

   protected class_68(class_353 var1) {
      super(var1.field_588.keySet(), var1);
   }

   public Iterator iterator() {
      return this.a.method_974(super.iterator());
   }

   public boolean contains(Object var1) {
      return this.a.field_588.containsKey(var1);
   }

   public boolean remove(Object var1) {
      if (this.a.field_588.containsKey(var1)) {
         Object var2 = this.a.field_588.remove(var1);
         this.a.field_589.remove(var2);
         return true;
      } else {
         return false;
      }
   }
}
