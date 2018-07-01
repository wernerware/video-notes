package org.a.a.a.f;

import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.f.f
public class class_175 implements class_7 {
   // $FF: renamed from: a org.a.a.a.am
   private final class_7 field_230;

   public class_175(class_7 var1) {
      if (var1 == null) {
         throw new NullPointerException("OrderedMapIterator must not be null");
      } else {
         this.field_230 = var1;
      }
   }

   // $FF: renamed from: c () org.a.a.a.am
   protected class_7 method_541() {
      return this.field_230;
   }

   public boolean hasNext() {
      return this.field_230.hasNext();
   }

   public Object next() {
      return this.field_230.next();
   }

   public boolean hasPrevious() {
      return this.field_230.hasPrevious();
   }

   public Object previous() {
      return this.field_230.previous();
   }

   public void remove() {
      this.field_230.remove();
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_6() {
      return this.field_230.a();
   }

   // $FF: renamed from: b () java.lang.Object
   public Object method_7() {
      return this.field_230.b();
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_8(Object var1) {
      return this.field_230.a(var1);
   }
}
