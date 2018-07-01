package org.a.a.a.j;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.class_24;
import org.a.a.a.class_28;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.j.t
public abstract class class_477 implements Serializable, class_24 {
   // $FF: renamed from: a long
   private static final long field_869 = 20150612L;
   // $FF: renamed from: b org.a.a.a.ai
   private final class_24 field_870;

   protected class_477(class_24 var1) {
      if (var1 == null) {
         throw new NullPointerException("MultiValuedMap must not be null.");
      } else {
         this.field_870 = var1;
      }
   }

   // $FF: renamed from: j () org.a.a.a.ai
   protected class_24 method_1572() {
      return this.field_870;
   }

   // $FF: renamed from: a () int
   public int method_33() {
      return this.method_1572().method_33();
   }

   // $FF: renamed from: b () boolean
   public boolean method_34() {
      return this.method_1572().method_34();
   }

   // $FF: renamed from: c (java.lang.Object) boolean
   public boolean method_35(Object var1) {
      return this.method_1572().method_35(var1);
   }

   // $FF: renamed from: d (java.lang.Object) boolean
   public boolean method_36(Object var1) {
      return this.method_1572().method_36(var1);
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   public boolean method_37(Object var1, Object var2) {
      return this.method_1572().method_37(var1, var2);
   }

   // $FF: renamed from: e (java.lang.Object) java.util.Collection
   public Collection method_38(Object var1) {
      return this.method_1572().method_38(var1);
   }

   // $FF: renamed from: f (java.lang.Object) java.util.Collection
   public Collection method_43(Object var1) {
      return this.method_1572().method_43(var1);
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) boolean
   public boolean method_44(Object var1, Object var2) {
      return this.method_1572().method_44(var1, var2);
   }

   // $FF: renamed from: c () void
   public void method_45() {
      this.method_1572().method_45();
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   public boolean method_39(Object var1, Object var2) {
      return this.method_1572().method_39(var1, var2);
   }

   // $FF: renamed from: f () java.util.Set
   public Set method_48() {
      return this.method_1572().method_48();
   }

   // $FF: renamed from: d () java.util.Collection
   public Collection method_46() {
      return this.method_1572().method_46();
   }

   // $FF: renamed from: e () org.a.a.a.af
   public class_28 method_47() {
      return this.method_1572().method_47();
   }

   // $FF: renamed from: g () java.util.Collection
   public Collection method_49() {
      return this.method_1572().method_49();
   }

   // $FF: renamed from: h () java.util.Map
   public Map method_50() {
      return this.method_1572().method_50();
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Iterable) boolean
   public boolean method_40(Object var1, Iterable var2) {
      return this.method_1572().method_40(var1, var2);
   }

   // $FF: renamed from: a (java.util.Map) boolean
   public boolean method_41(Map var1) {
      return this.method_1572().method_41(var1);
   }

   // $FF: renamed from: a (org.a.a.a.ai) boolean
   public boolean method_42(class_24 var1) {
      return this.method_1572().method_42(var1);
   }

   // $FF: renamed from: i () org.a.a.a.Z
   public class_4 method_51() {
      return this.method_1572().method_51();
   }

   public boolean equals(Object var1) {
      return var1 == this ? true : this.method_1572().equals(var1);
   }

   public int hashCode() {
      return this.method_1572().hashCode();
   }

   public String toString() {
      return this.method_1572().toString();
   }
}
