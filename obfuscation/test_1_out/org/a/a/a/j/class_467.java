package org.a.a.a.j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_24;
import org.a.a.a.class_28;
import org.a.a.a.class_4;
import org.a.a.a.class_415;
import org.a.a.a.f.class_163;
import org.a.a.a.k.class_57;

// $FF: renamed from: org.a.a.a.j.d
public abstract class class_467 implements class_24 {
   // $FF: renamed from: a java.util.Collection
   private transient Collection field_848;
   // $FF: renamed from: b org.a.a.a.j.i
   private transient class_464 field_849;
   // $FF: renamed from: c org.a.a.a.af
   private transient class_28 field_850;
   // $FF: renamed from: d org.a.a.a.j.f
   private transient class_465 field_851;
   // $FF: renamed from: e java.util.Map
   private transient Map field_852;

   protected class_467() {
   }

   protected class_467(Map var1) {
      if (var1 == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         this.field_852 = var1;
      }
   }

   // $FF: renamed from: j () java.util.Map
   protected Map method_1552() {
      return this.field_852;
   }

   // $FF: renamed from: b (java.util.Map) void
   protected void method_1553(Map var1) {
      this.field_852 = var1;
   }

   // $FF: renamed from: l () java.util.Collection
   protected abstract Collection method_1554();

   // $FF: renamed from: c (java.lang.Object) boolean
   public boolean method_35(Object var1) {
      return this.method_1552().containsKey(var1);
   }

   // $FF: renamed from: d (java.lang.Object) boolean
   public boolean method_36(Object var1) {
      return this.method_49().contains(var1);
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Object) boolean
   public boolean method_37(Object var1, Object var2) {
      Collection var3 = (Collection)this.method_1552().get(var1);
      return var3 != null && var3.contains(var2);
   }

   // $FF: renamed from: d () java.util.Collection
   public Collection method_46() {
      return this.field_849 != null ? this.field_849 : (this.field_849 = new class_464(this, (class_472)null));
   }

   // $FF: renamed from: e (java.lang.Object) java.util.Collection
   public Collection method_38(Object var1) {
      return this.method_1555(var1);
   }

   // $FF: renamed from: h (java.lang.Object) java.util.Collection
   Collection method_1555(Object var1) {
      return new class_474(this, var1);
   }

   // $FF: renamed from: f (java.lang.Object) java.util.Collection
   public Collection method_43(Object var1) {
      return class_415.method_1327((Collection)this.method_1552().remove(var1));
   }

   // $FF: renamed from: c (java.lang.Object, java.lang.Object) boolean
   public boolean method_44(Object var1, Object var2) {
      Collection var3 = (Collection)this.method_1552().get(var1);
      if (var3 == null) {
         return false;
      } else {
         boolean var4 = var3.remove(var2);
         if (var3.isEmpty()) {
            this.method_1552().remove(var1);
         }

         return var4;
      }
   }

   // $FF: renamed from: b () boolean
   public boolean method_34() {
      return this.method_1552().isEmpty();
   }

   // $FF: renamed from: f () java.util.Set
   public Set method_48() {
      return this.method_1552().keySet();
   }

   // $FF: renamed from: a () int
   public int method_33() {
      int var1 = 0;

      Collection var3;
      for(Iterator var2 = this.method_1552().values().iterator(); var2.hasNext(); var1 += var3.size()) {
         var3 = (Collection)var2.next();
      }

      return var1;
   }

   // $FF: renamed from: g () java.util.Collection
   public Collection method_49() {
      Collection var1 = this.field_848;
      return var1 != null ? var1 : (this.field_848 = new class_482(this, (class_472)null));
   }

   // $FF: renamed from: c () void
   public void method_45() {
      this.method_1552().clear();
   }

   // $FF: renamed from: b (java.lang.Object, java.lang.Object) boolean
   public boolean method_39(Object var1, Object var2) {
      Collection var3 = (Collection)this.method_1552().get(var1);
      if (var3 == null) {
         var3 = this.method_1554();
         if (var3.add(var2)) {
            this.field_852.put(var1, var3);
            return true;
         } else {
            return false;
         }
      } else {
         return var3.add(var2);
      }
   }

   // $FF: renamed from: a (java.util.Map) boolean
   public boolean method_41(Map var1) {
      if (var1 == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         boolean var2 = false;

         Entry var4;
         for(Iterator var3 = var1.entrySet().iterator(); var3.hasNext(); var2 |= this.method_39(var4.getKey(), var4.getValue())) {
            var4 = (Entry)var3.next();
         }

         return var2;
      }
   }

   // $FF: renamed from: a (org.a.a.a.ai) boolean
   public boolean method_42(class_24 var1) {
      if (var1 == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         boolean var2 = false;

         Entry var4;
         for(Iterator var3 = var1.method_46().iterator(); var3.hasNext(); var2 |= this.method_39(var4.getKey(), var4.getValue())) {
            var4 = (Entry)var3.next();
         }

         return var2;
      }
   }

   // $FF: renamed from: e () org.a.a.a.af
   public class_28 method_47() {
      if (this.field_850 == null) {
         this.field_850 = class_57.method_116(new class_371(this, (class_472)null));
      }

      return this.field_850;
   }

   // $FF: renamed from: h () java.util.Map
   public Map method_50() {
      return this.field_851 != null ? this.field_851 : (this.field_851 = new class_465(this, this.field_852));
   }

   // $FF: renamed from: a (java.lang.Object, java.lang.Iterable) boolean
   public boolean method_40(Object var1, Iterable var2) {
      if (var2 == null) {
         throw new NullPointerException("Values must not be null.");
      } else if (var2 instanceof Collection) {
         Collection var4 = (Collection)var2;
         return !var4.isEmpty() && this.method_38(var1).addAll(var4);
      } else {
         Iterator var3 = var2.iterator();
         return var3.hasNext() && class_415.method_1363(this.method_38(var1), var3);
      }
   }

   // $FF: renamed from: i () org.a.a.a.Z
   public class_4 method_51() {
      return (class_4)(this.method_33() == 0 ? class_163.method_512() : new class_481(this));
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return var1 instanceof class_24 ? this.method_50().equals(((class_24)var1).method_50()) : false;
      }
   }

   public int hashCode() {
      return this.method_1552().hashCode();
   }

   public String toString() {
      return this.method_1552().toString();
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   protected void method_1556(ObjectOutputStream var1) {
      var1.writeInt(this.field_852.size());
      Iterator var2 = this.field_852.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeInt(((Collection)var3.getValue()).size());
         Iterator var4 = ((Collection)var3.getValue()).iterator();

         while(var4.hasNext()) {
            Object var5 = var4.next();
            var1.writeObject(var5);
         }
      }

   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   protected void method_1557(ObjectInputStream var1) {
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var1.readObject();
         Collection var5 = this.method_38(var4);
         int var6 = var1.readInt();

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var1.readObject();
            var5.add(var8);
         }
      }

   }

   // $FF: renamed from: a (org.a.a.a.j.d) java.util.Map
   // $FF: synthetic method
   static Map method_1558(class_467 var0) {
      return var0.field_852;
   }
}
