package org.a.a.a.i;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.f.class_176;

// $FF: renamed from: org.a.a.a.i.an
class class_178 extends class_176 {
   // $FF: renamed from: a org.a.a.a.i.am
   // $FF: synthetic field
   final class_242 field_233;

   class_178(class_242 var1, Iterator var2) {
      super(var2);
      this.field_233 = var1;
   }

   public Object next() {
      return ((Entry)this.b().next()).getKey();
   }
}
