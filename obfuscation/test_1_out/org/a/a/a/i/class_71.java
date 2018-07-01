package org.a.a.a.i;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.n.class_70;

// $FF: renamed from: org.a.a.a.i.l
class class_71 extends class_70 {
   // $FF: renamed from: b long
   private static final long field_55 = 4354731610923110264L;
   // $FF: renamed from: c org.a.a.a.i.k
   private final class_134 field_56;
   // $FF: renamed from: a org.a.a.a.i.k
   // $FF: synthetic field
   final class_134 field_57;

   protected class_71(class_134 var1, Set var2, class_134 var3) {
      super(var2);
      this.field_57 = var1;
      this.field_56 = var3;
   }

   public Iterator iterator() {
      return new class_181(this.field_57, this.c().iterator(), this.field_56);
   }

   public Object[] toArray() {
      Object[] var1 = this.c().toArray();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = new class_209(this.field_57, (Entry)var1[var2], this.field_56);
      }

      return var1;
   }

   public Object[] toArray(Object[] var1) {
      Object[] var2 = var1;
      if (var1.length > 0) {
         var2 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), 0));
      }

      var2 = this.c().toArray(var2);

      for(int var3 = 0; var3 < var2.length; ++var3) {
         var2[var3] = new class_209(this.field_57, (Entry)var2[var3], this.field_56);
      }

      if (var2.length > var1.length) {
         return (Object[])var2;
      } else {
         System.arraycopy(var2, 0, var1, 0, var2.length);
         if (var1.length > var2.length) {
            var1[var2.length] = null;
         }

         return var1;
      }
   }
}
