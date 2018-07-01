package org.a.a.a.p;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;

// $FF: renamed from: org.a.a.a.p.p
abstract class class_318 extends AbstractMap implements SortedMap {
   // $FF: renamed from: a java.util.Set
   private transient volatile Set field_521;
   // $FF: renamed from: b org.a.a.a.p.c
   // $FF: synthetic field
   final class_303 field_522;

   private class_318(class_303 var1) {
      this.field_522 = var1;
   }

   // $FF: renamed from: a () java.util.Set
   protected abstract Set method_751();

   // $FF: renamed from: b () java.lang.Object
   protected abstract Object method_752();

   // $FF: renamed from: d () boolean
   protected abstract boolean method_753();

   // $FF: renamed from: c () java.lang.Object
   protected abstract Object method_754();

   // $FF: renamed from: e () boolean
   protected abstract boolean method_755();

   public Comparator comparator() {
      return this.field_522.comparator();
   }

   public boolean containsKey(Object var1) {
      return !this.method_756(this.field_522.b(var1)) ? false : this.field_522.containsKey(var1);
   }

   public Object remove(Object var1) {
      return !this.method_756(this.field_522.b(var1)) ? null : this.field_522.remove(var1);
   }

   public Object get(Object var1) {
      return !this.method_756(this.field_522.b(var1)) ? null : this.field_522.get(var1);
   }

   public Object put(Object var1, Object var2) {
      if (!this.method_756(var1)) {
         throw new IllegalArgumentException("Key is out of range: " + var1);
      } else {
         return this.field_522.put(var1, var2);
      }
   }

   public Set entrySet() {
      if (this.field_521 == null) {
         this.field_521 = this.method_751();
      }

      return this.field_521;
   }

   public SortedMap subMap(Object var1, Object var2) {
      if (!this.method_757(var1)) {
         throw new IllegalArgumentException("FromKey is out of range: " + var1);
      } else if (!this.method_757(var2)) {
         throw new IllegalArgumentException("ToKey is out of range: " + var2);
      } else {
         return this.method_760(var1, this.method_753(), var2, this.method_755());
      }
   }

   public SortedMap headMap(Object var1) {
      if (!this.method_757(var1)) {
         throw new IllegalArgumentException("ToKey is out of range: " + var1);
      } else {
         return this.method_760(this.method_752(), this.method_753(), var1, this.method_755());
      }
   }

   public SortedMap tailMap(Object var1) {
      if (!this.method_757(var1)) {
         throw new IllegalArgumentException("FromKey is out of range: " + var1);
      } else {
         return this.method_760(var1, this.method_753(), this.method_754(), this.method_755());
      }
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   protected boolean method_756(Object var1) {
      Object var2 = this.method_752();
      Object var3 = this.method_754();
      return (var2 == null || this.method_758(var1, false)) && (var3 == null || this.method_759(var1, false));
   }

   // $FF: renamed from: b (java.lang.Object) boolean
   protected boolean method_757(Object var1) {
      Object var2 = this.method_752();
      Object var3 = this.method_754();
      return (var2 == null || this.method_758(var1, false)) && (var3 == null || this.method_759(var1, true));
   }

   // $FF: renamed from: a (java.lang.Object, boolean) boolean
   protected boolean method_758(Object var1, boolean var2) {
      Object var3 = this.method_752();
      boolean var4 = this.method_753();
      int var5 = this.field_522.a().compare(var1, var3);
      if (!var4 && !var2) {
         return var5 > 0;
      } else {
         return var5 >= 0;
      }
   }

   // $FF: renamed from: b (java.lang.Object, boolean) boolean
   protected boolean method_759(Object var1, boolean var2) {
      Object var3 = this.method_754();
      boolean var4 = this.method_755();
      int var5 = this.field_522.a().compare(var1, var3);
      if (!var4 && !var2) {
         return var5 < 0;
      } else {
         return var5 <= 0;
      }
   }

   // $FF: renamed from: a (java.lang.Object, boolean, java.lang.Object, boolean) java.util.SortedMap
   protected abstract SortedMap method_760(Object var1, boolean var2, Object var3, boolean var4);

   // $FF: synthetic method
   class_318(class_303 var1, class_330 var2) {
      this(var1);
   }
}
