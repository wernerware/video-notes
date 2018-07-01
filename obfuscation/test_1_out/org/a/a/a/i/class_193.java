package org.a.a.a.i;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.aQ
class class_193 extends class_191 implements Iterator {
   // $FF: renamed from: b org.a.a.a.i.aL
   // $FF: synthetic field
   final class_115 field_263;

   private class_193(class_115 var1) {
      super(var1, (class_174)null);
      this.field_263 = var1;
   }

   public Object next() {
      return this.a().getKey();
   }

   // $FF: synthetic method
   class_193(class_115 var1, class_174 var2) {
      this(var1);
   }
}
