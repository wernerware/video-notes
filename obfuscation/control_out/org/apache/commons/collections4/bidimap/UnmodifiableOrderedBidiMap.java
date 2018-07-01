package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableOrderedBidiMap extends AbstractOrderedBidiMapDecorator implements Unmodifiable {
   private UnmodifiableOrderedBidiMap inverse;

   public static OrderedBidiMap unmodifiableOrderedBidiMap(OrderedBidiMap map) {
      return (OrderedBidiMap)(map instanceof Unmodifiable ? map : new UnmodifiableOrderedBidiMap(map));
   }

   private UnmodifiableOrderedBidiMap(OrderedBidiMap map) {
      super(map);
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Object put(Object key, Object value) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map mapToCopy) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object key) {
      throw new UnsupportedOperationException();
   }

   public Set entrySet() {
      Set set = super.entrySet();
      return UnmodifiableEntrySet.unmodifiableEntrySet(set);
   }

   public Set keySet() {
      Set set = super.keySet();
      return UnmodifiableSet.unmodifiableSet(set);
   }

   public Set values() {
      Set set = super.values();
      return UnmodifiableSet.unmodifiableSet(set);
   }

   public Object removeValue(Object value) {
      throw new UnsupportedOperationException();
   }

   public OrderedBidiMap inverseBidiMap() {
      return this.inverseOrderedBidiMap();
   }

   public OrderedMapIterator mapIterator() {
      OrderedMapIterator it = this.decorated().mapIterator();
      return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(it);
   }

   public OrderedBidiMap inverseOrderedBidiMap() {
      if (this.inverse == null) {
         this.inverse = new UnmodifiableOrderedBidiMap(this.decorated().inverseBidiMap());
         this.inverse.inverse = this;
      }

      return this.inverse;
   }
}
