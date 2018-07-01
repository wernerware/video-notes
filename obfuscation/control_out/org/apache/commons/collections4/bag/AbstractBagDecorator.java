package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

public abstract class AbstractBagDecorator extends AbstractCollectionDecorator implements Bag {
   private static final long serialVersionUID = -3768146017343785417L;

   protected AbstractBagDecorator() {
   }

   protected AbstractBagDecorator(Bag bag) {
      super(bag);
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

   public int getCount(Object object) {
      return this.decorated().getCount(object);
   }

   public boolean add(Object object, int count) {
      return this.decorated().add(object, count);
   }

   public boolean remove(Object object, int count) {
      return this.decorated().remove(object, count);
   }

   public Set uniqueSet() {
      return this.decorated().uniqueSet();
   }
}
