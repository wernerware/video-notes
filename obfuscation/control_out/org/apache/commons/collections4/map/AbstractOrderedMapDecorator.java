package org.apache.commons.collections4.map;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;

public abstract class AbstractOrderedMapDecorator extends AbstractMapDecorator implements OrderedMap {
   protected AbstractOrderedMapDecorator() {
   }

   public AbstractOrderedMapDecorator(OrderedMap map) {
      super(map);
   }

   protected OrderedMap decorated() {
      return (OrderedMap)super.decorated();
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

   public OrderedMapIterator mapIterator() {
      return this.decorated().mapIterator();
   }
}
