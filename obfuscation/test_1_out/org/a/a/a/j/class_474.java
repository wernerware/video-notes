package org.a.a.a.j;

import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.class_401;
import org.a.a.a.class_415;

// $FF: renamed from: org.a.a.a.j.s
class class_474 implements Collection {
   // $FF: renamed from: b java.lang.Object
   protected final Object field_865;
   // $FF: renamed from: c org.a.a.a.j.d
   // $FF: synthetic field
   final class_467 field_866;

   public class_474(class_467 var1, Object var2) {
      this.field_866 = var1;
      this.field_865 = var2;
   }

   // $FF: renamed from: b () java.util.Collection
   protected Collection method_1570() {
      return (Collection)this.field_866.method_1552().get(this.field_865);
   }

   public boolean add(Object var1) {
      Collection var2 = this.method_1570();
      if (var2 == null) {
         var2 = this.field_866.method_1554();
         class_467.method_1558(this.field_866).put(this.field_865, var2);
      }

      return var2.add(var1);
   }

   public boolean addAll(Collection var1) {
      Collection var2 = this.method_1570();
      if (var2 == null) {
         var2 = this.field_866.method_1554();
         class_467.method_1558(this.field_866).put(this.field_865, var2);
      }

      return var2.addAll(var1);
   }

   public void clear() {
      Collection var1 = this.method_1570();
      if (var1 != null) {
         var1.clear();
         this.field_866.method_43(this.field_865);
      }

   }

   public Iterator iterator() {
      Collection var1 = this.method_1570();
      return (Iterator)(var1 == null ? class_401.field_701 : new class_480(this.field_866, this.field_865));
   }

   public int size() {
      Collection var1 = this.method_1570();
      return var1 == null ? 0 : var1.size();
   }

   public boolean contains(Object var1) {
      Collection var2 = this.method_1570();
      return var2 == null ? false : var2.contains(var1);
   }

   public boolean containsAll(Collection var1) {
      Collection var2 = this.method_1570();
      return var2 == null ? false : var2.containsAll(var1);
   }

   public boolean isEmpty() {
      Collection var1 = this.method_1570();
      return var1 == null ? true : var1.isEmpty();
   }

   public boolean remove(Object var1) {
      Collection var2 = this.method_1570();
      if (var2 == null) {
         return false;
      } else {
         boolean var3 = var2.remove(var1);
         if (var2.isEmpty()) {
            this.field_866.method_43(this.field_865);
         }

         return var3;
      }
   }

   public boolean removeAll(Collection var1) {
      Collection var2 = this.method_1570();
      if (var2 == null) {
         return false;
      } else {
         boolean var3 = var2.removeAll(var1);
         if (var2.isEmpty()) {
            this.field_866.method_43(this.field_865);
         }

         return var3;
      }
   }

   public boolean retainAll(Collection var1) {
      Collection var2 = this.method_1570();
      if (var2 == null) {
         return false;
      } else {
         boolean var3 = var2.retainAll(var1);
         if (var2.isEmpty()) {
            this.field_866.method_43(this.field_865);
         }

         return var3;
      }
   }

   public Object[] toArray() {
      Collection var1 = this.method_1570();
      return var1 == null ? class_415.field_723.toArray() : var1.toArray();
   }

   public Object[] toArray(Object[] var1) {
      Collection var2 = this.method_1570();
      return var2 == null ? (Object[])class_415.field_723.toArray(var1) : var2.toArray(var1);
   }

   public String toString() {
      Collection var1 = this.method_1570();
      return var1 == null ? class_415.field_723.toString() : var1.toString();
   }
}
