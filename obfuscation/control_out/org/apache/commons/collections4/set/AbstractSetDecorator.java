package org.apache.commons.collections4.set;

import java.util.Set;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

public abstract class AbstractSetDecorator extends AbstractCollectionDecorator implements Set {
   private static final long serialVersionUID = -4678668309576958546L;

   protected AbstractSetDecorator() {
   }

   protected AbstractSetDecorator(Set set) {
      super(set);
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
