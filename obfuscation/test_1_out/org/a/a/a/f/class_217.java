package org.a.a.a.f;

import java.util.Enumeration;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.f.v
public class class_217 implements Enumeration {
   // $FF: renamed from: a java.util.Iterator
   private Iterator field_303;

   public class_217() {
   }

   public class_217(Iterator var1) {
      this.field_303 = var1;
   }

   public boolean hasMoreElements() {
      return this.field_303.hasNext();
   }

   public Object nextElement() {
      return this.field_303.next();
   }

   // $FF: renamed from: a () java.util.Iterator
   public Iterator method_557() {
      return this.field_303;
   }

   // $FF: renamed from: a (java.util.Iterator) void
   public void method_558(Iterator var1) {
      this.field_303 = var1;
   }
}
