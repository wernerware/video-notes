package org.a.a.a.p;

import java.util.AbstractSet;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.p.g
class class_328 extends AbstractSet {
   // $FF: renamed from: a org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_550;

   private class_328(class_303 var1) {
      this.field_550 = var1;
   }

   public Iterator iterator() {
      return new class_315(this, (class_330)null);
   }

   public int size() {
      return this.field_550.size();
   }

   public boolean contains(Object var1) {
      return this.field_550.containsKey(var1);
   }

   public boolean remove(Object var1) {
      int var2 = this.size();
      this.field_550.remove(var1);
      return var2 != this.size();
   }

   public void clear() {
      this.field_550.clear();
   }

   // $FF: synthetic method
   class_328(class_303 var1, class_330 var2) {
      this(var1);
   }
}
