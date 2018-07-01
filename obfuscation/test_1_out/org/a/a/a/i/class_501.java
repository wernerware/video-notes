package org.a.a.a.i;

import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.Y
class class_501 implements Entry {
   // $FF: renamed from: a org.a.a.a.i.U
   private final class_504 field_911;
   // $FF: renamed from: b int
   private final int field_912;
   // $FF: renamed from: c boolean
   private volatile boolean field_913;

   public class_501(class_504 var1, int var2) {
      this.field_911 = var1;
      this.field_912 = var2;
      this.field_913 = false;
   }

   // $FF: renamed from: a (boolean) void
   void method_1589(boolean var1) {
      this.field_913 = var1;
   }

   public Object getKey() {
      if (this.field_913) {
         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
      } else {
         switch(this.field_912) {
         case 1:
            return class_504.method_1598(this.field_911);
         case 2:
            return class_504.method_1597(this.field_911);
         case 3:
            return class_504.method_1596(this.field_911);
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_912);
         }
      }
   }

   public Object getValue() {
      if (this.field_913) {
         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
      } else {
         switch(this.field_912) {
         case 1:
            return class_504.method_1601(this.field_911);
         case 2:
            return class_504.method_1600(this.field_911);
         case 3:
            return class_504.method_1599(this.field_911);
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_912);
         }
      }
   }

   public Object setValue(Object var1) {
      if (this.field_913) {
         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
      } else {
         Object var2 = this.getValue();
         switch(this.field_912) {
         case 1:
            class_504.method_1604(this.field_911, var1);
            break;
         case 2:
            class_504.method_1603(this.field_911, var1);
            break;
         case 3:
            class_504.method_1602(this.field_911, var1);
            break;
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_912);
         }

         return var2;
      }
   }

   public boolean equals(Object var1) {
      if (this.field_913) {
         return false;
      } else if (!(var1 instanceof Entry)) {
         return false;
      } else {
         boolean var10000;
         label43: {
            label29: {
               Entry var2 = (Entry)var1;
               Object var3 = this.getKey();
               Object var4 = this.getValue();
               if (var3 == null) {
                  if (var2.getKey() != null) {
                     break label29;
                  }
               } else if (!var3.equals(var2.getKey())) {
                  break label29;
               }

               if (var4 == null) {
                  if (var2.getValue() == null) {
                     break label43;
                  }
               } else if (var4.equals(var2.getValue())) {
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
      if (this.field_913) {
         return 0;
      } else {
         Object var1 = this.getKey();
         Object var2 = this.getValue();
         return (var1 == null ? 0 : var1.hashCode()) ^ (var2 == null ? 0 : var2.hashCode());
      }
   }

   public String toString() {
      return !this.field_913 ? this.getKey() + "=" + this.getValue() : "";
   }
}
