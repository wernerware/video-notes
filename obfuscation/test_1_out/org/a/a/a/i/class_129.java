package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.a.a.a.class_4;
import org.a.a.a.g.class_445;

// $FF: renamed from: org.a.a.a.i.at
public class class_129 extends class_116 implements Serializable, Cloneable {
   // $FF: renamed from: b long
   private static final long field_130 = -1788199231038721040L;

   // $FF: renamed from: a (org.a.a.a.i.a) org.a.a.a.i.at
   public static class_129 method_291(class_151 var0) {
      if (var0 == null) {
         throw new NullPointerException("Map must not be null");
      } else if (var0.size() > 0) {
         throw new IllegalArgumentException("Map must be empty");
      } else {
         return new class_129(var0);
      }
   }

   public class_129() {
      this(new class_156());
   }

   protected class_129(class_151 var1) {
      super(var1);
      this.a = var1;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_292(Object var1, Object var2) {
      int var3 = this.method_296(var1, var2);

      for(class_496 var4 = this.method_323().field_181[this.method_323().method_441(var3, this.method_323().field_181.length)]; var4 != null; var4 = var4.field_903) {
         if (var4.field_904 == var3 && this.method_297(var4, var1, var2)) {
            return var4.getValue();
         }
      }

      return null;
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   public boolean method_293(Object var1, Object var2) {
      int var3 = this.method_296(var1, var2);

      for(class_496 var4 = this.method_323().field_181[this.method_323().method_441(var3, this.method_323().field_181.length)]; var4 != null; var4 = var4.field_903) {
         if (var4.field_904 == var3 && this.method_297(var4, var1, var2)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_294(Object var1, Object var2, Object var3) {
      int var4 = this.method_296(var1, var2);
      int var5 = this.method_323().method_441(var4, this.method_323().field_181.length);

      for(class_496 var6 = this.method_323().field_181[var5]; var6 != null; var6 = var6.field_903) {
         if (var6.field_904 == var4 && this.method_297(var6, var1, var2)) {
            Object var7 = var6.getValue();
            this.method_323().method_443(var6, var3);
            return var7;
         }
      }

      this.method_323().method_445(var5, var4, new class_445(var1, var2), var3);
      return null;
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_295(Object var1, Object var2) {
      int var3 = this.method_296(var1, var2);
      int var4 = this.method_323().method_441(var3, this.method_323().field_181.length);
      class_496 var5 = this.method_323().field_181[var4];

      for(class_496 var6 = null; var5 != null; var5 = var5.field_903) {
         if (var5.field_904 == var3 && this.method_297(var5, var1, var2)) {
            Object var7 = var5.getValue();
            this.method_323().method_448(var5, var4, var6);
            return var7;
         }

         var6 = var5;
      }

      return null;
   }

   // $FF: renamed from: d (java.lang.Object, java.lang.Object) int
   protected int method_296(Object var1, Object var2) {
      int var3 = 0;
      if (var1 != null) {
         var3 ^= var1.hashCode();
      }

      if (var2 != null) {
         var3 ^= var2.hashCode();
      }

      var3 += ~(var3 << 9);
      var3 ^= var3 >>> 14;
      var3 += var3 << 4;
      var3 ^= var3 >>> 10;
      return var3;
   }

   // $FF: renamed from: a (org.a.a.a.i.d, java.lang.Object, java.lang.Object) boolean
   protected boolean method_297(class_496 var1, Object var2, Object var3) {
      class_445 var4 = (class_445)var1.getKey();
      return var4.method_1518() == 2 && (var2 == var4.method_1517(0) || var2 != null && var2.equals(var4.method_1517(0))) && (var3 == var4.method_1517(1) || var3 != null && var3.equals(var4.method_1517(1)));
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_298(Object var1, Object var2, Object var3) {
      int var4 = this.method_302(var1, var2, var3);

      for(class_496 var5 = this.method_323().field_181[this.method_323().method_441(var4, this.method_323().field_181.length)]; var5 != null; var5 = var5.field_903) {
         if (var5.field_904 == var4 && this.method_303(var5, var1, var2, var3)) {
            return var5.getValue();
         }
      }

      return null;
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object, java.lang.Object) boolean
   public boolean method_299(Object var1, Object var2, Object var3) {
      int var4 = this.method_302(var1, var2, var3);

      for(class_496 var5 = this.method_323().field_181[this.method_323().method_441(var4, this.method_323().field_181.length)]; var5 != null; var5 = var5.field_903) {
         if (var5.field_904 == var4 && this.method_303(var5, var1, var2, var3)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_300(Object var1, Object var2, Object var3, Object var4) {
      int var5 = this.method_302(var1, var2, var3);
      int var6 = this.method_323().method_441(var5, this.method_323().field_181.length);

      for(class_496 var7 = this.method_323().field_181[var6]; var7 != null; var7 = var7.field_903) {
         if (var7.field_904 == var5 && this.method_303(var7, var1, var2, var3)) {
            Object var8 = var7.getValue();
            this.method_323().method_443(var7, var4);
            return var8;
         }
      }

      this.method_323().method_445(var6, var5, new class_445(var1, var2, var3), var4);
      return null;
   }

   // $FF: renamed from: d (java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_301(Object var1, Object var2, Object var3) {
      int var4 = this.method_302(var1, var2, var3);
      int var5 = this.method_323().method_441(var4, this.method_323().field_181.length);
      class_496 var6 = this.method_323().field_181[var5];

      for(class_496 var7 = null; var6 != null; var6 = var6.field_903) {
         if (var6.field_904 == var4 && this.method_303(var6, var1, var2, var3)) {
            Object var8 = var6.getValue();
            this.method_323().method_448(var6, var5, var7);
            return var8;
         }

         var7 = var6;
      }

      return null;
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object, java.lang.Object) int
   protected int method_302(Object var1, Object var2, Object var3) {
      int var4 = 0;
      if (var1 != null) {
         var4 ^= var1.hashCode();
      }

      if (var2 != null) {
         var4 ^= var2.hashCode();
      }

      if (var3 != null) {
         var4 ^= var3.hashCode();
      }

      var4 += ~(var4 << 9);
      var4 ^= var4 >>> 14;
      var4 += var4 << 4;
      var4 ^= var4 >>> 10;
      return var4;
   }

   // $FF: renamed from: a (org.a.a.a.i.d, java.lang.Object, java.lang.Object, java.lang.Object) boolean
   protected boolean method_303(class_496 var1, Object var2, Object var3, Object var4) {
      class_445 var5 = (class_445)var1.getKey();
      return var5.method_1518() == 3 && (var2 == var5.method_1517(0) || var2 != null && var2.equals(var5.method_1517(0))) && (var3 == var5.method_1517(1) || var3 != null && var3.equals(var5.method_1517(1))) && (var4 == var5.method_1517(2) || var4 != null && var4.equals(var5.method_1517(2)));
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_304(Object var1, Object var2, Object var3, Object var4) {
      int var5 = this.method_308(var1, var2, var3, var4);

      for(class_496 var6 = this.method_323().field_181[this.method_323().method_441(var5, this.method_323().field_181.length)]; var6 != null; var6 = var6.field_903) {
         if (var6.field_904 == var5 && this.method_309(var6, var1, var2, var3, var4)) {
            return var6.getValue();
         }
      }

      return null;
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) boolean
   public boolean method_305(Object var1, Object var2, Object var3, Object var4) {
      int var5 = this.method_308(var1, var2, var3, var4);

      for(class_496 var6 = this.method_323().field_181[this.method_323().method_441(var5, this.method_323().field_181.length)]; var6 != null; var6 = var6.field_903) {
         if (var6.field_904 == var5 && this.method_309(var6, var1, var2, var3, var4)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_306(Object var1, Object var2, Object var3, Object var4, Object var5) {
      int var6 = this.method_308(var1, var2, var3, var4);
      int var7 = this.method_323().method_441(var6, this.method_323().field_181.length);

      for(class_496 var8 = this.method_323().field_181[var7]; var8 != null; var8 = var8.field_903) {
         if (var8.field_904 == var6 && this.method_309(var8, var1, var2, var3, var4)) {
            Object var9 = var8.getValue();
            this.method_323().method_443(var8, var5);
            return var9;
         }
      }

      this.method_323().method_445(var7, var6, new class_445(var1, var2, var3, var4), var5);
      return null;
   }

   // $FF: renamed from: d (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_307(Object var1, Object var2, Object var3, Object var4) {
      int var5 = this.method_308(var1, var2, var3, var4);
      int var6 = this.method_323().method_441(var5, this.method_323().field_181.length);
      class_496 var7 = this.method_323().field_181[var6];

      for(class_496 var8 = null; var7 != null; var7 = var7.field_903) {
         if (var7.field_904 == var5 && this.method_309(var7, var1, var2, var3, var4)) {
            Object var9 = var7.getValue();
            this.method_323().method_448(var7, var6, var8);
            return var9;
         }

         var8 = var7;
      }

      return null;
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) int
   protected int method_308(Object var1, Object var2, Object var3, Object var4) {
      int var5 = 0;
      if (var1 != null) {
         var5 ^= var1.hashCode();
      }

      if (var2 != null) {
         var5 ^= var2.hashCode();
      }

      if (var3 != null) {
         var5 ^= var3.hashCode();
      }

      if (var4 != null) {
         var5 ^= var4.hashCode();
      }

      var5 += ~(var5 << 9);
      var5 ^= var5 >>> 14;
      var5 += var5 << 4;
      var5 ^= var5 >>> 10;
      return var5;
   }

   // $FF: renamed from: a (org.a.a.a.i.d, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) boolean
   protected boolean method_309(class_496 var1, Object var2, Object var3, Object var4, Object var5) {
      class_445 var6 = (class_445)var1.getKey();
      return var6.method_1518() == 4 && (var2 == var6.method_1517(0) || var2 != null && var2.equals(var6.method_1517(0))) && (var3 == var6.method_1517(1) || var3 != null && var3.equals(var6.method_1517(1))) && (var4 == var6.method_1517(2) || var4 != null && var4.equals(var6.method_1517(2))) && (var5 == var6.method_1517(3) || var5 != null && var5.equals(var6.method_1517(3)));
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_310(Object var1, Object var2, Object var3, Object var4, Object var5) {
      int var6 = this.method_314(var1, var2, var3, var4, var5);

      for(class_496 var7 = this.method_323().field_181[this.method_323().method_441(var6, this.method_323().field_181.length)]; var7 != null; var7 = var7.field_903) {
         if (var7.field_904 == var6 && this.method_315(var7, var1, var2, var3, var4, var5)) {
            return var7.getValue();
         }
      }

      return null;
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) boolean
   public boolean method_311(Object var1, Object var2, Object var3, Object var4, Object var5) {
      int var6 = this.method_314(var1, var2, var3, var4, var5);

      for(class_496 var7 = this.method_323().field_181[this.method_323().method_441(var6, this.method_323().field_181.length)]; var7 != null; var7 = var7.field_903) {
         if (var7.field_904 == var6 && this.method_315(var7, var1, var2, var3, var4, var5)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_312(Object var1, Object var2, Object var3, Object var4, Object var5, Object var6) {
      int var7 = this.method_314(var1, var2, var3, var4, var5);
      int var8 = this.method_323().method_441(var7, this.method_323().field_181.length);

      for(class_496 var9 = this.method_323().field_181[var8]; var9 != null; var9 = var9.field_903) {
         if (var9.field_904 == var7 && this.method_315(var9, var1, var2, var3, var4, var5)) {
            Object var10 = var9.getValue();
            this.method_323().method_443(var9, var6);
            return var10;
         }
      }

      this.method_323().method_445(var8, var7, new class_445(var1, var2, var3, var4, var5), var6);
      return null;
   }

   // $FF: renamed from: d (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) java.lang.Object
   public Object method_313(Object var1, Object var2, Object var3, Object var4, Object var5) {
      int var6 = this.method_314(var1, var2, var3, var4, var5);
      int var7 = this.method_323().method_441(var6, this.method_323().field_181.length);
      class_496 var8 = this.method_323().field_181[var7];

      for(class_496 var9 = null; var8 != null; var8 = var8.field_903) {
         if (var8.field_904 == var6 && this.method_315(var8, var1, var2, var3, var4, var5)) {
            Object var10 = var8.getValue();
            this.method_323().method_448(var8, var7, var9);
            return var10;
         }

         var9 = var8;
      }

      return null;
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) int
   protected int method_314(Object var1, Object var2, Object var3, Object var4, Object var5) {
      int var6 = 0;
      if (var1 != null) {
         var6 ^= var1.hashCode();
      }

      if (var2 != null) {
         var6 ^= var2.hashCode();
      }

      if (var3 != null) {
         var6 ^= var3.hashCode();
      }

      if (var4 != null) {
         var6 ^= var4.hashCode();
      }

      if (var5 != null) {
         var6 ^= var5.hashCode();
      }

      var6 += ~(var6 << 9);
      var6 ^= var6 >>> 14;
      var6 += var6 << 4;
      var6 ^= var6 >>> 10;
      return var6;
   }

   // $FF: renamed from: a (org.a.a.a.i.d, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) boolean
   protected boolean method_315(class_496 var1, Object var2, Object var3, Object var4, Object var5, Object var6) {
      class_445 var7 = (class_445)var1.getKey();
      return var7.method_1518() == 5 && (var2 == var7.method_1517(0) || var2 != null && var2.equals(var7.method_1517(0))) && (var3 == var7.method_1517(1) || var3 != null && var3.equals(var7.method_1517(1))) && (var4 == var7.method_1517(2) || var4 != null && var4.equals(var7.method_1517(2))) && (var5 == var7.method_1517(3) || var5 != null && var5.equals(var7.method_1517(3))) && (var6 == var7.method_1517(4) || var6 != null && var6.equals(var7.method_1517(4)));
   }

   // $FF: renamed from: a (java.lang.Object) boolean
   public boolean method_316(Object var1) {
      boolean var2 = false;
      class_4 var3 = this.method_9();

      while(true) {
         while(true) {
            class_445 var4;
            do {
               if (!var3.hasNext()) {
                  return var2;
               }

               var4 = (class_445)var3.next();
            } while(var4.method_1518() < 1);

            if (var1 == null) {
               if (var4.method_1517(0) == null) {
                  break;
               }
            } else if (var1.equals(var4.method_1517(0))) {
               break;
            }
         }

         var3.remove();
         var2 = true;
      }
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object) boolean
   public boolean method_317(Object var1, Object var2) {
      boolean var3 = false;
      class_4 var4 = this.method_9();

      while(true) {
         while(true) {
            class_445 var5;
            while(true) {
               do {
                  if (!var4.hasNext()) {
                     return var3;
                  }

                  var5 = (class_445)var4.next();
               } while(var5.method_1518() < 2);

               if (var1 == null) {
                  if (var5.method_1517(0) == null) {
                     break;
                  }
               } else if (var1.equals(var5.method_1517(0))) {
                  break;
               }
            }

            if (var2 == null) {
               if (var5.method_1517(1) == null) {
                  break;
               }
            } else if (var2.equals(var5.method_1517(1))) {
               break;
            }
         }

         var4.remove();
         var3 = true;
      }
   }

   // $FF: renamed from: f (java.lang.Object, java.lang.Object, java.lang.Object) boolean
   public boolean method_318(Object var1, Object var2, Object var3) {
      boolean var4 = false;
      class_4 var5 = this.method_9();

      while(true) {
         while(true) {
            class_445 var6;
            while(true) {
               while(true) {
                  do {
                     if (!var5.hasNext()) {
                        return var4;
                     }

                     var6 = (class_445)var5.next();
                  } while(var6.method_1518() < 3);

                  if (var1 == null) {
                     if (var6.method_1517(0) == null) {
                        break;
                     }
                  } else if (var1.equals(var6.method_1517(0))) {
                     break;
                  }
               }

               if (var2 == null) {
                  if (var6.method_1517(1) == null) {
                     break;
                  }
               } else if (var2.equals(var6.method_1517(1))) {
                  break;
               }
            }

            if (var3 == null) {
               if (var6.method_1517(2) == null) {
                  break;
               }
            } else if (var3.equals(var6.method_1517(2))) {
               break;
            }
         }

         var5.remove();
         var4 = true;
      }
   }

   // $FF: renamed from: f (java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) boolean
   public boolean method_319(Object var1, Object var2, Object var3, Object var4) {
      boolean var5 = false;
      class_4 var6 = this.method_9();

      while(true) {
         while(true) {
            class_445 var7;
            while(true) {
               while(true) {
                  while(true) {
                     do {
                        if (!var6.hasNext()) {
                           return var5;
                        }

                        var7 = (class_445)var6.next();
                     } while(var7.method_1518() < 4);

                     if (var1 == null) {
                        if (var7.method_1517(0) == null) {
                           break;
                        }
                     } else if (var1.equals(var7.method_1517(0))) {
                        break;
                     }
                  }

                  if (var2 == null) {
                     if (var7.method_1517(1) == null) {
                        break;
                     }
                  } else if (var2.equals(var7.method_1517(1))) {
                     break;
                  }
               }

               if (var3 == null) {
                  if (var7.method_1517(2) == null) {
                     break;
                  }
               } else if (var3.equals(var7.method_1517(2))) {
                  break;
               }
            }

            if (var4 == null) {
               if (var7.method_1517(3) == null) {
                  break;
               }
            } else if (var4.equals(var7.method_1517(3))) {
               break;
            }
         }

         var6.remove();
         var5 = true;
      }
   }

   // $FF: renamed from: a (org.a.a.a.g.f) void
   protected void method_320(class_445 var1) {
      if (var1 == null) {
         throw new NullPointerException("Key must not be null");
      }
   }

   // $FF: renamed from: a () org.a.a.a.i.at
   public class_129 method_321() {
      try {
         return (class_129)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   // $FF: renamed from: a (org.a.a.a.g.f, java.lang.Object) java.lang.Object
   public Object method_322(class_445 var1, Object var2) {
      this.method_320(var1);
      return super.put(var1, var2);
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         class_445 var3 = (class_445)var2.next();
         this.method_320(var3);
      }

      super.putAll(var1);
   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      return this.method_323().method_9();
   }

   // $FF: renamed from: b () org.a.a.a.i.a
   protected class_151 method_323() {
      return (class_151)super.method_258();
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_324(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_325(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   // $FF: synthetic method
   public Object put(Object var1, Object var2) {
      return this.method_322((class_445)var1, var2);
   }

   // $FF: renamed from: i () java.util.Map
   // $FF: synthetic method
   protected Map method_258() {
      return this.method_323();
   }

   // $FF: synthetic method
   public Object clone() {
      return this.method_321();
   }
}
