package org.apache.commons.collections4.keyvalue;

import java.util.Map.Entry;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.Unmodifiable;

public final class UnmodifiableMapEntry extends AbstractMapEntry implements Unmodifiable {
   public UnmodifiableMapEntry(Object key, Object value) {
      super(key, value);
   }

   public UnmodifiableMapEntry(KeyValue pair) {
      super(pair.getKey(), pair.getValue());
   }

   public UnmodifiableMapEntry(Entry entry) {
      super(entry.getKey(), entry.getValue());
   }

   public Object setValue(Object value) {
      throw new UnsupportedOperationException("setValue() is not supported");
   }
}
