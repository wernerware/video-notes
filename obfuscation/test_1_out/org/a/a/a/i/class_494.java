package org.a.a.a.i;

import java.util.AbstractSet;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.g
public class class_494 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.i.a
   private final class_151 field_902;

   protected class_494(class_151 var1) {
      this.field_902 = var1;
   }

   public int size() {
      return this.field_902.size();
   }

   public void clear() {
      this.field_902.clear();
   }

   public boolean contains(Object var1) {
      return this.field_902.containsKey(var1);
   }

   public boolean remove(Object var1) {
      boolean var2 = this.field_902.containsKey(var1);
      this.field_902.remove(var1);
      return var2;
   }

   public Iterator iterator() {
      return this.field_902.method_460();
   }
}
