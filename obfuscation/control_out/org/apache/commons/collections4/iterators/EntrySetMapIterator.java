package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EntrySetMapIterator implements MapIterator, ResettableIterator {
   private final Map map;
   private Iterator iterator;
   private Entry last;
   private boolean canRemove = false;

   public EntrySetMapIterator(Map map) {
      this.map = map;
      this.iterator = map.entrySet().iterator();
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public Object next() {
      this.last = (Entry)this.iterator.next();
      this.canRemove = true;
      return this.last.getKey();
   }

   public void remove() {
      if (!this.canRemove) {
         throw new IllegalStateException("Iterator remove() can only be called once after next()");
      } else {
         this.iterator.remove();
         this.last = null;
         this.canRemove = false;
      }
   }

   public Object getKey() {
      if (this.last == null) {
         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
      } else {
         return this.last.getKey();
      }
   }

   public Object getValue() {
      if (this.last == null) {
         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
      } else {
         return this.last.getValue();
      }
   }

   public Object setValue(Object value) {
      if (this.last == null) {
         throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
      } else {
         return this.last.setValue(value);
      }
   }

   public void reset() {
      this.iterator = this.map.entrySet().iterator();
      this.last = null;
      this.canRemove = false;
   }

   public String toString() {
      return this.last != null ? "MapIterator[" + this.getKey() + "=" + this.getValue() + "]" : "MapIterator[]";
   }
}
