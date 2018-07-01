package org.apache.commons.collections4.queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

public final class UnmodifiableQueue extends AbstractQueueDecorator implements Unmodifiable {
   private static final long serialVersionUID = 1832948656215393357L;

   public static Queue unmodifiableQueue(Queue queue) {
      return (Queue)(queue instanceof Unmodifiable ? queue : new UnmodifiableQueue(queue));
   }

   private UnmodifiableQueue(Queue queue) {
      super(queue);
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

   public boolean offer(Object obj) {
      throw new UnsupportedOperationException();
   }

   public Object poll() {
      throw new UnsupportedOperationException();
   }

   public Object remove() {
      throw new UnsupportedOperationException();
   }
}
