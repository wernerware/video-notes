package org.a.a.a.h;

import java.util.Iterator;
import java.util.Set;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.h.s
class class_184 extends class_180 {
   // $FF: renamed from: a java.util.Set
   private final Set field_241;
   // $FF: renamed from: b java.lang.Object
   private Object field_242 = null;

   protected class_184(Iterator var1, Set var2) {
      super(var1);
      this.field_241 = var2;
   }

   public Object next() {
      this.field_242 = super.next();
      return this.field_242;
   }

   public void remove() {
      super.remove();
      this.field_241.remove(this.field_242);
      this.field_242 = null;
   }
}
