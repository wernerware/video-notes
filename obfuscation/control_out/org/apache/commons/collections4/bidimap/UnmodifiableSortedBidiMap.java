package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableSortedBidiMap extends AbstractSortedBidiMapDecorator implements Unmodifiable {
   private UnmodifiableSortedBidiMap inverse;

   public static SortedBidiMap unmodifiableSortedBidiMap(SortedBidiMap map) {
      return (SortedBidiMap)(map instanceof Unmodifiable ? map : new UnmodifiableSortedBidiMap(map));
   }

   private UnmodifiableSortedBidiMap(SortedBidiMap map) {
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

   public OrderedMapIterator mapIterator() {
      OrderedMapIterator it = this.decorated().mapIterator();
      return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(it);
   }

   public SortedBidiMap inverseBidiMap() {
      if (this.inverse == null) {
         this.inverse = new UnmodifiableSortedBidiMap(this.decorated().inverseBidiMap());
         this.inverse.inverse = this;
      }

      return this.inverse;
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      SortedMap sm = this.decorated().subMap(fromKey, toKey);
      return UnmodifiableSortedMap.unmodifiableSortedMap(sm);
   }

   public SortedMap headMap(Object toKey) {
      SortedMap sm = this.decorated().headMap(toKey);
      return UnmodifiableSortedMap.unmodifiableSortedMap(sm);
   }

   public SortedMap tailMap(Object fromKey) {
      SortedMap sm = this.decorated().tailMap(fromKey);
      return UnmodifiableSortedMap.unmodifiableSortedMap(sm);
   }
}
