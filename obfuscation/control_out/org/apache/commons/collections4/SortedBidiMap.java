package org.apache.commons.collections4;

import java.util.Comparator;
import java.util.SortedMap;

public interface SortedBidiMap extends OrderedBidiMap, SortedMap {
   SortedBidiMap inverseBidiMap();

   Comparator valueComparator();
}
