package org.a.a.a.d;

import java.io.Serializable;
import java.util.Comparator;
import org.a.a.a.class_21;
import org.a.a.a.class_405;

// $FF: renamed from: org.a.a.a.d.i
public class class_40 implements Serializable, Comparator {
   // $FF: renamed from: a long
   private static final long field_2 = 3456940356043606220L;
   // $FF: renamed from: b java.util.Comparator
   private final Comparator field_3;
   // $FF: renamed from: c org.a.a.a.aI
   private final class_21 field_4;

   public class_40(class_21 var1) {
      this(var1, class_405.field_713);
   }

   public class_40(class_21 var1, Comparator var2) {
      this.field_3 = var2;
      this.field_4 = var1;
   }

   public int compare(Object var1, Object var2) {
      Object var3 = this.field_4.method_25(var1);
      Object var4 = this.field_4.method_25(var2);
      return this.field_3.compare(var3, var4);
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = var1 * 37 + (this.field_3 == null ? 0 : this.field_3.hashCode());
      var2 = var2 * 37 + (this.field_4 == null ? 0 : this.field_4.hashCode());
      return var2;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (null == var1) {
         return false;
      } else if (!var1.getClass().equals(this.getClass())) {
         return false;
      } else {
         boolean var10000;
         label48: {
            label32: {
               class_40 var2 = (class_40)var1;
               if (null == this.field_3) {
                  if (null != var2.field_3) {
                     break label32;
                  }
               } else if (!this.field_3.equals(var2.field_3)) {
                  break label32;
               }

               if (null == this.field_4) {
                  if (null == var2.field_4) {
                     break label48;
                  }
               } else if (this.field_4.equals(var2.field_4)) {
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
