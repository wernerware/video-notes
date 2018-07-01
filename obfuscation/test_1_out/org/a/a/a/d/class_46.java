package org.a.a.a.d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: org.a.a.a.d.c
public class class_46 implements Serializable, Comparator {
   // $FF: renamed from: a long
   private static final long field_20 = -721644942746081630L;
   // $FF: renamed from: b java.util.List
   private final List field_21;
   // $FF: renamed from: c java.util.BitSet
   private BitSet field_22;
   // $FF: renamed from: d boolean
   private boolean field_23;

   public class_46() {
      this(new ArrayList(), new BitSet());
   }

   public class_46(Comparator var1) {
      this(var1, false);
   }

   public class_46(Comparator var1, boolean var2) {
      this.field_22 = null;
      this.field_23 = false;
      this.field_21 = new ArrayList(1);
      this.field_21.add(var1);
      this.field_22 = new BitSet(1);
      if (var2) {
         this.field_22.set(0);
      }

   }

   public class_46(List var1) {
      this(var1, new BitSet(var1.size()));
   }

   public class_46(List var1, BitSet var2) {
      this.field_22 = null;
      this.field_23 = false;
      this.field_21 = var1;
      this.field_22 = var2;
   }

   // $FF: renamed from: a (java.util.Comparator) void
   public void method_88(Comparator var1) {
      this.method_89(var1, false);
   }

   // $FF: renamed from: a (java.util.Comparator, boolean) void
   public void method_89(Comparator var1, boolean var2) {
      this.method_96();
      this.field_21.add(var1);
      if (var2) {
         this.field_22.set(this.field_21.size() - 1);
      }

   }

   // $FF: renamed from: a (int, java.util.Comparator) void
   public void method_90(int var1, Comparator var2) {
      this.method_91(var1, var2, false);
   }

   // $FF: renamed from: a (int, java.util.Comparator, boolean) void
   public void method_91(int var1, Comparator var2, boolean var3) {
      this.method_96();
      this.field_21.set(var1, var2);
      if (var3) {
         this.field_22.set(var1);
      } else {
         this.field_22.clear(var1);
      }

   }

   // $FF: renamed from: a (int) void
   public void method_92(int var1) {
      this.method_96();
      this.field_22.clear(var1);
   }

   // $FF: renamed from: b (int) void
   public void method_93(int var1) {
      this.method_96();
      this.field_22.set(var1);
   }

   // $FF: renamed from: a () int
   public int method_94() {
      return this.field_21.size();
   }

   // $FF: renamed from: b () boolean
   public boolean method_95() {
      return this.field_23;
   }

   // $FF: renamed from: c () void
   private void method_96() {
      if (this.field_23) {
         throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
      }
   }

   // $FF: renamed from: d () void
   private void method_97() {
      if (this.field_21.size() == 0) {
         throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
      }
   }

   public int compare(Object var1, Object var2) {
      if (!this.field_23) {
         this.method_97();
         this.field_23 = true;
      }

      Iterator var3 = this.field_21.iterator();

      for(int var4 = 0; var3.hasNext(); ++var4) {
         Comparator var5 = (Comparator)var3.next();
         int var6 = var5.compare(var1, var2);
         if (var6 != 0) {
            if (this.field_22.get(var4)) {
               if (var6 > 0) {
                  var6 = -1;
               } else {
                  var6 = 1;
               }
            }

            return var6;
         }
      }

      return 0;
   }

   public int hashCode() {
      int var1 = 0;
      if (null != this.field_21) {
         var1 ^= this.field_21.hashCode();
      }

      if (null != this.field_22) {
         var1 ^= this.field_22.hashCode();
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (null == var1) {
         return false;
      } else if (!var1.getClass().equals(this.getClass())) {
         return false;
      } else {
         boolean var10000;
         label48: {
            label32: {
               class_46 var2 = (class_46)var1;
               if (null == this.field_22) {
                  if (null != var2.field_22) {
                     break label32;
                  }
               } else if (!this.field_22.equals(var2.field_22)) {
                  break label32;
               }

               if (null == this.field_21) {
                  if (null == var2.field_21) {
                     break label48;
                  }
               } else if (this.field_21.equals(var2.field_21)) {
                  break label48;
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }
}
