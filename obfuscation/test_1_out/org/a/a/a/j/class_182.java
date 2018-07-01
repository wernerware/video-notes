package org.a.a.a.j;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.f.class_180;
import org.a.a.a.g.class_255;

// $FF: renamed from: org.a.a.a.j.h
class class_182 extends class_180 {
   // $FF: renamed from: a org.a.a.a.j.f
   // $FF: synthetic field
   final class_465 field_238;

   class_182(class_465 var1, Iterator var2) {
      super(var2);
      this.field_238 = var1;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_545() {
      Entry var1 = (Entry)super.next();
      Object var2 = var1.getKey();
      return new class_255(var2, this.field_238.field_846.method_1555(var2));
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_545();
   }
}
