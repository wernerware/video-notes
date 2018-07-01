package org.a.a.a.f;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_20;

// $FF: renamed from: org.a.a.a.f.A
public class class_457 implements class_20 {
   // $FF: renamed from: a java.util.Collection
   private final Collection field_833;
   // $FF: renamed from: b java.util.Iterator
   private Iterator field_834;

   public class_457(Collection var1) {
      if (var1 == null) {
         throw new NullPointerException("The collection must not be null");
      } else {
         this.field_833 = var1;
         this.method_24();
      }
   }

   public boolean hasNext() {
      return this.field_833.size() > 0;
   }

   public Object next() {
      if (this.field_833.size() == 0) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         if (!this.field_834.hasNext()) {
            this.method_24();
         }

         return this.field_834.next();
      }
   }

   public void remove() {
      this.field_834.remove();
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_834 = this.field_833.iterator();
   }

   // $FF: renamed from: a () int
   public int method_1540() {
      return this.field_833.size();
   }
}
