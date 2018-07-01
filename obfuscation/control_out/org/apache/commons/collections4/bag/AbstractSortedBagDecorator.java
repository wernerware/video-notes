package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.SortedBag;

public abstract class AbstractSortedBagDecorator extends AbstractBagDecorator implements SortedBag {
   private static final long serialVersionUID = -8223473624050467718L;

   protected AbstractSortedBagDecorator() {
   }

   protected AbstractSortedBagDecorator(SortedBag bag) {
      super(bag);
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
