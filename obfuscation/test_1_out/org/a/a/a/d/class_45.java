package org.a.a.a.d;

import java.io.Serializable;
import java.util.Comparator;

// $FF: renamed from: org.a.a.a.d.b
public class class_45 implements Serializable, Comparator {
   // $FF: renamed from: b long
   private static final long field_18 = -291439688585137865L;
   // $FF: renamed from: a org.a.a.a.d.b
   public static final class_45 field_19 = new class_45();

   // $FF: renamed from: a () org.a.a.a.d.b
   public static class_45 method_86() {
      return field_19;
   }

   // $FF: renamed from: a (java.lang.Comparable, java.lang.Comparable) int
   public int method_87(Comparable var1, Comparable var2) {
      return var1.compareTo(var2);
   }

   public int hashCode() {
      return "ComparableComparator".hashCode();
   }

   public boolean equals(Object var1) {
      return this == var1 || null != var1 && var1.getClass().equals(this.getClass());
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.method_87((Comparable)var1, (Comparable)var2);
   }
}
