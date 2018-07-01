package org.a.a.a.b;

import java.util.Iterator;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.b.g
public class class_188 extends class_180 {
   // $FF: renamed from: a org.a.a.a.b.b
   protected final class_353 field_251;
   // $FF: renamed from: b java.lang.Object
   protected Object field_252 = null;
   // $FF: renamed from: c boolean
   protected boolean field_253 = false;

   protected class_188(Iterator var1, class_353 var2) {
      super(var1);
      this.field_251 = var2;
   }

   public Object next() {
      this.field_252 = super.next();
      this.field_253 = true;
      return this.field_252;
   }

   public void remove() {
      if (!this.field_253) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         Object var1 = this.field_251.field_588.get(this.field_252);
         super.remove();
         this.field_251.field_589.remove(var1);
         this.field_252 = null;
         this.field_253 = false;
      }
   }
}
