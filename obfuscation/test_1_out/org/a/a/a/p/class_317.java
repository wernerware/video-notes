package org.a.a.a.p;

import java.util.NoSuchElementException;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.p.o
final class class_317 extends class_311 {
   // $FF: renamed from: f java.lang.Object
   private final Object field_519;
   // $FF: renamed from: a org.a.a.a.p.n
   // $FF: synthetic field
   final class_323 field_520;

   private class_317(class_323 var1, class_301 var2, class_301 var3) {
      super(var1.field_541, var2);
      this.field_520 = var1;
      this.field_519 = var3 != null ? var3.getKey() : null;
   }

   public boolean hasNext() {
      return this.c != null && !class_302.method_711(this.c.a, this.field_519);
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_750() {
      if (this.c != null && !class_302.method_711(this.c.a, this.field_519)) {
         return this.c();
      } else {
         throw new NoSuchElementException();
      }
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_750();
   }

   // $FF: synthetic method
   class_317(class_323 var1, class_301 var2, class_301 var3, class_330 var4) {
      this(var1, var2, var3);
   }
}
