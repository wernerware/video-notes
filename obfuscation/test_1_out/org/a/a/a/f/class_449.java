package org.a.a.a.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

// $FF: renamed from: org.a.a.a.f.H
public class class_449 implements Iterator {
   // $FF: renamed from: a int[]
   private int[] field_807;
   // $FF: renamed from: b java.util.Map
   private Map field_808;
   // $FF: renamed from: c boolean[]
   private boolean[] field_809;
   // $FF: renamed from: d java.util.List
   private List field_810;

   public class_449(Collection var1) {
      if (var1 == null) {
         throw new NullPointerException("The collection must not be null");
      } else {
         this.field_807 = new int[var1.size()];
         this.field_809 = new boolean[var1.size()];
         Arrays.fill(this.field_809, false);
         int var2 = 1;
         this.field_808 = new HashMap();

         for(Iterator var3 = var1.iterator(); var3.hasNext(); this.field_807[var2 - 1] = var2++) {
            Object var4 = var3.next();
            this.field_808.put(var2, var4);
         }

         this.field_810 = new ArrayList(var1);
      }
   }

   public boolean hasNext() {
      return this.field_810 != null;
   }

   // $FF: renamed from: a () java.util.List
   public List method_1523() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         int var1 = -1;
         int var2 = -1;

         int var3;
         for(var3 = 0; var3 < this.field_807.length; ++var3) {
            if ((this.field_809[var3] && var3 < this.field_807.length - 1 && this.field_807[var3] > this.field_807[var3 + 1] || !this.field_809[var3] && var3 > 0 && this.field_807[var3] > this.field_807[var3 - 1]) && this.field_807[var3] > var2) {
               var2 = this.field_807[var3];
               var1 = var3;
            }
         }

         if (var2 == -1) {
            List var8 = this.field_810;
            this.field_810 = null;
            return var8;
         } else {
            var3 = this.field_809[var1] ? 1 : -1;
            int var4 = this.field_807[var1];
            this.field_807[var1] = this.field_807[var1 + var3];
            this.field_807[var1 + var3] = var4;
            boolean var5 = this.field_809[var1];
            this.field_809[var1] = this.field_809[var1 + var3];
            this.field_809[var1 + var3] = var5;
            ArrayList var6 = new ArrayList();

            for(int var7 = 0; var7 < this.field_807.length; ++var7) {
               if (this.field_807[var7] > var2) {
                  this.field_809[var7] = !this.field_809[var7];
               }

               var6.add(this.field_808.get(this.field_807[var7]));
            }

            List var9 = this.field_810;
            this.field_810 = var6;
            return var9;
         }
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() is not supported");
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_1523();
   }
}
