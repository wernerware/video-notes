package org.apache.commons.collections4.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;

public abstract class AbstractLinkedMap extends AbstractHashedMap implements OrderedMap {
   transient AbstractLinkedMap.LinkEntry header;

   protected AbstractLinkedMap() {
   }

   protected AbstractLinkedMap(int initialCapacity, float loadFactor, int threshold) {
      super(initialCapacity, loadFactor, threshold);
   }

   protected AbstractLinkedMap(int initialCapacity) {
      super(initialCapacity);
   }

   protected AbstractLinkedMap(int initialCapacity, float loadFactor) {
      super(initialCapacity, loadFactor);
   }

   protected AbstractLinkedMap(Map map) {
      super(map);
   }

   protected void init() {
      this.header = this.createEntry((AbstractHashedMap.HashEntry)null, -1, (Object)null, (Object)null);
      this.header.before = this.header.after = this.header;
   }

   public boolean containsValue(Object value) {
      AbstractLinkedMap.LinkEntry entry;
      if (value == null) {
         for(entry = this.header.after; entry != this.header; entry = entry.after) {
            if (entry.getValue() == null) {
               return true;
            }
         }
      } else {
         for(entry = this.header.after; entry != this.header; entry = entry.after) {
            if (this.isEqualValue(value, entry.getValue())) {
               return true;
            }
         }
      }

      return false;
   }

   public void clear() {
      super.clear();
      this.header.before = this.header.after = this.header;
   }

   public Object firstKey() {
      if (this.size == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.header.after.getKey();
      }
   }

   public Object lastKey() {
      if (this.size == 0) {
         throw new NoSuchElementException("Map is empty");
      } else {
         return this.header.before.getKey();
      }
   }

   public Object nextKey(Object key) {
      AbstractLinkedMap.LinkEntry entry = this.getEntry(key);
      return entry != null && entry.after != this.header ? entry.after.getKey() : null;
   }

   protected AbstractLinkedMap.LinkEntry getEntry(Object key) {
      return (AbstractLinkedMap.LinkEntry)super.getEntry(key);
   }

   public Object previousKey(Object key) {
      AbstractLinkedMap.LinkEntry entry = this.getEntry(key);
      return entry != null && entry.before != this.header ? entry.before.getKey() : null;
   }

   protected AbstractLinkedMap.LinkEntry getEntry(int index) {
      if (index < 0) {
         throw new IndexOutOfBoundsException("Index " + index + " is less than zero");
      } else if (index >= this.size) {
         throw new IndexOutOfBoundsException("Index " + index + " is invalid for size " + this.size);
      } else {
         AbstractLinkedMap.LinkEntry entry;
         int currentIndex;
         if (index < this.size / 2) {
            entry = this.header.after;

            for(currentIndex = 0; currentIndex < index; ++currentIndex) {
               entry = entry.after;
            }
         } else {
            entry = this.header;

            for(currentIndex = this.size; currentIndex > index; --currentIndex) {
               entry = entry.before;
            }
         }

         return entry;
      }
   }

   protected void addEntry(AbstractHashedMap.HashEntry entry, int hashIndex) {
      AbstractLinkedMap.LinkEntry link = (AbstractLinkedMap.LinkEntry)entry;
      link.after = this.header;
      link.before = this.header.before;
      this.header.before.after = link;
      this.header.before = link;
      this.data[hashIndex] = link;
   }

   protected AbstractLinkedMap.LinkEntry createEntry(AbstractHashedMap.HashEntry next, int hashCode, Object key, Object value) {
      return new AbstractLinkedMap.LinkEntry(next, hashCode, this.convertKey(key), value);
   }

   protected void removeEntry(AbstractHashedMap.HashEntry entry, int hashIndex, AbstractHashedMap.HashEntry previous) {
      AbstractLinkedMap.LinkEntry link = (AbstractLinkedMap.LinkEntry)entry;
      link.before.after = link.after;
      link.after.before = link.before;
      link.after = null;
      link.before = null;
      super.removeEntry(entry, hashIndex, previous);
   }

   protected AbstractLinkedMap.LinkEntry entryBefore(AbstractLinkedMap.LinkEntry entry) {
      return entry.before;
   }

   protected AbstractLinkedMap.LinkEntry entryAfter(AbstractLinkedMap.LinkEntry entry) {
      return entry.after;
   }

   public OrderedMapIterator mapIterator() {
      return (OrderedMapIterator)(this.size == 0 ? EmptyOrderedMapIterator.emptyOrderedMapIterator() : new AbstractLinkedMap.LinkMapIterator(this));
   }

   protected Iterator createEntrySetIterator() {
      return (Iterator)(this.size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new AbstractLinkedMap.EntrySetIterator(this));
   }

   protected Iterator createKeySetIterator() {
      return (Iterator)(this.size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new AbstractLinkedMap.KeySetIterator(this));
   }

   protected Iterator createValuesIterator() {
      return (Iterator)(this.size() == 0 ? EmptyOrderedIterator.emptyOrderedIterator() : new AbstractLinkedMap.ValuesIterator(this));
   }

   protected abstract static class LinkIterator {
      protected final AbstractLinkedMap parent;
      protected AbstractLinkedMap.LinkEntry last;
      protected AbstractLinkedMap.LinkEntry next;
      protected int expectedModCount;

      protected LinkIterator(AbstractLinkedMap parent) {
         this.parent = parent;
         this.next = parent.header.after;
         this.expectedModCount = parent.modCount;
      }

      public boolean hasNext() {
         return this.next != this.parent.header;
      }

      public boolean hasPrevious() {
         return this.next.before != this.parent.header;
      }

      protected AbstractLinkedMap.LinkEntry nextEntry() {
         if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         } else if (this.next == this.parent.header) {
            throw new NoSuchElementException("No next() entry in the iteration");
         } else {
            this.last = this.next;
            this.next = this.next.after;
            return this.last;
         }
      }

      protected AbstractLinkedMap.LinkEntry previousEntry() {
         if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         } else {
            AbstractLinkedMap.LinkEntry previous = this.next.before;
            if (previous == this.parent.header) {
               throw new NoSuchElementException("No previous() entry in the iteration");
            } else {
               this.next = previous;
               this.last = previous;
               return this.last;
            }
         }
      }

      protected AbstractLinkedMap.LinkEntry currentEntry() {
         return this.last;
      }

      public void remove() {
         if (this.last == null) {
            throw new IllegalStateException("remove() can only be called once after next()");
         } else if (this.parent.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         } else {
            this.parent.remove(this.last.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
         }
      }

      public void reset() {
         this.last = null;
         this.next = this.parent.header.after;
      }

      public String toString() {
         return this.last != null ? "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]" : "Iterator[]";
      }
   }

   protected static class LinkEntry extends AbstractHashedMap.HashEntry {
      protected AbstractLinkedMap.LinkEntry before;
      protected AbstractLinkedMap.LinkEntry after;

      protected LinkEntry(AbstractHashedMap.HashEntry next, int hashCode, Object key, Object value) {
         super(next, hashCode, key, value);
      }
   }

   protected static class ValuesIterator extends AbstractLinkedMap.LinkIterator implements OrderedIterator, ResettableIterator {
      protected ValuesIterator(AbstractLinkedMap parent) {
         super(parent);
      }

      public Object next() {
         return super.nextEntry().getValue();
      }

      public Object previous() {
         return super.previousEntry().getValue();
      }
   }

   protected static class KeySetIterator extends AbstractLinkedMap.LinkIterator implements OrderedIterator, ResettableIterator {
      protected KeySetIterator(AbstractLinkedMap parent) {
         super(parent);
      }

      public Object next() {
         return super.nextEntry().getKey();
      }

      public Object previous() {
         return super.previousEntry().getKey();
      }
   }

   protected static class EntrySetIterator extends AbstractLinkedMap.LinkIterator implements OrderedIterator, ResettableIterator {
      protected EntrySetIterator(AbstractLinkedMap parent) {
         super(parent);
      }

      public Entry next() {
         return super.nextEntry();
      }

      public Entry previous() {
         return super.previousEntry();
      }
   }

   protected static class LinkMapIterator extends AbstractLinkedMap.LinkIterator implements OrderedMapIterator, ResettableIterator {
      protected LinkMapIterator(AbstractLinkedMap parent) {
         super(parent);
      }

      public Object next() {
         return super.nextEntry().getKey();
      }

      public Object previous() {
         return super.previousEntry().getKey();
      }

      public Object getKey() {
         AbstractLinkedMap.LinkEntry current = this.currentEntry();
         if (current == null) {
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
         } else {
            return current.getKey();
         }
      }

      public Object getValue() {
         AbstractLinkedMap.LinkEntry current = this.currentEntry();
         if (current == null) {
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
         } else {
            return current.getValue();
         }
      }

      public Object setValue(Object value) {
         AbstractLinkedMap.LinkEntry current = this.currentEntry();
         if (current == null) {
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
         } else {
            return current.setValue(value);
         }
      }
   }
}
