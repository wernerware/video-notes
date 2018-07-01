package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedBag extends PredicatedCollection implements Bag {
   private static final long serialVersionUID = -2575833140344736876L;

   public static PredicatedBag predicatedBag(Bag bag, Predicate predicate) {
      return new PredicatedBag(bag, predicate);
   }

   protected PredicatedBag(Bag bag, Predicate predicate) {
      super(bag, predicate);
   }

   protected Bag decorated() {
      return (Bag)super.decorated();
   }

   public boolean equals(Object object) {
      return object == this || this.decorated().equals(object);
   }

   public int hashCode() {
      return this.decorated().hashCode();
   }

   public boolean add(Object object, int count) {
      this.validate(object);
      return this.decorated().add(object, count);
   }

   public boolean remove(Object object, int count) {
      return this.decorated().remove(object, count);
   }

   public Set uniqueSet() {
      return this.decorated().uniqueSet();
   }

   public int getCount(Object object) {
      return this.decorated().getCount(object);
   }
}
