package org.a.a.a.c;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.a.a.a.f.class_166;
import org.a.a.a.f.class_220;
import org.a.a.a.h.class_51;

// $FF: renamed from: org.a.a.a.c.b
public class class_107 implements Serializable, Collection {
   // $FF: renamed from: a long
   private static final long field_104 = 8417515734108306801L;
   // $FF: renamed from: b org.a.a.a.c.c
   private class_0 field_105;
   // $FF: renamed from: c java.util.List
   private final List field_106 = new ArrayList();

   public class_107() {
   }

   public class_107(Collection var1) {
      this.method_242(var1);
   }

   public class_107(Collection var1, Collection var2) {
      this.method_243(var1, var2);
   }

   public class_107(Collection... var1) {
      this.method_244(var1);
   }

   public int size() {
      int var1 = 0;

      Collection var3;
      for(Iterator var2 = this.field_106.iterator(); var2.hasNext(); var1 += var3.size()) {
         var3 = (Collection)var2.next();
      }

      return var1;
   }

   public boolean isEmpty() {
      Iterator var1 = this.field_106.iterator();

      Collection var2;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         var2 = (Collection)var1.next();
      } while(var2.isEmpty());

      return false;
   }

   public boolean contains(Object var1) {
      Iterator var2 = this.field_106.iterator();

      Collection var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (Collection)var2.next();
      } while(!var3.contains(var1));

      return true;
   }

   public Iterator iterator() {
      if (this.field_106.isEmpty()) {
         return class_166.method_517();
      } else {
         class_220 var1 = new class_220();
         Iterator var2 = this.field_106.iterator();

         while(var2.hasNext()) {
            Collection var3 = (Collection)var2.next();
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
      Iterator var5 = this.field_106.iterator();

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
      if (this.field_105 == null) {
         throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
      } else {
         return this.field_105.method_0(this, this.field_106, var1);
      }
   }

   public boolean remove(Object var1) {
      if (this.field_105 == null) {
         throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
      } else {
         return this.field_105.method_2(this, this.field_106, var1);
      }
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
      if (this.field_105 == null) {
         throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
      } else {
         return this.field_105.method_1(this, this.field_106, var1);
      }
   }

   public boolean removeAll(Collection var1) {
      if (var1.size() == 0) {
         return false;
      } else {
         boolean var2 = false;

         Collection var4;
         for(Iterator var3 = this.field_106.iterator(); var3.hasNext(); var2 |= var4.removeAll(var1)) {
            var4 = (Collection)var3.next();
         }

         return var2;
      }
   }

   public boolean retainAll(Collection var1) {
      boolean var2 = false;

      Collection var4;
      for(Iterator var3 = this.field_106.iterator(); var3.hasNext(); var2 |= var4.retainAll(var1)) {
         var4 = (Collection)var3.next();
      }

      return var2;
   }

   public void clear() {
      Iterator var1 = this.field_106.iterator();

      while(var1.hasNext()) {
         Collection var2 = (Collection)var1.next();
         var2.clear();
      }

   }

   // $FF: renamed from: a (org.a.a.a.c.c) void
   public void method_241(class_0 var1) {
      this.field_105 = var1;
   }

   // $FF: renamed from: a (java.util.Collection) void
   public void method_242(Collection var1) {
      this.field_106.add(var1);
   }

   // $FF: renamed from: a (java.util.Collection, java.util.Collection) void
   public void method_243(Collection var1, Collection var2) {
      this.field_106.add(var1);
      this.field_106.add(var2);
   }

   // $FF: renamed from: a (java.util.Collection[]) void
   public void method_244(Collection... var1) {
      this.field_106.addAll(Arrays.asList(var1));
   }

   // $FF: renamed from: b (java.util.Collection) void
   public void method_245(Collection var1) {
      this.field_106.remove(var1);
   }

   // $FF: renamed from: a () java.util.Collection
   public Collection method_246() {
      return new ArrayList(this);
   }

   // $FF: renamed from: b () java.util.List
   public List method_247() {
      return class_51.method_108(this.field_106);
   }

   // $FF: renamed from: c () org.a.a.a.c.c
   protected class_0 method_248() {
      return this.field_105;
   }
}
