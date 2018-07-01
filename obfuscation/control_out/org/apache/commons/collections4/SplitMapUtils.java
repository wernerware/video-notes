package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class SplitMapUtils {
   public static IterableMap readableMap(Get get) {
      if (get == null) {
         throw new NullPointerException("Get must not be null");
      } else if (get instanceof Map) {
         return get instanceof IterableMap ? (IterableMap)get : MapUtils.iterableMap((Map)get);
      } else {
         return new SplitMapUtils.WrappedGet(get);
      }
   }

   public static Map writableMap(Put put) {
      if (put == null) {
         throw new NullPointerException("Put must not be null");
      } else {
         return (Map)(put instanceof Map ? (Map)put : new SplitMapUtils.WrappedPut(put));
      }
   }

   private static class WrappedPut implements Map, Put {
      private final Put put;

      private WrappedPut(Put put) {
         this.put = put;
      }

      public void clear() {
         this.put.clear();
      }

      public boolean containsKey(Object key) {
         throw new UnsupportedOperationException();
      }

      public boolean containsValue(Object value) {
         throw new UnsupportedOperationException();
      }

      public Set entrySet() {
         throw new UnsupportedOperationException();
      }

      public boolean equals(Object obj) {
         if (obj == this) {
            return true;
         } else {
            return obj instanceof SplitMapUtils.WrappedPut && ((SplitMapUtils.WrappedPut)obj).put.equals(this.put);
         }
      }

      public Object get(Object key) {
         throw new UnsupportedOperationException();
      }

      public int hashCode() {
         return "WrappedPut".hashCode() << 4 | this.put.hashCode();
      }

      public boolean isEmpty() {
         throw new UnsupportedOperationException();
      }

      public Set keySet() {
         throw new UnsupportedOperationException();
      }

      public Object put(Object key, Object value) {
         return this.put.put(key, value);
      }

      public void putAll(Map t) {
         this.put.putAll(t);
      }

      public Object remove(Object key) {
         throw new UnsupportedOperationException();
      }

      public int size() {
         throw new UnsupportedOperationException();
      }

      public Collection values() {
         throw new UnsupportedOperationException();
      }

      // $FF: synthetic method
      WrappedPut(Put x0, Object x1) {
         this(x0);
      }
   }

   private static class WrappedGet implements IterableMap, Unmodifiable {
      private final Get get;

      private WrappedGet(Get get) {
         this.get = get;
      }

      public void clear() {
         throw new UnsupportedOperationException();
      }

      public boolean containsKey(Object key) {
         return this.get.containsKey(key);
      }

      public boolean containsValue(Object value) {
         return this.get.containsValue(value);
      }

      public Set entrySet() {
         return UnmodifiableEntrySet.unmodifiableEntrySet(this.get.entrySet());
      }

      public boolean equals(Object arg0) {
         if (arg0 == this) {
            return true;
         } else {
            return arg0 instanceof SplitMapUtils.WrappedGet && ((SplitMapUtils.WrappedGet)arg0).get.equals(this.get);
         }
      }

      public Object get(Object key) {
         return this.get.get(key);
      }

      public int hashCode() {
         return "WrappedGet".hashCode() << 4 | this.get.hashCode();
      }

      public boolean isEmpty() {
         return this.get.isEmpty();
      }

      public Set keySet() {
         return UnmodifiableSet.unmodifiableSet(this.get.keySet());
      }

      public Object put(Object key, Object value) {
         throw new UnsupportedOperationException();
      }

      public void putAll(Map t) {
         throw new UnsupportedOperationException();
      }

      public Object remove(Object key) {
         return this.get.remove(key);
      }

      public int size() {
         return this.get.size();
      }

      public Collection values() {
         return UnmodifiableCollection.unmodifiableCollection(this.get.values());
      }

      public MapIterator mapIterator() {
         Object it;
         if (this.get instanceof IterableGet) {
            it = ((IterableGet)this.get).mapIterator();
         } else {
            it = new EntrySetToMapIteratorAdapter(this.get.entrySet());
         }

         return UnmodifiableMapIterator.unmodifiableMapIterator((MapIterator)it);
      }

      // $FF: synthetic method
      WrappedGet(Get x0, Object x1) {
         this(x0);
      }
   }
}
