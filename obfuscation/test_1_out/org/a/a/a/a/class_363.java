package org.a.a.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_22;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.a.b
public abstract class class_363 implements class_22 {
   // $FF: renamed from: a java.util.Map
   private transient Map field_623;
   // $FF: renamed from: b int
   private int field_624;
   // $FF: renamed from: c int
   private transient int field_625;
   // $FF: renamed from: d java.util.Set
   private transient Set field_626;

   protected class_363() {
   }

   protected class_363(Map var1) {
      this.field_623 = var1;
   }

   // $FF: renamed from: e () java.util.Map
   protected Map method_1063() {
      return this.field_623;
   }

   public int size() {
      return this.field_624;
   }

   public boolean isEmpty() {
      return this.field_623.isEmpty();
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_26(Object var1) {
      class_367 var2 = (class_367)this.field_623.get(var1);
      return var2 != null ? var2.field_635 : 0;
   }

   public boolean contains(Object var1) {
      return this.field_623.containsKey(var1);
   }

   public boolean containsAll(Collection var1) {
      return var1 instanceof class_22 ? this.method_1064((class_22)var1) : this.method_1064(new class_364(var1));
   }

   // $FF: renamed from: a (org.a.a.a.b) boolean
   boolean method_1064(class_22 var1) {
      Iterator var2 = var1.method_29().iterator();

      Object var3;
      do {
         if (!var2.hasNext()) {
            return true;
         }

         var3 = var2.next();
      } while(this.method_26(var3) >= var1.method_26(var3));

      return false;
   }

   public Iterator iterator() {
      return new class_366(this);
   }

   public boolean add(Object var1) {
      return this.method_27(var1, 1);
   }

   // $FF: renamed from: a (java.lang.Object, int) boolean
   public boolean method_27(Object var1, int var2) {
      ++this.field_625;
      if (var2 > 0) {
         class_367 var3 = (class_367)this.field_623.get(var1);
         this.field_624 += var2;
         if (var3 == null) {
            this.field_623.put(var1, new class_367(var2));
            return true;
         } else {
            var3.field_635 += var2;
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean addAll(Collection var1) {
      boolean var2 = false;

      boolean var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 = var2 || var4) {
         var4 = this.add(var3.next());
      }

      return var2;
   }

   public void clear() {
      ++this.field_625;
      this.field_623.clear();
      this.field_624 = 0;
   }

   public boolean remove(Object var1) {
      class_367 var2 = (class_367)this.field_623.get(var1);
      if (var2 == null) {
         return false;
      } else {
         ++this.field_625;
         this.field_623.remove(var1);
         this.field_624 -= var2.field_635;
         return true;
      }
   }

   // $FF: renamed from: b (java.lang.Object, int) boolean
   public boolean method_28(Object var1, int var2) {
      class_367 var3 = (class_367)this.field_623.get(var1);
      if (var3 == null) {
         return false;
      } else if (var2 <= 0) {
         return false;
      } else {
         ++this.field_625;
         if (var2 < var3.field_635) {
            var3.field_635 -= var2;
            this.field_624 -= var2;
         } else {
            this.field_623.remove(var1);
            this.field_624 -= var3.field_635;
         }

         return true;
      }
   }

   public boolean removeAll(Collection var1) {
      boolean var2 = false;
      boolean var4;
      if (var1 != null) {
         for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 = var2 || var4) {
            var4 = this.method_28(var3.next(), 1);
         }
      }

      return var2;
   }

   public boolean retainAll(Collection var1) {
      return var1 instanceof class_22 ? this.method_1065((class_22)var1) : this.method_1065(new class_364(var1));
   }

   // $FF: renamed from: b (org.a.a.a.b) boolean
   boolean method_1065(class_22 var1) {
      boolean var2 = false;
      class_364 var3 = new class_364();
      Iterator var4 = this.method_29().iterator();

      while(true) {
         while(var4.hasNext()) {
            Object var5 = var4.next();
            int var6 = this.method_26(var5);
            int var7 = var1.method_26(var5);
            if (1 <= var7 && var7 <= var6) {
               var3.method_27(var5, var6 - var7);
            } else {
               var3.method_27(var5, var6);
            }
         }

         if (!var3.isEmpty()) {
            var2 = this.removeAll(var3);
         }

         return var2;
      }
   }

   public Object[] toArray() {
      Object[] var1 = new Object[this.size()];
      int var2 = 0;
      Iterator var3 = this.field_623.keySet().iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();

         for(int var5 = this.method_26(var4); var5 > 0; --var5) {
            var1[var2++] = var4;
         }
      }

      return var1;
   }

   public Object[] toArray(Object[] var1) {
      int var2 = this.size();
      if (var1.length < var2) {
         Object[] var3 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), var2));
         var1 = var3;
      }

      int var8 = 0;
      Iterator var4 = this.field_623.keySet().iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();

         for(int var6 = this.method_26(var5); var6 > 0; --var6) {
            var1[var8++] = var5;
         }
      }

      while(var8 < var1.length) {
         var1[var8++] = null;
      }

      return var1;
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_29() {
      if (this.field_626 == null) {
         this.field_626 = class_74.method_150(this.field_623.keySet());
      }

      return this.field_626;
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_1066(ObjectOutputStream var1) {
      var1.writeInt(this.field_623.size());
      Iterator var2 = this.field_623.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeInt(((class_367)var3.getValue()).field_635);
      }

   }

   // $FF: renamed from: a (java.util.Map, java.io.ObjectInputStream) void
   protected void method_1067(Map var1, ObjectInputStream var2) {
      this.field_623 = var1;
      int var3 = var2.readInt();

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = var2.readObject();
         int var6 = var2.readInt();
         var1.put(var5, new class_367(var6));
         this.field_624 += var6;
      }

   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof class_22)) {
         return false;
      } else {
         class_22 var2 = (class_22)var1;
         if (var2.size() != this.size()) {
            return false;
         } else {
            Iterator var3 = this.field_623.keySet().iterator();

            Object var4;
            do {
               if (!var3.hasNext()) {
                  return true;
               }

               var4 = var3.next();
            } while(var2.method_26(var4) == this.method_26(var4));

            return false;
         }
      }
   }

   public int hashCode() {
      int var1 = 0;

      Object var4;
      class_367 var5;
      for(Iterator var2 = this.field_623.entrySet().iterator(); var2.hasNext(); var1 += (var4 == null ? 0 : var4.hashCode()) ^ var5.field_635) {
         Entry var3 = (Entry)var2.next();
         var4 = var3.getKey();
         var5 = (class_367)var3.getValue();
      }

      return var1;
   }

   public String toString() {
      if (this.size() == 0) {
         return "[]";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append('[');
         Iterator var2 = this.method_29().iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            int var4 = this.method_26(var3);
            var1.append(var4);
            var1.append(':');
            var1.append(var3);
            if (var2.hasNext()) {
               var1.append(',');
            }
         }

         var1.append(']');
         return var1.toString();
      }
   }

   // $FF: renamed from: a (org.a.a.a.a.b) java.util.Map
   // $FF: synthetic method
   static Map method_1068(class_363 var0) {
      return var0.field_623;
   }

   // $FF: renamed from: b (org.a.a.a.a.b) int
   // $FF: synthetic method
   static int method_1069(class_363 var0) {
      return var0.field_625;
   }

   // $FF: renamed from: c (org.a.a.a.a.b) int
   // $FF: synthetic method
   static int method_1070(class_363 var0) {
      return var0.field_624--;
   }
}
