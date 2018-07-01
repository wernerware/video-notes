package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.collections4.multimap.TransformedMultiValuedMap;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;

public class MultiMapUtils {
   public static final MultiValuedMap EMPTY_MULTI_VALUED_MAP = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(new ArrayListValuedHashMap(0, 0));

   public static MultiValuedMap emptyMultiValuedMap() {
      return EMPTY_MULTI_VALUED_MAP;
   }

   public static MultiValuedMap emptyIfNull(MultiValuedMap map) {
      return map == null ? EMPTY_MULTI_VALUED_MAP : map;
   }

   public static boolean isEmpty(MultiValuedMap map) {
      return map == null || map.isEmpty();
   }

   public static Collection getCollection(MultiValuedMap map, Object key) {
      return map != null ? map.get(key) : null;
   }

   public static List getValuesAsList(MultiValuedMap map, Object key) {
      if (map != null) {
         Collection col = map.get(key);
         return (List)(col instanceof List ? (List)col : new ArrayList(col));
      } else {
         return null;
      }
   }

   public static Set getValuesAsSet(MultiValuedMap map, Object key) {
      if (map != null) {
         Collection col = map.get(key);
         return (Set)(col instanceof Set ? (Set)col : new HashSet(col));
      } else {
         return null;
      }
   }

   public static Bag getValuesAsBag(MultiValuedMap map, Object key) {
      if (map != null) {
         Collection col = map.get(key);
         return (Bag)(col instanceof Bag ? (Bag)col : new HashBag(col));
      } else {
         return null;
      }
   }

   public static ListValuedMap newListValuedHashMap() {
      return new ArrayListValuedHashMap();
   }

   public static SetValuedMap newSetValuedHashMap() {
      return new HashSetValuedHashMap();
   }

   public static MultiValuedMap unmodifiableMultiValuedMap(MultiValuedMap map) {
      return UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(map);
   }

   public static MultiValuedMap transformedMultiValuedMap(MultiValuedMap map, Transformer keyTransformer, Transformer valueTransformer) {
      return TransformedMultiValuedMap.transformingMap(map, keyTransformer, valueTransformer);
   }
}
