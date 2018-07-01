package org.a.a.a.i;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.a.a.a.f.class_461;
import org.a.a.a.f.class_462;
import org.a.a.a.h.class_51;

// $FF: renamed from: org.a.a.a.i.aj
class class_240 extends AbstractList {
   // $FF: renamed from: a org.a.a.a.i.ai
   private final class_154 field_347;

   class_240(class_154 var1) {
      this.field_347 = var1;
   }

   public int size() {
      return this.field_347.size();
   }

   public Object get(int var1) {
      return this.field_347.method_476(var1);
   }

   public boolean contains(Object var1) {
      return this.field_347.containsKey(var1);
   }

   public int indexOf(Object var1) {
      return this.field_347.method_478(var1);
   }

   public int lastIndexOf(Object var1) {
      return this.field_347.method_478(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.field_347.keySet().containsAll(var1);
   }

   public Object remove(int var1) {
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

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Object[] toArray() {
      return this.field_347.keySet().toArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.field_347.keySet().toArray(var1);
   }

   public Iterator iterator() {
      return class_461.method_1543(this.field_347.keySet().iterator());
   }

   public ListIterator listIterator() {
      return class_462.method_1544(super.listIterator());
   }

   public ListIterator listIterator(int var1) {
      return class_462.method_1544(super.listIterator(var1));
   }

   public List subList(int var1, int var2) {
      return class_51.method_108(super.subList(var1, var2));
   }
}
