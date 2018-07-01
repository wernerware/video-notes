package org.apache.commons.collections4.queue;

import java.util.Queue;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;

public class TransformedQueue extends TransformedCollection implements Queue {
   private static final long serialVersionUID = -7901091318986132033L;

   public static TransformedQueue transformingQueue(Queue queue, Transformer transformer) {
      return new TransformedQueue(queue, transformer);
   }

   public static TransformedQueue transformedQueue(Queue queue, Transformer transformer) {
      TransformedQueue decorated = new TransformedQueue(queue, transformer);
      if (queue.size() > 0) {
         Object[] values = (Object[])queue.toArray();
         queue.clear();
         Object[] arr$ = values;
         int len$ = values.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Object value = arr$[i$];
            decorated.decorated().add(transformer.transform(value));
         }
      }

      return decorated;
   }

   protected TransformedQueue(Queue queue, Transformer transformer) {
      super(queue, transformer);
   }

   protected Queue getQueue() {
      return (Queue)this.decorated();
   }

   public boolean offer(Object obj) {
      return this.getQueue().offer(this.transform(obj));
   }

   public Object poll() {
      return this.getQueue().poll();
   }

   public Object peek() {
      return this.getQueue().peek();
   }

   public Object element() {
      return this.getQueue().element();
   }

   public Object remove() {
      return this.getQueue().remove();
   }
}
