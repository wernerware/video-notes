package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.KeyAnalyzer;

public class StringKeyAnalyzer extends KeyAnalyzer {
   private static final long serialVersionUID = -7032449491269434877L;
   public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
   public static final int LENGTH = 16;
   private static final int MSB = 32768;

   private static int mask(int bit) {
      return '耀' >>> bit;
   }

   public int bitsPerElement() {
      return 16;
   }

   public int lengthInBits(String key) {
      return key != null ? key.length() * 16 : 0;
   }

   public int bitIndex(String key, int offsetInBits, int lengthInBits, String other, int otherOffsetInBits, int otherLengthInBits) {
      boolean allNull = true;
      if (offsetInBits % 16 == 0 && otherOffsetInBits % 16 == 0 && lengthInBits % 16 == 0 && otherLengthInBits % 16 == 0) {
         int beginIndex1 = offsetInBits / 16;
         int beginIndex2 = otherOffsetInBits / 16;
         int endIndex1 = beginIndex1 + lengthInBits / 16;
         int endIndex2 = beginIndex2 + otherLengthInBits / 16;
         int length = Math.max(endIndex1, endIndex2);
         char k = false;
         char f = false;

         for(int i = 0; i < length; ++i) {
            int index1 = beginIndex1 + i;
            int index2 = beginIndex2 + i;
            char k;
            if (index1 >= endIndex1) {
               k = 0;
            } else {
               k = key.charAt(index1);
            }

            char f;
            if (other != null && index2 < endIndex2) {
               f = other.charAt(index2);
            } else {
               f = 0;
            }

            if (k != f) {
               int x = k ^ f;
               return i * 16 + Integer.numberOfLeadingZeros(x) - 16;
            }

            if (k != 0) {
               allNull = false;
            }
         }

         if (allNull) {
            return -1;
         } else {
            return -2;
         }
      } else {
         throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
      }
   }

   public boolean isBitSet(String key, int bitIndex, int lengthInBits) {
      if (key != null && bitIndex < lengthInBits) {
         int index = bitIndex / 16;
         int bit = bitIndex % 16;
         return (key.charAt(index) & mask(bit)) != 0;
      } else {
         return false;
      }
   }

   public boolean isPrefix(String prefix, int offsetInBits, int lengthInBits, String key) {
      if (offsetInBits % 16 == 0 && lengthInBits % 16 == 0) {
         String s1 = prefix.substring(offsetInBits / 16, lengthInBits / 16);
         return key.startsWith(s1);
      } else {
         throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
      }
   }
}
