package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;

public class UnmodifiableTrie implements Trie, Serializable, Unmodifiable {
   private static final long serialVersionUID = -7156426030315945159L;
   private final Trie delegate;

   public static Trie unmodifiableTrie(Trie trie) {
      return (Trie)(trie instanceof Unmodifiable ? trie : new UnmodifiableTrie(trie));
   }

   public UnmodifiableTrie(Trie trie) {
      if (trie == null) {
         throw new NullPointerException("Trie must not be null");
      } else {
         this.delegate = trie;
      }
   }

   public Set entrySet() {
      return Collections.unmodifiableSet(this.delegate.entrySet());
   }

   public Set keySet() {
      return Collections.unmodifiableSet(this.delegate.keySet());
   }

   public Collection values() {
      return Collections.unmodifiableCollection(this.delegate.values());
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean containsKey(Object key) {
      return this.delegate.containsKey(key);
   }

   public boolean containsValue(Object value) {
      return this.delegate.containsValue(value);
   }

   public Object get(Object key) {
      return this.delegate.get(key);
   }

   public boolean isEmpty() {
      return this.delegate.isEmpty();
   }

   public Object put(Object key, Object value) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map m) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object key) {
      throw new UnsupportedOperationException();
   }

   public int size() {
      return this.delegate.size();
   }

   public Object firstKey() {
      return this.delegate.firstKey();
   }

   public SortedMap headMap(Object toKey) {
      return Collections.unmodifiableSortedMap(this.delegate.headMap(toKey));
   }

   public Object lastKey() {
      return this.delegate.lastKey();
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      return Collections.unmodifiableSortedMap(this.delegate.subMap(fromKey, toKey));
   }

   public SortedMap tailMap(Object fromKey) {
      return Collections.unmodifiableSortedMap(this.delegate.tailMap(fromKey));
   }

   public SortedMap prefixMap(Object key) {
      return Collections.unmodifiableSortedMap(this.delegate.prefixMap(key));
   }

   public Comparator comparator() {
      return this.delegate.comparator();
   }

   public OrderedMapIterator mapIterator() {
      OrderedMapIterator it = this.delegate.mapIterator();
      return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(it);
   }

   public Object nextKey(Object key) {
      return this.delegate.nextKey(key);
   }

   public Object previousKey(Object key) {
      return this.delegate.previousKey(key);
   }

   public int hashCode() {
      return this.delegate.hashCode();
   }

   public boolean equals(Object obj) {
      return this.delegate.equals(obj);
   }

   public String toString() {
      return this.delegate.toString();
   }
}
