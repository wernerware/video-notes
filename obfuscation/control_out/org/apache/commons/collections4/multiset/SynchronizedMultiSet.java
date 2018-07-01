package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.collection.SynchronizedCollection;

public class SynchronizedMultiSet extends SynchronizedCollection implements MultiSet {
   private static final long serialVersionUID = 20150629L;

   public static SynchronizedMultiSet synchronizedMultiSet(MultiSet multiset) {
      return new SynchronizedMultiSet(multiset);
   }

   protected SynchronizedMultiSet(MultiSet multiset) {
      super(multiset);
   }

   protected SynchronizedMultiSet(MultiSet multiset, Object lock) {
      super(multiset, lock);
   }

   protected MultiSet decorated() {
      return (MultiSet)super.decorated();
   }

   public boolean equals(Object object) {
      if (object == this) {
         return true;
      } else {
         Object var2 = this.lock;
         synchronized(this.lock) {
            return this.decorated().equals(object);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.decorated().hashCode();
      }
   }

   public int add(Object object, int count) {
      Object var3 = this.lock;
      synchronized(this.lock) {
         return this.decorated().add(object, count);
      }
   }

   public int remove(Object object, int count) {
      Object var3 = this.lock;
      synchronized(this.lock) {
         return this.decorated().remove(object, count);
      }
   }

   public int getCount(Object object) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().getCount(object);
      }
   }

   public int setCount(Object object, int count) {
      Object var3 = this.lock;
      synchronized(this.lock) {
         return this.decorated().setCount(object, count);
      }
   }

   public Set uniqueSet() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         Set set = this.decorated().uniqueSet();
         return new SynchronizedMultiSet.SynchronizedSet(set, this.lock);
      }
   }

   public Set entrySet() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         Set set = this.decorated().entrySet();
         return new SynchronizedMultiSet.SynchronizedSet(set, this.lock);
      }
   }

   static class SynchronizedSet extends SynchronizedCollection implements Set {
      private static final long serialVersionUID = 20150629L;

      SynchronizedSet(Set set, Object lock) {
         super(set, lock);
      }
   }
}
