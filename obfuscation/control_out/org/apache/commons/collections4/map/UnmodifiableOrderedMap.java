package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public final class UnmodifiableOrderedMap extends AbstractOrderedMapDecorator implements Unmodifiable, Serializable {
   private static final long serialVersionUID = 8136428161720526266L;

   public static OrderedMap unmodifiableOrderedMap(OrderedMap map) {
      return (OrderedMap)(map instanceof Unmodifiable ? map : new UnmodifiableOrderedMap(map));
   }

   private UnmodifiableOrderedMap(OrderedMap map) {
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

   public OrderedMapIterator mapIterator() {
      OrderedMapIterator it = this.decorated().mapIterator();
      return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(it);
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
      Set set = super.entrySet();
      return UnmodifiableEntrySet.unmodifiableEntrySet(set);
   }

   public Set keySet() {
      Set set = super.keySet();
      return UnmodifiableSet.unmodifiableSet(set);
   }

   public Collection values() {
      Collection coll = super.values();
      return UnmodifiableCollection.unmodifiableCollection(coll);
   }
}
