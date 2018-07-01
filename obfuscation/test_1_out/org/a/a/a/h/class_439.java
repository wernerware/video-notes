package org.a.a.a.h;

import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// $FF: renamed from: org.a.a.a.h.c
public class class_439 extends AbstractList {
   // $FF: renamed from: a org.a.a.a.h.a
   class_435 field_771;
   // $FF: renamed from: b int
   int field_772;
   // $FF: renamed from: c int
   int field_773;
   // $FF: renamed from: d int
   int field_774;

   protected class_439(class_435 var1, int var2, int var3) {
      if (var2 < 0) {
         throw new IndexOutOfBoundsException("fromIndex = " + var2);
      } else if (var3 > var1.size()) {
         throw new IndexOutOfBoundsException("toIndex = " + var3);
      } else if (var2 > var3) {
         throw new IllegalArgumentException("fromIndex(" + var2 + ") > toIndex(" + var3 + ")");
      } else {
         this.field_771 = var1;
         this.field_772 = var2;
         this.field_773 = var3 - var2;
         this.field_774 = var1.field_760;
      }
   }

   public int size() {
      this.method_1478();
      return this.field_773;
   }

   public Object get(int var1) {
      this.method_1477(var1, this.field_773);
      this.method_1478();
      return this.field_771.get(var1 + this.field_772);
   }

   public void add(int var1, Object var2) {
      this.method_1477(var1, this.field_773 + 1);
      this.method_1478();
      this.field_771.add(var1 + this.field_772, var2);
      this.field_774 = this.field_771.field_760;
      ++this.field_773;
      ++this.modCount;
   }

   public Object remove(int var1) {
      this.method_1477(var1, this.field_773);
      this.method_1478();
      Object var2 = this.field_771.remove(var1 + this.field_772);
      this.field_774 = this.field_771.field_760;
      --this.field_773;
      ++this.modCount;
      return var2;
   }

   public boolean addAll(Collection var1) {
      return this.addAll(this.field_773, var1);
   }

   public boolean addAll(int var1, Collection var2) {
      this.method_1477(var1, this.field_773 + 1);
      int var3 = var2.size();
      if (var3 == 0) {
         return false;
      } else {
         this.method_1478();
         this.field_771.addAll(this.field_772 + var1, var2);
         this.field_774 = this.field_771.field_760;
         this.field_773 += var3;
         ++this.modCount;
         return true;
      }
   }

   public Object set(int var1, Object var2) {
      this.method_1477(var1, this.field_773);
      this.method_1478();
      return this.field_771.set(var1 + this.field_772, var2);
   }

   public void clear() {
      this.method_1478();
      Iterator var1 = this.iterator();

      while(var1.hasNext()) {
         var1.next();
         var1.remove();
      }

   }

   public Iterator iterator() {
      this.method_1478();
      return this.field_771.method_1450(this);
   }

   public ListIterator listIterator(int var1) {
      this.method_1477(var1, this.field_773 + 1);
      this.method_1478();
      return this.field_771.method_1451(this, var1);
   }

   public List subList(int var1, int var2) {
      return new class_439(this.field_771, var1 + this.field_772, var2 + this.field_772);
   }

   // $FF: renamed from: a (int, int) void
   protected void method_1477(int var1, int var2) {
      if (var1 < 0 || var1 >= var2) {
         throw new IndexOutOfBoundsException("Index '" + var1 + "' out of bounds for size '" + this.field_773 + "'");
      }
   }

   // $FF: renamed from: a () void
   protected void method_1478() {
      if (this.field_771.field_760 != this.field_774) {
         throw new ConcurrentModificationException();
      }
   }
}
