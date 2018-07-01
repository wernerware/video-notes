package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_11;
import org.a.a.a.class_4;
import org.a.a.a.f.class_163;

// $FF: renamed from: org.a.a.a.i.U
public class class_504 implements Serializable, Cloneable, class_11 {
   // $FF: renamed from: a long
   private static final long field_918 = -6701087419741928296L;
   // $FF: renamed from: b int
   private transient int field_919;
   // $FF: renamed from: c int
   private transient int field_920;
   // $FF: renamed from: d int
   private transient int field_921;
   // $FF: renamed from: e int
   private transient int field_922;
   // $FF: renamed from: f java.lang.Object
   private transient Object field_923;
   // $FF: renamed from: g java.lang.Object
   private transient Object field_924;
   // $FF: renamed from: h java.lang.Object
   private transient Object field_925;
   // $FF: renamed from: i java.lang.Object
   private transient Object field_926;
   // $FF: renamed from: j java.lang.Object
   private transient Object field_927;
   // $FF: renamed from: k java.lang.Object
   private transient Object field_928;
   // $FF: renamed from: l org.a.a.a.i.a
   private transient class_151 field_929;

   public class_504() {
   }

   public class_504(Map var1) {
      this.putAll(var1);
   }

   public Object get(Object var1) {
      if (this.field_929 != null) {
         return this.field_929.get(var1);
      } else {
         if (var1 == null) {
            switch(this.field_919) {
            case 3:
               if (this.field_925 == null) {
                  return this.field_928;
               }
            case 2:
               if (this.field_924 == null) {
                  return this.field_927;
               }
            case 1:
               if (this.field_923 == null) {
                  return this.field_926;
               }
            }
         } else if (this.field_919 > 0) {
            int var2 = var1.hashCode();
            switch(this.field_919) {
            case 3:
               if (this.field_922 == var2 && var1.equals(this.field_925)) {
                  return this.field_928;
               }
            case 2:
               if (this.field_921 == var2 && var1.equals(this.field_924)) {
                  return this.field_927;
               }
            case 1:
               if (this.field_920 == var2 && var1.equals(this.field_923)) {
                  return this.field_926;
               }
            }
         }

         return null;
      }
   }

   public int size() {
      return this.field_929 != null ? this.field_929.size() : this.field_919;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public boolean containsKey(Object var1) {
      if (this.field_929 != null) {
         return this.field_929.containsKey(var1);
      } else {
         if (var1 == null) {
            switch(this.field_919) {
            case 3:
               if (this.field_925 == null) {
                  return true;
               }
            case 2:
               if (this.field_924 == null) {
                  return true;
               }
            case 1:
               if (this.field_923 == null) {
                  return true;
               }
            }
         } else if (this.field_919 > 0) {
            int var2 = var1.hashCode();
            switch(this.field_919) {
            case 3:
               if (this.field_922 == var2 && var1.equals(this.field_925)) {
                  return true;
               }
            case 2:
               if (this.field_921 == var2 && var1.equals(this.field_924)) {
                  return true;
               }
            case 1:
               if (this.field_920 == var2 && var1.equals(this.field_923)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean containsValue(Object var1) {
      if (this.field_929 != null) {
         return this.field_929.containsValue(var1);
      } else {
         if (var1 == null) {
            switch(this.field_919) {
            case 3:
               if (this.field_928 == null) {
                  return true;
               }
            case 2:
               if (this.field_927 == null) {
                  return true;
               }
            case 1:
               if (this.field_926 == null) {
                  return true;
               }
            }
         } else {
            switch(this.field_919) {
            case 3:
               if (var1.equals(this.field_928)) {
                  return true;
               }
            case 2:
               if (var1.equals(this.field_927)) {
                  return true;
               }
            case 1:
               if (var1.equals(this.field_926)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public Object put(Object var1, Object var2) {
      if (this.field_929 != null) {
         return this.field_929.put(var1, var2);
      } else {
         if (var1 == null) {
            Object var3;
            switch(this.field_919) {
            case 3:
               if (this.field_925 == null) {
                  var3 = this.field_928;
                  this.field_928 = var2;
                  return var3;
               }
            case 2:
               if (this.field_924 == null) {
                  var3 = this.field_927;
                  this.field_927 = var2;
                  return var3;
               }
            case 1:
               if (this.field_923 == null) {
                  var3 = this.field_926;
                  this.field_926 = var2;
                  return var3;
               }
            }
         } else if (this.field_919 > 0) {
            int var5 = var1.hashCode();
            Object var4;
            switch(this.field_919) {
            case 3:
               if (this.field_922 == var5 && var1.equals(this.field_925)) {
                  var4 = this.field_928;
                  this.field_928 = var2;
                  return var4;
               }
            case 2:
               if (this.field_921 == var5 && var1.equals(this.field_924)) {
                  var4 = this.field_927;
                  this.field_927 = var2;
                  return var4;
               }
            case 1:
               if (this.field_920 == var5 && var1.equals(this.field_923)) {
                  var4 = this.field_926;
                  this.field_926 = var2;
                  return var4;
               }
            }
         }

         switch(this.field_919) {
         case 0:
            this.field_920 = var1 == null ? 0 : var1.hashCode();
            this.field_923 = var1;
            this.field_926 = var2;
            break;
         case 1:
            this.field_921 = var1 == null ? 0 : var1.hashCode();
            this.field_924 = var1;
            this.field_927 = var2;
            break;
         case 2:
            this.field_922 = var1 == null ? 0 : var1.hashCode();
            this.field_925 = var1;
            this.field_928 = var2;
            break;
         default:
            this.method_1590();
            this.field_929.put(var1, var2);
            return null;
         }

         ++this.field_919;
         return null;
      }
   }

   public void putAll(Map var1) {
      int var2 = var1.size();
      if (var2 != 0) {
         if (this.field_929 != null) {
            this.field_929.putAll(var1);
         } else {
            if (var2 < 4) {
               Iterator var3 = var1.entrySet().iterator();

               while(var3.hasNext()) {
                  Entry var4 = (Entry)var3.next();
                  this.put(var4.getKey(), var4.getValue());
               }
            } else {
               this.method_1590();
               this.field_929.putAll(var1);
            }

         }
      }
   }

   // $FF: renamed from: d () void
   private void method_1590() {
      this.field_929 = this.method_1591();
      switch(this.field_919) {
      case 3:
         this.field_929.put(this.field_925, this.field_928);
      case 2:
         this.field_929.put(this.field_924, this.field_927);
      case 1:
         this.field_929.put(this.field_923, this.field_926);
      case 0:
         this.field_919 = 0;
         this.field_920 = this.field_921 = this.field_922 = 0;
         this.field_923 = this.field_924 = this.field_925 = null;
         this.field_926 = this.field_927 = this.field_928 = null;
         return;
      default:
         throw new IllegalStateException("Invalid map index: " + this.field_919);
      }
   }

   // $FF: renamed from: a () org.a.a.a.i.a
   protected class_151 method_1591() {
      return new class_156();
   }

   public Object remove(Object var1) {
      if (this.field_929 != null) {
         return this.field_929.remove(var1);
      } else if (this.field_919 == 0) {
         return null;
      } else {
         if (var1 == null) {
            Object var2;
            switch(this.field_919) {
            case 1:
               if (this.field_923 == null) {
                  var2 = this.field_926;
                  this.field_920 = 0;
                  this.field_923 = null;
                  this.field_926 = null;
                  this.field_919 = 0;
                  return var2;
               }
               break;
            case 2:
               if (this.field_924 == null) {
                  var2 = this.field_927;
                  this.field_921 = 0;
                  this.field_924 = null;
                  this.field_927 = null;
                  this.field_919 = 1;
                  return var2;
               }

               if (this.field_923 == null) {
                  var2 = this.field_926;
                  this.field_920 = this.field_921;
                  this.field_923 = this.field_924;
                  this.field_926 = this.field_927;
                  this.field_921 = 0;
                  this.field_924 = null;
                  this.field_927 = null;
                  this.field_919 = 1;
                  return var2;
               }

               return null;
            case 3:
               if (this.field_925 == null) {
                  var2 = this.field_928;
                  this.field_922 = 0;
                  this.field_925 = null;
                  this.field_928 = null;
                  this.field_919 = 2;
                  return var2;
               }

               if (this.field_924 == null) {
                  var2 = this.field_927;
                  this.field_921 = this.field_922;
                  this.field_924 = this.field_925;
                  this.field_927 = this.field_928;
                  this.field_922 = 0;
                  this.field_925 = null;
                  this.field_928 = null;
                  this.field_919 = 2;
                  return var2;
               }

               if (this.field_923 == null) {
                  var2 = this.field_926;
                  this.field_920 = this.field_922;
                  this.field_923 = this.field_925;
                  this.field_926 = this.field_928;
                  this.field_922 = 0;
                  this.field_925 = null;
                  this.field_928 = null;
                  this.field_919 = 2;
                  return var2;
               }

               return null;
            }
         } else if (this.field_919 > 0) {
            int var4 = var1.hashCode();
            Object var3;
            switch(this.field_919) {
            case 1:
               if (this.field_920 == var4 && var1.equals(this.field_923)) {
                  var3 = this.field_926;
                  this.field_920 = 0;
                  this.field_923 = null;
                  this.field_926 = null;
                  this.field_919 = 0;
                  return var3;
               }
               break;
            case 2:
               if (this.field_921 == var4 && var1.equals(this.field_924)) {
                  var3 = this.field_927;
                  this.field_921 = 0;
                  this.field_924 = null;
                  this.field_927 = null;
                  this.field_919 = 1;
                  return var3;
               }

               if (this.field_920 == var4 && var1.equals(this.field_923)) {
                  var3 = this.field_926;
                  this.field_920 = this.field_921;
                  this.field_923 = this.field_924;
                  this.field_926 = this.field_927;
                  this.field_921 = 0;
                  this.field_924 = null;
                  this.field_927 = null;
                  this.field_919 = 1;
                  return var3;
               }

               return null;
            case 3:
               if (this.field_922 == var4 && var1.equals(this.field_925)) {
                  var3 = this.field_928;
                  this.field_922 = 0;
                  this.field_925 = null;
                  this.field_928 = null;
                  this.field_919 = 2;
                  return var3;
               }

               if (this.field_921 == var4 && var1.equals(this.field_924)) {
                  var3 = this.field_927;
                  this.field_921 = this.field_922;
                  this.field_924 = this.field_925;
                  this.field_927 = this.field_928;
                  this.field_922 = 0;
                  this.field_925 = null;
                  this.field_928 = null;
                  this.field_919 = 2;
                  return var3;
               }

               if (this.field_920 == var4 && var1.equals(this.field_923)) {
                  var3 = this.field_926;
                  this.field_920 = this.field_922;
                  this.field_923 = this.field_925;
                  this.field_926 = this.field_928;
                  this.field_922 = 0;
                  this.field_925 = null;
                  this.field_928 = null;
                  this.field_919 = 2;
                  return var3;
               }

               return null;
            }
         }

         return null;
      }
   }

   public void clear() {
      if (this.field_929 != null) {
         this.field_929.clear();
         this.field_929 = null;
      } else {
         this.field_919 = 0;
         this.field_920 = this.field_921 = this.field_922 = 0;
         this.field_923 = this.field_924 = this.field_925 = null;
         this.field_926 = this.field_927 = this.field_928 = null;
      }

   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      if (this.field_929 != null) {
         return this.field_929.method_9();
      } else {
         return (class_4)(this.field_919 == 0 ? class_163.method_512() : new class_502(this));
      }
   }

   public Set entrySet() {
      return (Set)(this.field_929 != null ? this.field_929.entrySet() : new class_503(this));
   }

   public Set keySet() {
      return (Set)(this.field_929 != null ? this.field_929.keySet() : new class_221(this));
   }

   public Collection values() {
      return (Collection)(this.field_929 != null ? this.field_929.values() : new class_225(this));
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_1592(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.size());
      class_4 var2 = this.method_9();

      while(var2.hasNext()) {
         var1.writeObject(var2.next());
         var1.writeObject(var2.method_7());
      }

   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_1593(ObjectInputStream var1) {
      var1.defaultReadObject();
      int var2 = var1.readInt();
      if (var2 > 3) {
         this.field_929 = this.method_1591();
      }

      for(int var3 = var2; var3 > 0; --var3) {
         this.put(var1.readObject(), var1.readObject());
      }

   }

   // $FF: renamed from: b () org.a.a.a.i.U
   public class_504 method_1594() {
      try {
         class_504 var1 = (class_504)super.clone();
         if (var1.field_929 != null) {
            var1.field_929 = var1.field_929.method_464();
         }

         return var1;
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (this.field_929 != null) {
         return this.field_929.equals(var1);
      } else if (!(var1 instanceof Map)) {
         return false;
      } else {
         Map var2 = (Map)var1;
         if (this.field_919 != var2.size()) {
            return false;
         } else if (this.field_919 > 0) {
            Object var3 = null;
            switch(this.field_919) {
            case 3:
               if (!var2.containsKey(this.field_925)) {
                  return false;
               }

               var3 = var2.get(this.field_925);
               if (this.field_928 == null) {
                  if (var3 != null) {
                     return false;
                  }
               } else if (!this.field_928.equals(var3)) {
                  return false;
               }
            case 2:
               if (!var2.containsKey(this.field_924)) {
                  return false;
               }

               var3 = var2.get(this.field_924);
               if (this.field_927 == null) {
                  if (var3 != null) {
                     break;
                  }
               } else if (!this.field_927.equals(var3)) {
                  break;
               }
            case 1:
               if (!var2.containsKey(this.field_923)) {
                  return false;
               }

               var3 = var2.get(this.field_923);
               if (this.field_926 == null) {
                  if (var3 == null) {
                     return true;
                  }
               } else if (this.field_926.equals(var3)) {
                  return true;
               }

               return false;
            default:
               return true;
            }

            return false;
         } else {
            return true;
         }
      }
   }

   public int hashCode() {
      if (this.field_929 != null) {
         return this.field_929.hashCode();
      } else {
         int var1 = 0;
         switch(this.field_919) {
         case 3:
            var1 += this.field_922 ^ (this.field_928 == null ? 0 : this.field_928.hashCode());
         case 2:
            var1 += this.field_921 ^ (this.field_927 == null ? 0 : this.field_927.hashCode());
         case 1:
            var1 += this.field_920 ^ (this.field_926 == null ? 0 : this.field_926.hashCode());
         case 0:
            return var1;
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_919);
         }
      }
   }

   public String toString() {
      if (this.field_929 != null) {
         return this.field_929.toString();
      } else if (this.field_919 == 0) {
         return "{}";
      } else {
         StringBuilder var1 = new StringBuilder(128);
         var1.append('{');
         switch(this.field_919) {
         case 3:
            var1.append(this.field_925 == this ? "(this Map)" : this.field_925);
            var1.append('=');
            var1.append(this.field_928 == this ? "(this Map)" : this.field_928);
            var1.append(',');
         case 2:
            var1.append(this.field_924 == this ? "(this Map)" : this.field_924);
            var1.append('=');
            var1.append(this.field_927 == this ? "(this Map)" : this.field_927);
            var1.append(',');
         case 1:
            var1.append(this.field_923 == this ? "(this Map)" : this.field_923);
            var1.append('=');
            var1.append(this.field_926 == this ? "(this Map)" : this.field_926);
            var1.append('}');
            return var1.toString();
         default:
            throw new IllegalStateException("Invalid map index: " + this.field_919);
         }
      }
   }

   // $FF: synthetic method
   public Object clone() {
      return this.method_1594();
   }

   // $FF: renamed from: a (org.a.a.a.i.U) int
   // $FF: synthetic method
   static int method_1595(class_504 var0) {
      return var0.field_919;
   }

   // $FF: renamed from: b (org.a.a.a.i.U) java.lang.Object
   // $FF: synthetic method
   static Object method_1596(class_504 var0) {
      return var0.field_925;
   }

   // $FF: renamed from: c (org.a.a.a.i.U) java.lang.Object
   // $FF: synthetic method
   static Object method_1597(class_504 var0) {
      return var0.field_924;
   }

   // $FF: renamed from: d (org.a.a.a.i.U) java.lang.Object
   // $FF: synthetic method
   static Object method_1598(class_504 var0) {
      return var0.field_923;
   }

   // $FF: renamed from: e (org.a.a.a.i.U) java.lang.Object
   // $FF: synthetic method
   static Object method_1599(class_504 var0) {
      return var0.field_928;
   }

   // $FF: renamed from: f (org.a.a.a.i.U) java.lang.Object
   // $FF: synthetic method
   static Object method_1600(class_504 var0) {
      return var0.field_927;
   }

   // $FF: renamed from: g (org.a.a.a.i.U) java.lang.Object
   // $FF: synthetic method
   static Object method_1601(class_504 var0) {
      return var0.field_926;
   }

   // $FF: renamed from: a (org.a.a.a.i.U, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   static Object method_1602(class_504 var0, Object var1) {
      return var0.field_928 = var1;
   }

   // $FF: renamed from: b (org.a.a.a.i.U, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   static Object method_1603(class_504 var0, Object var1) {
      return var0.field_927 = var1;
   }

   // $FF: renamed from: c (org.a.a.a.i.U, java.lang.Object) java.lang.Object
   // $FF: synthetic method
   static Object method_1604(class_504 var0, Object var1) {
      return var0.field_926 = var1;
   }

   // $FF: renamed from: h (org.a.a.a.i.U) org.a.a.a.i.a
   // $FF: synthetic method
   static class_151 method_1605(class_504 var0) {
      return var0.field_929;
   }
}
