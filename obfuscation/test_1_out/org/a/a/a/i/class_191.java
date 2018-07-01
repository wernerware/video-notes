package org.a.a.a.i;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.aN
class class_191 {
   // $FF: renamed from: b java.util.ArrayList
   private final ArrayList field_258;
   // $FF: renamed from: c int
   private int field_259;
   // $FF: renamed from: d java.util.Map.Entry
   private Entry field_260;
   // $FF: renamed from: a org.a.a.a.i.aL
   // $FF: synthetic field
   final class_115 field_261;

   private class_191(class_115 var1) {
      this.field_261 = var1;
      this.field_258 = new ArrayList();
   }

   public boolean hasNext() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a () java.util.Map.Entry
   protected Entry method_549() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.field_260 = (Entry)this.field_258.remove(this.field_258.size() - 1);
         return this.field_260;
      }
   }

   public void remove() {
      if (this.field_260 == null) {
         throw new IllegalStateException();
      } else {
         this.field_261.remove(this.field_260.getKey());
         this.field_260 = null;
      }
   }

   // $FF: synthetic method
   class_191(class_115 var1, class_174 var2) {
      this(var1);
   }
}
