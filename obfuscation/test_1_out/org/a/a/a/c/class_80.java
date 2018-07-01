package org.a.a.a.c;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.a.a.a.class_14;
import org.a.a.a.class_21;
import org.a.a.a.i.class_130;

// $FF: renamed from: org.a.a.a.c.d
public class class_80 extends class_48 {
   // $FF: renamed from: a long
   private static final long field_67 = -5512610452568370038L;
   // $FF: renamed from: b org.a.a.a.aI
   private final class_21 field_68;
   // $FF: renamed from: c org.a.a.a.ad
   private final class_14 field_69;
   // $FF: renamed from: d boolean
   private final boolean field_70;

   // $FF: renamed from: a (java.util.Collection, org.a.a.a.aI) org.a.a.a.c.d
   public static class_80 method_161(Collection var0, class_21 var1) {
      return new class_80(var0, var1, class_130.method_326(new HashMap()), true);
   }

   // $FF: renamed from: b (java.util.Collection, org.a.a.a.aI) org.a.a.a.c.d
   public static class_80 method_162(Collection var0, class_21 var1) {
      return new class_80(var0, var1, class_130.method_326(new HashMap()), false);
   }

   public class_80(Collection var1, class_21 var2, class_14 var3, boolean var4) {
      super(var1);
      this.field_68 = var2;
      this.field_69 = var3;
      this.field_70 = var4;
      this.method_165();
   }

   public boolean add(Object var1) {
      boolean var2 = super.add(var1);
      if (var2) {
         this.method_166(var1);
      }

      return var2;
   }

   public boolean addAll(Collection var1) {
      boolean var2 = false;

      Object var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 |= this.add(var4)) {
         var4 = var3.next();
      }

      return var2;
   }

   public void clear() {
      super.clear();
      this.field_69.clear();
   }

   public boolean contains(Object var1) {
      return this.field_69.containsKey(this.field_68.method_25(var1));
   }

   public boolean containsAll(Collection var1) {
      Iterator var2 = var1.iterator();

      Object var3;
      do {
         if (!var2.hasNext()) {
            return true;
         }

         var3 = var2.next();
      } while(this.contains(var3));

      return false;
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_163(Object var1) {
      Collection var2 = (Collection)this.field_69.get(var1);
      return var2 == null ? null : var2.iterator().next();
   }

   // $FF: renamed from: b (java.lang.Object) java.util.Collection
   public Collection method_164(Object var1) {
      return (Collection)this.field_69.get(var1);
   }

   // $FF: renamed from: a () void
   public void method_165() {
      this.field_69.clear();
      Iterator var1 = this.f().iterator();

      while(var1.hasNext()) {
         Object var2 = var1.next();
         this.method_166(var2);
      }

   }

   public boolean remove(Object var1) {
      boolean var2 = super.remove(var1);
      if (var2) {
         this.method_167(var1);
      }

      return var2;
   }

   public boolean removeAll(Collection var1) {
      boolean var2 = false;

      Object var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 |= this.remove(var4)) {
         var4 = var3.next();
      }

      return var2;
   }

   public boolean retainAll(Collection var1) {
      boolean var2 = super.retainAll(var1);
      if (var2) {
         this.method_165();
      }

      return var2;
   }

   // $FF: renamed from: c (java.lang.Object) void
   private void method_166(Object var1) {
      Object var2 = this.field_68.method_25(var1);
      if (this.field_70 && this.field_69.containsKey(var2)) {
         throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
      } else {
         this.field_69.put(var2, var1);
      }
   }

   // $FF: renamed from: d (java.lang.Object) void
   private void method_167(Object var1) {
      this.field_69.remove(this.field_68.method_25(var1));
   }
}
