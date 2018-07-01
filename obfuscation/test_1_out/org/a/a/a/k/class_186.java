package org.a.a.a.k;

import java.util.Iterator;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.k.f
public class class_186 extends class_180 {
   // $FF: renamed from: a org.a.a.a.k.a
   protected final class_372 field_245;
   // $FF: renamed from: b java.lang.Object
   protected Object field_246 = null;
   // $FF: renamed from: c boolean
   protected boolean field_247 = false;

   protected class_186(Iterator var1, class_372 var2) {
      super(var1);
      this.field_245 = var2;
   }

   public Object next() {
      this.field_246 = super.next();
      this.field_247 = true;
      return this.field_246;
   }

   public void remove() {
      if (!this.field_247) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         int var1 = this.field_245.method_58(this.field_246);
         super.remove();
         this.field_245.method_61(this.field_246, var1);
         this.field_246 = null;
         this.field_247 = false;
      }
   }
}
