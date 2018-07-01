package org.a.a.a.f;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.a.a.a.class_20;

// $FF: renamed from: org.a.a.a.f.h
public class class_171 implements class_20 {
   // $FF: renamed from: a java.lang.Object
   final Object field_222;
   // $FF: renamed from: b int
   final int field_223;
   // $FF: renamed from: c int
   final int field_224;
   // $FF: renamed from: d int
   int field_225;

   public class_171(Object var1) {
      this(var1, 0);
   }

   public class_171(Object var1, int var2) {
      this(var1, var2, Array.getLength(var1));
   }

   public class_171(Object var1, int var2, int var3) {
      this.field_225 = 0;
      this.field_222 = var1;
      this.field_223 = var2;
      this.field_224 = var3;
      this.field_225 = var2;
      int var4 = Array.getLength(var1);
      this.method_537(var2, var4, "start");
      this.method_537(var3, var4, "end");
      if (var3 < var2) {
         throw new IllegalArgumentException("End index must not be less than start index.");
      }
   }

   // $FF: renamed from: a (int, int, java.lang.String) void
   protected void method_537(int var1, int var2, String var3) {
      if (var1 > var2) {
         throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + var3 + "s beyond the end of the array. ");
      } else if (var1 < 0) {
         throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + var3 + "s before the start of the array. ");
      }
   }

   public boolean hasNext() {
      return this.field_225 < this.field_224;
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return Array.get(this.field_222, this.field_225++);
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() method is not supported");
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_538() {
      return this.field_222;
   }

   // $FF: renamed from: b () int
   public int method_539() {
      return this.field_223;
   }

   // $FF: renamed from: d () int
   public int method_540() {
      return this.field_224;
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_225 = this.field_223;
   }
}
