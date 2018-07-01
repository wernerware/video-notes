package org.apache.commons.collections4.map;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EntrySetToMapIteratorAdapter implements MapIterator, ResettableIterator {
   Set entrySet;
   transient Iterator iterator;
   transient Entry entry;

   public EntrySetToMapIteratorAdapter(Set entrySet) {
      this.entrySet = entrySet;
      this.reset();
   }

   public Object getKey() {
      return this.current().getKey();
   }

   public Object getValue() {
      return this.current().getValue();
   }

   public Object setValue(Object value) {
      return this.current().setValue(value);
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public Object next() {
      this.entry = (Entry)this.iterator.next();
      return this.getKey();
   }

   public synchronized void reset() {
      this.iterator = this.entrySet.iterator();
   }

   public void remove() {
      this.iterator.remove();
      this.entry = null;
   }

   protected synchronized Entry current() {
      if (this.entry == null) {
         throw new IllegalStateException();
      } else {
         return this.entry;
      }
   }
}
