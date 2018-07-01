package org.a.a.a.h;

// $FF: renamed from: org.a.a.a.h.j
public class class_434 extends class_433 {
   // $FF: renamed from: i org.a.a.a.h.c
   protected final class_439 field_757;

   protected class_434(class_439 var1, int var2) {
      super((class_437)var1.field_771, var2 + var1.field_772);
      this.field_757 = var1;
   }

   public boolean hasNext() {
      return this.nextIndex() < this.field_757.field_773;
   }

   public boolean hasPrevious() {
      return this.previousIndex() >= 0;
   }

   public int nextIndex() {
      return super.nextIndex() - this.field_757.field_772;
   }

   public void add(Object var1) {
      super.add(var1);
      this.field_757.field_774 = this.a.field_760;
      ++this.field_757.field_773;
   }

   public void remove() {
      super.remove();
      this.field_757.field_774 = this.a.field_760;
      --this.field_757.field_773;
   }
}
