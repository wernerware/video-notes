package org.apache.commons.collections4;

import java.util.Iterator;

public interface MapIterator extends Iterator {
   boolean hasNext();

   Object next();

   Object getKey();

   Object getValue();

   void remove();

   Object setValue(Object var1);
}
