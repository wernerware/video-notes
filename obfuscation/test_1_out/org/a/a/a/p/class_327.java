package org.a.a.a.p;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.p.k
final class class_327 implements Iterator {
   // $FF: renamed from: b org.a.a.a.p.r
   private final class_301 field_547;
   // $FF: renamed from: c int
   private int field_548;
   // $FF: renamed from: a org.a.a.a.p.i
   // $FF: synthetic field
   final class_324 field_549;

   public class_327(class_324 var1, class_301 var2) {
      this.field_549 = var1;
      this.field_548 = 0;
      this.field_547 = var2;
   }

   public boolean hasNext() {
      return this.field_548 == 0;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_819() {
      if (this.field_548 != 0) {
         throw new NoSuchElementException();
      } else {
         ++this.field_548;
         return this.field_547;
      }
   }

   public void remove() {
      if (this.field_548 != 1) {
         throw new IllegalStateException();
      } else {
         ++this.field_548;
         this.field_549.field_545.method_722(this.field_547);
      }
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_819();
   }
}
