package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

public abstract class AbstractListDecorator extends AbstractCollectionDecorator implements List {
   private static final long serialVersionUID = 4500739654952315623L;

   protected AbstractListDecorator() {
   }

   protected AbstractListDecorator(List list) {
      super(list);
   }

   protected List decorated() {
      return (List)super.decorated();
   }

   public boolean equals(Object object) {
      return object == this || this.decorated().equals(object);
   }

   public int hashCode() {
      return this.decorated().hashCode();
   }

   public void add(int index, Object object) {
      this.decorated().add(index, object);
   }

   public boolean addAll(int index, Collection coll) {
      return this.decorated().addAll(index, coll);
   }

   public Object get(int index) {
      return this.decorated().get(index);
   }

   public int indexOf(Object object) {
      return this.decorated().indexOf(object);
   }

   public int lastIndexOf(Object object) {
      return this.decorated().lastIndexOf(object);
   }

   public ListIterator listIterator() {
      return this.decorated().listIterator();
   }

   public ListIterator listIterator(int index) {
      return this.decorated().listIterator(index);
   }

   public Object remove(int index) {
      return this.decorated().remove(index);
   }

   public Object set(int index, Object object) {
      return this.decorated().set(index, object);
   }

   public List subList(int fromIndex, int toIndex) {
      return this.decorated().subList(fromIndex, toIndex);
   }
}
