package org.a.a.a.i;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.i.ba
class class_190 extends class_180 {
   // $FF: renamed from: a org.a.a.a.i.aY
   // $FF: synthetic field
   final class_79 field_257;

   protected class_190(class_79 var1, Iterator var2) {
      super(var2);
      this.field_257 = var1;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_548() {
      return new class_211(this.field_257, (Entry)this.b().next());
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_548();
   }
}
