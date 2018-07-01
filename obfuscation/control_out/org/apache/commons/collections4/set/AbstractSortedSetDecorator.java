package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

public abstract class AbstractSortedSetDecorator extends AbstractSetDecorator implements SortedSet {
   private static final long serialVersionUID = -3462240946294214398L;

   protected AbstractSortedSetDecorator() {
   }

   protected AbstractSortedSetDecorator(Set set) {
      super(set);
   }

   protected SortedSet decorated() {
      return (SortedSet)super.decorated();
   }

   public SortedSet subSet(Object fromElement, Object toElement) {
      return this.decorated().subSet(fromElement, toElement);
   }

   public SortedSet headSet(Object toElement) {
      return this.decorated().headSet(toElement);
   }

   public SortedSet tailSet(Object fromElement) {
      return this.decorated().tailSet(fromElement);
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
