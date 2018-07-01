package org.a.a.a.n;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.a.a.a.class_415;
import org.a.a.a.f.class_166;
import org.a.a.a.f.class_220;
import org.a.a.a.h.class_51;

// $FF: renamed from: org.a.a.a.n.e
public class class_399 implements Serializable, Set {
   // $FF: renamed from: a long
   private static final long field_698 = 5185069727540378940L;
   // $FF: renamed from: b org.a.a.a.n.f
   private class_31 field_699;
   // $FF: renamed from: c java.util.List
   private final List field_700 = new ArrayList();

   public class_399() {
   }

   public class_399(Set var1) {
      this.method_1138(var1);
   }

   public class_399(Set... var1) {
      this.method_1140(var1);
   }

   public int size() {
      int var1 = 0;

      Set var3;
      for(Iterator var2 = this.field_700.iterator(); var2.hasNext(); var1 += var3.size()) {
         var3 = (Set)var2.next();
      }

      return var1;
   }

   public boolean isEmpty() {
      Iterator var1 = this.field_700.iterator();

      Set var2;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         var2 = (Set)var1.next();
      } while(var2.isEmpty());

      return false;
   }

   public boolean contains(Object var1) {
      Iterator var2 = this.field_700.iterator();

      Set var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (Set)var2.next();
      } while(!var3.contains(var1));

      return true;
   }

   public Iterator iterator() {
      if (this.field_700.isEmpty()) {
         return class_166.method_517();
      } else {
         class_220 var1 = new class_220();
         Iterator var2 = this.field_700.iterator();

         while(var2.hasNext()) {
            Set var3 = (Set)var2.next();
            var1.method_568(var3.iterator());
         }

         return var1;
      }
   }

   public Object[] toArray() {
      Object[] var1 = new Object[this.size()];
      int var2 = 0;

      for(Iterator var3 = this.iterator(); var3.hasNext(); ++var2) {
         var1[var2] = var3.next();
      }

      return var1;
   }

   public Object[] toArray(Object[] var1) {
      int var2 = this.size();
      Object[] var3 = null;
      if (var1.length >= var2) {
         var3 = var1;
      } else {
         var3 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), var2));
      }

      int var4 = 0;
      Iterator var5 = this.field_700.iterator();

      while(var5.hasNext()) {
         Collection var6 = (Collection)var5.next();

         Object var8;
         for(Iterator var7 = var6.iterator(); var7.hasNext(); var3[var4++] = var8) {
            var8 = var7.next();
         }
      }

      if (var3.length > var2) {
         var3[var2] = null;
      }

      return (Object[])var3;
   }

   public boolean add(Object var1) {
      if (this.field_699 == null) {
         throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
      } else {
         return this.field_699.method_64(this, this.field_700, var1);
      }
   }

   public boolean remove(Object var1) {
      Iterator var2 = this.method_1143().iterator();

      Set var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (Set)var2.next();
      } while(!var3.contains(var1));

      return var3.remove(var1);
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

   public boolean addAll(Collection var1) {
      if (this.field_699 == null) {
         throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
      } else {
         return this.field_699.method_65(this, this.field_700, var1);
      }
   }

   public boolean removeAll(Collection var1) {
      if (var1.size() == 0) {
         return false;
      } else {
         boolean var2 = false;

         Collection var4;
         for(Iterator var3 = this.field_700.iterator(); var3.hasNext(); var2 |= var4.removeAll(var1)) {
            var4 = (Collection)var3.next();
         }

         return var2;
      }
   }

   public boolean retainAll(Collection var1) {
      boolean var2 = false;

      Collection var4;
      for(Iterator var3 = this.field_700.iterator(); var3.hasNext(); var2 |= var4.retainAll(var1)) {
         var4 = (Collection)var3.next();
      }

      return var2;
   }

   public void clear() {
      Iterator var1 = this.field_700.iterator();

      while(var1.hasNext()) {
         Collection var2 = (Collection)var1.next();
         var2.clear();
      }

   }

   // $FF: renamed from: a (org.a.a.a.n.f) void
   public void method_1137(class_31 var1) {
      this.field_699 = var1;
   }

   // $FF: renamed from: a (java.util.Set) void
   public synchronized void method_1138(Set var1) {
      Iterator var2 = this.method_1143().iterator();

      while(var2.hasNext()) {
         Set var3 = (Set)var2.next();
         Collection var4 = class_415.method_1329(var3, var1);
         if (var4.size() > 0) {
            if (this.field_699 == null) {
               throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");
            }

            this.method_1144().method_66(this, var3, var1, var4);
            if (class_415.method_1329(var3, var1).size() > 0) {
               throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
            }
         }
      }

      this.field_700.add(var1);
   }

   // $FF: renamed from: a (java.util.Set, java.util.Set) void
   public void method_1139(Set var1, Set var2) {
      this.method_1138(var1);
      this.method_1138(var2);
   }

   // $FF: renamed from: a (java.util.Set[]) void
   public void method_1140(Set... var1) {
      Set[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Set var5 = var2[var4];
         this.method_1138(var5);
      }

   }

   // $FF: renamed from: b (java.util.Set) void
   public void method_1141(Set var1) {
      this.field_700.remove(var1);
   }

   // $FF: renamed from: a () java.util.Set
   public Set method_1142() {
      return new HashSet(this);
   }

   // $FF: renamed from: b () java.util.List
   public List method_1143() {
      return class_51.method_108(this.field_700);
   }

   // $FF: renamed from: c () org.a.a.a.n.f
   protected class_31 method_1144() {
      return this.field_699;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof Set)) {
         return false;
      } else {
         Set var2 = (Set)var1;
         return var2.size() == this.size() && var2.containsAll(this);
      }
   }

   public int hashCode() {
      int var1 = 0;

      Object var3;
      for(Iterator var2 = this.iterator(); var2.hasNext(); var1 += var3 == null ? 0 : var3.hashCode()) {
         var3 = var2.next();
      }

      return var1;
   }
}
