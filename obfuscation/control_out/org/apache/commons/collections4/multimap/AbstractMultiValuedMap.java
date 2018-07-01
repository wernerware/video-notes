package org.apache.commons.collections4.multimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;
import org.apache.commons.collections4.multiset.AbstractMultiSet;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;

public abstract class AbstractMultiValuedMap implements MultiValuedMap {
   private transient Collection valuesView;
   private transient AbstractMultiValuedMap.EntryValues entryValuesView;
   private transient MultiSet keysMultiSetView;
   private transient AbstractMultiValuedMap.AsMap asMapView;
   private transient Map map;

   protected AbstractMultiValuedMap() {
   }

   protected AbstractMultiValuedMap(Map map) {
      if (map == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         this.map = map;
      }
   }

   protected Map getMap() {
      return this.map;
   }

   protected void setMap(Map map) {
      this.map = map;
   }

   protected abstract Collection createCollection();

   public boolean containsKey(Object key) {
      return this.getMap().containsKey(key);
   }

   public boolean containsValue(Object value) {
      return this.values().contains(value);
   }

   public boolean containsMapping(Object key, Object value) {
      Collection coll = (Collection)this.getMap().get(key);
      return coll != null && coll.contains(value);
   }

   public Collection entries() {
      return this.entryValuesView != null ? this.entryValuesView : (this.entryValuesView = new AbstractMultiValuedMap.EntryValues());
   }

   public Collection get(Object key) {
      return this.wrappedCollection(key);
   }

   Collection wrappedCollection(Object key) {
      return new AbstractMultiValuedMap.WrappedCollection(key);
   }

   public Collection remove(Object key) {
      return CollectionUtils.emptyIfNull((Collection)this.getMap().remove(key));
   }

   public boolean removeMapping(Object key, Object value) {
      Collection coll = (Collection)this.getMap().get(key);
      if (coll == null) {
         return false;
      } else {
         boolean changed = coll.remove(value);
         if (coll.isEmpty()) {
            this.getMap().remove(key);
         }

         return changed;
      }
   }

   public boolean isEmpty() {
      return this.getMap().isEmpty();
   }

   public Set keySet() {
      return this.getMap().keySet();
   }

   public int size() {
      int size = 0;

      Collection col;
      for(Iterator i$ = this.getMap().values().iterator(); i$.hasNext(); size += col.size()) {
         col = (Collection)i$.next();
      }

      return size;
   }

   public Collection values() {
      Collection vs = this.valuesView;
      return vs != null ? vs : (this.valuesView = new AbstractMultiValuedMap.Values());
   }

   public void clear() {
      this.getMap().clear();
   }

   public boolean put(Object key, Object value) {
      Collection coll = (Collection)this.getMap().get(key);
      if (coll == null) {
         coll = this.createCollection();
         if (coll.add(value)) {
            this.map.put(key, coll);
            return true;
         } else {
            return false;
         }
      } else {
         return coll.add(value);
      }
   }

   public boolean putAll(Map map) {
      if (map == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         boolean changed = false;

         Entry entry;
         for(Iterator i$ = map.entrySet().iterator(); i$.hasNext(); changed |= this.put(entry.getKey(), entry.getValue())) {
            entry = (Entry)i$.next();
         }

         return changed;
      }
   }

   public boolean putAll(MultiValuedMap map) {
      if (map == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         boolean changed = false;

         Entry entry;
         for(Iterator i$ = map.entries().iterator(); i$.hasNext(); changed |= this.put(entry.getKey(), entry.getValue())) {
            entry = (Entry)i$.next();
         }

         return changed;
      }
   }

   public MultiSet keys() {
      if (this.keysMultiSetView == null) {
         this.keysMultiSetView = UnmodifiableMultiSet.unmodifiableMultiSet(new AbstractMultiValuedMap.KeysMultiSet());
      }

      return this.keysMultiSetView;
   }

   public Map asMap() {
      return this.asMapView != null ? this.asMapView : (this.asMapView = new AbstractMultiValuedMap.AsMap(this.map));
   }

   public boolean putAll(Object key, Iterable values) {
      if (values == null) {
         throw new NullPointerException("Values must not be null.");
      } else if (values instanceof Collection) {
         Collection valueCollection = (Collection)values;
         return !valueCollection.isEmpty() && this.get(key).addAll(valueCollection);
      } else {
         Iterator it = values.iterator();
         return it.hasNext() && CollectionUtils.addAll(this.get(key), it);
      }
   }

   public MapIterator mapIterator() {
      return (MapIterator)(this.size() == 0 ? EmptyMapIterator.emptyMapIterator() : new AbstractMultiValuedMap.MultiValuedMapIterator());
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else {
         return obj instanceof MultiValuedMap ? this.asMap().equals(((MultiValuedMap)obj).asMap()) : false;
      }
   }

   public int hashCode() {
      return this.getMap().hashCode();
   }

   public String toString() {
      return this.getMap().toString();
   }

   protected void doWriteObject(ObjectOutputStream out) throws IOException {
      out.writeInt(this.map.size());
      Iterator i$ = this.map.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         out.writeObject(entry.getKey());
         out.writeInt(((Collection)entry.getValue()).size());
         Iterator i$ = ((Collection)entry.getValue()).iterator();

         while(i$.hasNext()) {
            Object value = i$.next();
            out.writeObject(value);
         }
      }

   }

   protected void doReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      int entrySize = in.readInt();

      for(int i = 0; i < entrySize; ++i) {
         Object key = in.readObject();
         Collection values = this.get(key);
         int valueSize = in.readInt();

         for(int j = 0; j < valueSize; ++j) {
            Object value = in.readObject();
            values.add(value);
         }
      }

   }

   private class AsMap extends AbstractMap {
      final transient Map decoratedMap;

      AsMap(Map map) {
         this.decoratedMap = map;
      }

      public Set entrySet() {
         return new AbstractMultiValuedMap.AsMap.AsMapEntrySet();
      }

      public boolean containsKey(Object key) {
         return this.decoratedMap.containsKey(key);
      }

      public Collection get(Object key) {
         Collection collection = (Collection)this.decoratedMap.get(key);
         return collection == null ? null : AbstractMultiValuedMap.this.wrappedCollection(key);
      }

      public Set keySet() {
         return AbstractMultiValuedMap.this.keySet();
      }

      public int size() {
         return this.decoratedMap.size();
      }

      public Collection remove(Object key) {
         Collection collection = (Collection)this.decoratedMap.remove(key);
         if (collection == null) {
            return null;
         } else {
            Collection output = AbstractMultiValuedMap.this.createCollection();
            output.addAll(collection);
            collection.clear();
            return output;
         }
      }

      public boolean equals(Object object) {
         return this == object || this.decoratedMap.equals(object);
      }

      public int hashCode() {
         return this.decoratedMap.hashCode();
      }

      public String toString() {
         return this.decoratedMap.toString();
      }

      public void clear() {
         AbstractMultiValuedMap.this.clear();
      }

      class AsMapEntrySetIterator extends AbstractIteratorDecorator {
         AsMapEntrySetIterator(Iterator iterator) {
            super(iterator);
         }

         public Entry next() {
            Entry entry = (Entry)super.next();
            Object key = entry.getKey();
            return new UnmodifiableMapEntry(key, AbstractMultiValuedMap.this.wrappedCollection(key));
         }
      }

      class AsMapEntrySet extends AbstractSet {
         public Iterator iterator() {
            return AsMap.this.new AsMapEntrySetIterator(AsMap.this.decoratedMap.entrySet().iterator());
         }

         public int size() {
            return AsMap.this.size();
         }

         public void clear() {
            AsMap.this.clear();
         }

         public boolean contains(Object o) {
            return AsMap.this.decoratedMap.entrySet().contains(o);
         }

         public boolean remove(Object o) {
            if (!this.contains(o)) {
               return false;
            } else {
               Entry entry = (Entry)o;
               AbstractMultiValuedMap.this.remove(entry.getKey());
               return true;
            }
         }
      }
   }

   private class ValuesIterator implements Iterator {
      private final Object key;
      private final Collection values;
      private final Iterator iterator;

      public ValuesIterator(Object key) {
         this.key = key;
         this.values = (Collection)AbstractMultiValuedMap.this.getMap().get(key);
         this.iterator = this.values.iterator();
      }

      public void remove() {
         this.iterator.remove();
         if (this.values.isEmpty()) {
            AbstractMultiValuedMap.this.remove(this.key);
         }

      }

      public boolean hasNext() {
         return this.iterator.hasNext();
      }

      public Object next() {
         return this.iterator.next();
      }
   }

   private class Values extends AbstractCollection {
      private Values() {
      }

      public Iterator iterator() {
         IteratorChain chain = new IteratorChain();
         Iterator i$ = AbstractMultiValuedMap.this.keySet().iterator();

         while(i$.hasNext()) {
            Object k = i$.next();
            chain.addIterator(AbstractMultiValuedMap.this.new ValuesIterator(k));
         }

         return chain;
      }

      public int size() {
         return AbstractMultiValuedMap.this.size();
      }

      public void clear() {
         AbstractMultiValuedMap.this.clear();
      }

      // $FF: synthetic method
      Values(Object x1) {
         this();
      }
   }

   private class MultiValuedMapIterator implements MapIterator {
      private final Iterator it = AbstractMultiValuedMap.this.entries().iterator();
      private Entry current = null;

      public boolean hasNext() {
         return this.it.hasNext();
      }

      public Object next() {
         this.current = (Entry)this.it.next();
         return this.current.getKey();
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

      public void remove() {
         this.it.remove();
      }

      public Object setValue(Object value) {
         if (this.current == null) {
            throw new IllegalStateException();
         } else {
            return this.current.setValue(value);
         }
      }
   }

   private class MultiValuedMapEntry extends AbstractMapEntry {
      public MultiValuedMapEntry(Object key, Object value) {
         super(key, value);
      }

      public Object setValue(Object value) {
         throw new UnsupportedOperationException();
      }
   }

   private class EntryValues extends AbstractCollection {
      private EntryValues() {
      }

      public Iterator iterator() {
         return new LazyIteratorChain() {
            final Collection keysCol = new ArrayList(AbstractMultiValuedMap.this.getMap().keySet());
            final Iterator keyIterator;

            {
               this.keyIterator = this.keysCol.iterator();
            }

            protected Iterator nextIterator(int count) {
               if (!this.keyIterator.hasNext()) {
                  return null;
               } else {
                  final Object key = this.keyIterator.next();
                  Transformer entryTransformer = new Transformer() {
                     public Entry transform(Object input) {
                        return AbstractMultiValuedMap.this.new MultiValuedMapEntry(key, input);
                     }
                  };
                  return new TransformIterator(AbstractMultiValuedMap.this.new ValuesIterator(key), entryTransformer);
               }
            }
         };
      }

      public int size() {
         return AbstractMultiValuedMap.this.size();
      }

      // $FF: synthetic method
      EntryValues(Object x1) {
         this();
      }
   }

   private class KeysMultiSet extends AbstractMultiSet {
      private KeysMultiSet() {
      }

      public boolean contains(Object o) {
         return AbstractMultiValuedMap.this.getMap().containsKey(o);
      }

      public boolean isEmpty() {
         return AbstractMultiValuedMap.this.getMap().isEmpty();
      }

      public int size() {
         return AbstractMultiValuedMap.this.size();
      }

      protected int uniqueElements() {
         return AbstractMultiValuedMap.this.getMap().size();
      }

      public int getCount(Object object) {
         int count = 0;
         Collection col = (Collection)AbstractMultiValuedMap.this.getMap().get(object);
         if (col != null) {
            count = col.size();
         }

         return count;
      }

      protected Iterator createEntrySetIterator() {
         AbstractMultiValuedMap.KeysMultiSet.MapEntryTransformer transformer = new AbstractMultiValuedMap.KeysMultiSet.MapEntryTransformer();
         return IteratorUtils.transformedIterator(AbstractMultiValuedMap.this.map.entrySet().iterator(), transformer);
      }

      // $FF: synthetic method
      KeysMultiSet(Object x1) {
         this();
      }

      private final class MapEntryTransformer implements Transformer {
         private MapEntryTransformer() {
         }

         public MultiSet.Entry transform(final Entry mapEntry) {
            return new AbstractMultiSet.AbstractEntry() {
               public Object getElement() {
                  return mapEntry.getKey();
               }

               public int getCount() {
                  return ((Collection)mapEntry.getValue()).size();
               }
            };
         }

         // $FF: synthetic method
         MapEntryTransformer(Object x1) {
            this();
         }
      }
   }

   class WrappedCollection implements Collection {
      protected final Object key;

      public WrappedCollection(Object key) {
         this.key = key;
      }

      protected Collection getMapping() {
         return (Collection)AbstractMultiValuedMap.this.getMap().get(this.key);
      }

      public boolean add(Object value) {
         Collection coll = this.getMapping();
         if (coll == null) {
            coll = AbstractMultiValuedMap.this.createCollection();
            AbstractMultiValuedMap.this.map.put(this.key, coll);
         }

         return coll.add(value);
      }

      public boolean addAll(Collection other) {
         Collection coll = this.getMapping();
         if (coll == null) {
            coll = AbstractMultiValuedMap.this.createCollection();
            AbstractMultiValuedMap.this.map.put(this.key, coll);
         }

         return coll.addAll(other);
      }

      public void clear() {
         Collection coll = this.getMapping();
         if (coll != null) {
            coll.clear();
            AbstractMultiValuedMap.this.remove(this.key);
         }

      }

      public Iterator iterator() {
         Collection coll = this.getMapping();
         return (Iterator)(coll == null ? IteratorUtils.EMPTY_ITERATOR : AbstractMultiValuedMap.this.new ValuesIterator(this.key));
      }

      public int size() {
         Collection coll = this.getMapping();
         return coll == null ? 0 : coll.size();
      }

      public boolean contains(Object obj) {
         Collection coll = this.getMapping();
         return coll == null ? false : coll.contains(obj);
      }

      public boolean containsAll(Collection other) {
         Collection coll = this.getMapping();
         return coll == null ? false : coll.containsAll(other);
      }

      public boolean isEmpty() {
         Collection coll = this.getMapping();
         return coll == null ? true : coll.isEmpty();
      }

      public boolean remove(Object item) {
         Collection coll = this.getMapping();
         if (coll == null) {
            return false;
         } else {
            boolean result = coll.remove(item);
            if (coll.isEmpty()) {
               AbstractMultiValuedMap.this.remove(this.key);
            }

            return result;
         }
      }

      public boolean removeAll(Collection c) {
         Collection coll = this.getMapping();
         if (coll == null) {
            return false;
         } else {
            boolean result = coll.removeAll(c);
            if (coll.isEmpty()) {
               AbstractMultiValuedMap.this.remove(this.key);
            }

            return result;
         }
      }

      public boolean retainAll(Collection c) {
         Collection coll = this.getMapping();
         if (coll == null) {
            return false;
         } else {
            boolean result = coll.retainAll(c);
            if (coll.isEmpty()) {
               AbstractMultiValuedMap.this.remove(this.key);
            }

            return result;
         }
      }

      public Object[] toArray() {
         Collection coll = this.getMapping();
         return coll == null ? CollectionUtils.EMPTY_COLLECTION.toArray() : coll.toArray();
      }

      public Object[] toArray(Object[] a) {
         Collection coll = this.getMapping();
         return coll == null ? (Object[])CollectionUtils.EMPTY_COLLECTION.toArray(a) : coll.toArray(a);
      }

      public String toString() {
         Collection coll = this.getMapping();
         return coll == null ? CollectionUtils.EMPTY_COLLECTION.toString() : coll.toString();
      }
   }
}
