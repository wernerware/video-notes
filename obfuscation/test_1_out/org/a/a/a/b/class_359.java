package org.a.a.a.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_12;
import org.a.a.a.class_18;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.f.class_164;

// $FF: renamed from: org.a.a.a.b.w
class class_359 implements class_18 {
   // $FF: renamed from: b java.util.Set
   private Set field_606;
   // $FF: renamed from: c java.util.Set
   private Set field_607;
   // $FF: renamed from: d java.util.Set
   private Set field_608;
   // $FF: renamed from: a org.a.a.a.b.s
   // $FF: synthetic field
   final class_362 field_609;

   class_359(class_362 var1) {
      this.field_609 = var1;
   }

   public int size() {
      return this.field_609.size();
   }

   public boolean isEmpty() {
      return this.field_609.isEmpty();
   }

   // $FF: renamed from: e (java.lang.Object) java.lang.Comparable
   public Comparable method_986(Object var1) {
      return this.field_609.method_998(var1);
   }

   // $FF: renamed from: f (java.lang.Object) java.lang.Comparable
   public Comparable method_987(Object var1) {
      return this.field_609.method_995(var1);
   }

   public boolean containsKey(Object var1) {
      return this.field_609.containsValue(var1);
   }

   public boolean containsValue(Object var1) {
      return this.field_609.containsKey(var1);
   }

   // $FF: renamed from: f () java.lang.Comparable
   public Comparable method_988() {
      if (class_362.method_1056(this.field_609) == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return class_362.method_1052(this.field_609, class_362.method_1051(this.field_609)[class_361.field_612.ordinal()], class_361.field_612).method_418();
      }
   }

   // $FF: renamed from: g () java.lang.Comparable
   public Comparable method_989() {
      if (class_362.method_1056(this.field_609) == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return class_362.method_1055(this.field_609, class_362.method_1051(this.field_609)[class_361.field_612.ordinal()], class_361.field_612).method_418();
      }
   }

   // $FF: renamed from: a (java.lang.Comparable) java.lang.Comparable
   public Comparable method_990(Comparable var1) {
      class_362.method_1057(var1);
      class_150 var2 = class_362.method_1053(this.field_609, class_362.method_1058(this.field_609, var1, class_361.field_612), class_361.field_612);
      return var2 == null ? null : var2.method_418();
   }

   // $FF: renamed from: b (java.lang.Comparable) java.lang.Comparable
   public Comparable method_991(Comparable var1) {
      class_362.method_1057(var1);
      class_150 var2 = class_362.method_1054(this.field_609, class_362.method_1058(this.field_609, var1, class_361.field_612), class_361.field_612);
      return var2 == null ? null : var2.method_418();
   }

   // $FF: renamed from: a (java.lang.Comparable, java.lang.Comparable) java.lang.Comparable
   public Comparable method_992(Comparable var1, Comparable var2) {
      Comparable var3 = this.method_986(var1);
      class_362.method_1059(this.field_609, var2, var1);
      return var3;
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.method_992((Comparable)var3.getKey(), (Comparable)var3.getValue());
      }

   }

   // $FF: renamed from: g (java.lang.Object) java.lang.Comparable
   public Comparable method_993(Object var1) {
      return this.field_609.method_999(var1);
   }

   // $FF: renamed from: h (java.lang.Object) java.lang.Comparable
   public Comparable method_994(Object var1) {
      return this.field_609.method_997(var1);
   }

   public void clear() {
      this.field_609.clear();
   }

   public Set keySet() {
      if (this.field_606 == null) {
         this.field_606 = new class_111(this.field_609, class_361.field_612);
      }

      return this.field_606;
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_13() {
      if (this.field_607 == null) {
         this.field_607 = new class_112(this.field_609, class_361.field_612);
      }

      return this.field_607;
   }

   public Set entrySet() {
      if (this.field_608 == null) {
         this.field_608 = new class_110(this.field_609);
      }

      return this.field_608;
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return (class_7)(this.isEmpty() ? class_164.method_513() : new class_147(this.field_609, class_361.field_612));
   }

   // $FF: renamed from: d () org.a.a.a.aj
   public class_18 method_21() {
      return this.field_609;
   }

   public boolean equals(Object var1) {
      return class_362.method_1060(this.field_609, var1, class_361.field_612);
   }

   public int hashCode() {
      return class_362.method_1061(this.field_609, class_361.field_612);
   }

   public String toString() {
      return class_362.method_1062(this.field_609, class_361.field_612);
   }

   // $FF: renamed from: a () org.a.a.a.d
   // $FF: synthetic method
   public class_12 method_12() {
      return this.method_21();
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_11(Object var1) {
      return this.method_994(var1);
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_10(Object var1) {
      return this.method_987(var1);
   }

   // $FF: synthetic method
   public Object put(Object var1, Object var2) {
      return this.method_992((Comparable)var1, (Comparable)var2);
   }

   // $FF: synthetic method
   public Collection values() {
      return this.method_13();
   }

   // $FF: synthetic method
   public Object remove(Object var1) {
      return this.method_993(var1);
   }

   // $FF: synthetic method
   public Object get(Object var1) {
      return this.method_986(var1);
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_19(Object var1) {
      return this.method_991((Comparable)var1);
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_18(Object var1) {
      return this.method_990((Comparable)var1);
   }

   // $FF: synthetic method
   public Object lastKey() {
      return this.method_989();
   }

   // $FF: synthetic method
   public Object firstKey() {
      return this.method_988();
   }
}
