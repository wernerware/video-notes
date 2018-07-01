package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.SortedBag;

public class SynchronizedSortedBag extends SynchronizedBag implements SortedBag {
   private static final long serialVersionUID = 722374056718497858L;

   public static SynchronizedSortedBag synchronizedSortedBag(SortedBag bag) {
      return new SynchronizedSortedBag(bag);
   }

   protected SynchronizedSortedBag(SortedBag bag) {
      super(bag);
   }

   protected SynchronizedSortedBag(Bag bag, Object lock) {
      super(bag, lock);
   }

   protected SortedBag getSortedBag() {
      return (SortedBag)this.decorated();
   }

   public synchronized Object first() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.getSortedBag().first();
      }
   }

   public synchronized Object last() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.getSortedBag().last();
      }
   }

   public synchronized Comparator comparator() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.getSortedBag().comparator();
      }
   }
}
