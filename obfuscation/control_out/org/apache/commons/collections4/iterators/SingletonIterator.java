package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

public class SingletonIterator implements ResettableIterator {
   private final boolean removeAllowed;
   private boolean beforeFirst;
   private boolean removed;
   private Object object;

   public SingletonIterator(Object object) {
      this(object, true);
   }

   public SingletonIterator(Object object, boolean removeAllowed) {
      this.beforeFirst = true;
      this.removed = false;
      this.object = object;
      this.removeAllowed = removeAllowed;
   }

   public boolean hasNext() {
      return this.beforeFirst && !this.removed;
   }

   public Object next() {
      if (this.beforeFirst && !this.removed) {
         this.beforeFirst = false;
         return this.object;
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      if (this.removeAllowed) {
         if (!this.removed && !this.beforeFirst) {
            this.object = null;
            this.removed = true;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new UnsupportedOperationException();
      }
   }

   public void reset() {
      this.beforeFirst = true;
   }
}
