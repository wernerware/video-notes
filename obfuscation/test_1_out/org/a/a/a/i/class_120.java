package org.a.a.a.i;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: org.a.a.a.i.aB
public class class_120 extends class_116 implements Serializable {
   // $FF: renamed from: b long
   private static final long field_123 = 1L;
   // $FF: renamed from: c java.util.Map
   private final Map field_124;
   // $FF: renamed from: d org.a.a.a.i.aD
   private final class_3 field_125;

   // $FF: renamed from: b (long, java.util.concurrent.TimeUnit) long
   private static long method_267(long var0, TimeUnit var2) {
      if (var2 == null) {
         throw new NullPointerException("Time unit must not be null");
      } else {
         return TimeUnit.MILLISECONDS.convert(var0, var2);
      }
   }

   public class_120() {
      this(-1L);
   }

   public class_120(class_3 var1) {
      this(var1, new HashMap());
   }

   public class_120(class_3 var1, Map var2) {
      super(var2);
      this.field_124 = new HashMap();
      if (var1 == null) {
         throw new NullPointerException("Policy must not be null.");
      } else {
         this.field_125 = var1;
      }
   }

   public class_120(long var1) {
      this(new class_299(var1), new HashMap());
   }

   public class_120(long var1, Map var3) {
      this(new class_299(var1), var3);
   }

   public class_120(long var1, TimeUnit var3) {
      this(method_267(var1, var3));
   }

   public class_120(long var1, TimeUnit var3, Map var4) {
      this(method_267(var1, var3), var4);
   }

   public class_120(Map var1) {
      this(-1L, var1);
   }

   public void clear() {
      super.clear();
      this.field_124.clear();
   }

   public boolean containsKey(Object var1) {
      this.method_271(var1, this.method_269());
      return super.containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      this.method_270(this.method_269());
      return super.containsValue(var1);
   }

   public Set entrySet() {
      this.method_270(this.method_269());
      return super.entrySet();
   }

   public Object get(Object var1) {
      this.method_271(var1, this.method_269());
      return super.get(var1);
   }

   public boolean isEmpty() {
      this.method_270(this.method_269());
      return super.isEmpty();
   }

   // $FF: renamed from: a (long, java.lang.Long) boolean
   private boolean method_268(long var1, Long var3) {
      if (var3 == null) {
         return false;
      } else {
         long var4 = var3;
         return var4 >= 0L && var1 >= var4;
      }
   }

   public Set keySet() {
      this.method_270(this.method_269());
      return super.keySet();
   }

   // $FF: renamed from: a () long
   private long method_269() {
      return System.currentTimeMillis();
   }

   public Object put(Object var1, Object var2) {
      long var3 = this.field_125.method_5(var1, var2);
      this.field_124.put(var1, var3);
      return super.put(var1, var2);
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   public Object remove(Object var1) {
      this.field_124.remove(var1);
      return super.remove(var1);
   }

   // $FF: renamed from: a (long) void
   private void method_270(long var1) {
      Iterator var3 = this.field_124.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if (this.method_268(var1, (Long)var4.getValue())) {
            super.remove(var4.getKey());
            var3.remove();
         }
      }

   }

   // $FF: renamed from: a (java.lang.Object, long) void
   private void method_271(Object var1, long var2) {
      Long var4 = (Long)this.field_124.get(var1);
      if (this.method_268(var2, var4)) {
         this.remove(var1);
      }

   }

   public int size() {
      this.method_270(this.method_269());
      return super.size();
   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_272(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.a = (Map)var1.readObject();
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_273(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.a);
   }

   public Collection values() {
      this.method_270(this.method_269());
      return super.values();
   }

   // $FF: renamed from: a (long, java.util.concurrent.TimeUnit) long
   // $FF: synthetic method
   static long method_274(long var0, TimeUnit var2) {
      return method_267(var0, var2);
   }
}
