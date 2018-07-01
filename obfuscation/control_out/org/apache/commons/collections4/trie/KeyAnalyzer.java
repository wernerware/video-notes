package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Comparator;

public abstract class KeyAnalyzer implements Comparator, Serializable {
   private static final long serialVersionUID = -20497563720380683L;
   public static final int NULL_BIT_KEY = -1;
   public static final int EQUAL_BIT_KEY = -2;
   public static final int OUT_OF_BOUNDS_BIT_KEY = -3;

   static boolean isOutOfBoundsIndex(int bitIndex) {
      return bitIndex == -3;
   }

   static boolean isEqualBitKey(int bitIndex) {
      return bitIndex == -2;
   }

   static boolean isNullBitKey(int bitIndex) {
      return bitIndex == -1;
   }

   static boolean isValidBitIndex(int bitIndex) {
      return bitIndex >= 0;
   }

   public abstract int bitsPerElement();

   public abstract int lengthInBits(Object var1);

   public abstract boolean isBitSet(Object var1, int var2, int var3);

   public abstract int bitIndex(Object var1, int var2, int var3, Object var4, int var5, int var6);

   public abstract boolean isPrefix(Object var1, int var2, int var3, Object var4);

   public int compare(Object o1, Object o2) {
      if (o1 == null) {
         return o2 == null ? 0 : -1;
      } else {
         return o2 == null ? 1 : ((Comparable)o1).compareTo(o2);
      }
   }
}
