package org.apache.commons.collections4.iterators;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

public class ListIteratorWrapper implements ResettableListIterator {
   private static final String UNSUPPORTED_OPERATION_MESSAGE = "ListIteratorWrapper does not support optional operations of ListIterator.";
   private static final String CANNOT_REMOVE_MESSAGE = "Cannot remove element at index {0}.";
   private final Iterator iterator;
   private final List list = new ArrayList();
   private int currentIndex = 0;
   private int wrappedIteratorIndex = 0;
   private boolean removeState;

   public ListIteratorWrapper(Iterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.iterator = iterator;
      }
   }

   public void add(Object obj) throws UnsupportedOperationException {
      if (this.iterator instanceof ListIterator) {
         ListIterator li = (ListIterator)this.iterator;
         li.add(obj);
      } else {
         throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
      }
   }

   public boolean hasNext() {
      return this.currentIndex != this.wrappedIteratorIndex && !(this.iterator instanceof ListIterator) ? true : this.iterator.hasNext();
   }

   public boolean hasPrevious() {
      if (this.iterator instanceof ListIterator) {
         ListIterator li = (ListIterator)this.iterator;
         return li.hasPrevious();
      } else {
         return this.currentIndex > 0;
      }
   }

   public Object next() throws NoSuchElementException {
      if (this.iterator instanceof ListIterator) {
         return this.iterator.next();
      } else if (this.currentIndex < this.wrappedIteratorIndex) {
         ++this.currentIndex;
         return this.list.get(this.currentIndex - 1);
      } else {
         Object retval = this.iterator.next();
         this.list.add(retval);
         ++this.currentIndex;
         ++this.wrappedIteratorIndex;
         this.removeState = true;
         return retval;
      }
   }

   public int nextIndex() {
      if (this.iterator instanceof ListIterator) {
         ListIterator li = (ListIterator)this.iterator;
         return li.nextIndex();
      } else {
         return this.currentIndex;
      }
   }

   public Object previous() throws NoSuchElementException {
      if (this.iterator instanceof ListIterator) {
         ListIterator li = (ListIterator)this.iterator;
         return li.previous();
      } else if (this.currentIndex == 0) {
         throw new NoSuchElementException();
      } else {
         this.removeState = this.wrappedIteratorIndex == this.currentIndex;
         return this.list.get(--this.currentIndex);
      }
   }

   public int previousIndex() {
      if (this.iterator instanceof ListIterator) {
         ListIterator li = (ListIterator)this.iterator;
         return li.previousIndex();
      } else {
         return this.currentIndex - 1;
      }
   }

   public void remove() throws UnsupportedOperationException {
      if (this.iterator instanceof ListIterator) {
         this.iterator.remove();
      } else {
         int removeIndex = this.currentIndex;
         if (this.currentIndex == this.wrappedIteratorIndex) {
            --removeIndex;
         }

         if (this.removeState && this.wrappedIteratorIndex - this.currentIndex <= 1) {
            this.iterator.remove();
            this.list.remove(removeIndex);
            this.currentIndex = removeIndex;
            --this.wrappedIteratorIndex;
            this.removeState = false;
         } else {
            throw new IllegalStateException(MessageFormat.format("Cannot remove element at index {0}.", removeIndex));
         }
      }
   }

   public void set(Object obj) throws UnsupportedOperationException {
      if (this.iterator instanceof ListIterator) {
         ListIterator li = (ListIterator)this.iterator;
         li.set(obj);
      } else {
         throw new UnsupportedOperationException("ListIteratorWrapper does not support optional operations of ListIterator.");
      }
   }

   public void reset() {
      if (!(this.iterator instanceof ListIterator)) {
         this.currentIndex = 0;
      } else {
         ListIterator li = (ListIterator)this.iterator;

         while(li.previousIndex() >= 0) {
            li.previous();
         }

      }
   }
}
