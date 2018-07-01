package org.apache.commons.collections4.keyvalue;

import java.util.Map.Entry;

public abstract class AbstractMapEntry extends AbstractKeyValue implements Entry {
   protected AbstractMapEntry(Object key, Object value) {
      super(key, value);
   }

   public Object setValue(Object value) {
      return super.setValue(value);
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
