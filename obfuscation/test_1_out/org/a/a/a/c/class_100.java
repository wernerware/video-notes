package org.a.a.a.c;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

// $FF: renamed from: org.a.a.a.c.g
public class class_100 implements Serializable, Collection {
   // $FF: renamed from: a long
   private static final long field_92 = 2412805092710877986L;
   // $FF: renamed from: c java.util.Collection
   private final Collection field_93;
   // $FF: renamed from: b java.lang.Object
   protected final Object field_94;

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.c.g
   public static class_100 method_220(Collection var0) {
      return new class_100(var0);
   }

   protected class_100(Collection var1) {
      if (var1 == null) {
         throw new NullPointerException("Collection must not be null.");
      } else {
         this.field_93 = var1;
         this.field_94 = this;
      }
   }

   protected class_100(Collection var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException("Collection must not be null.");
      } else if (var2 == null) {
         throw new NullPointerException("Lock must not be null.");
      } else {
         this.field_93 = var1;
         this.field_94 = var2;
      }
   }

   // $FF: renamed from: g () java.util.Collection
   protected Collection method_221() {
      return this.field_93;
   }

   public boolean add(Object var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().add(var1);
      }
   }

   public boolean addAll(Collection var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().addAll(var1);
      }
   }

   public void clear() {
      Object var1 = this.field_94;
      synchronized(this.field_94) {
         this.method_221().clear();
      }
   }

   public boolean contains(Object var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().contains(var1);
      }
   }

   public boolean containsAll(Collection var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().containsAll(var1);
      }
   }

   public boolean isEmpty() {
      Object var1 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().isEmpty();
      }
   }

   public Iterator iterator() {
      return this.method_221().iterator();
   }

   public Object[] toArray() {
      Object var1 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().toArray();
      }
   }

   public Object[] toArray(Object[] var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().toArray(var1);
      }
   }

   public boolean remove(Object var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().remove(var1);
      }
   }

   public boolean removeAll(Collection var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().removeAll(var1);
      }
   }

   public boolean retainAll(Collection var1) {
      Object var2 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().retainAll(var1);
      }
   }

   public int size() {
      Object var1 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().size();
      }
   }

   public boolean equals(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public int hashCode() {
      Object var1 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().hashCode();
      }
   }

   public String toString() {
      Object var1 = this.field_94;
      synchronized(this.field_94) {
         return this.method_221().toString();
      }
   }
}
