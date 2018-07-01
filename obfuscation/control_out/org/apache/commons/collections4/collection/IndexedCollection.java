package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;

public class IndexedCollection extends AbstractCollectionDecorator {
   private static final long serialVersionUID = -5512610452568370038L;
   private final Transformer keyTransformer;
   private final MultiMap index;
   private final boolean uniqueIndex;

   public static IndexedCollection uniqueIndexedCollection(Collection coll, Transformer keyTransformer) {
      return new IndexedCollection(coll, keyTransformer, MultiValueMap.multiValueMap(new HashMap()), true);
   }

   public static IndexedCollection nonUniqueIndexedCollection(Collection coll, Transformer keyTransformer) {
      return new IndexedCollection(coll, keyTransformer, MultiValueMap.multiValueMap(new HashMap()), false);
   }

   public IndexedCollection(Collection coll, Transformer keyTransformer, MultiMap map, boolean uniqueIndex) {
      super(coll);
      this.keyTransformer = keyTransformer;
      this.index = map;
      this.uniqueIndex = uniqueIndex;
      this.reindex();
   }

   public boolean add(Object object) {
      boolean added = super.add(object);
      if (added) {
         this.addToIndex(object);
      }

      return added;
   }

   public boolean addAll(Collection coll) {
      boolean changed = false;

      Object c;
      for(Iterator i$ = coll.iterator(); i$.hasNext(); changed |= this.add(c)) {
         c = i$.next();
      }

      return changed;
   }

   public void clear() {
      super.clear();
      this.index.clear();
   }

   public boolean contains(Object object) {
      return this.index.containsKey(this.keyTransformer.transform(object));
   }

   public boolean containsAll(Collection coll) {
      Iterator i$ = coll.iterator();

      Object o;
      do {
         if (!i$.hasNext()) {
            return true;
         }

         o = i$.next();
      } while(this.contains(o));

      return false;
   }

   public Object get(Object key) {
      Collection coll = (Collection)this.index.get(key);
      return coll == null ? null : coll.iterator().next();
   }

   public Collection values(Object key) {
      return (Collection)this.index.get(key);
   }

   public void reindex() {
      this.index.clear();
      Iterator i$ = this.decorated().iterator();

      while(i$.hasNext()) {
         Object c = i$.next();
         this.addToIndex(c);
      }

   }

   public boolean remove(Object object) {
      boolean removed = super.remove(object);
      if (removed) {
         this.removeFromIndex(object);
      }

      return removed;
   }

   public boolean removeAll(Collection coll) {
      boolean changed = false;

      Object o;
      for(Iterator i$ = coll.iterator(); i$.hasNext(); changed |= this.remove(o)) {
         o = i$.next();
      }

      return changed;
   }

   public boolean retainAll(Collection coll) {
      boolean changed = super.retainAll(coll);
      if (changed) {
         this.reindex();
      }

      return changed;
   }

   private void addToIndex(Object object) {
      Object key = this.keyTransformer.transform(object);
      if (this.uniqueIndex && this.index.containsKey(key)) {
         throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
      } else {
         this.index.put(key, object);
      }
   }

   private void removeFromIndex(Object object) {
      this.index.remove(this.keyTransformer.transform(object));
   }
}
