package org.a.a.a.f;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.f.g
public abstract class class_176 implements Iterator {
   // $FF: renamed from: a java.util.Iterator
   private final Iterator field_231;

   protected class_176(Iterator var1) {
      if (var1 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.field_231 = var1;
      }
   }

   // $FF: renamed from: b () java.util.Iterator
   protected Iterator method_542() {
      return this.field_231;
   }

   public boolean hasNext() {
      return this.field_231.hasNext();
   }

   public void remove() {
      this.field_231.remove();
   }
}
