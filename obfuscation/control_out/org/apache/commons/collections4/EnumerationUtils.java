package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.collections4.iterators.EnumerationIterator;

public class EnumerationUtils {
   public static Object get(Enumeration e, int index) {
      int i = index;
      CollectionUtils.checkIndexBounds(index);

      while(e.hasMoreElements()) {
         --i;
         if (i == -1) {
            return e.nextElement();
         }

         e.nextElement();
      }

      throw new IndexOutOfBoundsException("Entry does not exist: " + i);
   }

   public static List toList(Enumeration enumeration) {
      return IteratorUtils.toList(new EnumerationIterator(enumeration));
   }

   public static List toList(StringTokenizer stringTokenizer) {
      ArrayList result = new ArrayList(stringTokenizer.countTokens());

      while(stringTokenizer.hasMoreTokens()) {
         result.add(stringTokenizer.nextToken());
      }

      return result;
   }
}
