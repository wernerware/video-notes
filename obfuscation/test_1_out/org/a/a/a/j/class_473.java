package org.a.a.a.j;

import java.util.List;
import java.util.ListIterator;
import org.a.a.a.class_400;

// $FF: renamed from: org.a.a.a.j.b
class class_473 implements ListIterator {
   // $FF: renamed from: b java.lang.Object
   private final Object field_861;
   // $FF: renamed from: c java.util.List
   private List field_862;
   // $FF: renamed from: d java.util.ListIterator
   private ListIterator field_863;
   // $FF: renamed from: a org.a.a.a.j.a
   // $FF: synthetic field
   final class_470 field_864;

   public class_473(class_470 var1, Object var2) {
      this.field_864 = var1;
      this.field_861 = var2;
      this.field_862 = class_400.method_1145((List)var1.method_1552().get(var2));
      this.field_863 = this.field_862.listIterator();
   }

   public class_473(class_470 var1, Object var2, int var3) {
      this.field_864 = var1;
      this.field_861 = var2;
      this.field_862 = class_400.method_1145((List)var1.method_1552().get(var2));
      this.field_863 = this.field_862.listIterator(var3);
   }

   public void add(Object var1) {
      if (this.field_864.method_1552().get(this.field_861) == null) {
         List var2 = this.field_864.method_1564();
         this.field_864.method_1552().put(this.field_861, var2);
         this.field_862 = var2;
         this.field_863 = var2.listIterator();
      }

      this.field_863.add(var1);
   }

   public boolean hasNext() {
      return this.field_863.hasNext();
   }

   public boolean hasPrevious() {
      return this.field_863.hasPrevious();
   }

   public Object next() {
      return this.field_863.next();
   }

   public int nextIndex() {
      return this.field_863.nextIndex();
   }

   public Object previous() {
      return this.field_863.previous();
   }

   public int previousIndex() {
      return this.field_863.previousIndex();
   }

   public void remove() {
      this.field_863.remove();
      if (this.field_862.isEmpty()) {
         this.field_864.method_1552().remove(this.field_861);
      }

   }

   public void set(Object var1) {
      this.field_863.set(var1);
   }
}
