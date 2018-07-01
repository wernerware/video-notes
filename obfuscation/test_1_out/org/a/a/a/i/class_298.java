package org.a.a.a.i;

import java.util.Collection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.aA
class class_298 implements Iterator {
   // $FF: renamed from: b java.lang.Object
   private final Object field_465;
   // $FF: renamed from: c java.util.Collection
   private final Collection field_466;
   // $FF: renamed from: d java.util.Iterator
   private final Iterator field_467;
   // $FF: renamed from: a org.a.a.a.i.au
   // $FF: synthetic field
   final class_130 field_468;

   public class_298(class_130 var1, Object var2) {
      this.field_468 = var1;
      this.field_465 = var2;
      this.field_466 = var1.method_332(var2);
      this.field_467 = this.field_466.iterator();
   }

   public void remove() {
      this.field_467.remove();
      if (this.field_466.isEmpty()) {
         this.field_468.remove(this.field_465);
      }

   }

   public boolean hasNext() {
      return this.field_467.hasNext();
   }

   public Object next() {
      return this.field_467.next();
   }
}
