package org.a.a.a.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.a.a.a.class_12;
import org.a.a.a.class_4;

// $FF: renamed from: org.a.a.a.b.b
public abstract class class_353 implements class_12 {
   // $FF: renamed from: a java.util.Map
   transient Map field_588;
   // $FF: renamed from: b java.util.Map
   transient Map field_589;
   // $FF: renamed from: c org.a.a.a.d
   transient class_12 field_590 = null;
   // $FF: renamed from: d java.util.Set
   transient Set field_591 = null;
   // $FF: renamed from: e java.util.Set
   transient Set field_592 = null;
   // $FF: renamed from: f java.util.Set
   transient Set field_593 = null;

   protected class_353() {
   }

   protected class_353(Map var1, Map var2) {
      this.field_588 = var1;
      this.field_589 = var2;
   }

   protected class_353(Map var1, Map var2, class_12 var3) {
      this.field_588 = var1;
      this.field_589 = var2;
      this.field_590 = var3;
   }

   // $FF: renamed from: a (java.util.Map, java.util.Map, org.a.a.a.d) org.a.a.a.d
   protected abstract class_12 method_973(Map var1, Map var2, class_12 var3);

   public Object get(Object var1) {
      return this.field_588.get(var1);
   }

   public int size() {
      return this.field_588.size();
   }

   public boolean isEmpty() {
      return this.field_588.isEmpty();
   }

   public boolean containsKey(Object var1) {
      return this.field_588.containsKey(var1);
   }

   public boolean equals(Object var1) {
      return this.field_588.equals(var1);
   }

   public int hashCode() {
      return this.field_588.hashCode();
   }

   public String toString() {
      return this.field_588.toString();
   }

   public Object put(Object var1, Object var2) {
      if (this.field_588.containsKey(var1)) {
         this.field_589.remove(this.field_588.get(var1));
      }

      if (this.field_589.containsKey(var2)) {
         this.field_588.remove(this.field_589.get(var2));
      }

      Object var3 = this.field_588.put(var1, var2);
      this.field_589.put(var2, var1);
      return var3;
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   public Object remove(Object var1) {
      Object var2 = null;
      if (this.field_588.containsKey(var1)) {
         var2 = this.field_588.remove(var1);
         this.field_589.remove(var2);
      }

      return var2;
   }

   public void clear() {
      this.field_588.clear();
      this.field_589.clear();
   }

   public boolean containsValue(Object var1) {
      return this.field_589.containsKey(var1);
   }

   // $FF: renamed from: c () org.a.a.a.Z
   public class_4 method_9() {
      return new class_358(this);
   }

   // $FF: renamed from: a (java.lang.Object) java.lang.Object
   public Object method_10(Object var1) {
      return this.field_589.get(var1);
   }

   // $FF: renamed from: b (java.lang.Object) java.lang.Object
   public Object method_11(Object var1) {
      Object var2 = null;
      if (this.field_589.containsKey(var1)) {
         var2 = this.field_589.remove(var1);
         this.field_588.remove(var2);
      }

      return var2;
   }

   // $FF: renamed from: a () org.a.a.a.d
   public class_12 method_12() {
      if (this.field_590 == null) {
         this.field_590 = this.method_973(this.field_589, this.field_588, this);
      }

      return this.field_590;
   }

   public Set keySet() {
      if (this.field_591 == null) {
         this.field_591 = new class_68(this);
      }

      return this.field_591;
   }

   // $FF: renamed from: a (java.util.Iterator) java.util.Iterator
   protected Iterator method_974(Iterator var1) {
      return new class_188(var1, this);
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_13() {
      if (this.field_592 == null) {
         this.field_592 = new class_69(this);
      }

      return this.field_592;
   }

   // $FF: renamed from: b (java.util.Iterator) java.util.Iterator
   protected Iterator method_975(Iterator var1) {
      return new class_189(var1, this);
   }

   public Set entrySet() {
      if (this.field_593 == null) {
         this.field_593 = new class_67(this);
      }

      return this.field_593;
   }

   // $FF: renamed from: c (java.util.Iterator) java.util.Iterator
   protected Iterator method_976(Iterator var1) {
      return new class_187(var1, this);
   }

   // $FF: synthetic method
   public Collection values() {
      return this.method_13();
   }
}
