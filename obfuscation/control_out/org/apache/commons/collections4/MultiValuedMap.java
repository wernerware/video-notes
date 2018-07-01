package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MultiValuedMap {
   int size();

   boolean isEmpty();

   boolean containsKey(Object var1);

   boolean containsValue(Object var1);

   boolean containsMapping(Object var1, Object var2);

   Collection get(Object var1);

   boolean put(Object var1, Object var2);

   boolean putAll(Object var1, Iterable var2);

   boolean putAll(Map var1);

   boolean putAll(MultiValuedMap var1);

   Collection remove(Object var1);

   boolean removeMapping(Object var1, Object var2);

   void clear();

   Collection entries();

   MultiSet keys();

   Set keySet();

   Collection values();

   Map asMap();

   MapIterator mapIterator();
}
