package org.a.a.a.i;

import java.util.Map.Entry;
import org.a.a.a.class_30;

// $FF: renamed from: org.a.a.a.i.aT
final class class_204 implements Entry, class_30 {
   // $FF: renamed from: a java.lang.Object
   protected Object field_275;
   // $FF: renamed from: b java.lang.Object
   protected Object field_276;
   // $FF: renamed from: c org.a.a.a.i.aT
   protected class_204 field_277;

   private class_204() {
   }

   public Object getKey() {
      return this.field_275;
   }

   public Object getValue() {
      return this.field_276;
   }

   public int hashCode() {
      return (this.field_275 == null ? 0 : this.field_275.hashCode()) ^ (this.field_276 == null ? 0 : this.field_276.hashCode());
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
               if (this.field_275 == null) {
                  if (var2.getKey() != null) {
                     break label29;
                  }
               } else if (!this.field_275.equals(var2.getKey())) {
                  break label29;
               }

               if (this.field_276 == null) {
                  if (var2.getValue() == null) {
                     break label43;
                  }
               } else if (this.field_276.equals(var2.getValue())) {
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

   public Object setValue(Object var1) {
      Object var2 = this.field_276;
      this.field_276 = var1;
      return var2;
   }

   // $FF: synthetic method
   class_204(class_174 var1) {
      this();
   }
}
