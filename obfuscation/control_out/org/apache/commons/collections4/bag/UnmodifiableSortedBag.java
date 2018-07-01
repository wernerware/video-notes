package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableSortedBag extends AbstractSortedBagDecorator implements Unmodifiable {
   private static final long serialVersionUID = -3190437252665717841L;

   public static SortedBag unmodifiableSortedBag(SortedBag bag) {
      return (SortedBag)(bag instanceof Unmodifiable ? bag : new UnmodifiableSortedBag(bag));
   }

   private UnmodifiableSortedBag(SortedBag bag) {
      super(bag);
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.decorated());
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.setCollection((Collection)in.readObject());
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

   public boolean add(Object object, int count) {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object object, int count) {
      throw new UnsupportedOperationException();
   }

   public Set uniqueSet() {
      Set set = this.decorated().uniqueSet();
      return UnmodifiableSet.unmodifiableSet(set);
   }
}
