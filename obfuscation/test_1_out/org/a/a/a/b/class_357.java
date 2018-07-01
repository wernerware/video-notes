package org.a.a.a.b;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map.Entry;
import org.a.a.a.class_20;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.b.q
public class class_357 implements class_7, class_20 {
   // $FF: renamed from: a org.a.a.a.b.b
   private final class_353 field_599;
   // $FF: renamed from: b java.util.ListIterator
   private ListIterator field_600;
   // $FF: renamed from: c java.util.Map.Entry
   private Entry field_601 = null;

   protected class_357(class_353 var1) {
      this.field_599 = var1;
      this.field_600 = (new ArrayList(var1.entrySet())).listIterator();
   }

   public boolean hasNext() {
      return this.field_600.hasNext();
   }

   public Object next() {
      this.field_601 = (Entry)this.field_600.next();
      return this.field_601.getKey();
   }

   public boolean hasPrevious() {
      return this.field_600.hasPrevious();
   }

   public Object previous() {
      this.field_601 = (Entry)this.field_600.previous();
      return this.field_601.getKey();
   }

   public void remove() {
      this.field_600.remove();
      this.field_599.remove(this.field_601.getKey());
      this.field_601 = null;
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (this.field_601 == null) {
         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
      } else {
         return this.field_601.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (this.field_601 == null) {
         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
      } else {
         return this.field_601.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (this.field_601 == null) {
         throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
      } else if (this.field_599.field_589.containsKey(var1) && this.field_599.field_589.get(var1) != this.field_601.getKey()) {
         throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
      } else {
         Object var2 = this.field_599.put(this.field_601.getKey(), var1);
         this.field_601.setValue(var1);
         return var2;
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_600 = (new ArrayList(this.field_599.entrySet())).listIterator();
      this.field_601 = null;
   }

   public String toString() {
      return this.field_601 != null ? "MapIterator[" + this.method_6() + "=" + this.method_7() + "]" : "MapIterator[]";
   }
}
