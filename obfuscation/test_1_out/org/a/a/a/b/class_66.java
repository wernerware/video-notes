package org.a.a.a.b;

import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.c.class_48;

// $FF: renamed from: org.a.a.a.b.k
public abstract class class_66 extends class_48 {
   // $FF: renamed from: b long
   private static final long field_49 = 4621510560119690639L;
   // $FF: renamed from: a org.a.a.a.b.b
   protected final class_353 field_50;

   protected class_66(Collection var1, class_353 var2) {
      super(var1);
      this.field_50 = var2;
   }

   public boolean equals(Object var1) {
      return var1 == this || this.f().equals(var1);
   }

   public int hashCode() {
      return this.f().hashCode();
   }

   public boolean removeAll(Collection var1) {
      if (!this.field_50.isEmpty() && !var1.isEmpty()) {
         boolean var2 = false;

         for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 |= this.remove(var3.next())) {
            ;
         }

         return var2;
      } else {
         return false;
      }
   }

   public boolean retainAll(Collection var1) {
      if (this.field_50.isEmpty()) {
         return false;
      } else if (var1.isEmpty()) {
         this.field_50.clear();
         return true;
      } else {
         boolean var2 = false;
         Iterator var3 = this.iterator();

         while(var3.hasNext()) {
            if (!var1.contains(var3.next())) {
               var3.remove();
               var2 = true;
            }
         }

         return var2;
      }
   }

   public void clear() {
      this.field_50.clear();
   }
}
