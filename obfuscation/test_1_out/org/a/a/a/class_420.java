package org.a.a.a;

import java.util.AbstractList;

// $FF: renamed from: org.a.a.a.V
final class class_420 extends AbstractList {
   // $FF: renamed from: a java.lang.CharSequence
   private final CharSequence field_730;

   public class_420(CharSequence var1) {
      this.field_730 = var1;
   }

   // $FF: renamed from: a (int) java.lang.Character
   public Character method_1411(int var1) {
      return this.field_730.charAt(var1);
   }

   public int size() {
      return this.field_730.length();
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_1411(var1);
   }
}
