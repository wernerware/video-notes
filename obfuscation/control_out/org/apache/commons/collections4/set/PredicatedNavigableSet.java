package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Predicate;

public class PredicatedNavigableSet extends PredicatedSortedSet implements NavigableSet {
   private static final long serialVersionUID = 20150528L;

   public static PredicatedNavigableSet predicatedNavigableSet(NavigableSet set, Predicate predicate) {
      return new PredicatedNavigableSet(set, predicate);
   }

   protected PredicatedNavigableSet(NavigableSet set, Predicate predicate) {
      super(set, predicate);
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
      return predicatedNavigableSet(this.decorated().descendingSet(), this.predicate);
   }

   public Iterator descendingIterator() {
      return this.decorated().descendingIterator();
   }

   public NavigableSet subSet(Object fromElement, boolean fromInclusive, Object toElement, boolean toInclusive) {
      NavigableSet sub = this.decorated().subSet(fromElement, fromInclusive, toElement, toInclusive);
      return predicatedNavigableSet(sub, this.predicate);
   }

   public NavigableSet headSet(Object toElement, boolean inclusive) {
      NavigableSet head = this.decorated().headSet(toElement, inclusive);
      return predicatedNavigableSet(head, this.predicate);
   }

   public NavigableSet tailSet(Object fromElement, boolean inclusive) {
      NavigableSet tail = this.decorated().tailSet(fromElement, inclusive);
      return predicatedNavigableSet(tail, this.predicate);
   }
}
