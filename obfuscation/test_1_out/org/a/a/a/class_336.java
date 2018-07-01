package org.a.a.a;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.a.a.a.c.class_98;
import org.a.a.a.f.class_459;
import org.a.a.a.i.class_505;
import org.a.a.a.i.class_79;
import org.a.a.a.n.class_74;

// $FF: renamed from: org.a.a.a.aG
class class_336 implements class_29, class_11 {
   // $FF: renamed from: a org.a.a.a.w
   private final class_9 field_564;

   private class_336(class_9 var1) {
      this.field_564 = var1;
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean containsKey(Object var1) {
      return this.field_564.containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      return this.field_564.containsValue(var1);
   }

   public Set entrySet() {
      return class_79.method_159(this.field_564.entrySet());
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else {
         return var1 instanceof class_336 && ((class_336)var1).field_564.equals(this.field_564);
      }
   }

   public Object get(Object var1) {
      return this.field_564.get(var1);
   }

   public int hashCode() {
      return "WrappedGet".hashCode() << 4 | this.field_564.hashCode();
   }

   public boolean isEmpty() {
      return this.field_564.isEmpty();
   }

   public Set keySet() {
      return class_74.method_150(this.field_564.keySet());
   }

   public Object put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map var1) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object var1) {
      return this.field_564.remove(var1);
   }

   public int size() {
      return this.field_564.size();
   }

   public Collection values() {
      return class_98.method_216(this.field_564.values());
   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      Object var1;
      if (this.field_564 instanceof class_10) {
         var1 = ((class_10)this.field_564).method_9();
      } else {
         var1 = new class_505(this.field_564.entrySet());
      }

      return class_459.method_1541((class_4)var1);
   }

   // $FF: synthetic method
   class_336(class_9 var1, class_337 var2) {
      this(var1);
   }
}
