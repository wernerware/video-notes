package org.a.a.a.i;

import java.util.Map.Entry;
import org.a.a.a.class_30;

// $FF: renamed from: org.a.a.a.i.d
public class class_496 implements Entry, class_30 {
   // $FF: renamed from: a org.a.a.a.i.d
   protected class_496 field_903;
   // $FF: renamed from: b int
   protected int field_904;
   // $FF: renamed from: c java.lang.Object
   protected Object field_905;
   // $FF: renamed from: d java.lang.Object
   protected Object field_906;

   protected class_496(class_496 var1, int var2, Object var3, Object var4) {
      this.field_903 = var1;
      this.field_904 = var2;
      this.field_905 = var3;
      this.field_906 = var4;
   }

   public Object getKey() {
      return this.field_905 == class_151.field_178 ? null : this.field_905;
   }

   public Object getValue() {
      return this.field_906;
   }

   public Object setValue(Object var1) {
      Object var2 = this.field_906;
      this.field_906 = var1;
      return var2;
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
               if (this.getKey() == null) {
                  if (var2.getKey() != null) {
                     break label29;
                  }
               } else if (!this.getKey().equals(var2.getKey())) {
                  break label29;
               }

               if (this.getValue() == null) {
                  if (var2.getValue() == null) {
                     break label43;
                  }
               } else if (this.getValue().equals(var2.getValue())) {
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

   public String toString() {
      return "" + this.getKey() + '=' + this.getValue();
   }
}
