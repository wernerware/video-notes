package org.a.a.a.n;

import java.util.Collection;
import java.util.ListIterator;
import org.a.a.a.class_5;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.n.i
class class_185 extends class_180 implements class_5 {
   // $FF: renamed from: a java.util.Collection
   private final Collection field_243;
   // $FF: renamed from: b java.lang.Object
   private Object field_244;

   private class_185(ListIterator var1, Collection var2) {
      super(var1);
      this.field_243 = var2;
   }

   public Object next() {
      this.field_244 = this.b().next();
      return this.field_244;
   }

   public void remove() {
      this.field_243.remove(this.field_244);
      this.b().remove();
      this.field_244 = null;
   }

   public boolean hasPrevious() {
      return ((ListIterator)this.b()).hasPrevious();
   }

   public Object previous() {
      this.field_244 = ((ListIterator)this.b()).previous();
      return this.field_244;
   }

   // $FF: synthetic method
   class_185(ListIterator var1, Collection var2, class_404 var3) {
      this(var1, var2);
   }
}
