package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;

public abstract class AbstractLinkedList implements List {
   transient AbstractLinkedList.Node header;
   transient int size;
   transient int modCount;

   protected AbstractLinkedList() {
   }

   protected AbstractLinkedList(Collection coll) {
      this.init();
      this.addAll(coll);
   }

   protected void init() {
      this.header = this.createHeaderNode();
   }

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public Object get(int index) {
      AbstractLinkedList.Node node = this.getNode(index, false);
      return node.getValue();
   }

   public Iterator iterator() {
      return this.listIterator();
   }

   public ListIterator listIterator() {
      return new AbstractLinkedList.LinkedListIterator(this, 0);
   }

   public ListIterator listIterator(int fromIndex) {
      return new AbstractLinkedList.LinkedListIterator(this, fromIndex);
   }

   public int indexOf(Object value) {
      int i = 0;

      for(AbstractLinkedList.Node node = this.header.next; node != this.header; node = node.next) {
         if (this.isEqualValue(node.getValue(), value)) {
            return i;
         }

         ++i;
      }

      return -1;
   }

   public int lastIndexOf(Object value) {
      int i = this.size - 1;

      for(AbstractLinkedList.Node node = this.header.previous; node != this.header; node = node.previous) {
         if (this.isEqualValue(node.getValue(), value)) {
            return i;
         }

         --i;
      }

      return -1;
   }

   public boolean contains(Object value) {
      return this.indexOf(value) != -1;
   }

   public boolean containsAll(Collection coll) {
      Iterator i$ = coll.iterator();

      Object o;
      do {
         if (!i$.hasNext()) {
            return true;
         }

         o = i$.next();
      } while(this.contains(o));

      return false;
   }

   public Object[] toArray() {
      return this.toArray(new Object[this.size]);
   }

   public Object[] toArray(Object[] array) {
      if (array.length < this.size) {
         Class componentType = array.getClass().getComponentType();
         array = (Object[])((Object[])Array.newInstance(componentType, this.size));
      }

      int i = 0;

      for(AbstractLinkedList.Node node = this.header.next; node != this.header; ++i) {
         array[i] = node.getValue();
         node = node.next;
      }

      if (array.length > this.size) {
         array[this.size] = null;
      }

      return array;
   }

   public List subList(int fromIndexInclusive, int toIndexExclusive) {
      return new AbstractLinkedList.LinkedSubList(this, fromIndexInclusive, toIndexExclusive);
   }

   public boolean add(Object value) {
      this.addLast(value);
      return true;
   }

   public void add(int index, Object value) {
      AbstractLinkedList.Node node = this.getNode(index, true);
      this.addNodeBefore(node, value);
   }

   public boolean addAll(Collection coll) {
      return this.addAll(this.size, coll);
   }

   public boolean addAll(int index, Collection coll) {
      AbstractLinkedList.Node node = this.getNode(index, true);
      Iterator i$ = coll.iterator();

      while(i$.hasNext()) {
         Object e = i$.next();
         this.addNodeBefore(node, e);
      }

      return true;
   }

   public Object remove(int index) {
      AbstractLinkedList.Node node = this.getNode(index, false);
      Object oldValue = node.getValue();
      this.removeNode(node);
      return oldValue;
   }

   public boolean remove(Object value) {
      for(AbstractLinkedList.Node node = this.header.next; node != this.header; node = node.next) {
         if (this.isEqualValue(node.getValue(), value)) {
            this.removeNode(node);
            return true;
         }
      }

      return false;
   }

   public boolean removeAll(Collection coll) {
      boolean modified = false;
      Iterator it = this.iterator();

      while(it.hasNext()) {
         if (coll.contains(it.next())) {
            it.remove();
            modified = true;
         }
      }

      return modified;
   }

   public boolean retainAll(Collection coll) {
      boolean modified = false;
      Iterator it = this.iterator();

      while(it.hasNext()) {
         if (!coll.contains(it.next())) {
            it.remove();
            modified = true;
         }
      }

      return modified;
   }

   public Object set(int index, Object value) {
      AbstractLinkedList.Node node = this.getNode(index, false);
      Object oldValue = node.getValue();
      this.updateNode(node, value);
      return oldValue;
   }

   public void clear() {
      this.removeAllNodes();
   }

   public Object getFirst() {
      AbstractLinkedList.Node node = this.header.next;
      if (node == this.header) {
         throw new NoSuchElementException();
      } else {
         return node.getValue();
      }
   }

   public Object getLast() {
      AbstractLinkedList.Node node = this.header.previous;
      if (node == this.header) {
         throw new NoSuchElementException();
      } else {
         return node.getValue();
      }
   }

   public boolean addFirst(Object o) {
      this.addNodeAfter(this.header, o);
      return true;
   }

   public boolean addLast(Object o) {
      this.addNodeBefore(this.header, o);
      return true;
   }

   public Object removeFirst() {
      AbstractLinkedList.Node node = this.header.next;
      if (node == this.header) {
         throw new NoSuchElementException();
      } else {
         Object oldValue = node.getValue();
         this.removeNode(node);
         return oldValue;
      }
   }

   public Object removeLast() {
      AbstractLinkedList.Node node = this.header.previous;
      if (node == this.header) {
         throw new NoSuchElementException();
      } else {
         Object oldValue = node.getValue();
         this.removeNode(node);
         return oldValue;
      }
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (!(obj instanceof List)) {
         return false;
      } else {
         List other = (List)obj;
         if (other.size() != this.size()) {
            return false;
         } else {
            ListIterator it1 = this.listIterator();
            ListIterator it2 = other.listIterator();

            while(true) {
               if (it1.hasNext() && it2.hasNext()) {
                  Object o1 = it1.next();
                  Object o2 = it2.next();
                  if (o1 == null) {
                     if (o2 == null) {
                        continue;
                     }
                  } else if (o1.equals(o2)) {
                     continue;
                  }

                  return false;
               }

               return !it1.hasNext() && !it2.hasNext();
            }
         }
      }
   }

   public int hashCode() {
      int hashCode = 1;

      Object e;
      for(Iterator i$ = this.iterator(); i$.hasNext(); hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode())) {
         e = i$.next();
      }

      return hashCode;
   }

   public String toString() {
      if (this.size() == 0) {
         return "[]";
      } else {
         StringBuilder buf = new StringBuilder(16 * this.size());
         buf.append('[');
         Iterator it = this.iterator();
         boolean hasNext = it.hasNext();

         while(hasNext) {
            Object value = it.next();
            buf.append(value == this ? "(this Collection)" : value);
            hasNext = it.hasNext();
            if (hasNext) {
               buf.append(", ");
            }
         }

         buf.append(']');
         return buf.toString();
      }
   }

   protected boolean isEqualValue(Object value1, Object value2) {
      return value1 == value2 || value1 != null && value1.equals(value2);
   }

   protected void updateNode(AbstractLinkedList.Node node, Object value) {
      node.setValue(value);
   }

   protected AbstractLinkedList.Node createHeaderNode() {
      return new AbstractLinkedList.Node();
   }

   protected AbstractLinkedList.Node createNode(Object value) {
      return new AbstractLinkedList.Node(value);
   }

   protected void addNodeBefore(AbstractLinkedList.Node node, Object value) {
      AbstractLinkedList.Node newNode = this.createNode(value);
      this.addNode(newNode, node);
   }

   protected void addNodeAfter(AbstractLinkedList.Node node, Object value) {
      AbstractLinkedList.Node newNode = this.createNode(value);
      this.addNode(newNode, node.next);
   }

   protected void addNode(AbstractLinkedList.Node nodeToInsert, AbstractLinkedList.Node insertBeforeNode) {
      nodeToInsert.next = insertBeforeNode;
      nodeToInsert.previous = insertBeforeNode.previous;
      insertBeforeNode.previous.next = nodeToInsert;
      insertBeforeNode.previous = nodeToInsert;
      ++this.size;
      ++this.modCount;
   }

   protected void removeNode(AbstractLinkedList.Node node) {
      node.previous.next = node.next;
      node.next.previous = node.previous;
      --this.size;
      ++this.modCount;
   }

   protected void removeAllNodes() {
      this.header.next = this.header;
      this.header.previous = this.header;
      this.size = 0;
      ++this.modCount;
   }

   protected AbstractLinkedList.Node getNode(int index, boolean endMarkerAllowed) throws IndexOutOfBoundsException {
      if (index < 0) {
         throw new IndexOutOfBoundsException("Couldn't get the node: index (" + index + ") less than zero.");
      } else if (!endMarkerAllowed && index == this.size) {
         throw new IndexOutOfBoundsException("Couldn't get the node: index (" + index + ") is the size of the list.");
      } else if (index > this.size) {
         throw new IndexOutOfBoundsException("Couldn't get the node: index (" + index + ") greater than the size of the " + "list (" + this.size + ").");
      } else {
         AbstractLinkedList.Node node;
         int currentIndex;
         if (index < this.size / 2) {
            node = this.header.next;

            for(currentIndex = 0; currentIndex < index; ++currentIndex) {
               node = node.next;
            }
         } else {
            node = this.header;

            for(currentIndex = this.size; currentIndex > index; --currentIndex) {
               node = node.previous;
            }
         }

         return node;
      }
   }

   protected Iterator createSubListIterator(AbstractLinkedList.LinkedSubList subList) {
      return this.createSubListListIterator(subList, 0);
   }

   protected ListIterator createSubListListIterator(AbstractLinkedList.LinkedSubList subList, int fromIndex) {
      return new AbstractLinkedList.LinkedSubListIterator(subList, fromIndex);
   }

   protected void doWriteObject(ObjectOutputStream outputStream) throws IOException {
      outputStream.writeInt(this.size());
      Iterator i$ = this.iterator();

      while(i$.hasNext()) {
         Object e = i$.next();
         outputStream.writeObject(e);
      }

   }

   protected void doReadObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
      this.init();
      int size = inputStream.readInt();

      for(int i = 0; i < size; ++i) {
         this.add(inputStream.readObject());
      }

   }

   protected static class LinkedSubList extends AbstractList {
      AbstractLinkedList parent;
      int offset;
      int size;
      int expectedModCount;

      protected LinkedSubList(AbstractLinkedList parent, int fromIndex, int toIndex) {
         if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
         } else if (toIndex > parent.size()) {
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
         } else if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
         } else {
            this.parent = parent;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
            this.expectedModCount = parent.modCount;
         }
      }

      public int size() {
         this.checkModCount();
         return this.size;
      }

      public Object get(int index) {
         this.rangeCheck(index, this.size);
         this.checkModCount();
         return this.parent.get(index + this.offset);
      }

      public void add(int index, Object obj) {
         this.rangeCheck(index, this.size + 1);
         this.checkModCount();
         this.parent.add(index + this.offset, obj);
         this.expectedModCount = this.parent.modCount;
         ++this.size;
         ++this.modCount;
      }

      public Object remove(int index) {
         this.rangeCheck(index, this.size);
         this.checkModCount();
         Object result = this.parent.remove(index + this.offset);
         this.expectedModCount = this.parent.modCount;
         --this.size;
         ++this.modCount;
         return result;
      }

      public boolean addAll(Collection coll) {
         return this.addAll(this.size, coll);
      }

      public boolean addAll(int index, Collection coll) {
         this.rangeCheck(index, this.size + 1);
         int cSize = coll.size();
         if (cSize == 0) {
            return false;
         } else {
            this.checkModCount();
            this.parent.addAll(this.offset + index, coll);
            this.expectedModCount = this.parent.modCount;
            this.size += cSize;
            ++this.modCount;
            return true;
         }
      }

      public Object set(int index, Object obj) {
         this.rangeCheck(index, this.size);
         this.checkModCount();
         return this.parent.set(index + this.offset, obj);
      }

      public void clear() {
         this.checkModCount();
         Iterator it = this.iterator();

         while(it.hasNext()) {
            it.next();
            it.remove();
         }

      }

      public Iterator iterator() {
         this.checkModCount();
         return this.parent.createSubListIterator(this);
      }

      public ListIterator listIterator(int index) {
         this.rangeCheck(index, this.size + 1);
         this.checkModCount();
         return this.parent.createSubListListIterator(this, index);
      }

      public List subList(int fromIndexInclusive, int toIndexExclusive) {
         return new AbstractLinkedList.LinkedSubList(this.parent, fromIndexInclusive + this.offset, toIndexExclusive + this.offset);
      }

      protected void rangeCheck(int index, int beyond) {
         if (index < 0 || index >= beyond) {
            throw new IndexOutOfBoundsException("Index '" + index + "' out of bounds for size '" + this.size + "'");
         }
      }

      protected void checkModCount() {
         if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         }
      }
   }

   protected static class LinkedSubListIterator extends AbstractLinkedList.LinkedListIterator {
      protected final AbstractLinkedList.LinkedSubList sub;

      protected LinkedSubListIterator(AbstractLinkedList.LinkedSubList sub, int startIndex) {
         super(sub.parent, startIndex + sub.offset);
         this.sub = sub;
      }

      public boolean hasNext() {
         return this.nextIndex() < this.sub.size;
      }

      public boolean hasPrevious() {
         return this.previousIndex() >= 0;
      }

      public int nextIndex() {
         return super.nextIndex() - this.sub.offset;
      }

      public void add(Object obj) {
         super.add(obj);
         this.sub.expectedModCount = this.parent.modCount;
         ++this.sub.size;
      }

      public void remove() {
         super.remove();
         this.sub.expectedModCount = this.parent.modCount;
         --this.sub.size;
      }
   }

   protected static class LinkedListIterator implements ListIterator, OrderedIterator {
      protected final AbstractLinkedList parent;
      protected AbstractLinkedList.Node next;
      protected int nextIndex;
      protected AbstractLinkedList.Node current;
      protected int expectedModCount;

      protected LinkedListIterator(AbstractLinkedList parent, int fromIndex) throws IndexOutOfBoundsException {
         this.parent = parent;
         this.expectedModCount = parent.modCount;
         this.next = parent.getNode(fromIndex, true);
         this.nextIndex = fromIndex;
      }

      protected void checkModCount() {
         if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         }
      }

      protected AbstractLinkedList.Node getLastNodeReturned() throws IllegalStateException {
         if (this.current == null) {
            throw new IllegalStateException();
         } else {
            return this.current;
         }
      }

      public boolean hasNext() {
         return this.next != this.parent.header;
      }

      public Object next() {
         this.checkModCount();
         if (!this.hasNext()) {
            throw new NoSuchElementException("No element at index " + this.nextIndex + ".");
         } else {
            Object value = this.next.getValue();
            this.current = this.next;
            this.next = this.next.next;
            ++this.nextIndex;
            return value;
         }
      }

      public boolean hasPrevious() {
         return this.next.previous != this.parent.header;
      }

      public Object previous() {
         this.checkModCount();
         if (!this.hasPrevious()) {
            throw new NoSuchElementException("Already at start of list.");
         } else {
            this.next = this.next.previous;
            Object value = this.next.getValue();
            this.current = this.next;
            --this.nextIndex;
            return value;
         }
      }

      public int nextIndex() {
         return this.nextIndex;
      }

      public int previousIndex() {
         return this.nextIndex() - 1;
      }

      public void remove() {
         this.checkModCount();
         if (this.current == this.next) {
            this.next = this.next.next;
            this.parent.removeNode(this.getLastNodeReturned());
         } else {
            this.parent.removeNode(this.getLastNodeReturned());
            --this.nextIndex;
         }

         this.current = null;
         ++this.expectedModCount;
      }

      public void set(Object obj) {
         this.checkModCount();
         this.getLastNodeReturned().setValue(obj);
      }

      public void add(Object obj) {
         this.checkModCount();
         this.parent.addNodeBefore(this.next, obj);
         this.current = null;
         ++this.nextIndex;
         ++this.expectedModCount;
      }
   }

   protected static class Node {
      protected AbstractLinkedList.Node previous;
      protected AbstractLinkedList.Node next;
      protected Object value;

      protected Node() {
         this.previous = this;
         this.next = this;
      }

      protected Node(Object value) {
         this.value = value;
      }

      protected Node(AbstractLinkedList.Node previous, AbstractLinkedList.Node next, Object value) {
         this.previous = previous;
         this.next = next;
         this.value = value;
      }

      protected Object getValue() {
         return this.value;
      }

      protected void setValue(Object value) {
         this.value = value;
      }

      protected AbstractLinkedList.Node getPreviousNode() {
         return this.previous;
      }

      protected void setPreviousNode(AbstractLinkedList.Node previous) {
         this.previous = previous;
      }

      protected AbstractLinkedList.Node getNextNode() {
         return this.next;
      }

      protected void setNextNode(AbstractLinkedList.Node next) {
         this.next = next;
      }
   }
}
