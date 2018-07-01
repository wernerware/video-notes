package org.a.a.a.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.a.a.a.class_400;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.h.r
public class class_54 extends class_50 {
   // $FF: renamed from: a long
   private static final long field_36 = 7196982186153478694L;
   // $FF: renamed from: b java.util.Set
   private final Set field_37;

   // $FF: renamed from: a (java.util.List) org.a.a.a.h.r
   public static class_54 method_111(List var0) {
      if (var0 == null) {
         throw new NullPointerException("List must not be null");
      } else if (var0.isEmpty()) {
         return new class_54(var0, new HashSet());
      } else {
         ArrayList var1 = new ArrayList(var0);
         var0.clear();
         class_54 var2 = new class_54(var0, new HashSet());
         var2.addAll(var1);
         return var2;
      }
   }

   protected class_54(List var1, Set var2) {
      super(var1);
      if (var2 == null) {
         throw new NullPointerException("Set must not be null");
      } else {
         this.field_37 = var2;
      }
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_112() {
      return class_74.method_150(this.field_37);
   }

   public boolean add(Object var1) {
      int var2 = this.size();
      this.add(this.size(), var1);
      return var2 != this.size();
   }

   public void add(int var1, Object var2) {
      if (!this.field_37.contains(var2)) {
         super.add(var1, var2);
         this.field_37.add(var2);
      }

   }

   public boolean addAll(Collection var1) {
      return this.addAll(this.size(), var1);
   }

   public boolean addAll(int var1, Collection var2) {
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if (this.field_37.add(var5)) {
            var3.add(var5);
         }
      }

      return super.addAll(var1, var3);
   }

   public Object set(int var1, Object var2) {
      int var3 = this.indexOf(var2);
      Object var4 = super.set(var1, var2);
      if (var3 != -1 && var3 != var1) {
         super.remove(var3);
      }

      this.field_37.remove(var4);
      this.field_37.add(var2);
      return var4;
   }

   public boolean remove(Object var1) {
      boolean var2 = this.field_37.remove(var1);
      if (var2) {
         super.remove(var1);
      }

      return var2;
   }

   public Object remove(int var1) {
      Object var2 = super.remove(var1);
      this.field_37.remove(var2);
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
      boolean var2 = this.field_37.retainAll(var1);
      if (!var2) {
         return false;
      } else {
         if (this.field_37.size() == 0) {
            super.clear();
         } else {
            super.retainAll(this.field_37);
         }

         return var2;
      }
   }

   public void clear() {
      super.clear();
      this.field_37.clear();
   }

   public boolean contains(Object var1) {
      return this.field_37.contains(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.field_37.containsAll(var1);
   }

   public Iterator iterator() {
      return new class_184(super.iterator(), this.field_37);
   }

   public ListIterator listIterator() {
      return new class_198(super.listIterator(), this.field_37);
   }

   public ListIterator listIterator(int var1) {
      return new class_198(super.listIterator(var1), this.field_37);
   }

   public List subList(int var1, int var2) {
      List var3 = super.subList(var1, var2);
      Set var4 = this.method_113(this.field_37, var3);
      return class_400.method_1158(new class_54(var3, var4));
   }

   // $FF: renamed from: a (java.util.Set, java.util.List) java.util.Set
   protected Set method_113(Set var1, List var2) {
      Object var3;
      if (var1.getClass().equals(HashSet.class)) {
         var3 = new HashSet(var2.size());
      } else {
         try {
            var3 = (Set)var1.getClass().newInstance();
         } catch (InstantiationException var5) {
            var3 = new HashSet();
         } catch (IllegalAccessException var6) {
            var3 = new HashSet();
         }
      }

      ((Set)var3).addAll(var2);
      return (Set)var3;
   }
}
