package org.a.a.a.p;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.p.n
class class_323 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.p.p
   private final class_318 field_538;
   // $FF: renamed from: c int
   private transient int field_539;
   // $FF: renamed from: d int
   private transient int field_540;
   // $FF: renamed from: b org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_541;

   public class_323(class_303 var1, class_318 var2) {
      this.field_541 = var1;
      this.field_539 = -1;
      if (var2 == null) {
         throw new NullPointerException("delegate");
      } else {
         this.field_538 = var2;
      }
   }

   public Iterator iterator() {
      Object var1 = this.field_538.method_752();
      Object var2 = this.field_538.method_754();
      class_301 var3 = null;
      if (var1 == null) {
         var3 = this.field_541.method_727();
      } else {
         var3 = this.field_541.method_731(var1);
      }

      class_301 var4 = null;
      if (var2 != null) {
         var4 = this.field_541.method_731(var2);
      }

      return new class_317(this, var3, var4, (class_330)null);
   }

   public int size() {
      if (this.field_539 == -1 || this.field_540 != this.field_541.field_488) {
         this.field_539 = 0;
         Iterator var1 = this.iterator();

         while(var1.hasNext()) {
            ++this.field_539;
            var1.next();
         }

         this.field_540 = this.field_541.field_488;
      }

      return this.field_539;
   }

   public boolean isEmpty() {
      return !this.iterator().hasNext();
   }

   public boolean contains(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         if (!this.field_538.method_756(var3)) {
            return false;
         } else {
            class_301 var4 = this.field_541.method_716(var3);
            return var4 != null && class_302.method_711(var4.getValue(), var2.getValue());
         }
      }
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         Object var3 = var2.getKey();
         if (!this.field_538.method_756(var3)) {
            return false;
         } else {
            class_301 var4 = this.field_541.method_716(var3);
            if (var4 != null && class_302.method_711(var4.getValue(), var2.getValue())) {
               this.field_541.method_722(var4);
               return true;
            } else {
               return false;
            }
         }
      }
   }
}
