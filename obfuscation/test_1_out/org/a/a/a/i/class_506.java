package org.a.a.a.i;

import java.util.ListIterator;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_7;
import org.a.a.a.f.class_206;

// $FF: renamed from: org.a.a.a.i.M
public class class_506 extends class_505 implements class_7 {
   protected class_506(Set var1) {
      super(var1);
   }

   // $FF: renamed from: c () void
   public synchronized void method_24() {
      super.method_24();
      this.b = new class_206(this.b);
   }

   public boolean hasPrevious() {
      return ((ListIterator)this.b).hasPrevious();
   }

   public Object previous() {
      this.c = (Entry)((ListIterator)this.b).previous();
      return this.a();
   }
}
