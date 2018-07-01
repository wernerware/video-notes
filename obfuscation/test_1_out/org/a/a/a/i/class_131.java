package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_15;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.h.class_51;

// $FF: renamed from: org.a.a.a.i.ak
public class class_131 extends class_116 implements Serializable, class_15 {
   // $FF: renamed from: b long
   private static final long field_134 = 2728177751851003750L;
   // $FF: renamed from: c java.util.List
   private final List field_135;

   // $FF: renamed from: a (java.util.Map) org.a.a.a.i.ak
   public static class_131 method_339(Map var0) {
      return new class_131(var0);
   }

   public class_131() {
      this(new HashMap());
   }

   protected class_131(Map var1) {
      super(var1);
      this.field_135 = new ArrayList();
      this.field_135.addAll(this.i().keySet());
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_340(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_341(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return new class_248(this);
   }

   public Object firstKey() {
      if (this.size() == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.field_135.get(0);
      }
   }

   public Object lastKey() {
      if (this.size() == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.field_135.get(this.size() - 1);
      }
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      int var2 = this.field_135.indexOf(var1);
      return var2 >= 0 && var2 < this.size() - 1 ? this.field_135.get(var2 + 1) : null;
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      int var2 = this.field_135.indexOf(var1);
      return var2 > 0 ? this.field_135.get(var2 - 1) : null;
   }

   public Object put(Object var1, Object var2) {
      if (this.i().containsKey(var1)) {
         return this.i().put(var1, var2);
      } else {
         Object var3 = this.i().put(var1, var2);
         this.field_135.add(var1);
         return var3;
      }
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   // $FF: renamed from: a (int, java.util.Map) void
   public void method_342(int var1, Map var2) {
      if (var1 >= 0 && var1 <= this.field_135.size()) {
         Iterator var3 = var2.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            Object var5 = var4.getKey();
            boolean var6 = this.containsKey(var5);
            this.method_349(var1, var4.getKey(), var4.getValue());
            if (!var6) {
               ++var1;
            } else {
               var1 = this.method_347(var4.getKey()) + 1;
            }
         }

      } else {
         throw new IndexOutOfBoundsException("Index: " + var1 + ", Size: " + this.field_135.size());
      }
   }

   public Object remove(Object var1) {
      Object var2 = null;
      if (this.i().containsKey(var1)) {
         var2 = this.i().remove(var1);
         this.field_135.remove(var1);
      }

      return var2;
   }

   public void clear() {
      this.i().clear();
      this.field_135.clear();
   }

   public Set keySet() {
      return new class_242(this);
   }

   // $FF: renamed from: a () java.util.List
   public List method_343() {
      return class_51.method_108(this.field_135);
   }

   public Collection values() {
      return new class_259(this);
   }

   // $FF: renamed from: b () java.util.List
   public List method_344() {
      return new class_259(this);
   }

   public Set entrySet() {
      return new class_244(this, this.field_135);
   }

   public String toString() {
      if (this.isEmpty()) {
         return "{}";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append('{');
         boolean var2 = true;
         Iterator var3 = this.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            Object var5 = var4.getKey();
            Object var6 = var4.getValue();
            if (var2) {
               var2 = false;
            } else {
               var1.append(", ");
            }

            var1.append(var5 == this ? "(this Map)" : var5);
            var1.append('=');
            var1.append(var6 == this ? "(this Map)" : var6);
         }

         var1.append('}');
         return var1.toString();
      }
   }

   // $FF: renamed from: a (int) java.lang.Object
   public Object method_345(int var1) {
      return this.field_135.get(var1);
   }

   // $FF: renamed from: b (int) java.lang.Object
   public Object method_346(int var1) {
      return this.get(this.field_135.get(var1));
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_347(Object var1) {
      return this.field_135.indexOf(var1);
   }

   // $FF: renamed from: a (int, java.lang.Object) java.lang.Object
   public Object method_348(int var1, Object var2) {
      Object var3 = this.field_135.get(var1);
      return this.put(var3, var2);
   }

   // $FF: renamed from: a (int, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_349(int var1, Object var2, Object var3) {
      if (var1 >= 0 && var1 <= this.field_135.size()) {
         Map var4 = this.i();
         if (var4.containsKey(var2)) {
            Object var5 = var4.remove(var2);
            int var6 = this.field_135.indexOf(var2);
            this.field_135.remove(var6);
            if (var6 < var1) {
               --var1;
            }

            this.field_135.add(var1, var2);
            var4.put(var2, var3);
            return var5;
         } else {
            this.field_135.add(var1, var2);
            var4.put(var2, var3);
            return null;
         }
      } else {
         throw new IndexOutOfBoundsException("Index: " + var1 + ", Size: " + this.field_135.size());
      }
   }

   // $FF: renamed from: c (int) java.lang.Object
   public Object method_350(int var1) {
      return this.remove(this.method_345(var1));
   }

   // $FF: renamed from: d () java.util.List
   public List method_351() {
      return this.method_343();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }

   // $FF: renamed from: a (org.a.a.a.i.ak) java.util.List
   // $FF: synthetic method
   static List method_352(class_131 var0) {
      return var0.field_135;
   }
}
