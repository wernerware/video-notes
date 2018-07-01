package org.apache.commons.collections4.multimap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.ListValuedMap;

public abstract class AbstractListValuedMap extends AbstractMultiValuedMap implements ListValuedMap {
   protected AbstractListValuedMap() {
   }

   protected AbstractListValuedMap(Map map) {
      super(map);
   }

   protected Map getMap() {
      return super.getMap();
   }

   protected abstract List createCollection();

   public List get(Object key) {
      return this.wrappedCollection(key);
   }

   List wrappedCollection(Object key) {
      return new AbstractListValuedMap.WrappedList(key);
   }

   public List remove(Object key) {
      return ListUtils.emptyIfNull((List)this.getMap().remove(key));
   }

   private class ValuesListIterator implements ListIterator {
      private final Object key;
      private List values;
      private ListIterator iterator;

      public ValuesListIterator(Object key) {
         this.key = key;
         this.values = ListUtils.emptyIfNull((List)AbstractListValuedMap.this.getMap().get(key));
         this.iterator = this.values.listIterator();
      }

      public ValuesListIterator(Object key, int index) {
         this.key = key;
         this.values = ListUtils.emptyIfNull((List)AbstractListValuedMap.this.getMap().get(key));
         this.iterator = this.values.listIterator(index);
      }

      public void add(Object value) {
         if (AbstractListValuedMap.this.getMap().get(this.key) == null) {
            List list = AbstractListValuedMap.this.createCollection();
            AbstractListValuedMap.this.getMap().put(this.key, list);
            this.values = list;
            this.iterator = list.listIterator();
         }

         this.iterator.add(value);
      }

      public boolean hasNext() {
         return this.iterator.hasNext();
      }

      public boolean hasPrevious() {
         return this.iterator.hasPrevious();
      }

      public Object next() {
         return this.iterator.next();
      }

      public int nextIndex() {
         return this.iterator.nextIndex();
      }

      public Object previous() {
         return this.iterator.previous();
      }

      public int previousIndex() {
         return this.iterator.previousIndex();
      }

      public void remove() {
         this.iterator.remove();
         if (this.values.isEmpty()) {
            AbstractListValuedMap.this.getMap().remove(this.key);
         }

      }

      public void set(Object value) {
         this.iterator.set(value);
      }
   }

   private class WrappedList extends AbstractMultiValuedMap.WrappedCollection implements List {
      public WrappedList(Object key) {
         super(key);
      }

      protected List getMapping() {
         return (List)AbstractListValuedMap.this.getMap().get(this.key);
      }

      public void add(int index, Object value) {
         List list = this.getMapping();
         if (list == null) {
            list = AbstractListValuedMap.this.createCollection();
            AbstractListValuedMap.this.getMap().put(this.key, list);
         }

         list.add(index, value);
      }

      public boolean addAll(int index, Collection c) {
         List list = this.getMapping();
         if (list == null) {
            list = AbstractListValuedMap.this.createCollection();
            boolean changed = list.addAll(index, c);
            if (changed) {
               AbstractListValuedMap.this.getMap().put(this.key, list);
            }

            return changed;
         } else {
            return list.addAll(index, c);
         }
      }

      public Object get(int index) {
         List list = ListUtils.emptyIfNull(this.getMapping());
         return list.get(index);
      }

      public int indexOf(Object o) {
         List list = ListUtils.emptyIfNull(this.getMapping());
         return list.indexOf(o);
      }

      public int lastIndexOf(Object o) {
         List list = ListUtils.emptyIfNull(this.getMapping());
         return list.lastIndexOf(o);
      }

      public ListIterator listIterator() {
         return AbstractListValuedMap.this.new ValuesListIterator(this.key);
      }

      public ListIterator listIterator(int index) {
         return AbstractListValuedMap.this.new ValuesListIterator(this.key, index);
      }

      public Object remove(int index) {
         List list = ListUtils.emptyIfNull(this.getMapping());
         Object value = list.remove(index);
         if (list.isEmpty()) {
            AbstractListValuedMap.this.remove(this.key);
         }

         return value;
      }

      public Object set(int index, Object value) {
         List list = ListUtils.emptyIfNull(this.getMapping());
         return list.set(index, value);
      }

      public List subList(int fromIndex, int toIndex) {
         List list = ListUtils.emptyIfNull(this.getMapping());
         return list.subList(fromIndex, toIndex);
      }

      public boolean equals(Object other) {
         List list = this.getMapping();
         if (list == null) {
            return Collections.emptyList().equals(other);
         } else if (!(other instanceof List)) {
            return false;
         } else {
            List otherList = (List)other;
            return ListUtils.isEqualList(list, otherList);
         }
      }

      public int hashCode() {
         List list = this.getMapping();
         return ListUtils.hashCodeForList(list);
      }
   }
}
