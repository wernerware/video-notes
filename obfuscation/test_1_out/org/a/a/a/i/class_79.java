package org.a.a.a.i;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_29;
import org.a.a.a.n.class_70;

// $FF: renamed from: org.a.a.a.i.aY
public final class class_79 extends class_70 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_66 = 1678353579659253473L;

   // $FF: renamed from: a (java.util.Set) java.util.Set
   public static Set method_159(Set var0) {
      return (Set)(var0 instanceof class_29 ? var0 : new class_79(var0));
   }

   private class_79(Set var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.util.Map.Entry) boolean
   public boolean method_160(Entry var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public Iterator iterator() {
      return new class_190(this, this.c().iterator());
   }

   public Object[] toArray() {
      Object[] var1 = this.c().toArray();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = new class_211(this, (Entry)var1[var2]);
      }

      return var1;
   }

   public Object[] toArray(Object[] var1) {
      Object[] var2 = var1;
      if (var1.length > 0) {
         var2 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), 0));
      }

      var2 = this.c().toArray(var2);

      for(int var3 = 0; var3 < var2.length; ++var3) {
         var2[var3] = new class_211(this, (Entry)var2[var3]);
      }

      if (var2.length > var1.length) {
         return (Object[])var2;
      } else {
         System.arraycopy(var2, 0, var1, 0, var2.length);
         if (var1.length > var2.length) {
            var1[var2.length] = null;
         }

         return var1;
      }
   }

   // $FF: synthetic method
   public boolean add(Object var1) {
      return this.method_160((Entry)var1);
   }
}
