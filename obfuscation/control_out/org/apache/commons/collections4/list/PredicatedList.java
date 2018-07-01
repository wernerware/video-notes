package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

public class PredicatedList extends PredicatedCollection implements List {
   private static final long serialVersionUID = -5722039223898659102L;

   public static PredicatedList predicatedList(List list, Predicate predicate) {
      return new PredicatedList(list, predicate);
   }

   protected PredicatedList(List list, Predicate predicate) {
      super(list, predicate);
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

   public Object get(int index) {
      return this.decorated().get(index);
   }

   public int indexOf(Object object) {
      return this.decorated().indexOf(object);
   }

   public int lastIndexOf(Object object) {
      return this.decorated().lastIndexOf(object);
   }

   public Object remove(int index) {
      return this.decorated().remove(index);
   }

   public void add(int index, Object object) {
      this.validate(object);
      this.decorated().add(index, object);
   }

   public boolean addAll(int index, Collection coll) {
      Iterator i$ = coll.iterator();

      while(i$.hasNext()) {
         Object aColl = i$.next();
         this.validate(aColl);
      }

      return this.decorated().addAll(index, coll);
   }

   public ListIterator listIterator() {
      return this.listIterator(0);
   }

   public ListIterator listIterator(int i) {
      return new PredicatedList.PredicatedListIterator(this.decorated().listIterator(i));
   }

   public Object set(int index, Object object) {
      this.validate(object);
      return this.decorated().set(index, object);
   }

   public List subList(int fromIndex, int toIndex) {
      List sub = this.decorated().subList(fromIndex, toIndex);
      return new PredicatedList(sub, this.predicate);
   }

   protected class PredicatedListIterator extends AbstractListIteratorDecorator {
      protected PredicatedListIterator(ListIterator iterator) {
         super(iterator);
      }

      public void add(Object object) {
         PredicatedList.this.validate(object);
         this.getListIterator().add(object);
      }

      public void set(Object object) {
         PredicatedList.this.validate(object);
         this.getListIterator().set(object);
      }
   }
}
