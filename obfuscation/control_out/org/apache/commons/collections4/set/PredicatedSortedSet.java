package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Predicate;

public class PredicatedSortedSet extends PredicatedSet implements SortedSet {
   private static final long serialVersionUID = -9110948148132275052L;

   public static PredicatedSortedSet predicatedSortedSet(SortedSet set, Predicate predicate) {
      return new PredicatedSortedSet(set, predicate);
   }

   protected PredicatedSortedSet(SortedSet set, Predicate predicate) {
      super(set, predicate);
   }

   protected SortedSet decorated() {
      return (SortedSet)super.decorated();
   }

   public Comparator comparator() {
      return this.decorated().comparator();
   }

   public Object first() {
      return this.decorated().first();
   }

   public Object last() {
      return this.decorated().last();
   }

   public SortedSet subSet(Object fromElement, Object toElement) {
      SortedSet sub = this.decorated().subSet(fromElement, toElement);
      return new PredicatedSortedSet(sub, this.predicate);
   }

   public SortedSet headSet(Object toElement) {
      SortedSet head = this.decorated().headSet(toElement);
      return new PredicatedSortedSet(head, this.predicate);
   }

   public SortedSet tailSet(Object fromElement) {
      SortedSet tail = this.decorated().tailSet(fromElement);
      return new PredicatedSortedSet(tail, this.predicate);
   }
}
