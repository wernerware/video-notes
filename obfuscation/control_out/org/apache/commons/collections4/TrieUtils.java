package org.apache.commons.collections4;

import org.apache.commons.collections4.trie.UnmodifiableTrie;

public class TrieUtils {
   public static Trie unmodifiableTrie(Trie trie) {
      return UnmodifiableTrie.unmodifiableTrie(trie);
   }
}
