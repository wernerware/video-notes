package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.KeyValue;

public class TiedMapEntry implements Entry, KeyValue, Serializable {
   private static final long serialVersionUID = -8453869361373831205L;
   private final Map map;
   private final Object key;

   public TiedMapEntry(Map map, Object key) {
      this.map = map;
      this.key = key;
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.map.get(this.key);
   }

   public Object setValue(Object value) {
      if (value == this) {
         throw new IllegalArgumentException("Cannot set value to this map entry");
      } else {
         return this.map.put(this.key, value);
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof Entry)) {
         return false;
      } else {
         boolean var10000;
         label43: {
            label29: {
               Entry other = (Entry)obj;
               Object value = this.getValue();
               if (this.key == null) {
                  if (other.getKey() != null) {
                     break label29;
                  }
               } else if (!this.key.equals(other.getKey())) {
                  break label29;
               }

               if (value == null) {
                  if (other.getValue() == null) {
                     break label43;
                  }
               } else if (value.equals(other.getValue())) {
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
      Object value = this.getValue();
      return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (value == null ? 0 : value.hashCode());
   }

   public String toString() {
      return this.getKey() + "=" + this.getValue();
   }
}
