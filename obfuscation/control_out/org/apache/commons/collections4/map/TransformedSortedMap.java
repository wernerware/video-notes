package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.apache.commons.collections4.Transformer;

public class TransformedSortedMap extends TransformedMap implements SortedMap {
   private static final long serialVersionUID = -8751771676410385778L;

   public static TransformedSortedMap transformingSortedMap(SortedMap map, Transformer keyTransformer, Transformer valueTransformer) {
      return new TransformedSortedMap(map, keyTransformer, valueTransformer);
   }

   public static TransformedSortedMap transformedSortedMap(SortedMap map, Transformer keyTransformer, Transformer valueTransformer) {
      TransformedSortedMap decorated = new TransformedSortedMap(map, keyTransformer, valueTransformer);
      if (map.size() > 0) {
         Map transformed = decorated.transformMap(map);
         decorated.clear();
         decorated.decorated().putAll(transformed);
      }

      return decorated;
   }

   protected TransformedSortedMap(SortedMap map, Transformer keyTransformer, Transformer valueTransformer) {
      super(map, keyTransformer, valueTransformer);
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
      return new TransformedSortedMap(map, this.keyTransformer, this.valueTransformer);
   }

   public SortedMap headMap(Object toKey) {
      SortedMap map = this.getSortedMap().headMap(toKey);
      return new TransformedSortedMap(map, this.keyTransformer, this.valueTransformer);
   }

   public SortedMap tailMap(Object fromKey) {
      SortedMap map = this.getSortedMap().tailMap(fromKey);
      return new TransformedSortedMap(map, this.keyTransformer, this.valueTransformer);
   }
}
