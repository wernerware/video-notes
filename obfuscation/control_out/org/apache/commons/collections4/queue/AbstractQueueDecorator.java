package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

public abstract class AbstractQueueDecorator extends AbstractCollectionDecorator implements Queue {
   private static final long serialVersionUID = -2629815475789577029L;

   protected AbstractQueueDecorator() {
   }

   protected AbstractQueueDecorator(Queue queue) {
      super(queue);
   }

   protected Queue decorated() {
      return (Queue)super.decorated();
   }

   public boolean offer(Object obj) {
      return this.decorated().offer(obj);
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
