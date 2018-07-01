package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.i.y
public abstract class class_157 extends class_151 {
   // $FF: renamed from: t org.a.a.a.i.G
   private class_491 field_195;
   // $FF: renamed from: u org.a.a.a.i.G
   private class_491 field_196;
   // $FF: renamed from: v boolean
   private boolean field_197;
   // $FF: renamed from: w java.lang.ref.ReferenceQueue
   private transient ReferenceQueue field_198;

   protected class_157() {
   }

   protected class_157(class_491 var1, class_491 var2, int var3, float var4, boolean var5) {
      super(var3, var4);
      this.field_195 = var1;
      this.field_196 = var2;
      this.field_197 = var5;
   }

   // $FF: renamed from: d () void
   protected void method_435() {
      this.field_198 = new ReferenceQueue();
   }

   public int size() {
      this.method_492();
      return super.size();
   }

   public boolean isEmpty() {
      this.method_492();
      return super.isEmpty();
   }

   public boolean containsKey(Object var1) {
      this.method_492();
      class_496 var2 = this.method_442(var1);
      if (var2 == null) {
         return false;
      } else {
         return var2.getValue() != null;
      }
   }

   public boolean containsValue(Object var1) {
      this.method_492();
      return var1 == null ? false : super.containsValue(var1);
   }

   public Object get(Object var1) {
      this.method_492();
      class_496 var2 = this.method_442(var1);
      return var2 == null ? null : var2.getValue();
   }

   public Object put(Object var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException("null keys not allowed");
      } else if (var2 == null) {
         throw new NullPointerException("null values not allowed");
      } else {
         this.method_493();
         return super.put(var1, var2);
      }
   }

   public Object remove(Object var1) {
      if (var1 == null) {
         return null;
      } else {
         this.method_493();
         return super.remove(var1);
      }
   }

   public void clear() {
      super.clear();

      while(this.field_198.poll() != null) {
         ;
      }

   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      return new class_487(this);
   }

   public Set entrySet() {
      if (this.q == null) {
         this.q = new class_500(this);
      }

      return this.q;
   }

   public Set keySet() {
      if (this.r == null) {
         this.r = new class_495(this);
      }

      return this.r;
   }

   public Collection values() {
      if (this.s == null) {
         this.s = new class_493(this);
      }

      return this.s;
   }

   // $FF: renamed from: a () void
   protected void method_492() {
      this.method_494();
   }

   // $FF: renamed from: b () void
   protected void method_493() {
      this.method_494();
   }

   // $FF: renamed from: e () void
   protected void method_494() {
      for(Reference var1 = this.field_198.poll(); var1 != null; var1 = this.field_198.poll()) {
         this.method_495(var1);
      }

   }

   // $FF: renamed from: a (java.lang.ref.Reference) void
   protected void method_495(Reference var1) {
      int var2 = var1.hashCode();
      int var3 = this.a(var2, this.n.length);
      class_496 var4 = null;

      for(class_496 var5 = this.n[var3]; var5 != null; var5 = var5.field_903) {
         if (((class_498)var5).method_1587(var1)) {
            if (var4 == null) {
               this.n[var3] = var5.field_903;
            } else {
               var4.field_903 = var5.field_903;
            }

            --this.m;
            return;
         }

         var4 = var5;
      }

   }

   // $FF: renamed from: e (java.lang.Object) org.a.a.a.i.d
   protected class_496 method_442(Object var1) {
      return var1 == null ? null : super.method_442(var1);
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) int
   protected int method_496(Object var1, Object var2) {
      return (var1 == null ? 0 : var1.hashCode()) ^ (var2 == null ? 0 : var2.hashCode());
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   protected boolean method_439(Object var1, Object var2) {
      var2 = this.field_195 == class_491.field_896 ? var2 : ((Reference)var2).get();
      return var1 == var2 || var1.equals(var2);
   }

   // $FF: renamed from: b (org.a.a.a.i.d, int, java.lang.Object, java.lang.Object) org.a.a.a.i.A
   protected class_498 method_497(class_496 var1, int var2, Object var3, Object var4) {
      return new class_498(this, var1, var2, var3, var4);
   }

   // $FF: renamed from: g () java.util.Iterator
   protected Iterator method_459() {
      return new class_486(this);
   }

   // $FF: renamed from: h () java.util.Iterator
   protected Iterator method_460() {
      return new class_488(this);
   }

   // $FF: renamed from: i () java.util.Iterator
   protected Iterator method_461() {
      return new class_489(this);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_462(ObjectOutputStream var1) {
      var1.writeInt(this.field_195.field_899);
      var1.writeInt(this.field_196.field_899);
      var1.writeBoolean(this.field_197);
      var1.writeFloat(this.l);
      var1.writeInt(this.n.length);
      class_4 var2 = this.method_9();

      while(var2.hasNext()) {
         var1.writeObject(var2.next());
         var1.writeObject(var2.method_7());
      }

      var1.writeObject((Object)null);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   protected void method_463(ObjectInputStream var1) {
      this.field_195 = class_491.method_1585(var1.readInt());
      this.field_196 = class_491.method_1585(var1.readInt());
      this.field_197 = var1.readBoolean();
      this.l = var1.readFloat();
      int var2 = var1.readInt();
      this.method_435();
      this.n = new class_496[var2];

      while(true) {
         Object var3 = var1.readObject();
         if (var3 == null) {
            this.o = this.a(this.n.length, this.l);
            return;
         }

         Object var4 = var1.readObject();
         this.put(var3, var4);
      }
   }

   // $FF: renamed from: a (org.a.a.a.i.G) boolean
   protected boolean method_498(class_491 var1) {
      return this.field_195 == var1;
   }

   // $FF: renamed from: a (org.a.a.a.i.d, int, java.lang.Object, java.lang.Object) org.a.a.a.i.d
   // $FF: synthetic method
   protected class_496 method_446(class_496 var1, int var2, Object var3, Object var4) {
      return this.method_497(var1, var2, var3, var4);
   }

   // $FF: renamed from: a (org.a.a.a.i.y) org.a.a.a.i.G
   // $FF: synthetic method
   static class_491 method_499(class_157 var0) {
      return var0.field_195;
   }

   // $FF: renamed from: b (org.a.a.a.i.y) org.a.a.a.i.G
   // $FF: synthetic method
   static class_491 method_500(class_157 var0) {
      return var0.field_196;
   }

   // $FF: renamed from: c (org.a.a.a.i.y) java.lang.ref.ReferenceQueue
   // $FF: synthetic method
   static ReferenceQueue method_501(class_157 var0) {
      return var0.field_198;
   }

   // $FF: renamed from: d (org.a.a.a.i.y) boolean
   // $FF: synthetic method
   static boolean method_502(class_157 var0) {
      return var0.field_197;
   }
}
