package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

public class LazySortedMap extends LazyMap implements SortedMap {
   private static final long serialVersionUID = 2715322183617658933L;

   public static LazySortedMap lazySortedMap(SortedMap map, Factory factory) {
      return new LazySortedMap(map, factory);
   }

   public static LazySortedMap lazySortedMap(SortedMap map, Transformer factory) {
      return new LazySortedMap(map, factory);
   }

   protected LazySortedMap(SortedMap map, Factory factory) {
      super(map, (Factory)factory);
   }

   protected LazySortedMap(SortedMap map, Transformer factory) {
      super(map, (Transformer)factory);
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
      return new LazySortedMap(map, this.factory);
   }

   public SortedMap headMap(Object toKey) {
      SortedMap map = this.getSortedMap().headMap(toKey);
      return new LazySortedMap(map, this.factory);
   }

   public SortedMap tailMap(Object fromKey) {
      SortedMap map = this.getSortedMap().tailMap(fromKey);
      return new LazySortedMap(map, this.factory);
   }
}
