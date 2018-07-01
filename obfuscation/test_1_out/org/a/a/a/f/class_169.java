package org.a.a.a.f;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.a.a.a.h.class_51;

// $FF: renamed from: org.a.a.a.f.k
public class class_169 implements Iterator {
   // $FF: renamed from: a java.util.Comparator
   private Comparator field_215;
   // $FF: renamed from: b java.util.List
   private List field_216;
   // $FF: renamed from: c java.util.List
   private List field_217;
   // $FF: renamed from: d java.util.BitSet
   private BitSet field_218;
   // $FF: renamed from: e int
   private int field_219;

   public class_169() {
      this((Comparator)null, 2);
   }

   public class_169(Comparator var1) {
      this(var1, 2);
   }

   public class_169(Comparator var1, int var2) {
      this.field_215 = null;
      this.field_216 = null;
      this.field_217 = null;
      this.field_218 = null;
      this.field_219 = -1;
      this.field_216 = new ArrayList(var2);
      this.method_528(var1);
   }

   public class_169(Comparator var1, Iterator var2, Iterator var3) {
      this(var1, 2);
      this.method_524(var2);
      this.method_524(var3);
   }

   public class_169(Comparator var1, Iterator[] var2) {
      this(var1, var2.length);
      Iterator[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Iterator var6 = var3[var5];
         this.method_524(var6);
      }

   }

   public class_169(Comparator var1, Collection var2) {
      this(var1, var2.size());
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Iterator var4 = (Iterator)var3.next();
         this.method_524(var4);
      }

   }

   // $FF: renamed from: a (java.util.Iterator) void
   public void method_524(Iterator var1) {
      this.method_533();
      if (var1 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.field_216.add(var1);
      }
   }

   // $FF: renamed from: a (int, java.util.Iterator) void
   public void method_525(int var1, Iterator var2) {
      this.method_533();
      if (var2 == null) {
         throw new NullPointerException("Iterator must not be null");
      } else {
         this.field_216.set(var1, var2);
      }
   }

   // $FF: renamed from: a () java.util.List
   public List method_526() {
      return class_51.method_108(this.field_216);
   }

   // $FF: renamed from: b () java.util.Comparator
   public Comparator method_527() {
      return this.field_215;
   }

   // $FF: renamed from: a (java.util.Comparator) void
   public void method_528(Comparator var1) {
      this.method_533();
      this.field_215 = var1;
   }

   public boolean hasNext() {
      this.method_530();
      return this.method_535(this.field_218) || this.method_536(this.field_216);
   }

   public Object next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         int var1 = this.method_534();
         if (var1 == -1) {
            throw new NoSuchElementException();
         } else {
            Object var2 = this.field_217.get(var1);
            this.method_532(var1);
            this.field_219 = var1;
            return var2;
         }
      }
   }

   public void remove() {
      if (this.field_219 == -1) {
         throw new IllegalStateException("No value can be removed at present");
      } else {
         ((Iterator)this.field_216.get(this.field_219)).remove();
      }
   }

   // $FF: renamed from: c () int
   public int method_529() {
      if (this.field_219 == -1) {
         throw new IllegalStateException("No value has been returned yet");
      } else {
         return this.field_219;
      }
   }

   // $FF: renamed from: d () void
   private void method_530() {
      if (this.field_217 == null) {
         this.field_217 = new ArrayList(this.field_216.size());
         this.field_218 = new BitSet(this.field_216.size());

         for(int var1 = 0; var1 < this.field_216.size(); ++var1) {
            this.field_217.add((Object)null);
            this.field_218.clear(var1);
         }
      }

   }

   // $FF: renamed from: a (int) boolean
   private boolean method_531(int var1) {
      Iterator var2 = (Iterator)this.field_216.get(var1);
      if (var2.hasNext()) {
         this.field_217.set(var1, var2.next());
         this.field_218.set(var1);
         return true;
      } else {
         this.field_217.set(var1, (Object)null);
         this.field_218.clear(var1);
         return false;
      }
   }

   // $FF: renamed from: b (int) void
   private void method_532(int var1) {
      this.field_217.set(var1, (Object)null);
      this.field_218.clear(var1);
   }

   // $FF: renamed from: e () void
   private void method_533() {
      if (this.field_217 != null) {
         throw new IllegalStateException("Can't do that after next or hasNext has been called.");
      }
   }

   // $FF: renamed from: f () int
   private int method_534() {
      int var1 = -1;
      Object var2 = null;

      for(int var3 = 0; var3 < this.field_217.size(); ++var3) {
         if (!this.field_218.get(var3)) {
            this.method_531(var3);
         }

         if (this.field_218.get(var3)) {
            if (var1 == -1) {
               var1 = var3;
               var2 = this.field_217.get(var3);
            } else {
               Object var4 = this.field_217.get(var3);
               if (this.field_215 == null) {
                  throw new NullPointerException("You must invoke setComparator() to set a comparator first.");
               }

               if (this.field_215.compare(var4, var2) < 0) {
                  var2 = var4;
                  var1 = var3;
               }
            }
         }
      }

      return var1;
   }

   // $FF: renamed from: a (java.util.BitSet) boolean
   private boolean method_535(BitSet var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         if (var1.get(var2)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: a (java.util.List) boolean
   private boolean method_536(List var1) {
      Iterator var2 = var1.iterator();

      Iterator var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (Iterator)var2.next();
      } while(!var3.hasNext());

      return true;
   }
}
