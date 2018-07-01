package org.a.a.a.i;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.i.z
class class_485 {
   // $FF: renamed from: a org.a.a.a.i.y
   final class_157 field_886;
   // $FF: renamed from: b int
   int field_887;
   // $FF: renamed from: c org.a.a.a.i.A
   class_498 field_888;
   // $FF: renamed from: d org.a.a.a.i.A
   class_498 field_889;
   // $FF: renamed from: e java.lang.Object
   Object field_890;
   // $FF: renamed from: f java.lang.Object
   Object field_891;
   // $FF: renamed from: g java.lang.Object
   Object field_892;
   // $FF: renamed from: h java.lang.Object
   Object field_893;
   // $FF: renamed from: i int
   int field_894;

   public class_485(class_157 var1) {
      this.field_886 = var1;
      this.field_887 = var1.size() != 0 ? var1.n.length : 0;
      this.field_894 = var1.p;
   }

   public boolean hasNext() {
      this.method_1580();

      while(this.method_1581()) {
         class_498 var1 = this.field_888;

         int var2;
         for(var2 = this.field_887; var1 == null && var2 > 0; var1 = (class_498)this.field_886.n[var2]) {
            --var2;
         }

         this.field_888 = var1;
         this.field_887 = var2;
         if (var1 == null) {
            this.field_890 = null;
            this.field_892 = null;
            return false;
         }

         this.field_891 = var1.getKey();
         this.field_893 = var1.getValue();
         if (this.method_1581()) {
            this.field_888 = this.field_888.method_1588();
         }
      }

      return true;
   }

   // $FF: renamed from: a () void
   private void method_1580() {
      if (this.field_886.p != this.field_894) {
         throw new ConcurrentModificationException();
      }
   }

   // $FF: renamed from: b () boolean
   private boolean method_1581() {
      return this.field_891 == null || this.field_893 == null;
   }

   // $FF: renamed from: c () org.a.a.a.i.A
   protected class_498 method_1582() {
      this.method_1580();
      if (this.method_1581() && !this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.field_889 = this.field_888;
         this.field_888 = this.field_888.method_1588();
         this.field_890 = this.field_891;
         this.field_892 = this.field_893;
         this.field_891 = null;
         this.field_893 = null;
         return this.field_889;
      }
   }

   // $FF: renamed from: d () org.a.a.a.i.A
   protected class_498 method_1583() {
      this.method_1580();
      return this.field_889;
   }

   public void remove() {
      this.method_1580();
      if (this.field_889 == null) {
         throw new IllegalStateException();
      } else {
         this.field_886.remove(this.field_890);
         this.field_889 = null;
         this.field_890 = null;
         this.field_892 = null;
         this.field_894 = this.field_886.p;
      }
   }
}
