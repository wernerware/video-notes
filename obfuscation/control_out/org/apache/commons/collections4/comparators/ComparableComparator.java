package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class ComparableComparator implements Comparator, Serializable {
   private static final long serialVersionUID = -291439688585137865L;
   public static final ComparableComparator INSTANCE = new ComparableComparator();

   public static ComparableComparator comparableComparator() {
      return INSTANCE;
   }

   public int compare(Comparable obj1, Comparable obj2) {
      return obj1.compareTo(obj2);
   }

   public int hashCode() {
      return "ComparableComparator".hashCode();
   }

   public boolean equals(Object object) {
      return this == object || null != object && object.getClass().equals(this.getClass());
   }
}
