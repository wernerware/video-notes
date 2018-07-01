package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

public class CompositeMap extends AbstractIterableMap implements Serializable {
   private static final long serialVersionUID = -6096931280583808322L;
   private Map[] composite;
   private CompositeMap.MapMutator mutator;

   public CompositeMap() {
      this((Map[])(new Map[0]), (CompositeMap.MapMutator)null);
   }

   public CompositeMap(Map one, Map two) {
      this((Map[])(new Map[]{one, two}), (CompositeMap.MapMutator)null);
   }

   public CompositeMap(Map one, Map two, CompositeMap.MapMutator mutator) {
      this(new Map[]{one, two}, mutator);
   }

   public CompositeMap(Map... composite) {
      this((Map[])composite, (CompositeMap.MapMutator)null);
   }

   public CompositeMap(Map[] composite, CompositeMap.MapMutator mutator) {
      this.mutator = mutator;
      this.composite = new Map[0];

      for(int i = composite.length - 1; i >= 0; --i) {
         this.addComposited(composite[i]);
      }

   }

   public void setMutator(CompositeMap.MapMutator mutator) {
      this.mutator = mutator;
   }

   public synchronized void addComposited(Map map) throws IllegalArgumentException {
      for(int i = this.composite.length - 1; i >= 0; --i) {
         Collection intersect = CollectionUtils.intersection(this.composite[i].keySet(), map.keySet());
         if (intersect.size() != 0) {
            if (this.mutator == null) {
               throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
            }

            this.mutator.resolveCollision(this, this.composite[i], map, intersect);
         }
      }

      Map[] temp = new Map[this.composite.length + 1];
      System.arraycopy(this.composite, 0, temp, 0, this.composite.length);
      temp[temp.length - 1] = map;
      this.composite = temp;
   }

   public synchronized Map removeComposited(Map map) {
      int size = this.composite.length;

      for(int i = 0; i < size; ++i) {
         if (this.composite[i].equals(map)) {
            Map[] temp = new Map[size - 1];
            System.arraycopy(this.composite, 0, temp, 0, i);
            System.arraycopy(this.composite, i + 1, temp, i, size - i - 1);
            this.composite = temp;
            return map;
         }
      }

      return null;
   }

   public void clear() {
      for(int i = this.composite.length - 1; i >= 0; --i) {
         this.composite[i].clear();
      }

   }

   public boolean containsKey(Object key) {
      for(int i = this.composite.length - 1; i >= 0; --i) {
         if (this.composite[i].containsKey(key)) {
            return true;
         }
      }

      return false;
   }

   public boolean containsValue(Object value) {
      for(int i = this.composite.length - 1; i >= 0; --i) {
         if (this.composite[i].containsValue(value)) {
            return true;
         }
      }

      return false;
   }

   public Set entrySet() {
      CompositeSet entries = new CompositeSet();

      for(int i = this.composite.length - 1; i >= 0; --i) {
         entries.addComposited(this.composite[i].entrySet());
      }

      return entries;
   }

   public Object get(Object key) {
      for(int i = this.composite.length - 1; i >= 0; --i) {
         if (this.composite[i].containsKey(key)) {
            return this.composite[i].get(key);
         }
      }

      return null;
   }

   public boolean isEmpty() {
      for(int i = this.composite.length - 1; i >= 0; --i) {
         if (!this.composite[i].isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public Set keySet() {
      CompositeSet keys = new CompositeSet();

      for(int i = this.composite.length - 1; i >= 0; --i) {
         keys.addComposited(this.composite[i].keySet());
      }

      return keys;
   }

   public Object put(Object key, Object value) {
      if (this.mutator == null) {
         throw new UnsupportedOperationException("No mutator specified");
      } else {
         return this.mutator.put(this, this.composite, key, value);
      }
   }

   public void putAll(Map map) {
      if (this.mutator == null) {
         throw new UnsupportedOperationException("No mutator specified");
      } else {
         this.mutator.putAll(this, this.composite, map);
      }
   }

   public Object remove(Object key) {
      for(int i = this.composite.length - 1; i >= 0; --i) {
         if (this.composite[i].containsKey(key)) {
            return this.composite[i].remove(key);
         }
      }

      return null;
   }

   public int size() {
      int size = 0;

      for(int i = this.composite.length - 1; i >= 0; --i) {
         size += this.composite[i].size();
      }

      return size;
   }

   public Collection values() {
      CompositeCollection values = new CompositeCollection();

      for(int i = this.composite.length - 1; i >= 0; --i) {
         values.addComposited(this.composite[i].values());
      }

      return values;
   }

   public boolean equals(Object obj) {
      if (obj instanceof Map) {
         Map map = (Map)obj;
         return this.entrySet().equals(map.entrySet());
      } else {
         return false;
      }
   }

   public int hashCode() {
      int code = 0;

      Entry entry;
      for(Iterator i$ = this.entrySet().iterator(); i$.hasNext(); code += entry.hashCode()) {
         entry = (Entry)i$.next();
      }

      return code;
   }

   public interface MapMutator extends Serializable {
      void resolveCollision(CompositeMap var1, Map var2, Map var3, Collection var4);

      Object put(CompositeMap var1, Map[] var2, Object var3, Object var4);

      void putAll(CompositeMap var1, Map[] var2, Map var3);
   }
}
