package org.a.a.a.f;

import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.f.j
public class class_168 implements Iterator {
   // $FF: renamed from: a java.util.Iterator
   private final Iterator field_211;
   // $FF: renamed from: b long
   private final long field_212;
   // $FF: renamed from: c long
   private final long field_213;
   // $FF: renamed from: d long
   private long field_214;

   public class_168(Iterator var1, long var2, long var4) {
      if (var1 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else if (var2 < 0L) {
         throw new IllegalArgumentException("Offset parameter must not be negative.");
      } else if (var4 < 0L) {
         throw new IllegalArgumentException("Max parameter must not be negative.");
      } else {
         this.field_211 = var1;
         this.field_212 = var2;
         this.field_213 = var4;
         this.field_214 = 0L;
         this.method_522();
      }
   }

   // $FF: renamed from: a () void
   private void method_522() {
      while(this.field_214 < this.field_212 && this.field_211.hasNext()) {
         this.field_211.next();
         ++this.field_214;
      }

   }

   public boolean hasNext() {
      return !this.method_523() ? false : this.field_211.hasNext();
   }

   // $FF: renamed from: b () boolean
   private boolean method_523() {
      return this.field_214 - this.field_212 + 1L <= this.field_213;
   }

   public Object next() {
      if (!this.method_523()) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.field_211.next();
         ++this.field_214;
         return var1;
      }
   }

   public void remove() {
      if (this.field_214 <= this.field_212) {
         throw new IllegalStateException("remove() can not be called before calling next()");
      } else {
         this.field_211.remove();
      }
   }
}
