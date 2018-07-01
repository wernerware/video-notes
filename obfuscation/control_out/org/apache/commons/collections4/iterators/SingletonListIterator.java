package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class SingletonListIterator implements ResettableListIterator {
   private boolean beforeFirst = true;
   private boolean nextCalled = false;
   private boolean removed = false;
   private Object object;

   public SingletonListIterator(Object object) {
      this.object = object;
   }

   public boolean hasNext() {
      return this.beforeFirst && !this.removed;
   }

   public boolean hasPrevious() {
      return !this.beforeFirst && !this.removed;
   }

   public int nextIndex() {
      return this.beforeFirst ? 0 : 1;
   }

   public int previousIndex() {
      return this.beforeFirst ? -1 : 0;
   }

   public Object next() {
      if (this.beforeFirst && !this.removed) {
         this.beforeFirst = false;
         this.nextCalled = true;
         return this.object;
      } else {
         throw new NoSuchElementException();
      }
   }

   public Object previous() {
      if (!this.beforeFirst && !this.removed) {
         this.beforeFirst = true;
         return this.object;
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      if (this.nextCalled && !this.removed) {
         this.object = null;
         this.removed = true;
      } else {
         throw new IllegalStateException();
      }
   }

   public void add(Object obj) {
      throw new UnsupportedOperationException("add() is not supported by this iterator");
   }

   public void set(Object obj) {
      if (this.nextCalled && !this.removed) {
         this.object = obj;
      } else {
         throw new IllegalStateException();
      }
   }

   public void reset() {
      this.beforeFirst = true;
      this.nextCalled = false;
   }
}
