package org.apache.commons.collections4.set;

import java.util.Set;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

public class PredicatedSet extends PredicatedCollection implements Set {
   private static final long serialVersionUID = -684521469108685117L;

   public static PredicatedSet predicatedSet(Set set, Predicate predicate) {
      return new PredicatedSet(set, predicate);
   }

   protected PredicatedSet(Set set, Predicate predicate) {
      super(set, predicate);
   }

   protected Set decorated() {
      return (Set)super.decorated();
   }

   public boolean equals(Object object) {
      return object == this || this.decorated().equals(object);
   }

   public int hashCode() {
      return this.decorated().hashCode();
   }
}
