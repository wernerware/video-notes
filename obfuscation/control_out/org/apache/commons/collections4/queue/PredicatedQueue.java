package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedQueue extends PredicatedCollection implements Queue {
   private static final long serialVersionUID = 2307609000539943581L;

   public static PredicatedQueue predicatedQueue(Queue Queue, Predicate predicate) {
      return new PredicatedQueue(Queue, predicate);
   }

   protected PredicatedQueue(Queue queue, Predicate predicate) {
      super(queue, predicate);
   }

   protected Queue decorated() {
      return (Queue)super.decorated();
   }

   public boolean offer(Object object) {
      this.validate(object);
      return this.decorated().offer(object);
   }

   public Object poll() {
      return this.decorated().poll();
   }

   public Object peek() {
      return this.decorated().peek();
   }

   public Object element() {
      return this.decorated().element();
   }

   public Object remove() {
      return this.decorated().remove();
   }
}
