package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_14;
import org.a.a.a.class_32;
import org.a.a.a.class_415;
import org.a.a.a.f.class_166;

// $FF: renamed from: org.a.a.a.i.au
public class class_130 extends class_116 implements Serializable, class_14 {
   // $FF: renamed from: b long
   private static final long field_131 = -2214159910087182007L;
   // $FF: renamed from: c org.a.a.a.s
   private final class_32 field_132;
   // $FF: renamed from: d java.util.Collection
   private transient Collection field_133;

   // $FF: renamed from: a (java.util.Map) org.a.a.a.i.au
   public static class_130 method_326(Map var0) {
      return method_327(var0, ArrayList.class);
   }

   // $FF: renamed from: a (java.util.Map, java.lang.Class) org.a.a.a.i.au
   public static class_130 method_327(Map var0, Class var1) {
      return new class_130(var0, new class_262(var1));
   }

   // $FF: renamed from: a (java.util.Map, org.a.a.a.s) org.a.a.a.i.au
   public static class_130 method_328(Map var0, class_32 var1) {
      return new class_130(var0, var1);
   }

   public class_130() {
      this(new HashMap(), new class_262(ArrayList.class));
   }

   protected class_130(Map var1, class_32 var2) {
      super(var1);
      if (var2 == null) {
         throw new IllegalArgumentException("The factory must not be null");
      } else {
         this.field_132 = var2;
      }
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_329(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_330(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   public void clear() {
      this.i().clear();
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   public boolean method_16(Object var1, Object var2) {
      Collection var3 = this.method_332(var1);
      if (var3 == null) {
         return false;
      } else {
         boolean var4 = var3.remove(var2);
         if (!var4) {
            return false;
         } else {
            if (var3.isEmpty()) {
               this.remove(var1);
            }

            return true;
         }
      }
   }

   public boolean containsValue(Object var1) {
      Set var2 = this.i().entrySet();
      if (var2 != null) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            if (((Collection)var4.getValue()).contains(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   public Object put(Object var1, Object var2) {
      boolean var3 = false;
      Collection var4 = this.method_332(var1);
      if (var4 == null) {
         var4 = this.method_338(1);
         var4.add(var2);
         if (var4.size() > 0) {
            this.i().put(var1, var4);
            var3 = true;
         }
      } else {
         var3 = var4.add(var2);
      }

      return var3 ? var2 : null;
   }

   public void putAll(Map var1) {
      Iterator var2;
      Entry var3;
      if (var1 instanceof class_14) {
         var2 = ((class_14)var1).entrySet().iterator();

         while(var2.hasNext()) {
            var3 = (Entry)var2.next();
            this.method_334(var3.getKey(), (Collection)var3.getValue());
         }
      } else {
         var2 = var1.entrySet().iterator();

         while(var2.hasNext()) {
            var3 = (Entry)var2.next();
            this.put(var3.getKey(), var3.getValue());
         }
      }

   }

   public Set entrySet() {
      return super.entrySet();
   }

   public Collection values() {
      Collection var1 = this.field_133;
      return var1 != null ? var1 : (this.field_133 = new class_265(this, (class_216)null));
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   public boolean method_331(Object var1, Object var2) {
      Collection var3 = this.method_332(var1);
      return var3 == null ? false : var3.contains(var2);
   }

   // $FF: renamed from: a (java.lang.Object) java.util.Collection
   public Collection method_332(Object var1) {
      return (Collection)this.i().get(var1);
   }

   // $FF: renamed from: b (java.lang.Object) int
   public int method_333(Object var1) {
      Collection var2 = this.method_332(var1);
      return var2 == null ? 0 : var2.size();
   }

   // $FF: renamed from: a (java.lang.Object, java.util.Collection) boolean
   public boolean method_334(Object var1, Collection var2) {
      if (var2 != null && var2.size() != 0) {
         boolean var3 = false;
         Collection var4 = this.method_332(var1);
         if (var4 == null) {
            var4 = this.method_338(var2.size());
            var4.addAll(var2);
            if (var4.size() > 0) {
               this.i().put(var1, var4);
               var3 = true;
            }
         } else {
            var3 = var4.addAll(var2);
         }

         return var3;
      } else {
         return false;
      }
   }

   // $FF: renamed from: c (java.lang.Object) java.util.Iterator
   public Iterator method_335(Object var1) {
      return (Iterator)(!this.containsKey(var1) ? class_166.method_517() : new class_298(this, var1));
   }

   // $FF: renamed from: a () java.util.Iterator
   public Iterator method_336() {
      ArrayList var1 = new ArrayList(this.keySet());
      Iterator var2 = var1.iterator();
      return new class_216(this, var2);
   }

   // $FF: renamed from: b () int
   public int method_337() {
      int var1 = 0;

      Object var3;
      for(Iterator var2 = this.i().values().iterator(); var2.hasNext(); var1 += class_415.method_1371(var3)) {
         var3 = var2.next();
      }

      return var1;
   }

   // $FF: renamed from: a (int) java.util.Collection
   protected Collection method_338(int var1) {
      return (Collection)this.field_132.method_67();
   }
}
