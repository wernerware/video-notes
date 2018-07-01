package org.a.a.a.f;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.a.a.a.class_6;

// $FF: renamed from: org.a.a.a.f.B
public class class_455 implements class_6 {
   // $FF: renamed from: a java.util.List
   private final List field_829;
   // $FF: renamed from: b java.util.ListIterator
   private ListIterator field_830;

   public class_455(List var1) {
      if (var1 == null) {
         throw new NullPointerException("The list must not be null");
      } else {
         this.field_829 = var1;
         this.method_1537();
      }
   }

   public boolean hasNext() {
      return !this.field_829.isEmpty();
   }

   public Object next() {
      if (this.field_829.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         if (!this.field_830.hasNext()) {
            this.method_1536();
         }

         return this.field_830.next();
      }
   }

   public int nextIndex() {
      if (this.field_829.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         return !this.field_830.hasNext() ? 0 : this.field_830.nextIndex();
      }
   }

   public boolean hasPrevious() {
      return !this.field_829.isEmpty();
   }

   public Object previous() {
      if (this.field_829.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else if (this.field_830.hasPrevious()) {
         return this.field_830.previous();
      } else {
         Object var1;
         for(var1 = null; this.field_830.hasNext(); var1 = this.field_830.next()) {
            ;
         }

         this.field_830.previous();
         return var1;
      }
   }

   public int previousIndex() {
      if (this.field_829.isEmpty()) {
         throw new NoSuchElementException("There are no elements for this iterator to loop on");
      } else {
         return !this.field_830.hasPrevious() ? this.field_829.size() - 1 : this.field_830.previousIndex();
      }
   }

   public void remove() {
      this.field_830.remove();
   }

   public void add(Object var1) {
      this.field_830.add(var1);
   }

   public void set(Object var1) {
      this.field_830.set(var1);
   }

   // $FF: renamed from: c () void
   public void method_1536() {
      this.method_1537();
   }

   // $FF: renamed from: b () void
   private void method_1537() {
      this.field_830 = this.field_829.listIterator();
   }

   // $FF: renamed from: a () int
   public int method_1538() {
      return this.field_829.size();
   }
}
