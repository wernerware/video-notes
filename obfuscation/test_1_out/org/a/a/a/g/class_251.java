package org.a.a.a.g;

import java.util.Map.Entry;
import org.a.a.a.class_30;

// $FF: renamed from: org.a.a.a.g.d
public class class_251 extends class_250 {
   public class_251() {
      super((Object)null, (Object)null);
   }

   public class_251(Object var1, Object var2) {
      super(var1, var2);
   }

   public class_251(class_30 var1) {
      super(var1.getKey(), var1.getValue());
   }

   public class_251(Entry var1) {
      super(var1.getKey(), var1.getValue());
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_608(Object var1) {
      if (var1 == this) {
         throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
      } else {
         return super.method_608(var1);
      }
   }

   public Object setValue(Object var1) {
      if (var1 == this) {
         throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
      } else {
         return super.setValue(var1);
      }
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_609() {
      return new class_254(this);
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof class_251)) {
         return false;
      } else {
         boolean var10000;
         label43: {
            label29: {
               class_251 var2 = (class_251)var1;
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
