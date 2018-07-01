package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableMultiSet extends AbstractMultiSetDecorator implements Unmodifiable {
   private static final long serialVersionUID = 20150611L;

   public static MultiSet unmodifiableMultiSet(MultiSet multiset) {
      return (MultiSet)(multiset instanceof Unmodifiable ? multiset : new UnmodifiableMultiSet(multiset));
   }

   private UnmodifiableMultiSet(MultiSet multiset) {
      super(multiset);
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

   public int setCount(Object object, int count) {
      throw new UnsupportedOperationException();
   }

   public int add(Object object, int count) {
      throw new UnsupportedOperationException();
   }

   public int remove(Object object, int count) {
      throw new UnsupportedOperationException();
   }

   public Set uniqueSet() {
      Set set = this.decorated().uniqueSet();
      return UnmodifiableSet.unmodifiableSet(set);
   }

   public Set entrySet() {
      Set set = this.decorated().entrySet();
      return UnmodifiableSet.unmodifiableSet(set);
   }
}
