package org.apache.commons.collections4;

public interface BoundedMap extends IterableMap {
   boolean isFull();

   int maxSize();
}
