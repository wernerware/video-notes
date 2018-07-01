package org.a.a.a.g;

import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.g.b
public abstract class class_252 extends class_250 implements Entry {
   protected class_252(Object var1, Object var2) {
      super(var1, var2);
   }

   public Object setValue(Object var1) {
      return super.setValue(var1);
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
}
