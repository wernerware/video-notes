package org.a.a.a.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.a.a.a.class_415;
import org.a.a.a.class_5;
import org.a.a.a.e.class_344;
import org.a.a.a.h.class_51;

// $FF: renamed from: org.a.a.a.n.g
public class class_73 extends class_72 {
   // $FF: renamed from: a long
   private static final long field_59 = -228664372470420141L;
   // $FF: renamed from: b java.util.List
   private final List field_60;

   // $FF: renamed from: a (java.util.Set, java.util.List) org.a.a.a.n.g
   public static class_73 method_140(Set var0, List var1) {
      if (var0 == null) {
         throw new NullPointerException("Set must not be null");
      } else if (var1 == null) {
         throw new NullPointerException("List must not be null");
      } else if (var0.size() <= 0 && var1.size() <= 0) {
         return new class_73(var0, var1);
      } else {
         throw new IllegalArgumentException("Set and List must be empty");
      }
   }

   // $FF: renamed from: a (java.util.Set) org.a.a.a.n.g
   public static class_73 method_141(Set var0) {
      return new class_73(var0);
   }

   // $FF: renamed from: a (java.util.List) org.a.a.a.n.g
   public static class_73 method_142(List var0) {
      if (var0 == null) {
         throw new NullPointerException("List must not be null");
      } else {
         class_415.method_1346(var0, class_344.method_876());
         HashSet var1 = new HashSet(var0);
         return new class_73(var1, var0);
      }
   }

   public class_73() {
      super(new HashSet());
      this.field_60 = new ArrayList();
   }

   protected class_73(Set var1) {
      super(var1);
      this.field_60 = new ArrayList(var1);
   }

   protected class_73(Set var1, List var2) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("List must not be null");
      } else {
         this.field_60 = var2;
      }
   }

   // $FF: renamed from: a () java.util.List
   public List method_143() {
      return class_51.method_108(this.field_60);
   }

   public void clear() {
      this.c().clear();
      this.field_60.clear();
   }

   // $FF: renamed from: b () org.a.a.a.ak
   public class_5 method_144() {
      return new class_185(this.field_60.listIterator(), this.c(), (class_404)null);
   }

   public boolean add(Object var1) {
      if (this.c().add(var1)) {
         this.field_60.add(var1);
         return true;
      } else {
         return false;
      }
   }

   public boolean addAll(Collection var1) {
      boolean var2 = false;

      Object var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 |= this.add(var4)) {
         var4 = var3.next();
      }

      return var2;
   }

   public boolean remove(Object var1) {
      boolean var2 = this.c().remove(var1);
      if (var2) {
         this.field_60.remove(var1);
      }

      return var2;
   }

   public boolean removeAll(Collection var1) {
      boolean var2 = false;

      Object var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 |= this.remove(var4)) {
         var4 = var3.next();
      }

      return var2;
   }

   public boolean retainAll(Collection var1) {
      boolean var2 = this.c().retainAll(var1);
      if (!var2) {
         return false;
      } else {
         if (this.c().size() == 0) {
            this.field_60.clear();
         } else {
            Iterator var3 = this.field_60.iterator();

            while(var3.hasNext()) {
               if (!this.c().contains(var3.next())) {
                  var3.remove();
               }
            }
         }

         return var2;
      }
   }

   public Object[] toArray() {
      return this.field_60.toArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.field_60.toArray(var1);
   }

   // $FF: renamed from: a (int) java.lang.Object
   public Object method_145(int var1) {
      return this.field_60.get(var1);
   }

   // $FF: renamed from: a (java.lang.Object) int
   public int method_146(Object var1) {
      return this.field_60.indexOf(var1);
   }

   // $FF: renamed from: a (int, java.lang.Object) void
   public void method_147(int var1, Object var2) {
      if (!this.contains(var2)) {
         this.c().add(var2);
         this.field_60.add(var1, var2);
      }

   }

   // $FF: renamed from: a (int, java.util.Collection) boolean
   public boolean method_148(int var1, Collection var2) {
      boolean var3 = false;
      ArrayList var4 = new ArrayList();
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         Object var6 = var5.next();
         if (!this.contains(var6)) {
            this.c().add(var6);
            var4.add(var6);
            var3 = true;
         }
      }

      if (var3) {
         this.field_60.addAll(var1, var4);
      }

      return var3;
   }

   // $FF: renamed from: b (int) java.lang.Object
   public Object method_149(int var1) {
      Object var2 = this.field_60.remove(var1);
      this.remove(var2);
      return var2;
   }

   public String toString() {
      return this.field_60.toString();
   }

   // $FF: synthetic method
   public Iterator iterator() {
      return this.method_144();
   }
}
