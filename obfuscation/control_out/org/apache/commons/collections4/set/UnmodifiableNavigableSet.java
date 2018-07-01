package org.apache.commons.collections4.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

public final class UnmodifiableNavigableSet extends AbstractNavigableSetDecorator implements Unmodifiable {
   private static final long serialVersionUID = 20150528L;

   public static NavigableSet unmodifiableNavigableSet(NavigableSet set) {
      return (NavigableSet)(set instanceof Unmodifiable ? set : new UnmodifiableNavigableSet(set));
   }

   private UnmodifiableNavigableSet(NavigableSet set) {
      super(set);
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

   public SortedSet subSet(Object fromElement, Object toElement) {
      SortedSet sub = this.decorated().subSet(fromElement, toElement);
      return UnmodifiableSortedSet.unmodifiableSortedSet(sub);
   }

   public SortedSet headSet(Object toElement) {
      SortedSet head = this.decorated().headSet(toElement);
      return UnmodifiableSortedSet.unmodifiableSortedSet(head);
   }

   public SortedSet tailSet(Object fromElement) {
      SortedSet tail = this.decorated().tailSet(fromElement);
      return UnmodifiableSortedSet.unmodifiableSortedSet(tail);
   }

   public NavigableSet descendingSet() {
      return unmodifiableNavigableSet(this.decorated().descendingSet());
   }

   public Iterator descendingIterator() {
      return UnmodifiableIterator.unmodifiableIterator(this.decorated().descendingIterator());
   }

   public NavigableSet subSet(Object fromElement, boolean fromInclusive, Object toElement, boolean toInclusive) {
      NavigableSet sub = this.decorated().subSet(fromElement, fromInclusive, toElement, toInclusive);
      return unmodifiableNavigableSet(sub);
   }

   public NavigableSet headSet(Object toElement, boolean inclusive) {
      NavigableSet head = this.decorated().headSet(toElement, inclusive);
      return unmodifiableNavigableSet(head);
   }

   public NavigableSet tailSet(Object fromElement, boolean inclusive) {
      NavigableSet tail = this.decorated().tailSet(fromElement, inclusive);
      return unmodifiableNavigableSet(tail);
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.decorated());
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.setCollection((Collection)in.readObject());
   }
}
