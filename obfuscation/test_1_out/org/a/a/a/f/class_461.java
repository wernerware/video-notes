package org.a.a.a.f;

import java.util.Iterator;
import org.a.a.a.class_29;

// $FF: renamed from: org.a.a.a.f.P
public final class class_461 implements Iterator, class_29 {
   // $FF: renamed from: a java.util.Iterator
   private final Iterator field_840;

   // $FF: renamed from: a (java.util.Iterator) java.util.Iterator
   public static Iterator method_1543(Iterator var0) {
      if (var0 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         return (Iterator)(var0 instanceof class_29 ? var0 : new class_461(var0));
      }
   }

   private class_461(Iterator var1) {
      this.field_840 = var1;
   }

   public boolean hasNext() {
      return this.field_840.hasNext();
   }

   public Object next() {
      return this.field_840.next();
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() is not supported");
   }
}
