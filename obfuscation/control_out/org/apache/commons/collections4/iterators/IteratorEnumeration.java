package org.apache.commons.collections4.iterators;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration implements Enumeration {
   private Iterator iterator;

   public IteratorEnumeration() {
   }

   public IteratorEnumeration(Iterator iterator) {
      this.iterator = iterator;
   }

   public boolean hasMoreElements() {
      return this.iterator.hasNext();
   }

   public Object nextElement() {
      return this.iterator.next();
   }

   public Iterator getIterator() {
      return this.iterator;
   }

   public void setIterator(Iterator iterator) {
      this.iterator = iterator;
   }
}
