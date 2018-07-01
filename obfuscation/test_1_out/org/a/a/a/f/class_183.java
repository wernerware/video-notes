package org.a.a.a.f;

import java.util.Iterator;

// $FF: renamed from: org.a.a.a.f.M
public class class_183 extends class_180 {
   // $FF: renamed from: a long
   private final long field_239;
   // $FF: renamed from: b long
   private long field_240;

   public class_183(Iterator var1, long var2) {
      super(var1);
      if (var2 < 0L) {
         throw new IllegalArgumentException("Offset parameter must not be negative.");
      } else {
         this.field_239 = var2;
         this.field_240 = 0L;
         this.method_546();
      }
   }

   // $FF: renamed from: a () void
   private void method_546() {
      while(this.field_240 < this.field_239 && this.hasNext()) {
         this.next();
      }

   }

   public Object next() {
      Object var1 = super.next();
      ++this.field_240;
      return var1;
   }

   public void remove() {
      if (this.field_240 <= this.field_239) {
         throw new IllegalStateException("remove() can not be called before calling next()");
      } else {
         super.remove();
      }
   }
}
