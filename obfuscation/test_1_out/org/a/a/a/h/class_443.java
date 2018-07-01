package org.a.a.a.h;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

// $FF: renamed from: org.a.a.a.h.w
public class class_443 extends AbstractList {
   // $FF: renamed from: a org.a.a.a.h.y
   private class_442 field_788;
   // $FF: renamed from: b int
   private int field_789;

   public class_443() {
   }

   public class_443(Collection var1) {
      if (!var1.isEmpty()) {
         this.field_788 = new class_442(var1, (class_441)null);
         this.field_789 = var1.size();
      }

   }

   public Object get(int var1) {
      this.method_1512(var1, 0, this.size() - 1);
      return this.field_788.method_1482(var1).method_1480();
   }

   public int size() {
      return this.field_789;
   }

   public Iterator iterator() {
      return this.listIterator(0);
   }

   public ListIterator listIterator() {
      return this.listIterator(0);
   }

   public ListIterator listIterator(int var1) {
      this.method_1512(var1, 0, this.size());
      return new class_440(this, var1);
   }

   public int indexOf(Object var1) {
      return this.field_788 == null ? -1 : this.field_788.method_1483(var1, class_442.method_1509(this.field_788));
   }

   public boolean contains(Object var1) {
      return this.indexOf(var1) >= 0;
   }

   public Object[] toArray() {
      Object[] var1 = new Object[this.size()];
      if (this.field_788 != null) {
         this.field_788.method_1484(var1, class_442.method_1509(this.field_788));
      }

      return var1;
   }

   public void add(int var1, Object var2) {
      ++this.modCount;
      this.method_1512(var1, 0, this.size());
      if (this.field_788 == null) {
         this.field_788 = new class_442(var1, var2, (class_442)null, (class_442)null, (class_441)null);
      } else {
         this.field_788 = this.field_788.method_1487(var1, var2);
      }

      ++this.field_789;
   }

   public boolean addAll(Collection var1) {
      if (var1.isEmpty()) {
         return false;
      } else {
         this.modCount += var1.size();
         class_442 var2 = new class_442(var1, (class_441)null);
         this.field_788 = this.field_788 == null ? var2 : class_442.method_1510(this.field_788, var2, this.field_789);
         this.field_789 += var1.size();
         return true;
      }
   }

   public Object set(int var1, Object var2) {
      this.method_1512(var1, 0, this.size() - 1);
      class_442 var3 = this.field_788.method_1482(var1);
      Object var4 = class_442.method_1511(var3);
      var3.method_1481(var2);
      return var4;
   }

   public Object remove(int var1) {
      ++this.modCount;
      this.method_1512(var1, 0, this.size() - 1);
      Object var2 = this.get(var1);
      this.field_788 = this.field_788.method_1494(var1);
      --this.field_789;
      return var2;
   }

   public void clear() {
      ++this.modCount;
      this.field_788 = null;
      this.field_789 = 0;
   }

   // $FF: renamed from: a (int, int, int) void
   private void method_1512(int var1, int var2, int var3) {
      if (var1 < var2 || var1 > var3) {
         throw new IndexOutOfBoundsException("Invalid index:" + var1 + ", size=" + this.size());
      }
   }

   // $FF: renamed from: a (org.a.a.a.h.w) int
   // $FF: synthetic method
   static int method_1513(class_443 var0) {
      return var0.modCount;
   }

   // $FF: renamed from: b (org.a.a.a.h.w) org.a.a.a.h.y
   // $FF: synthetic method
   static class_442 method_1514(class_443 var0) {
      return var0.field_788;
   }

   // $FF: renamed from: c (org.a.a.a.h.w) int
   // $FF: synthetic method
   static int method_1515(class_443 var0) {
      return var0.modCount;
   }
}
