package org.apache.commons.collections4.multimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MultiValuedMap;

public class ArrayListValuedHashMap extends AbstractListValuedMap implements Serializable {
   private static final long serialVersionUID = 20151118L;
   private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
   private static final int DEFAULT_INITIAL_LIST_CAPACITY = 3;
   private final int initialListCapacity;

   public ArrayListValuedHashMap() {
      this(16, 3);
   }

   public ArrayListValuedHashMap(int initialListCapacity) {
      this(16, initialListCapacity);
   }

   public ArrayListValuedHashMap(int initialMapCapacity, int initialListCapacity) {
      super(new HashMap(initialMapCapacity));
      this.initialListCapacity = initialListCapacity;
   }

   public ArrayListValuedHashMap(MultiValuedMap map) {
      this(map.size(), 3);
      super.putAll(map);
   }

   public ArrayListValuedHashMap(Map map) {
      this(map.size(), 3);
      super.putAll(map);
   }

   protected ArrayList createCollection() {
      return new ArrayList(this.initialListCapacity);
   }

   public void trimToSize() {
      Iterator i$ = this.getMap().values().iterator();

      while(i$.hasNext()) {
         Collection coll = (Collection)i$.next();
         ArrayList list = (ArrayList)coll;
         list.trimToSize();
      }

   }

   private void writeObject(ObjectOutputStream oos) throws IOException {
      oos.defaultWriteObject();
      this.doWriteObject(oos);
   }

   private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
      ois.defaultReadObject();
      this.setMap(new HashMap());
      this.doReadObject(ois);
   }
}
