package org.apache.commons.collections4.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapDecorator extends AbstractIterableMap {
   transient Map map;

   protected AbstractMapDecorator() {
   }

   protected AbstractMapDecorator(Map map) {
      if (map == null) {
         throw new NullPointerException("Map must not be null.");
      } else {
         this.map = map;
      }
   }

   protected Map decorated() {
      return this.map;
   }

   public void clear() {
      this.decorated().clear();
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

   public boolean isEmpty() {
      return this.decorated().isEmpty();
   }

   public Set keySet() {
      return this.decorated().keySet();
   }

   public Object put(Object key, Object value) {
      return this.decorated().put(key, value);
   }

   public void putAll(Map mapToCopy) {
      this.decorated().putAll(mapToCopy);
   }

   public Object remove(Object key) {
      return this.decorated().remove(key);
   }

   public int size() {
      return this.decorated().size();
   }

   public Collection values() {
      return this.decorated().values();
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
