package org.a.a.a.f;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.f.r
public class class_222 implements Iterator {
   // $FF: renamed from: a java.util.Collection
   private final Collection field_318;
   // $FF: renamed from: b java.util.Enumeration
   private Enumeration field_319;
   // $FF: renamed from: c java.lang.Object
   private Object field_320;

   public class_222() {
      this((Enumeration)null, (Collection)null);
   }

   public class_222(Enumeration var1) {
      this(var1, (Collection)null);
   }

   public class_222(Enumeration var1, Collection var2) {
      this.field_319 = var1;
      this.field_318 = var2;
      this.field_320 = null;
   }

   public boolean hasNext() {
      return this.field_319.hasMoreElements();
   }

   public Object next() {
      this.field_320 = this.field_319.nextElement();
      return this.field_320;
   }

   public void remove() {
      if (this.field_318 != null) {
         if (this.field_320 != null) {
            this.field_318.remove(this.field_320);
         } else {
            throw new IllegalStateException("next() must have been called for remove() to function");
         }
      } else {
         throw new UnsupportedOperationException("No Collection associated with this Iterator");
      }
   }

   // $FF: renamed from: a () java.util.Enumeration
   public Enumeration method_574() {
      return this.field_319;
   }

   // $FF: renamed from: a (java.util.Enumeration) void
   public void method_575(Enumeration var1) {
      this.field_319 = var1;
   }
}
