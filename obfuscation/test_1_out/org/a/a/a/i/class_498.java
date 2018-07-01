package org.a.a.a.i;

import java.lang.ref.Reference;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.A
public class class_498 extends class_496 {
   // $FF: renamed from: e org.a.a.a.i.y
   private final class_157 field_909;

   public class_498(class_157 var1, class_496 var2, int var3, Object var4, Object var5) {
      super(var2, var3, (Object)null, (Object)null);
      this.field_909 = var1;
      this.c = this.method_1586(class_157.method_499(var1), var4, var3);
      this.d = this.method_1586(class_157.method_500(var1), var5, var3);
   }

   public Object getKey() {
      return class_157.method_499(this.field_909) == class_491.field_896 ? this.c : ((Reference)this.c).get();
   }

   public Object getValue() {
      return class_157.method_500(this.field_909) == class_491.field_896 ? this.d : ((Reference)this.d).get();
   }

   public Object setValue(Object var1) {
      Object var2 = this.getValue();
      if (class_157.method_500(this.field_909) != class_491.field_896) {
         ((Reference)this.d).clear();
      }

      this.d = this.method_1586(class_157.method_500(this.field_909), var1, this.b);
      return var2;
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         Object var4 = var2.getValue();
         if (var3 != null && var4 != null) {
            return this.field_909.method_439(var3, this.c) && this.field_909.b(var4, this.getValue());
         } else {
            return false;
         }
      }
   }

   public int hashCode() {
      return this.field_909.method_496(this.getKey(), this.getValue());
   }

   // $FF: renamed from: a (org.a.a.a.i.G, java.lang.Object, int) java.lang.Object
   protected Object method_1586(class_491 var1, Object var2, int var3) {
      if (var1 == class_491.field_896) {
         return var2;
      } else if (var1 == class_491.field_897) {
         return new class_490(var3, var2, class_157.method_501(this.field_909));
      } else if (var1 == class_491.field_898) {
         return new class_507(var3, var2, class_157.method_501(this.field_909));
      } else {
         throw new Error();
      }
   }

   // $FF: renamed from: a (java.lang.ref.Reference) boolean
   boolean method_1587(Reference var1) {
      boolean var2 = class_157.method_499(this.field_909) != class_491.field_896 && this.c == var1;
      var2 = var2 || class_157.method_500(this.field_909) != class_491.field_896 && this.d == var1;
      if (var2) {
         if (class_157.method_499(this.field_909) != class_491.field_896) {
            ((Reference)this.c).clear();
         }

         if (class_157.method_500(this.field_909) != class_491.field_896) {
            ((Reference)this.d).clear();
         } else if (class_157.method_502(this.field_909)) {
            this.d = null;
         }
      }

      return var2;
   }

   // $FF: renamed from: a () org.a.a.a.i.A
   protected class_498 method_1588() {
      return (class_498)this.a;
   }
}
