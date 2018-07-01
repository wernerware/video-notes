package org.a.a.a;

import java.util.Iterator;
import org.a.a.a.f.class_212;

// $FF: renamed from: org.a.a.a.H
class class_214 extends class_212 {
   // $FF: renamed from: a org.a.a.a.G
   // $FF: synthetic field
   final class_394 field_299;

   class_214(class_394 var1) {
      this.field_299 = var1;
   }

   // $FF: renamed from: a (int) java.util.Iterator
   protected Iterator method_555(int var1) {
      return var1 > this.field_299.field_692.length ? null : this.field_299.field_692[var1 - 1].iterator();
   }
}
