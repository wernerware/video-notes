package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: org.a.a.a.i.al
class class_244 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.ak
   private final class_131 field_353;
   // $FF: renamed from: b java.util.List
   private final List field_354;
   // $FF: renamed from: c java.util.Set
   private Set field_355;

   public class_244(class_131 var1, List var2) {
      this.field_353 = var1;
      this.field_354 = var2;
   }

   // $FF: renamed from: a () java.util.Set
   private Set method_599() {
      if (this.field_355 == null) {
         this.field_355 = this.field_353.i().entrySet();
      }

      return this.field_355;
   }

   public int size() {
      return this.field_353.size();
   }

   public boolean isEmpty() {
      return this.field_353.isEmpty();
   }

   public boolean contains(Object var1) {
      return this.method_599().contains(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.method_599().containsAll(var1);
   }

   public boolean remove(Object var1) {
      if (!(var1 instanceof Entry)) {
         return false;
      } else if (this.method_599().contains(var1)) {
         Object var2 = ((Entry)var1).getKey();
         this.field_353.remove(var2);
         return true;
      } else {
         return false;
      }
   }

   public void clear() {
      this.field_353.clear();
   }

   public boolean equals(Object var1) {
      return var1 == this ? true : this.method_599().equals(var1);
   }

   public int hashCode() {
      return this.method_599().hashCode();
   }

   public String toString() {
      return this.method_599().toString();
   }

   public Iterator iterator() {
      return new class_179(this.field_353, this.field_354);
   }
}
