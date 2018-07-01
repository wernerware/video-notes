package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class HashedMap extends AbstractHashedMap implements Serializable, Cloneable {
   private static final long serialVersionUID = -1788199231038721040L;

   public HashedMap() {
      super(16, 0.75F, 12);
   }

   public HashedMap(int initialCapacity) {
      super(initialCapacity);
   }

   public HashedMap(int initialCapacity, float loadFactor) {
      super(initialCapacity, loadFactor);
   }

   public HashedMap(Map map) {
      super(map);
   }

   public HashedMap clone() {
      return (HashedMap)super.clone();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      this.doWriteObject(out);
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.doReadObject(in);
   }
}
