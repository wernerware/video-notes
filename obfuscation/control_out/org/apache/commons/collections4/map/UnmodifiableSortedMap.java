package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableSortedMap extends AbstractSortedMapDecorator implements Unmodifiable, Serializable {
   private static final long serialVersionUID = 5805344239827376360L;

   public static SortedMap unmodifiableSortedMap(SortedMap map) {
      return (SortedMap)(map instanceof Unmodifiable ? map : new UnmodifiableSortedMap(map));
   }

   private UnmodifiableSortedMap(SortedMap map) {
      super(map);
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.map);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Object put(Object key, Object value) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map mapToCopy) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object key) {
      throw new UnsupportedOperationException();
   }

   public Set entrySet() {
      return UnmodifiableEntrySet.unmodifiableEntrySet(super.entrySet());
   }

   public Set keySet() {
      return UnmodifiableSet.unmodifiableSet(super.keySet());
   }

   public Collection values() {
      return UnmodifiableCollection.unmodifiableCollection(super.values());
   }

   public Object firstKey() {
      return this.decorated().firstKey();
   }

   public Object lastKey() {
      return this.decorated().lastKey();
   }

   public Comparator comparator() {
      return this.decorated().comparator();
   }

   public SortedMap subMap(Object fromKey, Object toKey) {
      return new UnmodifiableSortedMap(this.decorated().subMap(fromKey, toKey));
   }

   public SortedMap headMap(Object toKey) {
      return new UnmodifiableSortedMap(this.decorated().headMap(toKey));
   }

   public SortedMap tailMap(Object fromKey) {
      return new UnmodifiableSortedMap(this.decorated().tailMap(fromKey));
   }
}
