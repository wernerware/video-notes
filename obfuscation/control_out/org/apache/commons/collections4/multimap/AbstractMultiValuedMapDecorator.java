package org.apache.commons.collections4.multimap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;

public abstract class AbstractMultiValuedMapDecorator implements MultiValuedMap, Serializable {
   private static final long serialVersionUID = 20150612L;
   private final MultiValuedMap map;

   protected AbstractMultiValuedMapDecorator(MultiValuedMap map) {
      if (map == null) {
         throw new NullPointerException("MultiValuedMap must not be null.");
      } else {
         this.map = map;
      }
   }

   protected MultiValuedMap decorated() {
      return this.map;
   }

   public int size() {
      return this.decorated().size();
   }

   public boolean isEmpty() {
      return this.decorated().isEmpty();
   }

   public boolean containsKey(Object key) {
      return this.decorated().containsKey(key);
   }

   public boolean containsValue(Object value) {
      return this.decorated().containsValue(value);
   }

   public boolean containsMapping(Object key, Object value) {
      return this.decorated().containsMapping(key, value);
   }

   public Collection get(Object key) {
      return this.decorated().get(key);
   }

   public Collection remove(Object key) {
      return this.decorated().remove(key);
   }

   public boolean removeMapping(Object key, Object item) {
      return this.decorated().removeMapping(key, item);
   }

   public void clear() {
      this.decorated().clear();
   }

   public boolean put(Object key, Object value) {
      return this.decorated().put(key, value);
   }

   public Set keySet() {
      return this.decorated().keySet();
   }

   public Collection entries() {
      return this.decorated().entries();
   }

   public MultiSet keys() {
      return this.decorated().keys();
   }

   public Collection values() {
      return this.decorated().values();
   }

   public Map asMap() {
      return this.decorated().asMap();
   }

   public boolean putAll(Object key, Iterable values) {
      return this.decorated().putAll(key, values);
   }

   public boolean putAll(Map map) {
      return this.decorated().putAll(map);
   }

   public boolean putAll(MultiValuedMap map) {
      return this.decorated().putAll(map);
   }

   public MapIterator mapIterator() {
      return this.decorated().mapIterator();
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
