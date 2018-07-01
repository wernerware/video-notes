package org.apache.commons.collections4.map;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;

public abstract class AbstractIterableMap implements IterableMap {
   public MapIterator mapIterator() {
      return new EntrySetToMapIteratorAdapter(this.entrySet());
   }
}
