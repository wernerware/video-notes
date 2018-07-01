package org.a.a.a.i;

import java.util.AbstractCollection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.aV
class class_205 extends AbstractCollection {
   // $FF: renamed from: a org.a.a.a.i.aL
   // $FF: synthetic field
   final class_115 field_278;

   private class_205(class_115 var1) {
      this.field_278 = var1;
   }

   public int size() {
      return this.field_278.size();
   }

   public void clear() {
      this.field_278.clear();
   }

   public Iterator iterator() {
      return new class_192(this.field_278, (class_174)null);
   }

   // $FF: synthetic method
   class_205(class_115 var1, class_174 var2) {
      this(var1);
   }
}
