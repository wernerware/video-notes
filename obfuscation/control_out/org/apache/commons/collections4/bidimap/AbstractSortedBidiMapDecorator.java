package org.apache.commons.collections4.bidimap;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.SortedBidiMap;

public abstract class AbstractSortedBidiMapDecorator extends AbstractOrderedBidiMapDecorator implements SortedBidiMap {
   public AbstractSortedBidiMapDecorator(SortedBidiMap map) {
      super(map);
   }

   protected SortedBidiMap decorated() {
      return (SortedBidiMap)super.decorated();
   }

   public SortedBidiMap inverseBidiMap() {
      return this.decorated().inverseBidiMap();
   }

   public Comparator comparator() {
      return this.decorated().comparator();
   }

   public Comparator valueComparator() {
      return this.decorated().valueComparator();
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      return this.decorated().subMap(fromKey, toKey);
   }

   public SortedMap headMap(Object toKey) {
      return this.decorated().headMap(toKey);
   }

   public SortedMap tailMap(Object fromKey) {
      return this.decorated().tailMap(fromKey);
   }
}
