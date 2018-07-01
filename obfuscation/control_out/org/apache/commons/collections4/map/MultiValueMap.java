package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

/** @deprecated */
@Deprecated
public class MultiValueMap extends AbstractMapDecorator implements MultiMap, Serializable {
   private static final long serialVersionUID = -2214159910087182007L;
   private final Factory collectionFactory;
   private transient Collection valuesView;

   public static MultiValueMap multiValueMap(Map map) {
      return multiValueMap(map, ArrayList.class);
   }

   public static MultiValueMap multiValueMap(Map map, Class collectionClass) {
      return new MultiValueMap(map, new MultiValueMap.ReflectionFactory(collectionClass));
   }

   public static MultiValueMap multiValueMap(Map map, Factory collectionFactory) {
      return new MultiValueMap(map, collectionFactory);
   }

   public MultiValueMap() {
      this(new HashMap(), new MultiValueMap.ReflectionFactory(ArrayList.class));
   }

   protected MultiValueMap(Map map, Factory collectionFactory) {
      super(map);
      if (collectionFactory == null) {
         throw new IllegalArgumentException("The factory must not be null");
      } else {
         this.collectionFactory = collectionFactory;
      }
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
      this.decorated().clear();
   }

   public boolean removeMapping(Object key, Object value) {
      Collection valuesForKey = this.getCollection(key);
      if (valuesForKey == null) {
         return false;
      } else {
         boolean removed = valuesForKey.remove(value);
         if (!removed) {
            return false;
         } else {
            if (valuesForKey.isEmpty()) {
               this.remove(key);
            }

            return true;
         }
      }
   }

   public boolean containsValue(Object value) {
      Set pairs = this.decorated().entrySet();
      if (pairs != null) {
         Iterator i$ = pairs.iterator();

         while(i$.hasNext()) {
            Entry entry = (Entry)i$.next();
            if (((Collection)entry.getValue()).contains(value)) {
               return true;
            }
         }
      }

      return false;
   }

   public Object put(Object key, Object value) {
      boolean result = false;
      Collection coll = this.getCollection(key);
      if (coll == null) {
         coll = this.createCollection(1);
         coll.add(value);
         if (coll.size() > 0) {
            this.decorated().put(key, coll);
            result = true;
         }
      } else {
         result = coll.add(value);
      }

      return result ? value : null;
   }

   public void putAll(Map map) {
      Iterator i$;
      Entry entry;
      if (map instanceof MultiMap) {
         i$ = ((MultiMap)map).entrySet().iterator();

         while(i$.hasNext()) {
            entry = (Entry)i$.next();
            this.putAll(entry.getKey(), (Collection)entry.getValue());
         }
      } else {
         i$ = map.entrySet().iterator();

         while(i$.hasNext()) {
            entry = (Entry)i$.next();
            this.put(entry.getKey(), entry.getValue());
         }
      }

   }

   public Set entrySet() {
      return super.entrySet();
   }

   public Collection values() {
      Collection vs = this.valuesView;
      return vs != null ? vs : (this.valuesView = new MultiValueMap.Values());
   }

   public boolean containsValue(Object key, Object value) {
      Collection coll = this.getCollection(key);
      return coll == null ? false : coll.contains(value);
   }

   public Collection getCollection(Object key) {
      return (Collection)this.decorated().get(key);
   }

   public int size(Object key) {
      Collection coll = this.getCollection(key);
      return coll == null ? 0 : coll.size();
   }

   public boolean putAll(Object key, Collection values) {
      if (values != null && values.size() != 0) {
         boolean result = false;
         Collection coll = this.getCollection(key);
         if (coll == null) {
            coll = this.createCollection(values.size());
            coll.addAll(values);
            if (coll.size() > 0) {
               this.decorated().put(key, coll);
               result = true;
            }
         } else {
            result = coll.addAll(values);
         }

         return result;
      } else {
         return false;
      }
   }

   public Iterator iterator(Object key) {
      return (Iterator)(!this.containsKey(key) ? EmptyIterator.emptyIterator() : new MultiValueMap.ValuesIterator(key));
   }

   public Iterator iterator() {
      Collection allKeys = new ArrayList(this.keySet());
      final Iterator keyIterator = allKeys.iterator();
      return new LazyIteratorChain() {
         protected Iterator nextIterator(int count) {
            if (!keyIterator.hasNext()) {
               return null;
            } else {
               final Object key = keyIterator.next();
               Transformer transformer = new Transformer() {
                  public Entry transform(final Object input) {
                     return new Entry() {
                        public Object getKey() {
                           return key;
                        }

                        public Object getValue() {
                           return input;
                        }

                        public Object setValue(Object value) {
                           throw new UnsupportedOperationException();
                        }
                     };
                  }
               };
               return new TransformIterator(MultiValueMap.this.new ValuesIterator(key), transformer);
            }
         }
      };
   }

   public int totalSize() {
      int total = 0;

      Object v;
      for(Iterator i$ = this.decorated().values().iterator(); i$.hasNext(); total += CollectionUtils.size(v)) {
         v = i$.next();
      }

      return total;
   }

   protected Collection createCollection(int size) {
      return (Collection)this.collectionFactory.create();
   }

   private static class ReflectionFactory implements Factory, Serializable {
      private static final long serialVersionUID = 2986114157496788874L;
      private final Class clazz;

      public ReflectionFactory(Class clazz) {
         this.clazz = clazz;
      }

      public Collection create() {
         try {
            return (Collection)this.clazz.newInstance();
         } catch (Exception var2) {
            throw new FunctorException("Cannot instantiate class: " + this.clazz, var2);
         }
      }

      private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
         is.defaultReadObject();
         if (this.clazz != null && !Collection.class.isAssignableFrom(this.clazz)) {
            throw new UnsupportedOperationException();
         }
      }
   }

   private class ValuesIterator implements Iterator {
      private final Object key;
      private final Collection values;
      private final Iterator iterator;

      public ValuesIterator(Object key) {
         this.key = key;
         this.values = MultiValueMap.this.getCollection(key);
         this.iterator = this.values.iterator();
      }

      public void remove() {
         this.iterator.remove();
         if (this.values.isEmpty()) {
            MultiValueMap.this.remove(this.key);
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
         Iterator i$ = MultiValueMap.this.keySet().iterator();

         while(i$.hasNext()) {
            Object k = i$.next();
            chain.addIterator(MultiValueMap.this.new ValuesIterator(k));
         }

         return chain;
      }

      public int size() {
         return MultiValueMap.this.totalSize();
      }

      public void clear() {
         MultiValueMap.this.clear();
      }

      // $FF: synthetic method
      Values(Object x1) {
         this();
      }
   }
}
