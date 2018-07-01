package org.a.a.a.i;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_20;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.i.R
public class class_505 implements class_4, class_20 {
   // $FF: renamed from: a java.util.Set
   Set field_930;
   // $FF: renamed from: b java.util.Iterator
   transient Iterator field_931;
   // $FF: renamed from: c java.util.Map.Entry
   transient Entry field_932;

   public class_505(Set var1) {
      this.field_930 = var1;
      this.method_24();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      return this.method_1606().getKey();
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      return this.method_1606().getValue();
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      return this.method_1606().setValue(var1);
   }

   public boolean hasNext() {
      return this.field_931.hasNext();
   }

   public Object next() {
      this.field_932 = (Entry)this.field_931.next();
      return this.method_6();
   }

   // $FF: renamed from: c () void
   public synchronized void method_24() {
      this.field_931 = this.field_930.iterator();
   }

   public void remove() {
      this.field_931.remove();
      this.field_932 = null;
   }

   // $FF: renamed from: d () java.util.Map.Entry
   protected synchronized Entry method_1606() {
      if (this.field_932 == null) {
         throw new IllegalStateException();
      } else {
         return this.field_932;
      }
   }
}
