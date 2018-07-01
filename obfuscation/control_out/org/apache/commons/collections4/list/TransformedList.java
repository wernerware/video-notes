package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

public class TransformedList extends TransformedCollection implements List {
   private static final long serialVersionUID = 1077193035000013141L;

   public static TransformedList transformingList(List list, Transformer transformer) {
      return new TransformedList(list, transformer);
   }

   public static TransformedList transformedList(List list, Transformer transformer) {
      TransformedList decorated = new TransformedList(list, transformer);
      if (list.size() > 0) {
         Object[] values = (Object[])list.toArray();
         list.clear();
         Object[] arr$ = values;
         int len$ = values.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            Object value = arr$[i$];
            decorated.decorated().add(transformer.transform(value));
         }
      }

      return decorated;
   }

   protected TransformedList(List list, Transformer transformer) {
      super(list, transformer);
   }

   protected List getList() {
      return (List)this.decorated();
   }

   public boolean equals(Object object) {
      return object == this || this.decorated().equals(object);
   }

   public int hashCode() {
      return this.decorated().hashCode();
   }

   public Object get(int index) {
      return this.getList().get(index);
   }

   public int indexOf(Object object) {
      return this.getList().indexOf(object);
   }

   public int lastIndexOf(Object object) {
      return this.getList().lastIndexOf(object);
   }

   public Object remove(int index) {
      return this.getList().remove(index);
   }

   public void add(int index, Object object) {
      object = this.transform(object);
      this.getList().add(index, object);
   }

   public boolean addAll(int index, Collection coll) {
      coll = this.transform(coll);
      return this.getList().addAll(index, coll);
   }

   public ListIterator listIterator() {
      return this.listIterator(0);
   }

   public ListIterator listIterator(int i) {
      return new TransformedList.TransformedListIterator(this.getList().listIterator(i));
   }

   public Object set(int index, Object object) {
      object = this.transform(object);
      return this.getList().set(index, object);
   }

   public List subList(int fromIndex, int toIndex) {
      List sub = this.getList().subList(fromIndex, toIndex);
      return new TransformedList(sub, this.transformer);
   }

   protected class TransformedListIterator extends AbstractListIteratorDecorator {
      protected TransformedListIterator(ListIterator iterator) {
         super(iterator);
      }

      public void add(Object object) {
         object = TransformedList.this.transform(object);
         this.getListIterator().add(object);
      }

      public void set(Object object) {
         object = TransformedList.this.transform(object);
         this.getListIterator().set(object);
      }
   }
}
