package org.apache.commons.collections4;

import java.util.Comparator;

public interface SortedBag extends Bag {
   Comparator comparator();

   Object first();

   Object last();
}
