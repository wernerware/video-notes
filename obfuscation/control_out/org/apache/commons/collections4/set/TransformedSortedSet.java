package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Transformer;

public class TransformedSortedSet extends TransformedSet implements SortedSet {
   private static final long serialVersionUID = -1675486811351124386L;

   public static TransformedSortedSet transformingSortedSet(SortedSet set, Transformer transformer) {
      return new TransformedSortedSet(set, transformer);
   }

   public static TransformedSortedSet transformedSortedSet(SortedSet set, Transformer transformer) {
      TransformedSortedSet decorated = new TransformedSortedSet(set, transformer);
      if (set.size() > 0) {
         Object[] values = (Object[])set.toArray();
         set.clear();
         Object[] arr$ = values;
         int len$ = values.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Object value = arr$[i$];
            decorated.decorated().add(transformer.transform(value));
         }
      }

      return decorated;
   }

   protected TransformedSortedSet(SortedSet set, Transformer transformer) {
      super(set, transformer);
   }

   protected SortedSet getSortedSet() {
      return (SortedSet)this.decorated();
   }

   public Object first() {
      return this.getSortedSet().first();
   }

   public Object last() {
      return this.getSortedSet().last();
   }

   public Comparator comparator() {
      return this.getSortedSet().comparator();
   }

   public SortedSet subSet(Object fromElement, Object toElement) {
      SortedSet set = this.getSortedSet().subSet(fromElement, toElement);
      return new TransformedSortedSet(set, this.transformer);
   }

   public SortedSet headSet(Object toElement) {
      SortedSet set = this.getSortedSet().headSet(toElement);
      return new TransformedSortedSet(set, this.transformer);
   }

   public SortedSet tailSet(Object fromElement) {
      SortedSet set = this.getSortedSet().tailSet(fromElement);
      return new TransformedSortedSet(set, this.transformer);
   }
}
