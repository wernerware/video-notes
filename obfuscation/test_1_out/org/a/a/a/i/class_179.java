package org.a.a.a.i;

import java.util.List;
import java.util.Map.Entry;
import org.a.a.a.f.class_176;

// $FF: renamed from: org.a.a.a.i.ao
class class_179 extends class_176 {
   // $FF: renamed from: a org.a.a.a.i.ak
   private final class_131 field_234;
   // $FF: renamed from: b java.lang.Object
   private Object field_235 = null;

   class_179(class_131 var1, List var2) {
      super(var2.iterator());
      this.field_234 = var1;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_543() {
      this.field_235 = this.b().next();
      return new class_256(this.field_234, this.field_235);
   }

   public void remove() {
      super.remove();
      this.field_234.i().remove(this.field_235);
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_543();
   }
}
