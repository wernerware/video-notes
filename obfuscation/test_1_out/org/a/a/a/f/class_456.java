package org.a.a.a.f;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// $FF: renamed from: org.a.a.a.f.C
public class class_456 implements Iterator {
   // $FF: renamed from: a org.w3c.dom.NodeList
   private final NodeList field_831;
   // $FF: renamed from: b int
   private int field_832 = 0;

   public class_456(Node var1) {
      if (var1 == null) {
         throw new NullPointerException("Node must not be null.");
      } else {
         this.field_831 = var1.getChildNodes();
      }
   }

   public class_456(NodeList var1) {
      if (var1 == null) {
         throw new NullPointerException("NodeList must not be null.");
      } else {
         this.field_831 = var1;
      }
   }

   public boolean hasNext() {
      return this.field_831 == null ? false : this.field_832 < this.field_831.getLength();
   }

   // $FF: renamed from: a () org.w3c.dom.Node
   public Node method_1539() {
      if (this.field_831 != null && this.field_832 < this.field_831.getLength()) {
         return this.field_831.item(this.field_832++);
      } else {
         throw new NoSuchElementException("underlying nodeList has no more elements");
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("remove() method not supported for a NodeListIterator.");
   }

   // $FF: synthetic method
   public Object next() {
      return this.method_1539();
   }
}
