package org.a.a.a.d;

import java.io.Serializable;
import java.util.Comparator;
import org.a.a.a.class_405;

// $FF: renamed from: org.a.a.a.d.h
public class class_39 implements Serializable, Comparator {
   // $FF: renamed from: a long
   private static final long field_0 = 2858887242028539265L;
   // $FF: renamed from: b java.util.Comparator
   private final Comparator field_1;

   public class_39() {
      this((Comparator)null);
   }

   public class_39(Comparator var1) {
      this.field_1 = var1 == null ? class_405.field_713 : var1;
   }

   public int compare(Object var1, Object var2) {
      return this.field_1.compare(var2, var1);
   }

   public int hashCode() {
      return "ReverseComparator".hashCode() ^ this.field_1.hashCode();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (null == var1) {
         return false;
      } else if (var1.getClass().equals(this.getClass())) {
         class_39 var2 = (class_39)var1;
         return this.field_1.equals(var2.field_1);
      } else {
         return false;
      }
   }
}
