package org.a.a.a.i;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.aL
public final class class_115 extends class_113 {
   // $FF: renamed from: a int
   private static final int field_116 = 255;
   // $FF: renamed from: b org.a.a.a.i.aT[]
   private final class_204[] field_117;
   // $FF: renamed from: c org.a.a.a.i.aS[]
   private final class_202[] field_118;

   public class_115() {
      this(255);
   }

   public class_115(int var1) {
      int var2 = Math.max(17, var1);
      if (var2 % 2 == 0) {
         --var2;
      }

      this.field_117 = new class_204[var2];
      this.field_118 = new class_202[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_118[var3] = new class_202((class_174)null);
      }

   }

   // $FF: renamed from: a (java.lang.Object) int
   private int method_252(Object var1) {
      if (var1 == null) {
         return 0;
      } else {
         int var2 = var1.hashCode();
         var2 += ~(var2 << 15);
         var2 ^= var2 >>> 10;
         var2 += var2 << 3;
         var2 ^= var2 >>> 6;
         var2 += ~(var2 << 11);
         var2 ^= var2 >>> 16;
         var2 %= this.field_117.length;
         return var2 < 0 ? var2 * -1 : var2;
      }
   }

   public int size() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.field_117.length; ++var2) {
         synchronized(this.field_118[var2]) {
            var1 += this.field_118[var2].field_273;
         }
      }

      return var1;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public Object get(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean containsKey(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean containsValue(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public Object put(Object param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public Object remove(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public Set keySet() {
      return new class_203(this, (class_174)null);
   }

   public Collection values() {
      return new class_205(this, (class_174)null);
   }

   public Set entrySet() {
      return new class_201(this, (class_174)null);
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   public void clear() {
      for(int var1 = 0; var1 < this.field_117.length; ++var1) {
         class_202 var2 = this.field_118[var1];
         synchronized(var2) {
            this.field_117[var1] = null;
            var2.field_273 = 0;
         }
      }

   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Map)) {
         return false;
      } else {
         Map var2 = (Map)var1;
         return this.entrySet().equals(var2.entrySet());
      }
   }

   public int hashCode() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.Runnable) void
   public void method_253(Runnable var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.method_254(var1, 0);
      }
   }

   // $FF: renamed from: a (java.lang.Runnable, int) void
   private void method_254(Runnable var1, int var2) {
      if (var2 >= this.field_117.length) {
         var1.run();
      } else {
         synchronized(this.field_118[var2]) {
            this.method_254(var1, var2 + 1);
         }
      }
   }

   // $FF: renamed from: a (org.a.a.a.i.aL) org.a.a.a.i.aT[]
   // $FF: synthetic method
   static class_204[] method_255(class_115 var0) {
      return var0.field_117;
   }

   // $FF: renamed from: b (org.a.a.a.i.aL) org.a.a.a.i.aS[]
   // $FF: synthetic method
   static class_202[] method_256(class_115 var0) {
      return var0.field_118;
   }

   // $FF: renamed from: a (org.a.a.a.i.aL, java.lang.Object) int
   // $FF: synthetic method
   static int method_257(class_115 var0, Object var1) {
      return var0.method_252(var1);
   }
}
