package org.a.a.a;

import java.util.AbstractList;
import java.util.List;

// $FF: renamed from: org.a.a.a.X
class class_418 extends AbstractList {
   // $FF: renamed from: a java.util.List
   private final List field_727;
   // $FF: renamed from: b int
   private final int field_728;

   private class_418(List var1, int var2) {
      this.field_727 = var1;
      this.field_728 = var2;
   }

   // $FF: renamed from: a (int) java.util.List
   public List method_1409(int var1) {
      int var2 = this.size();
      if (var2 < 0) {
         throw new IllegalArgumentException("negative size: " + var2);
      } else if (var1 < 0) {
         throw new IndexOutOfBoundsException("Index " + var1 + " must not be negative");
      } else if (var1 >= var2) {
         throw new IndexOutOfBoundsException("Index " + var1 + " must be less than size " + var2);
      } else {
         int var3 = var1 * this.field_728;
         int var4 = Math.min(var3 + this.field_728, this.field_727.size());
         return this.field_727.subList(var3, var4);
      }
   }

   public int size() {
      return (this.field_727.size() + this.field_728 - 1) / this.field_728;
   }

   public boolean isEmpty() {
      return this.field_727.isEmpty();
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_1409(var1);
   }

   // $FF: synthetic method
   class_418(List var1, int var2, class_421 var3) {
      this(var1, var2);
   }
}
