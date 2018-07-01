package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;

public class AbstractMapIteratorDecorator implements MapIterator {
   private final MapIterator iterator;

   public AbstractMapIteratorDecorator(MapIterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("MapIterator must not be null");
      } else {
         this.iterator = iterator;
      }
   }

   protected MapIterator getMapIterator() {
      return this.iterator;
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public Object next() {
      return this.iterator.next();
   }

   public void remove() {
      this.iterator.remove();
   }

   public Object getKey() {
      return this.iterator.getKey();
   }

   public Object getValue() {
      return this.iterator.getValue();
   }

   public Object setValue(Object obj) {
      return this.iterator.setValue(obj);
   }
}
