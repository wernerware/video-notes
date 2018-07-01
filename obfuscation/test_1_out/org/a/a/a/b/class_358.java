package org.a.a.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.class_20;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.b.c
public class class_358 implements class_4, class_20 {
   // $FF: renamed from: a org.a.a.a.b.b
   protected final class_353 field_602;
   // $FF: renamed from: b java.util.Iterator
   protected Iterator field_603;
   // $FF: renamed from: c java.util.Map.Entry
   protected Entry field_604 = null;
   // $FF: renamed from: d boolean
   protected boolean field_605 = false;

   protected class_358(class_353 var1) {
      this.field_602 = var1;
      this.field_603 = var1.field_588.entrySet().iterator();
   }

   public boolean hasNext() {
      return this.field_603.hasNext();
   }

   public Object next() {
      this.field_604 = (Entry)this.field_603.next();
      this.field_605 = true;
      return this.field_604.getKey();
   }

   public void remove() {
      if (!this.field_605) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         Object var1 = this.field_604.getValue();
         this.field_603.remove();
         this.field_602.field_589.remove(var1);
         this.field_604 = null;
         this.field_605 = false;
      }
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (this.field_604 == null) {
         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
      } else {
         return this.field_604.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (this.field_604 == null) {
         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
      } else {
         return this.field_604.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (this.field_604 == null) {
         throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
      } else if (this.field_602.field_589.containsKey(var1) && this.field_602.field_589.get(var1) != this.field_604.getKey()) {
         throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
      } else {
         return this.field_602.put(this.field_604.getKey(), var1);
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_603 = this.field_602.field_588.entrySet().iterator();
      this.field_604 = null;
      this.field_605 = false;
   }

   public String toString() {
      return this.field_604 != null ? "MapIterator[" + this.method_6() + "=" + this.method_7() + "]" : "MapIterator[]";
   }
}
