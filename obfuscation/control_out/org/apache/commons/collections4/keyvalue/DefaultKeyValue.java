package org.apache.commons.collections4.keyvalue;

import java.util.Map.Entry;
import org.apache.commons.collections4.KeyValue;

public class DefaultKeyValue extends AbstractKeyValue {
   public DefaultKeyValue() {
      super((Object)null, (Object)null);
   }

   public DefaultKeyValue(Object key, Object value) {
      super(key, value);
   }

   public DefaultKeyValue(KeyValue pair) {
      super(pair.getKey(), pair.getValue());
   }

   public DefaultKeyValue(Entry entry) {
      super(entry.getKey(), entry.getValue());
   }

   public Object setKey(Object key) {
      if (key == this) {
         throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
      } else {
         return super.setKey(key);
      }
   }

   public Object setValue(Object value) {
      if (value == this) {
         throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
      } else {
         return super.setValue(value);
      }
   }

   public Entry toMapEntry() {
      return new DefaultMapEntry(this);
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof DefaultKeyValue)) {
         return false;
      } else {
         boolean var10000;
         label43: {
            label29: {
               DefaultKeyValue other = (DefaultKeyValue)obj;
               if (this.getKey() == null) {
                  if (other.getKey() != null) {
                     break label29;
                  }
               } else if (!this.getKey().equals(other.getKey())) {
                  break label29;
               }

               if (this.getValue() == null) {
                  if (other.getValue() == null) {
                     break label43;
                  }
               } else if (this.getValue().equals(other.getValue())) {
                  break label43;
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }

   public int hashCode() {
      return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
   }
}
