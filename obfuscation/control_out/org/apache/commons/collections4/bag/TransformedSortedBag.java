package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.Transformer;

public class TransformedSortedBag extends TransformedBag implements SortedBag {
   private static final long serialVersionUID = -251737742649401930L;

   public static TransformedSortedBag transformingSortedBag(SortedBag bag, Transformer transformer) {
      return new TransformedSortedBag(bag, transformer);
   }

   public static TransformedSortedBag transformedSortedBag(SortedBag bag, Transformer transformer) {
      TransformedSortedBag decorated = new TransformedSortedBag(bag, transformer);
      if (bag.size() > 0) {
         Object[] values = (Object[])bag.toArray();
         bag.clear();
         Object[] arr$ = values;
         int len$ = values.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Object value = arr$[i$];
            decorated.decorated().add(transformer.transform(value));
         }
      }

      return decorated;
   }

   protected TransformedSortedBag(SortedBag bag, Transformer transformer) {
      super(bag, transformer);
   }

   protected SortedBag getSortedBag() {
      return (SortedBag)this.decorated();
   }

   public Object first() {
      return this.getSortedBag().first();
   }

   public Object last() {
      return this.getSortedBag().last();
   }

   public Comparator comparator() {
      return this.getSortedBag().comparator();
   }
}
