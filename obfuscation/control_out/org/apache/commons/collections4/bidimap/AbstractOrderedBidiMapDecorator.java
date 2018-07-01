package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMapIterator;

public abstract class AbstractOrderedBidiMapDecorator extends AbstractBidiMapDecorator implements OrderedBidiMap {
   protected AbstractOrderedBidiMapDecorator(OrderedBidiMap map) {
      super(map);
   }

   protected OrderedBidiMap decorated() {
      return (OrderedBidiMap)super.decorated();
   }

   public OrderedMapIterator mapIterator() {
      return this.decorated().mapIterator();
   }

   public Object firstKey() {
      return this.decorated().firstKey();
   }

   public Object lastKey() {
      return this.decorated().lastKey();
   }

   public Object nextKey(Object key) {
      return this.decorated().nextKey(key);
   }

   public Object previousKey(Object key) {
      return this.decorated().previousKey(key);
   }

   public OrderedBidiMap inverseBidiMap() {
      return this.decorated().inverseBidiMap();
   }
}
