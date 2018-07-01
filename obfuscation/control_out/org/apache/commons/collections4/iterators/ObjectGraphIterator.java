package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Transformer;

public class ObjectGraphIterator implements Iterator {
   private final Deque stack = new ArrayDeque(8);
   private Object root;
   private final Transformer transformer;
   private boolean hasNext = false;
   private Iterator currentIterator;
   private Object currentValue;
   private Iterator lastUsedIterator;

   public ObjectGraphIterator(Object root, Transformer transformer) {
      if (root instanceof Iterator) {
         this.currentIterator = (Iterator)root;
      } else {
         this.root = root;
      }

      this.transformer = transformer;
   }

   public ObjectGraphIterator(Iterator rootIterator) {
      this.currentIterator = rootIterator;
      this.transformer = null;
   }

   protected void updateCurrentIterator() {
      if (!this.hasNext) {
         if (this.currentIterator == null) {
            if (this.root != null) {
               if (this.transformer == null) {
                  this.findNext(this.root);
               } else {
                  this.findNext(this.transformer.transform(this.root));
               }

               this.root = null;
            }
         } else {
            this.findNextByIterator(this.currentIterator);
         }

      }
   }

   protected void findNext(Object value) {
      if (value instanceof Iterator) {
         this.findNextByIterator((Iterator)value);
      } else {
         this.currentValue = value;
         this.hasNext = true;
      }

   }

   protected void findNextByIterator(Iterator iterator) {
      if (iterator != this.currentIterator) {
         if (this.currentIterator != null) {
            this.stack.push(this.currentIterator);
         }

         this.currentIterator = iterator;
      }

      Object next;
      for(; this.currentIterator.hasNext() && !this.hasNext; this.findNext(next)) {
         next = this.currentIterator.next();
         if (this.transformer != null) {
            next = this.transformer.transform(next);
         }
      }

      if (!this.hasNext && !this.stack.isEmpty()) {
         this.currentIterator = (Iterator)this.stack.pop();
         this.findNextByIterator(this.currentIterator);
      }

   }

   public boolean hasNext() {
      this.updateCurrentIterator();
      return this.hasNext;
   }

   public Object next() {
      this.updateCurrentIterator();
      if (!this.hasNext) {
         throw new NoSuchElementException("No more elements in the iteration");
      } else {
         this.lastUsedIterator = this.currentIterator;
         Object result = this.currentValue;
         this.currentValue = null;
         this.hasNext = false;
         return result;
      }
   }

   public void remove() {
      if (this.lastUsedIterator == null) {
         throw new IllegalStateException("Iterator remove() cannot be called at this time");
      } else {
         this.lastUsedIterator.remove();
         this.lastUsedIterator = null;
      }
   }
}
