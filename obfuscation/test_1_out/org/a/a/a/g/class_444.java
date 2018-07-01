package org.a.a.a.g;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_30;

// $FF: renamed from: org.a.a.a.g.g
public class class_444 implements Serializable, Entry, class_30 {
   // $FF: renamed from: a long
   private static final long field_790 = -8453869361373831205L;
   // $FF: renamed from: b java.util.Map
   private final Map field_791;
   // $FF: renamed from: c java.lang.Object
   private final Object field_792;

   public class_444(Map var1, Object var2) {
      this.field_791 = var1;
      this.field_792 = var2;
   }

   public Object getKey() {
      return this.field_792;
   }

   public Object getValue() {
      return this.field_791.get(this.field_792);
   }

   public Object setValue(Object var1) {
      if (var1 == this) {
         throw new IllegalArgumentException("Cannot set value to this map entry");
      } else {
         return this.field_791.put(this.field_792, var1);
      }
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Entry)) {
         return false;
      } else {
         boolean var10000;
         label43: {
            label29: {
               Entry var2 = (Entry)var1;
               Object var3 = this.getValue();
               if (this.field_792 == null) {
                  if (var2.getKey() != null) {
                     break label29;
                  }
               } else if (!this.field_792.equals(var2.getKey())) {
                  break label29;
               }

               if (var3 == null) {
                  if (var2.getValue() == null) {
                     break label43;
                  }
               } else if (var3.equals(var2.getValue())) {
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
      Object var1 = this.getValue();
      return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (var1 == null ? 0 : var1.hashCode());
   }

   public String toString() {
      return this.getKey() + "=" + this.getValue();
   }
}
