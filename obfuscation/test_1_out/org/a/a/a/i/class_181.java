package org.a.a.a.i;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.i.m
class class_181 extends class_180 {
   // $FF: renamed from: b org.a.a.a.i.k
   private final class_134 field_236;
   // $FF: renamed from: a org.a.a.a.i.k
   // $FF: synthetic field
   final class_134 field_237;

   protected class_181(class_134 var1, Iterator var2, class_134 var3) {
      super(var2);
      this.field_237 = var1;
      this.field_236 = var3;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_544() {
      Entry var1 = (Entry)this.b().next();
      return new class_209(this.field_237, var1, this.field_236);
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_544();
   }
}
