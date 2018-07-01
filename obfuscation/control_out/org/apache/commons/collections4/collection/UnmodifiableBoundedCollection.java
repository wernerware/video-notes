package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

public final class UnmodifiableBoundedCollection extends AbstractCollectionDecorator implements BoundedCollection, Unmodifiable {
   private static final long serialVersionUID = -7112672385450340330L;

   public static BoundedCollection unmodifiableBoundedCollection(BoundedCollection coll) {
      return (BoundedCollection)(coll instanceof Unmodifiable ? coll : new UnmodifiableBoundedCollection(coll));
   }

   public static BoundedCollection unmodifiableBoundedCollection(Collection coll) {
      if (coll == null) {
         throw new NullPointerException("Collection must not be null.");
      } else {
         for(int i = 0; i < 1000 && !(coll instanceof BoundedCollection); ++i) {
            if (coll instanceof AbstractCollectionDecorator) {
               coll = ((AbstractCollectionDecorator)coll).decorated();
            } else if (coll instanceof SynchronizedCollection) {
               coll = ((SynchronizedCollection)coll).decorated();
            }
         }

         if (!(coll instanceof BoundedCollection)) {
            throw new IllegalArgumentException("Collection is not a bounded collection.");
         } else {
            return new UnmodifiableBoundedCollection((BoundedCollection)coll);
         }
      }
   }

   private UnmodifiableBoundedCollection(BoundedCollection coll) {
      super(coll);
   }

   public Iterator iterator() {
      return UnmodifiableIterator.unmodifiableIterator(this.decorated().iterator());
   }

   public boolean add(Object object) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection coll) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object object) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection coll) {
      throw new UnsupportedOperationException();
   }

   public boolean retainAll(Collection coll) {
      throw new UnsupportedOperationException();
   }

   public boolean isFull() {
      return this.decorated().isFull();
   }

   public int maxSize() {
      return this.decorated().maxSize();
   }

   protected BoundedCollection decorated() {
      return (BoundedCollection)super.decorated();
   }
}
