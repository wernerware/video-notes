package org.a.a.a.j;

import java.util.Collection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.j.r
class class_480 implements Iterator {
   // $FF: renamed from: b java.lang.Object
   private final Object field_875;
   // $FF: renamed from: c java.util.Collection
   private final Collection field_876;
   // $FF: renamed from: d java.util.Iterator
   private final Iterator field_877;
   // $FF: renamed from: a org.a.a.a.j.d
   // $FF: synthetic field
   final class_467 field_878;

   public class_480(class_467 var1, Object var2) {
      this.field_878 = var1;
      this.field_875 = var2;
      this.field_876 = (Collection)var1.method_1552().get(var2);
      this.field_877 = this.field_876.iterator();
   }

   public void remove() {
      this.field_877.remove();
      if (this.field_876.isEmpty()) {
         this.field_878.method_43(this.field_875);
      }

   }

   public boolean hasNext() {
      return this.field_877.hasNext();
   }

   public Object next() {
      return this.field_877.next();
   }
}
