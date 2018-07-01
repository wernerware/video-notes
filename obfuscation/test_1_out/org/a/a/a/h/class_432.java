package org.a.a.a.h;

// $FF: renamed from: org.a.a.a.h.d
public class class_432 extends class_431 {
   // $FF: renamed from: f org.a.a.a.h.c
   protected final class_439 field_753;

   protected class_432(class_439 var1, int var2) {
      super(var1.field_771, var2 + var1.field_772);
      this.field_753 = var1;
   }

   public boolean hasNext() {
      return this.nextIndex() < this.field_753.field_773;
   }

   public boolean hasPrevious() {
      return this.previousIndex() >= 0;
   }

   public int nextIndex() {
      return super.nextIndex() - this.field_753.field_772;
   }

   public void add(Object var1) {
      super.add(var1);
      this.field_753.field_774 = this.a.field_760;
      ++this.field_753.field_773;
   }

   public void remove() {
      super.remove();
      this.field_753.field_774 = this.a.field_760;
      --this.field_753.field_773;
   }
}
