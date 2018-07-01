package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class SynchronizedCollection implements Collection, Serializable {
   private static final long serialVersionUID = 2412805092710877986L;
   private final Collection collection;
   protected final Object lock;

   public static SynchronizedCollection synchronizedCollection(Collection coll) {
      return new SynchronizedCollection(coll);
   }

   protected SynchronizedCollection(Collection collection) {
      if (collection == null) {
         throw new NullPointerException("Collection must not be null.");
      } else {
         this.collection = collection;
         this.lock = this;
      }
   }

   protected SynchronizedCollection(Collection collection, Object lock) {
      if (collection == null) {
         throw new NullPointerException("Collection must not be null.");
      } else if (lock == null) {
         throw new NullPointerException("Lock must not be null.");
      } else {
         this.collection = collection;
         this.lock = lock;
      }
   }

   protected Collection decorated() {
      return this.collection;
   }

   public boolean add(Object object) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().add(object);
      }
   }

   public boolean addAll(Collection coll) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().addAll(coll);
      }
   }

   public void clear() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         this.decorated().clear();
      }
   }

   public boolean contains(Object object) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().contains(object);
      }
   }

   public boolean containsAll(Collection coll) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().containsAll(coll);
      }
   }

   public boolean isEmpty() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.decorated().isEmpty();
      }
   }

   public Iterator iterator() {
      return this.decorated().iterator();
   }

   public Object[] toArray() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.decorated().toArray();
      }
   }

   public Object[] toArray(Object[] object) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().toArray(object);
      }
   }

   public boolean remove(Object object) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().remove(object);
      }
   }

   public boolean removeAll(Collection coll) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().removeAll(coll);
      }
   }

   public boolean retainAll(Collection coll) {
      Object var2 = this.lock;
      synchronized(this.lock) {
         return this.decorated().retainAll(coll);
      }
   }

   public int size() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.decorated().size();
      }
   }

   public boolean equals(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.decorated().hashCode();
      }
   }

   public String toString() {
      Object var1 = this.lock;
      synchronized(this.lock) {
         return this.decorated().toString();
      }
   }
}
