package org.a.a.a.i;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_13;
import org.a.a.a.class_15;
import org.a.a.a.class_30;
import org.a.a.a.class_4;
import org.a.a.a.class_7;
import org.a.a.a.g.class_444;

// $FF: renamed from: org.a.a.a.i.aI
public class class_167 implements Serializable, Cloneable, class_30, class_15, class_13 {
   // $FF: renamed from: a long
   private static final long field_208 = -8931271118676803261L;
   // $FF: renamed from: b java.lang.Object
   private final Object field_209;
   // $FF: renamed from: c java.lang.Object
   private Object field_210;

   public class_167() {
      this.field_209 = null;
   }

   public class_167(Object var1, Object var2) {
      this.field_209 = var1;
      this.field_210 = var2;
   }

   public class_167(class_30 var1) {
      this.field_209 = var1.getKey();
      this.field_210 = var1.getValue();
   }

   public class_167(Entry var1) {
      this.field_209 = var1.getKey();
      this.field_210 = var1.getValue();
   }

   public class_167(Map var1) {
      if (var1.size() != 1) {
         throw new IllegalArgumentException("The map size must be 1");
      } else {
         Entry var2 = (Entry)var1.entrySet().iterator().next();
         this.field_209 = var2.getKey();
         this.field_210 = var2.getValue();
      }
   }

   public Object getKey() {
      return this.field_209;
   }

   public Object getValue() {
      return this.field_210;
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_518(Object var1) {
      Object var2 = this.field_210;
      this.field_210 = var1;
      return var2;
   }

   // $FF: renamed from: a () boolean
   public boolean method_14() {
      return true;
   }

   // $FF: renamed from: a_ () int
   public int method_15() {
      return 1;
   }

   public Object get(Object var1) {
      return this.method_519(var1) ? this.field_210 : null;
   }

   public int size() {
      return 1;
   }

   public boolean isEmpty() {
      return false;
   }

   public boolean containsKey(Object var1) {
      return this.method_519(var1);
   }

   public boolean containsValue(Object var1) {
      return this.method_520(var1);
   }

   public Object put(Object var1, Object var2) {
      if (this.method_519(var1)) {
         return this.method_518(var2);
      } else {
         throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
      }
   }

   public void putAll(Map var1) {
      switch(var1.size()) {
      case 0:
         return;
      case 1:
         Entry var2 = (Entry)var1.entrySet().iterator().next();
         this.put(var2.getKey(), var2.getValue());
         return;
      default:
         throw new IllegalArgumentException("The map size must be 0 or 1");
      }
   }

   public Object remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Set entrySet() {
      class_444 var1 = new class_444(this, this.getKey());
      return Collections.singleton(var1);
   }

   public Set keySet() {
      return Collections.singleton(this.field_209);
   }

   public Collection values() {
      return new class_170(this);
   }

   // $FF: renamed from: e () org.a.a.a.am
   public class_7 method_17() {
      return new class_173(this);
   }

   public Object firstKey() {
      return this.getKey();
   }

   public Object lastKey() {
      return this.getKey();
   }

   // $FF: renamed from: c (java.lang.Object) java.lang.Object
   public Object method_18(Object var1) {
      return null;
   }

   // $FF: renamed from: d (java.lang.Object) java.lang.Object
   public Object method_19(Object var1) {
      return null;
   }

   // $FF: renamed from: b (java.lang.Object) boolean
   protected boolean method_519(Object var1) {
      return var1 == null ? this.getKey() == null : var1.equals(this.getKey());
   }

   // $FF: renamed from: e (java.lang.Object) boolean
   protected boolean method_520(Object var1) {
      return var1 == null ? this.getValue() == null : var1.equals(this.getValue());
   }

   // $FF: renamed from: d () org.a.a.a.i.aI
   public class_167 method_521() {
      try {
         return (class_167)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new InternalError();
      }
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Map)) {
         return false;
      } else {
         Map var2 = (Map)var1;
         if (var2.size() != 1) {
            return false;
         } else {
            Entry var3 = (Entry)var2.entrySet().iterator().next();
            return this.method_519(var3.getKey()) && this.method_520(var3.getValue());
         }
      }
   }

   public int hashCode() {
      return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
   }

   public String toString() {
      return (new StringBuilder(128)).append('{').append(this.getKey() == this ? "(this Map)" : this.getKey()).append('=').append(this.getValue() == this ? "(this Map)" : this.getValue()).append('}').toString();
   }

   // $FF: synthetic method
   public Object clone() {
      return this.method_521();
   }

   // $FF: renamed from: c () org.a.a.a.Z
   // $FF: synthetic method
   public class_4 method_9() {
      return this.method_17();
   }
}
