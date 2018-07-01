package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;

public final class BooleanComparator implements Comparator, Serializable {
   private static final long serialVersionUID = 1830042991606340609L;
   private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);
   private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);
   private boolean trueFirst;

   public static BooleanComparator getTrueFirstComparator() {
      return TRUE_FIRST;
   }

   public static BooleanComparator getFalseFirstComparator() {
      return FALSE_FIRST;
   }

   public static BooleanComparator booleanComparator(boolean trueFirst) {
      return trueFirst ? TRUE_FIRST : FALSE_FIRST;
   }

   public BooleanComparator() {
      this(false);
   }

   public BooleanComparator(boolean trueFirst) {
      this.trueFirst = false;
      this.trueFirst = trueFirst;
   }

   public int compare(Boolean b1, Boolean b2) {
      boolean v1 = b1;
      boolean v2 = b2;
      return v1 ^ v2 ? (v1 ^ this.trueFirst ? 1 : -1) : 0;
   }

   public int hashCode() {
      int hash = "BooleanComparator".hashCode();
      return this.trueFirst ? -1 * hash : hash;
   }

   public boolean equals(Object object) {
      return this == object || object instanceof BooleanComparator && this.trueFirst == ((BooleanComparator)object).trueFirst;
   }

   public boolean sortsTrueFirst() {
      return this.trueFirst;
   }
}
