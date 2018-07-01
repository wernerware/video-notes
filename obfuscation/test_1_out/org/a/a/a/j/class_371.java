package org.a.a.a.j;

import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.class_401;
import org.a.a.a.k.class_370;

// $FF: renamed from: org.a.a.a.j.l
class class_371 extends class_370 {
   // $FF: renamed from: a org.a.a.a.j.d
   // $FF: synthetic field
   final class_467 field_648;

   private class_371(class_467 var1) {
      this.field_648 = var1;
   }

   public boolean contains(Object var1) {
      return this.field_648.method_1552().containsKey(var1);
   }

   public boolean isEmpty() {
      return this.field_648.method_1552().isEmpty();
   }

   public int size() {
      return this.field_648.method_33();
   }

   // $FF: renamed from: c () int
   protected int method_1094() {
      return this.field_648.method_1552().size();
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_58(Object var1) {
      int var2 = 0;
      Collection var3 = (Collection)this.field_648.method_1552().get(var1);
      if (var3 != null) {
         var2 = var3.size();
      }

      return var2;
   }

   // $FF: renamed from: d () java.util.Iterator
   protected Iterator method_1095() {
      class_483 var1 = new class_483(this, (class_472)null);
      return class_401.method_1199(class_467.method_1558(this.field_648).entrySet().iterator(), var1);
   }

   // $FF: synthetic method
   class_371(class_467 var1, class_472 var2) {
      this(var1);
   }
}
