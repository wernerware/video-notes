package org.a.a.a.f;

import java.util.Iterator;
import org.a.a.a.class_21;

// $FF: renamed from: org.a.a.a.f.N
public class class_463 implements Iterator {
   // $FF: renamed from: a java.util.Iterator
   private Iterator field_842;
   // $FF: renamed from: b org.a.a.a.aI
   private class_21 field_843;

   public class_463() {
   }

   public class_463(Iterator var1) {
      this.field_842 = var1;
   }

   public class_463(Iterator var1, class_21 var2) {
      this.field_842 = var1;
      this.field_843 = var2;
   }

   public boolean hasNext() {
      return this.field_842.hasNext();
   }

   public Object next() {
      return this.method_1549(this.field_842.next());
   }

   public void remove() {
      this.field_842.remove();
   }

   // $FF: renamed from: a () java.util.Iterator
   public Iterator method_1545() {
      return this.field_842;
   }

   // $FF: renamed from: a (java.util.Iterator) void
   public void method_1546(Iterator var1) {
      this.field_842 = var1;
   }

   // $FF: renamed from: b () org.a.a.a.aI
   public class_21 method_1547() {
      return this.field_843;
   }

   // $FF: renamed from: a (org.a.a.a.aI) void
   public void method_1548(class_21 var1) {
      this.field_843 = var1;
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_1549(Object var1) {
      return this.field_843.method_25(var1);
   }
}
