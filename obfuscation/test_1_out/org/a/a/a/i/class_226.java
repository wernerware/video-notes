package org.a.a.a.i;

import java.util.NoSuchElementException;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.V
abstract class class_226 {
   // $FF: renamed from: a org.a.a.a.i.U
   private final class_504 field_326;
   // $FF: renamed from: b int
   private int field_327 = 0;
   // $FF: renamed from: c org.a.a.a.i.Y
   private class_501 field_328 = null;

   public class_226(class_504 var1) {
      this.field_326 = var1;
   }

   public boolean hasNext() {
      return this.field_327 < class_504.method_1595(this.field_326);
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_581() {
      if (!this.hasNext()) {
         throw new NoSuchElementException("No next() entry in the iteration");
      } else {
         this.field_328 = new class_501(this.field_326, ++this.field_327);
         return this.field_328;
      }
   }

   public void remove() {
      if (this.field_328 == null) {
         throw new IllegalStateException("remove() can only be called once after next()");
      } else {
         this.field_328.method_1589(true);
         this.field_326.remove(this.field_328.getKey());
         --this.field_327;
         this.field_328 = null;
      }
   }
}
