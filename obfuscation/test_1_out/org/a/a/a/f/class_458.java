package org.a.a.a.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_384;

// $FF: renamed from: org.a.a.a.f.T
public class class_458 implements Iterator {
   // $FF: renamed from: a java.util.Iterator
   private final Iterator field_835;
   // $FF: renamed from: b java.util.Iterator
   private Iterator field_836;
   // $FF: renamed from: c java.util.Iterator
   private Iterator field_837;

   public class_458(Iterator var1, Iterator var2) {
      this(var1, var2);
   }

   public class_458(Iterator var1, Iterator var2, Iterator var3) {
      this(var1, var2, var3);
   }

   public class_458(Iterator... var1) {
      this.field_836 = null;
      this.field_837 = null;
      ArrayList var2 = new ArrayList();
      Iterator[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Iterator var6 = var3[var5];
         if (var6 == null) {
            throw new NullPointerException("Iterator must not be null.");
         }

         var2.add(var6);
      }

      this.field_835 = class_384.method_1110(var2).method_1118().iterator();
   }

   public boolean hasNext() {
      if (this.field_836 != null) {
         return true;
      } else {
         while(this.field_835.hasNext()) {
            Iterator var1 = (Iterator)this.field_835.next();
            if (var1.hasNext()) {
               this.field_836 = var1;
               return true;
            }

            this.field_835.remove();
         }

         return false;
      }
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Object var1 = this.field_836.next();
         this.field_837 = this.field_836;
         this.field_836 = null;
         return var1;
      }
   }

   public void remove() {
      if (this.field_837 == null) {
         throw new IllegalStateException("No value can be removed at present");
      } else {
         this.field_837.remove();
         this.field_837 = null;
      }
   }
}
