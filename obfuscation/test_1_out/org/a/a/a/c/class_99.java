package org.a.a.a.c;

import java.util.Collection;
import java.util.Iterator;
import org.a.a.a.class_29;
import org.a.a.a.class_35;
import org.a.a.a.f.class_461;

// $FF: renamed from: org.a.a.a.c.i
public final class class_99 extends class_48 implements class_29, class_35 {
   // $FF: renamed from: a long
   private static final long field_91 = -7112672385450340330L;

   // $FF: renamed from: a (org.a.a.a.e) org.a.a.a.e
   public static class_35 method_217(class_35 var0) {
      return (class_35)(var0 instanceof class_29 ? var0 : new class_99(var0));
   }

   // $FF: renamed from: b (java.util.Collection) org.a.a.a.e
   public static class_35 method_218(Collection var0) {
      if (var0 == null) {
         throw new NullPointerException("Collection must not be null.");
      } else {
         for(int var1 = 0; var1 < 1000 && !(var0 instanceof class_35); ++var1) {
            if (var0 instanceof class_48) {
               var0 = ((class_48)var0).method_103();
            } else if (var0 instanceof class_100) {
               var0 = ((class_100)var0).method_221();
            }
         }

         if (!(var0 instanceof class_35)) {
            throw new IllegalArgumentException("Collection is not a bounded collection.");
         } else {
            return new class_99((class_35)var0);
         }
      }
   }

   private class_99(class_35 var1) {
      super(var1);
   }

   public Iterator iterator() {
      return class_461.method_1543(this.method_219().iterator());
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   // $FF: renamed from: a () boolean
   public boolean method_71() {
      return this.method_219().method_71();
   }

   // $FF: renamed from: b () int
   public int method_72() {
      return this.method_219().method_72();
   }

   // $FF: renamed from: c () org.a.a.a.e
   protected class_35 method_219() {
      return (class_35)super.method_103();
   }

   // $FF: renamed from: f () java.util.Collection
   // $FF: synthetic method
   protected Collection method_103() {
      return this.method_219();
   }
}
