package org.apache.commons.collections4.splitmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.IterableGet;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;

public class AbstractIterableGetMapDecorator implements IterableGet {
   transient Map map;

   public AbstractIterableGetMapDecorator(Map map) {
      if (map == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         this.map = map;
      }
   }

   protected AbstractIterableGetMapDecorator() {
   }

   protected Map decorated() {
      return this.map;
   }

   public boolean containsKey(Object key) {
      return this.decorated().containsKey(key);
   }

   public boolean containsValue(Object value) {
      return this.decorated().containsValue(value);
   }

   public Set entrySet() {
      return this.decorated().entrySet();
   }

   public Object get(Object key) {
      return this.decorated().get(key);
   }

   public Object remove(Object key) {
      return this.decorated().remove(key);
   }

   public boolean isEmpty() {
      return this.decorated().isEmpty();
   }

   public Set keySet() {
      return this.decorated().keySet();
   }

   public int size() {
      return this.decorated().size();
   }

   public Collection values() {
      return this.decorated().values();
   }

   public MapIterator mapIterator() {
      return new EntrySetToMapIteratorAdapter(this.entrySet());
   }

   public boolean equals(Object object) {
      return object == this ? true : this.decorated().equals(object);
   }

   public int hashCode() {
      return this.decorated().hashCode();
   }

   public String toString() {
      return this.decorated().toString();
   }
}
