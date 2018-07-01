package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;

public class DefaultEquator implements Equator, Serializable {
   private static final long serialVersionUID = 825802648423525485L;
   public static final DefaultEquator INSTANCE = new DefaultEquator();
   public static final int HASHCODE_NULL = -1;

   public static DefaultEquator defaultEquator() {
      return INSTANCE;
   }

   public boolean equate(Object o1, Object o2) {
      return o1 == o2 || o1 != null && o1.equals(o2);
   }

   public int hash(Object o) {
      return o == null ? -1 : o.hashCode();
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
