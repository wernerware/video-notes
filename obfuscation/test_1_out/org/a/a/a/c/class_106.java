package org.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.a.a.a.class_1;
import org.a.a.a.class_22;
import org.a.a.a.class_28;
import org.a.a.a.a.class_364;
import org.a.a.a.a.class_88;
import org.a.a.a.h.class_82;
import org.a.a.a.k.class_373;
import org.a.a.a.k.class_86;
import org.a.a.a.l.class_87;
import org.a.a.a.n.class_83;

// $FF: renamed from: org.a.a.a.c.f
public class class_106 {
   // $FF: renamed from: a org.a.a.a.an
   private final class_1 field_101;
   // $FF: renamed from: b java.util.List
   private final List field_102 = new ArrayList();
   // $FF: renamed from: c java.util.List
   private final List field_103 = new ArrayList();

   public class_106(class_1 var1) {
      if (var1 == null) {
         throw new NullPointerException("Predicate must not be null");
      } else {
         this.field_101 = var1;
      }
   }

   // $FF: renamed from: a (java.lang.Object) org.a.a.a.c.f
   public class_106 method_228(Object var1) {
      if (this.field_101.method_3(var1)) {
         this.field_102.add(var1);
      } else {
         this.field_103.add(var1);
      }

      return this;
   }

   // $FF: renamed from: a (java.util.Collection) org.a.a.a.c.f
   public class_106 method_229(Collection var1) {
      if (var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.method_228(var3);
         }
      }

      return this;
   }

   // $FF: renamed from: a () java.util.List
   public List method_230() {
      return this.method_231(new ArrayList());
   }

   // $FF: renamed from: a (java.util.List) java.util.List
   public List method_231(List var1) {
      if (var1 == null) {
         throw new NullPointerException("List must not be null.");
      } else {
         class_82 var2 = class_82.method_172(var1, this.field_101);
         var2.addAll(this.field_102);
         return var2;
      }
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_232() {
      return this.method_233(new HashSet());
   }

   // $FF: renamed from: a (java.util.Set) java.util.Set
   public Set method_233(Set var1) {
      if (var1 == null) {
         throw new NullPointerException("Set must not be null.");
      } else {
         class_83 var2 = class_83.method_176(var1, this.field_101);
         var2.addAll(this.field_102);
         return var2;
      }
   }

   // $FF: renamed from: c () org.a.a.a.af
   public class_28 method_234() {
      return this.method_235(new class_373());
   }

   // $FF: renamed from: a (org.a.a.a.af) org.a.a.a.af
   public class_28 method_235(class_28 var1) {
      if (var1 == null) {
         throw new NullPointerException("MultiSet must not be null.");
      } else {
         class_86 var2 = class_86.method_182(var1, this.field_101);
         var2.addAll(this.field_102);
         return var2;
      }
   }

   // $FF: renamed from: d () org.a.a.a.b
   public class_22 method_236() {
      return this.method_237(new class_364());
   }

   // $FF: renamed from: a (org.a.a.a.b) org.a.a.a.b
   public class_22 method_237(class_22 var1) {
      if (var1 == null) {
         throw new NullPointerException("Bag must not be null.");
      } else {
         class_88 var2 = class_88.method_186(var1, this.field_101);
         var2.addAll(this.field_102);
         return var2;
      }
   }

   // $FF: renamed from: e () java.util.Queue
   public Queue method_238() {
      return this.method_239(new LinkedList());
   }

   // $FF: renamed from: a (java.util.Queue) java.util.Queue
   public Queue method_239(Queue var1) {
      if (var1 == null) {
         throw new NullPointerException("queue must not be null");
      } else {
         class_87 var2 = class_87.method_184(var1, this.field_101);
         var2.addAll(this.field_102);
         return var2;
      }
   }

   // $FF: renamed from: f () java.util.Collection
   public Collection method_240() {
      return Collections.unmodifiableCollection(this.field_103);
   }
}
