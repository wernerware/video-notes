package org.a.a.a.i;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import org.a.a.a.f.class_448;

// $FF: renamed from: org.a.a.a.i.aK
class class_170 extends AbstractSet implements Serializable {
   // $FF: renamed from: a long
   private static final long field_220 = -3689524741863047872L;
   // $FF: renamed from: b org.a.a.a.i.aI
   private final class_167 field_221;

   class_170(class_167 var1) {
      this.field_221 = var1;
   }

   public int size() {
      return 1;
   }

   public boolean isEmpty() {
      return false;
   }

   public boolean contains(Object var1) {
      return this.field_221.containsValue(var1);
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Iterator iterator() {
      return new class_448(this.field_221.getValue(), false);
   }
}
