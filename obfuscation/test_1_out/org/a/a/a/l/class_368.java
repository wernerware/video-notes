package org.a.a.a.l;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.a.a.a.class_35;

// $FF: renamed from: org.a.a.a.l.b
public class class_368 extends AbstractCollection implements Serializable, Queue, class_35 {
   // $FF: renamed from: a long
   private static final long field_636 = -8423413834657610406L;
   // $FF: renamed from: b java.lang.Object[]
   private transient Object[] field_637;
   // $FF: renamed from: c int
   private transient int field_638;
   // $FF: renamed from: d int
   private transient int field_639;
   // $FF: renamed from: e boolean
   private transient boolean field_640;
   // $FF: renamed from: f int
   private final int field_641;

   public class_368() {
      this(32);
   }

   public class_368(int var1) {
      this.field_638 = 0;
      this.field_639 = 0;
      this.field_640 = false;
      if (var1 <= 0) {
         throw new IllegalArgumentException("The size must be greater than 0");
      } else {
         this.field_637 = (Object[])(new Object[var1]);
         this.field_641 = this.field_637.length;
      }
   }

   public class_368(Collection var1) {
      this(var1.size());
      this.addAll(var1);
   }

   // $FF: renamed from: a (java.io.ObjectOutputStream) void
   private void method_1076(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeInt(this.size());
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         var1.writeObject(var3);
      }

   }

   // $FF: renamed from: a (java.io.ObjectInputStream) void
   private void method_1077(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.field_637 = (Object[])(new Object[this.field_641]);
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_637[var3] = var1.readObject();
      }

      this.field_638 = 0;
      this.field_640 = var2 == this.field_641;
      if (this.field_640) {
         this.field_639 = 0;
      } else {
         this.field_639 = var2;
      }

   }

   public int size() {
      boolean var1 = false;
      int var2;
      if (this.field_639 < this.field_638) {
         var2 = this.field_641 - this.field_638 + this.field_639;
      } else if (this.field_639 == this.field_638) {
         var2 = this.field_640 ? this.field_641 : 0;
      } else {
         var2 = this.field_639 - this.field_638;
      }

      return var2;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   // $FF: renamed from: a () boolean
   public boolean method_71() {
      return false;
   }

   // $FF: renamed from: c () boolean
   public boolean method_1078() {
      return this.size() == this.field_641;
   }

   // $FF: renamed from: b () int
   public int method_72() {
      return this.field_641;
   }

   public void clear() {
      this.field_640 = false;
      this.field_638 = 0;
      this.field_639 = 0;
      Arrays.fill(this.field_637, (Object)null);
   }

   public boolean add(Object var1) {
      if (null == var1) {
         throw new NullPointerException("Attempted to add null object to queue");
      } else {
         if (this.method_1078()) {
            this.remove();
         }

         this.field_637[this.field_639++] = var1;
         if (this.field_639 >= this.field_641) {
            this.field_639 = 0;
         }

         if (this.field_639 == this.field_638) {
            this.field_640 = true;
         }

         return true;
      }
   }

   // $FF: renamed from: a (int) java.lang.Object
   public Object method_1079(int var1) {
      int var2 = this.size();
      if (var1 >= 0 && var1 < var2) {
         int var3 = (this.field_638 + var1) % this.field_641;
         return this.field_637[var3];
      } else {
         throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", var1, var2));
      }
   }

   public boolean offer(Object var1) {
      return this.add(var1);
   }

   public Object poll() {
      return this.isEmpty() ? null : this.remove();
   }

   public Object element() {
      if (this.isEmpty()) {
         throw new NoSuchElementException("queue is empty");
      } else {
         return this.peek();
      }
   }

   public Object peek() {
      return this.isEmpty() ? null : this.field_637[this.field_638];
   }

   public Object remove() {
      if (this.isEmpty()) {
         throw new NoSuchElementException("queue is empty");
      } else {
         Object var1 = this.field_637[this.field_638];
         if (null != var1) {
            this.field_637[this.field_638++] = null;
            if (this.field_638 >= this.field_641) {
               this.field_638 = 0;
            }

            this.field_640 = false;
         }

         return var1;
      }
   }

   // $FF: renamed from: b (int) int
   private int method_1080(int var1) {
      ++var1;
      if (var1 >= this.field_641) {
         var1 = 0;
      }

      return var1;
   }

   // $FF: renamed from: c (int) int
   private int method_1081(int var1) {
      --var1;
      if (var1 < 0) {
         var1 = this.field_641 - 1;
      }

      return var1;
   }

   public Iterator iterator() {
      return new class_369(this);
   }

   // $FF: renamed from: a (org.a.a.a.l.b) int
   // $FF: synthetic method
   static int method_1082(class_368 var0) {
      return var0.field_638;
   }

   // $FF: renamed from: b (org.a.a.a.l.b) boolean
   // $FF: synthetic method
   static boolean method_1083(class_368 var0) {
      return var0.field_640;
   }

   // $FF: renamed from: c (org.a.a.a.l.b) int
   // $FF: synthetic method
   static int method_1084(class_368 var0) {
      return var0.field_639;
   }

   // $FF: renamed from: a (org.a.a.a.l.b, int) int
   // $FF: synthetic method
   static int method_1085(class_368 var0, int var1) {
      return var0.method_1080(var1);
   }

   // $FF: renamed from: d (org.a.a.a.l.b) java.lang.Object[]
   // $FF: synthetic method
   static Object[] method_1086(class_368 var0) {
      return var0.field_637;
   }

   // $FF: renamed from: e (org.a.a.a.l.b) int
   // $FF: synthetic method
   static int method_1087(class_368 var0) {
      return var0.field_641;
   }

   // $FF: renamed from: b (org.a.a.a.l.b, int) int
   // $FF: synthetic method
   static int method_1088(class_368 var0, int var1) {
      return var0.method_1081(var1);
   }

   // $FF: renamed from: c (org.a.a.a.l.b, int) int
   // $FF: synthetic method
   static int method_1089(class_368 var0, int var1) {
      return var0.field_639 = var1;
   }

   // $FF: renamed from: a (org.a.a.a.l.b, boolean) boolean
   // $FF: synthetic method
   static boolean method_1090(class_368 var0, boolean var1) {
      return var0.field_640 = var1;
   }
}
