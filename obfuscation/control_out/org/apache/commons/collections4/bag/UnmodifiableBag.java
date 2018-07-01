package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableBag extends AbstractBagDecorator implements Unmodifiable {
   private static final long serialVersionUID = -1873799975157099624L;

   public static Bag unmodifiableBag(Bag bag) {
      return (Bag)(bag instanceof Unmodifiable ? bag : new UnmodifiableBag(bag));
   }

   private UnmodifiableBag(Bag bag) {
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
