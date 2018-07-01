package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class CaseInsensitiveMap extends AbstractHashedMap implements Serializable, Cloneable {
   private static final long serialVersionUID = -7074655917369299456L;

   public CaseInsensitiveMap() {
      super(16, 0.75F, 12);
   }

   public CaseInsensitiveMap(int initialCapacity) {
      super(initialCapacity);
   }

   public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
      super(initialCapacity, loadFactor);
   }

   public CaseInsensitiveMap(Map map) {
      super(map);
   }

   protected Object convertKey(Object key) {
      if (key == null) {
         return AbstractHashedMap.NULL;
      } else {
         char[] chars = key.toString().toCharArray();

         for(int i = chars.length - 1; i >= 0; --i) {
            chars[i] = Character.toLowerCase(Character.toUpperCase(chars[i]));
         }

         return new String(chars);
      }
   }

   public CaseInsensitiveMap clone() {
      return (CaseInsensitiveMap)super.clone();
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
