package org.a.a.a.i;

import java.util.AbstractCollection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.i.i
public class class_492 extends AbstractCollection {
   // $FF: renamed from: a org.a.a.a.i.a
   private final class_151 field_901;

   protected class_492(class_151 var1) {
      this.field_901 = var1;
   }

   public int size() {
      return this.field_901.size();
   }

   public void clear() {
      this.field_901.clear();
   }

   public boolean contains(Object var1) {
      return this.field_901.containsValue(var1);
   }

   public Iterator iterator() {
      return this.field_901.method_461();
   }
}
