package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.a.a.a.class_13;

// $FF: renamed from: org.a.a.a.i.af
public class class_155 extends class_153 implements Serializable, Cloneable, class_13 {
   // $FF: renamed from: v long
   private static final long field_190 = -612114643488955218L;
   // $FF: renamed from: u int
   protected static final int field_191 = 100;
   // $FF: renamed from: w int
   private transient int field_192;
   // $FF: renamed from: x boolean
   private boolean field_193;

   public class_155() {
      this(100, 0.75F, false);
   }

   public class_155(int var1) {
      this(var1, 0.75F);
   }

   public class_155(int var1, int var2) {
      this(var1, var2, 0.75F);
   }

   public class_155(int var1, boolean var2) {
      this(var1, 0.75F, var2);
   }

   public class_155(int var1, float var2) {
      this(var1, var2, false);
   }

   public class_155(int var1, int var2, float var3) {
      this(var1, var2, var3, false);
   }

   public class_155(int var1, float var2, boolean var3) {
      this(var1, var1, var2, var3);
   }

   public class_155(int var1, int var2, float var3, boolean var4) {
      super(var2, var3);
      if (var1 < 1) {
         throw new IllegalArgumentException("LRUMap max size must be greater than 0");
      } else if (var2 > var1) {
         throw new IllegalArgumentException("LRUMap initial size must not be greather than max size");
      } else {
         this.field_192 = var1;
         this.field_193 = var4;
      }
   }

   public class_155(Map var1) {
      this(var1, false);
   }

   public class_155(Map var1, boolean var2) {
      this(var1.size(), 0.75F, var2);
      this.putAll(var1);
   }

   public Object get(Object var1) {
      return this.method_481(var1, true);
   }

   // $FF: renamed from: a (java.lang.Object, boolean) java.lang.Object
   public Object method_481(Object var1, boolean var2) {
      class_497 var3 = this.f(var1);
      if (var3 == null) {
         return null;
      } else {
         if (var2) {
            this.method_482(var3);
         }

         return var3.getValue();
      }
   }

   // $FF: renamed from: c (org.a.a.a.i.s) void
   protected void method_482(class_497 var1) {
      if (var1.field_908 != this.t) {
         ++this.p;
         if (var1.field_907 == null) {
            throw new IllegalStateException("Entry.before is null. Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
         }

         var1.field_907.field_908 = var1.field_908;
         var1.field_908.field_907 = var1.field_907;
         var1.field_908 = this.t;
         var1.field_907 = this.t.field_907;
         this.t.field_907.field_908 = var1;
         this.t.field_907 = var1;
      } else if (var1 == this.t) {
         throw new IllegalStateException("Can't move header to MRU (please report this to dev@commons.apache.org)");
      }

   }

   // $FF: renamed from: a (org.a.a.a.i.d, java.lang.Object) void
   protected void method_443(class_496 var1, Object var2) {
      this.method_482((class_497)var1);
      var1.setValue(var2);
   }

   // $FF: renamed from: a (int, int, java.lang.Object, java.lang.Object) void
   protected void method_445(int var1, int var2, Object var3, Object var4) {
      if (this.method_14()) {
         class_497 var5 = this.t.field_908;
         boolean var6 = false;
         if (!this.field_193) {
            var6 = this.method_484(var5);
         } else {
            while(var5 != this.t && var5 != null) {
               if (this.method_484(var5)) {
                  var6 = true;
                  break;
               }

               var5 = var5.field_908;
            }

            if (var5 == null) {
               throw new IllegalStateException("Entry.after=null, header.after" + this.t.field_908 + " header.before" + this.t.field_907 + " key=" + var3 + " value=" + var4 + " size=" + this.m + " maxSize=" + this.field_192 + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
            }
         }

         if (var6) {
            if (var5 == null) {
               throw new IllegalStateException("reuse=null, header.after=" + this.t.field_908 + " header.before" + this.t.field_907 + " key=" + var3 + " value=" + var4 + " size=" + this.m + " maxSize=" + this.field_192 + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
            }

            this.method_483(var5, var1, var2, var3, var4);
         } else {
            super.a(var1, var2, var3, var4);
         }
      } else {
         super.a(var1, var2, var3, var4);
      }

   }

   // $FF: renamed from: a (org.a.a.a.i.s, int, int, java.lang.Object, java.lang.Object) void
   protected void method_483(class_497 param1, int param2, int param3, Object param4, Object param5) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (org.a.a.a.i.s) boolean
   protected boolean method_484(class_497 var1) {
      return true;
   }

   // $FF: renamed from: a () boolean
   public boolean method_14() {
      return this.m >= this.field_192;
   }

   // $FF: renamed from: a_ () int
   public int method_15() {
      return this.field_192;
   }

   // $FF: renamed from: k () boolean
   public boolean method_485() {
      return this.field_193;
   }

   // $FF: renamed from: l () org.a.a.a.i.af
   public class_155 method_486() {
      return (class_155)super.j();
   }

   // $FF: renamed from: b (java.io.ObjectOutputStream) void
   private void method_487(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      this.method_462(var1);
   }

   // $FF: renamed from: b (java.io.ObjectInputStream) void
   private void method_488(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.method_463(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_462(ObjectOutputStream var1) {
      var1.writeInt(this.field_192);
      super.a(var1);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   protected void method_463(ObjectInputStream var1) {
      this.field_192 = var1.readInt();
      super.a(var1);
   }

   // $FF: renamed from: j () org.a.a.a.i.a
   // $FF: synthetic method
   public class_151 method_464() {
      return this.method_486();
   }

   // $FF: synthetic method
   public Object clone() {
      return this.method_486();
   }
}
