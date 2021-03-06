package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedMultiSet extends PredicatedCollection implements MultiSet {
   private static final long serialVersionUID = 20150629L;

   public static PredicatedMultiSet predicatedMultiSet(MultiSet multiset, Predicate predicate) {
      return new PredicatedMultiSet(multiset, predicate);
   }

   protected PredicatedMultiSet(MultiSet multiset, Predicate predicate) {
      super(multiset, predicate);
   }

   protected MultiSet decorated() {
      return (MultiSet)super.decorated();
   }

   public boolean equals(Object object) {
      return object == this || this.decorated().equals(object);
   }

   public int hashCode() {
      return this.decorated().hashCode();
   }

   public int add(Object object, int count) {
      this.validate(object);
      return this.decorated().add(object, count);
   }

   public int remove(Object object, int count) {
      return this.decorated().remove(object, count);
   }

   public int getCount(Object object) {
      return this.decorated().getCount(object);
   }

   public int setCount(Object object, int count) {
      this.validate(object);
      return this.decorated().setCount(object, count);
   }

   public Set uniqueSet() {
      return this.decorated().uniqueSet();
   }

   public Set entrySet() {
      return this.decorated().entrySet();
   }
}
