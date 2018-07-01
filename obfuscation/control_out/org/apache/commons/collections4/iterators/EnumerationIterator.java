package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {
   private final Collection collection;
   private Enumeration enumeration;
   private Object last;

   public EnumerationIterator() {
      this((Enumeration)null, (Collection)null);
   }

   public EnumerationIterator(Enumeration enumeration) {
      this(enumeration, (Collection)null);
   }

   public EnumerationIterator(Enumeration enumeration, Collection collection) {
      this.enumeration = enumeration;
      this.collection = collection;
      this.last = null;
   }

   public boolean hasNext() {
      return this.enumeration.hasMoreElements();
   }

   public Object next() {
      this.last = this.enumeration.nextElement();
      return this.last;
   }

   public void remove() {
      if (this.collection != null) {
         if (this.last != null) {
            this.collection.remove(this.last);
         } else {
            throw new IllegalStateException("next() must have been called for remove() to function");
         }
      } else {
         throw new UnsupportedOperationException("No Collection associated with this Iterator");
      }
   }

   public Enumeration getEnumeration() {
      return this.enumeration;
   }

   public void setEnumeration(Enumeration enumeration) {
      this.enumeration = enumeration;
   }
}
