package org.apache.commons.collections4.multimap;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.collections4.SetValuedMap;

public abstract class AbstractSetValuedMap extends AbstractMultiValuedMap implements SetValuedMap {
   protected AbstractSetValuedMap() {
   }

   protected AbstractSetValuedMap(Map map) {
      super(map);
   }

   protected Map getMap() {
      return super.getMap();
   }

   protected abstract Set createCollection();

   public Set get(Object key) {
      return this.wrappedCollection(key);
   }

   Set wrappedCollection(Object key) {
      return new AbstractSetValuedMap.WrappedSet(key);
   }

   public Set remove(Object key) {
      return SetUtils.emptyIfNull((Set)this.getMap().remove(key));
   }

   private class WrappedSet extends AbstractMultiValuedMap.WrappedCollection implements Set {
      public WrappedSet(Object key) {
         super(key);
      }

      public boolean equals(Object other) {
         Set set = (Set)this.getMapping();
         if (set == null) {
            return Collections.emptySet().equals(other);
         } else if (!(other instanceof Set)) {
            return false;
         } else {
            Set otherSet = (Set)other;
            return SetUtils.isEqualSet(set, otherSet);
         }
      }

      public int hashCode() {
         Set set = (Set)this.getMapping();
         return SetUtils.hashCodeForSet(set);
      }
   }
}
