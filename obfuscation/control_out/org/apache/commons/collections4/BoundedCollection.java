package org.apache.commons.collections4;

import java.util.Collection;

public interface BoundedCollection extends Collection {
   boolean isFull();

   int maxSize();
}
