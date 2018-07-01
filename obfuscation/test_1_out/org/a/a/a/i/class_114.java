package org.a.a.a.i;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_415;
import org.a.a.a.c.class_107;
import org.a.a.a.n.class_399;

// $FF: renamed from: org.a.a.a.i.O
public class class_114 extends class_113 implements Serializable {
   // $FF: renamed from: a long
   private static final long field_113 = -6096931280583808322L;
   // $FF: renamed from: b java.util.Map[]
   private Map[] field_114;
   // $FF: renamed from: c org.a.a.a.i.P
   private class_38 field_115;

   public class_114() {
      this((Map[])(new Map[0]), (class_38)null);
   }

   public class_114(Map var1, Map var2) {
      this((Map[])(new Map[]{var1, var2}), (class_38)null);
   }

   public class_114(Map var1, Map var2, class_38 var3) {
      this(new Map[]{var1, var2}, var3);
   }

   public class_114(Map... var1) {
      this((Map[])var1, (class_38)null);
   }

   public class_114(Map[] var1, class_38 var2) {
      this.field_115 = var2;
      this.field_114 = new Map[0];

      for(int var3 = var1.length - 1; var3 >= 0; --var3) {
         this.method_250(var1[var3]);
      }

   }

   // $FF: renamed from: a (org.a.a.a.i.P) void
   public void method_249(class_38 var1) {
      this.field_115 = var1;
   }

   // $FF: renamed from: a (java.util.Map) void
   public synchronized void method_250(Map var1) {
      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         Collection var3 = class_415.method_1329(this.field_114[var2].keySet(), var1.keySet());
         if (var3.size() != 0) {
            if (this.field_115 == null) {
               throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
            }

            this.field_115.method_77(this, this.field_114[var2], var1, var3);
         }
      }

      Map[] var4 = new Map[this.field_114.length + 1];
      System.arraycopy(this.field_114, 0, var4, 0, this.field_114.length);
      var4[var4.length - 1] = var1;
      this.field_114 = var4;
   }

   // $FF: renamed from: b (java.util.Map) java.util.Map
   public synchronized Map method_251(Map var1) {
      int var2 = this.field_114.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if (this.field_114[var3].equals(var1)) {
            Map[] var4 = new Map[var2 - 1];
            System.arraycopy(this.field_114, 0, var4, 0, var3);
            System.arraycopy(this.field_114, var3 + 1, var4, var3, var2 - var3 - 1);
            this.field_114 = var4;
            return var1;
         }
      }

      return null;
   }

   public void clear() {
      for(int var1 = this.field_114.length - 1; var1 >= 0; --var1) {
         this.field_114[var1].clear();
      }

   }

   public boolean containsKey(Object var1) {
      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         if (this.field_114[var2].containsKey(var1)) {
            return true;
         }
      }

      return false;
   }

   public boolean containsValue(Object var1) {
      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         if (this.field_114[var2].containsValue(var1)) {
            return true;
         }
      }

      return false;
   }

   public Set entrySet() {
      class_399 var1 = new class_399();

      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         var1.method_1138(this.field_114[var2].entrySet());
      }

      return var1;
   }

   public Object get(Object var1) {
      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         if (this.field_114[var2].containsKey(var1)) {
            return this.field_114[var2].get(var1);
         }
      }

      return null;
   }

   public boolean isEmpty() {
      for(int var1 = this.field_114.length - 1; var1 >= 0; --var1) {
         if (!this.field_114[var1].isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public Set keySet() {
      class_399 var1 = new class_399();

      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         var1.method_1138(this.field_114[var2].keySet());
      }

      return var1;
   }

   public Object put(Object var1, Object var2) {
      if (this.field_115 == null) {
         throw new UnsupportedOperationException("No mutator specified");
      } else {
         return this.field_115.method_78(this, this.field_114, var1, var2);
      }
   }

   public void putAll(Map var1) {
      if (this.field_115 == null) {
         throw new UnsupportedOperationException("No mutator specified");
      } else {
         this.field_115.method_79(this, this.field_114, var1);
      }
   }

   public Object remove(Object var1) {
      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         if (this.field_114[var2].containsKey(var1)) {
            return this.field_114[var2].remove(var1);
         }
      }

      return null;
   }

   public int size() {
      int var1 = 0;

      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         var1 += this.field_114[var2].size();
      }

      return var1;
   }

   public Collection values() {
      class_107 var1 = new class_107();

      for(int var2 = this.field_114.length - 1; var2 >= 0; --var2) {
         var1.method_242(this.field_114[var2].values());
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if (var1 instanceof Map) {
         Map var2 = (Map)var1;
         return this.entrySet().equals(var2.entrySet());
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = 0;

      Entry var3;
      for(Iterator var2 = this.entrySet().iterator(); var2.hasNext(); var1 += var3.hashCode()) {
         var3 = (Entry)var2.next();
      }

      return var1;
   }
}
