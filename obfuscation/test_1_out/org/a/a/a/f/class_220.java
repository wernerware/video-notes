package org.a.a.a.f;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// $FF: renamed from: org.a.a.a.f.u
public class class_220 implements Iterator {
   // $FF: renamed from: a java.util.Queue
   private final Queue field_313 = new LinkedList();
   // $FF: renamed from: b java.util.Iterator
   private Iterator field_314 = null;
   // $FF: renamed from: c java.util.Iterator
   private Iterator field_315 = null;
   // $FF: renamed from: d boolean
   private boolean field_316 = false;

   public class_220() {
   }

   public class_220(Iterator var1) {
      this.method_568(var1);
   }

   public class_220(Iterator var1, Iterator var2) {
      this.method_568(var1);
      this.method_568(var2);
   }

   public class_220(Iterator... var1) {
      Iterator[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Iterator var5 = var2[var4];
         this.method_568(var5);
      }

   }

   public class_220(Collection var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Iterator var3 = (Iterator)var2.next();
         this.method_568(var3);
      }

   }

   // $FF: renamed from: a (java.util.Iterator) void
   public void method_568(Iterator var1) {
      this.method_571();
      if (var1 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.field_313.add(var1);
      }
   }

   // $FF: renamed from: a () int
   public int method_569() {
      return this.field_313.size();
   }

   // $FF: renamed from: b () boolean
   public boolean method_570() {
      return this.field_316;
   }

   // $FF: renamed from: d () void
   private void method_571() {
      if (this.field_316) {
         throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
      }
   }

   // $FF: renamed from: e () void
   private void method_572() {
      if (!this.field_316) {
         this.field_316 = true;
      }

   }

   // $FF: renamed from: c () void
   protected void method_573() {
      if (this.field_314 == null) {
         if (this.field_313.isEmpty()) {
            this.field_314 = class_166.method_517();
         } else {
            this.field_314 = (Iterator)this.field_313.remove();
         }

         this.field_315 = this.field_314;
      }

      while(!this.field_314.hasNext() && !this.field_313.isEmpty()) {
         this.field_314 = (Iterator)this.field_313.remove();
      }

   }

   public boolean hasNext() {
      this.method_572();
      this.method_573();
      this.field_315 = this.field_314;
      return this.field_314.hasNext();
   }

   public Object next() {
      this.method_572();
      this.method_573();
      this.field_315 = this.field_314;
      return this.field_314.next();
   }

   public void remove() {
      this.method_572();
      if (this.field_314 == null) {
         this.method_573();
      }

      this.field_315.remove();
   }
}
