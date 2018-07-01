package org.a.a.a.i;

import org.a.a.a.g.class_252;

// $FF: renamed from: org.a.a.a.i.ap
class class_256 extends class_252 {
   // $FF: renamed from: a org.a.a.a.i.ak
   private final class_131 field_374;

   class_256(class_131 var1, Object var2) {
      super(var2, (Object)null);
      this.field_374 = var1;
   }

   public Object getValue() {
      return this.field_374.get(this.getKey());
   }

   public Object setValue(Object var1) {
      return this.field_374.i().put(this.getKey(), var1);
   }
}
