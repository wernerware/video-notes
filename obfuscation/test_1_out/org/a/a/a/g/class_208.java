package org.a.a.a.g;

import java.util.Map.Entry;
import org.a.a.a.class_30;

// $FF: renamed from: org.a.a.a.g.c
public abstract class class_208 implements Entry, class_30 {
   // $FF: renamed from: a java.util.Map.Entry
   private final Entry field_287;

   public class_208(Entry var1) {
      if (var1 == null) {
         throw new NullPointerException("Map Entry must not be null.");
      } else {
         this.field_287 = var1;
      }
   }

   // $FF: renamed from: a () java.util.Map.Entry
   protected Entry method_554() {
      return this.field_287;
   }

   public Object getKey() {
      return this.field_287.getKey();
   }

   public Object getValue() {
      return this.field_287.getValue();
   }

   public Object setValue(Object var1) {
      return this.field_287.setValue(var1);
   }

   public boolean equals(Object var1) {
      return var1 == this ? true : this.field_287.equals(var1);
   }

   public int hashCode() {
      return this.field_287.hashCode();
   }

   public String toString() {
      return this.field_287.toString();
   }
}
