package org.a.a.a.k;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_28;

// $FF: renamed from: org.a.a.a.k.a
public abstract class class_372 extends class_370 {
   // $FF: renamed from: a java.util.Map
   private transient Map field_649;
   // $FF: renamed from: b int
   private transient int field_650;
   // $FF: renamed from: c int
   private transient int field_651;

   protected class_372() {
   }

   protected class_372(Map var1) {
      this.field_649 = var1;
   }

   // $FF: renamed from: e () java.util.Map
   protected Map method_1098() {
      return this.field_649;
   }

   // $FF: renamed from: a (java.util.Map) void
   protected void method_1099(Map var1) {
      this.field_649 = var1;
   }

   public int size() {
      return this.field_650;
   }

   public boolean isEmpty() {
      return this.field_649.isEmpty();
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_58(Object var1) {
      class_375 var2 = (class_375)this.field_649.get(var1);
      return var2 != null ? var2.field_654 : 0;
   }

   public boolean contains(Object var1) {
      return this.field_649.containsKey(var1);
   }

   public Iterator iterator() {
      return new class_376(this);
   }

   // $FF: renamed from: b (java.lang.Object, int) int
   public int method_60(Object var1, int var2) {
      if (var2 < 0) {
         throw new IllegalArgumentException("Occurrences must not be negative.");
      } else {
         class_375 var3 = (class_375)this.field_649.get(var1);
         int var4 = var3 != null ? var3.field_654 : 0;
         if (var2 > 0) {
            ++this.field_651;
            this.field_650 += var2;
            if (var3 == null) {
               this.field_649.put(var1, new class_375(var2));
            } else {
               var3.field_654 += var2;
            }
         }

         return var4;
      }
   }

   public void clear() {
      ++this.field_651;
      this.field_649.clear();
      this.field_650 = 0;
   }

   // $FF: renamed from: c (java.lang.Object, int) int
   public int method_61(Object var1, int var2) {
      if (var2 < 0) {
         throw new IllegalArgumentException("Occurrences must not be negative.");
      } else {
         class_375 var3 = (class_375)this.field_649.get(var1);
         if (var3 == null) {
            return 0;
         } else {
            int var4 = var3.field_654;
            if (var2 > 0) {
               ++this.field_651;
               if (var2 < var3.field_654) {
                  var3.field_654 -= var2;
                  this.field_650 -= var2;
               } else {
                  this.field_649.remove(var1);
                  this.field_650 -= var3.field_654;
               }
            }

            return var4;
         }
      }
   }

   // $FF: renamed from: f () java.util.Iterator
   protected Iterator method_1092() {
      return new class_186(this.method_1098().keySet().iterator(), this);
   }

   // $FF: renamed from: c () int
   protected int method_1094() {
      return this.field_649.size();
   }

   // $FF: renamed from: d () java.util.Iterator
   protected Iterator method_1095() {
      return new class_380(this.field_649.entrySet().iterator(), this);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_1096(ObjectOutputStream var1) {
      var1.writeInt(this.field_649.size());
      Iterator var2 = this.field_649.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeInt(((class_375)var3.getValue()).field_654);
      }

   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   protected void method_1097(ObjectInputStream var1) {
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         int var5 = var1.readInt();
         this.field_649.put(var4, new class_375(var5));
         this.field_650 += var5;
      }

   }

   public Object[] toArray() {
      Object[] var1 = new Object[this.size()];
      int var2 = 0;
      Iterator var3 = this.field_649.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         Object var5 = var4.getKey();
         class_375 var6 = (class_375)var4.getValue();

         for(int var7 = var6.field_654; var7 > 0; --var7) {
            var1[var2++] = var5;
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

      int var10 = 0;
      Iterator var4 = this.field_649.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         Object var6 = var5.getKey();
         class_375 var7 = (class_375)var5.getValue();

         for(int var8 = var7.field_654; var8 > 0; --var8) {
            var1[var10++] = var6;
         }
      }

      while(var10 < var1.length) {
         var1[var10++] = null;
      }

      return var1;
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
            Iterator var3 = this.field_649.keySet().iterator();

            Object var4;
            do {
               if (!var3.hasNext()) {
                  return true;
               }

               var4 = var3.next();
            } while(var2.method_58(var4) == this.method_58(var4));

            return false;
         }
      }
   }

   public int hashCode() {
      int var1 = 0;

      Object var4;
      class_375 var5;
      for(Iterator var2 = this.field_649.entrySet().iterator(); var2.hasNext(); var1 += (var4 == null ? 0 : var4.hashCode()) ^ var5.field_654) {
         Entry var3 = (Entry)var2.next();
         var4 = var3.getKey();
         var5 = (class_375)var3.getValue();
      }

      return var1;
   }

   // $FF: renamed from: a (org.a.a.a.k.a) java.util.Map
   // $FF: synthetic method
   static Map method_1100(class_372 var0) {
      return var0.field_649;
   }

   // $FF: renamed from: b (org.a.a.a.k.a) int
   // $FF: synthetic method
   static int method_1101(class_372 var0) {
      return var0.field_651;
   }

   // $FF: renamed from: c (org.a.a.a.k.a) int
   // $FF: synthetic method
   static int method_1102(class_372 var0) {
      return var0.field_650--;
   }
}
