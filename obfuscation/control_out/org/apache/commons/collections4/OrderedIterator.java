package org.apache.commons.collections4;

import java.util.Iterator;

public interface OrderedIterator extends Iterator {
   boolean hasPrevious();

   Object previous();
}
