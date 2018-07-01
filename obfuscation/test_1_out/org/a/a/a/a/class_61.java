package org.a.a.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.class_22;

// $FF: renamed from: org.a.a.a.a.f
public final class class_61 extends class_60 {
   // $FF: renamed from: a long
   private static final long field_44 = -2560033712679053143L;

   // $FF: renamed from: a (org.a.a.a.b) org.a.a.a.b
   public static class_22 method_124(class_22 var0) {
      return new class_61(var0);
   }

   public class_61(class_22 var1) {
      super(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_125(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.e());
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_126(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a((Collection)var1.readObject());
   }

   public boolean containsAll(Collection var1) {
      Iterator var2 = var1.iterator();

      do {
         if (!var2.hasNext()) {
            return true;
         }
      } while(this.contains(var2.next()));

      return false;
   }

   public boolean add(Object var1) {
      return this.method_27(var1, 1);
   }

   public boolean addAll(Collection var1) {
      boolean var2 = false;

      boolean var4;
      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 = var2 || var4) {
         var4 = this.method_27(var3.next(), 1);
      }

      return var2;
   }

   public boolean remove(Object var1) {
      return this.b(var1, 1);
   }

   public boolean removeAll(Collection var1) {
      if (var1 == null) {
         return this.e().removeAll((Collection)null);
      } else {
         boolean var2 = false;

         boolean var5;
         for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 = var2 || var5) {
            Object var4 = var3.next();
            var5 = this.b(var4, this.a(var4));
         }

         return var2;
      }
   }

   public boolean retainAll(Collection var1) {
      if (var1 != null) {
         boolean var2 = false;
         Iterator var3 = this.iterator();

         while(var3.hasNext()) {
            if (!var1.contains(var3.next())) {
               var3.remove();
               var2 = true;
            }
         }

         return var2;
      } else {
         return this.e().retainAll((Collection)null);
      }
   }

   // $FF: renamed from: a (java.lang.Object, int) boolean
   public boolean method_27(Object var1, int var2) {
      this.e().method_27(var1, var2);
      return true;
   }
}
