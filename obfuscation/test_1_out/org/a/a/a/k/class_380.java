package org.a.a.a.k;

import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.class_27;

// $FF: renamed from: org.a.a.a.k.b
public class class_380 implements Iterator {
   // $FF: renamed from: a org.a.a.a.k.a
   protected final class_372 field_664;
   // $FF: renamed from: b java.util.Iterator
   protected final Iterator field_665;
   // $FF: renamed from: c org.a.a.a.ag
   protected class_27 field_666 = null;
   // $FF: renamed from: d boolean
   protected boolean field_667 = false;

   protected class_380(Iterator var1, class_372 var2) {
      this.field_665 = var1;
      this.field_664 = var2;
   }

   public boolean hasNext() {
      return this.field_665.hasNext();
   }

   // $FF: renamed from: a () org.a.a.a.ag
   public class_27 method_1106() {
      this.field_666 = new class_379((Entry)this.field_665.next());
      this.field_667 = true;
      return this.field_666;
   }

   public void remove() {
      if (!this.field_667) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         this.field_665.remove();
         this.field_666 = null;
         this.field_667 = false;
      }
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_1106();
   }
}
