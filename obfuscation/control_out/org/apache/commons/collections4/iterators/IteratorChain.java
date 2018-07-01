package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IteratorChain implements Iterator {
   private final Queue iteratorChain = new LinkedList();
   private Iterator currentIterator = null;
   private Iterator lastUsedIterator = null;
   private boolean isLocked = false;

   public IteratorChain() {
   }

   public IteratorChain(Iterator iterator) {
      this.addIterator(iterator);
   }

   public IteratorChain(Iterator first, Iterator second) {
      this.addIterator(first);
      this.addIterator(second);
   }

   public IteratorChain(Iterator... iteratorChain) {
      Iterator[] arr$ = iteratorChain;
      int len$ = iteratorChain.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Iterator element = arr$[i$];
         this.addIterator(element);
      }

   }

   public IteratorChain(Collection iteratorChain) {
      Iterator i$ = iteratorChain.iterator();

      while(i$.hasNext()) {
         Iterator iterator = (Iterator)i$.next();
         this.addIterator(iterator);
      }

   }

   public void addIterator(Iterator iterator) {
      this.checkLocked();
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.iteratorChain.add(iterator);
      }
   }

   public int size() {
      return this.iteratorChain.size();
   }

   public boolean isLocked() {
      return this.isLocked;
   }

   private void checkLocked() {
      if (this.isLocked) {
         throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
      }
   }

   private void lockChain() {
      if (!this.isLocked) {
         this.isLocked = true;
      }

   }

   protected void updateCurrentIterator() {
      if (this.currentIterator == null) {
         if (this.iteratorChain.isEmpty()) {
            this.currentIterator = EmptyIterator.emptyIterator();
         } else {
            this.currentIterator = (Iterator)this.iteratorChain.remove();
         }

         this.lastUsedIterator = this.currentIterator;
      }

      while(!this.currentIterator.hasNext() && !this.iteratorChain.isEmpty()) {
         this.currentIterator = (Iterator)this.iteratorChain.remove();
      }

   }

   public boolean hasNext() {
      this.lockChain();
      this.updateCurrentIterator();
      this.lastUsedIterator = this.currentIterator;
      return this.currentIterator.hasNext();
   }

   public Object next() {
      this.lockChain();
      this.updateCurrentIterator();
      this.lastUsedIterator = this.currentIterator;
      return this.currentIterator.next();
   }

   public void remove() {
      this.lockChain();
      if (this.currentIterator == null) {
         this.updateCurrentIterator();
      }

      this.lastUsedIterator.remove();
   }
}
