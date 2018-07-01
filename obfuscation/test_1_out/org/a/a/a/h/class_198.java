package org.a.a.a.h;

import java.util.ListIterator;
import java.util.Set;
import org.a.a.a.f.class_195;

// $FF: renamed from: org.a.a.a.h.t
class class_198 extends class_195 {
   // $FF: renamed from: a java.util.Set
   private final Set field_268;
   // $FF: renamed from: b java.lang.Object
   private Object field_269 = null;

   protected class_198(ListIterator var1, Set var2) {
      super(var1);
      this.field_268 = var2;
   }

   public Object next() {
      this.field_269 = super.next();
      return this.field_269;
   }

   public Object previous() {
      this.field_269 = super.previous();
      return this.field_269;
   }

   public void remove() {
      super.remove();
      this.field_268.remove(this.field_269);
      this.field_269 = null;
   }

   public void add(Object var1) {
      if (!this.field_268.contains(var1)) {
         super.add(var1);
         this.field_268.add(var1);
      }

   }

   public void set(Object var1) {
      throw new UnsupportedOperationException("ListIterator does not support set");
   }
}
