package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;

public final class UnmodifiableList extends AbstractSerializableListDecorator implements Unmodifiable {
   private static final long serialVersionUID = 6595182819922443652L;

   public static List unmodifiableList(List list) {
      return (List)(list instanceof Unmodifiable ? list : new UnmodifiableList(list));
   }

   public UnmodifiableList(List list) {
      super(list);
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

   public ListIterator listIterator() {
      return UnmodifiableListIterator.umodifiableListIterator(this.decorated().listIterator());
   }

   public ListIterator listIterator(int index) {
      return UnmodifiableListIterator.umodifiableListIterator(this.decorated().listIterator(index));
   }

   public void add(int index, Object object) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(int index, Collection coll) {
      throw new UnsupportedOperationException();
   }

   public Object remove(int index) {
      throw new UnsupportedOperationException();
   }

   public Object set(int index, Object object) {
      throw new UnsupportedOperationException();
   }

   public List subList(int fromIndex, int toIndex) {
      List sub = this.decorated().subList(fromIndex, toIndex);
      return new UnmodifiableList(sub);
   }
}
