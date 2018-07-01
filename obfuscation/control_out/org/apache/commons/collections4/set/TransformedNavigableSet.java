package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Transformer;

public class TransformedNavigableSet extends TransformedSortedSet implements NavigableSet {
   private static final long serialVersionUID = 20150528L;

   public static TransformedNavigableSet transformingNavigableSet(NavigableSet set, Transformer transformer) {
      return new TransformedNavigableSet(set, transformer);
   }

   public static TransformedNavigableSet transformedNavigableSet(NavigableSet set, Transformer transformer) {
      TransformedNavigableSet decorated = new TransformedNavigableSet(set, transformer);
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

   protected TransformedNavigableSet(NavigableSet set, Transformer transformer) {
      super(set, transformer);
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
      return transformingNavigableSet(this.decorated().descendingSet(), this.transformer);
   }

   public Iterator descendingIterator() {
      return this.decorated().descendingIterator();
   }

   public NavigableSet subSet(Object fromElement, boolean fromInclusive, Object toElement, boolean toInclusive) {
      NavigableSet sub = this.decorated().subSet(fromElement, fromInclusive, toElement, toInclusive);
      return transformingNavigableSet(sub, this.transformer);
   }

   public NavigableSet headSet(Object toElement, boolean inclusive) {
      NavigableSet head = this.decorated().headSet(toElement, inclusive);
      return transformingNavigableSet(head, this.transformer);
   }

   public NavigableSet tailSet(Object fromElement, boolean inclusive) {
      NavigableSet tail = this.decorated().tailSet(fromElement, inclusive);
      return transformingNavigableSet(tail, this.transformer);
   }
}
