package org.apache.commons.collections4;

public interface OrderedMap extends IterableMap {
   OrderedMapIterator mapIterator();

   Object firstKey();

   Object lastKey();

   Object nextKey(Object var1);

   Object previousKey(Object var1);
}
