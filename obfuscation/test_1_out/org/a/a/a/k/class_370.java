package org.a.a.a.k;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.a.a.a.class_27;
import org.a.a.a.class_28;
import org.a.a.a.class_401;

// $FF: renamed from: org.a.a.a.k.g
public abstract class class_370 extends AbstractCollection implements class_28 {
   // $FF: renamed from: a java.util.Set
   private transient Set field_646;
   // $FF: renamed from: b java.util.Set
   private transient Set field_647;

   public int size() {
      int var1 = 0;

      class_27 var3;
      for(Iterator var2 = this.method_63().iterator(); var2.hasNext(); var1 += var3.method_57()) {
         var3 = (class_27)var2.next();
      }

      return var1;
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_58(Object var1) {
      Iterator var2 = this.method_63().iterator();

      class_27 var3;
      Object var4;
      do {
         if (!var2.hasNext()) {
            return 0;
         }

         var3 = (class_27)var2.next();
         var4 = var3.method_56();
      } while(var4 != var1 && (var4 == null || !var4.equals(var1)));

      return var3.method_57();
   }

   // $FF: renamed from: a (java.lang.Object, int) int
   public int method_59(Object var1, int var2) {
      if (var2 < 0) {
         throw new IllegalArgumentException("Count must not be negative.");
      } else {
         int var3 = this.method_58(var1);
         if (var3 < var2) {
            this.method_60(var1, var2 - var3);
         } else {
            this.method_61(var1, var3 - var2);
         }

         return var3;
      }
   }

   public boolean contains(Object var1) {
      return this.method_58(var1) > 0;
   }

   public Iterator iterator() {
      return new class_381(this);
   }

   public boolean add(Object var1) {
      this.method_60(var1, 1);
      return true;
   }

   // $FF: renamed from: b (java.lang.Object, int) int
   public int method_60(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      Iterator var1 = this.method_63().iterator();

      while(var1.hasNext()) {
         var1.next();
         var1.remove();
      }

   }

   public boolean remove(Object var1) {
      return this.method_61(var1, 1) != 0;
   }

   // $FF: renamed from: c (java.lang.Object, int) int
   public int method_61(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection var1) {
      boolean var2 = false;

      boolean var5;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 = var2 || var5) {
         Object var4 = var3.next();
         var5 = this.method_61(var4, this.method_58(var4)) != 0;
      }

      return var2;
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_62() {
      if (this.field_646 == null) {
         this.field_646 = this.method_1091();
      }

      return this.field_646;
   }

   // $FF: renamed from: g () java.util.Set
   protected Set method_1091() {
      return new class_382(this);
   }

   // $FF: renamed from: f () java.util.Iterator
   protected Iterator method_1092() {
      class_374 var1 = new class_374(this);
      return class_401.method_1199(this.method_63().iterator(), var1);
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_63() {
      if (this.field_647 == null) {
         this.field_647 = this.method_1093();
      }

      return this.field_647;
   }

   // $FF: renamed from: h () java.util.Set
   protected Set method_1093() {
      return new class_383(this);
   }

   // $FF: renamed from: c () int
   protected abstract int method_1094();

   // $FF: renamed from: d () java.util.Iterator
   protected abstract Iterator method_1095();

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_1096(ObjectOutputStream var1) {
      var1.writeInt(this.method_63().size());
      Iterator var2 = this.method_63().iterator();

      while(var2.hasNext()) {
         class_27 var3 = (class_27)var2.next();
         var1.writeObject(var3.method_56());
         var1.writeInt(var3.method_57());
      }

   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   protected void method_1097(ObjectInputStream var1) {
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         int var5 = var1.readInt();
         this.method_59(var4, var5);
      }

   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof class_28)) {
         return false;
      } else {
         class_28 var2 = (class_28)var1;
         if (var2.size() != this.size()) {
            return false;
         } else {
            Iterator var3 = this.method_63().iterator();

            class_27 var4;
            do {
               if (!var3.hasNext()) {
                  return true;
               }

               var4 = (class_27)var3.next();
            } while(var2.method_58(var4.method_56()) == this.method_58(var4.method_56()));

            return false;
         }
      }
   }

   public int hashCode() {
      return this.method_63().hashCode();
   }

   public String toString() {
      return this.method_63().toString();
   }
}
