package org.a.a.a.d;

import java.io.Serializable;
import java.util.Comparator;
import org.a.a.a.class_405;

// $FF: renamed from: org.a.a.a.d.g
public class class_42 implements Serializable, Comparator {
   // $FF: renamed from: a long
   private static final long field_9 = -5820772575483504339L;
   // $FF: renamed from: b java.util.Comparator
   private final Comparator field_10;
   // $FF: renamed from: c boolean
   private final boolean field_11;

   public class_42() {
      this(class_405.field_713, true);
   }

   public class_42(Comparator var1) {
      this(var1, true);
   }

   public class_42(boolean var1) {
      this(class_405.field_713, var1);
   }

   public class_42(Comparator var1, boolean var2) {
      this.field_10 = var1;
      this.field_11 = var2;
      if (var1 == null) {
         throw new NullPointerException("null nonNullComparator");
      }
   }

   public int compare(Object var1, Object var2) {
      if (var1 == var2) {
         return 0;
      } else if (var1 == null) {
         return this.field_11 ? 1 : -1;
      } else if (var2 == null) {
         return this.field_11 ? -1 : 1;
      } else {
         return this.field_10.compare(var1, var2);
      }
   }

   public int hashCode() {
      return (this.field_11 ? -1 : 1) * this.field_10.hashCode();
   }

   public boolean equals(Object var1) {
      if (var1 == null) {
         return false;
      } else if (var1 == this) {
         return true;
      } else if (!var1.getClass().equals(this.getClass())) {
         return false;
      } else {
         class_42 var2 = (class_42)var1;
         return this.field_11 == var2.field_11 && this.field_10.equals(var2.field_10);
      }
   }
}
