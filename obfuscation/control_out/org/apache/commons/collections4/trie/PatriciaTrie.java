package org.apache.commons.collections4.trie;

import java.util.Map;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;

public class PatriciaTrie extends AbstractPatriciaTrie {
   private static final long serialVersionUID = 4446367780901817838L;

   public PatriciaTrie() {
      super(new StringKeyAnalyzer());
   }

   public PatriciaTrie(Map m) {
      super(new StringKeyAnalyzer(), m);
   }
}
