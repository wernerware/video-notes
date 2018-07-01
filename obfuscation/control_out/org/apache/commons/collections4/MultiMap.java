package org.apache.commons.collections4;

import java.util.Collection;

/** @deprecated */
@Deprecated
public interface MultiMap extends IterableMap {
   boolean removeMapping(Object var1, Object var2);

   int size();

   Object get(Object var1);

   boolean containsValue(Object var1);

   Object put(Object var1, Object var2);

   Object remove(Object var1);

   Collection values();
}
