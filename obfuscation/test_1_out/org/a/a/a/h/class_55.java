package org.a.a.a.h;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_35;
import org.a.a.a.f.class_461;

// $FF: renamed from: org.a.a.a.h.k
public class class_55 extends class_50 implements class_35 {
   // $FF: renamed from: a long
   private static final long field_38 = -2218010673611160319L;

   // $FF: renamed from: a (java.util.List) org.a.a.a.h.k
   public static class_55 method_114(List var0) {
      return new class_55(var0);
   }

   protected class_55(List var1) {
      super(var1);
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public void add(int var1, Object var2) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public boolean addAll(int var1, Collection var2) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public void clear() {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public Object get(int var1) {
      return this.c().get(var1);
   }

   public int indexOf(Object var1) {
      return this.c().indexOf(var1);
   }

   public Iterator iterator() {
      return class_461.method_1543(this.c().iterator());
   }

   public int lastIndexOf(Object var1) {
      return this.c().lastIndexOf(var1);
   }

   public ListIterator listIterator() {
      return new class_196(this, this.c().listIterator(0));
   }

   public ListIterator listIterator(int var1) {
      return new class_196(this, this.c().listIterator(var1));
   }

   public Object remove(int var1) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException("List is fixed size");
   }

   public Object set(int var1, Object var2) {
      return this.c().set(var1, var2);
   }

   public List subList(int var1, int var2) {
      List var3 = this.c().subList(var1, var2);
      return new class_55(var3);
   }

   // $FF: renamed from: a () boolean
   public boolean method_71() {
      return true;
   }

   // $FF: renamed from: b () int
   public int method_72() {
      return this.size();
   }
}
