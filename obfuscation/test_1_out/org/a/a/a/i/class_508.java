package org.a.a.a.i;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.i.e
public abstract class class_508 {
   // $FF: renamed from: a org.a.a.a.i.a
   private final class_151 field_934;
   // $FF: renamed from: b int
   private int field_935;
   // $FF: renamed from: c org.a.a.a.i.d
   private class_496 field_936;
   // $FF: renamed from: d org.a.a.a.i.d
   private class_496 field_937;
   // $FF: renamed from: e int
   private int field_938;

   protected class_508(class_151 var1) {
      this.field_934 = var1;
      class_496[] var2 = var1.field_181;
      int var3 = var2.length;

      class_496 var4;
      for(var4 = null; var3 > 0 && var4 == null; var4 = var2[var3]) {
         --var3;
      }

      this.field_937 = var4;
      this.field_935 = var3;
      this.field_938 = var1.field_183;
   }

   public boolean hasNext() {
      return this.field_937 != null;
   }

   // $FF: renamed from: c () org.a.a.a.i.d
   protected class_496 method_1607() {
      if (this.field_934.field_183 != this.field_938) {
         throw new ConcurrentModificationException();
      } else {
         class_496 var1 = this.field_937;
         if (var1 == null) {
            throw new NoSuchElementException("No next() entry in the iteration");
         } else {
            class_496[] var2 = this.field_934.field_181;
            int var3 = this.field_935;

            class_496 var4;
            for(var4 = var1.field_903; var4 == null && var3 > 0; var4 = var2[var3]) {
               --var3;
            }

            this.field_937 = var4;
            this.field_935 = var3;
            this.field_936 = var1;
            return var1;
         }
      }
   }

   // $FF: renamed from: d () org.a.a.a.i.d
   protected class_496 method_1608() {
      return this.field_936;
   }

   public void remove() {
      if (this.field_936 == null) {
         throw new IllegalStateException("remove() can only be called once after next()");
      } else if (this.field_934.field_183 != this.field_938) {
         throw new ConcurrentModificationException();
      } else {
         this.field_934.remove(this.field_936.getKey());
         this.field_936 = null;
         this.field_938 = this.field_934.field_183;
      }
   }

   public String toString() {
      return this.field_936 != null ? "Iterator[" + this.field_936.getKey() + "=" + this.field_936.getValue() + "]" : "Iterator[]";
   }
}
