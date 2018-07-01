package org.a.a.a.p;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;
import org.a.a.a.class_4;
import org.a.a.a.class_7;

// $FF: renamed from: org.a.a.a.p.c
abstract class class_303 extends class_302 {
   // $FF: renamed from: b long
   private static final long field_482 = 5155253417231339498L;
   // $FF: renamed from: c org.a.a.a.p.r
   private transient class_301 field_483 = new class_301((Object)null, (Object)null, -1);
   // $FF: renamed from: d java.util.Set
   private transient volatile Set field_484;
   // $FF: renamed from: e java.util.Collection
   private transient volatile Collection field_485;
   // $FF: renamed from: f java.util.Set
   private transient volatile Set field_486;
   // $FF: renamed from: g int
   private transient int field_487 = 0;
   // $FF: renamed from: a int
   protected transient int field_488 = 0;

   protected class_303(class_333 var1) {
      super(var1);
   }

   protected class_303(class_333 var1, Map var2) {
      super(var1);
      this.putAll(var2);
   }

   public void clear() {
      this.field_483.a = null;
      this.field_483.field_475 = -1;
      this.field_483.b = null;
      this.field_483.field_476 = null;
      this.field_483.field_477 = this.field_483;
      this.field_483.field_478 = null;
      this.field_483.field_479 = this.field_483;
      this.field_487 = 0;
      this.method_714();
   }

   public int size() {
      return this.field_487;
   }

   // $FF: renamed from: d () void
   void method_712() {
      ++this.field_487;
      this.method_714();
   }

   // $FF: renamed from: f () void
   void method_713() {
      --this.field_487;
      this.method_714();
   }

   // $FF: renamed from: i () void
   private void method_714() {
      ++this.field_488;
   }

   public Object put(Object var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException("Key cannot be null");
      } else {
         int var3 = this.e(var1);
         if (var3 == 0) {
            if (this.field_483.method_701()) {
               this.method_712();
            } else {
               this.method_714();
            }

            return this.field_483.a(var1, var2);
         } else {
            class_301 var4 = this.method_721(var1, var3);
            if (this.b(var1, var4.a)) {
               if (var4.method_701()) {
                  this.method_712();
               } else {
                  this.method_714();
               }

               return var4.a(var1, var2);
            } else {
               int var5 = this.a(var1, var4.a);
               if (!class_333.method_825(var5)) {
                  if (class_333.method_828(var5)) {
                     class_301 var6 = new class_301(var1, var2, var5);
                     this.method_715(var6, var3);
                     this.method_712();
                     return null;
                  }

                  if (class_333.method_827(var5)) {
                     if (this.field_483.method_701()) {
                        this.method_712();
                     } else {
                        this.method_714();
                     }

                     return this.field_483.a(var1, var2);
                  }

                  if (class_333.method_826(var5) && var4 != this.field_483) {
                     this.method_714();
                     return var4.a(var1, var2);
                  }
               }

               throw new IllegalArgumentException("Failed to put: " + var1 + " -> " + var2 + ", " + var5);
            }
         }
      }
   }

   // $FF: renamed from: a (org.a.a.a.p.r, int) org.a.a.a.p.r
   class_301 method_715(class_301 var1, int var2) {
      class_301 var3 = this.field_483.field_477;
      class_301 var4 = this.field_483;

      while(var3.field_475 < var1.field_475 && var3.field_475 > var4.field_475) {
         var4 = var3;
         if (!this.a(var1.a, var3.field_475, var2)) {
            var3 = var3.field_477;
         } else {
            var3 = var3.field_478;
         }
      }

      var1.field_479 = var1;
      if (!this.a(var1.a, var1.field_475, var2)) {
         var1.field_477 = var1;
         var1.field_478 = var3;
      } else {
         var1.field_477 = var3;
         var1.field_478 = var1;
      }

      var1.field_476 = var4;
      if (var3.field_475 >= var1.field_475) {
         var3.field_476 = var1;
      }

      if (var3.field_475 <= var4.field_475) {
         var3.field_479 = var1;
      }

      if (var4 != this.field_483 && this.a(var1.a, var4.field_475, var2)) {
         var4.field_478 = var1;
      } else {
         var4.field_477 = var1;
      }

      return var1;
   }

   public Object get(Object var1) {
      class_301 var2 = this.method_716(var1);
      return var2 != null ? var2.getValue() : null;
   }

   // $FF: renamed from: f (java.lang.Object) org.a.a.a.p.r
   class_301 method_716(Object var1) {
      Object var2 = this.b(var1);
      if (var2 == null) {
         return null;
      } else {
         int var3 = this.e(var2);
         class_301 var4 = this.method_721(var2, var3);
         return !var4.method_701() && this.b(var2, var4.a) ? var4 : null;
      }
   }

   // $FF: renamed from: g (java.lang.Object) java.util.Map.Entry
   public Entry method_717(Object var1) {
      int var2 = this.e(var1);
      class_322 var3 = new class_322((class_330)null);
      return !this.method_720(this.field_483.field_477, -1, var1, var2, var3) ? (Entry)var3.method_789() : null;
   }

   // $FF: renamed from: h (java.lang.Object) java.lang.Object
   public Object method_718(Object var1) {
      Entry var2 = this.method_717(var1);
      return var2 == null ? null : var2.getKey();
   }

   // $FF: renamed from: i (java.lang.Object) java.lang.Object
   public Object method_719(Object var1) {
      Entry var2 = this.method_717(var1);
      return var2 == null ? null : var2.getValue();
   }

   // $FF: renamed from: a (org.a.a.a.p.r, int, java.lang.Object, int, org.a.a.a.p.q) boolean
   private boolean method_720(class_301 var1, int var2, Object var3, int var4, class_322 var5) {
      if (var1.field_475 <= var2) {
         if (!var1.method_701()) {
            var5.method_788(var1);
            return false;
         } else {
            return true;
         }
      } else {
         if (!this.a(var3, var1.field_475, var4)) {
            if (this.method_720(var1.field_477, var1.field_475, var3, var4, var5)) {
               return this.method_720(var1.field_478, var1.field_475, var3, var4, var5);
            }
         } else if (this.method_720(var1.field_478, var1.field_475, var3, var4, var5)) {
            return this.method_720(var1.field_477, var1.field_475, var3, var4, var5);
         }

         return false;
      }
   }

   public boolean containsKey(Object var1) {
      if (var1 == null) {
         return false;
      } else {
         Object var2 = this.b(var1);
         int var3 = this.e(var2);
         class_301 var4 = this.method_721(var2, var3);
         return !var4.method_701() && this.b(var2, var4.a);
      }
   }

   public Set entrySet() {
      if (this.field_486 == null) {
         this.field_486 = new class_331(this, (class_330)null);
      }

      return this.field_486;
   }

   public Set keySet() {
      if (this.field_484 == null) {
         this.field_484 = new class_328(this, (class_330)null);
      }

      return this.field_484;
   }

   public Collection values() {
      if (this.field_485 == null) {
         this.field_485 = new class_335(this, (class_330)null);
      }

      return this.field_485;
   }

   public Object remove(Object var1) {
      if (var1 == null) {
         return null;
      } else {
         Object var2 = this.b(var1);
         int var3 = this.e(var2);
         class_301 var4 = this.field_483.field_477;
         class_301 var5 = this.field_483;

         while(var4.field_475 > var5.field_475) {
            var5 = var4;
            if (!this.a(var2, var4.field_475, var3)) {
               var4 = var4.field_477;
            } else {
               var4 = var4.field_478;
            }
         }

         if (!var4.method_701() && this.b(var2, var4.a)) {
            return this.method_722(var4);
         } else {
            return null;
         }
      }
   }

   // $FF: renamed from: a (java.lang.Object, int) org.a.a.a.p.r
   class_301 method_721(Object var1, int var2) {
      class_301 var3 = this.field_483.field_477;
      class_301 var4 = this.field_483;

      while(var3.field_475 > var4.field_475) {
         var4 = var3;
         if (!this.a(var1, var3.field_475, var2)) {
            var3 = var3.field_477;
         } else {
            var3 = var3.field_478;
         }
      }

      return var3;
   }

   // $FF: renamed from: a (org.a.a.a.p.r) java.lang.Object
   Object method_722(class_301 var1) {
      if (var1 != this.field_483) {
         if (var1.method_702()) {
            this.method_724(var1);
         } else {
            this.method_723(var1);
         }
      }

      this.method_713();
      return var1.a((Object)null, (Object)null);
   }

   // $FF: renamed from: f (org.a.a.a.p.r) void
   private void method_723(class_301 var1) {
      if (var1 == this.field_483) {
         throw new IllegalArgumentException("Cannot delete root Entry!");
      } else if (!var1.method_703()) {
         throw new IllegalArgumentException(var1 + " is not an external Entry!");
      } else {
         class_301 var2 = var1.field_476;
         class_301 var3 = var1.field_477 == var1 ? var1.field_478 : var1.field_477;
         if (var2.field_477 == var1) {
            var2.field_477 = var3;
         } else {
            var2.field_478 = var3;
         }

         if (var3.field_475 > var2.field_475) {
            var3.field_476 = var2;
         } else {
            var3.field_479 = var2;
         }

      }
   }

   // $FF: renamed from: g (org.a.a.a.p.r) void
   private void method_724(class_301 var1) {
      if (var1 == this.field_483) {
         throw new IllegalArgumentException("Cannot delete root Entry!");
      } else if (!var1.method_702()) {
         throw new IllegalArgumentException(var1 + " is not an internal Entry!");
      } else {
         class_301 var2 = var1.field_479;
         var2.field_475 = var1.field_475;
         class_301 var3 = var2.field_476;
         class_301 var4 = var2.field_477 == var1 ? var2.field_478 : var2.field_477;
         if (var2.field_479 == var2 && var2.field_476 != var1) {
            var2.field_479 = var2.field_476;
         }

         if (var3.field_477 == var2) {
            var3.field_477 = var4;
         } else {
            var3.field_478 = var4;
         }

         if (var4.field_475 > var3.field_475) {
            var4.field_476 = var3;
         }

         if (var1.field_477.field_476 == var1) {
            var1.field_477.field_476 = var2;
         }

         if (var1.field_478.field_476 == var1) {
            var1.field_478.field_476 = var2;
         }

         if (var1.field_476.field_477 == var1) {
            var1.field_476.field_477 = var2;
         } else {
            var1.field_476.field_478 = var2;
         }

         var2.field_476 = var1.field_476;
         var2.field_477 = var1.field_477;
         var2.field_478 = var1.field_478;
         if (method_739(var2.field_477, var2)) {
            var2.field_477.field_479 = var2;
         }

         if (method_739(var2.field_478, var2)) {
            var2.field_478.field_479 = var2;
         }

      }
   }

   // $FF: renamed from: b (org.a.a.a.p.r) org.a.a.a.p.r
   class_301 method_725(class_301 var1) {
      return var1 == null ? this.method_727() : this.method_726(var1.field_479, var1, (class_301)null);
   }

   // $FF: renamed from: a (org.a.a.a.p.r, org.a.a.a.p.r, org.a.a.a.p.r) org.a.a.a.p.r
   class_301 method_726(class_301 var1, class_301 var2, class_301 var3) {
      class_301 var4 = var1;
      if (var2 == null || var1 != var2.field_479) {
         while(!var4.field_477.method_701() && var2 != var4.field_477) {
            if (method_739(var4.field_477, var4)) {
               return var4.field_477;
            }

            var4 = var4.field_477;
         }
      }

      if (var4.method_701()) {
         return null;
      } else if (var4.field_478 == null) {
         return null;
      } else if (var2 != var4.field_478) {
         return method_739(var4.field_478, var4) ? var4.field_478 : this.method_726(var4.field_478, var2, var3);
      } else {
         while(var4 == var4.field_476.field_478) {
            if (var4 == var3) {
               return null;
            }

            var4 = var4.field_476;
         }

         if (var4 == var3) {
            return null;
         } else if (var4.field_476.field_478 == null) {
            return null;
         } else if (var2 != var4.field_476.field_478 && method_739(var4.field_476.field_478, var4.field_476)) {
            return var4.field_476.field_478;
         } else if (var4.field_476.field_478 == var4.field_476) {
            return null;
         } else {
            return this.method_726(var4.field_476.field_478, var2, var3);
         }
      }
   }

   // $FF: renamed from: g () org.a.a.a.p.r
   class_301 method_727() {
      return this.isEmpty() ? null : this.method_728(this.field_483);
   }

   // $FF: renamed from: c (org.a.a.a.p.r) org.a.a.a.p.r
   class_301 method_728(class_301 var1) {
      while(true) {
         class_301 var2 = var1.field_477;
         if (var2.method_701()) {
            var2 = var1.field_478;
         }

         if (var2.field_475 <= var1.field_475) {
            return var2;
         }

         var1 = var2;
      }
   }

   public Comparator comparator() {
      return this.a();
   }

   public Object firstKey() {
      if (this.size() == 0) {
         throw new NoSuchElementException();
      } else {
         return this.method_727().getKey();
      }
   }

   public Object lastKey() {
      class_301 var1 = this.method_735();
      if (var1 != null) {
         return var1.getKey();
      } else {
         throw new NoSuchElementException();
      }
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         class_301 var2 = this.method_716(var1);
         if (var2 != null) {
            class_301 var3 = this.method_725(var2);
            return var3 != null ? var3.getKey() : null;
         } else {
            return null;
         }
      }
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         class_301 var2 = this.method_716(var1);
         if (var2 != null) {
            class_301 var3 = this.method_737(var2);
            return var3 != null ? var3.getKey() : null;
         } else {
            return null;
         }
      }
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return new class_312(this, (class_330)null);
   }

   // $FF: renamed from: a (java.lang.Object) java.util.SortedMap
   public SortedMap method_20(Object var1) {
      return this.method_729(var1, 0, this.e(var1));
   }

   // $FF: renamed from: c (java.lang.Object, int, int) java.util.SortedMap
   private SortedMap method_729(Object var1, int var2, int var3) {
      int var4 = var2 + var3;
      if (var4 > this.e(var1)) {
         throw new IllegalArgumentException(var2 + " + " + var3 + " > " + this.e(var1));
      } else {
         return (SortedMap)(var4 == 0 ? this : new class_320(this, var1, var2, var3, (class_330)null));
      }
   }

   public SortedMap headMap(Object var1) {
      return new class_319(this, (Object)null, var1);
   }

   public SortedMap subMap(Object var1, Object var2) {
      return new class_319(this, var1, var2);
   }

   public SortedMap tailMap(Object var1) {
      return new class_319(this, var1, (Object)null);
   }

   // $FF: renamed from: j (java.lang.Object) org.a.a.a.p.r
   class_301 method_730(Object var1) {
      int var2 = this.e(var1);
      if (var2 == 0) {
         if (!this.field_483.method_701()) {
            return this.size() > 1 ? this.method_725(this.field_483) : null;
         } else {
            return this.method_727();
         }
      } else {
         class_301 var3 = this.method_721(var1, var2);
         if (this.b(var1, var3.a)) {
            return this.method_725(var3);
         } else {
            int var4 = this.a(var1, var3.a);
            if (class_333.method_828(var4)) {
               class_301 var5 = new class_301(var1, (Object)null, var4);
               this.method_715(var5, var2);
               this.method_712();
               class_301 var6 = this.method_725(var5);
               this.method_722(var5);
               this.field_488 -= 2;
               return var6;
            } else if (class_333.method_827(var4)) {
               if (!this.field_483.method_701()) {
                  return this.method_727();
               } else {
                  return this.size() > 1 ? this.method_725(this.method_727()) : null;
               }
            } else if (class_333.method_826(var4)) {
               return this.method_725(var3);
            } else {
               throw new IllegalStateException("invalid lookup: " + var1);
            }
         }
      }
   }

   // $FF: renamed from: k (java.lang.Object) org.a.a.a.p.r
   class_301 method_731(Object var1) {
      int var2 = this.e(var1);
      if (var2 == 0) {
         return !this.field_483.method_701() ? this.field_483 : this.method_727();
      } else {
         class_301 var3 = this.method_721(var1, var2);
         if (this.b(var1, var3.a)) {
            return var3;
         } else {
            int var4 = this.a(var1, var3.a);
            if (class_333.method_828(var4)) {
               class_301 var5 = new class_301(var1, (Object)null, var4);
               this.method_715(var5, var2);
               this.method_712();
               class_301 var6 = this.method_725(var5);
               this.method_722(var5);
               this.field_488 -= 2;
               return var6;
            } else if (class_333.method_827(var4)) {
               return !this.field_483.method_701() ? this.field_483 : this.method_727();
            } else if (class_333.method_826(var4)) {
               return var3;
            } else {
               throw new IllegalStateException("invalid lookup: " + var1);
            }
         }
      }
   }

   // $FF: renamed from: l (java.lang.Object) org.a.a.a.p.r
   class_301 method_732(Object var1) {
      int var2 = this.e(var1);
      if (var2 == 0) {
         return null;
      } else {
         class_301 var3 = this.method_721(var1, var2);
         if (this.b(var1, var3.a)) {
            return this.method_737(var3);
         } else {
            int var4 = this.a(var1, var3.a);
            if (class_333.method_828(var4)) {
               class_301 var5 = new class_301(var1, (Object)null, var4);
               this.method_715(var5, var2);
               this.method_712();
               class_301 var6 = this.method_737(var5);
               this.method_722(var5);
               this.field_488 -= 2;
               return var6;
            } else if (class_333.method_827(var4)) {
               return null;
            } else if (class_333.method_826(var4)) {
               return this.method_737(var3);
            } else {
               throw new IllegalStateException("invalid lookup: " + var1);
            }
         }
      }
   }

   // $FF: renamed from: m (java.lang.Object) org.a.a.a.p.r
   class_301 method_733(Object var1) {
      int var2 = this.e(var1);
      if (var2 == 0) {
         return !this.field_483.method_701() ? this.field_483 : null;
      } else {
         class_301 var3 = this.method_721(var1, var2);
         if (this.b(var1, var3.a)) {
            return var3;
         } else {
            int var4 = this.a(var1, var3.a);
            if (class_333.method_828(var4)) {
               class_301 var5 = new class_301(var1, (Object)null, var4);
               this.method_715(var5, var2);
               this.method_712();
               class_301 var6 = this.method_737(var5);
               this.method_722(var5);
               this.field_488 -= 2;
               return var6;
            } else if (class_333.method_827(var4)) {
               return !this.field_483.method_701() ? this.field_483 : null;
            } else if (class_333.method_826(var4)) {
               return var3;
            } else {
               throw new IllegalStateException("invalid lookup: " + var1);
            }
         }
      }
   }

   // $FF: renamed from: b (java.lang.Object, int, int) org.a.a.a.p.r
   class_301 method_734(Object var1, int var2, int var3) {
      class_301 var4 = this.field_483.field_477;
      class_301 var5 = this.field_483;

      while(var4.field_475 > var5.field_475 && var3 > var4.field_475) {
         var5 = var4;
         if (!this.a(var1, var2 + var4.field_475, var2 + var3)) {
            var4 = var4.field_477;
         } else {
            var4 = var4.field_478;
         }
      }

      class_301 var6 = var4.method_701() ? var5 : var4;
      if (var6.method_701()) {
         return null;
      } else {
         int var7 = var2 + var3;
         if (var6 == this.field_483 && this.e(var6.getKey()) < var7) {
            return null;
         } else if (this.a(var1, var7 - 1, var7) != this.a(var6.a, var3 - 1, this.e(var6.a))) {
            return null;
         } else {
            int var8 = this.a().method_832(var1, var2, var3, var6.a, 0, this.e(var6.getKey()));
            return var8 >= 0 && var8 < var3 ? null : var6;
         }
      }
   }

   // $FF: renamed from: h () org.a.a.a.p.r
   class_301 method_735() {
      return this.method_736(this.field_483.field_477);
   }

   // $FF: renamed from: d (org.a.a.a.p.r) org.a.a.a.p.r
   class_301 method_736(class_301 var1) {
      if (var1.field_478 == null) {
         return null;
      } else {
         while(var1.field_478.field_475 > var1.field_475) {
            var1 = var1.field_478;
         }

         return var1.field_478;
      }
   }

   // $FF: renamed from: e (org.a.a.a.p.r) org.a.a.a.p.r
   class_301 method_737(class_301 var1) {
      if (var1.field_479 == null) {
         throw new IllegalArgumentException("must have come from somewhere!");
      } else if (var1.field_479.field_478 == var1) {
         return method_739(var1.field_479.field_477, var1.field_479) ? var1.field_479.field_477 : this.method_736(var1.field_479.field_477);
      } else {
         class_301 var2;
         for(var2 = var1.field_479; var2.field_476 != null && var2 == var2.field_476.field_477; var2 = var2.field_476) {
            ;
         }

         if (var2.field_476 == null) {
            return null;
         } else if (method_739(var2.field_476.field_477, var2.field_476)) {
            if (var2.field_476.field_477 == this.field_483) {
               return this.field_483.method_701() ? null : this.field_483;
            } else {
               return var2.field_476.field_477;
            }
         } else {
            return this.method_736(var2.field_476.field_477);
         }
      }
   }

   // $FF: renamed from: a (org.a.a.a.p.r, org.a.a.a.p.r) org.a.a.a.p.r
   class_301 method_738(class_301 var1, class_301 var2) {
      return var1 == null ? this.method_727() : this.method_726(var1.field_479, var1, var2);
   }

   // $FF: renamed from: b (org.a.a.a.p.r, org.a.a.a.p.r) boolean
   static boolean method_739(class_301 var0, class_301 var1) {
      return var0 != null && var0.field_475 <= var1.field_475 && !var0.method_701();
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_740(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.field_483 = new class_301((Object)null, (Object)null, -1);
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         Object var5 = var1.readObject();
         this.put(var4, var5);
      }

   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_741(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.size());
      Iterator var2 = this.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeObject(var3.getValue());
      }

   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }
}
