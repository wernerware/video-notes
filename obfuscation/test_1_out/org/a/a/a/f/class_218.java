package org.a.a.a.f;

import java.util.Iterator;
import org.a.a.a.class_20;

// $FF: renamed from: org.a.a.a.f.w
public class class_218 implements Iterable {
   // $FF: renamed from: a java.util.Iterator
   private final Iterator field_304;
   // $FF: renamed from: b java.util.Iterator
   private final Iterator field_305;

   // $FF: renamed from: a (java.util.Iterator) java.util.Iterator
   private static Iterator method_559(Iterator var0) {
      return new class_207(var0);
   }

   public class_218(Iterator var1) {
      this(var1, false);
   }

   public class_218(Iterator var1, boolean var2) {
      if (var2 && !(var1 instanceof class_20)) {
         this.field_304 = new class_206(var1);
      } else {
         this.field_304 = var1;
      }

      this.field_305 = method_559(this.field_304);
   }

   public Iterator iterator() {
      if (this.field_304 instanceof class_20) {
         ((class_20)this.field_304).method_24();
      }

      return this.field_305;
   }
}
