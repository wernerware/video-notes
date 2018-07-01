package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.KeyValue;

public abstract class AbstractKeyValue implements KeyValue {
   private Object key;
   private Object value;

   protected AbstractKeyValue(Object key, Object value) {
      this.key = key;
      this.value = value;
   }

   public Object getKey() {
      return this.key;
   }

   protected Object setKey(Object key) {
      Object old = this.key;
      this.key = key;
      return old;
   }

   public Object getValue() {
      return this.value;
   }

   protected Object setValue(Object value) {
      Object old = this.value;
      this.value = value;
      return old;
   }

   public String toString() {
      return "" + this.getKey() + '=' + this.getValue();
   }
}
