package org.a.a.a.l;

import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.l.c
class class_369 implements Iterator {
   // $FF: renamed from: b int
   private int field_642;
   // $FF: renamed from: c int
   private int field_643;
   // $FF: renamed from: d boolean
   private boolean field_644;
   // $FF: renamed from: a org.a.a.a.l.b
   // $FF: synthetic field
   final class_368 field_645;

   class_369(class_368 var1) {
      this.field_645 = var1;
      this.field_642 = class_368.method_1082(this.field_645);
      this.field_643 = -1;
      this.field_644 = class_368.method_1083(this.field_645);
   }

   public boolean hasNext() {
      return this.field_644 || this.field_642 != class_368.method_1084(this.field_645);
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.field_644 = false;
         this.field_643 = this.field_642;
         this.field_642 = class_368.method_1085(this.field_645, this.field_642);
         return class_368.method_1086(this.field_645)[this.field_643];
      }
   }

   public void remove() {
      if (this.field_643 == -1) {
         throw new IllegalStateException();
      } else if (this.field_643 == class_368.method_1082(this.field_645)) {
         this.field_645.remove();
         this.field_643 = -1;
      } else {
         int var1 = this.field_643 + 1;
         if (class_368.method_1082(this.field_645) < this.field_643 && var1 < class_368.method_1084(this.field_645)) {
            System.arraycopy(class_368.method_1086(this.field_645), var1, class_368.method_1086(this.field_645), this.field_643, class_368.method_1084(this.field_645) - var1);
         } else {
            while(var1 != class_368.method_1084(this.field_645)) {
               if (var1 >= class_368.method_1087(this.field_645)) {
                  class_368.method_1086(this.field_645)[var1 - 1] = class_368.method_1086(this.field_645)[0];
                  var1 = 0;
               } else {
                  class_368.method_1086(this.field_645)[class_368.method_1088(this.field_645, var1)] = class_368.method_1086(this.field_645)[var1];
                  var1 = class_368.method_1085(this.field_645, var1);
               }
            }
         }

         this.field_643 = -1;
         class_368.method_1089(this.field_645, class_368.method_1088(this.field_645, class_368.method_1084(this.field_645)));
         class_368.method_1086(this.field_645)[class_368.method_1084(this.field_645)] = null;
         class_368.method_1090(this.field_645, false);
         this.field_642 = class_368.method_1088(this.field_645, this.field_642);
      }
   }
}
