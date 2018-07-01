package org.a.a.a.d;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: org.a.a.a.d.d
public class class_43 implements Serializable, Comparator {
   // $FF: renamed from: a long
   private static final long field_12 = 82794675842863201L;
   // $FF: renamed from: b java.util.Map
   private final Map field_13 = new HashMap();
   // $FF: renamed from: c int
   private int field_14 = 0;
   // $FF: renamed from: d boolean
   private boolean field_15 = false;
   // $FF: renamed from: e org.a.a.a.d.f
   private class_41 field_16;

   public class_43() {
      this.field_16 = class_41.field_7;
   }

   public class_43(Object... var1) {
      this.field_16 = class_41.field_7;
      if (var1 == null) {
         throw new NullPointerException("The list of items must not be null");
      } else {
         Object[] var2 = var1;
         int var3 = var1.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Object var5 = var2[var4];
            this.method_84(var5);
         }

      }
   }

   public class_43(List var1) {
      this.field_16 = class_41.field_7;
      if (var1 == null) {
         throw new NullPointerException("The list of items must not be null");
      } else {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.method_84(var3);
         }

      }
   }

   // $FF: renamed from: a () boolean
   public boolean method_80() {
      return this.field_15;
   }

   // $FF: renamed from: b () void
   protected void method_81() {
      if (this.method_80()) {
         throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
      }
   }

   // $FF: renamed from: c () org.a.a.a.d.f
   public class_41 method_82() {
      return this.field_16;
   }

   // $FF: renamed from: a (org.a.a.a.d.f) void
   public void method_83(class_41 var1) {
      this.method_81();
      if (var1 == null) {
         throw new NullPointerException("Unknown object behavior must not be null");
      } else {
         this.field_16 = var1;
      }
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_84(Object var1) {
      this.method_81();
      Integer var2 = (Integer)this.field_13.put(var1, this.field_14++);
      return var2 == null;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   public boolean method_85(Object var1, Object var2) {
      this.method_81();
      Integer var3 = (Integer)this.field_13.get(var1);
      if (var3 == null) {
         throw new IllegalArgumentException(var1 + " not known to " + this);
      } else {
         Integer var4 = (Integer)this.field_13.put(var2, var3);
         return var4 == null;
      }
   }

   public int compare(Object var1, Object var2) {
      this.field_15 = true;
      Integer var3 = (Integer)this.field_13.get(var1);
      Integer var4 = (Integer)this.field_13.get(var2);
      if (var3 != null && var4 != null) {
         return var3.compareTo(var4);
      } else {
         switch(class_44.field_17[this.field_16.ordinal()]) {
         case 1:
            return var3 == null ? (var4 == null ? 0 : -1) : 1;
         case 2:
            return var3 == null ? (var4 == null ? 0 : 1) : -1;
         case 3:
            Object var5 = var3 == null ? var1 : var2;
            throw new IllegalArgumentException("Attempting to compare unknown object " + var5);
         default:
            throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.field_16);
         }
      }
   }

   public int hashCode() {
      byte var1 = 17;
      int var2 = var1 * 37 + (this.field_13 == null ? 0 : this.field_13.hashCode());
      var2 = var2 * 37 + (this.field_16 == null ? 0 : this.field_16.hashCode());
      var2 = var2 * 37 + this.field_14;
      var2 = var2 * 37 + (this.field_15 ? 0 : 1);
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
         label54: {
            label38: {
               class_43 var2 = (class_43)var1;
               if (null == this.field_13) {
                  if (null != var2.field_13) {
                     break label38;
                  }
               } else if (!this.field_13.equals(var2.field_13)) {
                  break label38;
               }

               if (null == this.field_16) {
                  if (null == var2.field_16) {
                     break label54;
                  }
               } else if (this.field_16 == var2.field_16 && this.field_14 == var2.field_14 && this.field_15 == var2.field_15 && this.field_16 == var2.field_16) {
                  break label54;
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
