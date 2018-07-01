package org.apache.commons.collections4.bidimap;

import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.AbstractMapDecorator;

public abstract class AbstractBidiMapDecorator extends AbstractMapDecorator implements BidiMap {
   protected AbstractBidiMapDecorator(BidiMap map) {
      super(map);
   }

   protected BidiMap decorated() {
      return (BidiMap)super.decorated();
   }

   public MapIterator mapIterator() {
      return this.decorated().mapIterator();
   }

   public Object getKey(Object value) {
      return this.decorated().getKey(value);
   }

   public Object removeValue(Object value) {
      return this.decorated().removeValue(value);
   }

   public BidiMap inverseBidiMap() {
      return this.decorated().inverseBidiMap();
   }

   public Set values() {
      return this.decorated().values();
   }
}
