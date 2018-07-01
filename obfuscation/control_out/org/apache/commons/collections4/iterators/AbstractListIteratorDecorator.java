package org.apache.commons.collections4.iterators;

import java.util.ListIterator;

public class AbstractListIteratorDecorator implements ListIterator {
   private final ListIterator iterator;

   public AbstractListIteratorDecorator(ListIterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("ListIterator must not be null");
      } else {
         this.iterator = iterator;
      }
   }

   protected ListIterator getListIterator() {
      return this.iterator;
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public Object next() {
      return this.iterator.next();
   }

   public int nextIndex() {
      return this.iterator.nextIndex();
   }

   public boolean hasPrevious() {
      return this.iterator.hasPrevious();
   }

   public Object previous() {
      return this.iterator.previous();
   }

   public int previousIndex() {
      return this.iterator.previousIndex();
   }

   public void remove() {
      this.iterator.remove();
   }

   public void set(Object obj) {
      this.iterator.set(obj);
   }

   public void add(Object obj) {
      this.iterator.add(obj);
   }
}
