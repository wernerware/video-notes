package org.a.a.a.h;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.h.a
public abstract class class_435 implements List {
   // $FF: renamed from: a org.a.a.a.h.e
   transient class_438 field_758;
   // $FF: renamed from: b int
   transient int field_759;
   // $FF: renamed from: c int
   transient int field_760;

   protected class_435() {
   }

   protected class_435(Collection var1) {
      this.method_1433();
      this.addAll(var1);
   }

   // $FF: renamed from: a () void
   protected void method_1433() {
      this.field_758 = this.method_1442();
   }

   public int size() {
      return this.field_759;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public Object get(int var1) {
      class_438 var2 = this.method_1449(var1, false);
      return var2.method_1471();
   }

   public Iterator iterator() {
      return this.listIterator();
   }

   public ListIterator listIterator() {
      return new class_431(this, 0);
   }

   public ListIterator listIterator(int var1) {
      return new class_431(this, var1);
   }

   public int indexOf(Object var1) {
      int var2 = 0;

      for(class_438 var3 = this.field_758.field_769; var3 != this.field_758; var3 = var3.field_769) {
         if (this.method_1440(var3.method_1471(), var1)) {
            return var2;
         }

         ++var2;
      }

      return -1;
   }

   public int lastIndexOf(Object var1) {
      int var2 = this.field_759 - 1;

      for(class_438 var3 = this.field_758.field_768; var3 != this.field_758; var3 = var3.field_768) {
         if (this.method_1440(var3.method_1471(), var1)) {
            return var2;
         }

         --var2;
      }

      return -1;
   }

   public boolean contains(Object var1) {
      return this.indexOf(var1) != -1;
   }

   public boolean containsAll(Collection var1) {
      Iterator var2 = var1.iterator();

      Object var3;
      do {
         if (!var2.hasNext()) {
            return true;
         }

         var3 = var2.next();
      } while(this.contains(var3));

      return false;
   }

   public Object[] toArray() {
      return this.toArray(new Object[this.field_759]);
   }

   public Object[] toArray(Object[] var1) {
      if (var1.length < this.field_759) {
         Class var2 = var1.getClass().getComponentType();
         var1 = (Object[])((Object[])Array.newInstance(var2, this.field_759));
      }

      int var4 = 0;

      for(class_438 var3 = this.field_758.field_769; var3 != this.field_758; ++var4) {
         var1[var4] = var3.method_1471();
         var3 = var3.field_769;
      }

      if (var1.length > this.field_759) {
         var1[this.field_759] = null;
      }

      return var1;
   }

   public List subList(int var1, int var2) {
      return new class_439(this, var1, var2);
   }

   public boolean add(Object var1) {
      this.method_1437(var1);
      return true;
   }

   public void add(int var1, Object var2) {
      class_438 var3 = this.method_1449(var1, true);
      this.method_1444(var3, var2);
   }

   public boolean addAll(Collection var1) {
      return this.addAll(this.field_759, var1);
   }

   public boolean addAll(int var1, Collection var2) {
      class_438 var3 = this.method_1449(var1, true);
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         this.method_1444(var3, var5);
      }

      return true;
   }

   public Object remove(int var1) {
      class_438 var2 = this.method_1449(var1, false);
      Object var3 = var2.method_1471();
      this.method_1447(var2);
      return var3;
   }

   public boolean remove(Object var1) {
      for(class_438 var2 = this.field_758.field_769; var2 != this.field_758; var2 = var2.field_769) {
         if (this.method_1440(var2.method_1471(), var1)) {
            this.method_1447(var2);
            return true;
         }
      }

      return false;
   }

   public boolean removeAll(Collection var1) {
      boolean var2 = false;
      Iterator var3 = this.iterator();

      while(var3.hasNext()) {
         if (var1.contains(var3.next())) {
            var3.remove();
            var2 = true;
         }
      }

      return var2;
   }

   public boolean retainAll(Collection var1) {
      boolean var2 = false;
      Iterator var3 = this.iterator();

      while(var3.hasNext()) {
         if (!var1.contains(var3.next())) {
            var3.remove();
            var2 = true;
         }
      }

      return var2;
   }

   public Object set(int var1, Object var2) {
      class_438 var3 = this.method_1449(var1, false);
      Object var4 = var3.method_1471();
      this.method_1441(var3, var2);
      return var4;
   }

   public void clear() {
      this.method_1448();
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_1434() {
      class_438 var1 = this.field_758.field_769;
      if (var1 == this.field_758) {
         throw new NoSuchElementException();
      } else {
         return var1.method_1471();
      }
   }

   // $FF: renamed from: c () java.lang.Object
   public Object method_1435() {
      class_438 var1 = this.field_758.field_768;
      if (var1 == this.field_758) {
         throw new NoSuchElementException();
      } else {
         return var1.method_1471();
      }
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_1436(Object var1) {
      this.method_1445(this.field_758, var1);
      return true;
   }

   // $FF: renamed from: b (java.lang.Object) boolean
   public boolean method_1437(Object var1) {
      this.method_1444(this.field_758, var1);
      return true;
   }

   // $FF: renamed from: d () java.lang.Object
   public Object method_1438() {
      class_438 var1 = this.field_758.field_769;
      if (var1 == this.field_758) {
         throw new NoSuchElementException();
      } else {
         Object var2 = var1.method_1471();
         this.method_1447(var1);
         return var2;
      }
   }

   // $FF: renamed from: e () java.lang.Object
   public Object method_1439() {
      class_438 var1 = this.field_758.field_768;
      if (var1 == this.field_758) {
         throw new NoSuchElementException();
      } else {
         Object var2 = var1.method_1471();
         this.method_1447(var1);
         return var2;
      }
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof List)) {
         return false;
      } else {
         List var2 = (List)var1;
         if (var2.size() != this.size()) {
            return false;
         } else {
            ListIterator var3 = this.listIterator();
            ListIterator var4 = var2.listIterator();

            while(true) {
               if (var3.hasNext() && var4.hasNext()) {
                  Object var5 = var3.next();
                  Object var6 = var4.next();
                  if (var5 == null) {
                     if (var6 == null) {
                        continue;
                     }
                  } else if (var5.equals(var6)) {
                     continue;
                  }

                  return false;
               }

               return !var3.hasNext() && !var4.hasNext();
            }
         }
      }
   }

   public int hashCode() {
      int var1 = 1;

      Object var3;
      for(Iterator var2 = this.iterator(); var2.hasNext(); var1 = 31 * var1 + (var3 == null ? 0 : var3.hashCode())) {
         var3 = var2.next();
      }

      return var1;
   }

   public String toString() {
      if (this.size() == 0) {
         return "[]";
      } else {
         StringBuilder var1 = new StringBuilder(16 * this.size());
         var1.append('[');
         Iterator var2 = this.iterator();
         boolean var3 = var2.hasNext();

         while(var3) {
            Object var4 = var2.next();
            var1.append(var4 == this ? "(this Collection)" : var4);
            var3 = var2.hasNext();
            if (var3) {
               var1.append(", ");
            }
         }

         var1.append(']');
         return var1.toString();
      }
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   protected boolean method_1440(Object var1, Object var2) {
      return var1 == var2 || var1 != null && var1.equals(var2);
   }

   // $FF: renamed from: a (org.a.a.a.h.e, java.lang.Object) void
   protected void method_1441(class_438 var1, Object var2) {
      var1.method_1472(var2);
   }

   // $FF: renamed from: f () org.a.a.a.h.e
   protected class_438 method_1442() {
      return new class_438();
   }

   // $FF: renamed from: c (java.lang.Object) org.a.a.a.h.e
   protected class_438 method_1443(Object var1) {
      return new class_438(var1);
   }

   // $FF: renamed from: b (org.a.a.a.h.e, java.lang.Object) void
   protected void method_1444(class_438 var1, Object var2) {
      class_438 var3 = this.method_1443(var2);
      this.method_1446(var3, var1);
   }

   // $FF: renamed from: c (org.a.a.a.h.e, java.lang.Object) void
   protected void method_1445(class_438 var1, Object var2) {
      class_438 var3 = this.method_1443(var2);
      this.method_1446(var3, var1.field_769);
   }

   // $FF: renamed from: a (org.a.a.a.h.e, org.a.a.a.h.e) void
   protected void method_1446(class_438 var1, class_438 var2) {
      var1.field_769 = var2;
      var1.field_768 = var2.field_768;
      var2.field_768.field_769 = var1;
      var2.field_768 = var1;
      ++this.field_759;
      ++this.field_760;
   }

   // $FF: renamed from: a (org.a.a.a.h.e) void
   protected void method_1447(class_438 var1) {
      var1.field_768.field_769 = var1.field_769;
      var1.field_769.field_768 = var1.field_768;
      --this.field_759;
      ++this.field_760;
   }

   // $FF: renamed from: g () void
   protected void method_1448() {
      this.field_758.field_769 = this.field_758;
      this.field_758.field_768 = this.field_758;
      this.field_759 = 0;
      ++this.field_760;
   }

   // $FF: renamed from: a (int, boolean) org.a.a.a.h.e
   protected class_438 method_1449(int var1, boolean var2) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException("Couldn't get the node: index (" + var1 + ") less than zero.");
      } else if (!var2 && var1 == this.field_759) {
         throw new IndexOutOfBoundsException("Couldn't get the node: index (" + var1 + ") is the size of the list.");
      } else if (var1 > this.field_759) {
         throw new IndexOutOfBoundsException("Couldn't get the node: index (" + var1 + ") greater than the size of the " + "list (" + this.field_759 + ").");
      } else {
         class_438 var3;
         int var4;
         if (var1 < this.field_759 / 2) {
            var3 = this.field_758.field_769;

            for(var4 = 0; var4 < var1; ++var4) {
               var3 = var3.field_769;
            }
         } else {
            var3 = this.field_758;

            for(var4 = this.field_759; var4 > var1; --var4) {
               var3 = var3.field_768;
            }
         }

         return var3;
      }
   }

   // $FF: renamed from: a (org.a.a.a.h.c) java.util.Iterator
   protected Iterator method_1450(class_439 var1) {
      return this.method_1451(var1, 0);
   }

   // $FF: renamed from: a (org.a.a.a.h.c, int) java.util.ListIterator
   protected ListIterator method_1451(class_439 var1, int var2) {
      return new class_432(var1, var2);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_1452(ObjectOutputStream var1) {
      var1.writeInt(this.size());
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.writeObject(var3);
      }

   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   protected void method_1453(ObjectInputStream var1) {
      this.method_1433();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         this.add(var1.readObject());
      }

   }
}
