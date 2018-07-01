package org.a.a.a.h;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_29;
import org.a.a.a.f.class_461;
import org.a.a.a.f.class_462;

// $FF: renamed from: org.a.a.a.h.A
public final class class_51 extends class_50 implements class_29 {
   // $FF: renamed from: a long
   private static final long field_32 = 6595182819922443652L;

   // $FF: renamed from: a (java.util.List) java.util.List
   public static List method_108(List var0) {
      return (List)(var0 instanceof class_29 ? var0 : new class_51(var0));
   }

   public class_51(List var1) {
      super(var1);
   }

   public Iterator iterator() {
      return class_461.method_1543(this.c().iterator());
   }

   public boolean add(Object var1) {
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

   public ListIterator listIterator() {
      return class_462.method_1544(this.c().listIterator());
   }

   public ListIterator listIterator(int var1) {
      return class_462.method_1544(this.c().listIterator(var1));
   }

   public void add(int var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(int var1, Collection var2) {
      throw new UnsupportedOperationException();
   }

   public Object remove(int var1) {
      throw new UnsupportedOperationException();
   }

   public Object set(int var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public List subList(int var1, int var2) {
      List var3 = this.c().subList(var1, var2);
      return new class_51(var3);
   }
}
