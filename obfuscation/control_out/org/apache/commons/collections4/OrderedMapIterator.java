package org.apache.commons.collections4;

public interface OrderedMapIterator extends MapIterator, OrderedIterator {
   boolean hasPrevious();

   Object previous();
}
