package org.a.a.a.c;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.c.a
public abstract class class_48 implements Serializable, Collection {
   // $FF: renamed from: a long
   private static final long field_28 = 6249888059822088500L;
   // $FF: renamed from: b java.util.Collection
   private Collection field_29;

   protected class_48() {
   }

   protected class_48(Collection var1) {
      if (var1 == null) {
         throw new NullPointerException("Collection must not be null.");
      } else {
         this.field_29 = var1;
      }
   }

   // $FF: renamed from: f () java.util.Collection
   protected Collection method_103() {
      return this.field_29;
   }

   // $FF: renamed from: a (java.util.Collection) void
   protected void method_104(Collection var1) {
      this.field_29 = var1;
   }

   public boolean add(Object var1) {
      return this.method_103().add(var1);
   }

   public boolean addAll(Collection var1) {
      return this.method_103().addAll(var1);
   }

   public void clear() {
      this.method_103().clear();
   }

   public boolean contains(Object var1) {
      return this.method_103().contains(var1);
   }

   public boolean isEmpty() {
      return this.method_103().isEmpty();
   }

   public Iterator iterator() {
      return this.method_103().iterator();
   }

   public boolean remove(Object var1) {
      return this.method_103().remove(var1);
   }

   public int size() {
      return this.method_103().size();
   }

   public Object[] toArray() {
      return this.method_103().toArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.method_103().toArray(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.method_103().containsAll(var1);
   }

   public boolean removeAll(Collection var1) {
      return this.method_103().removeAll(var1);
   }

   public boolean retainAll(Collection var1) {
      return this.method_103().retainAll(var1);
   }

   public String toString() {
      return this.method_103().toString();
   }
}
