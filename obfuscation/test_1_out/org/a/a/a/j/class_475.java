package org.a.a.a.j;

import java.util.Collections;
import java.util.Set;
import org.a.a.a.class_321;

// $FF: renamed from: org.a.a.a.j.v
class class_475 extends class_474 implements Set {
   // $FF: renamed from: a org.a.a.a.j.u
   // $FF: synthetic field
   final class_468 field_867;

   public class_475(class_468 var1, Object var2) {
      super(var1, var2);
      this.field_867 = var1;
   }

   public boolean equals(Object var1) {
      Set var2 = (Set)this.b();
      if (var2 == null) {
         return Collections.emptySet().equals(var1);
      } else if (!(var1 instanceof Set)) {
         return false;
      } else {
         Set var3 = (Set)var1;
         return class_321.method_769(var2, var3);
      }
   }

   public int hashCode() {
      Set var1 = (Set)this.b();
      return class_321.method_770(var1);
   }
}
