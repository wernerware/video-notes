package org.apache.commons.collections4.trie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;
import org.apache.commons.collections4.OrderedMapIterator;

abstract class AbstractPatriciaTrie extends AbstractBitwiseTrie {
   private static final long serialVersionUID = 5155253417231339498L;
   private transient AbstractPatriciaTrie.TrieEntry root = new AbstractPatriciaTrie.TrieEntry((Object)null, (Object)null, -1);
   private transient volatile Set keySet;
   private transient volatile Collection values;
   private transient volatile Set entrySet;
   private transient int size = 0;
   protected transient int modCount = 0;

   protected AbstractPatriciaTrie(KeyAnalyzer keyAnalyzer) {
      super(keyAnalyzer);
   }

   protected AbstractPatriciaTrie(KeyAnalyzer keyAnalyzer, Map map) {
      super(keyAnalyzer);
      this.putAll(map);
   }

   public void clear() {
      this.root.key = null;
      this.root.bitIndex = -1;
      this.root.value = null;
      this.root.parent = null;
      this.root.left = this.root;
      this.root.right = null;
      this.root.predecessor = this.root;
      this.size = 0;
      this.incrementModCount();
   }

   public int size() {
      return this.size;
   }

   void incrementSize() {
      ++this.size;
      this.incrementModCount();
   }

   void decrementSize() {
      --this.size;
      this.incrementModCount();
   }

   private void incrementModCount() {
      ++this.modCount;
   }

   public Object put(Object key, Object value) {
      if (key == null) {
         throw new NullPointerException("Key cannot be null");
      } else {
         int lengthInBits = this.lengthInBits(key);
         if (lengthInBits == 0) {
            if (this.root.isEmpty()) {
               this.incrementSize();
            } else {
               this.incrementModCount();
            }

            return this.root.setKeyValue(key, value);
         } else {
            AbstractPatriciaTrie.TrieEntry found = this.getNearestEntryForKey(key, lengthInBits);
            if (this.compareKeys(key, found.key)) {
               if (found.isEmpty()) {
                  this.incrementSize();
               } else {
                  this.incrementModCount();
               }

               return found.setKeyValue(key, value);
            } else {
               int bitIndex = this.bitIndex(key, found.key);
               if (!KeyAnalyzer.isOutOfBoundsIndex(bitIndex)) {
                  if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
                     AbstractPatriciaTrie.TrieEntry t = new AbstractPatriciaTrie.TrieEntry(key, value, bitIndex);
                     this.addEntry(t, lengthInBits);
                     this.incrementSize();
                     return null;
                  }

                  if (KeyAnalyzer.isNullBitKey(bitIndex)) {
                     if (this.root.isEmpty()) {
                        this.incrementSize();
                     } else {
                        this.incrementModCount();
                     }

                     return this.root.setKeyValue(key, value);
                  }

                  if (KeyAnalyzer.isEqualBitKey(bitIndex) && found != this.root) {
                     this.incrementModCount();
                     return found.setKeyValue(key, value);
                  }
               }

               throw new IllegalArgumentException("Failed to put: " + key + " -> " + value + ", " + bitIndex);
            }
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry addEntry(AbstractPatriciaTrie.TrieEntry entry, int lengthInBits) {
      AbstractPatriciaTrie.TrieEntry current = this.root.left;
      AbstractPatriciaTrie.TrieEntry path = this.root;

      while(current.bitIndex < entry.bitIndex && current.bitIndex > path.bitIndex) {
         path = current;
         if (!this.isBitSet(entry.key, current.bitIndex, lengthInBits)) {
            current = current.left;
         } else {
            current = current.right;
         }
      }

      entry.predecessor = entry;
      if (!this.isBitSet(entry.key, entry.bitIndex, lengthInBits)) {
         entry.left = entry;
         entry.right = current;
      } else {
         entry.left = current;
         entry.right = entry;
      }

      entry.parent = path;
      if (current.bitIndex >= entry.bitIndex) {
         current.parent = entry;
      }

      if (current.bitIndex <= path.bitIndex) {
         current.predecessor = entry;
      }

      if (path != this.root && this.isBitSet(entry.key, path.bitIndex, lengthInBits)) {
         path.right = entry;
      } else {
         path.left = entry;
      }

      return entry;
   }

   public Object get(Object k) {
      AbstractPatriciaTrie.TrieEntry entry = this.getEntry(k);
      return entry != null ? entry.getValue() : null;
   }

   AbstractPatriciaTrie.TrieEntry getEntry(Object k) {
      Object key = this.castKey(k);
      if (key == null) {
         return null;
      } else {
         int lengthInBits = this.lengthInBits(key);
         AbstractPatriciaTrie.TrieEntry entry = this.getNearestEntryForKey(key, lengthInBits);
         return !entry.isEmpty() && this.compareKeys(key, entry.key) ? entry : null;
      }
   }

   public Entry select(Object key) {
      int lengthInBits = this.lengthInBits(key);
      AbstractPatriciaTrie.Reference reference = new AbstractPatriciaTrie.Reference();
      return !this.selectR(this.root.left, -1, key, lengthInBits, reference) ? (Entry)reference.get() : null;
   }

   public Object selectKey(Object key) {
      Entry entry = this.select(key);
      return entry == null ? null : entry.getKey();
   }

   public Object selectValue(Object key) {
      Entry entry = this.select(key);
      return entry == null ? null : entry.getValue();
   }

   private boolean selectR(AbstractPatriciaTrie.TrieEntry h, int bitIndex, Object key, int lengthInBits, AbstractPatriciaTrie.Reference reference) {
      if (h.bitIndex <= bitIndex) {
         if (!h.isEmpty()) {
            reference.set(h);
            return false;
         } else {
            return true;
         }
      } else {
         if (!this.isBitSet(key, h.bitIndex, lengthInBits)) {
            if (this.selectR(h.left, h.bitIndex, key, lengthInBits, reference)) {
               return this.selectR(h.right, h.bitIndex, key, lengthInBits, reference);
            }
         } else if (this.selectR(h.right, h.bitIndex, key, lengthInBits, reference)) {
            return this.selectR(h.left, h.bitIndex, key, lengthInBits, reference);
         }

         return false;
      }
   }

   public boolean containsKey(Object k) {
      if (k == null) {
         return false;
      } else {
         Object key = this.castKey(k);
         int lengthInBits = this.lengthInBits(key);
         AbstractPatriciaTrie.TrieEntry entry = this.getNearestEntryForKey(key, lengthInBits);
         return !entry.isEmpty() && this.compareKeys(key, entry.key);
      }
   }

   public Set entrySet() {
      if (this.entrySet == null) {
         this.entrySet = new AbstractPatriciaTrie.EntrySet();
      }

      return this.entrySet;
   }

   public Set keySet() {
      if (this.keySet == null) {
         this.keySet = new AbstractPatriciaTrie.KeySet();
      }

      return this.keySet;
   }

   public Collection values() {
      if (this.values == null) {
         this.values = new AbstractPatriciaTrie.Values();
      }

      return this.values;
   }

   public Object remove(Object k) {
      if (k == null) {
         return null;
      } else {
         Object key = this.castKey(k);
         int lengthInBits = this.lengthInBits(key);
         AbstractPatriciaTrie.TrieEntry current = this.root.left;
         AbstractPatriciaTrie.TrieEntry path = this.root;

         while(current.bitIndex > path.bitIndex) {
            path = current;
            if (!this.isBitSet(key, current.bitIndex, lengthInBits)) {
               current = current.left;
            } else {
               current = current.right;
            }
         }

         if (!current.isEmpty() && this.compareKeys(key, current.key)) {
            return this.removeEntry(current);
         } else {
            return null;
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry getNearestEntryForKey(Object key, int lengthInBits) {
      AbstractPatriciaTrie.TrieEntry current = this.root.left;
      AbstractPatriciaTrie.TrieEntry path = this.root;

      while(current.bitIndex > path.bitIndex) {
         path = current;
         if (!this.isBitSet(key, current.bitIndex, lengthInBits)) {
            current = current.left;
         } else {
            current = current.right;
         }
      }

      return current;
   }

   Object removeEntry(AbstractPatriciaTrie.TrieEntry h) {
      if (h != this.root) {
         if (h.isInternalNode()) {
            this.removeInternalEntry(h);
         } else {
            this.removeExternalEntry(h);
         }
      }

      this.decrementSize();
      return h.setKeyValue((Object)null, (Object)null);
   }

   private void removeExternalEntry(AbstractPatriciaTrie.TrieEntry h) {
      if (h == this.root) {
         throw new IllegalArgumentException("Cannot delete root Entry!");
      } else if (!h.isExternalNode()) {
         throw new IllegalArgumentException(h + " is not an external Entry!");
      } else {
         AbstractPatriciaTrie.TrieEntry parent = h.parent;
         AbstractPatriciaTrie.TrieEntry child = h.left == h ? h.right : h.left;
         if (parent.left == h) {
            parent.left = child;
         } else {
            parent.right = child;
         }

         if (child.bitIndex > parent.bitIndex) {
            child.parent = parent;
         } else {
            child.predecessor = parent;
         }

      }
   }

   private void removeInternalEntry(AbstractPatriciaTrie.TrieEntry h) {
      if (h == this.root) {
         throw new IllegalArgumentException("Cannot delete root Entry!");
      } else if (!h.isInternalNode()) {
         throw new IllegalArgumentException(h + " is not an internal Entry!");
      } else {
         AbstractPatriciaTrie.TrieEntry p = h.predecessor;
         p.bitIndex = h.bitIndex;
         AbstractPatriciaTrie.TrieEntry parent = p.parent;
         AbstractPatriciaTrie.TrieEntry child = p.left == h ? p.right : p.left;
         if (p.predecessor == p && p.parent != h) {
            p.predecessor = p.parent;
         }

         if (parent.left == p) {
            parent.left = child;
         } else {
            parent.right = child;
         }

         if (child.bitIndex > parent.bitIndex) {
            child.parent = parent;
         }

         if (h.left.parent == h) {
            h.left.parent = p;
         }

         if (h.right.parent == h) {
            h.right.parent = p;
         }

         if (h.parent.left == h) {
            h.parent.left = p;
         } else {
            h.parent.right = p;
         }

         p.parent = h.parent;
         p.left = h.left;
         p.right = h.right;
         if (isValidUplink(p.left, p)) {
            p.left.predecessor = p;
         }

         if (isValidUplink(p.right, p)) {
            p.right.predecessor = p;
         }

      }
   }

   AbstractPatriciaTrie.TrieEntry nextEntry(AbstractPatriciaTrie.TrieEntry node) {
      return node == null ? this.firstEntry() : this.nextEntryImpl(node.predecessor, node, (AbstractPatriciaTrie.TrieEntry)null);
   }

   AbstractPatriciaTrie.TrieEntry nextEntryImpl(AbstractPatriciaTrie.TrieEntry start, AbstractPatriciaTrie.TrieEntry previous, AbstractPatriciaTrie.TrieEntry tree) {
      AbstractPatriciaTrie.TrieEntry current = start;
      if (previous == null || start != previous.predecessor) {
         while(!current.left.isEmpty() && previous != current.left) {
            if (isValidUplink(current.left, current)) {
               return current.left;
            }

            current = current.left;
         }
      }

      if (current.isEmpty()) {
         return null;
      } else if (current.right == null) {
         return null;
      } else if (previous != current.right) {
         return isValidUplink(current.right, current) ? current.right : this.nextEntryImpl(current.right, previous, tree);
      } else {
         while(current == current.parent.right) {
            if (current == tree) {
               return null;
            }

            current = current.parent;
         }

         if (current == tree) {
            return null;
         } else if (current.parent.right == null) {
            return null;
         } else if (previous != current.parent.right && isValidUplink(current.parent.right, current.parent)) {
            return current.parent.right;
         } else if (current.parent.right == current.parent) {
            return null;
         } else {
            return this.nextEntryImpl(current.parent.right, previous, tree);
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry firstEntry() {
      return this.isEmpty() ? null : this.followLeft(this.root);
   }

   AbstractPatriciaTrie.TrieEntry followLeft(AbstractPatriciaTrie.TrieEntry node) {
      while(true) {
         AbstractPatriciaTrie.TrieEntry child = node.left;
         if (child.isEmpty()) {
            child = node.right;
         }

         if (child.bitIndex <= node.bitIndex) {
            return child;
         }

         node = child;
      }
   }

   public Comparator comparator() {
      return this.getKeyAnalyzer();
   }

   public Object firstKey() {
      if (this.size() == 0) {
         throw new NoSuchElementException();
      } else {
         return this.firstEntry().getKey();
      }
   }

   public Object lastKey() {
      AbstractPatriciaTrie.TrieEntry entry = this.lastEntry();
      if (entry != null) {
         return entry.getKey();
      } else {
         throw new NoSuchElementException();
      }
   }

   public Object nextKey(Object key) {
      if (key == null) {
         throw new NullPointerException();
      } else {
         AbstractPatriciaTrie.TrieEntry entry = this.getEntry(key);
         if (entry != null) {
            AbstractPatriciaTrie.TrieEntry nextEntry = this.nextEntry(entry);
            return nextEntry != null ? nextEntry.getKey() : null;
         } else {
            return null;
         }
      }
   }

   public Object previousKey(Object key) {
      if (key == null) {
         throw new NullPointerException();
      } else {
         AbstractPatriciaTrie.TrieEntry entry = this.getEntry(key);
         if (entry != null) {
            AbstractPatriciaTrie.TrieEntry prevEntry = this.previousEntry(entry);
            return prevEntry != null ? prevEntry.getKey() : null;
         } else {
            return null;
         }
      }
   }

   public OrderedMapIterator mapIterator() {
      return new AbstractPatriciaTrie.TrieMapIterator();
   }

   public SortedMap prefixMap(Object key) {
      return this.getPrefixMapByBits(key, 0, this.lengthInBits(key));
   }

   private SortedMap getPrefixMapByBits(Object key, int offsetInBits, int lengthInBits) {
      int offsetLength = offsetInBits + lengthInBits;
      if (offsetLength > this.lengthInBits(key)) {
         throw new IllegalArgumentException(offsetInBits + " + " + lengthInBits + " > " + this.lengthInBits(key));
      } else {
         return (SortedMap)(offsetLength == 0 ? this : new AbstractPatriciaTrie.PrefixRangeMap(key, offsetInBits, lengthInBits));
      }
   }

   public SortedMap headMap(Object toKey) {
      return new AbstractPatriciaTrie.RangeEntryMap((Object)null, toKey);
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      return new AbstractPatriciaTrie.RangeEntryMap(fromKey, toKey);
   }

   public SortedMap tailMap(Object fromKey) {
      return new AbstractPatriciaTrie.RangeEntryMap(fromKey, (Object)null);
   }

   AbstractPatriciaTrie.TrieEntry higherEntry(Object key) {
      int lengthInBits = this.lengthInBits(key);
      if (lengthInBits == 0) {
         if (!this.root.isEmpty()) {
            return this.size() > 1 ? this.nextEntry(this.root) : null;
         } else {
            return this.firstEntry();
         }
      } else {
         AbstractPatriciaTrie.TrieEntry found = this.getNearestEntryForKey(key, lengthInBits);
         if (this.compareKeys(key, found.key)) {
            return this.nextEntry(found);
         } else {
            int bitIndex = this.bitIndex(key, found.key);
            if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
               AbstractPatriciaTrie.TrieEntry added = new AbstractPatriciaTrie.TrieEntry(key, (Object)null, bitIndex);
               this.addEntry(added, lengthInBits);
               this.incrementSize();
               AbstractPatriciaTrie.TrieEntry ceil = this.nextEntry(added);
               this.removeEntry(added);
               this.modCount -= 2;
               return ceil;
            } else if (KeyAnalyzer.isNullBitKey(bitIndex)) {
               if (!this.root.isEmpty()) {
                  return this.firstEntry();
               } else {
                  return this.size() > 1 ? this.nextEntry(this.firstEntry()) : null;
               }
            } else if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
               return this.nextEntry(found);
            } else {
               throw new IllegalStateException("invalid lookup: " + key);
            }
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry ceilingEntry(Object key) {
      int lengthInBits = this.lengthInBits(key);
      if (lengthInBits == 0) {
         return !this.root.isEmpty() ? this.root : this.firstEntry();
      } else {
         AbstractPatriciaTrie.TrieEntry found = this.getNearestEntryForKey(key, lengthInBits);
         if (this.compareKeys(key, found.key)) {
            return found;
         } else {
            int bitIndex = this.bitIndex(key, found.key);
            if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
               AbstractPatriciaTrie.TrieEntry added = new AbstractPatriciaTrie.TrieEntry(key, (Object)null, bitIndex);
               this.addEntry(added, lengthInBits);
               this.incrementSize();
               AbstractPatriciaTrie.TrieEntry ceil = this.nextEntry(added);
               this.removeEntry(added);
               this.modCount -= 2;
               return ceil;
            } else if (KeyAnalyzer.isNullBitKey(bitIndex)) {
               return !this.root.isEmpty() ? this.root : this.firstEntry();
            } else if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
               return found;
            } else {
               throw new IllegalStateException("invalid lookup: " + key);
            }
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry lowerEntry(Object key) {
      int lengthInBits = this.lengthInBits(key);
      if (lengthInBits == 0) {
         return null;
      } else {
         AbstractPatriciaTrie.TrieEntry found = this.getNearestEntryForKey(key, lengthInBits);
         if (this.compareKeys(key, found.key)) {
            return this.previousEntry(found);
         } else {
            int bitIndex = this.bitIndex(key, found.key);
            if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
               AbstractPatriciaTrie.TrieEntry added = new AbstractPatriciaTrie.TrieEntry(key, (Object)null, bitIndex);
               this.addEntry(added, lengthInBits);
               this.incrementSize();
               AbstractPatriciaTrie.TrieEntry prior = this.previousEntry(added);
               this.removeEntry(added);
               this.modCount -= 2;
               return prior;
            } else if (KeyAnalyzer.isNullBitKey(bitIndex)) {
               return null;
            } else if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
               return this.previousEntry(found);
            } else {
               throw new IllegalStateException("invalid lookup: " + key);
            }
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry floorEntry(Object key) {
      int lengthInBits = this.lengthInBits(key);
      if (lengthInBits == 0) {
         return !this.root.isEmpty() ? this.root : null;
      } else {
         AbstractPatriciaTrie.TrieEntry found = this.getNearestEntryForKey(key, lengthInBits);
         if (this.compareKeys(key, found.key)) {
            return found;
         } else {
            int bitIndex = this.bitIndex(key, found.key);
            if (KeyAnalyzer.isValidBitIndex(bitIndex)) {
               AbstractPatriciaTrie.TrieEntry added = new AbstractPatriciaTrie.TrieEntry(key, (Object)null, bitIndex);
               this.addEntry(added, lengthInBits);
               this.incrementSize();
               AbstractPatriciaTrie.TrieEntry floor = this.previousEntry(added);
               this.removeEntry(added);
               this.modCount -= 2;
               return floor;
            } else if (KeyAnalyzer.isNullBitKey(bitIndex)) {
               return !this.root.isEmpty() ? this.root : null;
            } else if (KeyAnalyzer.isEqualBitKey(bitIndex)) {
               return found;
            } else {
               throw new IllegalStateException("invalid lookup: " + key);
            }
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry subtree(Object prefix, int offsetInBits, int lengthInBits) {
      AbstractPatriciaTrie.TrieEntry current = this.root.left;
      AbstractPatriciaTrie.TrieEntry path = this.root;

      while(current.bitIndex > path.bitIndex && lengthInBits > current.bitIndex) {
         path = current;
         if (!this.isBitSet(prefix, offsetInBits + current.bitIndex, offsetInBits + lengthInBits)) {
            current = current.left;
         } else {
            current = current.right;
         }
      }

      AbstractPatriciaTrie.TrieEntry entry = current.isEmpty() ? path : current;
      if (entry.isEmpty()) {
         return null;
      } else {
         int endIndexInBits = offsetInBits + lengthInBits;
         if (entry == this.root && this.lengthInBits(entry.getKey()) < endIndexInBits) {
            return null;
         } else if (this.isBitSet(prefix, endIndexInBits - 1, endIndexInBits) != this.isBitSet(entry.key, lengthInBits - 1, this.lengthInBits(entry.key))) {
            return null;
         } else {
            int bitIndex = this.getKeyAnalyzer().bitIndex(prefix, offsetInBits, lengthInBits, entry.key, 0, this.lengthInBits(entry.getKey()));
            return bitIndex >= 0 && bitIndex < lengthInBits ? null : entry;
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry lastEntry() {
      return this.followRight(this.root.left);
   }

   AbstractPatriciaTrie.TrieEntry followRight(AbstractPatriciaTrie.TrieEntry node) {
      if (node.right == null) {
         return null;
      } else {
         while(node.right.bitIndex > node.bitIndex) {
            node = node.right;
         }

         return node.right;
      }
   }

   AbstractPatriciaTrie.TrieEntry previousEntry(AbstractPatriciaTrie.TrieEntry start) {
      if (start.predecessor == null) {
         throw new IllegalArgumentException("must have come from somewhere!");
      } else if (start.predecessor.right == start) {
         return isValidUplink(start.predecessor.left, start.predecessor) ? start.predecessor.left : this.followRight(start.predecessor.left);
      } else {
         AbstractPatriciaTrie.TrieEntry node;
         for(node = start.predecessor; node.parent != null && node == node.parent.left; node = node.parent) {
            ;
         }

         if (node.parent == null) {
            return null;
         } else if (isValidUplink(node.parent.left, node.parent)) {
            if (node.parent.left == this.root) {
               return this.root.isEmpty() ? null : this.root;
            } else {
               return node.parent.left;
            }
         } else {
            return this.followRight(node.parent.left);
         }
      }
   }

   AbstractPatriciaTrie.TrieEntry nextEntryInSubtree(AbstractPatriciaTrie.TrieEntry node, AbstractPatriciaTrie.TrieEntry parentOfSubtree) {
      return node == null ? this.firstEntry() : this.nextEntryImpl(node.predecessor, node, parentOfSubtree);
   }

   static boolean isValidUplink(AbstractPatriciaTrie.TrieEntry next, AbstractPatriciaTrie.TrieEntry from) {
      return next != null && next.bitIndex <= from.bitIndex && !next.isEmpty();
   }

   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
      stream.defaultReadObject();
      this.root = new AbstractPatriciaTrie.TrieEntry((Object)null, (Object)null, -1);
      int size = stream.readInt();

      for(int i = 0; i < size; ++i) {
         Object k = stream.readObject();
         Object v = stream.readObject();
         this.put(k, v);
      }

   }

   private void writeObject(ObjectOutputStream stream) throws IOException {
      stream.defaultWriteObject();
      stream.writeInt(this.size());
      Iterator i$ = this.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         stream.writeObject(entry.getKey());
         stream.writeObject(entry.getValue());
      }

   }

   private final class PrefixRangeEntrySet extends AbstractPatriciaTrie.RangeEntrySet {
      private final AbstractPatriciaTrie.PrefixRangeMap delegate;
      private AbstractPatriciaTrie.TrieEntry prefixStart;
      private int expectedModCount = 0;

      public PrefixRangeEntrySet(AbstractPatriciaTrie.PrefixRangeMap delegate) {
         super(delegate);
         this.delegate = delegate;
      }

      public int size() {
         return this.delegate.fixup();
      }

      public Iterator iterator() {
         if (AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
            this.prefixStart = AbstractPatriciaTrie.this.subtree(this.delegate.prefix, this.delegate.offsetInBits, this.delegate.lengthInBits);
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
         }

         if (this.prefixStart == null) {
            Set empty = Collections.emptySet();
            return empty.iterator();
         } else {
            return (Iterator)(this.delegate.lengthInBits > this.prefixStart.bitIndex ? new AbstractPatriciaTrie.PrefixRangeEntrySet.SingletonIterator(this.prefixStart) : new AbstractPatriciaTrie.PrefixRangeEntrySet.EntryIterator(this.prefixStart, this.delegate.prefix, this.delegate.offsetInBits, this.delegate.lengthInBits));
         }
      }

      private final class EntryIterator extends AbstractPatriciaTrie.TrieIterator {
         private final Object prefix;
         private final int offset;
         private final int lengthInBits;
         private boolean lastOne;
         private AbstractPatriciaTrie.TrieEntry subtree;

         EntryIterator(AbstractPatriciaTrie.TrieEntry startScan, Object prefix, int offset, int lengthInBits) {
            super();
            this.subtree = startScan;
            this.next = AbstractPatriciaTrie.this.followLeft(startScan);
            this.prefix = prefix;
            this.offset = offset;
            this.lengthInBits = lengthInBits;
         }

         public Entry next() {
            Entry entry = this.nextEntry();
            if (this.lastOne) {
               this.next = null;
            }

            return entry;
         }

         protected AbstractPatriciaTrie.TrieEntry findNext(AbstractPatriciaTrie.TrieEntry prior) {
            return AbstractPatriciaTrie.this.nextEntryInSubtree(prior, this.subtree);
         }

         public void remove() {
            boolean needsFixing = false;
            int bitIdx = this.subtree.bitIndex;
            if (this.current == this.subtree) {
               needsFixing = true;
            }

            super.remove();
            if (bitIdx != this.subtree.bitIndex || needsFixing) {
               this.subtree = AbstractPatriciaTrie.this.subtree(this.prefix, this.offset, this.lengthInBits);
            }

            if (this.lengthInBits >= this.subtree.bitIndex) {
               this.lastOne = true;
            }

         }
      }

      private final class SingletonIterator implements Iterator {
         private final AbstractPatriciaTrie.TrieEntry entry;
         private int hit = 0;

         public SingletonIterator(AbstractPatriciaTrie.TrieEntry entry) {
            this.entry = entry;
         }

         public boolean hasNext() {
            return this.hit == 0;
         }

         public Entry next() {
            if (this.hit != 0) {
               throw new NoSuchElementException();
            } else {
               ++this.hit;
               return this.entry;
            }
         }

         public void remove() {
            if (this.hit != 1) {
               throw new IllegalStateException();
            } else {
               ++this.hit;
               AbstractPatriciaTrie.this.removeEntry(this.entry);
            }
         }
      }
   }

   private class PrefixRangeMap extends AbstractPatriciaTrie.RangeMap {
      private final Object prefix;
      private final int offsetInBits;
      private final int lengthInBits;
      private Object fromKey;
      private Object toKey;
      private transient int expectedModCount;
      private int size;

      private PrefixRangeMap(Object prefix, int offsetInBits, int lengthInBits) {
         super(null);
         this.fromKey = null;
         this.toKey = null;
         this.expectedModCount = 0;
         this.size = -1;
         this.prefix = prefix;
         this.offsetInBits = offsetInBits;
         this.lengthInBits = lengthInBits;
      }

      private int fixup() {
         if (this.size == -1 || AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
            Iterator it = super.entrySet().iterator();
            this.size = 0;
            Entry entryx = null;
            if (it.hasNext()) {
               entryx = (Entry)it.next();
               this.size = 1;
            }

            this.fromKey = entryx == null ? null : entryx.getKey();
            if (this.fromKey != null) {
               AbstractPatriciaTrie.TrieEntry prior = AbstractPatriciaTrie.this.previousEntry((AbstractPatriciaTrie.TrieEntry)entryx);
               this.fromKey = prior == null ? null : prior.getKey();
            }

            for(this.toKey = this.fromKey; it.hasNext(); entryx = (Entry)it.next()) {
               ++this.size;
            }

            this.toKey = entryx == null ? null : entryx.getKey();
            if (this.toKey != null) {
               Entry entry = AbstractPatriciaTrie.this.nextEntry((AbstractPatriciaTrie.TrieEntry)entryx);
               this.toKey = entry == null ? null : entry.getKey();
            }

            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
         }

         return this.size;
      }

      public Object firstKey() {
         this.fixup();
         Entry e = null;
         if (this.fromKey == null) {
            e = AbstractPatriciaTrie.this.firstEntry();
         } else {
            e = AbstractPatriciaTrie.this.higherEntry(this.fromKey);
         }

         Object first = e != null ? e.getKey() : null;
         if (e != null && AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, first)) {
            return first;
         } else {
            throw new NoSuchElementException();
         }
      }

      public Object lastKey() {
         this.fixup();
         Entry e = null;
         if (this.toKey == null) {
            e = AbstractPatriciaTrie.this.lastEntry();
         } else {
            e = AbstractPatriciaTrie.this.lowerEntry(this.toKey);
         }

         Object last = e != null ? e.getKey() : null;
         if (e != null && AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, last)) {
            return last;
         } else {
            throw new NoSuchElementException();
         }
      }

      protected boolean inRange(Object key) {
         return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key);
      }

      protected boolean inRange2(Object key) {
         return this.inRange(key);
      }

      protected boolean inFromRange(Object key, boolean forceInclusive) {
         return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key);
      }

      protected boolean inToRange(Object key, boolean forceInclusive) {
         return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, key);
      }

      protected Set createEntrySet() {
         return AbstractPatriciaTrie.this.new PrefixRangeEntrySet(this);
      }

      public Object getFromKey() {
         return this.fromKey;
      }

      public Object getToKey() {
         return this.toKey;
      }

      public boolean isFromInclusive() {
         return false;
      }

      public boolean isToInclusive() {
         return false;
      }

      protected SortedMap createRangeMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive) {
         return AbstractPatriciaTrie.this.new RangeEntryMap(fromKey, fromInclusive, toKey, toInclusive);
      }

      // $FF: synthetic method
      PrefixRangeMap(Object x1, int x2, int x3, Object x4) {
         this(x1, x2, x3);
      }
   }

   private class RangeEntrySet extends AbstractSet {
      private final AbstractPatriciaTrie.RangeMap delegate;
      private transient int size = -1;
      private transient int expectedModCount;

      public RangeEntrySet(AbstractPatriciaTrie.RangeMap delegate) {
         if (delegate == null) {
            throw new NullPointerException("delegate");
         } else {
            this.delegate = delegate;
         }
      }

      public Iterator iterator() {
         Object fromKey = this.delegate.getFromKey();
         Object toKey = this.delegate.getToKey();
         AbstractPatriciaTrie.TrieEntry first = null;
         if (fromKey == null) {
            first = AbstractPatriciaTrie.this.firstEntry();
         } else {
            first = AbstractPatriciaTrie.this.ceilingEntry(fromKey);
         }

         AbstractPatriciaTrie.TrieEntry last = null;
         if (toKey != null) {
            last = AbstractPatriciaTrie.this.ceilingEntry(toKey);
         }

         return new AbstractPatriciaTrie.RangeEntrySet.EntryIterator(first, last);
      }

      public int size() {
         if (this.size == -1 || this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
            this.size = 0;
            Iterator it = this.iterator();

            while(it.hasNext()) {
               ++this.size;
               it.next();
            }

            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
         }

         return this.size;
      }

      public boolean isEmpty() {
         return !this.iterator().hasNext();
      }

      public boolean contains(Object o) {
         if (!(o instanceof Entry)) {
            return false;
         } else {
            Entry entry = (Entry)o;
            Object key = entry.getKey();
            if (!this.delegate.inRange(key)) {
               return false;
            } else {
               AbstractPatriciaTrie.TrieEntry node = AbstractPatriciaTrie.this.getEntry(key);
               return node != null && AbstractBitwiseTrie.compare(node.getValue(), entry.getValue());
            }
         }
      }

      public boolean remove(Object o) {
         if (!(o instanceof Entry)) {
            return false;
         } else {
            Entry entry = (Entry)o;
            Object key = entry.getKey();
            if (!this.delegate.inRange(key)) {
               return false;
            } else {
               AbstractPatriciaTrie.TrieEntry node = AbstractPatriciaTrie.this.getEntry(key);
               if (node != null && AbstractBitwiseTrie.compare(node.getValue(), entry.getValue())) {
                  AbstractPatriciaTrie.this.removeEntry(node);
                  return true;
               } else {
                  return false;
               }
            }
         }
      }

      private final class EntryIterator extends AbstractPatriciaTrie.TrieIterator {
         private final Object excludedKey;

         private EntryIterator(AbstractPatriciaTrie.TrieEntry first, AbstractPatriciaTrie.TrieEntry last) {
            super(first);
            this.excludedKey = last != null ? last.getKey() : null;
         }

         public boolean hasNext() {
            return this.next != null && !AbstractBitwiseTrie.compare(this.next.key, this.excludedKey);
         }

         public Entry next() {
            if (this.next != null && !AbstractBitwiseTrie.compare(this.next.key, this.excludedKey)) {
               return this.nextEntry();
            } else {
               throw new NoSuchElementException();
            }
         }

         // $FF: synthetic method
         EntryIterator(AbstractPatriciaTrie.TrieEntry x1, AbstractPatriciaTrie.TrieEntry x2, Object x3) {
            this(x1, x2);
         }
      }
   }

   private class RangeEntryMap extends AbstractPatriciaTrie.RangeMap {
      private final Object fromKey;
      private final Object toKey;
      private final boolean fromInclusive;
      private final boolean toInclusive;

      protected RangeEntryMap(Object fromKey, Object toKey) {
         this(fromKey, true, toKey, false);
      }

      protected RangeEntryMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive) {
         super(null);
         if (fromKey == null && toKey == null) {
            throw new IllegalArgumentException("must have a from or to!");
         } else if (fromKey != null && toKey != null && AbstractPatriciaTrie.this.getKeyAnalyzer().compare(fromKey, toKey) > 0) {
            throw new IllegalArgumentException("fromKey > toKey");
         } else {
            this.fromKey = fromKey;
            this.fromInclusive = fromInclusive;
            this.toKey = toKey;
            this.toInclusive = toInclusive;
         }
      }

      public Object firstKey() {
         Entry e = null;
         if (this.fromKey == null) {
            e = AbstractPatriciaTrie.this.firstEntry();
         } else if (this.fromInclusive) {
            e = AbstractPatriciaTrie.this.ceilingEntry(this.fromKey);
         } else {
            e = AbstractPatriciaTrie.this.higherEntry(this.fromKey);
         }

         Object first = e != null ? e.getKey() : null;
         if (e != null && (this.toKey == null || this.inToRange(first, false))) {
            return first;
         } else {
            throw new NoSuchElementException();
         }
      }

      public Object lastKey() {
         AbstractPatriciaTrie.TrieEntry e;
         if (this.toKey == null) {
            e = AbstractPatriciaTrie.this.lastEntry();
         } else if (this.toInclusive) {
            e = AbstractPatriciaTrie.this.floorEntry(this.toKey);
         } else {
            e = AbstractPatriciaTrie.this.lowerEntry(this.toKey);
         }

         Object last = e != null ? e.getKey() : null;
         if (e != null && (this.fromKey == null || this.inFromRange(last, false))) {
            return last;
         } else {
            throw new NoSuchElementException();
         }
      }

      protected Set createEntrySet() {
         return AbstractPatriciaTrie.this.new RangeEntrySet(this);
      }

      public Object getFromKey() {
         return this.fromKey;
      }

      public Object getToKey() {
         return this.toKey;
      }

      public boolean isFromInclusive() {
         return this.fromInclusive;
      }

      public boolean isToInclusive() {
         return this.toInclusive;
      }

      protected SortedMap createRangeMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive) {
         return AbstractPatriciaTrie.this.new RangeEntryMap(fromKey, fromInclusive, toKey, toInclusive);
      }
   }

   private abstract class RangeMap extends AbstractMap implements SortedMap {
      private transient volatile Set entrySet;

      private RangeMap() {
      }

      protected abstract Set createEntrySet();

      protected abstract Object getFromKey();

      protected abstract boolean isFromInclusive();

      protected abstract Object getToKey();

      protected abstract boolean isToInclusive();

      public Comparator comparator() {
         return AbstractPatriciaTrie.this.comparator();
      }

      public boolean containsKey(Object key) {
         return !this.inRange(AbstractPatriciaTrie.this.castKey(key)) ? false : AbstractPatriciaTrie.this.containsKey(key);
      }

      public Object remove(Object key) {
         return !this.inRange(AbstractPatriciaTrie.this.castKey(key)) ? null : AbstractPatriciaTrie.this.remove(key);
      }

      public Object get(Object key) {
         return !this.inRange(AbstractPatriciaTrie.this.castKey(key)) ? null : AbstractPatriciaTrie.this.get(key);
      }

      public Object put(Object key, Object value) {
         if (!this.inRange(key)) {
            throw new IllegalArgumentException("Key is out of range: " + key);
         } else {
            return AbstractPatriciaTrie.this.put(key, value);
         }
      }

      public Set entrySet() {
         if (this.entrySet == null) {
            this.entrySet = this.createEntrySet();
         }

         return this.entrySet;
      }

      public SortedMap subMap(Object fromKey, Object toKey) {
         if (!this.inRange2(fromKey)) {
            throw new IllegalArgumentException("FromKey is out of range: " + fromKey);
         } else if (!this.inRange2(toKey)) {
            throw new IllegalArgumentException("ToKey is out of range: " + toKey);
         } else {
            return this.createRangeMap(fromKey, this.isFromInclusive(), toKey, this.isToInclusive());
         }
      }

      public SortedMap headMap(Object toKey) {
         if (!this.inRange2(toKey)) {
            throw new IllegalArgumentException("ToKey is out of range: " + toKey);
         } else {
            return this.createRangeMap(this.getFromKey(), this.isFromInclusive(), toKey, this.isToInclusive());
         }
      }

      public SortedMap tailMap(Object fromKey) {
         if (!this.inRange2(fromKey)) {
            throw new IllegalArgumentException("FromKey is out of range: " + fromKey);
         } else {
            return this.createRangeMap(fromKey, this.isFromInclusive(), this.getToKey(), this.isToInclusive());
         }
      }

      protected boolean inRange(Object key) {
         Object fromKey = this.getFromKey();
         Object toKey = this.getToKey();
         return (fromKey == null || this.inFromRange(key, false)) && (toKey == null || this.inToRange(key, false));
      }

      protected boolean inRange2(Object key) {
         Object fromKey = this.getFromKey();
         Object toKey = this.getToKey();
         return (fromKey == null || this.inFromRange(key, false)) && (toKey == null || this.inToRange(key, true));
      }

      protected boolean inFromRange(Object key, boolean forceInclusive) {
         Object fromKey = this.getFromKey();
         boolean fromInclusive = this.isFromInclusive();
         int ret = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(key, fromKey);
         if (!fromInclusive && !forceInclusive) {
            return ret > 0;
         } else {
            return ret >= 0;
         }
      }

      protected boolean inToRange(Object key, boolean forceInclusive) {
         Object toKey = this.getToKey();
         boolean toInclusive = this.isToInclusive();
         int ret = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(key, toKey);
         if (!toInclusive && !forceInclusive) {
            return ret < 0;
         } else {
            return ret <= 0;
         }
      }

      protected abstract SortedMap createRangeMap(Object var1, boolean var2, Object var3, boolean var4);

      // $FF: synthetic method
      RangeMap(Object x1) {
         this();
      }
   }

   private class TrieMapIterator extends AbstractPatriciaTrie.TrieIterator implements OrderedMapIterator {
      protected AbstractPatriciaTrie.TrieEntry previous;

      private TrieMapIterator() {
         super();
      }

      public Object next() {
         return this.nextEntry().getKey();
      }

      public Object getKey() {
         if (this.current == null) {
            throw new IllegalStateException();
         } else {
            return this.current.getKey();
         }
      }

      public Object getValue() {
         if (this.current == null) {
            throw new IllegalStateException();
         } else {
            return this.current.getValue();
         }
      }

      public Object setValue(Object value) {
         if (this.current == null) {
            throw new IllegalStateException();
         } else {
            return this.current.setValue(value);
         }
      }

      public boolean hasPrevious() {
         return this.previous != null;
      }

      public Object previous() {
         return this.previousEntry().getKey();
      }

      protected AbstractPatriciaTrie.TrieEntry nextEntry() {
         AbstractPatriciaTrie.TrieEntry nextEntry = super.nextEntry();
         this.previous = nextEntry;
         return nextEntry;
      }

      protected AbstractPatriciaTrie.TrieEntry previousEntry() {
         if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
            throw new ConcurrentModificationException();
         } else {
            AbstractPatriciaTrie.TrieEntry e = this.previous;
            if (e == null) {
               throw new NoSuchElementException();
            } else {
               this.previous = AbstractPatriciaTrie.this.previousEntry(e);
               this.next = this.current;
               this.current = e;
               return this.current;
            }
         }
      }

      // $FF: synthetic method
      TrieMapIterator(Object x1) {
         this();
      }
   }

   abstract class TrieIterator implements Iterator {
      protected int expectedModCount;
      protected AbstractPatriciaTrie.TrieEntry next;
      protected AbstractPatriciaTrie.TrieEntry current;

      protected TrieIterator() {
         this.expectedModCount = AbstractPatriciaTrie.this.modCount;
         this.next = AbstractPatriciaTrie.this.nextEntry((AbstractPatriciaTrie.TrieEntry)null);
      }

      protected TrieIterator(AbstractPatriciaTrie.TrieEntry firstEntry) {
         this.expectedModCount = AbstractPatriciaTrie.this.modCount;
         this.next = firstEntry;
      }

      protected AbstractPatriciaTrie.TrieEntry nextEntry() {
         if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
            throw new ConcurrentModificationException();
         } else {
            AbstractPatriciaTrie.TrieEntry e = this.next;
            if (e == null) {
               throw new NoSuchElementException();
            } else {
               this.next = this.findNext(e);
               this.current = e;
               return e;
            }
         }
      }

      protected AbstractPatriciaTrie.TrieEntry findNext(AbstractPatriciaTrie.TrieEntry prior) {
         return AbstractPatriciaTrie.this.nextEntry(prior);
      }

      public boolean hasNext() {
         return this.next != null;
      }

      public void remove() {
         if (this.current == null) {
            throw new IllegalStateException();
         } else if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
            throw new ConcurrentModificationException();
         } else {
            AbstractPatriciaTrie.TrieEntry node = this.current;
            this.current = null;
            AbstractPatriciaTrie.this.removeEntry(node);
            this.expectedModCount = AbstractPatriciaTrie.this.modCount;
         }
      }
   }

   private class Values extends AbstractCollection {
      private Values() {
      }

      public Iterator iterator() {
         return new AbstractPatriciaTrie.Values.ValueIterator();
      }

      public int size() {
         return AbstractPatriciaTrie.this.size();
      }

      public boolean contains(Object o) {
         return AbstractPatriciaTrie.this.containsValue(o);
      }

      public void clear() {
         AbstractPatriciaTrie.this.clear();
      }

      public boolean remove(Object o) {
         Iterator it = this.iterator();

         Object value;
         do {
            if (!it.hasNext()) {
               return false;
            }

            value = it.next();
         } while(!AbstractBitwiseTrie.compare(value, o));

         it.remove();
         return true;
      }

      // $FF: synthetic method
      Values(Object x1) {
         this();
      }

      private class ValueIterator extends AbstractPatriciaTrie.TrieIterator {
         private ValueIterator() {
            super();
         }

         public Object next() {
            return this.nextEntry().getValue();
         }

         // $FF: synthetic method
         ValueIterator(Object x1) {
            this();
         }
      }
   }

   private class KeySet extends AbstractSet {
      private KeySet() {
      }

      public Iterator iterator() {
         return new AbstractPatriciaTrie.KeySet.KeyIterator();
      }

      public int size() {
         return AbstractPatriciaTrie.this.size();
      }

      public boolean contains(Object o) {
         return AbstractPatriciaTrie.this.containsKey(o);
      }

      public boolean remove(Object o) {
         int size = this.size();
         AbstractPatriciaTrie.this.remove(o);
         return size != this.size();
      }

      public void clear() {
         AbstractPatriciaTrie.this.clear();
      }

      // $FF: synthetic method
      KeySet(Object x1) {
         this();
      }

      private class KeyIterator extends AbstractPatriciaTrie.TrieIterator {
         private KeyIterator() {
            super();
         }

         public Object next() {
            return this.nextEntry().getKey();
         }

         // $FF: synthetic method
         KeyIterator(Object x1) {
            this();
         }
      }
   }

   private class EntrySet extends AbstractSet {
      private EntrySet() {
      }

      public Iterator iterator() {
         return new AbstractPatriciaTrie.EntrySet.EntryIterator();
      }

      public boolean contains(Object o) {
         if (!(o instanceof Entry)) {
            return false;
         } else {
            AbstractPatriciaTrie.TrieEntry candidate = AbstractPatriciaTrie.this.getEntry(((Entry)o).getKey());
            return candidate != null && candidate.equals(o);
         }
      }

      public boolean remove(Object obj) {
         if (!(obj instanceof Entry)) {
            return false;
         } else if (!this.contains(obj)) {
            return false;
         } else {
            Entry entry = (Entry)obj;
            AbstractPatriciaTrie.this.remove(entry.getKey());
            return true;
         }
      }

      public int size() {
         return AbstractPatriciaTrie.this.size();
      }

      public void clear() {
         AbstractPatriciaTrie.this.clear();
      }

      // $FF: synthetic method
      EntrySet(Object x1) {
         this();
      }

      private class EntryIterator extends AbstractPatriciaTrie.TrieIterator {
         private EntryIterator() {
            super();
         }

         public Entry next() {
            return this.nextEntry();
         }

         // $FF: synthetic method
         EntryIterator(Object x1) {
            this();
         }
      }
   }

   protected static class TrieEntry extends AbstractBitwiseTrie.BasicEntry {
      private static final long serialVersionUID = 4596023148184140013L;
      protected int bitIndex;
      protected AbstractPatriciaTrie.TrieEntry parent;
      protected AbstractPatriciaTrie.TrieEntry left;
      protected AbstractPatriciaTrie.TrieEntry right;
      protected AbstractPatriciaTrie.TrieEntry predecessor;

      public TrieEntry(Object key, Object value, int bitIndex) {
         super(key, value);
         this.bitIndex = bitIndex;
         this.parent = null;
         this.left = this;
         this.right = null;
         this.predecessor = this;
      }

      public boolean isEmpty() {
         return this.key == null;
      }

      public boolean isInternalNode() {
         return this.left != this && this.right != this;
      }

      public boolean isExternalNode() {
         return !this.isInternalNode();
      }

      public String toString() {
         StringBuilder buffer = new StringBuilder();
         if (this.bitIndex == -1) {
            buffer.append("RootEntry(");
         } else {
            buffer.append("Entry(");
         }

         buffer.append("key=").append(this.getKey()).append(" [").append(this.bitIndex).append("], ");
         buffer.append("value=").append(this.getValue()).append(", ");
         if (this.parent != null) {
            if (this.parent.bitIndex == -1) {
               buffer.append("parent=").append("ROOT");
            } else {
               buffer.append("parent=").append(this.parent.getKey()).append(" [").append(this.parent.bitIndex).append("]");
            }
         } else {
            buffer.append("parent=").append("null");
         }

         buffer.append(", ");
         if (this.left != null) {
            if (this.left.bitIndex == -1) {
               buffer.append("left=").append("ROOT");
            } else {
               buffer.append("left=").append(this.left.getKey()).append(" [").append(this.left.bitIndex).append("]");
            }
         } else {
            buffer.append("left=").append("null");
         }

         buffer.append(", ");
         if (this.right != null) {
            if (this.right.bitIndex == -1) {
               buffer.append("right=").append("ROOT");
            } else {
               buffer.append("right=").append(this.right.getKey()).append(" [").append(this.right.bitIndex).append("]");
            }
         } else {
            buffer.append("right=").append("null");
         }

         buffer.append(", ");
         if (this.predecessor != null) {
            if (this.predecessor.bitIndex == -1) {
               buffer.append("predecessor=").append("ROOT");
            } else {
               buffer.append("predecessor=").append(this.predecessor.getKey()).append(" [").append(this.predecessor.bitIndex).append("]");
            }
         }

         buffer.append(")");
         return buffer.toString();
      }
   }

   private static class Reference {
      private Object item;

      private Reference() {
      }

      public void set(Object item) {
         this.item = item;
      }

      public Object get() {
         return this.item;
      }

      // $FF: synthetic method
      Reference(Object x0) {
         this();
      }
   }
}
