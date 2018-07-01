package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import org.apache.commons.collections4.ResettableListIterator;

public class EmptyListIterator extends AbstractEmptyIterator implements ResettableListIterator {
   public static final ResettableListIterator RESETTABLE_INSTANCE = new EmptyListIterator();
   public static final ListIterator INSTANCE;

   public static ResettableListIterator resettableEmptyListIterator() {
      return RESETTABLE_INSTANCE;
   }

   public static ListIterator emptyListIterator() {
      return INSTANCE;
   }

   static {
      INSTANCE = RESETTABLE_INSTANCE;
   }
}
