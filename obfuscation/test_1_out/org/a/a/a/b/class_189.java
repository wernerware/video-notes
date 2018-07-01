package org.a.a.a.b;

import java.util.Iterator;
import org.a.a.a.f.class_180;

// $FF: renamed from: org.a.a.a.b.j
public class class_189 extends class_180 {
   // $FF: renamed from: a org.a.a.a.b.b
   protected final class_353 field_254;
   // $FF: renamed from: b java.lang.Object
   protected Object field_255 = null;
   // $FF: renamed from: c boolean
   protected boolean field_256 = false;

   protected class_189(Iterator var1, class_353 var2) {
      super(var1);
      this.field_254 = var2;
   }

   public Object next() {
      this.field_255 = super.next();
      this.field_256 = true;
      return this.field_255;
   }

   public void remove() {
      if (!this.field_256) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         super.remove();
         this.field_254.field_589.remove(this.field_255);
         this.field_255 = null;
         this.field_256 = false;
      }
   }
}
