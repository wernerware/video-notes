package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_11;
import org.a.a.a.class_4;
import org.a.a.a.f.class_163;
import org.a.a.a.f.class_166;

// $FF: renamed from: org.a.a.a.i.a
public class class_151 extends AbstractMap implements class_11 {
   // $FF: renamed from: a java.lang.String
   protected static final String field_168 = "No next() entry in the iteration";
   // $FF: renamed from: b java.lang.String
   protected static final String field_169 = "No previous() entry in the iteration";
   // $FF: renamed from: c java.lang.String
   protected static final String field_170 = "remove() can only be called once after next()";
   // $FF: renamed from: d java.lang.String
   protected static final String field_171 = "getKey() can only be called after next() and before remove()";
   // $FF: renamed from: e java.lang.String
   protected static final String field_172 = "getValue() can only be called after next() and before remove()";
   // $FF: renamed from: f java.lang.String
   protected static final String field_173 = "setValue() can only be called after next() and before remove()";
   // $FF: renamed from: g int
   protected static final int field_174 = 16;
   // $FF: renamed from: h int
   protected static final int field_175 = 12;
   // $FF: renamed from: i float
   protected static final float field_176 = 0.75F;
   // $FF: renamed from: j int
   protected static final int field_177 = 1073741824;
   // $FF: renamed from: k java.lang.Object
   protected static final Object field_178 = new Object();
   // $FF: renamed from: l float
   transient float field_179;
   // $FF: renamed from: m int
   transient int field_180;
   // $FF: renamed from: n org.a.a.a.i.d[]
   transient class_496[] field_181;
   // $FF: renamed from: o int
   transient int field_182;
   // $FF: renamed from: p int
   transient int field_183;
   // $FF: renamed from: q org.a.a.a.i.b
   transient class_499 field_184;
   // $FF: renamed from: r org.a.a.a.i.g
   transient class_494 field_185;
   // $FF: renamed from: s org.a.a.a.i.i
   transient class_492 field_186;

   protected class_151() {
   }

   protected class_151(int var1, float var2, int var3) {
      this.field_179 = var2;
      this.field_181 = new class_496[var1];
      this.field_182 = var3;
      this.method_435();
   }

   protected class_151(int var1) {
      this(var1, 0.75F);
   }

   protected class_151(int var1, float var2) {
      if (var1 < 0) {
         throw new IllegalArgumentException("Initial capacity must be a non negative number");
      } else if (var2 > 0.0F && !Float.isNaN(var2)) {
         this.field_179 = var2;
         var1 = this.method_453(var1);
         this.field_182 = this.method_454(var1, var2);
         this.field_181 = new class_496[var1];
         this.method_435();
      } else {
         throw new IllegalArgumentException("Load factor must be greater than 0");
      }
   }

   protected class_151(Map var1) {
      this(Math.max(2 * var1.size(), 16), 0.75F);
      this.method_436(var1);
   }

   // $FF: renamed from: d () void
   protected void method_435() {
   }

   public Object get(Object var1) {
      var1 = this.method_437(var1);
      int var2 = this.method_438(var1);

      for(class_496 var3 = this.field_181[this.method_441(var2, this.field_181.length)]; var3 != null; var3 = var3.field_903) {
         if (var3.field_904 == var2 && this.method_439(var1, var3.field_905)) {
            return var3.getValue();
         }
      }

      return null;
   }

   public int size() {
      return this.field_180;
   }

   public boolean isEmpty() {
      return this.field_180 == 0;
   }

   public boolean containsKey(Object var1) {
      var1 = this.method_437(var1);
      int var2 = this.method_438(var1);

      for(class_496 var3 = this.field_181[this.method_441(var2, this.field_181.length)]; var3 != null; var3 = var3.field_903) {
         if (var3.field_904 == var2 && this.method_439(var1, var3.field_905)) {
            return true;
         }
      }

      return false;
   }

   public boolean containsValue(Object var1) {
      class_496[] var2;
      int var3;
      int var4;
      class_496 var5;
      class_496 var6;
      if (var1 == null) {
         var2 = this.field_181;
         var3 = var2.length;

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];

            for(var6 = var5; var6 != null; var6 = var6.field_903) {
               if (var6.getValue() == null) {
                  return true;
               }
            }
         }
      } else {
         var2 = this.field_181;
         var3 = var2.length;

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];

            for(var6 = var5; var6 != null; var6 = var6.field_903) {
               if (this.method_440(var1, var6.getValue())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public Object put(Object var1, Object var2) {
      Object var3 = this.method_437(var1);
      int var4 = this.method_438(var3);
      int var5 = this.method_441(var4, this.field_181.length);

      for(class_496 var6 = this.field_181[var5]; var6 != null; var6 = var6.field_903) {
         if (var6.field_904 == var4 && this.method_439(var3, var6.field_905)) {
            Object var7 = var6.getValue();
            this.method_443(var6, var2);
            return var7;
         }
      }

      this.method_445(var5, var4, var1, var2);
      return null;
   }

   public void putAll(Map var1) {
      this.method_436(var1);
   }

   // $FF: renamed from: a (java.util.Map) void
   private void method_436(Map var1) {
      int var2 = var1.size();
      if (var2 != 0) {
         int var3 = (int)((float)(this.field_180 + var2) / this.field_179 + 1.0F);
         this.method_452(this.method_453(var3));
         Iterator var4 = var1.entrySet().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            this.put(var5.getKey(), var5.getValue());
         }

      }
   }

   public Object remove(Object var1) {
      var1 = this.method_437(var1);
      int var2 = this.method_438(var1);
      int var3 = this.method_441(var2, this.field_181.length);
      class_496 var4 = this.field_181[var3];

      for(class_496 var5 = null; var4 != null; var4 = var4.field_903) {
         if (var4.field_904 == var2 && this.method_439(var1, var4.field_905)) {
            Object var6 = var4.getValue();
            this.method_448(var4, var3, var5);
            return var6;
         }

         var5 = var4;
      }

      return null;
   }

   public void clear() {
      ++this.field_183;
      class_496[] var1 = this.field_181;

      for(int var2 = var1.length - 1; var2 >= 0; --var2) {
         var1[var2] = null;
      }

      this.field_180 = 0;
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   protected Object method_437(Object var1) {
      return var1 == null ? field_178 : var1;
   }

   // $FF: renamed from: b (java.lang.Object) int
   protected int method_438(Object var1) {
      int var2 = var1.hashCode();
      var2 += ~(var2 << 9);
      var2 ^= var2 >>> 14;
      var2 += var2 << 4;
      var2 ^= var2 >>> 10;
      return var2;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   protected boolean method_439(Object var1, Object var2) {
      return var1 == var2 || var1.equals(var2);
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   protected boolean method_440(Object var1, Object var2) {
      return var1 == var2 || var1.equals(var2);
   }

   // $FF: renamed from: a (int, int) int
   protected int method_441(int var1, int var2) {
      return var1 & var2 - 1;
   }

   // $FF: renamed from: e (java.lang.Object) org.a.a.a.i.d
   protected class_496 method_442(Object var1) {
      var1 = this.method_437(var1);
      int var2 = this.method_438(var1);

      for(class_496 var3 = this.field_181[this.method_441(var2, this.field_181.length)]; var3 != null; var3 = var3.field_903) {
         if (var3.field_904 == var2 && this.method_439(var1, var3.field_905)) {
            return var3;
         }
      }

      return null;
   }

   // $FF: renamed from: a (org.a.a.a.i.d, java.lang.Object) void
   protected void method_443(class_496 var1, Object var2) {
      var1.setValue(var2);
   }

   // $FF: renamed from: a (org.a.a.a.i.d, int, int, java.lang.Object, java.lang.Object) void
   protected void method_444(class_496 var1, int var2, int var3, Object var4, Object var5) {
      var1.field_903 = this.field_181[var2];
      var1.field_904 = var3;
      var1.field_905 = var4;
      var1.field_906 = var5;
   }

   // $FF: renamed from: a (int, int, java.lang.Object, java.lang.Object) void
   protected void method_445(int var1, int var2, Object var3, Object var4) {
      ++this.field_183;
      class_496 var5 = this.method_446(this.field_181[var1], var2, var3, var4);
      this.method_447(var5, var1);
      ++this.field_180;
      this.method_451();
   }

   // $FF: renamed from: a (org.a.a.a.i.d, int, java.lang.Object, java.lang.Object) org.a.a.a.i.d
   protected class_496 method_446(class_496 var1, int var2, Object var3, Object var4) {
      return new class_496(var1, var2, this.method_437(var3), var4);
   }

   // $FF: renamed from: a (org.a.a.a.i.d, int) void
   protected void method_447(class_496 var1, int var2) {
      this.field_181[var2] = var1;
   }

   // $FF: renamed from: a (org.a.a.a.i.d, int, org.a.a.a.i.d) void
   protected void method_448(class_496 var1, int var2, class_496 var3) {
      ++this.field_183;
      this.method_449(var1, var2, var3);
      --this.field_180;
      this.method_450(var1);
   }

   // $FF: renamed from: b (org.a.a.a.i.d, int, org.a.a.a.i.d) void
   protected void method_449(class_496 var1, int var2, class_496 var3) {
      if (var3 == null) {
         this.field_181[var2] = var1.field_903;
      } else {
         var3.field_903 = var1.field_903;
      }

   }

   // $FF: renamed from: a (org.a.a.a.i.d) void
   protected void method_450(class_496 var1) {
      var1.field_903 = null;
      var1.field_905 = null;
      var1.field_906 = null;
   }

   // $FF: renamed from: f () void
   protected void method_451() {
      if (this.field_180 >= this.field_182) {
         int var1 = this.field_181.length * 2;
         if (var1 <= 1073741824) {
            this.method_452(var1);
         }
      }

   }

   // $FF: renamed from: a (int) void
   protected void method_452(int var1) {
      int var2 = this.field_181.length;
      if (var1 > var2) {
         if (this.field_180 == 0) {
            this.field_182 = this.method_454(var1, this.field_179);
            this.field_181 = new class_496[var1];
         } else {
            class_496[] var3 = this.field_181;
            class_496[] var4 = new class_496[var1];
            ++this.field_183;

            for(int var5 = var2 - 1; var5 >= 0; --var5) {
               class_496 var6 = var3[var5];
               if (var6 != null) {
                  var3[var5] = null;

                  class_496 var7;
                  do {
                     var7 = var6.field_903;
                     int var8 = this.method_441(var6.field_904, var1);
                     var6.field_903 = var4[var8];
                     var4[var8] = var6;
                     var6 = var7;
                  } while(var7 != null);
               }
            }

            this.field_182 = this.method_454(var1, this.field_179);
            this.field_181 = var4;
         }

      }
   }

   // $FF: renamed from: b (int) int
   protected int method_453(int var1) {
      int var2 = 1;
      if (var1 > 1073741824) {
         var2 = 1073741824;
      } else {
         while(true) {
            if (var2 >= var1) {
               if (var2 > 1073741824) {
                  var2 = 1073741824;
               }
               break;
            }

            var2 <<= 1;
         }
      }

      return var2;
   }

   // $FF: renamed from: a (int, float) int
   protected int method_454(int var1, float var2) {
      return (int)((float)var1 * var2);
   }

   // $FF: renamed from: b (org.a.a.a.i.d) org.a.a.a.i.d
   protected class_496 method_455(class_496 var1) {
      return var1.field_903;
   }

   // $FF: renamed from: c (org.a.a.a.i.d) int
   protected int method_456(class_496 var1) {
      return var1.field_904;
   }

   // $FF: renamed from: d (org.a.a.a.i.d) java.lang.Object
   protected Object method_457(class_496 var1) {
      return var1.getKey();
   }

   // $FF: renamed from: e (org.a.a.a.i.d) java.lang.Object
   protected Object method_458(class_496 var1) {
      return var1.getValue();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      return (class_4)(this.field_180 == 0 ? class_163.method_512() : new class_510(this));
   }

   public Set entrySet() {
      if (this.field_184 == null) {
         this.field_184 = new class_499(this);
      }

      return this.field_184;
   }

   // $FF: renamed from: g () java.util.Iterator
   protected Iterator method_459() {
      return (Iterator)(this.size() == 0 ? class_166.method_517() : new class_509(this));
   }

   public Set keySet() {
      if (this.field_185 == null) {
         this.field_185 = new class_494(this);
      }

      return this.field_185;
   }

   // $FF: renamed from: h () java.util.Iterator
   protected Iterator method_460() {
      return (Iterator)(this.size() == 0 ? class_166.method_517() : new class_511(this));
   }

   public Collection values() {
      if (this.field_186 == null) {
         this.field_186 = new class_492(this);
      }

      return this.field_186;
   }

   // $FF: renamed from: i () java.util.Iterator
   protected Iterator method_461() {
      return (Iterator)(this.size() == 0 ? class_166.method_517() : new class_512(this));
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_462(ObjectOutputStream var1) {
      var1.writeFloat(this.field_179);
      var1.writeInt(this.field_181.length);
      var1.writeInt(this.field_180);
      class_4 var2 = this.method_9();

      while(var2.hasNext()) {
         var1.writeObject(var2.next());
         var1.writeObject(var2.method_7());
      }

   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   protected void method_463(ObjectInputStream var1) {
      this.field_179 = var1.readFloat();
      int var2 = var1.readInt();
      int var3 = var1.readInt();
      this.method_435();
      this.field_182 = this.method_454(var2, this.field_179);
      this.field_181 = new class_496[var2];

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = var1.readObject();
         Object var6 = var1.readObject();
         this.put(var5, var6);
      }

   }

   // $FF: renamed from: j () org.a.a.a.i.a
   protected class_151 method_464() {
      try {
         class_151 var1 = (class_151)super.clone();
         var1.field_181 = new class_496[this.field_181.length];
         var1.field_184 = null;
         var1.field_185 = null;
         var1.field_186 = null;
         var1.field_183 = 0;
         var1.field_180 = 0;
         var1.method_435();
         var1.putAll(this);
         return var1;
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   public boolean equals(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      int var1 = 0;

      for(Iterator var2 = this.method_459(); var2.hasNext(); var1 += ((Entry)var2.next()).hashCode()) {
         ;
      }

      return var1;
   }

   public String toString() {
      if (this.size() == 0) {
         return "{}";
      } else {
         StringBuilder var1 = new StringBuilder(32 * this.size());
         var1.append('{');
         class_4 var2 = this.method_9();
         boolean var3 = var2.hasNext();

         while(var3) {
            Object var4 = var2.next();
            Object var5 = var2.method_7();
            var1.append(var4 == this ? "(this Map)" : var4).append('=').append(var5 == this ? "(this Map)" : var5);
            var3 = var2.hasNext();
            if (var3) {
               var1.append(',').append(' ');
            }
         }

         var1.append('}');
         return var1.toString();
      }
   }

   // $FF: synthetic method
   protected Object clone() {
      return this.method_464();
   }
}
