package org.a.a.a;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: org.a.a.a.aA
public abstract class class_305 extends AbstractSet {
   public Iterator iterator() {
      return class_401.method_1189(this.method_742());
   }

   // $FF: renamed from: a () java.util.Iterator
   protected abstract Iterator method_742();

   public int size() {
      return class_401.method_1232(this.iterator());
   }

   // $FF: renamed from: a (java.util.Set) void
   public void method_743(Set var1) {
      class_415.method_1362(var1, this);
   }

   // $FF: renamed from: b () java.util.Set
   public Set method_744() {
      HashSet var1 = new HashSet(this.size());
      this.method_743(var1);
      return var1;
   }
}
