package org.a.a.a.p;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.a.a.a.class_17;

// $FF: renamed from: org.a.a.a.p.a
public abstract class class_302 extends AbstractMap implements Serializable, class_17 {
   // $FF: renamed from: a long
   private static final long field_480 = 5826987063535505652L;
   // $FF: renamed from: b org.a.a.a.p.w
   private final class_333 field_481;

   protected class_302(class_333 var1) {
      if (var1 == null) {
         throw new NullPointerException("keyAnalyzer");
      } else {
         this.field_481 = var1;
      }
   }

   // $FF: renamed from: a () org.a.a.a.p.w
   protected class_333 method_704() {
      return this.field_481;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Trie[").append(this.size()).append("]={\n");
      Iterator var2 = this.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.append("  ").append(var3).append("\n");
      }

      var1.append("}\n");
      return var1.toString();
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   final Object method_705(Object var1) {
      return var1;
   }

   // $FF: renamed from: e (java.lang.Object) int
   final int method_706(Object var1) {
      return var1 == null ? 0 : this.field_481.method_830(var1);
   }

   // $FF: renamed from: b () int
   final int method_707() {
      return this.field_481.method_829();
   }

   // $FF: renamed from: a (java.lang.Object, int, int) boolean
   final boolean method_708(Object var1, int var2, int var3) {
      return var1 == null ? false : this.field_481.method_831(var1, var2, var3);
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) int
   final int method_709(Object var1, Object var2) {
      return this.field_481.method_832(var1, 0, this.method_706(var1), var2, 0, this.method_706(var2));
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   final boolean method_710(Object var1, Object var2) {
      if (var1 == null) {
         return var2 == null;
      } else if (var2 == null) {
         return false;
      } else {
         return this.field_481.compare(var1, var2) == 0;
      }
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) boolean
   static boolean method_711(Object var0, Object var1) {
      return var0 == null ? var1 == null : var0.equals(var1);
   }
}
