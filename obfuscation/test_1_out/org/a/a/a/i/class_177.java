package org.a.a.a.i;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.f.class_176;

// $FF: renamed from: org.a.a.a.i.as
class class_177 extends class_176 {
   // $FF: renamed from: a org.a.a.a.i.ar
   // $FF: synthetic field
   final class_259 field_232;

   class_177(class_259 var1, Iterator var2) {
      super(var2);
      this.field_232 = var1;
   }

   public Object next() {
      return ((Entry)this.b().next()).getValue();
   }
}
