package org.a.a.a.j;

import java.util.Collection;
import java.util.Map.Entry;
import org.a.a.a.k.class_377;

// $FF: renamed from: org.a.a.a.j.n
class class_378 extends class_377 {
   // $FF: renamed from: a java.util.Map.Entry
   // $FF: synthetic field
   final Entry field_661;
   // $FF: renamed from: b org.a.a.a.j.m
   // $FF: synthetic field
   final class_483 field_662;

   class_378(class_483 var1, Entry var2) {
      this.field_662 = var1;
      this.field_661 = var2;
   }

   // $FF: renamed from: a () java.lang.Object
   public Object method_56() {
      return this.field_661.getKey();
   }

   // $FF: renamed from: b () int
   public int method_57() {
      return ((Collection)this.field_661.getValue()).size();
   }
}
