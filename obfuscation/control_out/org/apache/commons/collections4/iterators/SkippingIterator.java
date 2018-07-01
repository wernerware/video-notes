package org.apache.commons.collections4.iterators;

import java.util.Iterator;

public class SkippingIterator extends AbstractIteratorDecorator {
   private final long offset;
   private long pos;

   public SkippingIterator(Iterator iterator, long offset) {
      super(iterator);
      if (offset < 0L) {
         throw new IllegalArgumentException("Offset parameter must not be negative.");
      } else {
         this.offset = offset;
         this.pos = 0L;
         this.init();
      }
   }

   private void init() {
      while(this.pos < this.offset && this.hasNext()) {
         this.next();
      }

   }

   public Object next() {
      Object next = super.next();
      ++this.pos;
      return next;
   }

   public void remove() {
      if (this.pos <= this.offset) {
         throw new IllegalStateException("remove() can not be called before calling next()");
      } else {
         super.remove();
      }
   }
}
