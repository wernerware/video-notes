package org.a.a.a.f;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.a.a.a.class_20;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.f.q
public class class_230 implements class_4, class_20 {
   // $FF: renamed from: a java.util.Map
   private final Map field_329;
   // $FF: renamed from: b java.util.Iterator
   private Iterator field_330;
   // $FF: renamed from: c java.util.Map.Entry
   private Entry field_331;
   // $FF: renamed from: d boolean
   private boolean field_332 = false;

   public class_230(Map var1) {
      this.field_329 = var1;
      this.field_330 = var1.entrySet().iterator();
   }

   public boolean hasNext() {
      return this.field_330.hasNext();
   }

   public Object next() {
      this.field_331 = (Entry)this.field_330.next();
      this.field_332 = true;
      return this.field_331.getKey();
   }

   public void remove() {
      if (!this.field_332) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         this.field_330.remove();
         this.field_331 = null;
         this.field_332 = false;
      }
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (this.field_331 == null) {
         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
      } else {
         return this.field_331.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (this.field_331 == null) {
         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
      } else {
         return this.field_331.getValue();
      }
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (this.field_331 == null) {
         throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
      } else {
         return this.field_331.setValue(var1);
      }
   }

   // $FF: renamed from: c () void
   public void method_24() {
      this.field_330 = this.field_329.entrySet().iterator();
      this.field_331 = null;
      this.field_332 = false;
   }

   public String toString() {
      return this.field_331 != null ? "MapIterator[" + this.method_6() + "=" + this.method_7() + "]" : "MapIterator[]";
   }
}
