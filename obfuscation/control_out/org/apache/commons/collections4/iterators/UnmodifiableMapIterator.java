package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;

public final class UnmodifiableMapIterator implements MapIterator, Unmodifiable {
   private final MapIterator iterator;

   public static MapIterator unmodifiableMapIterator(MapIterator iterator) {
      if (iterator == null) {
         throw new NullPointerException("MapIterator must not be null");
      } else {
         return (MapIterator)(iterator instanceof Unmodifiable ? iterator : new UnmodifiableMapIterator(iterator));
      }
   }

   private UnmodifiableMapIterator(MapIterator iterator) {
      this.iterator = iterator;
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public Object next() {
      return this.iterator.next();
   }

   public Object getKey() {
      return this.iterator.getKey();
   }

   public Object getValue() {
      return this.iterator.getValue();
   }

   public Object setValue(Object value) {
      throw new UnsupportedOperationException("setValue() is not supported");
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() is not supported");
   }
}
