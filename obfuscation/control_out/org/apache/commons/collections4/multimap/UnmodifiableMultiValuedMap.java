package org.apache.commons.collections4.multimap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableMultiValuedMap extends AbstractMultiValuedMapDecorator implements Unmodifiable {
   private static final long serialVersionUID = 20150612L;

   public static UnmodifiableMultiValuedMap unmodifiableMultiValuedMap(MultiValuedMap map) {
      return map instanceof Unmodifiable ? (UnmodifiableMultiValuedMap)map : new UnmodifiableMultiValuedMap(map);
   }

   private UnmodifiableMultiValuedMap(MultiValuedMap map) {
      super(map);
   }

   public Collection remove(Object key) {
      throw new UnsupportedOperationException();
   }

   public boolean removeMapping(Object key, Object item) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Collection get(Object key) {
      return UnmodifiableCollection.unmodifiableCollection(this.decorated().get(key));
   }

   public boolean put(Object key, Object value) {
      throw new UnsupportedOperationException();
   }

   public Set keySet() {
      return UnmodifiableSet.unmodifiableSet(this.decorated().keySet());
   }

   public Collection entries() {
      return UnmodifiableCollection.unmodifiableCollection(this.decorated().entries());
   }

   public MultiSet keys() {
      return UnmodifiableMultiSet.unmodifiableMultiSet(this.decorated().keys());
   }

   public Collection values() {
      return UnmodifiableCollection.unmodifiableCollection(this.decorated().values());
   }

   public Map asMap() {
      return UnmodifiableMap.unmodifiableMap(this.decorated().asMap());
   }

   public MapIterator mapIterator() {
      return UnmodifiableMapIterator.unmodifiableMapIterator(this.decorated().mapIterator());
   }

   public boolean putAll(Object key, Iterable values) {
      throw new UnsupportedOperationException();
   }

   public boolean putAll(Map map) {
      throw new UnsupportedOperationException();
   }

   public boolean putAll(MultiValuedMap map) {
      throw new UnsupportedOperationException();
   }
}
