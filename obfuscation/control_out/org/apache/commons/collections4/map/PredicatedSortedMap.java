package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.Predicate;

public class PredicatedSortedMap extends PredicatedMap implements SortedMap {
   private static final long serialVersionUID = 3359846175935304332L;

   public static PredicatedSortedMap predicatedSortedMap(SortedMap map, Predicate keyPredicate, Predicate valuePredicate) {
      return new PredicatedSortedMap(map, keyPredicate, valuePredicate);
   }

   protected PredicatedSortedMap(SortedMap map, Predicate keyPredicate, Predicate valuePredicate) {
      super(map, keyPredicate, valuePredicate);
   }

   protected SortedMap getSortedMap() {
      return (SortedMap)this.map;
   }

   public Object firstKey() {
      return this.getSortedMap().firstKey();
   }

   public Object lastKey() {
      return this.getSortedMap().lastKey();
   }

   public Comparator comparator() {
      return this.getSortedMap().comparator();
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      SortedMap map = this.getSortedMap().subMap(fromKey, toKey);
      return new PredicatedSortedMap(map, this.keyPredicate, this.valuePredicate);
   }

   public SortedMap headMap(Object toKey) {
      SortedMap map = this.getSortedMap().headMap(toKey);
      return new PredicatedSortedMap(map, this.keyPredicate, this.valuePredicate);
   }

   public SortedMap tailMap(Object fromKey) {
      SortedMap map = this.getSortedMap().tailMap(fromKey);
      return new PredicatedSortedMap(map, this.keyPredicate, this.valuePredicate);
   }
}
