package org.a.a.a.h;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.c.class_48;

// $FF: renamed from: org.a.a.a.h.f
public abstract class class_49 extends class_48 implements List {
   // $FF: renamed from: a long
   private static final long field_30 = 4500739654952315623L;

   protected class_49() {
   }

   protected class_49(List var1) {
      super(var1);
   }

   // $FF: renamed from: c () java.util.List
   protected List method_105() {
      return (List)super.method_103();
   }

   public boolean equals(Object var1) {
      return var1 == this || this.method_105().equals(var1);
   }

   public int hashCode() {
      return this.method_105().hashCode();
   }

   public void add(int var1, Object var2) {
      this.method_105().add(var1, var2);
   }

   public boolean addAll(int var1, Collection var2) {
      return this.method_105().addAll(var1, var2);
   }

   public Object get(int var1) {
      return this.method_105().get(var1);
   }

   public int indexOf(Object var1) {
      return this.method_105().indexOf(var1);
   }

   public int lastIndexOf(Object var1) {
      return this.method_105().lastIndexOf(var1);
   }

   public ListIterator listIterator() {
      return this.method_105().listIterator();
   }

   public ListIterator listIterator(int var1) {
      return this.method_105().listIterator(var1);
   }

   public Object remove(int var1) {
      return this.method_105().remove(var1);
   }

   public Object set(int var1, Object var2) {
      return this.method_105().set(var1, var2);
   }

   public List subList(int var1, int var2) {
      return this.method_105().subList(var1, var2);
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_105();
   }
}
