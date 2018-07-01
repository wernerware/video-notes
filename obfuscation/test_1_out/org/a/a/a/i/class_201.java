package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.aP
class class_201 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.aL
   // $FF: synthetic field
   final class_115 field_272;

   private class_201(class_115 var1) {
      this.field_272 = var1;
   }

   public int size() {
      return this.field_272.size();
   }

   public void clear() {
      this.field_272.clear();
   }

   public Iterator iterator() {
      return new class_194(this.field_272, (class_174)null);
   }

   public boolean contains(Object var1) {
      Entry var2 = (Entry)var1;
      int var3 = class_115.method_257(this.field_272, var2.getKey());
      synchronized(class_115.method_256(this.field_272)[var3]) {
         for(class_204 var5 = class_115.method_255(this.field_272)[var3]; var5 != null; var5 = var5.field_277) {
            if (var5.equals(var2)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         int var3 = class_115.method_257(this.field_272, var2.getKey());
         synchronized(class_115.method_256(this.field_272)[var3]) {
            for(class_204 var5 = class_115.method_255(this.field_272)[var3]; var5 != null; var5 = var5.field_277) {
               if (var5.equals(var2)) {
                  this.field_272.remove(var5.getKey());
                  return true;
               }
            }

            return false;
         }
      }
   }

   // $FF: synthetic method
   class_201(class_115 var1, class_174 var2) {
      this(var1);
   }
}
