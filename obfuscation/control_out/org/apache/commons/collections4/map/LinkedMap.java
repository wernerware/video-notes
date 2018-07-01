package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.list.UnmodifiableList;

public class LinkedMap extends AbstractLinkedMap implements Serializable, Cloneable {
   private static final long serialVersionUID = 9077234323521161066L;

   public LinkedMap() {
      super(16, 0.75F, 12);
   }

   public LinkedMap(int initialCapacity) {
      super(initialCapacity);
   }

   public LinkedMap(int initialCapacity, float loadFactor) {
      super(initialCapacity, loadFactor);
   }

   public LinkedMap(Map map) {
      super(map);
   }

   public LinkedMap clone() {
      return (LinkedMap)super.clone();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      this.doWriteObject(out);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.doReadObject(in);
   }

   public Object get(int index) {
      return this.getEntry(index).getKey();
   }

   public Object getValue(int index) {
      return this.getEntry(index).getValue();
   }

   public int indexOf(Object key) {
      key = this.convertKey(key);
      int i = 0;

      for(AbstractLinkedMap.LinkEntry entry = this.header.after; entry != this.header; ++i) {
         if (this.isEqualKey(key, entry.key)) {
            return i;
         }

         entry = entry.after;
      }

      return -1;
   }

   public Object remove(int index) {
      return this.remove(this.get(index));
   }

   public List asList() {
      return new LinkedMap.LinkedMapList(this);
   }

   static class LinkedMapList extends AbstractList {
      private final LinkedMap parent;

      LinkedMapList(LinkedMap parent) {
         this.parent = parent;
      }

      public int size() {
         return this.parent.size();
      }

      public Object get(int index) {
         return this.parent.get(index);
      }

      public boolean contains(Object obj) {
         return this.parent.containsKey(obj);
      }

      public int indexOf(Object obj) {
         return this.parent.indexOf(obj);
      }

      public int lastIndexOf(Object obj) {
         return this.parent.indexOf(obj);
      }

      public boolean containsAll(Collection coll) {
         return this.parent.keySet().containsAll(coll);
      }

      public Object remove(int index) {
         throw new UnsupportedOperationException();
      }

      public boolean remove(Object obj) {
         throw new UnsupportedOperationException();
      }

      public boolean removeAll(Collection coll) {
         throw new UnsupportedOperationException();
      }

      public boolean retainAll(Collection coll) {
         throw new UnsupportedOperationException();
      }

      public void clear() {
         throw new UnsupportedOperationException();
      }

      public Object[] toArray() {
         return this.parent.keySet().toArray();
      }

      public Object[] toArray(Object[] array) {
         return this.parent.keySet().toArray(array);
      }

      public Iterator iterator() {
         return UnmodifiableIterator.unmodifiableIterator(this.parent.keySet().iterator());
      }

      public ListIterator listIterator() {
         return UnmodifiableListIterator.umodifiableListIterator(super.listIterator());
      }

      public ListIterator listIterator(int fromIndex) {
         return UnmodifiableListIterator.umodifiableListIterator(super.listIterator(fromIndex));
      }

      public List subList(int fromIndexInclusive, int toIndexExclusive) {
         return UnmodifiableList.unmodifiableList(super.subList(fromIndexInclusive, toIndexExclusive));
      }
   }
}
