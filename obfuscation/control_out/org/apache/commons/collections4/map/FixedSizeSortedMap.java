package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class FixedSizeSortedMap extends AbstractSortedMapDecorator implements BoundedMap, Serializable {
   private static final long serialVersionUID = 3126019624511683653L;

   public static FixedSizeSortedMap fixedSizeSortedMap(SortedMap map) {
      return new FixedSizeSortedMap(map);
   }

   protected FixedSizeSortedMap(SortedMap map) {
      super(map);
   }

   protected SortedMap getSortedMap() {
      return (SortedMap)this.map;
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.map);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }

   public Object put(Object key, Object value) {
      if (!this.map.containsKey(key)) {
         throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
      } else {
         return this.map.put(key, value);
      }
   }

   public void putAll(Map mapToCopy) {
      if (CollectionUtils.isSubCollection(mapToCopy.keySet(), this.keySet())) {
         throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
      } else {
         this.map.putAll(mapToCopy);
      }
   }

   public void clear() {
      throw new UnsupportedOperationException("Map is fixed size");
   }

   public Object remove(Object key) {
      throw new UnsupportedOperationException("Map is fixed size");
   }

   public Set entrySet() {
      return UnmodifiableSet.unmodifiableSet(this.map.entrySet());
   }

   public Set keySet() {
      return UnmodifiableSet.unmodifiableSet(this.map.keySet());
   }

   public Collection values() {
      return UnmodifiableCollection.unmodifiableCollection(this.map.values());
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      return new FixedSizeSortedMap(this.getSortedMap().subMap(fromKey, toKey));
   }

   public SortedMap headMap(Object toKey) {
      return new FixedSizeSortedMap(this.getSortedMap().headMap(toKey));
   }

   public SortedMap tailMap(Object fromKey) {
      return new FixedSizeSortedMap(this.getSortedMap().tailMap(fromKey));
   }

   public boolean isFull() {
      return true;
   }

   public int maxSize() {
      return this.size();
   }
}
