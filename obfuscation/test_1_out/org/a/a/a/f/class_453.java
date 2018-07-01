package org.a.a.a.f;

import java.util.NoSuchElementException;
import org.a.a.a.class_20;

// $FF: renamed from: org.a.a.a.f.D
public class class_453 implements class_20 {
   // $FF: renamed from: a java.lang.Object[]
   final Object[] field_824;
   // $FF: renamed from: b int
   final int field_825;
   // $FF: renamed from: c int
   final int field_826;
   // $FF: renamed from: d int
   int field_827;

   public class_453(Object... var1) {
      this(var1, 0, var1.length);
   }

   public class_453(Object[] var1, int var2) {
      this(var1, var2, var1.length);
   }

   public class_453(Object[] var1, int var2, int var3) {
      this.field_827 = 0;
      if (var2 < 0) {
         throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
      } else if (var3 > var1.length) {
         throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
      } else if (var2 > var1.length) {
         throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
      } else if (var3 < var2) {
         throw new IllegalArgumentException("End index must not be less than start index");
      } else {
         this.field_824 = var1;
         this.field_825 = var2;
         this.field_826 = var3;
         this.field_827 = var2;
      }
   }

   public boolean hasNext() {
      return this.field_827 < this.field_826;
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.field_824[this.field_827++];
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
   }

   // $FF: renamed from: a () java.lang.Object[]
   public Object[] method_1533() {
      return this.field_824;
   }

   // $FF: renamed from: b () int
   public int method_1534() {
      return this.field_825;
   }

   // $FF: renamed from: d () int
   public int method_1535() {
      return this.field_826;
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_827 = this.field_825;
   }
}
