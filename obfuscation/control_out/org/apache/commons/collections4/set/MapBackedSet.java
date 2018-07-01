package org.apache.commons.collections4.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MapBackedSet implements Set, Serializable {
   private static final long serialVersionUID = 6723912213766056587L;
   private final Map map;
   private final Object dummyValue;

   public static MapBackedSet mapBackedSet(Map map) {
      return mapBackedSet(map, (Object)null);
   }

   public static MapBackedSet mapBackedSet(Map map, Object dummyValue) {
      return new MapBackedSet(map, dummyValue);
   }

   private MapBackedSet(Map map, Object dummyValue) {
      if (map == null) {
         throw new NullPointerException("The map must not be null");
      } else {
         this.map = map;
         this.dummyValue = dummyValue;
      }
   }

   public int size() {
      return this.map.size();
   }

   public boolean isEmpty() {
      return this.map.isEmpty();
   }

   public Iterator iterator() {
      return this.map.keySet().iterator();
   }

   public boolean contains(Object obj) {
      return this.map.containsKey(obj);
   }

   public boolean containsAll(Collection coll) {
      return this.map.keySet().containsAll(coll);
   }

   public boolean add(Object obj) {
      int size = this.map.size();
      this.map.put(obj, this.dummyValue);
      return this.map.size() != size;
   }

   public boolean addAll(Collection coll) {
      int size = this.map.size();
      Iterator i$ = coll.iterator();

      while(i$.hasNext()) {
         Object e = i$.next();
         this.map.put(e, this.dummyValue);
      }

      return this.map.size() != size;
   }

   public boolean remove(Object obj) {
      int size = this.map.size();
      this.map.remove(obj);
      return this.map.size() != size;
   }

   public boolean removeAll(Collection coll) {
      return this.map.keySet().removeAll(coll);
   }

   public boolean retainAll(Collection coll) {
      return this.map.keySet().retainAll(coll);
   }

   public void clear() {
      this.map.clear();
   }

   public Object[] toArray() {
      return this.map.keySet().toArray();
   }

   public Object[] toArray(Object[] array) {
      return this.map.keySet().toArray(array);
   }

   public boolean equals(Object obj) {
      return this.map.keySet().equals(obj);
   }

   public int hashCode() {
      return this.map.keySet().hashCode();
   }
}
