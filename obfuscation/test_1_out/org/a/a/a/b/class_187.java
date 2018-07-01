package org.a.a.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.b.e
public class class_187 extends class_180 {
   // $FF: renamed from: a org.a.a.a.b.b
   protected final class_353 field_248;
   // $FF: renamed from: b java.util.Map.Entry
   protected Entry field_249 = null;
   // $FF: renamed from: c boolean
   protected boolean field_250 = false;

   protected class_187(Iterator var1, class_353 var2) {
      super(var1);
      this.field_248 = var2;
   }

   // $FF: renamed from: a () java.util.Map.Entry
   public Entry method_547() {
      this.field_249 = new class_210((Entry)super.next(), this.field_248);
      this.field_250 = true;
      return this.field_249;
   }

   public void remove() {
      if (!this.field_250) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         Object var1 = this.field_249.getValue();
         super.remove();
         this.field_248.field_589.remove(var1);
         this.field_249 = null;
         this.field_250 = false;
      }
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_547();
   }
}
