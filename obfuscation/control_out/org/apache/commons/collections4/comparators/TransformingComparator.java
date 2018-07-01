package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;

public class TransformingComparator implements Comparator, Serializable {
   private static final long serialVersionUID = 3456940356043606220L;
   private final Comparator decorated;
   private final Transformer transformer;

   public TransformingComparator(Transformer transformer) {
      this(transformer, ComparatorUtils.NATURAL_COMPARATOR);
   }

   public TransformingComparator(Transformer transformer, Comparator decorated) {
      this.decorated = decorated;
      this.transformer = transformer;
   }

   public int compare(Object obj1, Object obj2) {
      Object value1 = this.transformer.transform(obj1);
      Object value2 = this.transformer.transform(obj2);
      return this.decorated.compare(value1, value2);
   }

   public int hashCode() {
      int total = 17;
      int total = total * 37 + (this.decorated == null ? 0 : this.decorated.hashCode());
      total = total * 37 + (this.transformer == null ? 0 : this.transformer.hashCode());
      return total;
   }

   public boolean equals(Object object) {
      if (this == object) {
         return true;
      } else if (null == object) {
         return false;
      } else if (!object.getClass().equals(this.getClass())) {
         return false;
      } else {
         boolean var10000;
         label48: {
            label32: {
               TransformingComparator comp = (TransformingComparator)object;
               if (null == this.decorated) {
                  if (null != comp.decorated) {
                     break label32;
                  }
               } else if (!this.decorated.equals(comp.decorated)) {
                  break label32;
               }

               if (null == this.transformer) {
                  if (null == comp.transformer) {
                     break label48;
                  }
               } else if (this.transformer.equals(comp.transformer)) {
                  break label48;
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }
}
