package org.a.a.a.f;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_6;

// $FF: renamed from: org.a.a.a.f.z
public class class_206 implements class_6 {
   // $FF: renamed from: a java.lang.String
   private static final String field_279 = "ListIteratorWrapper does not support optional operations of ListIterator.";
   // $FF: renamed from: b java.lang.String
   private static final String field_280 = "Cannot remove element at index {0}.";
   // $FF: renamed from: c java.util.Iterator
   private final Iterator field_281;
   // $FF: renamed from: d java.util.List
   private final List field_282 = new ArrayList();
   // $FF: renamed from: e int
   private int field_283 = 0;
   // $FF: renamed from: f int
   private int field_284 = 0;
   // $FF: renamed from: g boolean
   private boolean field_285;

   public class_206(Iterator var1) {
      if (var1 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.field_281 = var1;
      }
   }

   public void add(Object var1) {
      if (this.field_281 instanceof ListIterator) {
         ListIterator var2 = (ListIterator)this.field_281;
         var2.add(var1);
      } else {
         throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
      }
   }

   public boolean hasNext() {
      return this.field_283 != this.field_284 && !(this.field_281 instanceof ListIterator) ? true : this.field_281.hasNext();
   }

   public boolean hasPrevious() {
      if (this.field_281 instanceof ListIterator) {
         ListIterator var1 = (ListIterator)this.field_281;
         return var1.hasPrevious();
      } else {
         return this.field_283 > 0;
      }
   }

   public Object next() {
      if (this.field_281 instanceof ListIterator) {
         return this.field_281.next();
      } else if (this.field_283 < this.field_284) {
         ++this.field_283;
         return this.field_282.get(this.field_283 - 1);
      } else {
         Object var1 = this.field_281.next();
         this.field_282.add(var1);
         ++this.field_283;
         ++this.field_284;
         this.field_285 = true;
         return var1;
      }
   }

   public int nextIndex() {
      if (this.field_281 instanceof ListIterator) {
         ListIterator var1 = (ListIterator)this.field_281;
         return var1.nextIndex();
      } else {
         return this.field_283;
      }
   }

   public Object previous() {
      if (this.field_281 instanceof ListIterator) {
         ListIterator var1 = (ListIterator)this.field_281;
         return var1.previous();
      } else if (this.field_283 == 0) {
         throw new NoSuchElementException();
      } else {
         this.field_285 = this.field_284 == this.field_283;
         return this.field_282.get(--this.field_283);
      }
   }

   public int previousIndex() {
      if (this.field_281 instanceof ListIterator) {
         ListIterator var1 = (ListIterator)this.field_281;
         return var1.previousIndex();
      } else {
         return this.field_283 - 1;
      }
   }

   public void remove() {
      if (this.field_281 instanceof ListIterator) {
         this.field_281.remove();
      } else {
         int var1 = this.field_283;
         if (this.field_283 == this.field_284) {
            --var1;
         }

         if (this.field_285 && this.field_284 - this.field_283 <= 1) {
            this.field_281.remove();
            this.field_282.remove(var1);
            this.field_283 = var1;
            --this.field_284;
            this.field_285 = false;
         } else {
            throw new IllegalStateException(MessageFormat.format("Cannot remove element at index {0}.", var1));
         }
      }
   }

   public void set(Object var1) {
      if (this.field_281 instanceof ListIterator) {
         ListIterator var2 = (ListIterator)this.field_281;
         var2.set(var1);
      } else {
         throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
      }
   }

   // $FF: renamed from: c () void
   public void method_553() {
      if (!(this.field_281 instanceof ListIterator)) {
         this.field_283 = 0;
      } else {
         ListIterator var1 = (ListIterator)this.field_281;

         while(var1.previousIndex() >= 0) {
            var1.previous();
         }

      }
   }
}
