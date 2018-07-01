package org.a.a.a.k;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.k.l
public class class_382 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.k.g
   protected final class_370 field_673;

   protected class_382(class_370 var1) {
      this.field_673 = var1;
   }

   public Iterator iterator() {
      return this.field_673.method_1092();
   }

   public boolean contains(Object var1) {
      return this.field_673.contains(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.field_673.containsAll(var1);
   }

   public boolean remove(Object var1) {
      return this.field_673.method_61(var1, this.field_673.method_58(var1)) != 0;
   }

   public int size() {
      return this.field_673.method_1094();
   }

   public void clear() {
      this.field_673.clear();
   }
}
