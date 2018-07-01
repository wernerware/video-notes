package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Set;

public interface Get {
   boolean containsKey(Object var1);

   boolean containsValue(Object var1);

   Set entrySet();

   Object get(Object var1);

   Object remove(Object var1);

   boolean isEmpty();

   Set keySet();

   int size();

   Collection values();
}
