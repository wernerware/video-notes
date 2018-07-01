package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.SortedBag;

public class PredicatedSortedBag extends PredicatedBag implements SortedBag {
   private static final long serialVersionUID = 3448581314086406616L;

   public static PredicatedSortedBag predicatedSortedBag(SortedBag bag, Predicate predicate) {
      return new PredicatedSortedBag(bag, predicate);
   }

   protected PredicatedSortedBag(SortedBag bag, Predicate predicate) {
      super(bag, predicate);
   }

   protected SortedBag decorated() {
      return (SortedBag)super.decorated();
   }

   public Object first() {
      return this.decorated().first();
   }

   public Object last() {
      return this.decorated().last();
   }

   public Comparator comparator() {
      return this.decorated().comparator();
   }
}
