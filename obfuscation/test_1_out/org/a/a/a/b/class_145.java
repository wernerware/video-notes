package org.a.a.a.b;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.b.E
abstract class class_145 {
   // $FF: renamed from: a org.a.a.a.b.u
   private final class_361 field_150;
   // $FF: renamed from: b org.a.a.a.b.B
   class_150 field_151;
   // $FF: renamed from: d org.a.a.a.b.B
   private class_150 field_152;
   // $FF: renamed from: e org.a.a.a.b.B
   private class_150 field_153;
   // $FF: renamed from: f int
   private int field_154;
   // $FF: renamed from: c org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_155;

   class_145(class_362 var1, class_361 var2) {
      this.field_155 = var1;
      this.field_150 = var2;
      this.field_154 = class_362.method_1050(var1);
      this.field_152 = class_362.method_1052(var1, class_362.method_1051(var1)[var2.ordinal()], var2);
      this.field_151 = null;
      this.field_153 = null;
   }

   public final boolean hasNext() {
      return this.field_152 != null;
   }

   // $FF: renamed from: g () org.a.a.a.b.B
   protected class_150 method_385() {
      if (this.field_152 == null) {
         throw new NoSuchElementException();
      } else if (class_362.method_1050(this.field_155) != this.field_154) {
         throw new ConcurrentModificationException();
      } else {
         this.field_151 = this.field_152;
         this.field_153 = this.field_152;
         this.field_152 = class_362.method_1053(this.field_155, this.field_152, this.field_150);
         return this.field_151;
      }
   }

   public boolean hasPrevious() {
      return this.field_153 != null;
   }

   // $FF: renamed from: h () org.a.a.a.b.B
   protected class_150 method_386() {
      if (this.field_153 == null) {
         throw new NoSuchElementException();
      } else if (class_362.method_1050(this.field_155) != this.field_154) {
         throw new ConcurrentModificationException();
      } else {
         this.field_152 = this.field_151;
         if (this.field_152 == null) {
            this.field_152 = class_362.method_1053(this.field_155, this.field_153, this.field_150);
         }

         this.field_151 = this.field_153;
         this.field_153 = class_362.method_1054(this.field_155, this.field_153, this.field_150);
         return this.field_151;
      }
   }

   public final void remove() {
      if (this.field_151 == null) {
         throw new IllegalStateException();
      } else if (class_362.method_1050(this.field_155) != this.field_154) {
         throw new ConcurrentModificationException();
      } else {
         class_362.method_1049(this.field_155, this.field_151);
         ++this.field_154;
         this.field_151 = null;
         if (this.field_152 == null) {
            this.field_153 = class_362.method_1055(this.field_155, class_362.method_1051(this.field_155)[this.field_150.ordinal()], this.field_150);
         } else {
            this.field_153 = class_362.method_1054(this.field_155, this.field_152, this.field_150);
         }

      }
   }
}
