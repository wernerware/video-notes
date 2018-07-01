package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;

public abstract class AbstractNavigableSetDecorator extends AbstractSortedSetDecorator implements NavigableSet {
   private static final long serialVersionUID = 20150528L;

   protected AbstractNavigableSetDecorator() {
   }

   protected AbstractNavigableSetDecorator(NavigableSet set) {
      super(set);
   }

   protected NavigableSet decorated() {
      return (NavigableSet)super.decorated();
   }

   public Object lower(Object e) {
      return this.decorated().lower(e);
   }

   public Object floor(Object e) {
      return this.decorated().floor(e);
   }

   public Object ceiling(Object e) {
      return this.decorated().ceiling(e);
   }

   public Object higher(Object e) {
      return this.decorated().higher(e);
   }

   public Object pollFirst() {
      return this.decorated().pollFirst();
   }

   public Object pollLast() {
      return this.decorated().pollLast();
   }

   public NavigableSet descendingSet() {
      return this.decorated().descendingSet();
   }

   public Iterator descendingIterator() {
      return this.decorated().descendingIterator();
   }

   public NavigableSet subSet(Object fromElement, boolean fromInclusive, Object toElement, boolean toInclusive) {
      return this.decorated().subSet(fromElement, fromInclusive, toElement, toInclusive);
   }

   public NavigableSet headSet(Object toElement, boolean inclusive) {
      return this.decorated().headSet(toElement, inclusive);
   }

   public NavigableSet tailSet(Object fromElement, boolean inclusive) {
      return this.decorated().tailSet(fromElement, inclusive);
   }
}
