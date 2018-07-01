package org.a.a.a.b;

import java.util.Map.Entry;
import org.a.a.a.g.class_208;

// $FF: renamed from: org.a.a.a.b.h
public class class_210 extends class_208 {
   // $FF: renamed from: a org.a.a.a.b.b
   protected final class_353 field_290;

   protected class_210(Entry var1, class_353 var2) {
      super(var1);
      this.field_290 = var2;
   }

   public Object setValue(Object var1) {
      Object var2 = this.getKey();
      if (this.field_290.field_589.containsKey(var1) && this.field_290.field_589.get(var1) != var2) {
         throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
      } else {
         this.field_290.put(var2, var1);
         return super.setValue(var1);
      }
   }
}
