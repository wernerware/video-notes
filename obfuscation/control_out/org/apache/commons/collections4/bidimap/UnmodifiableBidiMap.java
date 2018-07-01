package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableBidiMap extends AbstractBidiMapDecorator implements Unmodifiable {
   private UnmodifiableBidiMap inverse;

   public static BidiMap unmodifiableBidiMap(BidiMap map) {
      return (BidiMap)(map instanceof Unmodifiable ? map : new UnmodifiableBidiMap(map));
   }

   private UnmodifiableBidiMap(BidiMap map) {
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

   public MapIterator mapIterator() {
      MapIterator it = this.decorated().mapIterator();
      return UnmodifiableMapIterator.unmodifiableMapIterator(it);
   }

   public synchronized BidiMap inverseBidiMap() {
      if (this.inverse == null) {
         this.inverse = new UnmodifiableBidiMap(this.decorated().inverseBidiMap());
         this.inverse.inverse = this;
      }

      return this.inverse;
   }
}
