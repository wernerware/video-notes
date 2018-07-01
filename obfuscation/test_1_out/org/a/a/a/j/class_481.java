package org.a.a.a.j;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.j.p
class class_481 implements class_4 {
   // $FF: renamed from: b java.util.Iterator
   private final Iterator field_879;
   // $FF: renamed from: c java.util.Map.Entry
   private Entry field_880;
   // $FF: renamed from: a org.a.a.a.j.d
   // $FF: synthetic field
   final class_467 field_881;

   public class_481(class_467 var1) {
      this.field_881 = var1;
      this.field_880 = null;
      this.field_879 = var1.method_46().iterator();
   }

   public boolean hasNext() {
      return this.field_879.hasNext();
   }

   public Object next() {
      this.field_880 = (Entry)this.field_879.next();
      return this.field_880.getKey();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      if (this.field_880 == null) {
         throw new IllegalStateException();
      } else {
         return this.field_880.getKey();
      }
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      if (this.field_880 == null) {
         throw new IllegalStateException();
      } else {
         return this.field_880.getValue();
      }
   }

   public void remove() {
      this.field_879.remove();
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      if (this.field_880 == null) {
         throw new IllegalStateException();
      } else {
         return this.field_880.setValue(var1);
      }
   }
}
