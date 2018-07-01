package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.commons.collections4.Trie;

public abstract class AbstractBitwiseTrie extends AbstractMap implements Trie, Serializable {
   private static final long serialVersionUID = 5826987063535505652L;
   private final KeyAnalyzer keyAnalyzer;

   protected AbstractBitwiseTrie(KeyAnalyzer keyAnalyzer) {
      if (keyAnalyzer == null) {
         throw new NullPointerException("keyAnalyzer");
      } else {
         this.keyAnalyzer = keyAnalyzer;
      }
   }

   protected KeyAnalyzer getKeyAnalyzer() {
      return this.keyAnalyzer;
   }

   public String toString() {
      StringBuilder buffer = new StringBuilder();
      buffer.append("Trie[").append(this.size()).append("]={\n");
      Iterator i$ = this.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         buffer.append("  ").append(entry).append("\n");
      }

      buffer.append("}\n");
      return buffer.toString();
   }

   final Object castKey(Object key) {
      return key;
   }

   final int lengthInBits(Object key) {
      return key == null ? 0 : this.keyAnalyzer.lengthInBits(key);
   }

   final int bitsPerElement() {
      return this.keyAnalyzer.bitsPerElement();
   }

   final boolean isBitSet(Object key, int bitIndex, int lengthInBits) {
      return key == null ? false : this.keyAnalyzer.isBitSet(key, bitIndex, lengthInBits);
   }

   final int bitIndex(Object key, Object foundKey) {
      return this.keyAnalyzer.bitIndex(key, 0, this.lengthInBits(key), foundKey, 0, this.lengthInBits(foundKey));
   }

   final boolean compareKeys(Object key, Object other) {
      if (key == null) {
         return other == null;
      } else if (other == null) {
         return false;
      } else {
         return this.keyAnalyzer.compare(key, other) == 0;
      }
   }

   static boolean compare(Object a, Object b) {
      return a == null ? b == null : a.equals(b);
   }

   abstract static class BasicEntry implements Entry, Serializable {
      private static final long serialVersionUID = -944364551314110330L;
      protected Object key;
      protected Object value;

      public BasicEntry(Object key) {
         this.key = key;
      }

      public BasicEntry(Object key, Object value) {
         this.key = key;
         this.value = value;
      }

      public Object setKeyValue(Object key, Object value) {
         this.key = key;
         return this.setValue(value);
      }

      public Object getKey() {
         return this.key;
      }

      public Object getValue() {
         return this.value;
      }

      public Object setValue(Object value) {
         Object previous = this.value;
         this.value = value;
         return previous;
      }

      public int hashCode() {
         return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
      }

      public boolean equals(Object o) {
         if (o == this) {
            return true;
         } else if (!(o instanceof Entry)) {
            return false;
         } else {
            Entry other = (Entry)o;
            return AbstractBitwiseTrie.compare(this.key, other.getKey()) && AbstractBitwiseTrie.compare(this.value, other.getValue());
         }
      }

      public String toString() {
         return this.key + "=" + this.value;
      }
   }
}
